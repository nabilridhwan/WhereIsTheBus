package com.nabil.whereisthebus.Fetchers;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;

import com.nabil.whereisthebus.R;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FetchBusArrival extends AsyncTask<Void, Void, String> {

    String BUS_STOP_CODE = null;
    String ENDPOINT = null;
    Activity ACTIVITY = null;

    public FetchBusArrival(String busStopCode, Activity _activity){
        this.BUS_STOP_CODE = busStopCode;
        this.ENDPOINT = "https://arrivelah.herokuapp.com/?id=" + this.BUS_STOP_CODE;
        this.ACTIVITY = _activity;
    }

    @Override
    protected String doInBackground(Void... voids) {
        String return_value = null;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(ENDPOINT)
                .build();

        try{
            Response response = client.newCall(request).execute();
            return_value = response.body().string();
        }catch(IOException e){
            e.printStackTrace();
        }

        return return_value;
    }

    @Override
    protected void onPostExecute(String s) {
        if(s != null){
            ((TextView) (ACTIVITY.findViewById(R.id.displayInfo))).setText(s);
        }
    }
}
