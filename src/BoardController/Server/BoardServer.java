package BoardController.Server;

import java.io.IOException;
import java.net.ServerSocket;

public class BoardServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(7777,3);
        Players players = new Players();
        try {
            while (true) {
                new BoardServerHandler(serverSocket.accept(),players).start();
                if(players.getAmoutOfPlayers()==4) {
                    break;
                }
            }
        }catch (Exception e){
            System.out.println(e.toString());
        } finally {
            serverSocket.close();
        }
    }
}
