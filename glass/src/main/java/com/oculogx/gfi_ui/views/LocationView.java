package com.oculogx.gfi_ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.oculogx.gfi_ui.R;
import com.oculogx.gfi_ui.models.Item;

/**
 * @since 3/16/18.
 */

public class LocationView extends FrameLayout {

    private TextView location1;
    private TextView location2;
    private TextView location3;

    private TextView upc;
    private TextView description;
    private TextView packSize;

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
        inflate(getContext(), R.layout.card_item, this);

        // bind views
        location1 = (TextView) findViewById(R.id.location_card_location1);
        location2 = (TextView) findViewById(R.id.location_card_location2);
        location3 = (TextView) findViewById(R.id.location_card_location3);
        upc = (TextView) findViewById(R.id.location_card_upc);
        description = (TextView) findViewById(R.id.location_card_description);
        packSize = (TextView) findViewById(R.id.location_card_pack_size);
    }

    public void setItem(Item item) {
        // Set data here (ie. object model info here)
    }
}
