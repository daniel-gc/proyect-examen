package com.project.liverpool.ui.productosliverpool;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;

import com.project.liverpool.R;
import com.project.liverpool.application.BaseActivity;
import com.project.liverpool.dagger.component.ApplicationComponent;
import com.project.liverpool.dagger.modules.RepositoryModule;
import com.project.liverpool.ui.productosliverpool.productosFragments.ProductsFindFragment;

import javax.inject.Inject;

public class MainProductsActivity extends BaseActivity implements ProductosContract.View {

    @Inject
    ProductosContract.Presenter presenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        presenter.loadNetworkConfig();
        presenter.initFragment();
    }
    @Override
    protected void onResume(){
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Fragment initialFragment = ProductsFindFragment.newInstance();
                changeFragmentNew(R.id.container, initialFragment);
            }
        }, 1000);
    }


    @Override
    public void setUpComponent(ApplicationComponent appComponent) {

        appComponent.getProductsComponet(new ProductosModule(this)).inject(this);
        appComponent.getPublicMSSessionManager().createMSSession();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main_products;
    }

    @Override
    public void showProgressBar(String message, Boolean isCancelable) {
        this.showCustomProgressBar(message,isCancelable);
    }

    @Override
    public void hidenProgressBar() {
        this.hideCustomProgressBar();
    }
}