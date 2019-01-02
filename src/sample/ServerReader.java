package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerReader extends Thread {
    private Socket serverSocket;
    private BufferedReader input;
    private PrintWriter output;
    private PlayersList playersList;

    public ServerReader(Socket serverSocket) throws IOException {
        this.playersList = PlayersList.getIstance();
        this.serverSocket = serverSocket;
        this.input = new BufferedReader(new InputStreamReader(this.serverSocket.getInputStream()));
        this.output = new PrintWriter(this.serverSocket.getOutputStream(), true);
        playersList.addPlayer(output);
    }

    public void run(){
        try {
            String line;
            while ( (line = input.readLine()) != null) {
                playersList.notifyPlayers(line);
            }
        }catch (IOException e){

        }
    }

}
