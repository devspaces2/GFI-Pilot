package com.oculogx.gfi_ui;

import com.google.android.glass.media.Sounds;
import com.google.android.glass.widget.CardBuilder;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;
import com.oculogx.gfi_ui.cards.ItemCard;
import com.oculogx.gfi_ui.models.Item;
import com.oculogx.gfi_ui.views.ItemView;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;

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
public class MainActivity extends Activity {

    private ItemView itemView;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.activity_main);
        itemView = (ItemView) findViewById(R.id.item_view);
        Item item = new Item(9793, "_________________________", "CUPCAKES MINI PARVE", "ABC 123");
        itemView.setItem(item);
    }

    /**
     * Builds a Glass styled "Hello World!" view using the {@link CardBuilder} class.
     */
    private View buildView() {
        ItemCard itemCard = new ItemCard();
        Item item = new Item(9793, "123 UPC", "CUPCAKES MINI PARVE", "ABC 123");

        itemCard.setData(item);

        return itemCard.inflate(new CardBuilder(this, CardBuilder.Layout.EMBED_INSIDE));
    }

}
