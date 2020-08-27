package com.project.liverpool.webservices;

public interface BaseCallback<T> {

    void onSuccess(T t);

    void onFailure(String messageError);

}
