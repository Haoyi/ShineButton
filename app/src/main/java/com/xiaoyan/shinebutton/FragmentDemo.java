package com.xiaoyan.shinebutton;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.xiaoyan.shinebutton_core.ShineButton;

/**
 * @author Chad
 * @title com.xiaoyan.shinebutton
 * @description
 * @modifier
 * @date
 * @since 17/3/17 上午11:23
 **/
public class FragmentDemo extends Fragment {
    View rootView;
    FragmentManager fragmentManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.common_fragment, null);
        return rootView;
    }

    @Override
    public void onResume() {
        initData();
        super.onResume();
    }

    private void initData() {
        ShineButton shineButton1 = (ShineButton) rootView.findViewById(R.id.po_image1);
        shineButton1.init((MainActivity) getActivity(),true);

        ShineButton shineButton2 = (ShineButton) rootView.findViewById(R.id.po_image2);
        ShineButton shineButton3 = (ShineButton) rootView.findViewById(R.id.po_image3);
        final Button hideBtn = (Button) rootView.findViewById(R.id.hide_button);
        hideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideFragment();
            }
        });
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideFragment();
            }
        });
    }

    public void showFragment(final FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(
                R.anim.fragmentv_slide_bottom_enter,
                0,
                0,
                R.anim.fragmentv_slide_top_exit);
        transaction.add(Window.ID_ANDROID_CONTENT, FragmentDemo.this, "FragmentDemo");
        transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }

    public void hideFragment() {
        fragmentManager.popBackStack();
    }
}
