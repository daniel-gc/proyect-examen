package com.project.liverpool.ui.productosliverpool.productosFragments;

import com.project.liverpool.application.ActivityScope;
import com.project.liverpool.dagger.modules.RepositoryModule;
import com.project.liverpool.data.repository.ServicesRepository;
import com.project.liverpool.utils.AppSharePreferencesManager;

import dagger.Module;
import dagger.Provides;

@Module(includes = RepositoryModule.class)
public class ProductFindModule {

    ProductFindContract.View view;

    public ProductFindModule(ProductFindContract.View view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    public ProductFindContract.Presenter providePresenter(ServicesRepository templateDataSource,
                                                          AppSharePreferencesManager appSharePreferences) {
        return new ProductFindPresenterImpl(view, templateDataSource, appSharePreferences);
    }

}
