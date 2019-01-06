package com.example.daplu.practice;

import android.view.View;
import android.widget.Button;


public class PostIndexFragment extends BaseFragment {

    private Button btn;
    private View view;
    @Override
    public View initView(){
        if (view == null) {
            view = View.inflate(mPost, R.layout.post_post_fragment, null);
            btn = (Button) view.findViewById(R.id.btn_journal);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mPost.switchFragment("postFragment", "journalFragment");
                }
            });
        }
        return view;
    }
}

