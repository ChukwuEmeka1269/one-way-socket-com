package org.rexco.client;


public class Client {
    public static void main(String[] args) {
        SocketClient.connectToServer("localhost", 6666);
    }
}
