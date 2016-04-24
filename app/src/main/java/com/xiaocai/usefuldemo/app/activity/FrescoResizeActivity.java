package com.xiaocai.usefuldemo.app.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaocai.usefuldemo.app.R;
import com.xiaocai.usefuldemo.app.utils.FrescoHelper;

/**
 * 作者：crr on 2016/4/22 0022 19:21
 * desc：
 */
public class FrescoResizeActivity extends Activity implements View.OnClickListener {
    private static int mScreenWidth, mScreenHeight;
    private SimpleDraweeView mSdv;
    String uri = "http://qlogo2.store.qq.com/qzone/708814445/708814445/100?1353557035";
    private LinearLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resize);

        if (mScreenWidth == 0 || mScreenHeight == 0) {
            DisplayMetrics metrics = getResources().getDisplayMetrics();
            mScreenWidth = metrics.widthPixels;
            mScreenHeight = metrics.heightPixels;
        }


        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        mContainer = (LinearLayout) findViewById(R.id.container);
        mSdv = (SimpleDraweeView) findViewById(R.id.sdv);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                FrescoHelper.displayImageview(mSdv,uri,false,0);
                break;
            case R.id.btn2:
                float ratio =( (float)mContainer.getWidth())/mContainer.getHeight();
                mSdv.setLayoutParams(new LinearLayout.LayoutParams(mContainer.getWidth(),mContainer.getHeight()));
                FrescoHelper.displayImageResize(mSdv,uri,mContainer.getWidth(),mContainer.getHeight(),ratio);
                break;
        }
    }
}
