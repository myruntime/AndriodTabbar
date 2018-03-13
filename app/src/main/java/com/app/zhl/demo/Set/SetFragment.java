package com.app.zhl.demo.Set;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.zhl.demo.R;
import com.app.zhl.demo.Tools.Instance;
import com.bacy.view.titlebar.TitleBar;

/**
 * A simple {@link Fragment} subclass.
 */
public class SetFragment extends Fragment {


    public SetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set, container,
                false);
        initNavbar(view);
        return view;
    }

    private void initNavbar(View view) {
        final TitleBar titleBar = (TitleBar) view.findViewById(R.id.title_bar_set);
        titleBar.setImmersive(Instance.isImmersive);
        titleBar.setBackgroundColor(Color.parseColor("#64b4ff"));
        titleBar.setTitle("设置");
        titleBar.setTitleColor(Color.WHITE);
    }

}
