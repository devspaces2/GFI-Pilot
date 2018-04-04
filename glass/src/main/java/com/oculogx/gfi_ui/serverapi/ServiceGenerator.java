package com.oculogx.gfi_ui.serverapi;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by charu on 3/22/18.
 */

public class ServiceGenerator {

    private static final String API_BASE_URL = "http://192.168.1.142";
    private static final String TAG = "com.oculogx.gfi_ui.serverapi.ServiceGenerator";

    private static OculogxClient client;

    public static OculogxClient getClient() {
        if (client == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(new OkHttpClient.Builder().build())
                    .build();

            client = retrofit.create(OculogxClient.class);
        }
        return client;
    }
}
