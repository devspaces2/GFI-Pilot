package com.oculogx.gfi_ui.serverapi;

import retrofit2.Retrofit;

/**
 * Created by charu on 3/22/18.
 */

public class APIProvider {

    private static API API;

    public static API getAPI() {
        if (API == null) {
            API = new Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .build()
                    .create(API.class);
        }
        return API;
    }

}
