package com.project.liverpool.dagger.modules;

import com.google.gson.Gson;
import com.project.liverpool.commons.Constants;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ConfigServiceModule {

    String baseUrl;

    public ConfigServiceModule(String baseUrl){
        this.baseUrl = baseUrl;
    }

    @Provides @Singleton
    @Named(Constants.PUBLIC_SERVICE)
    Retrofit provideConfigRetrofit(Gson gson, @Named(Constants.PUBLIC_SERVICE) OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build();
    }

}
