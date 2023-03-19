package org.rexco.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerSocket {


    public static void openConnection(int port){
        java.net.ServerSocket serverSocker = null;
        try {
            System.out.println("Starting up server..................");
            System.out.println("Listening for message on port : "+ port);
            serverSocker = new java.net.ServerSocket(port);
            Socket socket = serverSocker.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String clientMessageToServer = dataInputStream.readUTF();
            System.out.println("Message = "+clientMessageToServer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(!serverSocker.isClosed()){
                try {
                    serverSocker.close();
                } catch (IOException e) {
                    System.out.println("Could not close server socket. Reason : " + e.getMessage());
                }
            }
        }
    }
}
