package com.xiaocai.usefuldemo.app.retrofitdemo;

import android.app.Activity;
import android.os.Bundle;

import com.xiaocai.usefuldemo.app.R;
import com.xiaocai.usefuldemo.app.logger.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by xiaocai on 2016/4/25.
 */
public class RetrofitDemo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofitdemo);

        Call<WeatherBean> weatherBeanCall = WeatherModel.getInstance(this).getWeather(new WeatherBean());
        weatherBeanCall.enqueue(new Callback<WeatherBean>() {
            @Override
            public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response) {
                WeatherBean weatherBean = response.body();
                Logger.d("response:"+weatherBean.reason);
                Logger.d("response:"+weatherBean.result.toString());
                Logger.d("response:"+weatherBean.result.data.toString());
            }

            @Override
            public void onFailure(Call<WeatherBean> call, Throwable t) {

            }
        });
//                Logger.d();
    }
}
