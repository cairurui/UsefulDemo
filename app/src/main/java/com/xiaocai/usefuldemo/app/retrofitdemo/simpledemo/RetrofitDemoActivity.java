package com.xiaocai.usefuldemo.app.retrofitdemo.simpledemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xiaocai.usefuldemo.app.R;
import com.xiaocai.usefuldemo.app.logger.Logger;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Query;


/**
 * 作者：crr on 2016/4/25 0025 18:24
 * desc：
 */
public class RetrofitDemoActivity extends Activity implements View.OnClickListener {

    private TextView mTv;
    private WeatherService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_retrofit_demo);
        mTv = (TextView) findViewById(R.id.tv);
        findViewById(R.id.btn).setOnClickListener(this);


        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://v.juhe.cn/xiangji_weather")
                .build();

        mService = restAdapter.create(WeatherService.class);

    }

    @Override
    public void onClick(View v) {

        mService.getWeather("101010100", "c57c05bad956ebe6b0bd061da31f28bf", new Callback<WeatherBean>() {
            @Override
            public void success(WeatherBean weatherBean, Response response) {
                mTv.setText(weatherBean.toString());
                Logger.d("result:" + weatherBean.toString());
            }

            @Override
            public void failure(RetrofitError error) {
                Logger.d("result:" + error);
            }
        });
    }

    public interface WeatherService {
        @GET("/real_time_weather.php")
        void getWeather(@Query("areaid") String areaid, @Query("key") String key, Callback<WeatherBean> callback);
    }
}
