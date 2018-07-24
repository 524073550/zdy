package com.zhuke.zdy1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zhuke.zdy1.view.CanvasTest;
import com.zhuke.zdy1.view.RoundProgress;

/**
 * Created by 15653 on 2018/4/2.
 */

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
//         final CanvasTest canvasTest = (CanvasTest) findViewById(R.id.canvas);
//         final RoundProgress canvasTest = (RoundProgress) findViewById(R.id.canvas);

     /*   final float totalProgress = 90;
//        让当前的进度条动态的加载显示
        new Thread(new Runnable() {
            @Override
            public void run() {
                canvasTest.setMax(100);
                canvasTest.setProgress(0);
                for(int i = 0; i < totalProgress; i++) {
                    canvasTest.setProgress(i);
                    SystemClock.sleep(30);
//                    强制重绘 Use this to invalidate the View from a non-UI thread
                    canvasTest.postInvalidate();
                }
            }
        }).start();*/

    }
}
