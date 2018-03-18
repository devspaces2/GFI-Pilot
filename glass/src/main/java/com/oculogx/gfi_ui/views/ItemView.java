package com.oculogx.gfi_ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.oculogx.gfi_ui.R;
import com.oculogx.gfi_ui.models.Item;

/**
 * Created by charu on 3/18/18.
 */

public class ItemView extends FrameLayout {

    private TextView itemIDView;
    private TextView upcView;
    private TextView descriptionView;
    private TextView locationView;
    private ImageView imageView1;
    private ImageView imageView2;

    public ItemView(Context context) {
        super(context);
        bindViews();
    }

    public ItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        bindViews();
    }

    private void bindViews() {
        inflate(getContext(), R.layout.card_item, this);

        // bind views
        itemIDView = (TextView) findViewById(R.id.item_card_item_id);
        upcView = (TextView) findViewById(R.id.item_card_upc);
        descriptionView = (TextView) findViewById(R.id.item_card_description);
        locationView = (TextView) findViewById(R.id.item_card_location);
        imageView1 = (ImageView) findViewById(R.id.item_card_image1);
        imageView2 = (ImageView) findViewById(R.id.item_card_image2);
    }

    public void setItem(Item item) {
        // bind data here
        itemIDView.setText(String.valueOf(item.itemID));
        upcView.setText(item.upc);
        descriptionView.setText(item.description);
        locationView.setText(item.location);
//        Picasso.get()
//        GlideApp.with(this).load("http://goo.gl/gEgYUd").into(imageView);
    }
}
