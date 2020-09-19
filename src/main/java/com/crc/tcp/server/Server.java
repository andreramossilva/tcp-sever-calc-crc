package com.crc.tcp.server;

import com.crc.tcp.client.ClientHandler;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static ArrayList<ClientHandler> clients = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws Exception {

        ServerSocket listener = new ServerSocket(9000);
        System.out.println("server listening on port 9000");

        while (true) {
            final Socket client = listener.accept();
            ClientHandler clientThread = new ClientHandler(client);
            clients.add(clientThread);
            pool.execute(clientThread);
        }

    }
}

