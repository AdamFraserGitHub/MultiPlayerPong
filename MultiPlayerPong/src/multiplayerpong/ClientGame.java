package multiplayerpong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import multiplayerpong.Networking.ClientServerThreads.BallX;
import multiplayerpong.Networking.ClientServerThreads.HostPaddleY;
import multiplayerpong.Networking.ClientServerThreads.BallY;

public class ClientGame {
    
    private static BufferStrategy bs;
    private static Graphics g;
    private static int ctxWidth, ctxHeight;
    private static Display display;
    
    private static float opponantPaddleY, playerPaddleY, ballX, ballY;
    private static String playerName, opponantName;
    
    public void renderSetup(Display display) {
        
        this.display = display;
        ctxWidth = Display.frame.getWidth();
        ctxHeight = Display.frame.getHeight();
    }
    
    public void update() {
      
    }
    
    public static void render() {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3); //creates buffer strategy 3 deep
            return;
        }
        g = bs.getDrawGraphics();
        
        //background
        g.setColor(Color.black);
        g.fillRect(0, 0, ctxWidth, ctxHeight);
        g.setColor(Color.white);
        g.drawLine(ctxWidth/2, 0, ctxWidth/2, ctxHeight);
        g.drawLine(1, 0, 1, ctxHeight);
        g.drawLine(ctxWidth - 1, 0, ctxWidth - 1, ctxHeight);
        
        opponantPaddleY = HostPaddleY.opponantY;
        ballX = BallX.ballX;
        ballY = BallY.ballY;
        
        //player paddle
        g.fillRect(25, (int) opponantPaddleY, 25, 100);
        g.drawOval((int) ballX, (int) ballY, 25, 25);
        
        bs.show();
        g.dispose();
        
    }
}