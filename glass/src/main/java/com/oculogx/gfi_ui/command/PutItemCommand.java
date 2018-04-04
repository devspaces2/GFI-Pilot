package com.oculogx.gfi_ui.command;

import com.oculogx.gfi_ui.models.Item;
import com.oculogx.gfi_ui.serverapi.OculogxClient;
import com.oculogx.gfi_ui.serverapi.ServiceGenerator;

import java.util.List;

import okhttp3.ResponseBody;

/**
 * Created by charu on 4/4/18.
 */

public class PutItemCommand extends AbstractCommand<Void> {

    public interface PutItemCommandListener extends CommandListener {
        void onPutItemSuccess();
        void onPutItemFailure(ResponseBody error);
    }

    private int id;
    private Item item;

    public PutItemCommand(PutItemCommandListener listener, int id, Item item) {
        super(listener);
        this.id = id;
        this.item = item;
    }

    @Override
    protected void onExecute() {
        OculogxClient client = ServiceGenerator.getClient();
        client.putItem(id, item).enqueue(this);
    }

    @Override
    public void onSuccess(Void responseData) {
        PutItemCommandListener listener = (PutItemCommandListener) getListener();
        if (listener != null) {
            listener.onPutItemSuccess();
        }
    }

    @Override
    public void onFailure(ResponseBody error) {
        PutItemCommandListener listener = (PutItemCommandListener) getListener();
        if (listener != null) {
            listener.onPutItemFailure(error);
        }
    }
}
