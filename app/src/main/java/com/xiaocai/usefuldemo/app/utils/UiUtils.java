package com.xiaocai.usefuldemo.app.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import com.xiaocai.usefuldemo.app.base.BaseApplication;


/**
 * Created by xiaocai on 2016/4/24.
 */
public class UiUtils {

    /**
     * 判断是否有网络
     *
     * @return
     */
    public static boolean hasInternet() {
        boolean flag;
        if (((ConnectivityManager) BaseApplication.getContext().getSystemService(
                Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null)
            flag = true;
        else
            flag = false;
        return flag;
    }
}
