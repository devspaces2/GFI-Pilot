package com.oculogx.gfi_ui.command;

import com.oculogx.gfi_ui.models.Item;
import com.oculogx.gfi_ui.serverapi.OculogxClient;
import com.oculogx.gfi_ui.serverapi.ServiceGenerator;

import okhttp3.ResponseBody;

/**
 * Created by charu on 4/4/18.
 */

public class PostItemCommand extends AbstractCommand<Void> {

    private Item item;

    public PostItemCommand(CommandListener listener, Item item) {
        super(listener);
        this.item = item;
    }

    @Override
    protected void onExecute() {
        OculogxClient client = ServiceGenerator.getClient();
        client.postItem(item).enqueue(null);
    }

    @Override
    public void onSuccess(Void responseData) {
        // no op
    }

    @Override
    public void onFailure(ResponseBody error) {
        // no op
    }
}
