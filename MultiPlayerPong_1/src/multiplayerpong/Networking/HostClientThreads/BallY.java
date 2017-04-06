package multiplayerpong.Networking.HostClientThreads;

import java.io.PrintWriter;
import java.net.Socket;
import multiplayerpong.Init;
import static multiplayerpong.Networking.HostClientSetup.*;

public class BallY implements Runnable {
    private Thread thread;
    
    @Override
    public void run() {
        
        try {
            ballYSocket = new Socket ("localHost", ballYPort);
            ballYWriter = new PrintWriter(ballYSocket.getOutputStream(),true);
            
            while(Init.gameRunning) {
                ballYWriter.println("test");
                thread.sleep((int) frameTimeMS);
            }
        } 
        catch (Exception e) {
            System.out.println("ballY.java: " + e);
        }
    }
    
    public void start() {
        if (thread == null) {
            thread = new Thread (this, "ballYThread");
            thread.start();
        }
    }
    
}
