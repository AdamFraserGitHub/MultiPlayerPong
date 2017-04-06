package multiplayerpong.Networking.HostClientThreads;

import java.io.PrintWriter;
import java.net.Socket;
import multiplayerpong.Init;
import static multiplayerpong.Networking.HostClientSetup.*;

public class HostPaddleY implements Runnable {
    private Thread thread;
    
    @Override
    public void run() {
        
        try {
            hostPaddleYSocket = new Socket ("localHost", hostPaddleYPort);
            hostPaddleYWriter = new PrintWriter(hostPaddleYSocket.getOutputStream(),true);
            
            while(Init.gameRunning) {
                hostPaddleYWriter.println("test");
                thread.sleep((int) frameTimeMS);
            }
        } 
        catch (Exception e) {
            System.out.println("hostPaddleY.java: " + e);
        }
    }
    
    public void start() {
        if (thread == null) {
            thread = new Thread (this, "hostPaddleYThread");
            thread.start();
        }
    }
    
}
