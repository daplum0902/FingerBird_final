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

public class testJournalFragment extends Fragment {

    private Button btn;
    private View view;

    private ListView listView;
    private ListAdapter listAdapter;

    public String[][] data = {
            {"肥龍", "法國浪漫遊","台灣/台北"},
            {"阿毛,", "極光動感之旅","台灣/高雄"},
            {"阿玫", "十字軍東征歷程","台灣/台南"},
            {"帥哥", "支那蘇州之旅","台灣/屏東"},
            {"阿長", "打狗之旅","台灣/台中"}
    };

    int[][] journal_img = new int[][]{
            {R.drawable.demo_post_pic8, R.drawable.demo_user_g}, {R.drawable.demo_post_pic7, R.drawable.demo_user_b},
            {R.drawable.demo_post_pic6, R.drawable.demo_user_b}, {R.drawable.demo_post_pic4, R.drawable.demo_user_g},
            {R.drawable.demo_post_pic5, R.drawable.demo_user_g},
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.test_journal_fragment, null);
        ListView listView = (ListView) view.findViewById(R.id.post_j_list);



        //將資料轉換成<key,value>的型態
        List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        for (int i=0;i < data.length;i++){
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("poster_name", data[i][0]);
            item.put("journal_title", data[i][1]);
            item.put("journal_place", data[i][2]);
            item.put("post_cover", Integer.toString(journal_img[i][0]));
            item.put("profile", Integer.toString(journal_img[i][1]));
            items.add(item);
        }

        // Keys used in Hashmap
        String[] from = {"poster_name", "journal_title", "journal_place", "post_cover", "profile" };

        // Ids of views in listview_layout
        int[] to = { R.id.poster_name, R.id.journal_title, R.id.journal_place, R.id.post_cover, R.id.profile};

        SimpleAdapter adapter = new SimpleAdapter(getActivity(), items, R.layout.test_journal_list_style, from, to);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), testJournalDetail.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
