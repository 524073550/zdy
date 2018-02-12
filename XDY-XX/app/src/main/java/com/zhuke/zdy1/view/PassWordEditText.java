package com.zhuke.zdy1.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

import com.zhuke.zdy1.R;

/**
 * Created by 15653 on 2018/2/12.
 */

public class PassWordEditText extends android.support.v7.widget.AppCompatEditText {
    private Paint mPaint = new Paint();
    private int mWidth;
    private int mHeigh;
    private int mLineSize;

    public PassWordEditText(Context context) {
        this(context, null);
    }

    private int maxCount = 6;

    public PassWordEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        mPaint.setStrokeWidth(2);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PassWordEditText);
        maxCount = typedArray.getInt(R.styleable.PassWordEditText_maxSize, maxCount);
    }

    public PassWordEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeigh = MeasureSpec.getSize(heightMeasureSpec);
        mLineSize = mWidth/maxCount;
        int startCircleX = mLineSize/2;
        int startCircleY = mHeigh/2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF();
        rectF.set(0, 0, mWidth, mHeigh);
        canvas.drawRoundRect(rectF, ((int) (mHeigh / 3 * 0.8)), ((int) (mHeigh / 3 * 0.8)), mPaint);
        for (int i = 0; i < maxCount-1; i++) {
            canvas.drawLine((i+1)*mLineSize,0,(i+1)*mLineSize,mHeigh,mPaint);
        }
    }
}
