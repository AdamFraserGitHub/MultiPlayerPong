package multiplayerpong;

import java.util.Scanner;
import multiplayerpong.Networking.ClientServerSetup;
import multiplayerpong.Networking.HostClientSetup;
import multiplayerpong.Networking.HostServerSetup;

public class Init {
    public static int fps;
    public static boolean gameRunning;
    
    public static void main(String[] args) {
        boolean host = false;
        gameRunning = true;
        fps = 30;
        
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
            clientServerSetup.setup();
        }
    }
    
}