package multiplayerpong.Networking;

import java.io.PrintWriter;
import java.net.Socket;
import multiplayerpong.Init;
import multiplayerpong.Networking.HostClientThreads.*;

public class HostClientSetup {

    public static int frameTimeMS = 1000/Init.fps;    
    public static int ballXPort, ballYPort, hostPaddleYPort, clientScorePort, hostScorePort, hostNamePort;
    public static Socket ballXSocket, ballYSocket, hostPaddleYSocket, clientScoreSocket, hostScoreSocket, hostNameSocket;
    public static PrintWriter ballXWriter, ballYWriter, hostPaddleYWriter, clientScoreWriter, hostScoreWriter, hostNameWriter;
    
    public HostClientSetup(int ballXPort, int ballYPort, int hostPaddleYPort, int clientScorePort, int hostScorePort, int hostNamePort) {
        this.ballXPort = ballXPort;
        this.ballYPort = ballYPort;
        this.hostPaddleYPort = hostPaddleYPort;
        this.clientScorePort = clientScorePort;
        this.hostScorePort = hostScorePort;
        this.hostNamePort = hostNamePort;
    }
    
    public void setup() {
       BallX BallXThread = new BallX();
       BallXThread.start();
       
       BallY BallYThread = new BallY();
       BallYThread.start();
       
       HostPaddleY HostPaddleYThread = new HostPaddleY();
       HostPaddleYThread.start();
       
       ClientScore ClientScoreThread = new ClientScore();
       ClientScoreThread.start();
       
       HostScore HostScoreThread = new HostScore();
       HostScoreThread.start();
       
       HostName HostNameThread = new HostName();
       HostNameThread.start();
    }
}
