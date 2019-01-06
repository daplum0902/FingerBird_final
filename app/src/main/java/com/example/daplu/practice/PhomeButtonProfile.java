package com.example.daplu.practice;

import android.view.View;
import android.widget.Button;

public class PhomeButtonProfile extends BaseFragment{

    private Button btn;
    private View view;
    @Override
    public View initView(){
        if (view == null) {
            view = View.inflate(mPost, R.layout.phome_profile_fragment, null);
            btn = (Button) view.findViewById(R.id.button);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //*************有問題*****************
                    mPost.switchFragment("phome_profile_fragment", "aaa_phome_album");
                }
            });
        }
        return view;
    }
}
