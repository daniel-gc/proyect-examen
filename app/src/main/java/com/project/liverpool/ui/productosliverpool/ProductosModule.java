package com.project.liverpool.ui.productosliverpool;

import com.project.liverpool.application.ActivityScope;
import com.project.liverpool.application.PublicSessionManager;
import com.project.liverpool.dagger.modules.RepositoryModule;
import com.project.liverpool.data.repository.ServicesRepository;
import com.project.liverpool.utils.AppSharePreferencesManager;

import dagger.Module;
import dagger.Provides;

@Module
public class ProductosModule {

   ProductosContract.View view;

    public ProductosModule(ProductosContract.View view){
        this.view=view;
    }

    @Provides
    @ActivityScope
    public ProductosContract.Presenter providePresenter(PublicSessionManager sessionManager,
                                                        AppSharePreferencesManager appSharePreferences) {
        return new ProductosPresenterImpl(view, sessionManager,appSharePreferences);
    }

}
