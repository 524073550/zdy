package com.zhuke.zdy1.dialog;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.zhuke.zdy1.R;

/**
 * Created by 15653 on 2018/6/7.
 */

@SuppressLint("ValidFragment")
public class RXDailog extends DialogFragment {
    private int layoutId;

    public RXDailog(int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(layoutId, container,false);
        return inflate;
    }
}
