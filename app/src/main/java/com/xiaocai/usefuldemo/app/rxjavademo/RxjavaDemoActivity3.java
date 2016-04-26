package com.xiaocai.usefuldemo.app.rxjavademo;

import android.app.Activity;
import android.os.Bundle;

import com.xiaocai.usefuldemo.app.logger.Logger;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * 作者：crr on 2016/4/26 0026 14:52
 * desc：
 */
public class RxjavaDemoActivity3 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rejavaTest();

    }

    private void rejavaTest() {
        /**
         * 只要偶数--->之后取平方根。  因为平方根后就不在是int类型了就不能像原来那样链式编程
         * 解决： 使用 map 操作符
         *
         */
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9).filter(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer % 2 == 0;
            }
        }).map(new Func1<Integer, Double>() {
            @Override
            public Double call(Integer a) {
                return Math.sqrt(a);
            }
        }).subscribe(new Action1<Double>() {
            @Override
            public void call(Double a) {
                Logger.d("rejavaTest()输出:" + a);
            }
        });

    }

}
