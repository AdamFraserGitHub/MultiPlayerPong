package multiplayerpong.Networking.ClientServerThreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static multiplayerpong.Networking.ClientServerSetup.*;


public class HostName implements Runnable{
    private Thread thread;
    
    public void run() {
        System.out.println("HostName Socket set up");
        try {
            hostNameClientSocket = hostNameSocket.accept();
            hostNameReader = new BufferedReader(new InputStreamReader(hostNameClientSocket.getInputStream()));
            
            if ((hostNameInput = hostNameReader.readLine()) != null){
                System.out.println(hostNameInput);
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
