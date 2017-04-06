package multiplayerpong.Networking.HostClientThreads;

import java.io.PrintWriter;
import java.net.Socket;
import multiplayerpong.Init;
import static multiplayerpong.Networking.HostClientSetup.*;

public class BallX implements Runnable {
    private Thread thread;
    
    @Override
    public void run() {
        
        try {
            ballXSocket = new Socket ("localHost", ballXPort);
            ballXWriter = new PrintWriter(ballXSocket.getOutputStream(),true);
            
            while(Init.gameRunning) {
                ballXWriter.println("test");
                thread.sleep((int) frameTimeMS);
            }
        } 
        catch (Exception e) {
            System.out.println("ballX.java: " + e);
        }
    }
    
    public void start() {
        if (thread == null) {
            thread = new Thread (this, "ballXThread");
            thread.start();
        }
    }
    
}
