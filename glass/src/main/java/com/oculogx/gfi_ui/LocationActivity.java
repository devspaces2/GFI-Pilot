package com.oculogx.gfi_ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.glass.touchpad.Gesture;
import com.google.android.glass.touchpad.GestureDetector;
import com.oculogx.gfi_ui.models.Item;
import com.oculogx.gfi_ui.models.ItemManager;
import com.oculogx.gfi_ui.utils.ListUtil;
import com.oculogx.gfi_ui.views.LocationView;

import java.util.List;

/**
 * Custom activity to display items with Location information.
 * <p>
 * Created by charu on 3/18/18.
 */

public class LocationActivity extends Activity implements GestureDetector.BaseListener {

    public static final String EXTRA_INDEX = "com.oculogx.gfi_ui.LocationActivity.EXTRA_INDEX";

    private LocationView locationView;
    private GestureDetector gestureDetector;
    private List<Item> items;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.activity_location);
        locationView = (LocationView) findViewById(R.id.location_view);

        items = ItemManager.getInstance().getItems();
        Item item = ListUtil.getIndex(items, index);
        locationView.setItem(item != null ? item : items.get(0));

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
            case TAP:
                // Start location activity for given item
                Intent intent = new Intent(this, ItemActivity.class);
                intent.putExtra(EXTRA_INDEX, index);
                startActivity(intent);
                return true;
            case SWIPE_DOWN:
                // Dismiss
                finish();
                return true;
            default:
                return false;
        }
        Item newItem = ListUtil.getIndex(items, index);
        if (newItem != null) {
            locationView.setItem(newItem);
        }
        return true;
    }
}
