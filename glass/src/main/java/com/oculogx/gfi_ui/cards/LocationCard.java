package com.oculogx.gfi_ui.cards;

import android.view.View;
import android.widget.TextView;

import com.google.android.glass.widget.CardBuilder;
import com.oculogx.gfi_ui.R;

/**
 * @since 3/16/18.
 */

public class LocationCard {

    private TextView location1;
    private TextView location2;
    private TextView location3;

    private TextView upc;
    private TextView description;
    private TextView packSize;


    public View inflate(CardBuilder cardBuilder) {
        // inflate the layout
        cardBuilder.setEmbeddedLayout(R.layout.card_item);
        View view = cardBuilder.getView();

        // bind views
        location1 = (TextView) view.findViewById(R.id.location_card_location1);
        location2 = (TextView) view.findViewById(R.id.location_card_location2);
        location3 = (TextView) view.findViewById(R.id.location_card_location3);
        upc = (TextView) view.findViewById(R.id.location_card_upc);
        description = (TextView) view.findViewById(R.id.location_card_description);
        packSize = (TextView) view.findViewById(R.id.location_card_pack_size);

        return view;
    }

    public void setData() {
        // Set data here (ie. object model info here)
    }
}
