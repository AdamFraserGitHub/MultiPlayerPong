package multiplayerpong.Networking.ClientServerThreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static multiplayerpong.Networking.ClientServerSetup.*;


public class HostPaddleY implements Runnable{
    private Thread thread;
    
    public void run() {
        System.out.println("HostPaddleY Socket set up");
        try {
            hostPaddleYClientSocket = hostPaddleYSocket.accept();
            hostPaddleYReader = new BufferedReader(new InputStreamReader(hostPaddleYClientSocket.getInputStream()));
            
            while ((hostPaddleYInput = hostPaddleYReader.readLine()) != null){
                System.out.println(hostPaddleYInput);
            }
        
        } catch(IOException e) {
            System.out.println("hostPaddleY.java: " + e);
        }
    }
    
    public void start() {
        if(thread == null) {
            thread = new Thread (this, "hostPaddleYThread");
            thread.start ();
        }
    }
}
