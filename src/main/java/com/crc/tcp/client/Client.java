package com.crc.tcp.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 9000);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyBoard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        System.out.print("message: ");
        String data = keyBoard.readLine();

        out.println(data);

        String serverResponse = input.readLine();
        System.out.println(serverResponse);

        out.close();
        keyBoard.close();
        input.close();

    }
}
