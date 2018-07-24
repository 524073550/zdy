package com.zhuke.zdy1.recycleview.call;

import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.zhuke.zdy1.R;
import com.zhuke.zdy1.recycleview.ItemTouchMoveListener;

/**
 * Created by 15653 on 2018/5/2.
 */

public class MyItemTouchHelperCallback extends ItemTouchHelper.Callback {

    private ItemTouchMoveListener moveListener;

    public MyItemTouchHelperCallback(ItemTouchMoveListener moveListener) {
        this.moveListener = moveListener;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //我要监听的拖拽方向是哪个方向
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        //我要监听的swipe侧滑方向是哪个方向
        int swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;


        int flags = makeMovementFlags(dragFlags, swipeFlags);
        return flags;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        // 在拖拽过程中不断地调用adapter.notifyItemMoved(from,to);
        if (viewHolder.getItemViewType() != target.getItemViewType()) {
            return false;
        }
        //在拖拽的过程中不断调用adapter.notifyItemMoved(from,to);
        boolean result = moveListener.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return result;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        moveListener.onItemRemove(viewHolder.getAdapterPosition());
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    //设置滑动item的背景
    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        //判断选中状态
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            viewHolder.itemView.setBackgroundColor(viewHolder.itemView.getContext().getResources().getColor(R.color.text_color));
        }
        super.onSelectedChanged(viewHolder, actionState);

    }

    //清除滑动item的背景
    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        // 恢复
        viewHolder.itemView.setBackgroundColor(viewHolder.itemView.getContext().getResources().getColor(R.color.code_send));

        //防止出现复用问题 而导致条目不显示 方式一
        viewHolder.itemView.setAlpha(1);//1-0
        //设置滑出大小
//            viewHolder.itemView.setScaleX(1);
//            viewHolder.itemView.setScaleY(1);
        super.clearView(recyclerView, viewHolder);
    }

    //设置滑动时item的背景透明度
    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        //dX:水平方向移动的增量(负：往左；正：往右) 0-view.getWidth()
        float alpha = 1 - Math.abs(dX) / viewHolder.itemView.getWidth();
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {

            //透明度动画
            viewHolder.itemView.setAlpha(alpha);//1-0
            //设置滑出大小
//            viewHolder.itemView.setScaleX(alpha);
//            viewHolder.itemView.setScaleY(alpha);
        }
//        //防止出现复用问题 而导致条目不显示 方式二
//        if(alpha==0){
//            viewHolder.itemView.setAlpha(1);//1-0
//            //设置滑出大小
////            viewHolder.itemView.setScaleX(1);
////            viewHolder.itemView.setScaleY(1);
//        }
        //此super方法自动处理setTranslationX
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

    }

}
