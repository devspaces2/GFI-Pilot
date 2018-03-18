package com.oculogx.gfi_ui.models;

/**
 * Created by charu on 3/18/18.
 */

public class Item {

    public int itemID;
    public String upc;
    public String description;
    public String location;

    public String primaryImageURL;
    public String secondaryImageURL;

    public Item(int itemNumber, String upc, String description, String location) {
        this.itemID = itemNumber;
        this.upc = upc;
        this.description = description;
        this.location = location;
    }
}
