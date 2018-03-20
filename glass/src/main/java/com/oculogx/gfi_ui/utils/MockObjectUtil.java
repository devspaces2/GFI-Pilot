package com.oculogx.gfi_ui.utils;

import com.oculogx.gfi_ui.R;
import com.oculogx.gfi_ui.models.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom object to generate mock data before we hook up the Rest API
 *
 * Created by charu on 3/18/18.
 */

public class MockObjectUtil {

    public static List<Item> generateItemList() {
        ArrayList<Item> items = new ArrayList<Item>();
        Item item = new Item(300004, "______","SODA DRY GINGER ALE", "24/12 OZ", 43, "02A01", 1065);
        item.primaryImageURL = R.drawable.item1front;
        item.secondaryImageURL = R.drawable.item1side;
        //item.primaryImageURL = "https://i.pinimg.com/originals/3a/cc/57/3acc578e2f2683eb0da30f5f27163de5.jpg";

        Item item2 = new Item(92951, "______", "RIBBON CUSTOM MURRAYS 1016SP", "4/1 CT", 43, "06B01", 1355);
        item2.primaryImageURL = R.drawable.item2front;
        item2.secondaryImageURL = R.drawable.item2side;
        //item2.primaryImageURL = "https://i.ytimg.com/vi/hEJnMQG9ev8/maxresdefault.jpg";

        Item item3 = new Item(410192, "______", "BLUE HEAVEN BLUE CHEESE POWDER", "24/3 OZ", 43, "10B01", 1550);
        //item3.primaryImageURL = R.drawable.item3front;
        //item3.secondaryImageURL = R.drawable.item3side;
        //item3.primaryImageURL = "https://www.dollargeneral.com/media/catalog/product/cache/image/700x700/e9c3970ab036de70892d86c6d221abfe/0/0/00012000504082_0.jpg";

        Item item4 = new Item(60283, "______", "OLIVE MIX WHOLE GREEK UNPITTED", "6/5.6 OZ", 43, "14B03", 1840);
        //item4.primaryImageURL = R.drawable.item4front;
        //item4.secondaryImageURL = R.drawable.item4side;
        //item4.primaryImageURL = "";

        Item item5 = new Item(46078, "______","HONEY STICKS BONNE MAMAN CASE", "100/0.5 OZ", 43, "20B01", 2225);
        //item5.primaryImageURL = R.drawable.item5front;
        //item5.secondaryImageURL = R.drawable.item5side;
        //item5.primaryImageURL = "";

        Item item6 = new Item(20855, "______","CHIPS KETTLE SWEET MAUI ONION", "24/2 OZ", 44, "12A01", 2475);
        //item6.primaryImageURL = "";

        Item item7 = new Item(20850, "______", "CHIPS KETTLE SALT AND VINEGAR", "24/2 OZ", 44, "22A01", 2850);
        //item7.primaryImageURL = "";

        Item item8 = new Item(11776, "______", "MELBA TOAST 1.75 IN CT688", "688/1.75 IN", 45, "08A01", 4380);
        //item8.primaryImageURL = "";

        Item item9 = new Item(55050, "______", "WILD MUSHROOM MIX IN PAIL", "4/3.3 LB", 45, "26A02", 5900);
        //item9.primaryImageURL = "";


        items.add(item);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        items.add(item7);
        items.add(item8);
        items.add(item9);

        return items;
    }

}
