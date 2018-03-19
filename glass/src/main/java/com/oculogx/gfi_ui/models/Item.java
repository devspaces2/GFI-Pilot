package com.oculogx.gfi_ui.models;

/**
 * Created by charu on 3/18/18.
 */

public class Item {

    // TODO: Change Item Models to fit REST API Item Object
    // TODO: Overload Item constructor
    public int num;
    public String upc;
    public String description;
    public int aisle;
    public String slot;
    public int slotseq;

    public String primaryImageURL;
    public String secondaryImageURL;

    public Item(int itemNumber, String upc, String description, int aisle, String slot, int slotseq) {
        this.num = itemNumber;
        this.upc = upc;
        this.description = description;
        this.aisle = aisle;
        this.slot = slot;
        this.slotseq = slotseq;
    }
}
