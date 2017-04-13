package multiplayerpong.Networking.ClientServerThreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static multiplayerpong.Networking.ClientServerSetup.*;


public class BallX implements Runnable{
    private Thread thread;
    public static float ballX;
    
    public void run() {
        System.out.println("BallX Socket set up");
        try {
            ballXClientSocket = ballXSocket.accept();
            ballXReader = new BufferedReader(new InputStreamReader(ballXClientSocket.getInputStream()));
            
            while ((ballXInput = ballXReader.readLine()) != null){
                ballX = Float.parseFloat(ballXInput);
            }
        
        } catch(IOException e) {
            System.out.println("ballX.java: " + e);
        }
    }
    
    public void start() {
        if(thread == null) {
            thread = new Thread (this, "ballXThread");
            thread.start ();
        }
    }
}