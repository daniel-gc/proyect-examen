package com.project.liverpool.ui.productosliverpool.productosFragments;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.otaliastudios.autocomplete.Autocomplete;
import com.otaliastudios.autocomplete.AutocompleteCallback;
import com.otaliastudios.autocomplete.AutocompletePresenter;
import com.project.liverpool.R;
import com.project.liverpool.application.AppInit;
import com.project.liverpool.application.BaseFragment;
import com.project.liverpool.dagger.component.PublicSessionComponent;
import com.project.liverpool.dagger.modules.RepositoryModule;
import com.project.liverpool.data.model.Records;
import com.project.liverpool.databinding.FragmentProductsFindBinding;
import com.project.liverpool.utils.AppSharePreferencesManager;
import com.project.liverpool.utils.autocomplete.ProductsPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class ProductsFindFragment extends BaseFragment implements ProductFindContract.View{

    View view;
    private AdapterProductos mAdapterProductos;
    private Autocomplete productsAutocomplete;
    @Inject
    ProductFindContract.Presenter presenter;

    @Inject
    AppSharePreferencesManager sharePreferencesManager;

    List<String> worldSearch;

    private FragmentProductsFindBinding mFragmentProductsFindBinding;


    private PublicSessionComponent publicSessionComponent;

    public static ProductsFindFragment newInstance() {
        ProductsFindFragment fragment = new ProductsFindFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_products_find, container, false);

        mFragmentProductsFindBinding = FragmentProductsFindBinding.bind(view);

        mFragmentProductsFindBinding.search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(productsAutocomplete != null){
                    productsAutocomplete.showPopup(" ");
                }
                String searchs=mFragmentProductsFindBinding.etValueSearch.getText().toString().trim();
                if(!worldSearch.contains(searchs) && !searchs.equals(""))
                    worldSearch.add(searchs);

                setAutocompleteProducts();

                presenter.getProducts(searchs);
            }
        });
        worldSearch= sharePreferencesManager.getListSearchWorld();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(worldSearch != null && worldSearch.size() > 0)
            setAutocompleteProducts();
    }

    public void setAutocompleteProducts(){
        Drawable backgroundDrawable = new ColorDrawable(Color.WHITE);
        float elevation = 6f;
        AutocompletePresenter<String> presenter = new ProductsPresenter(getContext(),worldSearch);
        AutocompleteCallback<String> callback = new AutocompleteCallback<String>() {
            @Override
            public boolean onPopupItemClicked(@NonNull Editable editable, @NonNull String item) {
                editable.clear();
                editable.append(item);
                return true;
            }

            public void onPopupVisibilityChanged(boolean shown) {}
        };

        productsAutocomplete= Autocomplete.<String>on(mFragmentProductsFindBinding.etValueSearch)
                .with(elevation)
                .with(backgroundDrawable)
                .with(presenter)
                .with(callback)
                .build();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_products_find;
    }

    @Override
    public void injectDependencies() {
        super.injectDependencies();
        publicSessionComponent = AppInit.getAppComponent().getPublicMSSessionManager().getPublicMSComponent();
        DaggerProductFindComponent.builder()
                .publicSessionComponent(publicSessionComponent)
                .productFindModule(new ProductFindModule(this))
                .repositoryModule(new RepositoryModule())
                .build()
                .inject(this);

    }

    @Override
    public void showProgressBar(String message, Boolean isCancelable) {
        this.showCustomProgressBar(message,isCancelable);
    }

    @Override
    public void hidenProgressBar() {
        this.hideCustomProgressBar();
    }

    @Override
    public void showReciclerViewData(List<Records> listProducts) {
        mAdapterProductos = new AdapterProductos(listProducts,getContext());
        mFragmentProductsFindBinding.rvProdList.setVisibility(View.VISIBLE);
        mFragmentProductsFindBinding.rvProdList.setHasFixedSize(true);
        mFragmentProductsFindBinding.rvProdList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mFragmentProductsFindBinding.rvProdList.setAdapter(mAdapterProductos);
    }

    @Override
    public void hideReciclerViewData() {
        mAdapterProductos=null;
        mFragmentProductsFindBinding.rvProdList.setVisibility(View.GONE);
    }
}