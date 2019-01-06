package com.example.daplu.practice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainPost extends AppCompatActivity {


    FragmentManager fm;
    FragmentTransaction ft;
    Fragment mCurrentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_index);
        fm = getSupportFragmentManager();
        ft = ((FragmentManager) fm).beginTransaction();

        PostIndexFragment postFragment = new PostIndexFragment();
        JournalIndexFragment journalIndexFragment = new JournalIndexFragment();

        ft.add(R.id.content_layout, postFragment, "postFragment")
                .add(R.id.content_layout, journalIndexFragment, "journalFragment")
                .hide(journalIndexFragment).commit();
    }


//     防止Fragement数据重复加载，采用显示和隐藏的方式

    public void switchFragment(String fromTag, String toTag) {
        Fragment from = fm.findFragmentByTag(fromTag);
        Fragment to = fm.findFragmentByTag(toTag);
        if (mCurrentFragment != to) {
            mCurrentFragment = to;
            FragmentTransaction transaction = fm.beginTransaction();
            if (!to.isAdded()) {//判断是否被添加到了Activity里面去了
                transaction.hide(from).add(R.id.content_layout, to).commit();
            } else {
                transaction.hide(from).show(to).commit();
            }
        }

    }
}
