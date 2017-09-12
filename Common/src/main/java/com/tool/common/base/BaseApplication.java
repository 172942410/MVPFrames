package com.tool.common.base;

import android.app.Application;

import com.tool.common.base.delegate.AppDelegate;
import com.tool.common.di.component.AppComponent;

/**
 * Source https://github.com/DesignQu/MVPFrames
 */
public abstract class BaseApplication extends Application implements App {

    // AppDelegate
    private AppDelegate delegate;

    @Override
    public void onCreate() {
        super.onCreate();

        this.delegate = new AppDelegate(this);
        this.delegate.onCreate(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        this.delegate.onTerminate(this);
    }

    /**
     * 返回AppComponent提供统一出口，AppComponent里拿到对象后都可以直接使用
     *
     * @return
     */
    @Override
    public AppComponent getAppComponent() {
        return delegate.getAppComponent();
    }
}