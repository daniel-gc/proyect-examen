package com.project.liverpool.application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.project.liverpool.utils.IBackHandler;
import com.project.liverpool.utils.SpinnerLoading;

public abstract class BaseFragment extends Fragment {
    protected IBackHandler backHandler;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
        if (getActivity() instanceof IBackHandler) {
            backHandler = (IBackHandler) getActivity();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        backHandler.setFragment(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getFragmentLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void injectDependencies() {
    }

    protected abstract int getFragmentLayout();

    public boolean onBackPressed() {
        return false;
    }

    public void showCustomProgressBar(String message,Boolean isCancelable){
        SpinnerLoading.show(getContext(),message,isCancelable);
    }

    public void hideCustomProgressBar(){
        SpinnerLoading.hide();
    }

}
