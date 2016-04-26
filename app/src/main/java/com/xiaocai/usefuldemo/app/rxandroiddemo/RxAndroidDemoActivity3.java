package com.xiaocai.usefuldemo.app.rxandroiddemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.xiaocai.usefuldemo.app.R;
import com.xiaocai.usefuldemo.app.rxjavademo.RxjavaDemoActivity3;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者：crr on 2016/4/26 0026 16:50
 * desc：
 */
public class RxAndroidDemoActivity3 extends Activity implements View.OnClickListener {

    private Subscription mSubscribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxandroiddemo);

        findViewById(R.id.start_btn).setOnClickListener(this);
    }

    public String longRunOperation() {
        SystemClock.sleep(5000);
        return "complete";
    }


    @Override
    public void onClick(View v) {
        /**
         * .subscribeOn(Schedulers.io())  订阅在IO线程中执行
         * .observeOn(AndroidSchedulers.mainThread()); 观察结果在主线程中
         */
        mSubscribe = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext(longRunOperation());
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Toast.makeText(RxAndroidDemoActivity3.this, s, Toast.LENGTH_SHORT).show();
                    }
                });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mSubscribe != null && !mSubscribe.isUnsubscribed()) {
            mSubscribe.unsubscribe();
        }
    }
}
