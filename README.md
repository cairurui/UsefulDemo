#对目前比较好用的框架的配置及简单使用#

###1、Fresco的配置及四种使用 ###
在demo中已经注释很详细了

###2、retrofit ###
retrofit在这里需要稍微说明下使用步骤：

1.创建接口，里面写注解的接口

    public interface WeatherService {
        @GET("/real_time_weather.php")
        void getWeather(@Query("areaid") String areaid, @Query("key") String key, Callback<WeatherBean> callback);
    }
2.创建RestAdapter对象

	 private WeatherService mService; //声明service
	 RestAdapter restAdapter = new RestAdapter.Builder()
             .setEndpoint("http://v.juhe.cn/xiangji_weather")//EndPoint就是域名
             .build();

     mService = restAdapter.create(WeatherService.class);//创建一个service实现类

3.调用service声明中的方法

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


通过以上三个步骤即可简单实现了retrofit的使用了，需要在build中添加依赖：compile 'com.squareup.retrofit:retrofit:1.9.0'






