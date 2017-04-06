package multiplayerpong.Networking.HostClientThreads;

import java.io.PrintWriter;
import java.net.Socket;
import multiplayerpong.Init;
import static multiplayerpong.Networking.HostClientSetup.*;

public class ClientScore implements Runnable {
    private Thread thread;
    
    @Override
    public void run() {
        
        try {
            clientScoreSocket = new Socket ("localHost", clientScorePort);
            clientScoreWriter = new PrintWriter(clientScoreSocket.getOutputStream(),true);
            
            while(Init.gameRunning) {
                clientScoreWriter.println("test");
                thread.sleep((int) frameTimeMS);
            }
        } 
        catch (Exception e) {
            System.out.println("clientScore.java: " + e);
        }
    }
    
    public void start() {
        if (thread == null) {
            thread = new Thread (this, "clientScoreThread");
            thread.start();
        }
    }
    
}
