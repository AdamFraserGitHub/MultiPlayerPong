package multiplayerpong.Networking.HostClientThreads;

import java.io.PrintWriter;
import java.net.Socket;
import multiplayerpong.Init;
import static multiplayerpong.Networking.HostClientSetup.*;

public class HostName implements Runnable {
    private Thread thread;
    
    @Override
    public void run() {
        
        try {
            hostNameSocket = new Socket ("localHost", hostNamePort);
            hostNameWriter = new PrintWriter(hostNameSocket.getOutputStream(),true);
            
            while(Init.gameRunning) {
                hostNameWriter.println("test");
                thread.sleep((int) frameTimeMS);
            }
        } 
        catch (Exception e) {
            System.out.println("hostName.java: " + e);
        }
    }
    
    public void start() {
        if (thread == null) {
            thread = new Thread (this, "hostNameThread");
            thread.start();
        }
    }
    
}
