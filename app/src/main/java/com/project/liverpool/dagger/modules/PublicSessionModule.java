package com.project.liverpool.dagger.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.liverpool.commons.Constants;
import com.project.liverpool.dagger.scopes.PublicSessionScope;
import com.project.liverpool.utils.AppSharePreferencesManager;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class PublicSessionModule {

    public PublicSessionModule(){
    }

    @Provides
    @Named(Constants.PUBLIC_SERVICE)
    @PublicSessionScope
    public static Retrofit providePublicSessionRetrofit(@Named("ms_base_url") String baseUrl){

            Gson gson =  new GsonBuilder().setLenient().create();
            OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
            OkHttpClient okHttpClient = httpClientBuilder
                                        .readTimeout(60, TimeUnit.SECONDS)
                                        .retryOnConnectionFailure(false).build();

        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @PublicSessionScope
    @Named("ms_base_url")
    String provideMSBaseUrl(AppSharePreferencesManager sharePreferences){
        return Constants.BASE_URL;
    }

}
