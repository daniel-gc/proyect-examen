package com.project.liverpool.application;

import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.multidex.MultiDexApplication;

import com.blankj.utilcode.util.Utils;
import com.project.liverpool.commons.Constants;
import com.project.liverpool.dagger.component.ApplicationComponent;
import com.project.liverpool.dagger.component.DaggerApplicationComponent;
import com.project.liverpool.dagger.modules.ApplicationModule;
import com.project.liverpool.dagger.modules.ConfigServiceModule;
import com.project.liverpool.utils.ApplicationLifecycleObserver;

public class AppInit extends MultiDexApplication{

    private static ApplicationComponent component;
    public static boolean IN_APP;

    @Override
    public void onCreate() {
        super.onCreate();
        configDagger();
        ProcessLifecycleOwner.get().getLifecycle().addObserver(new ApplicationLifecycleObserver(component.getAppSharePreference()));
        Utils.init(this);
    }

    private void configDagger() {
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .configServiceModule(new ConfigServiceModule(Constants.BASE_URL))
                .build();
    }

    public static ApplicationComponent getAppComponent() {
        return component;
    }

}
