package com.oculogx.gfi_ui.serverapi;

import android.util.Log;

import com.oculogx.gfi_ui.models.Item;
import com.oculogx.gfi_ui.models.User;

import org.apache.http.protocol.HttpRequestInterceptorList;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.HttpException;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by charu on 3/22/18.
 */

public class ServiceGenerator {

    private static final String API_BASE_URL = "24.72.148.200";
    private static final String TAG = ServiceGenerator.class.getSimpleName();

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static OculogxClient OculogxClient;

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(
                            GsonConverterFactory.create()
                    );

    private static Retrofit retrofit =
            builder
                    .client(
                            httpClient.build()
                    )
                    .build();

    public static <S> S createService(Class<S> serviceClass){
        // Create a very simple REST adaptor which points to the API_BASE_URL
        return retrofit.create(serviceClass);
    }

//    public ServiceGenerator(){
//
//        // Fetch an list of items
//        Call<Item> call = OculogxClient.getItem(3);
//
//        User user = new User(4, "sumanbangalore");
//
//        call.enqueue(new Callback<Item>() {
//                         @Override
//                         public void onResponse(Call<Item> call, Response<Item> response) {
//
//                             Log.d(TAG, "2");
//                         }
//
//                         @Override
//                         public void onFailure(Call<Item> call, Throwable t) {
//
//                         }
//    }

//    public static OculogxClient getAPI() {
//        if (OculogxClient == null) {
//            OculogxClient = new Retrofit.Builder()
//                    .baseUrl(API_BASE_URL)
//                    .build()
//                    .create(OculogxClient.class);
//        }
//        return OculogxClient;
//    }

}
