package com.zhuke.zdy1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhuke.zdy1.R;
import com.zhuke.zdy1.recycleview.ItemTouchMoveListener;
import com.zhuke.zdy1.recycleview.RecycleviewActivity;

import java.util.Collections;
import java.util.List;

/**
 * Created by 15653 on 2018/5/2.
 */

public class MyRecycleAdapter extends RecyclerView.Adapter implements ItemTouchMoveListener{
    private Context mContext;
    private List<String> mStrings;
    public MyRecycleAdapter(Context context, List<String> strings) {
        this.mContext =context;
        this.mStrings = strings;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.recycle_item, parent, false);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyHolder holder1 = (MyHolder) holder;
        holder1.mTextView.setText(mStrings.get(position));
        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemOnClickListener != null){
                    mItemOnClickListener.addItemOnClickListener(position);
                }
            }
        });
    }
   private ItemOnClickListener mItemOnClickListener;
   public void  addItemOnClickListener(ItemOnClickListener itemOnClickListener){
       this.mItemOnClickListener= itemOnClickListener;
   }
    public interface ItemOnClickListener {
        void addItemOnClickListener(int position);
    }

    @Override
    public int getItemCount() {
        return mStrings == null? 0 :mStrings.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        //1.数据交换 2.刷新
        Collections.swap(mStrings, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public boolean onItemRemove(int position) {
        mStrings.remove(position);
        notifyItemRemoved(position);
        return true;
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private final TextView mTextView;

        public MyHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text_view);
        }
    }
}
