package com.example.daplu.practice;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class testMainPost extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // The request code must be 0 or greater.
    private static final int PLUS_ONE_REQUEST_CODE = 0;
    // The URL to +1.  Must be a valid URL.
    private final String PLUS_ONE_URL = "http://developer.android.com";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public testMainPost(){

    }


    public static testMainPost newInstance(String param1, String param2) {
        testMainPost fragment = new testMainPost();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private Button btn_post;
    private Button btn_journal;
    private com.example.daplu.practice.testPostFragment testPostFragment;
    private com.example.daplu.practice.testJournalFragment testJournalFragment;
    FragmentManager fm;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //徵伴貼文
        View view = inflater.inflate(R.layout.test_post_index, container, false);

        btn_journal = view.findViewById(R.id.btn_journal);
        btn_post = view.findViewById(R.id.btn_post);
        fm = getFragmentManager();


        Log.d("hi","working");

        setTabSelection(1);

        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("我","要徵伴");
                setTabSelection(1);
                btn_journal.setBackground(getResources().getDrawable(R.drawable.post_unbutton_style));
                btn_post.setBackground(getResources().getDrawable(R.drawable.post_button_style));

                btn_journal.setTextColor(getResources().getColor(R.color.gray));
                btn_post.setTextColor(getResources().getColor(R.color.white));
            }
        });
        btn_journal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("我","要發遊記");
                setTabSelection(0);
                btn_journal.setBackground(getResources().getDrawable(R.drawable.post_button_style));
                btn_post.setBackground(getResources().getDrawable(R.drawable.post_unbutton_style));

                btn_journal.setTextColor(getResources().getColor(R.color.white));
                btn_post.setTextColor(getResources().getColor(R.color.gray));

            }
        });



        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void setTabSelection(int index){

        FragmentTransaction ft = fm.beginTransaction();
        hideFragment(ft);
        switch (index) {
            case 0:
                if(testPostFragment==null){
                    testPostFragment = new testPostFragment();
                    ft.add(R.id.post_mainview, testPostFragment);

                    Log.d("now",ft.toString());
                }else{
                    ft.show(testPostFragment);
                    Log.d("now",ft.toString());
                }
                break;

            case 1:
                if(testJournalFragment==null){
                    testJournalFragment = new testJournalFragment();
                    ft.add(R.id.post_mainview, testJournalFragment);
                    Log.d("now",ft.toString());
                }else {
                    ft.show(testJournalFragment);
                    Log.d("now", ft.toString());
                }
                break;
        }
        ft.commit();
    }
    //用于隐藏fragment
    private void hideFragment(FragmentTransaction ft) {
        if (testJournalFragment != null) {
            ft.hide(testJournalFragment);
        }else if (testPostFragment != null) {
            ft.hide(testPostFragment);
        }
    }

}
