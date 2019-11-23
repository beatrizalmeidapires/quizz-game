package org.academiadecodigo.thunderstructs.server;

import java.io.*;
import java.net.Socket;

public class Server {

    public final static int DEFAULT_PORT = 8080;

    public static void main(String[] args) {

    }

    private class ServerWorker implements Runnable {

       private String name;
       private Socket clientSocket;
       private BufferedReader in;
       private BufferedWriter out;

        private ServerWorker(String name, Socket clientSocket) throws IOException {
            this.name = name;
            this.clientSocket = clientSocket;
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        }

        //@Override
        public void run() {
        }
    }
}
