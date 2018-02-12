package com.zhuke.zdy1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 15653 on 2018/2/12.
 */

public class LineView extends View {
    private Paint linePaine = new Paint();

    public LineView(Context context) {
        this(context, null);
    }

    public LineView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
        linePaine.setStyle(Paint.Style.STROKE);
        linePaine.setAntiAlias(true);
        linePaine.setStrokeWidth(2);
    }

    public LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
private int start = 0;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getWidth() / 2, getHeight() / 2);
        canvas.drawCircle(0,0,getWidth() / 2,linePaine);
        canvas.drawLine(0,0,getWidth() / 2-30,0,linePaine);
        canvas.save();
        canvas.rotate(start);

        canvas.drawLine(0, 0, getWidth() / 2-10, 0, linePaine);

        postInvalidateDelayed(1000);
        start++;
    }
}
