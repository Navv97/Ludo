package BoardController.Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.java.BoardController.Client.Controller;
import main.java.BoardController.Server.BoardServer;
import main.java.Chat.Server.ChatServer;
import main.java.Main;
import main.java.Model.Pawn;
import main.java.Model.Field;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ControllerTests {

    @Test
    public void checkIfDiceRollsCorrectValues(){
        //given
        int DICE_MIN_VALUE = 1;
        int DICE_MAX_VALUE = 6;

        //when
        Controller testController = new Controller();
        int ROLLED_VALUE = testController.diceThrow();

        //then
        assertTrue(ROLLED_VALUE <= DICE_MAX_VALUE);
        assertFalse(ROLLED_VALUE < DICE_MIN_VALUE);
    }

    @Test
    public void checkIfPawnMoved(){

    }

    @Test
    public void checkIfFieldIsTaken() throws IOException{
    }
}
