package com.zhuke.zdy1.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.zhuke.zdy1.R;

/**
 * Created by 15653 on 2018/1/18.
 */

public class TestView extends View {

    private String mTextTitle;
    private int mTextColor;
    private int mTextSize;
    private Paint mPaint;
    private Rect mRect;

    public TestView(Context context) {
        this(context, null);
    }

    public TestView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTitleView, defStyleAttr, 0);
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            switch (index) {
                case R.styleable.CustomTitleView_titleText:
                    mTextTitle = typedArray.getString(index);
                    break;
                case R.styleable.CustomTitleView_titleTextColor:
                    mTextColor = typedArray.getColor(index, Color.BLACK);
                    break;
                case R.styleable.CustomTitleView_titleTextSize:
                    mTextSize = typedArray.getDimensionPixelSize(index, ((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics())));
                    break;

            }
        }
        typedArray.recycle();
        mPaint = new Paint();
        mPaint.setTextSize(mTextSize);
        mRect = new Rect();
        mPaint.getTextBounds(mTextTitle,0,mTextTitle.length(), mRect);
    }

   /* @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heighSize = MeasureSpec.getSize(heightMeasureSpec);
        int width;
        int height;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        }else {
            mPaint.setTextSize(mTextSize);
            mPaint.getTextBounds(mTextTitle,0,mTextTitle.length(), mRect);
            float width1 = mRect.width();
            width = (int)(getPaddingLeft() + width1 + getPaddingRight() );
        }

        if (heightMode == MeasureSpec.EXACTLY){
            height = heighSize;
        }else {
            mPaint.setTextSize(mTextSize);
            mPaint.getTextBounds(mTextTitle,0,mTextTitle.length(), mRect);
            int height1 = mRect.height();
            height = (int)(getPaddingTop() + height1 + getPaddingBottom());
        }
        setMeasuredDimension(width,height);
    }*/

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(Color.RED);
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint);
        mPaint.setColor(R.color.colorPrimary);
        Log.e("onDraw",getWidth()+"=" + getHeight());
        Log.e("onDraw",mRect.width()+"=" + mRect.height());
        canvas.drawText(mTextTitle,getWidth()/2-mRect.width()/2,getHeight()/2-mRect.height()/2,mPaint);
    }
}
