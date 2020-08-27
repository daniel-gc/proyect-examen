package com.project.liverpool.dagger.modules;

import com.project.liverpool.application.ActivityScope;
import com.project.liverpool.commons.Constants;
import com.project.liverpool.data.local.ServiceLocalDataSource;
import com.project.liverpool.data.remote.ServicesRemoteDataSource;
import com.project.liverpool.data.repository.ServicesRepository;
import com.project.liverpool.utils.AppSharePreferencesManager;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class RepositoryModule {

    @Provides
    @ActivityScope
    public ServicesRemoteDataSource providesRemoteDataSource(@Named(Constants.PUBLIC_SERVICE) Retrofit retrofit) {
        return new ServicesRemoteDataSource(retrofit);
    }

    @Provides
    @ActivityScope
    public ServiceLocalDataSource providesLocalDataSource(AppSharePreferencesManager sharePreferences) {
        return new ServiceLocalDataSource(sharePreferences);
    }

    @Provides
    @ActivityScope
    public ServicesRepository providesRepository(ServicesRemoteDataSource remoteDataSource, ServiceLocalDataSource localDataSource) {
        return new ServicesRepository(remoteDataSource, localDataSource);
    }

}
