package com.xiaocai.usefuldemo.app.rxjavademo;

import android.app.Activity;
import android.os.Bundle;

import com.xiaocai.usefuldemo.app.logger.Logger;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * 作者：crr on 2016/4/26 0026 14:52
 * desc：
 */
public class RxjavaDemoActivity2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rejavaTest();

    }

    private void rejavaTest() {
        /**
         * filter起到过滤作用:返回true则通过，false则不会通过
         * filter之后还是原来的Observable对象，所以可继续链式编程
        */
        // 只要偶数
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9).filter(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer % 2 == 0;
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Logger.d("rejavaTest()输出:" + integer);
            }
        });

    }

}
