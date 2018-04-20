package com.zhuke.zdy1.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.zhuke.zdy1.R;
import com.zhuke.zdy1.textview.TextViewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15653 on 2018/2/26.
 */

public class MyAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private ArrayList<String> mStrings;

    public MyAdapter(Context context, ArrayList<String> strings) {
        this.mContext = context;
        this.mStrings = strings;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        public MyHolder(View itemView) {
            super(itemView);
        }
    }
}
