package com.xiaocai.usefuldemo.app.retrofitdemo;

/**
 * Created by xiaocai on 2016/4/24.
 */
public class WeatherBean {
    public int error_code	;//0
    public String reason	;//success
    public WeatherResultBean result	;//Object

    public class WeatherResultBean {
      public WeatherInfoBean  data	;//Object
      public String  pubTime	;//20160424225320
      public String  reqTime	;//20160424231611

        @Override
        public String toString() {
            return "WeatherResultBean{" +
                    "data=" + data +
                    ", pubTime='" + pubTime + '\'' +
                    ", reqTime='" + reqTime + '\'' +
                    '}';
        }
    }

    public class WeatherInfoBean{
       public String  airp	;//1002
       public String  aqi	;//108
       public String  cw	;//00
       public String  cwd	;//05
       public String  rh	;//51
       public String  st	;//20
       public String  tip_aqi	;//轻度污染
       public String  tmp	;//20
       public String  w	;//晴
       public String  wd	;//西南风
       public String  wdg	;//3

        @Override
        public String toString() {
            return "WeatherInfoBean{" +
                    "airp='" + airp + '\'' +
                    ", aqi='" + aqi + '\'' +
                    ", cw='" + cw + '\'' +
                    ", cwd='" + cwd + '\'' +
                    ", rh='" + rh + '\'' +
                    ", st='" + st + '\'' +
                    ", tip_aqi='" + tip_aqi + '\'' +
                    ", tmp='" + tmp + '\'' +
                    ", w='" + w + '\'' +
                    ", wd='" + wd + '\'' +
                    ", wdg='" + wdg + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WeatherBean{" +
                "error_code=" + error_code +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }
}
