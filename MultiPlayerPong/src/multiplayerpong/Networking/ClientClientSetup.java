package multiplayerpong.Networking;

import java.io.PrintWriter;
import java.net.Socket;
import multiplayerpong.Init;
import multiplayerpong.Networking.ClientClientThreads.*;

public class ClientClientSetup {

    public static int frameTimeMS = 1000/Init.fps;    
    public static int clientPaddleYPort, clientNamePort;
    public static Socket clientPaddleYSocket, clientNameSocket;
    public static PrintWriter clientPaddleYWriter, clientNameWriter;
    
    public ClientClientSetup(int clientNamePort, int clientPaddleYPort) {
        this.clientPaddleYPort = clientPaddleYPort;
        this.clientNamePort = clientNamePort;
    }
    
    public void setup() {
       ClientPaddleY clientPaddleYThread = new ClientPaddleY();
       clientPaddleYThread.start();
       
       ClientName clientNameThread = new ClientName();
       clientNameThread.start();
    }
}
