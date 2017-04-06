package multiplayerpong.Networking.ClientClientThreads;
import java.io.PrintWriter;
import java.net.Socket;
import multiplayerpong.Init;
import static multiplayerpong.Networking.ClientClientSetup.*;

public class ClientName implements Runnable {
    private Thread thread;
    
    @Override
    public void run() {
        
        try {
            clientNameSocket = new Socket ("localHost", clientNamePort);
            clientNameWriter = new PrintWriter(clientNameSocket.getOutputStream(),true);
            
            if(Init.gameRunning) {
                clientNameWriter.println("test");
                thread.sleep((int) frameTimeMS);
            }
        } 
        catch (Exception e) {
            System.out.println("ClientName.java: " + e);
        }
    }
    
    public void start() {
        if (thread == null) {
            thread = new Thread (this, "clientNameThread");
            thread.start();
        }
    }
    
}