package sample.test;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class TestController {
    public Button but1;
    public Button but2;
    public Button bu3;
    public Button kloc1;
    public Button kloc2;
    public Button kloc3;
    public Socket clientSocket;
    private BufferedReader input;
    private PrintWriter output;
    public ArrayList<Button> indexes;


    public void initialize(){
        indexes = new ArrayList<>();
        indexes.add(kloc1);
        indexes.add(kloc2);
        indexes.add(kloc3);
        try {
            this.clientSocket = new Socket("127.0.0.1", 7777);
            this.input = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
            this.output = new PrintWriter(this.clientSocket.getOutputStream(), true);
            new BoardController(clientSocket,indexes).start();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }

    public void but1move(ActionEvent actionEvent) {
        output.println(0);
    }

    public void but2move(ActionEvent actionEvent) {
        output.println(1);
    }

    public void but3move(ActionEvent actionEvent) {
        output.println(2);
    }

}
