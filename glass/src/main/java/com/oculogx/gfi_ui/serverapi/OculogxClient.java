package com.oculogx.gfi_ui.serverapi;

import com.oculogx.gfi_ui.models.Item;
import com.oculogx.gfi_ui.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by charu on 3/22/18.
 */

public interface OculogxClient {



    ///////////////////// GET METHODS ////////////////////
    @GET("items")
    Call<List<Item>> getItems(@Query("num") int num);
//            , @Query("upc") String upc, @Query("description") String description,
//                              @Query("packsize") String packsize, @Query("aisle") int aisle, @Query("slot") String slot,
//                              @Query("slotseq") int slotseq);

    @GET("items/{id}")
    Call<Item> getItem(@Path("id") int num);

    @GET("users/")
    Call<List<User>> getUsers(@Query("num") int num);

    @GET("users/{id}")
    Call<User> getUser(@Path("id") int id);



    // PUT METHODS
    @PUT("items/{id}")
    Call<Void> putItem(@Body Item item);

    @PUT("users/{id}")
    Call<Void> putUser(@Body User user);



    // POST METHODS
    @POST("items/new")
    Call<Item> postItem(@Body Item item);

    @POST("users/new")
    Call<User> postUser(@Body User user);

}