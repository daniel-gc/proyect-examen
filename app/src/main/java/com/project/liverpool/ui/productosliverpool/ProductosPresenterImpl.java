package com.project.liverpool.ui.productosliverpool;

import com.project.liverpool.application.PublicSessionManager;
import com.project.liverpool.data.repository.ServicesDataSource;
import com.project.liverpool.utils.AppSharePreferencesManager;

import javax.inject.Inject;

public class ProductosPresenterImpl implements ProductosContract.Presenter{

    private ProductosContract.View view;
    private AppSharePreferencesManager appSharePreferences;
    private PublicSessionManager publicMSSessionManager;
    @Inject
    ServicesDataSource userRepository;

    @Inject
    public ProductosPresenterImpl(ProductosContract.View view, PublicSessionManager sessionManager,
                               AppSharePreferencesManager appSharePreferences) {
        this.view = view;
        this.publicMSSessionManager = sessionManager;
        this.appSharePreferences=appSharePreferences;
    }

    @Override
    public void initFragment() {
        // se inicia la logica del negocio inicial
    }

    @Override
    public void loadNetworkConfig() {
        publicMSSessionManager.createMSSession();
    }

}
