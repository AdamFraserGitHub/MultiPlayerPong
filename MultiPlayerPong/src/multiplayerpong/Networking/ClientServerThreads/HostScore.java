package multiplayerpong.Networking.ClientServerThreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static multiplayerpong.Networking.ClientServerSetup.*;


public class HostScore implements Runnable{
    private Thread thread;
    
    public void run() {
        System.out.println("HostScore Socket set up");
        try {
            hostScoreClientSocket = hostScoreSocket.accept();
            hostScoreReader = new BufferedReader(new InputStreamReader(hostScoreClientSocket.getInputStream()));
            
            while ((hostScoreInput = hostScoreReader.readLine()) != null){
                System.out.println(hostScoreInput);
            }
        
        } catch(IOException e) {
            System.out.println("hostScore.java: " + e);
        }
    }
    
    public void start() {
        if(thread == null) {
            thread = new Thread (this, "hostScoreThread");
            thread.start ();
        }
    }
}
