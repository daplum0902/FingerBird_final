package com.example.daplu.practice;

import android.content.Context;
import android.content.SharedPreferences;
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
import android.widget.FrameLayout;
import android.widget.TextView;


public class MainPhome extends Fragment{
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

    public MainPhome(){

    }

    public static MainPhome newInstance(String param1, String param2) {
        MainPhome fragment = new MainPhome();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private Button btn;
    private Button btn2;
    private Button btn3;
    private TextView name;
    private SharedPreferences prf;
    private PhomeProfileList phomeProfileList;
    private PhomeAlbumFragment phomeAlbumFragment;
    private PhomeJournalFragment phomeJournalFragment;
    FragmentManager fm;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.phome_index, container, false);

        name = view.findViewById(R.id.name);
        prf = getActivity().getSharedPreferences("user_details",Context.MODE_PRIVATE);

//        setContentView(R.layout.phome_index);

        btn = (Button) view.findViewById(R.id.button);
        btn2 = (Button) view.findViewById(R.id.button2);
        btn3 = (Button) view.findViewById(R.id.button3);
        FrameLayout fl = view.findViewById(R.id.fl);

        if(prf.getString("name",null)!=null) {
            name.setText(prf.getString("name", null));
        }else{
            name.setText(prf.getString("email", null));
        }

        fm = getFragmentManager();
//        fm = getSupportFragmentManager();
        Log.d("測試","111");

        setTabSelection(0);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("編號0","被點了");
                setTabSelection(0);
                btn.setBackground(getResources().getDrawable(R.drawable.phome_button_style));
                btn2.setBackground(getResources().getDrawable(R.drawable.phome_unbutton_style));
                btn3.setBackground(getResources().getDrawable(R.drawable.phome_unbutton_style));

                btn.setTextColor(getResources().getColor(R.color.white));
                btn2.setTextColor(getResources().getColor(R.color.gray));
                btn3.setTextColor(getResources().getColor(R.color.gray));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("編號1","被點了");
                setTabSelection(1);
                btn2.setBackground(getResources().getDrawable(R.drawable.phome_button_style));
                btn.setBackground(getResources().getDrawable(R.drawable.phome_unbutton_style));
                btn3.setBackground(getResources().getDrawable(R.drawable.phome_unbutton_style));

                btn2.setTextColor(getResources().getColor(R.color.white));
                btn.setTextColor(getResources().getColor(R.color.gray));
                btn3.setTextColor(getResources().getColor(R.color.gray));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("編號2","被點了");
                setTabSelection(2);
                btn3.setBackground(getResources().getDrawable(R.drawable.phome_button_style));
                btn2.setBackground(getResources().getDrawable(R.drawable.phome_unbutton_style));
                btn.setBackground(getResources().getDrawable(R.drawable.phome_unbutton_style));

                btn3.setTextColor(getResources().getColor(R.color.white));
                btn2.setTextColor(getResources().getColor(R.color.gray));
                btn.setTextColor(getResources().getColor(R.color.gray));
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
                if(phomeProfileList==null){
                    phomeProfileList = new PhomeProfileList();
                    ft.add(R.id.fl, phomeProfileList);
                }else{
                    ft.show(phomeProfileList);
                }

                break;

            case 1:
                if(phomeAlbumFragment==null){
                    phomeAlbumFragment = new PhomeAlbumFragment();
                    ft.add(R.id.fl, phomeAlbumFragment);
                }
                ft.show(phomeAlbumFragment);
                break;

            case 2:
                if(phomeJournalFragment==null){
                    phomeJournalFragment = new PhomeJournalFragment();
                    ft.add(R.id.fl, phomeJournalFragment);
                }
                ft.show(phomeJournalFragment);
                break;
        }
        ft.commit();
    }
    //用于隐藏fragment
    private void hideFragment(FragmentTransaction ft) {
        if (phomeProfileList != null) {
            ft.hide(phomeProfileList);
            if (phomeJournalFragment != null) {
                ft.hide(phomeJournalFragment);
            }
        }if (phomeAlbumFragment != null) {
            ft.hide(phomeAlbumFragment);
            if (phomeProfileList != null) {
                ft.hide(phomeProfileList);
            }
        }
        if (phomeJournalFragment != null){
            ft.hide(phomeJournalFragment);
            if (phomeAlbumFragment != null) {
                ft.hide(phomeAlbumFragment);
            }
        }

    }
}