package com.app.zhl.demo.Main;


import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.app.zhl.demo.Game.GameFragment;
import com.app.zhl.demo.Home.HomeFragment;
import com.app.zhl.demo.R;
import com.app.zhl.demo.Set.SetFragment;
import com.app.zhl.demo.Tools.Instance;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    private FragmentManager fragmentManager;
    private Fragment seletedFragment;
    private View seletedView;
    private FrameLayout frameLayout;
    private LinearLayout linearLayout;
    private List<View> views;

    private Fragment fragments[] = {new HomeFragment(),new GameFragment(),new SetFragment()};
    private String mTitles[] = {"首页","游戏","设置"};
    private int mImages[] = {
            R.drawable.tab_home_normal,
            R.drawable.tab_game_normal,
            R.drawable.tab_set_normal
    };
    private int selectedImages[] = {
            R.drawable.tab_home_select,
            R.drawable.tab_game_select,
            R.drawable.tab_set_select
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSubViews();
        setSelectedItem(0);

        if (hasKitKat() && !hasLollipop()) {

            Instance.isImmersive = true;
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else if (hasLollipop()) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            Instance.isImmersive = true;
        }

    }


    public void initSubViews() {

        views = new ArrayList<View>();
        views.add(getTabbarItem(0));
        views.add(getTabbarItem(1));
        views.add(getTabbarItem(2));

        frameLayout = (FrameLayout) findViewById(R.id.content);
        linearLayout = (LinearLayout) findViewById(R.id.tabbar);

        linearLayout.addView(views.get(0));
        linearLayout.addView(views.get(1));
        linearLayout.addView(views.get(2));

        fragmentManager = getSupportFragmentManager();

    }

    @Override
    public void onClick(View view) {
        setSelectedItem(view.getId());
    }


    private View getTabbarItem(int index) {

        View view = LayoutInflater.from(this).inflate(R.layout.tabbar_item,null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        Display display = getWindowManager().getDefaultDisplay();
        layoutParams.width = display.getWidth()/3;
        view.setLayoutParams(layoutParams);

        view.setOnClickListener(this);
        view.setId(index);
        ImageView imageView = (ImageView) view.findViewById(R.id.tab_img);
        TextView textView = (TextView) view.findViewById(R.id.tab_text);
        imageView.setImageResource(mImages[index]);
        textView.setText(mTitles[index]);
        return view;
    }





    private void setSelectedItem(int index) {

        View view = views.get(index);
        if (view == seletedView) return;
        if (seletedView != null) {
            int k = views.indexOf(seletedView);
            resetTabbarItem(seletedView,k);
        }
        seletedView = view;
        setSelectedTabbarItem(seletedView,index);
    }

    private void resetTabbarItem(View view,int index) {
        ImageView imageView = (ImageView) view.findViewById(R.id.tab_img);
        TextView textView = (TextView) view.findViewById(R.id.tab_text);
        imageView.setImageResource(mImages[index]);
        textView.setTextColor(getResources().getColor(R.color.tab_nor_color));
    }

    private void setSelectedTabbarItem(View view,int index) {
        ImageView imageView = (ImageView) view.findViewById(R.id.tab_img);
        TextView textView = (TextView) view.findViewById(R.id.tab_text);
        imageView.setImageResource(selectedImages[index]);
        textView.setTextColor(getResources().getColor(R.color.tab_sel_color));

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fm = fragments[index];
        if (seletedFragment != null) {
            transaction.hide(seletedFragment);
        }
        seletedFragment = fm;
        if (fm.isAdded()) {
            transaction.show(fm);
        }else  {
            transaction.add(R.id.content,fm);
        }
        transaction.commit();
    }

    public static boolean hasKitKat() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }

    public static boolean hasLollipop() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }




}



