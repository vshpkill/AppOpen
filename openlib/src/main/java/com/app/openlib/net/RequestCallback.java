package com.app.openlib.net;

/**
 * Created by GetY on 2018/1/1.
 */

public abstract class RequestCallback {
    public abstract void onSuccess(String content);
    public abstract void onFail(String errorMessage);
}
