package multiplayerpong.Networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import multiplayerpong.Networking.ClientServerThreads.*;

public class ClientServerSetup {
    int ballXPort, ballYPort, hostPaddleYPort, clientScorePort, hostScorePort, hostNamePort;
    
    public static ServerSocket ballXSocket, ballYSocket, hostPaddleYSocket, clientScoreSocket, hostScoreSocket, hostNameSocket;
    public static Socket ballXClientSocket, ballYClientSocket, hostPaddleYClientSocket, clientScoreClientSocket, hostScoreClientSocket, hostNameClientSocket;
    public static BufferedReader ballXReader, ballYReader, hostPaddleYReader, clientScoreReader, hostScoreReader, hostNameReader;
    public static String ballXInput, ballYInput, hostPaddleYInput, clientScoreInput, hostScoreInput, hostNameInput;
    
    public ClientServerSetup(int ballXPort, int ballYPort, int hostPaddleYPort, int clientScorePort, int hostScorePort, int hostNamePort){
        this.ballXPort = ballXPort;
        this.ballYPort = ballYPort;
        this.hostPaddleYPort = hostPaddleYPort;
        this.clientScorePort = clientScorePort;
        this.hostScorePort = hostScorePort;
        this.hostNamePort = hostNamePort;
    }
    
    public void setup(){
        
        try{
            ballXSocket = new ServerSocket(ballXPort);
            ballYSocket = new ServerSocket(ballYPort);
            hostPaddleYSocket = new ServerSocket(hostPaddleYPort);
            clientScoreSocket = new ServerSocket(clientScorePort);
            hostScoreSocket = new ServerSocket(hostScorePort);
            hostNameSocket = new ServerSocket(hostNamePort);
              
        } catch (IOException e){
            System.out.println("ClientServerSetup.java: " + e);
        }
        
       BallX BallXThread = new BallX();
       BallXThread.start();
       
       BallY BallYThread = new BallY();
       BallYThread.start();
       
       HostPaddleY HostPaddleYThread = new HostPaddleY();
       HostPaddleYThread.start();
       
       ClientScore ClientScoreThread = new ClientScore();
       ClientScoreThread.start();
       
       HostScore HostScoreThread = new HostScore();
       HostScoreThread.start();
       
       HostName HostNameThread = new HostName();
       HostNameThread.start();
    }
    
}