package sample;


import java.io.Serializable;

public class PawnForServer implements Serializable{
    private int buttonIndex;
    private int pawnIndex;
    private int diceIndex;
    private int pawnPath;
    private int diceRoll;
    private Field spawn;

    public PawnForServer(int buttonIndex, int pawnIndex, int diceIndex, int pawnPath, int diceRoll, Field spawn) {
        this.buttonIndex = buttonIndex;
        this.pawnIndex = pawnIndex;
        this.pawnPath = pawnPath;
        this.diceRoll = diceRoll;
        this.spawn = spawn;
        this.diceIndex = diceIndex;
    }

    public int getDiceRoll() {
        return diceRoll;
    }

    public void setDiceRoll(int diceRoll) {
        this.diceRoll = diceRoll;
    }

    public Field getSpawn() {
        return spawn;
    }

    public void setSpawn(Field spawn) {
        this.spawn = spawn;
    }

    public int getButtonIndex() {
        return buttonIndex;
    }

    public void setButtonIndex(int buttonIndex) {
        this.buttonIndex = buttonIndex;
    }

    public int getPawnIndex() {
        return pawnIndex;
    }

    public void setPawnIndex(int pawnIndex) {
        this.pawnIndex = pawnIndex;
    }

    public int getPawnPath() {
        return pawnPath;
    }

    public void setPawnPath(int pawnPath) {
        this.pawnPath = pawnPath;
    }
}
