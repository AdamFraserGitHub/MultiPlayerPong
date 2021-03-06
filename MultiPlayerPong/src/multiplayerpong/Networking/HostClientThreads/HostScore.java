package multiplayerpong.Networking.HostClientThreads;

import java.io.PrintWriter;
import java.net.Socket;
import multiplayerpong.Init;
import static multiplayerpong.Networking.HostClientSetup.*;

public class HostScore implements Runnable {
    private Thread thread;
    
    @Override
    public void run() {
        
        try {
            hostScoreSocket = new Socket ("localHost", hostScorePort);
            hostScoreWriter = new PrintWriter(hostScoreSocket.getOutputStream(),true);
            
            while(Init.gameRunning) {
                hostScoreWriter.println("test");
                thread.sleep((int) frameTimeMS);
            }
        } 
        catch (Exception e) {
            System.out.println("hostScore.java: " + e);
        }
    }
    
    public void start() {
        if (thread == null) {
            thread = new Thread (this, "hostScoreThread");
            thread.start();
        }
    }
    
}
