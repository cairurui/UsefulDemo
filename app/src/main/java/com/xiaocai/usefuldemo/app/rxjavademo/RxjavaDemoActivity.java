package com.xiaocai.usefuldemo.app.rxjavademo;

import android.app.Activity;
import android.os.Bundle;

import com.xiaocai.usefuldemo.app.logger.Logger;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * 作者：crr on 2016/4/26 0026 14:52
 * desc：
 */
public class RxjavaDemoActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rejavaTest();
        rejavaTest2();
        rejavaTest3();
        rejavaTest4();

    }

    private void rejavaTest4() {
        Integer[] arrs = {1,2,3};
        Observable.from(arrs).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Logger.d("rejavaTest4()输出:"+integer);
            }
        });

    }


    private void rejavaTest3() {
        Observable.just(1,2,3).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Logger.d("rejavaTest3()输出:"+integer);
            }
        });

    }

    private void rejavaTest2() {
        Observable integerObservable = Observable.just(1,2,3);

        Subscriber integerSubscriber = new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer o) {
                Logger.d("rejavaTest2()输出：" + o);//看日志输出结果
            }
        };

        integerObservable.subscribe(integerSubscriber);

    }

    private void rejavaTest() {
        Observable integerObservable = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber subscriber) {
                subscriber.onNext(1);
                subscriber.onNext(2);
                subscriber.onNext(3);
                subscriber.onCompleted();
            }
        });

        Subscriber integerSubscriber = new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer o) {
                Logger.d("rejavaTest()输出：" + o);//看日志输出结果
            }
        };

        integerObservable.subscribe(integerSubscriber);

    }


}
