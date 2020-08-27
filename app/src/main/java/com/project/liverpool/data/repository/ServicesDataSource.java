package com.project.liverpool.data.repository;

import com.project.liverpool.webservices.BaseCallback;
import com.project.liverpool.webservices.response.PlpResults;
import com.project.liverpool.webservices.response.ResponseSuccess;

import java.util.List;

public interface ServicesDataSource {

    void getProductosLiverpool(String nameProduct,Integer numPage, Integer numItems,BaseCallback<ResponseSuccess> callback);

    void setLoadLocalData(boolean loadLocalData);
}
