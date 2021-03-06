package com.oculogx.gfi_ui.models;

import android.graphics.drawable.Drawable;

/**
 * Created by charu on 3/18/18.
 */

public class Item {

    // TODO: Change Item Models to fit REST API Item Object
    // TODO: Overload Item constructor
    // TODO: Switch primaryImageURL to String not Drawable
    public int num;
    public String upc;
    public String description;
    public String packsize;
    public int aisle;
    public String slot;
    public int slotseq;

    public int primaryImageURL;
    public int secondaryImageURL;

    public Item(int itemNumber, String upc, String description, String packsize, int aisle, String slot, int slotseq) {
        this.num = itemNumber;
        this.upc = upc;
        this.description = description;
        this.packsize = packsize;
        this.aisle = aisle;
        this.slot = slot;
        this.slotseq = slotseq;
    }
}
