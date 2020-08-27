package com.project.liverpool.dagger.component;

import android.content.Context;

import com.google.gson.Gson;
import com.project.liverpool.commons.Constants;
import com.project.liverpool.dagger.modules.PublicSessionModule;
import com.project.liverpool.dagger.scopes.PublicSessionScope;
import com.project.liverpool.utils.AppSharePreferencesManager;

import javax.inject.Named;

import dagger.Component;
import retrofit2.Retrofit;

@Component(modules = {PublicSessionModule.class}, dependencies= ApplicationComponent.class)
@PublicSessionScope
public interface PublicSessionComponent {

    @Named(Constants.PUBLIC_SERVICE)
    Retrofit getPublicMSService();

    Context getContext();

    Gson getGson();

    AppSharePreferencesManager getSharedPreference();

}
