package com.oculogx.gfi_ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.oculogx.gfi_ui.LocationActivity;
import com.oculogx.gfi_ui.R;
import com.oculogx.gfi_ui.models.Item;

/**
 * Custom view for displaying an item with Location information. Used in {@link LocationActivity}
 *
 * @since 3/16/18.
 */

public class LocationView extends FrameLayout {

    private TextView aisleView;
    private TextView slotView;

    private TextView upcView;
    private TextView descriptionView;
    private TextView packSizeView;

    public LocationView(Context context) {
        super(context);
        bindViews();
    }

    public LocationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        bindViews();
    }

    private void bindViews() {
        // inflate the layout
        inflate(getContext(), R.layout.card_location, this);

        // bind views
        aisleView = (TextView) findViewById(R.id.location_card_aisle);
        slotView = (TextView) findViewById(R.id.location_card_slot);
        upcView = (TextView) findViewById(R.id.location_card_upc);
        descriptionView = (TextView) findViewById(R.id.location_card_description);
        packSizeView = (TextView) findViewById(R.id.location_card_pack_size);
    }

    public void setItem(Item item) {
        // bind data here
        aisleView.setText(String.valueOf(item.aisle));
        slotView.setText(item.slot);
        upcView.setText(item.upc);
        descriptionView.setText(item.description);
        packSizeView.setText(item.packsize);
    }
}
