package com.example.daplu.practice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class PostDetail extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_post_detail);
    }

    public void BackPost(View view){
        startActivity(new Intent(PostDetail.this,MainActivity.class));
    }
}
