package com.project.liverpool.ui.productosliverpool.productosFragments;

import com.project.liverpool.application.ActivityScope;
import com.project.liverpool.dagger.component.PublicSessionComponent;

import dagger.Component;

@ActivityScope
@Component(
        dependencies = PublicSessionComponent.class,
        modules = ProductFindModule.class
)
public interface ProductFindComponent {
    void inject(ProductsFindFragment fragment);

    ProductFindContract.Presenter getPresenter();
}
