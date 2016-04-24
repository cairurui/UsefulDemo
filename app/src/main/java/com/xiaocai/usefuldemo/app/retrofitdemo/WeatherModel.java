package com.xiaocai.usefuldemo.app.retrofitdemo;

import android.content.Context;

import retrofit2.Call;

/**
 * Created by xiaocai on 2016/4/25.
 */
public class WeatherModel {

    private static WeatherModel mWeatherModel;
    private WeatherService mWeatherService;

    //初始化WeatherService
    private WeatherModel(Context context) {
        //初始化WeatherService
        mWeatherService = RetrofitWrapper.getInstance().create(WeatherService.class);
    }

    /**
     * 单例模式
     *
     * @return
     */
    public static WeatherModel getInstance(Context context) {
        if (mWeatherModel == null) {
            synchronized (WeatherModel.class) {
                if (mWeatherModel == null) {
                    mWeatherModel = new WeatherModel(context);
                }
            }
        }
        return mWeatherModel;
    }

    /**
     * 查询天气
     * areaid=101010100&key=c57c05bad956ebe6b0bd061da31f28bf
     *
     * @return
     */
    public Call<WeatherBean> getWeather(WeatherBean weatherBean) {
        Call<WeatherBean> call = mWeatherService.getWeather("101010100", "c57c05bad956ebe6b0bd061da31f28bf");
        return call;
    }


}
