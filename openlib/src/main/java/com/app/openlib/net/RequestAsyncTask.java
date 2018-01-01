package com.app.openlib.net;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by GetY on 2018/1/1.
 */
@Deprecated
public abstract class RequestAsyncTask extends AsyncTask<String,Void,Response> {
    @Override
    protected Response doInBackground(String... url) {
        return getResponseFormUrl(url[0]);
    }

    private Response getResponseFormUrl(String url) {
        URL url1 = null;
        try {
            url1 = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Response response = new Response();
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url1.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(10000);

        } catch (ProtocolException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
    public abstract void onSuccess(String content);
    public abstract void onFail(String errorMessage);

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected void onPostExecute(Response response) {
        if (response.hasError()){
            onFail(response.getErrorMessage());
        }else {
            onSuccess(response.getResult());
        }
    }
}
