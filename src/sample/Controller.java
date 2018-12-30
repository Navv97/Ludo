package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Controller{

    public AnchorPane boardLayout;
    public Button yellowPawn1;
    public Button yellowPawn3;
    public Button yellowPawn4;
    public Button yellowPawn2;
    public Button bluePawn3;
    public Button bluePawn4;
    public Button bluePawn1;
    public Button bluePawn2;
    public Button redPawn2;
    public Button redPawn4;
    public Button redPawn1;
    public Button redPawn3;
    public Button greenPawn1;
    public Button greenPawn2;
    public Button greenPawn3;
    public Button greenPawn4;
    public Button dice;

    Field blueSpawn1 = new Field(4,329,true);
    Field blueSpawn2 = new Field(40,329,true);
    Field blueSpawn3 = new Field(4,365,true);
    Field blueSpawn4 = new Field(40,365,true);

    Field blueFinish1 = new Field(185,330,false);
    Field blueFinish2 = new Field(185,293,false);
    Field blueFinish3 = new Field(185,258,false);
    Field blueFinish4 = new Field(185,221,false);

//  FIELDS ON THE BOARD
    Field blueStart = new Field(149,365,false);
    Field fieldOfPath1 = new Field(149,330,false);
    Field fieldOfPath2 = new Field(149,294,false);
    Field fieldOfPath3 = new Field(149,258,false);
    Field fieldOfPath4 = new Field(149,221,false);
    Field fieldOfPath5 = new Field(112,221,false);
    Field fieldOfPath6 = new Field(75,221,false);
    Field fieldOfPath7 = new Field(40,221,false);
    Field fieldOfPath8 = new Field(4,221,false);
    Field fieldOfPath9 = new Field(4,184,false);
    Field yellowStart = new Field(4,148,false);
    Field fieldOfPath10 = new Field(40,148,false);
    Field fieldOfPath11 = new Field(76,148,false);
    Field fieldOfPath12 = new Field(112,148,false);
    Field fieldOfPath13 = new Field(149,148,false);
    Field fieldOfPath14 = new Field(149,112,false);
    Field fieldOfPath15 = new Field(149,76,false);
    Field fieldOfPath16 = new Field(149,40,false);
    Field fieldOfPath17 = new Field(149,4,false);
    Field fieldOfPath18 = new Field(185,4,false);
    Field greenStart = new Field(221,4,false);
    Field fieldOfPath19 = new Field(221,40,false);
    Field fieldOfPath20 = new Field(221,76,false);
    Field fieldOfPath21 = new Field(221,112,false);
    Field fieldOfPath22 = new Field(221,148,false);
    Field fieldOfPath23 = new Field(257,148,false);
    Field fieldOfPath24 = new Field(293,148,false);
    Field fieldOfPath25 = new Field(329,148,false);
    Field fieldOfPath26 = new Field(365,148,false);
    Field fieldOfPath27 = new Field(365,184,false);
    Field redStart = new Field(365,221,false);
    Field fieldOfPath28 = new Field(329,221,false);
    Field fieldOfPath29 = new Field(293,221,false);
    Field fieldOfPath30 = new Field(257,221,false);
    Field fieldOfPath31 = new Field(221,221,false);
    Field fieldOfPath32 = new Field(221,258,false);
    Field fieldOfPath33 = new Field(221,293,false);
    Field fieldOfPath34 = new Field(221,330,false);
    Field fieldOfPath35 = new Field(221,365,false);
    Field fieldOfPath36 = new Field(185,365,false);

    ArrayList<Field> generalPath = new ArrayList<Field>();
    ArrayList<Field> bluePlayerPath = new ArrayList<Field>();

    Pawn bluePawn1Object;
    Pawn bluePawn2Object;
    Pawn bluePawn3Object;
    Pawn bluePawn4Object;


    int diceThrow;
    int i = 0;

    public void initialize() {
        bluePawn1Object = new Pawn(bluePawn1, -1, blueSpawn1.getPositionX(), blueSpawn1.getPositionY());
        bluePawn2Object = new Pawn(bluePawn2, -1, blueSpawn2.getPositionX(), blueSpawn2.getPositionY());
        bluePawn3Object = new Pawn(bluePawn3, -1, blueSpawn3.getPositionX(), blueSpawn3.getPositionY());
        bluePawn4Object = new Pawn(bluePawn4, -1, blueSpawn4.getPositionX(), blueSpawn4.getPositionY());

        //initialize path for all players
        generalPath.add(blueStart);
        generalPath.add(fieldOfPath1);
        generalPath.add(fieldOfPath2);
        generalPath.add(fieldOfPath3);
        generalPath.add(fieldOfPath4);
        generalPath.add(fieldOfPath5);
        generalPath.add(fieldOfPath6);
        generalPath.add(fieldOfPath7);
        generalPath.add(fieldOfPath8);
        generalPath.add(fieldOfPath9);
        generalPath.add(yellowStart);
        generalPath.add(fieldOfPath10);
        generalPath.add(fieldOfPath11);
        generalPath.add(fieldOfPath12);
        generalPath.add(fieldOfPath13);
        generalPath.add(fieldOfPath14);
        generalPath.add(fieldOfPath15);
        generalPath.add(fieldOfPath16);
        generalPath.add(fieldOfPath17);
        generalPath.add(fieldOfPath18);
        generalPath.add(greenStart);
        generalPath.add(fieldOfPath19);
        generalPath.add(fieldOfPath20);
        generalPath.add(fieldOfPath21);
        generalPath.add(fieldOfPath22);
        generalPath.add(fieldOfPath23);
        generalPath.add(fieldOfPath24);
        generalPath.add(fieldOfPath25);
        generalPath.add(fieldOfPath26);
        generalPath.add(fieldOfPath27);
        generalPath.add(redStart);
        generalPath.add(fieldOfPath28);
        generalPath.add(fieldOfPath29);
        generalPath.add(fieldOfPath30);
        generalPath.add(fieldOfPath31);
        generalPath.add(fieldOfPath32);
        generalPath.add(fieldOfPath33);
        generalPath.add(fieldOfPath34);
        generalPath.add(fieldOfPath35);
        generalPath.add(fieldOfPath36);

        //initalize path for blue player
        bluePlayerPath.addAll(generalPath);
        bluePlayerPath.add(blueFinish1);
        bluePlayerPath.add(blueFinish2);
        bluePlayerPath.add(blueFinish3);
        bluePlayerPath.add(blueFinish4);

        bluePawn1.setDisable(true);
        bluePawn2.setDisable(true);
        bluePawn3.setDisable(true);
        bluePawn4.setDisable(true);

    }

    public void moveBluePawn1() {
        pawnController(bluePawn1,bluePawn1Object,bluePawn1Object.getCurrentPosition(),bluePlayerPath);
    }

    public void moveBluePawn2() {
        pawnController(bluePawn2,bluePawn2Object,bluePawn1Object.getCurrentPosition(),bluePlayerPath);
    }

    public void moveBluePawn3() {
        pawnController(bluePawn3,bluePawn3Object,bluePawn1Object.getCurrentPosition(),bluePlayerPath);
    }

    public void moveBluePawn4() {
        pawnController(bluePawn4,bluePawn4Object,bluePawn1Object.getCurrentPosition(),bluePlayerPath);
    }

    public void pawnController(Button pawnButton, Pawn pawnObject, int currentPosition, ArrayList<Field> path){
        int moveBy = currentPosition + diceThrow;
        pawnButton.setLayoutX(path.get(moveBy).getPositionX());
        pawnButton.setLayoutY(path.get(moveBy).getPositionY());
        pawnObject.setCurrentPosition(moveBy);
        pawnButton.setDisable(true);
        dice.setDisable(false);
    }

    int tries = -1;

    public void diceRoll() {
        if(blueSpawn1.isTaken()) {
            tries++;
        }
            if(tries < 3) {
                System.out.println("Proby: " + tries);
                diceThrow = ThreadLocalRandom.current().nextInt(1, 6 + 1);
                System.out.println("Kostka: " + diceThrow);
                if (diceThrow == 6) {
                    bluePawn1.setLayoutX(bluePlayerPath.get(0).getPositionX());
                    bluePawn1.setLayoutY(bluePlayerPath.get(0).getPositionY());
                    blueSpawn1.setTaken(false);
                    bluePawn1Object.setCurrentPosition(0);
                    diceThrow = ThreadLocalRandom.current().nextInt(1, 6 + 1);
                }
                if(!blueSpawn1.isTaken()){
                    diceThrow = ThreadLocalRandom.current().nextInt(1, 6 + 1);
                    bluePawn1.setDisable(false);
                }
            }
            if(tries==3){
                dice.setDisable(true);
                System.out.println("Proby: " + tries);
            }
    }

}

