package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.Socket;

public class ChatController {
    public TextArea textArea;
    public TextField inputBox;
    public Button sendMessage;
    public Socket clientSocket;

    public void sendMessageAction(ActionEvent actionEvent) {
        String message;
        message = inputBox.getText();
        try {
            new ClientWriter(clientSocket, message).start();
        }catch (IOException e){
            System.out.println("Zepsulo sie cos");
        }
        inputBox.setText("");
    }

    public void initialize(){
        try {
            this.clientSocket = new Socket("127.0.0.1", 8888);
            new ClientReader(clientSocket,textArea).start();
        }catch (IOException e){
            System.out.println("Popsulo sie");
        }
    }
}
