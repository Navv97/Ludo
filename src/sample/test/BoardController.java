package sample.test;

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
    private ArrayList<Button> indexes;

    public BoardController(Socket clientSocket, ArrayList<Button> indexes) throws IOException{
        this.clientSocket = clientSocket;
        this.input = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
        this.output = new PrintWriter(this.clientSocket.getOutputStream(), true);
        this.indexes = indexes;
    }

    public void run(){
        try {
            String index;
            while ((index = input.readLine()) != null) {
                int indexInt = Integer.parseInt(index);
                indexes.get(indexInt).setLayoutY(indexes.get(indexInt).getLayoutX()+10);
                indexes.get(indexInt).setLayoutX(indexes.get(indexInt).getLayoutY()+10);
            }
        }catch (IOException e){

        }
    }
}
