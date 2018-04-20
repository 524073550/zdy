package com.zhuke.zdy1.view;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by 15653 on 2018/4/20.
 */

public class PassWordEditText2 extends android.support.v7.widget.AppCompatEditText {
    /**
     * 间隔
     */
    private final int PWD_SPACING = 1;
    /**
     * 密码大小
     */
    private final int PWD_SIZE = 5;
    /**
     * 密码长度
     */
    private final int PWD_LENGTH = 6;
    /**
     * 上下文
     */
    private Context mContext;
    /**
     * 宽度
     */
    private int mWidth;
    /**
     * 高度
     */
    private int mHeight;
    /**
     * 密码框
     */
    private Rect mRect;

    /**
     * 密码画笔
     */
    private Paint mPwdPaint;

    /**
     * 密码框画笔
     */
    private Paint mRectPaint;
    /**
     * 密码框画笔
     */
    private Paint textPaint;
    /**
     * 输入的密码长度
     */
    private int mInputLength;
    public PassWordEditText2(Context context) {
        super(context);
    }

    public PassWordEditText2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PassWordEditText2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
