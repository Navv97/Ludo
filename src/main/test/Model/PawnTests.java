package Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import javafx.scene.control.Button;
import main.java.Model.Pawn;
import main.java.Model.Field;
import org.junit.Test;

public class PawnTests {
    private Field spawnForPawn = new Field(4,329,true);
    private Field startForPawn = new Field(149,365,false);
    private Button buttonForPawn;
    private Pawn pawnToTest = new Pawn(buttonForPawn,-1,spawnForPawn.getPositionX(), spawnForPawn.getPositionY(),startForPawn,spawnForPawn);

    @Test
    public void checkPawnPositionX(){
        //gieven
        int EXPECTED_POSITION_X = 4;
        //when
        //then
        assertEquals(EXPECTED_POSITION_X,pawnToTest.getSpawnPosition().getPositionX());
    }

    @Test
    public void checkPawnPositionY(){
        //gieven
        int EXPECTED_POSITION_Y = 329;
        //when
        //then
        assertEquals(EXPECTED_POSITION_Y,pawnToTest.getSpawnPosition().getPositionY());
    }

    @Test
    public void checkPawnStartingPosition(){
        //given
        Field WRONG_STARTING_POSITION = new Field(149,365,false);
        //when
        //then
        assertNotSame(WRONG_STARTING_POSITION, pawnToTest.getStartPosition());
    }
}
