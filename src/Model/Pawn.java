package Model;

import Model.Field;
import javafx.scene.control.Button;

import java.io.Serializable;

public class Pawn implements Serializable{
    public Button pawnType;
    public int currentPosition;
    public int spawnPositionX;
    public int spawnPositionY;
    private Field startPosition;

    public Pawn(Button pawnType, int currentPosition, int spawnPositionX, int getSpawnPositionY, Field startPosition) {
        this.pawnType = pawnType;
        this.currentPosition = currentPosition;
        this.spawnPositionX = spawnPositionX;
        this.spawnPositionY = getSpawnPositionY;
        this.startPosition = startPosition;
    }

    public Field getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Field startPosition) {
        this.startPosition = startPosition;
    }

    public Button getPawnType() {
        return pawnType;
    }

    public void setPawnType(Button pawnType) {
        this.pawnType = pawnType;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

}
