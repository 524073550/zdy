package com.zhuke.zdy1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;

/**
 * Created by 15653 on 2018/7/5.
 */

public class ProgressView extends View {

    private Paint mBorderPaint;//边框线
    private int mBorderColor = Color.BLACK;//边框线颜色
    private int mBgColor = Color.WHITE;//背景色
    private int mProgressColor = Color.BLUE;//进度颜色
    private int progress = 20;//当前进度
    private int maxProgress = 100;//最大进度
    private float radian = 4;
    private int mBorderWidth = 4;//边框线宽度
    private int mWidthSize;
    private float textSize = 14;
    private int mHeightSize;


    public ProgressView(Context context) {
        this(context, null);
    }

    public ProgressView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mBorderPaint = new Paint();
        mBorderPaint.setColor(mBorderColor);
        mBorderPaint.setStrokeWidth(mBorderWidth);
        mBorderPaint.setStyle(Paint.Style.STROKE);
        mBorderPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mWidthSize = getWidth();
        mHeightSize = getHeight();
        RectF rectF = new RectF(mBorderWidth / 2, mBorderWidth / 2, mWidthSize - mBorderWidth / 2, mHeightSize - mBorderWidth / 2);
        canvas.drawRoundRect(rectF, dip2px(getContext(), radian), dip2px(getContext(), radian), mBorderPaint);
        Paint textPaint = new Paint();
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(dip2px(getContext(), textSize));
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float top = fontMetrics.top;//为基线到字体上边框的距离,即上图中的top
        float bottom = fontMetrics.bottom;//为基线到字体下边框的距离,即上图中的bottom
        canvas.drawText(progress + "%", mWidthSize / 2, mHeightSize / 2 - (bottom + top) / 2, textPaint);
        textPaint.setColor(mProgressColor);
        textPaint.setStyle(Paint.Style.FILL);
        RectF rectF1 = new RectF(mBorderWidth ,mBorderWidth ,50,mHeightSize - mBorderWidth / 2);
        canvas.drawRoundRect(rectF1,dip2px(getContext(), radian), dip2px(getContext(), radian),textPaint );
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
}
