package com.app.zhl.demo.Main;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.app.zhl.demo.R;
import com.app.zhl.demo.Tools.Instance;
import com.bacy.view.titlebar.TitleBar;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        initNavbar();
    }

    public void initNavbar() {
        final TitleBar titleBar = (TitleBar) this.findViewById(R.id.title_bar_home);
        titleBar.setImmersive(Instance.isImmersive);
        titleBar.setBackgroundColor(Color.parseColor("#64b4ff"));
        titleBar.setLeftImageResource(R.mipmap.logo);
//        titleBar.setLeftText("返回");
//        titleBar.setLeftTextColor(Color.WHITE);
//        titleBar.setLeftClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), "点击了返回", Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}
