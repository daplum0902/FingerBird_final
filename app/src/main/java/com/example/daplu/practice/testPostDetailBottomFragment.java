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

public class testPostDetailBottomFragment extends Fragment {
    private Button btn;
    private View view;
    private ListView listView;
    private ListAdapter listAdapter;

    public String[][] data = {
            {"天天", "請問只會講英文，法文不流利可以嗎?"},
            {"惇惇", "請問我會開車，我可以當司機，這樣會比較方便，不知道你有一定要搭uber嗎?"},
            {"長長", "請問你寫的價錢有包含來回機票嗎?"},
            {"俊俊", "拜託選我，我都符合!!"}
    };

    int[] journal_img = new int[]{
            R.drawable.demo_user_g, R.drawable.demo_user_b,
            R.drawable.demo_user_b, R.drawable.demo_user_g, R.drawable.demo_user_g
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view = View.inflate(getActivity(), R.layout.test_post_detail_down, null);
        ListView listView = (ListView) view.findViewById(R.id.message_list);

        View footer_view = getLayoutInflater().inflate(R.layout.post_detail_footer_view, null);

        listView.addFooterView(footer_view);


        //將資料轉換成<key,value>的型態
        List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        for (int i=0;i < data.length;i++){
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("ms_name", data[i][0]);
            item.put("ms_content", data[i][1]);
            item.put("profile", Integer.toString(journal_img[i]));
            items.add(item);
        }

        // Keys used in Hashmap
        String[] from = {"ms_name", "ms_content", "profile" };

        // Ids of views in listview_layout
        int[] to = { R.id.ms_name, R.id.ms_content, R.id.profile};

        SimpleAdapter adapter = new SimpleAdapter(getActivity(), items, R.layout.message_list_layout, from, to);

        listView.setAdapter(adapter);
        return view;

    }
}
