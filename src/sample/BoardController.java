package sample;

import javafx.scene.control.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class BoardController extends Thread{
    private BufferedReader input;
    private PrintWriter output;
    private Socket clientSocket;
    private ArrayList<Button> indexesOfButtons;
    private ArrayList<Pawn> indexesOfPawns;
    private ArrayList<ArrayList<Field>> indexesOfPaths;
    private ArrayList<Boolean> playersTurns;
    private ArrayList<Button> indexesOfDices;

    public BoardController(Socket clientSocket, ArrayList<Button> buttons, ArrayList<Pawn> pawns, ArrayList<ArrayList<Field>> paths, ArrayList<Boolean> playersTruns, ArrayList<Button> indexesOfDices) throws IOException{
        this.clientSocket = clientSocket;
        this.input = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
        this.output = new PrintWriter(this.clientSocket.getOutputStream(), true);
        this.indexesOfButtons = buttons;
        this.indexesOfPawns = pawns;
        this.indexesOfPaths = paths;
        this.playersTurns = playersTruns;
        this.indexesOfDices = indexesOfDices;
    }

    public void run(){
        try {
            String index;
            while ((index = input.readLine()) != null) {
                int buttonIndex = Integer.parseInt(index);
                int pawnIndex = Integer.parseInt(input.readLine());
                int pathIndex = Integer.parseInt(input.readLine());
                int moveBy = Integer.parseInt(input.readLine());
                int currentPlayer = Integer.parseInt(input.readLine());
                int nextPlayer = Integer.parseInt(input.readLine());
                System.out.println(buttonIndex + " " + pawnIndex + " " + pathIndex + " " + moveBy + " " + currentPlayer + " " + nextPlayer);
                if(moveBy != 0) {
                    indexesOfButtons.get(buttonIndex).setLayoutX(indexesOfPaths.get(pathIndex).get(moveBy).getPositionX());
                    indexesOfButtons.get(buttonIndex).setLayoutY(indexesOfPaths.get(pathIndex).get(moveBy).getPositionY());
                    indexesOfPawns.get(pawnIndex).setCurrentPosition(moveBy);
                }
                playersTurns.set(currentPlayer,false);
                playersTurns.set(nextPlayer,true);
                indexesOfDices.get(currentPlayer).setDisable(true);
                indexesOfDices.get(nextPlayer).setDisable(false);
            }
        }catch (IOException e){

        }
    }

}
