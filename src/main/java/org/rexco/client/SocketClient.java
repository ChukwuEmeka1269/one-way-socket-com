package org.rexco.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketClient {

    public static void connectToServer(String hostname, int port){
        Socket socket = null;
        DataOutputStream dataOutPutStream = null;

        try{
             socket = new Socket(hostname, port);
             dataOutPutStream = new DataOutputStream(socket.getOutputStream());
            dataOutPutStream.writeUTF("Hello Server from this side");
            dataOutPutStream.flush();

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            try {
                if(dataOutPutStream != null)
                    dataOutPutStream.close();
                if(socket != null)
                    socket.close();
            } catch (IOException e) {
                System.out.println("Error message : " + e.getMessage());
            }
        }
    }
}
