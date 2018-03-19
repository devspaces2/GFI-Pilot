package com.oculogx.gfi_ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.glass.touchpad.Gesture;
import com.google.android.glass.touchpad.GestureDetector;
import com.google.android.glass.widget.CardScrollView;
import com.oculogx.gfi_ui.models.Item;
import com.oculogx.gfi_ui.utils.ListUtil;
import com.oculogx.gfi_ui.utils.MockObjectUtil;
import com.oculogx.gfi_ui.views.ItemView;

import java.util.List;

/**
 * An {@link Activity} showing a tuggable "Hello World!" card.
 * <p>
 * The main content view is composed of a one-card {@link CardScrollView} that provides tugging
 * feedback to the user when swipe gestures are detected.
 * If your Glassware intends to intercept swipe gestures, you should set the content view directly
 * and use a {@link com.google.android.glass.touchpad.GestureDetector}.
 *
 * @see <a href="https://developers.google.com/glass/develop/gdk/touch">GDK Developer Guide</a>
 */
public class MainActivity extends Activity implements GestureDetector.BaseListener {

    // TODO: Add function to solidify location
    private ItemView itemView;

    List<Item> items;
    private int index;

    GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.activity_main);
        itemView = (ItemView) findViewById(R.id.item_view);
        items = MockObjectUtil.generateItemList();
        itemView.setItem(items.get(0));

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
                // Go to location
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
            itemView.setItem(newItem);
        }
        return true;
    }
}
