package com.zhuke.zdy1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by 15653 on 2018/4/2.
 */

public class CanvasTest extends View {

    private Paint mPaint;
    private float mAngle;
    private int mWidth;
    //圆环宽度
    private int annulusWidth = 20;
    //圆环颜色
    private int annulusColor = Color.RED;
    //最大值
    private float progressMax = 100;
    //当前progress
    private float mProgress = 50;
    //文本颜色
    private int textColor = Color.RED;
    //自己大小
    private int textSize = 40;
    private int mHeight;

    public CanvasTest(Context context) {
        this(context,null);
    }

    public CanvasTest(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);

    }

    public CanvasTest(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPanit();
    }

    private void initPanit() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.DKGRAY);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(mWidth / 2,mHeight/2);
        mPaint.setStrokeWidth(annulusWidth);
        float radius = (mWidth / 2 - annulusWidth / 2)/2;
        canvas.drawCircle(0,0,radius,mPaint);

        RectF rectF = new RectF(-radius,-radius,radius,radius);
        mPaint.setColor(annulusColor);
//        canvas.drawRect(rectF,mPaint);
        canvas.drawArc(rectF,0, mProgress *360/progressMax,false,mPaint);
        Log.e("progress",mProgress *360/progressMax+"");
        //        3、绘制文本
        String text = mProgress * 100 / progressMax + "%";
        mPaint.setColor(textColor);
        mPaint.setTextSize(textSize);
//        注意此处一定要重新设置宽度为0
        mPaint.setStrokeWidth(0);
//        得到指定文本的边界矩形大小
        Rect bounds = new Rect();
        mPaint.getTextBounds(text, 0, text.length(), bounds);
        canvas.drawText(text,  - bounds.width() / 2, bounds.height() / 2, mPaint);
       /*  canvas.drawPoint(100,100,mPaint);
        canvas.drawPoints(new float[]{100,200,100,300,100,400},mPaint);
        canvas.drawLine(200,200,600,200,mPaint);
        canvas.drawLines(new float[]{200,300,600,300, 200,400,600,400},mPaint);
        canvas.drawRect(200,500,600,900,mPaint);
        Rect rect = new Rect(200,500,600,900);
        canvas.drawRect(rect,mPaint);
        RectF rectF = new RectF(200f,500f,600f,900f);
        canvas.drawRect(rectF,mPaint);
        RectF rect1 = new RectF(200,1000,600,1400);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(400,1200,200,mPaint);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawArc(rect1,-90,mAngle,true,mPaint);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.WHITE);
        canvas.drawCircle(400,1200,160,mPaint);*/
     /*   Path path = new Path();
        mPaint.setStyle(Paint.Style.STROKE);
        path.lineTo(500,500);
        path.lineTo(0,500);
        canvas.drawPath(path,mPaint)*/;

    }

    // 设置起始角度
    public void setAngle(float mAngle) {
        this.mAngle = mAngle;
        invalidate();   // 刷新
    }

    public void setMax(int max) {
        this.progressMax = max;
    }

    public void setProgress(float progress) {
        this.mProgress = progress;
    }
}
