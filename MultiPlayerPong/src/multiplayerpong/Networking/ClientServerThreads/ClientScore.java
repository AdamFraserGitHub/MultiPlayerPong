package multiplayerpong.Networking.ClientServerThreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static multiplayerpong.Networking.ClientServerSetup.*;


public class ClientScore implements Runnable{
    private Thread thread;
    
    public void run() {
        System.out.println("ClientScore Socket set up");
        try {
            clientScoreClientSocket = clientScoreSocket.accept();
            clientScoreReader = new BufferedReader(new InputStreamReader(clientScoreClientSocket.getInputStream()));
            
            while ((clientScoreInput = clientScoreReader.readLine()) != null){
                System.out.println(clientScoreInput);
            }
        
        } catch(IOException e) {
            System.out.println("hostName.java: " + e);
        }
    }
    
    public void start() {
        if(thread == null) {
            thread = new Thread (this, "hostNameThread");
            thread.start ();
        }
    }
}
