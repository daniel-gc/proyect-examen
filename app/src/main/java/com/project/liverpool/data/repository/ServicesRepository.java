package com.project.liverpool.data.repository;

import android.util.Log;

import com.project.liverpool.webservices.BaseCallback;
import com.project.liverpool.webservices.response.PlpResults;
import com.project.liverpool.webservices.response.ResponseSuccess;

import java.util.List;

public class ServicesRepository implements ServicesDataSource{

    private ServicesDataSource localDataSource;
    private ServicesDataSource remoteDataSource;
    private boolean loadLocalData;

    public ServicesRepository(ServicesDataSource remoteDataSource, ServicesDataSource localDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
        this.loadLocalData = true;
    }


    @Override
    public void getProductosLiverpool(String nameProduct,Integer numPage, Integer numItems,BaseCallback<ResponseSuccess> callback) {
        if (loadLocalData) {
            //cargar los datos locales
            Log.d("Ejemplo","Datos Locales");
            localDataSource.getProductosLiverpool(nameProduct,numPage,numItems,callback);
        }else{
            //cargar los datos remotos
            Log.d("Ejemplo","Datos remotos");
            remoteDataSource.getProductosLiverpool(nameProduct,numPage,numItems,callback);
        }
    }

    @Override
    public void setLoadLocalData(boolean loadLocalData) {
        this.loadLocalData = loadLocalData;
    }
}
