package com.oculogx.gfi_ui.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by charu on 4/3/18.
 */

public class User {

    //TODO: Model currently matches REST API, check for changes

//    @SerializedName("url")
//    String url;

    @SerializedName("id")
    int id;

    @SerializedName("username")
    String username;

//    @SerializedName("items")
//    List<Item> items;

    public User(int id, String username){
//        this.url = url;
        this.id = id;
        this.username = username;
//        this.items = items;
    }
}
