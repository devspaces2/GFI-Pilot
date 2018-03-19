package com.oculogx.gfi_ui.utils;

import java.util.List;

/**
 * Created by charu on 3/18/18.
 */

public class ListUtil {

    public static <T> T getIndex(List<T> list, int newIndex) {
        if(0 <= newIndex && newIndex < list.size()) {
            return list.get(newIndex);
        }
        return null;
    }

}
