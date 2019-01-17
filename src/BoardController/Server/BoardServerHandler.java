package BoardController.Server;

import java.io.*;
import java.net.Socket;

public class BoardServerHandler extends Thread{
    private Socket serverSocket;
    private BufferedReader input;
    private PrintWriter output;
    private Players players;

    public BoardServerHandler(Socket serverSocket, Players players) throws IOException{
        this.serverSocket = serverSocket;
        this.input = new BufferedReader(new InputStreamReader(this.serverSocket.getInputStream()));
        this.output = new PrintWriter(this.serverSocket.getOutputStream(), true);
        this.players = players;
        players.addPlayer(output);
        players.setAmoutOfPlayers(players.getAmoutOfPlayers()+1);
    }

    public void run(){
        try {
            String index;
            output.println(players.getAmoutOfPlayers());
            while ((index = input.readLine()) != null) {
                players.notifyPlayers(index);
            }
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }

}
