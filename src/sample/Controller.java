package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.net.Socket;
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
    public Button blueDice;
    public Button yellowDice;
    public Button greenDice;
    public Button redDice;
    public TextArea textArea;
    public TextField inputBox;
    public Button sendMessage;

    private Field blueSpawn1 = new Field(4,329,true);
    private Field blueSpawn2 = new Field(40,329,true);
    private Field blueSpawn3 = new Field(4,365,true);
    private Field blueSpawn4 = new Field(40,365,true);

    private Field blueFinish1 = new Field(185,330,false);
    private Field blueFinish2 = new Field(185,293,false);
    private Field blueFinish3 = new Field(185,258,false);
    private Field blueFinish4 = new Field(185,221,false);

    private Field yellowSpawn1 = new Field(4,3,true);
    private Field yellowSpawn2 = new Field(40,3,true);
    private Field yellowSpawn3 = new Field(4,39,true);
    private Field yellowSpawn4 = new Field(39,39,true);

    private Field yellowFinish1 = new Field(40,184,false);
    private Field yellowFinish2 = new Field(76,184,false);
    private Field yellowFinish3 = new Field(112,184,false);
    private Field yellowFinish4 = new Field(149,184,false);

    private Field greenSpawn1 = new Field(331,3,true);
    private Field greenSpawn2 = new Field(366,3,true);
    private Field greenSpawn3 = new Field(330,39,true);
    private Field greenSpawn4 = new Field(366,39,true);

    private Field greenFinish1 = new Field(185,40,false);
    private Field greenFinish2 = new Field(185,76,false);
    private Field greenFinish3 = new Field(185,112,false);
    private Field greenFinish4 = new Field(185,148,false);

    private Field redSpawn1 = new Field(330,330,true);
    private Field redSpawn2 = new Field(366,330,true);
    private Field redSpawn3 = new Field(330,366,true);
    private Field redSpawn4 = new Field(367,366,true);

    private Field redFinish1 = new Field(329,184,false);
    private Field redFinish2 = new Field(293,184,false);
    private Field redFinish3 = new Field(257,184,false);
    private Field redFinish4 = new Field(221,184,false);

    //  FIELDS ON THE BOARD
    private Field blueStart = new Field(149,365,false);
    private Field fieldOfPath1 = new Field(149,330,false);
    private Field fieldOfPath2 = new Field(149,294,false);
    private Field fieldOfPath3 = new Field(149,258,false);
    private Field fieldOfPath4 = new Field(149,221,false);
    private Field fieldOfPath5 = new Field(112,221,false);
    private Field fieldOfPath6 = new Field(75,221,false);
    private Field fieldOfPath7 = new Field(40,221,false);
    private Field fieldOfPath8 = new Field(4,221,false);
    private Field fieldOfPath9 = new Field(4,184,false);
    private Field yellowStart = new Field(4,148,false);
    private Field fieldOfPath10 = new Field(40,148,false);
    private Field fieldOfPath11 = new Field(76,148,false);
    private Field fieldOfPath12 = new Field(112,148,false);
    private Field fieldOfPath13 = new Field(149,148,false);
    private Field fieldOfPath14 = new Field(149,112,false);
    private Field fieldOfPath15 = new Field(149,76,false);
    private Field fieldOfPath16 = new Field(149,40,false);
    private Field fieldOfPath17 = new Field(149,4,false);
    private Field fieldOfPath18 = new Field(185,4,false);
    private Field greenStart = new Field(221,4,false);
    private Field fieldOfPath19 = new Field(221,40,false);
    private Field fieldOfPath20 = new Field(221,76,false);
    private Field fieldOfPath21 = new Field(221,112,false);
    private Field fieldOfPath22 = new Field(221,148,false);
    private Field fieldOfPath23 = new Field(257,148,false);
    private Field fieldOfPath24 = new Field(293,148,false);
    private Field fieldOfPath25 = new Field(329,148,false);
    private Field fieldOfPath26 = new Field(365,148,false);
    private Field fieldOfPath27 = new Field(365,184,false);
    private Field redStart = new Field(365,221,false);
    private Field fieldOfPath28 = new Field(329,221,false);
    private Field fieldOfPath29 = new Field(293,221,false);
    private Field fieldOfPath30 = new Field(257,221,false);
    private Field fieldOfPath31 = new Field(221,221,false);
    private Field fieldOfPath32 = new Field(221,258,false);
    private Field fieldOfPath33 = new Field(221,293,false);
    private Field fieldOfPath34 = new Field(221,330,false);
    private Field fieldOfPath35 = new Field(221,365,false);
    private Field fieldOfPath36 = new Field(185,365,false);

    public ArrayList<Field> generalPath = new ArrayList<Field>();
    public ArrayList<Field> bluePlayerPath = new ArrayList<Field>();
    public ArrayList<Field> yellowPlayerPath = new ArrayList<Field>();
    public ArrayList<Field> greenPlayerPath = new ArrayList<Field>();
    public  ArrayList<Field> redPlayerPath = new ArrayList<Field>();

    public  Pawn bluePawn1Object;
    public Pawn bluePawn2Object;
    public  Pawn bluePawn3Object;
    public Pawn bluePawn4Object;
    public Pawn yellowPawn1Object;
    public Pawn greenPawn1Object;
    public Pawn redPawn1Object;


    public Integer diceThrow;
    public Socket chatSocket;
    public Socket boardSocket;
    public ArrayList<Button> indexesOfPawns;
    public ArrayList<Pawn> indexesOfPawnsObject;
    public ArrayList<ArrayList <Field>> paths;
    public ArrayList<Boolean> playersTruns;
    public ArrayList<Button> indexesOfDices;
    private BufferedReader input;
    private PrintWriter output;
    private int playerIndex;


    public void initialize() {
        try {
            this.chatSocket = new Socket("127.0.0.1", 8888);
            new ChatClientReader(chatSocket,textArea).start();
        }catch (IOException e){
            System.out.println("Popsulo sie");
        }
        bluePawn1Object = new Pawn(bluePawn1, -1, blueSpawn1.getPositionX(), blueSpawn1.getPositionY());
        yellowPawn1Object = new Pawn(yellowPawn1, -1, yellowSpawn1.getPositionX(), yellowSpawn1.positionY);
        greenPawn1Object = new Pawn(greenPawn1, -1, greenSpawn1.getPositionX(), yellowSpawn1.positionY);
        redPawn1Object = new Pawn(redPawn1, -1, redSpawn1.getPositionX(), redSpawn1.positionY);

        //useless for now
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

        //initialize path for yellow player
        yellowPlayerPath.add(yellowStart);
        yellowPlayerPath.add(fieldOfPath10);
        yellowPlayerPath.add(fieldOfPath11);
        yellowPlayerPath.add(fieldOfPath12);
        yellowPlayerPath.add(fieldOfPath13);
        yellowPlayerPath.add(fieldOfPath14);
        yellowPlayerPath.add(fieldOfPath15);
        yellowPlayerPath.add(fieldOfPath16);
        yellowPlayerPath.add(fieldOfPath17);
        yellowPlayerPath.add(fieldOfPath18);
        yellowPlayerPath.add(greenStart);
        yellowPlayerPath.add(fieldOfPath19);
        yellowPlayerPath.add(fieldOfPath20);
        yellowPlayerPath.add(fieldOfPath21);
        yellowPlayerPath.add(fieldOfPath22);
        yellowPlayerPath.add(fieldOfPath23);
        yellowPlayerPath.add(fieldOfPath24);
        yellowPlayerPath.add(fieldOfPath25);
        yellowPlayerPath.add(fieldOfPath26);
        yellowPlayerPath.add(fieldOfPath27);
        yellowPlayerPath.add(redStart);
        yellowPlayerPath.add(fieldOfPath28);
        yellowPlayerPath.add(fieldOfPath29);
        yellowPlayerPath.add(fieldOfPath30);
        yellowPlayerPath.add(fieldOfPath31);
        yellowPlayerPath.add(fieldOfPath32);
        yellowPlayerPath.add(fieldOfPath33);
        yellowPlayerPath.add(fieldOfPath34);
        yellowPlayerPath.add(fieldOfPath35);
        yellowPlayerPath.add(fieldOfPath36);
        yellowPlayerPath.add(blueStart);
        yellowPlayerPath.add(fieldOfPath1);
        yellowPlayerPath.add(fieldOfPath2);
        yellowPlayerPath.add(fieldOfPath3);
        yellowPlayerPath.add(fieldOfPath4);
        yellowPlayerPath.add(fieldOfPath5);
        yellowPlayerPath.add(fieldOfPath6);
        yellowPlayerPath.add(fieldOfPath7);
        yellowPlayerPath.add(fieldOfPath8);
        yellowPlayerPath.add(fieldOfPath9);
        yellowPlayerPath.add(yellowFinish1);
        yellowPlayerPath.add(yellowFinish2);
        yellowPlayerPath.add(yellowFinish3);
        yellowPlayerPath.add(yellowFinish4);

        //initalize path for green player
        greenPlayerPath.add(greenStart);
        greenPlayerPath.add(fieldOfPath19);
        greenPlayerPath.add(fieldOfPath20);
        greenPlayerPath.add(fieldOfPath21);
        greenPlayerPath.add(fieldOfPath22);
        greenPlayerPath.add(fieldOfPath23);
        greenPlayerPath.add(fieldOfPath24);
        greenPlayerPath.add(fieldOfPath25);
        greenPlayerPath.add(fieldOfPath26);
        greenPlayerPath.add(fieldOfPath27);
        greenPlayerPath.add(redStart);
        greenPlayerPath.add(fieldOfPath28);
        greenPlayerPath.add(fieldOfPath29);
        greenPlayerPath.add(fieldOfPath30);
        greenPlayerPath.add(fieldOfPath31);
        greenPlayerPath.add(fieldOfPath32);
        greenPlayerPath.add(fieldOfPath33);
        greenPlayerPath.add(fieldOfPath34);
        greenPlayerPath.add(fieldOfPath35);
        greenPlayerPath.add(fieldOfPath36);
        greenPlayerPath.add(blueStart);
        greenPlayerPath.add(fieldOfPath1);
        greenPlayerPath.add(fieldOfPath2);
        greenPlayerPath.add(fieldOfPath3);
        greenPlayerPath.add(fieldOfPath4);
        greenPlayerPath.add(fieldOfPath5);
        greenPlayerPath.add(fieldOfPath6);
        greenPlayerPath.add(fieldOfPath7);
        greenPlayerPath.add(fieldOfPath8);
        greenPlayerPath.add(fieldOfPath9);
        greenPlayerPath.add(yellowStart);
        greenPlayerPath.add(fieldOfPath10);
        greenPlayerPath.add(fieldOfPath11);
        greenPlayerPath.add(fieldOfPath12);
        greenPlayerPath.add(fieldOfPath13);
        greenPlayerPath.add(fieldOfPath14);
        greenPlayerPath.add(fieldOfPath15);
        greenPlayerPath.add(fieldOfPath16);
        greenPlayerPath.add(fieldOfPath17);
        greenPlayerPath.add(fieldOfPath18);
        greenPlayerPath.add(greenFinish1);
        greenPlayerPath.add(greenFinish2);
        greenPlayerPath.add(greenFinish3);
        greenPlayerPath.add(greenFinish4);

        //initalize path for red player
        redPlayerPath.add(redStart);
        redPlayerPath.add(fieldOfPath28);
        redPlayerPath.add(fieldOfPath29);
        redPlayerPath.add(fieldOfPath30);
        redPlayerPath.add(fieldOfPath31);
        redPlayerPath.add(fieldOfPath32);
        redPlayerPath.add(fieldOfPath33);
        redPlayerPath.add(fieldOfPath34);
        redPlayerPath.add(fieldOfPath35);
        redPlayerPath.add(fieldOfPath36);
        redPlayerPath.add(blueStart);
        redPlayerPath.add(fieldOfPath1);
        redPlayerPath.add(fieldOfPath2);
        redPlayerPath.add(fieldOfPath3);
        redPlayerPath.add(fieldOfPath4);
        redPlayerPath.add(fieldOfPath5);
        redPlayerPath.add(fieldOfPath6);
        redPlayerPath.add(fieldOfPath7);
        redPlayerPath.add(fieldOfPath8);
        redPlayerPath.add(fieldOfPath9);
        redPlayerPath.add(yellowStart);
        redPlayerPath.add(fieldOfPath10);
        redPlayerPath.add(fieldOfPath11);
        redPlayerPath.add(fieldOfPath12);
        redPlayerPath.add(fieldOfPath13);
        redPlayerPath.add(fieldOfPath14);
        redPlayerPath.add(fieldOfPath15);
        redPlayerPath.add(fieldOfPath16);
        redPlayerPath.add(fieldOfPath17);
        redPlayerPath.add(fieldOfPath18);
        redPlayerPath.add(greenStart);
        redPlayerPath.add(fieldOfPath19);
        redPlayerPath.add(fieldOfPath20);
        redPlayerPath.add(fieldOfPath21);
        redPlayerPath.add(fieldOfPath22);
        redPlayerPath.add(fieldOfPath23);
        redPlayerPath.add(fieldOfPath24);
        redPlayerPath.add(fieldOfPath25);
        redPlayerPath.add(fieldOfPath26);
        redPlayerPath.add(fieldOfPath27);
        redPlayerPath.add(redFinish1);
        redPlayerPath.add(redFinish2);
        redPlayerPath.add(redFinish3);
        redPlayerPath.add(redFinish4);

        indexesOfPawns = new ArrayList<>();
        indexesOfPawnsObject = new ArrayList<>();
        playersTruns = new ArrayList<>();
        indexesOfDices = new ArrayList<>();

        indexesOfDices.add(blueDice);
        indexesOfDices.add(yellowDice);
        indexesOfDices.add(greenDice);
        indexesOfDices.add(redDice);

        playersTruns.add(blueTurn);
        playersTruns.add(yellowTurn);
        playersTruns.add(greenTurn);
        playersTruns.add(redTurn);

        indexesOfPawns.add(bluePawn1);
        indexesOfPawns.add(bluePawn2);
        indexesOfPawns.add(bluePawn3);
        indexesOfPawns.add(bluePawn4);
        indexesOfPawns.add(yellowPawn1);
        indexesOfPawns.add(yellowPawn2);
        indexesOfPawns.add(yellowPawn3);
        indexesOfPawns.add(yellowPawn4);
        indexesOfPawns.add(greenPawn1);
        indexesOfPawns.add(greenPawn2);
        indexesOfPawns.add(greenPawn3);
        indexesOfPawns.add(greenPawn4);
        indexesOfPawns.add(redPawn1);
        indexesOfPawns.add(redPawn2);
        indexesOfPawns.add(redPawn3);
        indexesOfPawns.add(redPawn4);

        indexesOfPawnsObject.add(bluePawn1Object);
        indexesOfPawnsObject.add(yellowPawn1Object);
        indexesOfPawnsObject.add(greenPawn1Object);
        indexesOfPawnsObject.add(redPawn1Object);

        bluePawn1.setDisable(true);
        yellowPawn1.setDisable(true);
        greenPawn1.setDisable(true);
        redPawn1.setDisable(true);

        yellowDice.setDisable(true);
        greenDice.setDisable(true);
        redDice.setDisable(true);

        //useless for now
        bluePawn2.setDisable(true);
        bluePawn3.setDisable(true);
        bluePawn4.setDisable(true);

        paths = new ArrayList<>();
        paths.add(bluePlayerPath);
        paths.add(yellowPlayerPath);
        paths.add(greenPlayerPath);
        paths.add(redPlayerPath);

        try{
            this.boardSocket = new Socket("127.0.0.1", 7777);
            this.input = new BufferedReader(new InputStreamReader(this.boardSocket.getInputStream()));
            this.output = new PrintWriter(this.boardSocket.getOutputStream(), true);
            this.playerIndex = Integer.parseInt(input.readLine());
            new BoardController(boardSocket,indexesOfPawns,indexesOfPawnsObject,paths,playersTruns,indexesOfDices).start();
        }catch (IOException e){

        }
    }

    public boolean blueTurn = true;
    public boolean yellowTurn = false;
    public boolean greenTurn = false;
    public boolean redTurn = false;
    public int yellowTries = -1;
    public int blueTries = -1;
    public int greenTries = -1;
    public int redTries = -1;

    public void bluePawnMovement() {
        if(playerIndex==1) {
            pawnController(0, 0, bluePawn1Object.getCurrentPosition(), 0, blueDice, 0, 1);
        }
    }

    public void yellowPawnMovement(ActionEvent actionEvent) {
        if(playerIndex==2) {
            pawnController(4, 1, yellowPawn1Object.getCurrentPosition(), 1, yellowDice, 1, 2);
        }
    }

    public void greenPawnMovement(ActionEvent actionEvent) {
        if(playerIndex==3) {
            pawnController(8, 2, greenPawn1Object.getCurrentPosition(), 2, greenDice, 2, 3);
        }
    }

    public void redPawnMovement(ActionEvent actionEvent) {
        if(playerIndex==4) {
            pawnController(12, 3, redPawn1Object.getCurrentPosition(), 3, redDice, 3, 0);
        }
    }

    public void pawnController(int pawnButtonID, int pawnObjectID, int currentPosition, int pathID, Button dice, int currentPlayer, int nextPlayer){
        int moveBy = currentPosition + diceThrow;
        output.println(pawnButtonID);
        output.println(pawnObjectID);
        output.println(pathID);
        output.println(moveBy);
        output.println(currentPlayer);
        output.println(nextPlayer);
        indexesOfPawns.get(pawnButtonID).setDisable(true);
        dice.setDisable(false);
    }

    public void blueDiceRoll() {
        if(playerIndex==1) {
            if (blueSpawn1.isTaken()) {
                this.blueTries++;
            }
            veryGoodDiceRoll(0,blueSpawn1,blueTries,0,0,0,0,blueStart);
            if ((blueSpawn1.isTaken() && this.blueTries == 2) || (!blueSpawn1.isTaken() && this.blueTries == 1) || (!blueSpawn1.isTaken() && this.blueTries == 0)) {
                blueTurn = false;
                yellowTurn = true;
                if (blueSpawn1.isTaken() && this.blueTries == 2) {
                    blueDice.setDisable(true);
                    yellowDice.setDisable(false);
                }
                this.blueTries = -1;
            }
        }
    }

    public void yellowDiceRoll(ActionEvent actionEvent) {
        if(playerIndex==2) {
            if (yellowSpawn1.isTaken()) {
                this.yellowTries++;
            }
            veryGoodDiceRoll(1,yellowSpawn1,yellowTries,1,4,1,1,yellowStart);
            if ((yellowSpawn1.isTaken() && this.yellowTries == 2) || (!yellowSpawn1.isTaken() && this.yellowTries == 1) || (!yellowSpawn1.isTaken() && this.yellowTries == 0)) {
                yellowTurn = false;
                greenTurn = true;
                if (yellowSpawn1.isTaken() && this.yellowTries == 2) {
                    yellowDice.setDisable(true);
                    greenDice.setDisable(false);
                }
                this.yellowTries = -1;
            }
        }
    }

    public void greenDiceRoll(ActionEvent actionEvent) {
        if(playerIndex==3) {
            if (greenSpawn1.isTaken()) {
                this.greenTries++;
            }
            veryGoodDiceRoll(2,greenSpawn1,greenTries,2,8,2,2,greenStart);
            if ((greenSpawn1.isTaken() && this.greenTries == 2) || (!greenSpawn1.isTaken() && this.greenTries == 1) || (!greenSpawn1.isTaken() && this.greenTries == 0)) {
                greenTurn = false;
                redTurn = true;
                if (greenSpawn1.isTaken() && this.greenTries == 2) {
                    greenDice.setDisable(true);
                    redDice.setDisable(false);
                }
                if (!greenSpawn1.isTaken()) {
                    greenDice.setDisable(true);
                    redDice.setDisable(false);
                }
                this.greenTries = -1;
            }
        }
    }

    public void redDiceRoll(ActionEvent actionEvent) {
        if(playerIndex==4) {
            if (redSpawn1.isTaken()) {
                this.redTries++;
            }
            veryGoodDiceRoll(3,redSpawn1,redTries,3,12,3,3,redStart);
            if ((redSpawn1.isTaken() && this.redTries == 2) || (!redSpawn1.isTaken() && this.redTries == 1) || (!redSpawn1.isTaken() && this.redTries == 0)) {
                redTurn = false;
                blueTurn = true;
                if (redSpawn1.isTaken() && this.redTries == 2) {
                    redDice.setDisable(true);
                    blueDice.setDisable(false);
                }
                this.redTries = -1;
            }
        }
    }

    public void veryGoodDiceRoll(int yourTurn, Field yourSpawn, int yourTries, int yourDice, int yourPawnButton, int yourPath, int yourPawnObject, Field yourStart){
        if(playersTruns.get(yourTurn)){
            if(yourTries < 3){
                System.out.println("Proby: " + yourTries);
                diceThrow = ThreadLocalRandom.current().nextInt(6, 6 + 1);
                indexesOfDices.get(yourDice).setText(diceThrow.toString());
                if(diceThrow == 6 && yourSpawn.isTaken()){
                    indexesOfPawns.get(yourPawnButton).setLayoutX(paths.get(yourPath).get(0).getPositionX());
                    indexesOfPawns.get(yourPawnButton).setLayoutY(paths.get(yourPath).get(0).getPositionY());
                    indexesOfPawnsObject.get(yourPawnObject).setCurrentPosition(0);
                    indexesOfPawns.get(yourPawnButton).setDisable(true);
                    yourSpawn.setTaken(false);
                    yourStart.setTaken(true);
                }
                if(!yourSpawn.isTaken() && indexesOfPawns.get(yourPawnButton).isDisabled()){
                    indexesOfPawns.get(yourPawnButton).setDisable(false);
                    diceThrow = ThreadLocalRandom.current().nextInt(6, 6 + 1);
                    indexesOfDices.get(yourDice).setText(diceThrow.toString());
                    indexesOfDices.get(yourDice).setDisable(true);
                }
            }
        }
    }

    //useless for now
    public void moveBluePawn2() {
        pawnController(0,0,bluePawn1Object.getCurrentPosition(),0,blueDice,0,0);
    }

    public void moveBluePawn3() {
        pawnController(0,0,bluePawn1Object.getCurrentPosition(),0,blueDice,0,0);
    }

    public void moveBluePawn4() {
        pawnController(0,0,bluePawn1Object.getCurrentPosition(),0,blueDice,0,0);
    }

    public void sendMessageAction(ActionEvent actionEvent) {
        String message;
        message = inputBox.getText();
        try {
            new ChatClientWriter(chatSocket, message).start();
        }catch (IOException e){
            System.out.println("Zepsulo sie cos");
        }
        inputBox.setText("");
    }
}
