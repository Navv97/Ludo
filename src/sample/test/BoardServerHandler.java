package sample.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
    }

    public void run(){
        try {
            String index;
            while ( (index = input.readLine()) != null) {
                players.notifyPlayers(index);
            }
        }catch (IOException e){

        }
    }

}
