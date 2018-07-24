package com.zhuke.zdy1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 15653 on 2018/7/11.
 */

public class MyChartView extends View {
    private Context mContext;
    private int stockColor = Color.parseColor("#E5E7F1");//线条边框颜色
    private int stockWidth = 1;//线条宽度
    private int texteVColor = Color.parseColor("#6a6a6a");//竖直字体颜色
    private int texteHColor = Color.parseColor("#2b2b2b");//横向字体颜色
    private int zColor = Color.parseColor("#25b3fb");//正向统计字体雅安色
    private int fColor = Color.parseColor("#ff9161");//背向向统计字体雅安色
    private static List<Float> mVData = new ArrayList<Float>();//竖向数据源
    private String[] mHData = new String[]{"订单出库", "采购入库", "可退入库", "调度出库", "采退出库"};//横向数据源
    private int mWidth;
    private int mHeight;
    private Paint mPaint;
    private Paint mTextPain;
    private int mLineWidth;
    private int rectWidth = 40;
    private static List<Float> mZIntegers;
    private static List<Float> mFIntegers;

    static {
        mVData.add(0.00f);
        mVData.add(200.00f);
        mVData.add(400.00f);
        mVData.add(600.00f);
        mVData.add(800.00f);
        //正向数据源
        mZIntegers = new ArrayList<>();
        mZIntegers.add(100.00f);
        mZIntegers.add(200f);
        mZIntegers.add(400f);
        mZIntegers.add(500f);
        mZIntegers.add(800f);
        //反向数据源
        mFIntegers = new ArrayList<>();
        mFIntegers.add(200.00f);
        mFIntegers.add(400.00f);
        mFIntegers.add(500.00f);
        mFIntegers.add(200.00f);
        mFIntegers.add(800.00f);
    }


    public MyChartView(Context context) {
        this(context, null);
    }

    public MyChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(stockWidth);
        mPaint.setColor(stockColor);
        mTextPain = new Paint();
        mTextPain.setStyle(Paint.Style.FILL);
        mTextPain.setAntiAlias(true);
        mTextPain.setColor(texteVColor);
        mTextPain.setTextAlign(Paint.Align.CENTER);
        mTextPain.setTextSize(14);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        mWidth = getWidth();
        mHeight = getHeight();
        mLineWidth = (mWidth - 40) / 11;
        canvas.translate(0, mHeight / 2);
        drawHorizontalLine(canvas);
        drawVerticalLine(canvas);
        drawRect(canvas);
        drawRectData(canvas);
    }


    private void drawRectData(Canvas canvas) {
        Float max = Collections.max(mVData);
        for (int i = 0; i < mZIntegers.size(); i++) {
            RectF rectF = new RectF();
            mPaint.setShader(new LinearGradient(mLineWidth + 33 + 2 * rectWidth * i, ((mHeight / 10)-mHeight / 2 )* (mZIntegers.get(i) / max), mLineWidth + 33 + rectWidth * (i * 2 + 1), 0,Color.parseColor("#35b3fb"),Color.parseColor("#376ff9"), Shader.TileMode.MIRROR));
            rectF.set(mLineWidth + 33 + 2 * rectWidth * i, ((mHeight / 10)-mHeight / 2 )* (mZIntegers.get(i) / max), mLineWidth + 33 + rectWidth * (i * 2 + 1), 0);
            canvas.drawRect(rectF, mPaint);
            mTextPain.setColor(zColor);
            canvas.drawText(mZIntegers.get(i)+"",mLineWidth + 33 + 2 * rectWidth * i+rectWidth/2,((mHeight / 10)-mHeight / 2) * (mZIntegers.get(i) / max)-4,mTextPain);
        }
        for (int i = 0; i < mFIntegers.size(); i++) {
            mTextPain.setColor(fColor);
            mPaint.setShader(new LinearGradient(mLineWidth + 33 + 2 * rectWidth * i, 0, mLineWidth + 33 + rectWidth * (i * 2 + 1), (mHeight / 2 - (mHeight / 10)) * (mZIntegers.get(i) / max),Color.parseColor("#ffac5a"),Color.parseColor("#ff9161"), Shader.TileMode.MIRROR));
            RectF rectF = new RectF(mLineWidth + 33 + 2 * rectWidth * i, 0, mLineWidth + 33 + rectWidth * (i * 2 + 1), (mHeight / 2 - (mHeight / 10)) * (mZIntegers.get(i) / max));
            canvas.drawRect(rectF, mPaint);
            canvas.drawText(mZIntegers.get(i)+"",mLineWidth + 33 + 2 * rectWidth * i+rectWidth/2,(mHeight / 2 - (mHeight / 10)) * (mZIntegers.get(i) / max)+(mHeight / 10)/3,mTextPain);
        }
    }

    private void drawRect(Canvas canvas) {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.parseColor("#f3f7f9"));
        for (int i = 0; i < mHData.length; i++) {
            RectF rectF = new RectF(mLineWidth + 33 + 2 * rectWidth * i, 0, mLineWidth + 33 + rectWidth * (i * 2 + 1), mHeight / 2 - (mHeight / 10));
            canvas.drawRect(rectF, mPaint);
            rectF.set(mLineWidth + 33 + 2 * rectWidth * i, -mHeight / 2, mLineWidth + 33 + rectWidth * (i * 2 + 1), 0);
            canvas.drawRect(rectF, mPaint);
        }
        mTextPain.setColor(texteHColor);
        for (int i = 0; i < mHData.length; i++) {
            canvas.drawText(mHData[i], mLineWidth + 33 + 2 * rectWidth * i +rectWidth/2, mHeight / 2 - (mHeight / 10) + (mHeight / 10)*4/5, mTextPain);
        }
    }


    private void drawVerticalLine(Canvas canvas) {
        canvas.drawLine(mLineWidth + 13, -mHeight, mLineWidth + 13, mHeight, mPaint);
    }

    private void drawHorizontalLine(Canvas canvas) {
        for (int i = 0; i < mVData.size(); i++) {
            canvas.drawLine(13, (mHeight / 10) * i, mWidth - 13, (mHeight / 10) * i, mPaint);
            if (i != mVData.size() - 1) {
                canvas.drawText(mVData.get(i + 1) + "", 13+mLineWidth/2, (mHeight / 10) * i + (mHeight / 10) * 2 / 3, mTextPain);
            }
        }
        for (int i = 0; i <= mVData.size(); i++) {
            canvas.drawLine(13, -(mHeight / 10) * (i + 1), mWidth - 13, -(mHeight / 10) * (i + 1), mPaint);
            if (i != mVData.size()) {
                canvas.drawText(mVData.get(i) + "", 13+mLineWidth/2, -(mHeight / 10) * i - (mHeight / 10) * 1 / 3, mTextPain);
            }
        }
    }

    public void setData(List<Float> dataZ,List<Float> dataF,List<Float> mVData){
        this.mZIntegers = dataZ;
        this.mFIntegers = dataF;
        this.mVData = dataF;
        invalidate();
    }
}
