package com.zhuke.zdy1.recycleview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import com.zhuke.zdy1.R;
import com.zhuke.zdy1.adapter.MyRecycleAdapter;
import com.zhuke.zdy1.recycleview.call.MyItemTouchHelperCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15653 on 2018/5/2.
 */

public class RecycleviewActivity extends AppCompatActivity implements MyRecycleAdapter.ItemOnClickListener {

    private RecyclerView mRecyclerView;
    private List<String> mStrings = new ArrayList<>();
    private ItemTouchHelper itemTouchHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleview);
        initRecycleview();
    }

    private void initRecycleview() {
        getData();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyRecycleAdapter adapter = new MyRecycleAdapter(this, mStrings);
        mRecyclerView.setAdapter(adapter);
        adapter.addItemOnClickListener(this);
        ItemTouchHelper.Callback callback = new MyItemTouchHelperCallback(adapter);
        itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);

    }

    private void getData() {
        for (int i = 0; i < 20; i++) {
            mStrings.add("我是数据"+ i);
        }
    }

    @Override
    public void addItemOnClickListener(int position) {
        Toast.makeText(this,position+"",Toast.LENGTH_SHORT).show();
    }
}
