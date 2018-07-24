package com.zhuke.zdy1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zhuke.zdy1.dialog.RXDailog;

/**
 * Created by 15653 on 2018/6/7.
 */

public class DialogAvtivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ((Button) findViewById(R.id.diaglog1)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.diaglog1:
                new RXDailog(R.layout.activity_password).show(getSupportFragmentManager(),"dialog");
                break;
        }
    }
}
