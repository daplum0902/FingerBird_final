package com.example.daplu.practice;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class testPostDetailUpFragment extends Fragment {
    private TextView name;
    private Button ToSchedule,travelend;
    private ImageButton profile;
//    private SharedPreferences prf;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //徵伴貼文內文
        View view = inflater.inflate(R.layout.test_post_detail_up, container, false);
//        name = view.findViewById(R.id.name);
//        prf = getActivity().getSharedPreferences("user_details",Context.MODE_PRIVATE);
//        if(prf.getString("name",null)!=null) {
//            name.setText(prf.getString("name", null));
//        }else{
//            name.setText(prf.getString("email", null));
//        }

        ToSchedule = view.findViewById(R.id.Schedule1);
        profile = view.findViewById(R.id.add);
        travelend = view.findViewById(R.id.travelend);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())


                        .setIcon(R.drawable.ic_travel)
                        .setTitle("確定要加入旅行嗎?")
//                                        .setMessage("確定要加入旅行嗎?")
                        .setPositiveButton("加入", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                new AlertDialog.Builder(getActivity())
                                        .setIcon(R.drawable.ic_check)
                                        .setTitle("申請成功")
                                        .setMessage("請等待審核")

//                                        .setMessage("確定要加入旅行嗎?")
                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {


                                            }
                                        })
                                        .show();

                            }
                        }).setNegativeButton("取消",null).create()
                        .show();
            }
        });

        travelend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setIcon(R.drawable.ic_travelend)
                        .setTitle("旅遊結束囉！")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {


                            }
                        })
                        .show();
            }
        });
        ToSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),schedulelist.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
