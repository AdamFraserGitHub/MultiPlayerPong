package multiplayerpong;

public class ClientGameThread implements Runnable{
    
    private Thread thread;
    ClientGame game = new ClientGame();
    
    @Override 
    public void run() {
        
        try {
            while(Init.gameRunning) {
                ClientGame.render();
                ClientGame.update();
                thread.sleep((int) 1000 / Init.fps);
            } 
        } catch (Exception e) {
            System.out.println("GameThread: " + e);
        }
    }
    
    public void start() {
        if (thread == null) {
            thread = new Thread (this, "GameThread");
            thread.start();
        }
    }
}
