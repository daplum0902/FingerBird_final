package com.example.daplu.practice;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PhomeProfileListAdapter extends RecyclerView.Adapter<PhomeProfileListAdapter.ViewHolder>{

    private List myAdapter;

    public PhomeProfileListAdapter(List Adapter){
        //這邊是接 MainActivity 傳進來的值
        myAdapter = Adapter;
    }

    @Override
    public PhomeProfileListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.phome_items_layout, null);
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.phome_profile_list_layout, null);
        return new PhomeProfileListAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PhomeProfileListAdapter.ViewHolder holder, int position) {
        // 設定 textView 的文字由 itemsData 取出，而 itemsData 的內容已經在 ItemData.java 設定好了
//        holder.bindData(ItemData.get(position));
        holder.bindData((ItemData) myAdapter.get(position));
    }

    @Override
    public int getItemCount() {
        // 顯示的數量
        return myAdapter.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView_subtitle;
        public TextView textView_info;

        public ViewHolder(View itemView) {
            super(itemView);
            // 設定 textView 為 item_title 這個 layout 物件

            textView_subtitle = (TextView) itemView.findViewById(R.id.profile_subtitle);
            textView_info = (TextView) itemView.findViewById(R.id.profile_info);
        }
        public void bindData(ItemData itemData){

            textView_subtitle.setText(""+itemData.subtitle);
            textView_info.setText(""+itemData.info);
        }

    }
}