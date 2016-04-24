package com.xiaocai.usefuldemo.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xiaocai.usefuldemo.app.R;
import com.xiaocai.usefuldemo.app.logger.Logger;
import com.xiaocai.usefuldemo.app.retrofitdemo.RetrofitDemo;
import com.xiaocai.usefuldemo.app.retrofitdemo.WeatherBean;
import com.xiaocai.usefuldemo.app.retrofitdemo.WeatherModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                startActivity(new Intent(this,FrescoImageSampleActivity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(this,FrescoImageCircleActivity.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(this,FrescoResizeActivity.class));
                break;
            case R.id.btn4:
                startActivity(new Intent(this,FrescoImageGIFActivity.class));
                break;
            case R.id.btn5:
                startActivity(new Intent(this,RetrofitDemo.class));
                break;
        }
    }
}
