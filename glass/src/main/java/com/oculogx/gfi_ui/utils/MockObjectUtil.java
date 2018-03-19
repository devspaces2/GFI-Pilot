package com.oculogx.gfi_ui.utils;

import com.oculogx.gfi_ui.models.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom object to generate mock data before we hook up the Rest API
 *
 * Created by charu on 3/18/18.
 */

public class MockObjectUtil {

    // TODO: Fix location generation
    public static List<Item> generateItemList() {
        ArrayList<Item> items = new ArrayList<Item>();
        Item item = new Item(9793, "_________________________", "CUPCAKES MINI PARVE", "1CS/13", 32, "06B06", 1212);
        item.primaryImageURL = "https://i.pinimg.com/originals/3a/cc/57/3acc578e2f2683eb0da30f5f27163de5.jpg";

        Item item2 = new Item(1234, "AU-9641_M", "MAD MAX CUPCAKES", "1CS/13", 12, "B0223f", 3455);
        item2.primaryImageURL = "https://i.ytimg.com/vi/hEJnMQG9ev8/maxresdefault.jpg";

        Item item3 = new Item(5693, "_________________________", "MOUNTAIN DEW CUPCAKES", "1CS/13", 500, "B000DR", 9948);
        item3.primaryImageURL = "https://www.dollargeneral.com/media/catalog/product/cache/image/700x700/e9c3970ab036de70892d86c6d221abfe/0/0/00012000504082_0.jpg";

        items.add(item);
        items.add(item2);
        items.add(item3);

        return items;
    }

}
