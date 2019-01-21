package BoardController.Server;

import org.junit.Test;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

public class PlayersTests {
    private final Collection<PrintWriter> players = Collections.synchronizedCollection(new ArrayList<>());
    private int amoutOfPlayers;

    @Test
    public void checkIfPlayerHasBeenAdded(){
        //given
        PrintWriter player = null;
        //when
        players.add(player);
        //then
        assertEquals(1,players.size());
    }

    @Test
    public void checkAmountOfPlayers(){
        //given
        int INCORRECT_NUMBER_OF_PLAYERS = 5;
        //when
        amoutOfPlayers = 2;
        //then
        assertNotSame(INCORRECT_NUMBER_OF_PLAYERS,amoutOfPlayers);
    }
}
