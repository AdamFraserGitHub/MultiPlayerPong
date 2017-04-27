package multiplayerpong;

import java.util.Scanner;
import multiplayerpong.Networking.ClientClientSetup;
import multiplayerpong.Networking.ClientServerSetup;
import multiplayerpong.Networking.HostClientSetup;
import multiplayerpong.Networking.HostServerSetup;

public class Init {
    public static int fps;
    public static boolean gameRunning;
    
    public static void main(String[] args) {
        boolean host = false;
        gameRunning = true;
        fps = 200;
        
        //VERY temporary solution
        Scanner scanner = new Scanner(System.in);
        
        if(host){
            HostServerSetup hostServerSetup = new HostServerSetup(60002, 60006);
            HostClientSetup hostClientSetup = new HostClientSetup(60000, 60001, 60003, 60004, 60005, 60007);
            
            hostServerSetup.setup();
            System.out.println("press return once the clientServer has been established");
            scanner.nextLine();
            hostClientSetup.setup();
        }
        
        if(!host){
            ClientServerSetup clientServerSetup = new ClientServerSetup(60000, 60001, 60003, 60004, 60005, 60007);
            ClientClientSetup clientClientSetup = new ClientClientSetup(60006, 60002);
            
            clientServerSetup.setup();
            System.out.println("press return once the hostServer has been established");
            scanner.nextLine();
            clientClientSetup.setup();
        }
        
        Display display = new Display("Multi Player Pong");
        ClientGame.keyManagerSetup(display);
        
        ClientGame game = new ClientGame();
        game.renderSetup(display);

        ClientGameThread gameThread = new ClientGameThread();
        gameThread.start();
    }
    
}