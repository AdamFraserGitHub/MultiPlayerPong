package multiplayerpong;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game {
    
    private BufferStrategy bs;
    private Graphics g;
    
    public void renderSetup(Display display) {

        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3); //creates buffer strategy 3 deep
            return;
        }
        
        
        g = bs.getDrawGraphics();
        System.out.println(display + "\n" + bs + "\n" + display.getCanvas());
        g.fillRect(0, 0, 50, 50);
        bs.show();
        g.dispose();
        
//        System.out.println(bs);
//        System.out.println(g);
    }
    
    public void update() {
        
    }
    
    public void render() {
        
    }
}

