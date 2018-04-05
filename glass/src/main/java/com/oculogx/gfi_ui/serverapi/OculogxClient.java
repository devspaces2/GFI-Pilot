package com.oculogx.gfi_ui.serverapi;

import com.oculogx.gfi_ui.models.Item;
import com.oculogx.gfi_ui.models.ItemsResponse;
import com.oculogx.gfi_ui.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by charu on 3/22/18.
 */

public interface OculogxClient {


    ///////////////////// GET METHODS ////////////////////
    @GET("items")
    Call<ItemsResponse> getItems();

    @GET("items/{id}")
    Call<Item> getItem(@Path("id") int id);

    @GET("users")
    Call<List<User>> getUsers();

    @GET("users/{id}")
    Call<User> getUser(@Path("id") int id);


    ///////////////////// PUT METHODS ////////////////////
    @PUT("items/{id}")
    Call<Void> putItem(@Path("id") int id, @Body Item item);

    @PUT("users/{id}")
    Call<Void> putUser(@Path("id") int id, @Body User user);



    ///////////////////// POST METHODS ////////////////////
    @POST("items/new")
    Call<Item> postItem(@Body Item item);

    @POST("users/new")
    Call<User> postUser(@Body User user);

}