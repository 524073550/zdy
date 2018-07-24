package com.zhuke.zdy1.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.zhuke.zdy1.R;


/**
 * Created by Administrator on 2017/8/10.
 */

public abstract class CommentDailog extends Dialog {

    private final int mScreenWidth;
    private EditText mEtContent;
    private ImageButton mIbRelevance;
    public CheckBox mCbRetransmission;
    private Button mSend;
    private final int mScreenHeight;
    private LinearLayout mDialogLatout;
    private ImageButton mExpression;
    private int mDrawableType;

    public CommentDailog(Context context,int drawableType) {
        super(context, R.style.BottomDialog);
        this.mDrawableType = drawableType;
        //设置在dailog区域外点击消失属性
        setCanceledOnTouchOutside(true);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        mScreenWidth = displayMetrics.widthPixels;
        mScreenHeight = displayMetrics.heightPixels;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(getDialog_content_normal());
        Window window = getWindow();
        window.setBackgroundDrawableResource(mDrawableType);
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.CENTER ;
        params.width = mScreenWidth*4/5;
        window.setAttributes(params);
        initEvent();

    }

    public abstract int getDialog_content_normal() ;

    public abstract void initEvent() ;



}
