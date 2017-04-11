package multiplayerpong;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Display {
    private JFrame frame;
    private Canvas canvas;
    
    private final String title;
    
    public Display(String title){
        this.title = title;
        
        createDisplay();
        createCanvas();
    }
    
    private void createDisplay(){
        frame = new JFrame(title);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);        
    }
    
    private void createCanvas(){
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(frame.getWidth(), frame.getHeight()));
        canvas.setMaximumSize(new Dimension(frame.getWidth(), frame.getHeight()));
        canvas.setMinimumSize(new Dimension(frame.getWidth(), frame.getHeight()));
        canvas.setFocusable(false); 

        frame.add(canvas);
        frame.pack();
    }
    
    //Getters
    
    public Canvas getCanvas(){
        return canvas;
    }
    
    public JFrame getFrame(){
        return frame;
    }
}