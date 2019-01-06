package com.example.daplu.practice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PhomeProfileList extends Fragment {

    private Button btn;
    private View view;

    private ListView listView;
    private ListAdapter listAdapter;

    public String[][] data = {
            {"居住地", "高雄市"},
            {"星座", "獅子座"},
            {"性別", "男"}, {"生日", "1997/08/16"},  {"興趣", "旅行、看書、攝影"} , {"自我介紹", "我想一根手指，遨遊全世界"}
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //個人小屋個人資料
        View view = View.inflate(getActivity(), R.layout.phome_profile_fragment, null);
        ListView listView = (ListView) view.findViewById(R.id.listView);

        //以LISTVIEW表頭包旅行者屬性(圖像式)
        View header_view = getLayoutInflater().inflate(R.layout.phome_profile_header, null);

        listView.addHeaderView(header_view);

        //將資料轉換成<key,value>的型態
        List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        for (int i=0;i < data.length;i++){
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("subtitle", data[i][0]);
            item.put("info", data[i][1]);
            items.add(item);
        }

        //帶入對應資料
        SimpleAdapter adapter = new SimpleAdapter(
                getActivity(),
                items,
                R.layout.phome_profile_list_layout,
                new String[]{"subtitle", "info"},
                new int[]{R.id.profile_subtitle, R.id.profile_info}
        );


        listView.setAdapter(adapter);
        return view;
    }

}