package com.app.zhl.demo.Home;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.zhl.demo.R;
import com.app.zhl.demo.Tools.Instance;
import com.bacy.view.titlebar.TitleBar;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button pushBtn;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container,
                false);
        initNavbar(view);
        initSubview(view);
        return view;
    }


    private void initNavbar(View view) {
        final TitleBar titleBar = (TitleBar) view.findViewById(R.id.title_bar_home);
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

    private void initSubview(View view) {
        pushBtn = (Button) view.findViewById(R.id.pushBtn);
        pushBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.pushBtn) {
            Intent intent = new Intent();
            intent.setClass(this.getActivity(),ListActivity.class);
             startActivity(intent);
        }

    }
}
