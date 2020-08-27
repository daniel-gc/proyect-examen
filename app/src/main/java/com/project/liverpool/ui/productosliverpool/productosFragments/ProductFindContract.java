package com.project.liverpool.ui.productosliverpool.productosFragments;

import com.project.liverpool.data.model.Records;

import java.util.List;

public interface ProductFindContract {

    interface View{
        void showProgressBar(String message,Boolean isCancelable);
        void hidenProgressBar();
        void showReciclerViewData(List<Records> listProducts);
        void hideReciclerViewData();
    }
    interface Presenter{
        void getProducts(String name);
    }

}
