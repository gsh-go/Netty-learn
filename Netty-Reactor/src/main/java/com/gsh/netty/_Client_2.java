package com.gsh.netty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Author: gsh
 * @Date: Created in 2018/9/28 15:45
 * @Description:
 */
public class _Client_2 {

    public static void main(String[] args) {
        String hostName = "localhost";
        int port = 1234;

        System.out.println("Connecting to " + hostName + ":" + port);
        try {
            Socket client = new Socket(hostName, port);
            System.out.println("Connected to " + hostName);

            PrintWriter out = new PrintWriter(client.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String input;

            while ((input = stdIn.readLine()) != null) {
                out.println(input);
                out.flush();
                if (input.equals("exit")) {
                    break;
                }
                System.out.println("server: " + in.readLine());
            }
            client.close();
            System.out.println("client stop.");
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            System.err.println("Don't know about host: " + hostName);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println("Couldn't get I/O for the socket connection");
        }

    }


}
