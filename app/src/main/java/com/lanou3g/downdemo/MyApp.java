package com.lanou3g.downdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by 陈丰尧 on 2017/2/2.
 */

public class MyApp extends Application {
    public static Context sContext;//全局的Context对象

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }
}
