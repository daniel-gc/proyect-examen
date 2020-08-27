package com.project.liverpool.ui.productosliverpool.productosFragments;

import com.project.liverpool.data.model.Records;
import com.project.liverpool.data.repository.ServicesDataSource;
import com.project.liverpool.utils.AppSharePreferencesManager;
import com.project.liverpool.webservices.BaseCallback;
import com.project.liverpool.webservices.response.ResponseSuccess;
import com.project.liverpool.webservices.response.Status;

import java.util.List;

public class ProductFindPresenterImpl implements ProductFindContract.Presenter{

    public static final String TAG = ProductFindPresenterImpl.class.getSimpleName();

    private ProductFindContract.View view;
    private ServicesDataSource userRepository;
    private AppSharePreferencesManager appSharePreferences;
    List<String> optionsEstatusCitList;
    List<Records> recordsList;

    public ProductFindPresenterImpl(ProductFindContract.View view, ServicesDataSource userRepository,
                                        AppSharePreferencesManager appSharePreferences) {
        this.view = view;
        this.userRepository = userRepository;
        this.appSharePreferences = appSharePreferences;
    }

    @Override
    public void getProducts(String name) {

        if(name == null || name.trim().equals("")){
            view.hidenProgressBar();
            view.showProgressBar("Debe ingresar el nombre de un producto",true);
            return;
        }
        view.showProgressBar("Buscando...",true);
        userRepository.setLoadLocalData(false);
        userRepository.getProductosLiverpool(name,1,10,new BaseCallback<ResponseSuccess>(){

            @Override
            public void onSuccess(ResponseSuccess responseSuccess) {
                Status status = responseSuccess.getStatus();
                int statusCode = status.getStatusCode();
                String decr = status.getErrorDescription();

                if(decr != null && !decr.trim().equals("")){
                    view.showProgressBar(decr,true);
                }else {
                    if (responseSuccess.getPlpResults() != null && responseSuccess.getPlpResults().getRecords() != null && responseSuccess.getPlpResults().getRecords().size() > 0){
                        view.showReciclerViewData(responseSuccess.getPlpResults().getRecords());
                        view.hidenProgressBar();
                    }else{
                            view.hidenProgressBar();
                            view.showProgressBar("No se encontraron registros de esa descripción",true);
                        }
                    }

            }

            @Override
            public void onFailure(String message) {
                view.hidenProgressBar();
                view.showProgressBar(message,true);
            }
        });
    }
}
