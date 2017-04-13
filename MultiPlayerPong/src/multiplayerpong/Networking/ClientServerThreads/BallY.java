package multiplayerpong.Networking.ClientServerThreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static multiplayerpong.Networking.ClientServerSetup.*;


public class BallY implements Runnable{
    private Thread thread;
    public static float ballY;
    
    public void run() {
        System.out.println("BallY Socket set up");
        try {
            ballYClientSocket = ballYSocket.accept();
            ballYReader = new BufferedReader(new InputStreamReader(ballYClientSocket.getInputStream()));
            
            while ((ballYInput = ballYReader.readLine()) != null){
                ballY = Float.parseFloat(ballYInput);
            }
        
        } catch(IOException e) {
            System.out.println("ballY.java: " + e);
        }
    }
    
    public void start() {
        if(thread == null) {
            thread = new Thread (this, "ballYThread");
            thread.start ();
        }
    }
}
