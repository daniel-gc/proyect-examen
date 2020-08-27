package com.project.liverpool.webservices;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.project.liverpool.webservices.response.ErrorResponse;
import com.project.liverpool.webservices.response.Status;

import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import javax.net.ssl.SSLException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitCallback <T> implements Callback<T> {

    private BaseCallback<T> callback;

    public RetrofitCallback(BaseCallback<T> baseCallback) {
        this.callback = baseCallback;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        String messageError="Error en el servidor remoto, por favor intente de nuevo";
        if (response.isSuccessful()) {
            callback.onSuccess(response.body());
        } else {
            try{
                String resultStatusJSON = response.errorBody().string();
                Status status = new Status();
                if (response.code() == 404 || response.code() == 503 || response.code() == 409) {

                    if (resultStatusJSON.contains("message")) {

                        // se valida y se convierte en un objeto con la respuesta de error
                        resultStatusJSON = resultStatusJSON.replace("message", "errorDescription");
                        JsonElement mJson = new JsonParser().parse(resultStatusJSON);
                        status = new Gson().fromJson(mJson, Status.class);

                        messageError=status.getErrorDescription();

                    } else if (response.errorBody() != null) {
                        messageError=resultStatusJSON;
                        JsonElement mJson = new JsonParser().parse(resultStatusJSON);
                        ErrorResponse error=new ErrorResponse();
                        error = new Gson().fromJson(mJson, ErrorResponse.class);
                        messageError=error.getStatus().getErrorDescription();
                        // se convierte en el objeto especificado

                    }

                } else if (response.errorBody() != null) {
                    // se aram de manera manual el objeto especificado para mostrar el error
                    if(resultStatusJSON.contains("message")){
                        resultStatusJSON = resultStatusJSON.replace("message", "errorDescription");
                        JsonElement mJson = new JsonParser().parse(resultStatusJSON);
                        status = new Gson().fromJson(mJson, Status.class);

                        messageError=status.getErrorDescription();
                    }else{

                        JsonElement mJson = new JsonParser().parse(resultStatusJSON);
                        ErrorResponse error=new ErrorResponse();
                        error = new Gson().fromJson(mJson, ErrorResponse.class);
                        messageError=error.getStatus().getErrorDescription();

                    }
                }
                callback.onFailure(messageError);
            }catch (Exception e) {
                e.printStackTrace();
                messageError=e.getMessage();
                callback.onFailure(messageError);
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        String messageError="Error en el servidor remoto, por favor intente de nuevo";
        if(t instanceof UnknownHostException || t instanceof SSLException || t instanceof TimeoutException
                || t instanceof SocketTimeoutException || t instanceof InterruptedIOException){
            messageError="Tu conexión a la red ha fallado, por favor intenta nuevamente";
        }

        callback.onFailure(messageError);
    }
}
