package com.oculogx.gfi_ui.command;

import java.lang.ref.WeakReference;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by charu on 4/4/18.
 */

public abstract class AbstractCommand<Type> implements Command, Callback<Type> {

    public interface CommandListener {
        // no op. marking interface. Inherited listeners should implement
    }

    private WeakReference<CommandListener> listenerWeakReference;
    private boolean isCancelled;

    public AbstractCommand(CommandListener listener) {
        this.listenerWeakReference = new WeakReference<CommandListener>(listener);
    }

    /**
     * ABSTRACT METHODS
     */

    protected abstract void onExecute();
    public abstract void onSuccess(Type responseData);
    public abstract void onFailure(ResponseBody error);

    /**
     * COMMAND METHODS
     */

    @Override
    public void execute() {
        onExecute();
    }

    @Override
    public void cancel() {
        isCancelled = true;
        listenerWeakReference.clear();
    }

    /**
     * CALLBACK METHODS
     */

    @Override
    public void onResponse(Call<Type> call, Response<Type> response) {
        if (!isCancelled) {
            if (response != null && response.isSuccessful() && response.body() != null) {
                onSuccess(response.body());
            } else {
                onFailure(response.errorBody());
            }
        }
    }

    @Override
    public void onFailure(Call<Type> call, Throwable t) {
        onFailure(null);
    }

    /**
     * UTILITY METHODS
     */

    protected CommandListener getListener() {
        if (listenerWeakReference != null) {
            return listenerWeakReference.get();
        }
        return null;
    }
}
