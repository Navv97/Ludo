package sample;

import javafx.scene.control.TextArea;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatClientReader extends Thread{
    private Socket clientSocket;
    private BufferedReader input;
    private TextArea textArea;

    public ChatClientReader(Socket clientSocket, TextArea textArea) throws IOException {
        this.clientSocket = clientSocket;
        this.input = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
        this.textArea = textArea;
    }

    public void run(){
        try{
            String line;
            while ( (line = input.readLine()) != null) {
                textArea.appendText(line + "\n");
            }
        }catch (IOException e){
            System.out.println("Nie da rady");
        }
    }

}
