package com.zhuke.zdy1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.zhuke.zdy1.bean.PieDataBean;
import com.zhuke.zdy1.view.PieView;
import com.zhuke.zdy1.view.WaveView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<PieDataBean> mData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WaveView viewById = (WaveView) findViewById(R.id.wv);
        PieView pv = (PieView) findViewById(R.id.pv);
        for (int i = 0; i < 4; i++) {
            mData.add(new PieDataBean("hong",(10+i)*2));
        }
        pv.setData(mData);
        Log.e("pieview",pv.getWidth()+"="+pv.getHeight());
    }
}
