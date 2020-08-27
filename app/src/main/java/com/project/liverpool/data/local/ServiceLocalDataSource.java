package com.project.liverpool.data.local;

import com.project.liverpool.data.repository.ServicesDataSource;
import com.project.liverpool.utils.AppSharePreferencesManager;
import com.project.liverpool.webservices.BaseCallback;
import com.project.liverpool.webservices.response.PlpResults;
import com.project.liverpool.webservices.response.ResponseSuccess;

import java.util.List;

import javax.inject.Inject;
//metodos para persistencia local/ REALM,SHAREDPREFERENS,O SQLITE, DEPENDIENDO LA ONFIURACIÓN
public class ServiceLocalDataSource implements ServicesDataSource {

    private AppSharePreferencesManager sharePrefs;

    @Inject
    public ServiceLocalDataSource(AppSharePreferencesManager sharePreferences){
        this.sharePrefs = sharePreferences;
    }

    @Override
    public void getProductosLiverpool(String nameProduct,Integer numPage, Integer numItems,BaseCallback<ResponseSuccess> callback) {

    }

    @Override
    public void setLoadLocalData(boolean loadLocalData) {

    }
}
