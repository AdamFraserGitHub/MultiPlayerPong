package multiplayerpong.Networking.ClientClientThreads;
import java.io.PrintWriter;
import java.net.Socket;
import multiplayerpong.ClientGame;
import multiplayerpong.Init;
import static multiplayerpong.Networking.ClientClientSetup.*;

public class ClientPaddleY implements Runnable {
    private Thread thread;
    
    @Override
    public void run() {
        
        try {
            clientPaddleYSocket = new Socket ("localHost", clientPaddleYPort);
            clientPaddleYWriter = new PrintWriter(clientPaddleYSocket.getOutputStream(),true);
            
            while(Init.gameRunning) {
                clientPaddleYWriter.print(ClientGame.getPlayerPaddleY());
                thread.sleep((int) frameTimeMS);
            }
        } 
        catch (Exception e) {
            System.out.println("ClientPaddleY.java: " + e);
        }
    }
    
    public void start() {
        if (thread == null) {
            thread = new Thread (this, "ClientPaddleYThread");
            thread.start();
        }
    }
    
}