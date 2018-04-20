package com.zhuke.zdy1.textview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.zhuke.zdy1.R;
import com.zhuke.zdy1.adapter.MyAdapter;
import com.zhuke.zdy1.dialog.CustomDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15653 on 2018/2/26.
 */

public class TextViewActivity extends AppCompatActivity {
    private boolean isOpen = false;
    private ArrayList<String> mStrings;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);
        final TextView viewById = (TextView) findViewById(R.id.text_view);
        RecyclerView listview = (RecyclerView) findViewById(R.id.rv);
        listview.setLayoutManager(new LinearLayoutManager(this));
        listview.setAdapter(new MyAdapter(this,mStrings));
        getData();
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen){
                    isOpen =false;
                    viewById.setMaxLines(3);
                }else {
                    isOpen =true;
                    viewById.setMaxLines(Integer.MAX_VALUE);
                }
            }
        });

        CustomDialog build = new CustomDialog.Builder(this).cancelTouchout(false)
                .build();
    }

    private void getData() {
        mStrings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mStrings.add("asasa22sasaaaaaaaaaaaaaaaw4w1313a1s31a654w6a5w3a21s31a34a4s6a4s6a1s3a1s31a3s16a4s6as3as13a21sa46s4a6s1a3123");
        }
    }
}
