package sample.test;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Players {
    private final Collection<PrintWriter> players = Collections.synchronizedCollection(new ArrayList<>());

    public Players(){

    }

    public void notifyPlayers(String message){
        for (PrintWriter printWriter : players){
            printWriter.println(message);
        }
    }

    public void addPlayer(PrintWriter player){
        players.add(player);
    }
}
