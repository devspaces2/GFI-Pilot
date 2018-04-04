package com.oculogx.gfi_ui.models;

import java.util.List;

/**
 * Created by charu on 4/4/18.
 */

public class ItemsResponse {

    public List<Item> results;
    
    public ItemsResponse(List<Item> results){
        this.results = results;
    }

}
