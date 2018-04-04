package com.oculogx.gfi_ui.command;

import com.oculogx.gfi_ui.models.Item;
import com.oculogx.gfi_ui.models.User;
import com.oculogx.gfi_ui.serverapi.OculogxClient;
import com.oculogx.gfi_ui.serverapi.ServiceGenerator;

import java.util.List;

import okhttp3.ResponseBody;

/**
 * Created by charu on 4/4/18.
 */

public class GetUsersCommand extends AbstractCommand<List<User>> {

    public interface GetUsersCommandListener extends CommandListener {
        void onGetUsersSuccess(List<User> users);

        void onGetUsersFailure(ResponseBody error);
    }

    public GetUsersCommand(GetUsersCommand.GetUsersCommandListener listener) {
        super(listener);
    }

    @Override
    protected void onExecute() {
        OculogxClient client = ServiceGenerator.getClient();
        client.getUsers().enqueue(this);
    }

    @Override
    public void onSuccess(List<User> responseData) {
        GetUsersCommand.GetUsersCommandListener listener = (GetUsersCommand.GetUsersCommandListener) getListener();
        if (listener != null) {
            listener.onGetUsersSuccess(responseData);
        }
    }

    @Override
    public void onFailure(ResponseBody error) {
        GetUsersCommand.GetUsersCommandListener listener = (GetUsersCommand.GetUsersCommandListener) getListener();
        if (listener != null) {
            listener.onGetUsersFailure(error);
        }
    }
}
