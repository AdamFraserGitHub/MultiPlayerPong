package multiplayerpong.Networking.HostServerThreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static multiplayerpong.Networking.HostServerSetup.*;

public class ClientName implements Runnable{
    private Thread thread;
    
    public void run() {

        try {
            clientNameClientSocket = clientNameSocket.accept();
            clientNameReader = new BufferedReader(new InputStreamReader(clientNameClientSocket.getInputStream()));
            
            if ((clientNameInput = clientNameReader.readLine()) != null){
                System.out.println(clientNameInput);
            }
        
        } catch(IOException e) {
            System.out.println("ClientName.java: " + e);
        }
    }
    
    public void start() {
        if(thread == null) {
            thread = new Thread (this, "ClientNameThread");
            thread.start ();
        }
    }
}