package com.oculogx.gfi_ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.glass.touchpad.Gesture;
import com.google.android.glass.touchpad.GestureDetector;
import com.oculogx.gfi_ui.command.GetItemsCommand;
import com.oculogx.gfi_ui.models.Item;
import com.oculogx.gfi_ui.models.ItemManager;
import com.oculogx.gfi_ui.utils.ListUtil;
import com.oculogx.gfi_ui.views.ItemView;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;

/**
 * Custom activity to handle displaying list of items.
 *
 * TODO: Retrieve list of items from server.
 */
public class ItemActivity extends Activity implements GestureDetector.BaseListener {

    // TODO: Add function to parse location
    // TODO: In xml views, add hardcoded values to @string
    private ItemView itemView;
    private List<Item> items;
    private int index;
    private GetItemsCommand command;

    GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.activity_main);
        itemView = (ItemView) findViewById(R.id.item_view);

        index = getIntent().getIntExtra(LocationActivity.EXTRA_INDEX, 0);


        items = ItemManager.getInstance().getItems();
        Item item = ListUtil.getIndex(items, index);

        if (item == null) {
            command = new GetItemsCommand(null);
            command.execute();
        }

        itemView.setItem(item != null ? item : items.get(0));

        gestureDetector = new GestureDetector(this);
        gestureDetector.setBaseListener(this);

    }

    //Send generic motion events to the gesture detector
    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        if (gestureDetector != null) {
            return gestureDetector.onMotionEvent(event);
        }
        return false;
    }

    @Override
    public boolean onGesture(Gesture gesture) {
        switch (gesture) {
            case SWIPE_RIGHT:
                // Go to next item
                index++;
                break;
            case SWIPE_LEFT:
                // Go to previous item
                index--;
                break;
            case SWIPE_DOWN:
                // Dismiss
                finish();
                return true;
            default:
                return false;
        }
        Item newItem = ListUtil.getIndex(items, index);
        if (newItem != null) {
            itemView.setItem(newItem);
        }
        return true;
    }
}
