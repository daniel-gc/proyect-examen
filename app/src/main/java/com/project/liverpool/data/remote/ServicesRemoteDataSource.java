package com.project.liverpool.data.remote;

import android.util.Log;

import com.project.liverpool.commons.Constants;
import com.project.liverpool.data.repository.ServicesDataSource;
import com.project.liverpool.webservices.IServicesAPI;
import com.project.liverpool.webservices.BaseCallback;
import com.project.liverpool.webservices.RetrofitCallback;
import com.project.liverpool.webservices.response.PlpResults;
import com.project.liverpool.webservices.response.ResponseSuccess;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import retrofit2.Call;
import retrofit2.Retrofit;
//metodos para persistencia o consulta de datos mediante retrofit
public class ServicesRemoteDataSource implements ServicesDataSource {

    private Retrofit retrofit;

    @Inject
    public ServicesRemoteDataSource(@Named(Constants.PUBLIC_SERVICE) Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Override
    public void getProductosLiverpool(String nameProduct,Integer numPage, Integer numItems,BaseCallback<ResponseSuccess> callback) {
        // se invoca el servicio
        Log.d("Example", "getDataFromRepositori retrofit call");
        IServicesAPI service = retrofit.create(IServicesAPI.class);
        Call<ResponseSuccess> userCall = service.getProductosLiverpool(Boolean.TRUE,nameProduct,numPage,numItems);
        userCall.enqueue(new RetrofitCallback<>(callback));
    }

    @Override
    public void setLoadLocalData(boolean loadLocalData) {

    }
}
