package com.zhuke.zdy1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.zhuke.zdy1.dialog.CommentDailog;

import org.json.JSONArray;
import org.json.JSONException;


/**
 * Created by 15653 on 2018/4/25.
 */

public class TestActivity extends AppCompatActivity implements View.OnClickListener{
    private String data = "[\n" +
            "  [\n" +
            "    \"150819001\",\n" +
            "    \"周三001\",\n" +
            "    \"欧洲冠军联赛\",\n" +
            "    \"凯尔特人\",\n" +
            "    \"马尔默\",\n" +
            "    \"-1\",\n" +
            "    \"2015-08-20 02:45:00\",\n" +
            "    \"2015-08-19 23:55:00\",\n" +
            "    \"00000\",\n" +
            "    \"-\",\n" +
            "    \"-\",\n" +
            "    \"-\",\n" +
            "    \"-\",\n" +
            "    \"-\",\n" +
            "    \"-\",\n" +
            "    \",,\",\n" +
            "    \"[[1.47,3.7,5.8],[2.57,3.3,2.3],[10,4.5,3.25,3.65,5,9.5,17,27],[5.8,7,7,10,11,24,20,24,50,50,60,120,40,10,6.5,16,70,400,13,30,16,80,50,50,300,200,250,900,600,700,250],[2.1,16,50,4,5.4,11,24,16,8.5],[0,0,0],[],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0]]\",\n" +
            "    \"#F75000\",\n" +
            "    \"2015-08-19\"\n" +
            "  ],\n" +
            "  [\n" +
            "    \"150819002\",\n" +
            "    \"周三002\",\n" +
            "    \"欧洲冠军联赛\",\n" +
            "    \"凯尔特人\",\n" +
            "    \"马尔默\",\n" +
            "    \"-1\",\n" +
            "    \"2015-08-20 02:45:00\",\n" +
            "    \"2015-08-19 23:55:00\",\n" +
            "    \"00000\",\n" +
            "    \"-\",\n" +
            "    \"-\",\n" +
            "    \"-\",\n" +
            "    \"-\",\n" +
            "    \"-\",\n" +
            "    \"-\",\n" +
            "    \",,\",\n" +
            "    \"[[1.47,3.7,5.8],[2.57,3.3,2.3],[10,4.5,3.25,3.65,5,9.5,17,27],[5.8,7,7,10,11,24,20,24,50,50,60,120,40,10,6.5,16,70,400,13,30,16,80,50,50,300,200,250,900,600,700,250],[2.1,16,50,4,5.4,11,24,16,8.5],[0,0,0],[],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0]]\",\n" +
            "    \"#F75000\",\n" +
            "    \"2015-08-19\"\n" +
            "  ],\n" +
            "  [\n" +
            "    \"150820001\",\n" +
            "    \"周四001\",\n" +
            "    \"欧洲冠军联赛\",\n" +
            "    \"凯尔特人\",\n" +
            "    \"马尔默\",\n" +
            "    \"-1\",\n" +
            "    \"2015-08-20 02:45:00\",\n" +
            "    \"2015-08-19 23:55:00\",\n" +
            "    \"00000\",\n" +
            "    \"-\",\n" +
            "    \"-\",\n" +
            "    \"-\",\n" +
            "    \"-\",\n" +
            "    \"-\",\n" +
            "    \"-\",\n" +
            "    \",,\",\n" +
            "    \"[[1.47,3.7,5.8],[2.57,3.3,2.3],[10,4.5,3.25,3.65,5,9.5,17,27],[5.8,7,7,10,11,24,20,24,50,50,60,120,40,10,6.5,16,70,400,13,30,16,80,50,50,300,200,250,900,600,700,250],[2.1,16,50,4,5.4,11,24,16,8.5],[0,0,0],[],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0]]\",\n" +
            "    \"#F75000\",\n" +
            "    \"2015-08-20\"\n" +
            "  ],\n" +
            "  [\n" +
            "    \"150820002\",\n" +
            "    \"周四002\",\n" +
            "    \"欧洲冠军联赛\",\n" +
            "    \"凯尔特人\",\n" +
            "    \"马尔默\",\n" +
            "    \"-1\",\n" +
            "    \"2015-08-20 02:45:00\",\n" +
            "    \"2015-08-19 23:55:00\",\n" +
            "    \"00000\",\n" +
            "    \"-\",\n" +
            "    \"-\",\n" +
            "    \"-\",\n" +
            "    \"-\",\n" +
            "    \"-\",\n" +
            "    \"-\",\n" +
            "    \",,\",\n" +
            "    \"[[1.47,3.7,5.8],[2.57,3.3,2.3],[10,4.5,3.25,3.65,5,9.5,17,27],[5.8,7,7,10,11,24,20,24,50,50,60,120,40,10,6.5,16,70,400,13,30,16,80,50,50,300,200,250,900,600,700,250],[2.1,16,50,4,5.4,11,24,16,8.5],[0,0,0],[],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0]]\",\n" +
            "    \"#F75000\",\n" +
            "    \"2015-08-20\"\n" +
            "  ],\n" +
            "  [\n" +
            "    \"150820003\",\n" +
            "    \"周四003\",\n" +
            "    \"欧洲冠军联赛\",\n" +
            "    \"凯尔特人\",\n" +
            "    \"马尔默\",\n" +
            "    \"-1\",\n" +
            "    \"2015-08-20 02:45:00\",\n" +
            "    \"2015-08-19 23:55:00\",\n" +
            "    \"00000\",\n" +
            "    \"-\",\n" +
            "    \"-\",\n" +
            "    \"-\",\n" +
            "    \"-\",\n" +
            "    \"-\",\n" +
            "    \"-\",\n" +
            "    \",,\",\n" +
            "    \"[[1.47,3.7,5.8],[2.57,3.3,2.3],[10,4.5,3.25,3.65,5,9.5,17,27],[5.8,7,7,10,11,24,20,24,50,50,60,120,40,10,6.5,16,70,400,13,30,16,80,50,50,300,200,250,900,600,700,250],[2.1,16,50,4,5.4,11,24,16,8.5],[0,0,0],[],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0]]\",\n" +
            "    \"#F75000\",\n" +
            "    \"2015-08-20\"\n" +
            "  ]\n" +
            "]";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        findViewById(R.id.click).setOnClickListener(this);
        json();
    }

    private void json() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONArray jsonArray1 = jsonArray.getJSONArray(i);
                for (int i1 = 0; i1 < jsonArray1.length(); i1++) {
                   /* if (i1 == 16) {
                        JSONArray jsonArray2 = jsonArray1.getJSONArray(i1);

                            stringBuilder.append(jsonArray2.get(i2).toString());

                    }else {*/
                   Toast.makeText(this,jsonArray1.get(16).toString(),Toast.LENGTH_SHORT).show();
                        stringBuilder.append( jsonArray1.get(i1).toString());
//                    }
                }
            }
            Log.e("json",stringBuilder.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public void onClick(View mView) {

        switch (mView.getId()){
            case R.id.click:
                json();
               /* new CommentDailog(this,R.drawable.user_dailog_shape) {
                    @Override
                    public int getDialog_content_normal() {
                        return R.layout.time_hint;
                    }

                    @Override
                    public void initEvent() {
                        findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                               dismiss();
                            }
                        });
                    }
                }.show();*/
                break;
        }
    }
}
