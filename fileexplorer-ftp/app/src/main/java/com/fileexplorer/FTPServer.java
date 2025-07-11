package com.fileexplorer;

import android.os.Environment;
import java.io.File;

public class FTPServer {
    private SimpleFTPServer ftp;

    public void start() {
        File root = Environment.getExternalStorageDirectory();
        ftp = new SimpleFTPServer(2121, root);
        ftp.start();
    }

    public void stop() {
        if (ftp != null) ftp.stopServer();
    }
}