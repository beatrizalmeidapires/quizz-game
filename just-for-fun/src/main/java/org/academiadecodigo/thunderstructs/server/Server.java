package org.academiadecodigo.thunderstructs.server;

import org.academiadecodigo.thunderstructs.Menu;
import org.academiadecodigo.thunderstructs.enter.UserRegister;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public final static int DEFAULT_PORT = 8080;


    public void start(int port) {

        try {

            // Bind to local port
            System.out.println("Binding to port " + port + ", please wait  ...");
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started: " + serverSocket);

            while (true) {

                // Block waiting for client connections
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client accepted: " + clientSocket);

                // Serve the client connection with a new Thread
                Thread thread = new Thread();
                thread.start();
            }

        } catch (IOException e) {
            System.out.println("Unable to start server on port " + port);
        }
    }

    public static void main(String[] args) {

        int port = DEFAULT_PORT;

        try {

            if (args.length > 0) {
                port = Integer.parseInt(args[0]);
            }

            Server chatServer = new Server();
            chatServer.start(port);

        } catch (NumberFormatException ex) {

            System.exit(1);

        }
    }
}




