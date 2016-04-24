package com.xiaocai.usefuldemo.app.retrofitdemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by xiaocai on 2016/4/24.
 */
public interface WeatherService {

    /**
     * 完整路径名：
     * http://v.juhe.cn/xiangji_weather/real_time_weather.php?areaid=101010100&key=c57c05bad956ebe6b0bd061da31f28bf
     */
    @GET("/xiangji_weather/real_time_weather.php/")
    Call<WeatherBean> getWeather(@Query("areaid") String areaid,
               @Query("key") String key);

}
