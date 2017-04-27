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
    private static int ctxWidth, ctxHeight, paddleVelocity = 15;
    private static Display display;
    final static private KeyManager keyManager = new KeyManager();
    
    private static float opponantPaddleY, playerPaddleY, ballX, ballY;
    private static String playerName, opponantName;
    
    public void renderSetup(Display display) {
        
        this.display = display;
        ctxWidth = Display.frame.getWidth();
        ctxHeight = Display.frame.getHeight();
        
        playerPaddleY = ctxHeight / 2 - 50; 
    }
    
    public static void update() {
        opponantPaddleY = HostPaddleY.opponantY;
        ballX = BallX.ballX;
        ballY = BallY.ballY;
        
        keyManager.update();
        movementHandler();
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
        
        //player paddle
        g.fillRect(25, (int) playerPaddleY, 25, 100); //player paddle
        g.fillRect(ctxWidth - 50, (int) opponantPaddleY, 25, 100); //opponant paddle
        g.drawOval((int) ballX, (int) ballY, 25, 25); //ball
        
        bs.show();
        g.dispose();
    }
    
    public static void keyManagerSetup(Display display){
        display.getFrame().addKeyListener(keyManager);
    }
    
    public static void movementHandler() {
        if(keyManager.down && (playerPaddleY + 100) < ctxHeight){
            playerPaddleY += paddleVelocity;
        }
        if(keyManager.up && playerPaddleY > 0){
            playerPaddleY -= paddleVelocity;
        }
    }
    
    public static float getPlayerPaddleY() {
        return playerPaddleY;
    }
}