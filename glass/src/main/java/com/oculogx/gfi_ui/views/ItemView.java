package com.oculogx.gfi_ui.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.oculogx.gfi_ui.ItemActivity;
import com.oculogx.gfi_ui.R;
import com.oculogx.gfi_ui.models.Item;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Custom view to display an item. Used in {@link ItemActivity}
 *
 * Created by charu on 3/18/18.
 */

public class ItemView extends FrameLayout {

    // TODO: Change bindViews and setItem to match new Item model
    // TODO: Change slot + aisle in locationview
    // TODO: Change slot + aisle color

    @BindView(R.id.item_card_item_id)
    TextView itemIDView;

    @BindView(R.id.item_card_upc)
    TextView upcView;

    @BindView(R.id.item_card_description)
    TextView descriptionView;

    @BindView(R.id.item_card_aisle)
    TextView aisleView;

    @BindView(R.id.item_card_slot)
    TextView slotView;

    @BindView(R.id.item_card_image1)
    ImageView imageView1;

    @BindView(R.id.item_card_image2)
    ImageView imageView2;

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
        ButterKnife.bind(this);
    }

    public void setItem(Item item) {
        // bind data here
        itemIDView.setText(String.valueOf(item.num));
        upcView.setText(item.upc);
        descriptionView.setText(item.description);
        aisleView.setText(String.valueOf(item.aisle));
        slotView.setText(item.slot);
        setImage(item.primaryImageURL, imageView1);
        setImage(item.secondaryImageURL, imageView2);
    }

    private void setImage(String url, ImageView imageView) {
        if(url != null && !TextUtils.isEmpty(url)) {
            Picasso.with(getContext()).load(url).into(imageView);
        } else {
            // Put default image res here
            imageView.setImageResource(android.R.drawable.ic_menu_camera);
        }
    }
}
