package com.xiaocai.usefuldemo.app.rxandroiddemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.xiaocai.usefuldemo.app.R;

import rx.Observable;
import rx.functions.Action1;

/**
 * 作者：crr on 2016/4/26 0026 16:50
 * desc：
 */
public class RxAndroidDemoActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxandroiddemo);

        Button startBtn = (Button) findViewById(R.id.start_btn);
        startBtn.setOnClickListener(this);
    }

    public String longRunOperation() {
        SystemClock.sleep(5000);
        return "complete";
    }


    @Override
    public void onClick(View v) {
        /**
         * 若不指定线程，则在哪个线程创建，在哪个线程中执行 onNext 等的代码
         */
        Observable<String> opetationObservable = Observable.just(longRunOperation());

        opetationObservable.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Toast.makeText(RxAndroidDemoActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
