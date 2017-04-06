package multiplayerpong.Networking.HostServerThreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static multiplayerpong.Networking.HostServerSetup.*;


public class LeftPaddleY implements Runnable{
    private Thread thread;
    
    public void run() {

        try {
            clientPaddleYClientSocket = clientPaddleYSocket.accept();
            clientPaddleYReader = new BufferedReader(new InputStreamReader(clientPaddleYClientSocket.getInputStream()));
            
            while ((clientPaddleYInput = clientPaddleYReader.readLine()) != null){
                System.out.println(clientPaddleYInput);
            }
        
        } catch(IOException e) {
            System.out.println("LeftPaddleY.java: " + e);
        }
    }
    
    public void start() {
        if(thread == null) {
            thread = new Thread (this, "LeftPaddleYThread");
            thread.start ();
        }
    }
}
