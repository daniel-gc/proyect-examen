package com.project.liverpool.ui.productosliverpool;

public interface ProductosContract {


    interface View{
        void showProgressBar(String message,Boolean isCancelable);
        void hidenProgressBar();
    }
    interface Presenter{
        void initFragment();
        void loadNetworkConfig();
    }

}
