package com.example.daplu.practice;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatRoomIndex extends Fragment {
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

    public ChatRoomIndex(){

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
        private View view;

        private ListView listView;
        private ListAdapter listAdapter;

        public String[][] data = {
                {"法國高空體驗之旅la ", "11/04"},
                {"熱情高雄一起熱", "11/03"},
                {"冰島-極光之旅", "11/02"},
                {"中國知性之旅", "10/30"}
        };

    int[] post_img = new int[]{
            R.drawable.demo_post_pic1, R.drawable.demo_post_pic2, R.drawable.demo_post_pic3, R.drawable.demo_post_pic4, R.drawable.demo_post_pic5
    };

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.chatroom_index, container,false);

            //將資料轉換成<key,value>的型態
            List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
            for (int i=0;i < data.length;i++){
                Map<String, Object> item = new HashMap<String, Object>();
                item.put("title", data[i][0]);
                item.put("date", data[i][1]);
                item.put("profile_photo", Integer.toString(post_img[i]));
                items.add(item);
            }

            // Keys used in Hashmap
            String[] from = {"title", "date", "profile_photo" };

            // Ids of views in listview_layout
            int[] to = { R.id.title, R.id.date, R.id.profile_photo};

            SimpleAdapter adapter = new SimpleAdapter(getActivity(), items, R.layout.chatroom_index_style, from, to);
            //帶入對應資料
            ListView listView = (ListView) view.findViewById(R.id.chatroom_list);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getActivity(), Mainchat.class);
                    startActivity(intent);
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

}
