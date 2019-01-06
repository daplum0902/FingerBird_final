package com.example.daplu.practice;

import android.content.Intent;
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

public class testPostFragment extends Fragment {

    private Button btn;
    private View view;

    private ListView listView;
    private ListAdapter listAdapter;


    public String[][] data = {
            {"法國誰要跟我一起浪漫一波", "法國/巴黎", "11/10"},
            {"一起打狗高雄走一波", "台灣/高雄", "11/12"},
            {"跟著十字軍一起東征", "義大利/羅馬", "11/13"},
            {"支那蘇州古都", "中國/蘇州", "11/15"},
            {"來見極光遇到愛", "冰島/北部", "12/01"}
    };

//    int[] post_img = new int[]{
//        R.drawable.demo_post_pic1, R.drawable.demo_post_pic2, R.drawable.demo_post_pic3, R.drawable.demo_post_pic4, R.drawable.demo_post_pic5
//    };

    int[][] post_img = new int[][]{
            {R.drawable.demo_post_pic1, R.drawable.demo_user_g}, {R.drawable.demo_post_pic2, R.drawable.demo_user_b},
            {R.drawable.demo_post_pic3, R.drawable.demo_user_b}, {R.drawable.demo_post_pic4, R.drawable.demo_user_g},
            {R.drawable.demo_post_pic5, R.drawable.demo_user_g},
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.test_post_fragment, null);

        //將資料轉換成<key,value>的型態
        List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        for (int i=0;i < 5;i++){
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("title", data[i][0]);
            item.put("place", data[i][1]);
            item.put("date", data[i][2]);
            item.put("goDetail", Integer.toString(post_img[i][0]));
            item.put("profile", Integer.toString(post_img[i][1]));
            items.add(item);
        }

        // Keys used in Hashmap
        String[] from = {"title", "place", "date", "goDetail", "profile" };

        // Ids of views in listview_layout
        int[] to = { R.id.title, R.id.place, R.id.date, R.id.goDetail, R.id.profile};


        SimpleAdapter adapter = new SimpleAdapter(getActivity(), items, R.layout.test_post_list_style, from, to);

//        //帶入對應資料
//        SimpleAdapter adapter = new SimpleAdapter(
//                getActivity(),
//                items,
//                R.layout.test_post_list_style,
//                new String[]{"title", "place", "date"},
//                new int[]{R.id.title, R.id.place, R.id.date}
//
//
//        );
//
        ListView listView = (ListView) view.findViewById(R.id.post2_list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), PostDetail.class);
                startActivity(intent);
            }
        });
        return view;
    }


}
