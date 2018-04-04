package com.oculogx.gfi_ui.command;

import com.oculogx.gfi_ui.models.Item;
import com.oculogx.gfi_ui.serverapi.OculogxClient;
import com.oculogx.gfi_ui.serverapi.ServiceGenerator;

import java.util.List;

import okhttp3.ResponseBody;

/**
 * Created by charu on 4/4/18.
 */

public class GetItemCommand extends AbstractCommand<Item> {

    public interface GetItemCommandListener extends CommandListener {
        void onGetItemSuccess(Item items);
        void onGetItemFailure(ResponseBody error);
    }

    private int id;

    public GetItemCommand(GetItemCommand.GetItemCommandListener listener, int id) {
        super(listener);
        this.id = id;
    }

    @Override
    protected void onExecute() {
        OculogxClient client = ServiceGenerator.getClient();
        client.getItem(id).enqueue(this);
    }

    @Override
    public void onSuccess(Item responseData) {
        GetItemCommand.GetItemCommandListener listener = (GetItemCommand.GetItemCommandListener) getListener();
        if (listener != null) {
            listener.onGetItemSuccess(responseData);

        }
    }

    @Override
    public void onFailure(ResponseBody error) {
        GetItemCommand.GetItemCommandListener listener = (GetItemCommand.GetItemCommandListener) getListener();
        if (listener != null) {
            listener.onGetItemFailure(error);
        }
    }
}
