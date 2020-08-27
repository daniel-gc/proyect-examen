package com.project.liverpool.webservices;

import com.project.liverpool.webservices.response.PlpResults;
import com.project.liverpool.webservices.response.ResponseSuccess;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IServicesAPI {

    String LIST_DATA_PRODUCTS= "v3/plp";

    //USUARIO
    @GET(LIST_DATA_PRODUCTS)
    Call<ResponseSuccess> getProductosLiverpool(@Query("force-plp") Boolean forcePlp,
                                                @Query("search-string") String nameProduct,
                                                @Query("page-number") Integer numPages,
                                                @Query("number-of-items-per-page") Integer numItemsForPage);

}
