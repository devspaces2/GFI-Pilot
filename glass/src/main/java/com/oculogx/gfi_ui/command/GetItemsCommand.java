package com.oculogx.gfi_ui.command;

import com.oculogx.gfi_ui.models.Item;
import com.oculogx.gfi_ui.models.ItemManager;
import com.oculogx.gfi_ui.models.ItemsResponse;
import com.oculogx.gfi_ui.serverapi.OculogxClient;
import com.oculogx.gfi_ui.serverapi.ServiceGenerator;

import java.util.List;

import okhttp3.ResponseBody;

/**
 * Created by charu on 4/4/18.
 */

public class GetItemsCommand extends AbstractCommand<ItemsResponse> {

    public interface GetItemsCommandListener extends CommandListener {
        void onGetItemsSuccess(List<Item> items);
        void onGetItemsFailure(ResponseBody error);
    }

    public GetItemsCommand(GetItemsCommandListener listener) {
        super(listener);
    }

    @Override
    protected void onExecute() {
        OculogxClient client = ServiceGenerator.getClient();
        client.getItems().enqueue(this);
    }

    @Override
    public void onSuccess(ItemsResponse responseData) {
        ItemManager.getInstance().setItems(responseData.results);
        GetItemsCommandListener listener = (GetItemsCommandListener) getListener();
        if (listener != null) {
            listener.onGetItemsSuccess(responseData.results);
        }
    }

    @Override
    public void onFailure(ResponseBody error) {
        GetItemsCommandListener listener = (GetItemsCommandListener) getListener();
        if (listener != null) {
            listener.onGetItemsFailure(error);
        }
    }
}
