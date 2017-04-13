package multiplayerpong.Networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import multiplayerpong.Networking.HostServerThreads.ClientName;
import multiplayerpong.Networking.HostServerThreads.LeftPaddleY;

public class HostServerSetup {
    int clientPaddleYPort, clientNamePort;
    
    public static ServerSocket clientPaddleYSocket, clientNameSocket;
    public static Socket clientPaddleYClientSocket, clientNameClientSocket;
    public static BufferedReader clientPaddleYReader, clientNameReader;
    public static String clientPaddleYInput, clientNameInput;
    
    public HostServerSetup(int clientPaddleYPort, int clientNamePort){
        this.clientPaddleYPort = clientPaddleYPort;
        this.clientNamePort = clientNamePort;
    }
    
    public void setup(){
        
        try{
            clientPaddleYSocket = new ServerSocket(clientPaddleYPort);
            clientNameSocket = new ServerSocket(clientNamePort);  
        } catch (IOException e){
            System.out.println("HostServerSetup.java: " + e);
        }
        
       LeftPaddleY LeftPaddleYThread = new LeftPaddleY();
       LeftPaddleYThread.start();
       
       ClientName ClientNameThread = new ClientName();
       ClientNameThread.start();
    }
}