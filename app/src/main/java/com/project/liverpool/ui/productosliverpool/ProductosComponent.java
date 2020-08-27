package com.project.liverpool.ui.productosliverpool;

import com.project.liverpool.application.ActivityScope;
import com.project.liverpool.dagger.component.PublicSessionComponent;

import dagger.Component;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = ProductosModule.class)
public interface ProductosComponent {
    void inject(MainProductsActivity appointmentActivity);
    ProductosContract.Presenter getPresenter();
}
