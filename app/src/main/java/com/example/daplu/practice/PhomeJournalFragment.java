package com.example.daplu.practice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PhomeJournalFragment extends Fragment {

    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //個人小屋遊記
        View view = View.inflate(getActivity(), R.layout.aaa_phome_journal, null);

        return  view;
    }

}
