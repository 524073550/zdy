package com.zhuke.zdy1.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.TextView;

import com.zhuke.zdy1.R;


/**
 * Created by 15653 on 2018/2/12.
 */

public class PassWordEditText extends android.support.v7.widget.AppCompatEditText {
    /**
     * 间隔
     */
    private final int PWD_SPACING = 1;
    private int mWidth;
    private int mHeigh;//每个边框高度
    private int mLineSize;//每个边框宽度
    private int maxCount = 6;
    private int textLength;
    //边框属性
    private Paint mStrokePaint = new Paint();
    private int borderRadius = 5;//圆角
    private int strokeWidth = 5;//线框
    private int strokeColor = Color.GRAY;//线框颜色

    //密码相关属性
    private Paint mPasswordPaint = new Paint();
    private int textPassSize = 16;
    private int textPassColor = Color.BLACK;
    private int passwordPointWidth = 5;

    //边框样式类型
    private int strokeType = 2;
    //是否明文
    private int passwordType = 2;

    //下划线距离
    private int lineWidth = 10;


    public PassWordEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PassWordEditText);
        maxCount = typedArray.getInt(R.styleable.PassWordEditText_maxSize, maxCount);
        borderRadius = typedArray.getInt(R.styleable.PassWordEditText_borderRadius, borderRadius);
        strokeWidth = typedArray.getInt(R.styleable.PassWordEditText_strokeWidth, strokeWidth);
        strokeColor = typedArray.getColor(R.styleable.PassWordEditText_strokeColor, strokeColor);
        textPassSize = (int) typedArray.getDimension(R.styleable.PassWordEditText_textPassSize, textPassSize);
        textPassColor = typedArray.getColor(R.styleable.PassWordEditText_textPassColor, textPassColor);
        passwordPointWidth = typedArray.getInt(R.styleable.PassWordEditText_passwordPointWidth, passwordPointWidth);
        strokeType = typedArray.getInt(R.styleable.PassWordEditText_strokeType, strokeType);
        passwordType = typedArray.getInt(R.styleable.PassWordEditText_passwordType, passwordType);
        mStrokePaint.setStrokeWidth(strokeWidth);
        mStrokePaint.setAntiAlias(true);
        mStrokePaint.setStyle(Paint.Style.STROKE);
        mStrokePaint.setColor(strokeColor);

        mPasswordPaint.setAntiAlias(true);
        mPasswordPaint.setTextSize(dip2px(context, textPassSize));
        mPasswordPaint.setColor(textPassColor);
    }


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    private int dip2px(Context context, float dpValue) {
        try {
            float scale = context.getResources().getDisplayMetrics().density;
            return (int) (dpValue * scale + 0.5f * (dpValue >= 0 ? 1 : -1));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mWidth = getWidth();
        mHeigh = getHeight();
        mLineSize = mWidth / maxCount;
        //相当于遮罩,遮挡住原edtext的style
        Paint paint = new Paint();
        RectF rectF = new RectF();
        rectF.set(0, 0, mWidth, mHeigh);
        paint.setColor(Color.WHITE);
        canvas.drawRoundRect(rectF, dip2px(getContext(), borderRadius), dip2px(getContext(), borderRadius), paint);
        switch (strokeType) {
            case 1: //下划线
                drawLine(canvas);
                break;
            case 2: //边框
                drawRect(canvas);
                break;
        }


        for (int i = 0; i < textLength; i++) {
            int cx = mLineSize / 2 + (mLineSize + PWD_SPACING) * i;
            int cy = mHeigh / 2;
            canvas.drawCircle(cx, cy, dip2px(getContext(), passwordPointWidth), mPasswordPaint);
        }
    }

    private void drawLine(Canvas canvas) {
        mPasswordPaint.setStrokeWidth(strokeWidth);
        mPasswordPaint.setColor(Color.DKGRAY);
        for (int i = 0; i < maxCount; i++) {
            //mLineSize
            canvas.drawLine(i * (mLineSize ) + lineWidth, mHeigh - lineWidth, (mLineSize ) * (i +1) - lineWidth, mHeigh - lineWidth, mPasswordPaint);
        }

       /* canvas.drawLine(getPaddingLeft() + (passwordSize + passwordPadding) * i, getPaddingTop() + passwordSize,
                getPaddingLeft() + (passwordSize + passwordPadding) * i + passwordSize, getPaddingTop() + passwordSize,
                paint);*/
    }

    private void drawRect(Canvas canvas) {
        //TODO:问题点圆角比边框框的原因
        RectF rect = new RectF();
        rect.set(borderRadius / 2, borderRadius / 2, mWidth - borderRadius / 2, mHeigh - borderRadius / 2);
        canvas.drawRoundRect(rect, dip2px(getContext(), borderRadius), dip2px(getContext(), borderRadius), mStrokePaint);

        for (int i = 1; i < maxCount; i++) {
            canvas.drawLine(i * mLineSize, 0, i * mLineSize, mHeigh, mStrokePaint);
        }
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        this.textLength = text.toString().length();
        invalidate();
    }


}
