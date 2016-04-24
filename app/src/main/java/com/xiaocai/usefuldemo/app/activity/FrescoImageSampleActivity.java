package com.xiaocai.usefuldemo.app.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaocai.usefuldemo.app.R;
import com.xiaocai.usefuldemo.app.utils.FrescoHelper;

public class FrescoImageSampleActivity extends Activity {

    private SimpleDraweeView mSdv;
    String uri = "http://qlogo2.store.qq.com/qzone/708814445/708814445/100?1353557035";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_fresco_image);
        mSdv = (SimpleDraweeView) findViewById(R.id.sdv);
    }

    public void click(View view){
        FrescoHelper.displayImageview(mSdv,uri,true,10);
    }

}
