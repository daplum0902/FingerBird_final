package com.example.daplu.practice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class TitleFragment extends Fragment {

    private ImageButton btn_notice;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.title_fragment, container, false);
//        btn_notice = (ImageButton)view.findViewById(R.id.btn_notice);
//        btn_notice.setOnClickListener(new OnClickListener()
//        {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(),"booooooooooooooooooom",Toast.LENGTH_SHORT).show();
//            }
//        });
        return view;
    }
}
