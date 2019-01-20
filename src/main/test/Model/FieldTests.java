package Model;

import main.java.Model.Field;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

public class FieldTests {
    private Field fieldToTest = new Field(149,365,false);

    @Test
    public void checkIfFieldWasCreated(){
        assertNotNull(fieldToTest);
    }

    @Test
    public void checkFieldPositionX(){
        //given
        int EXPECTED_POSITION_X = 170;
        //when
        fieldToTest.setPositionX(EXPECTED_POSITION_X);
        //then
        assertEquals(EXPECTED_POSITION_X,fieldToTest.getPositionX());
    }

    @Test
    public void checkFieldPositionY(){
        //given
        int INCORRECT_POSITION_Y = 370;
        //when
        //then
        assertNotSame(INCORRECT_POSITION_Y,fieldToTest.getPositionY());
    }

    @Test
    public void checkIfFieldIsTaken(){
        //given
        boolean FIELD_TAKEN = true;
        //when
        //then
        assertNotSame(FIELD_TAKEN,fieldToTest.isTaken());
    }

}
