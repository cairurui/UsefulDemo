package com.xiaocai.usefuldemo.app.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaocai.usefuldemo.app.R;
import com.xiaocai.usefuldemo.app.constants.ConfigConstants;

public class FrescoImageGIFActivity extends Activity {

    private SimpleDraweeView mSdv;
    String uri = "http://qn.18touch.com/uploads/tuku/20160323/1458721508535632.gif";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_fresco_image);
        mSdv = (SimpleDraweeView) findViewById(R.id.sdv);
    }

    public void click(View view) {
        mSdv.setController(ConfigConstants.getDraweeController(ConfigConstants.getImageRequest(mSdv, uri), mSdv));
    }

}
