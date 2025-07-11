package com.fileexplorer;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MainService extends Service {
    private FTPServer ftpServer;

    @Override
    public void onCreate() {
        super.onCreate();
        ftpServer = new FTPServer();
        ftpServer.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        ftpServer.stop();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}