package com.fileexplorer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.OutputStream;
import java.io.File;

public class SimpleFTPServer extends Thread {
    private int port;
    private File rootDir;
    private boolean running = true;
    private ServerSocket serverSocket;

    public SimpleFTPServer(int port, File rootDir) {
        this.port = port;
        this.rootDir = rootDir;
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(port);
            while (running) {
                Socket client = serverSocket.accept();
                OutputStream os = client.getOutputStream();
                String msg = "220 Simple FTP Server Ready\r\n";
                os.write(msg.getBytes());
                os.flush();
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopServer() {
        running = false;
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}