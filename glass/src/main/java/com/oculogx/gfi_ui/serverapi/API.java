package com.oculogx.gfi_ui.serverapi;

import com.oculogx.gfi_ui.models.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by charu on 3/22/18.
 */

public interface API {

    @GET("items")
    Call<List<Item>> getItems();

    @GET("items/{id}")
    Call<Item> getItem(@Path("id") String itemID);
}