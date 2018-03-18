package com.oculogx.gfi_ui.cards;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.glass.widget.CardBuilder;
import com.oculogx.gfi_ui.R;
import com.oculogx.gfi_ui.models.Item;

/**
 * @since 3/16/18.
 */

public class ItemCard {

    private Item item;

    private TextView itemIDView;
    private TextView upcView;
    private TextView descriptionView;
    private TextView locationView;
    private ImageView imageView1;
    private ImageView imageView2;

    public View inflate(CardBuilder cardBuilder) {
        // inflate the layout
        cardBuilder.setEmbeddedLayout(R.layout.card_item);
        View view = cardBuilder.getView();

        // bind views
        itemIDView = (TextView) view.findViewById(R.id.item_card_item_id);
        upcView = (TextView) view.findViewById(R.id.item_card_upc);
        descriptionView = (TextView) view.findViewById(R.id.item_card_description);
        locationView = (TextView) view.findViewById(R.id.item_card_location);
        imageView1 = (ImageView) view.findViewById(R.id.item_card_image1);
        imageView2 = (ImageView) view.findViewById(R.id.item_card_image2);

        // bind data here
        itemIDView.setText(String.valueOf(item.itemID));
        upcView.setText(item.upc);
        descriptionView.setText(item.description);
        locationView.setText(item.location);

        return view;
    }

    public void setData(Item item) {
        this.item = item;
    }

}
