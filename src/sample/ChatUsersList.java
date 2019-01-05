package sample;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ChatUsersList {
    private final Collection<PrintWriter> users = Collections.synchronizedCollection(new ArrayList<>());

    public ChatUsersList(){

    }

    public void notifyPlayers(String message){
        for (PrintWriter printWriter : users){
            printWriter.println(message);
        }
    }

    public void addPlayer(PrintWriter user){
        users.add(user);
    }
}
