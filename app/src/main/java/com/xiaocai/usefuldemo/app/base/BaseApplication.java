package com.xiaocai.usefuldemo.app.base;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.xiaocai.usefuldemo.app.constants.ConfigConstants;
import com.xiaocai.usefuldemo.app.logger.Logger;


/**
 * 作者：crr on 2016/4/21 0021 10:49
 * desc：
 */
public class BaseApplication extends Application {

    private static BaseApplication appcontext = null;

    @Override
    public void onCreate() {
        super.onCreate();
        appcontext = this;
        Logger.init("各种测试");
        Fresco.initialize(appcontext, ConfigConstants.getImagePipelineConfig(appcontext));
    }

    public static BaseApplication getContext(){
        return appcontext;
    }
}
