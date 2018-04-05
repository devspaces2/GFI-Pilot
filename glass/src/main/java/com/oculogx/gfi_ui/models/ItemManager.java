package com.oculogx.gfi_ui.models;

import com.oculogx.gfi_ui.utils.MockObjectUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton to handle item data between both Activities.
 *
 * Created by charu on 3/18/18.
 */

public class ItemManager {

    private List<Item> items;
    private static ItemManager manager;

    private ItemManager() {
        items = new ArrayList<Item>();
    }

    public static ItemManager getInstance() {
        if(manager == null) {
            manager = new ItemManager();
        }
        return manager;
    }

    public static boolean hasItems() {
        return manager != null && manager.items != null && manager.items.size() > 0;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        if (items == null) {
            items = new ArrayList<Item>();
//            items = MockObjectUtil.generateItemList();
        }
        return items;
    }


}
