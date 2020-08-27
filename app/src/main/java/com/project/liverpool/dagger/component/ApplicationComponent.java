package com.project.liverpool.dagger.component;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.project.liverpool.application.PublicSessionManager;
import com.project.liverpool.dagger.modules.ApplicationModule;
import com.project.liverpool.dagger.modules.ConfigServiceModule;
import com.project.liverpool.ui.productosliverpool.ProductosComponent;
import com.project.liverpool.ui.productosliverpool.ProductosModule;
import com.project.liverpool.utils.AppSharePreferencesManager;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ConfigServiceModule.class})
public interface ApplicationComponent {

    ProductosComponent getProductsComponet(ProductosModule module);

    Context getContext();

    Application getApplication();

    Gson getGson();

    PublicSessionManager getPublicMSSessionManager();

    AppSharePreferencesManager getAppSharePreference();

}
