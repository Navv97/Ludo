package BoardController.Server;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Players {
    private final Collection<PrintWriter> players = Collections.synchronizedCollection(new ArrayList<>());
    private int amoutOfPlayers;


    public Players(){
        this.amoutOfPlayers = 0;
    }

    public int getAmoutOfPlayers() {
        return amoutOfPlayers;
    }

    public void setAmoutOfPlayers(int amoutOfPlayers) {
        this.amoutOfPlayers = amoutOfPlayers;
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
