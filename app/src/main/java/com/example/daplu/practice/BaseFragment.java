package com.example.daplu.practice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
    //上下文
    public MainPost mPost;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mPost = (MainPost) getActivity();
        View view = initView();
        return view;
    }


//     主界面的抽象方法初始化view

    public abstract View initView();

}

