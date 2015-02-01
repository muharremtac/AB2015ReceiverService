package com.muharremtac.ab2015receiverservice;

import android.app.Service;
import android.content.Intent;
import android.os.Debug;
import android.os.IBinder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MesajService extends Service {

    public MesajService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                URL url;
                HttpURLConnection conn;
                BufferedReader rd;
                String line;
                String result = "";
                try {
                    String urlToRead = "http://google.com";
                    url = new URL(urlToRead);
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    while ((line = rd.readLine()) != null) {
                        result += line;
                    }
                    rd.close();
                    System.out.print(result);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        super.onCreate();
    }
}
