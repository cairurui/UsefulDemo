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
import com.xiaocai.usefuldemo.app.retrofitdemo.simpledemo.RetrofitDemoActivity;
import com.xiaocai.usefuldemo.app.rxandroiddemo.RxAndroidDemoActivity;
import com.xiaocai.usefuldemo.app.rxandroiddemo.RxAndroidDemoActivity2;
import com.xiaocai.usefuldemo.app.rxandroiddemo.RxAndroidDemoActivity3;
import com.xiaocai.usefuldemo.app.rxjavademo.RxjavaDemoActivity;
import com.xiaocai.usefuldemo.app.rxjavademo.RxjavaDemoActivity2;
import com.xiaocai.usefuldemo.app.rxjavademo.RxjavaDemoActivity3;

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
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);
        findViewById(R.id.btn10).setOnClickListener(this);
        findViewById(R.id.btn11).setOnClickListener(this);
        findViewById(R.id.btn12).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                startActivity(new Intent(this, FrescoImageSampleActivity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(this, FrescoImageCircleActivity.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(this, FrescoResizeActivity.class));
                break;
            case R.id.btn4:
                startActivity(new Intent(this, FrescoImageGIFActivity.class));
                break;
            case R.id.btn5:
                startActivity(new Intent(this, RetrofitDemo.class));
                break;
            case R.id.btn6:
                startActivity(new Intent(this, RetrofitDemoActivity.class));
                break;
            case R.id.btn7:
                startActivity(new Intent(this, RxjavaDemoActivity.class));
                break;
            case R.id.btn8:
                startActivity(new Intent(this, RxjavaDemoActivity2.class));
                break;
            case R.id.btn9:
                startActivity(new Intent(this, RxjavaDemoActivity3.class));
                break;
            case R.id.btn10:
                startActivity(new Intent(this, RxAndroidDemoActivity.class));
                break;
            case R.id.btn11:
                startActivity(new Intent(this, RxAndroidDemoActivity2.class));
                break;
            case R.id.btn12:
                startActivity(new Intent(this, RxAndroidDemoActivity3.class));
                break;
        }
    }
}
