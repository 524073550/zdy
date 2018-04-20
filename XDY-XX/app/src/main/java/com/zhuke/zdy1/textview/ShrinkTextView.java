package com.zhuke.zdy1.textview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.zhuke.zdy1.R;

/**
 * Created by 15653 on 2018/2/26.
 */

@SuppressLint("AppCompatCustomView")
public class ShrinkTextView extends TextView {
    private boolean shrink;
    private int normalLine = 3;
    public ShrinkTextView(Context context) {
        this(context, null);
    }

    public ShrinkTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShrinkTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ShrinkTextView);
        shrink = typedArray.getBoolean(R.styleable.ShrinkTextView_shrink, shrink);
        if (shrink) {
            shrink = false;
            setMaxLines(normalLine);
        } else {
            shrink = true;
            setMaxLines(Integer.MAX_VALUE);
        }
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        super.setOnClickListener(l);
        if (shrink) {
            shrink = false;
            setMaxLines(normalLine);
        } else {
            shrink = true;
            setMaxLines(Integer.MAX_VALUE);
        }
    }

    /**
     * 设置是否展开
     *
     * @param isShrink
     */
    public void setTextViewShrink(boolean isShrink) {
        this.shrink = isShrink;
    }

    /**
     * 得到textview是否展开
     *
     * @return
     */
    public boolean getTextViewShrink() {
        return shrink;
    }

    /**
     * 设置默认显示行数
     * @param lines
     */
    public void setNormalLine(int lines){
        this.normalLine = lines;
    }
}
