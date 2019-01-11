package Chat.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatServerHandler extends Thread {
    private Socket serverSocket;
    private BufferedReader input;
    private PrintWriter output;
    private ChatUsersList chatUsersList;

    public ChatServerHandler(Socket serverSocket, ChatUsersList chatUsersList) throws IOException {
        this.chatUsersList = chatUsersList;
        this.serverSocket = serverSocket;
        this.input = new BufferedReader(new InputStreamReader(this.serverSocket.getInputStream()));
        this.output = new PrintWriter(this.serverSocket.getOutputStream(), true);
        chatUsersList.addUser(output);
    }

    public void run(){
        try {
            String line;
            while ( (line = input.readLine()) != null) {
                chatUsersList.notifyUsers(line);
            }
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }

}
