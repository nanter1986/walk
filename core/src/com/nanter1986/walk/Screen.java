package com.nanter1986.walk;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by user on 5/2/2017.
 */

public class Screen extends ScreenAdapter implements Input.TextInputListener {
    private SpriteBatch batch;
    String gameStage;
    String comActionDisplay;
    String playerActionDisplay;
    int playerActionAmount;
    int comActionAmount;
    //cards
    private Texture card1;
    private Texture card2;
    private Texture OPcard1;
    private Texture OPcard2;
    private Texture hiddenOPCard;
    private Texture flop1;
    private Texture flop2;
    private Texture flop3;
    private Texture turn1;
    private Texture river1;
    //buttons
    private ClickableButton buttonPic;
    private ClickableButton redFoldButton;
    private ClickableButton orangeCallButton;
    private ClickableButton greenRaiseButton;
    private ClickableButton nextButton;
    //board reveal
    boolean flopReveal;
    boolean turnReveal;
    boolean riverReveal;


    int button;
    int p1Stack;
    int comStack;
    int potSize;
    int card1X, card1Y, card2X, card2Y;
    int OPcard1X, OPcard1Y, OPcard2X, OPcard2Y;
    BitmapFont font = new BitmapFont();

    List<TheDeck> basicD;
    ArrayList<TheDeck> basicDeck;
    ArrayList<TheDeck> playerHand;
    ArrayList<TheDeck> comHand;
    ArrayList<TheDeck> board;


    @Override
    public void show() {
        goToNextHand();
    }

    private void revealBolleans() {
        flopReveal = false;
        turnReveal = false;
        riverReveal = false;
    }

    private void formBoard() {
        Collections.shuffle(basicDeck);
        for (int i = 0; i < 5; i++) {
            board.add(basicDeck.get(i));
        }
        flop1 = new Texture(Gdx.files.internal(board.get(0).getFileLocation()));
        flop2 = new Texture(Gdx.files.internal(board.get(1).getFileLocation()));
        flop3 = new Texture(Gdx.files.internal(board.get(2).getFileLocation()));
        turn1 = new Texture(Gdx.files.internal(board.get(3).getFileLocation()));
        river1 = new Texture(Gdx.files.internal(board.get(4).getFileLocation()));
    }

    private void comHandCoordinates() {
        OPcard1X = 20;
        OPcard1Y = 0;
        OPcard2X = 0;
        OPcard2Y = OPcard1Y;
    }

    private void p1HandCoordinates() {
        card1X = Gdx.graphics.getWidth() - 100;
        card1Y = 0;
        card2X = card1X - 20;
        card2Y = card1Y;
    }

    private void giveComHand() {
        Random r2a = new Random();
        int firstCardCom = r2a.nextInt(basicDeck.size());
        OPcard1 = new Texture(Gdx.files.internal("back.png"));
        comHand.add(basicDeck.get(firstCardCom));
        basicDeck.remove(firstCardCom);
        Random r2b = new Random();
        int secondCardCom = r2b.nextInt(basicDeck.size());
        OPcard2 = new Texture(Gdx.files.internal("back.png"));
        comHand.add(basicDeck.get(secondCardCom));
        basicDeck.remove(secondCardCom);

        hiddenOPCard = new Texture(Gdx.files.internal("back.png"));
    }

    private void revealComHand() {
        OPcard1 = new Texture(Gdx.files.internal(comHand.get(0).getFileLocation()));
        OPcard2 = new Texture(Gdx.files.internal(comHand.get(1).getFileLocation()));
    }

    private void giveP1Hand() {
        Random r1a = new Random();
        int firstCardPlayer = r1a.nextInt(basicDeck.size());
        card1 = new Texture(Gdx.files.internal(basicDeck.get(firstCardPlayer).getFileLocation()));
        playerHand.add(basicDeck.get(firstCardPlayer));
        basicDeck.remove(firstCardPlayer);
        Random r1b = new Random();
        int secondCardPlayer = r1b.nextInt(basicDeck.size());
        card2 = new Texture(Gdx.files.internal(basicDeck.get(secondCardPlayer).getFileLocation()));
        playerHand.add(basicDeck.get(secondCardPlayer));
        basicDeck.remove(secondCardPlayer);
    }


    @Override
    public void resize(int width, int height) {
        int w = 640;
        int h = 480;
        super.resize(w, h);

    }


    @Override
    public void dispose() {

        super.dispose();

        card1.dispose();
        card2.dispose();
    }


    @Override
    public void render(float delta) {
        /*if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
            card1X=Gdx.input.getX();
			card1Y=Gdx.graphics.getHeight()-Gdx.input.getY();
		}*/
        potSize = 400 - p1Stack - comStack;


        gameScript();


        clearScreenForRedraw();

        batch.begin();


        drawButtons();
        drawCards();
        drawFonts();


        batch.end();
    }

    private void gameScript() {
        Gdx.app.log("a", "" + playerActionAmount + " " + gameStage);
        if (gameStage.equals("preps")) {
            comStack = comStack - 1;
            p1Stack = p1Stack - 2;
            potSize = 3;
            String action = PokerAI.decidePreps(comHand, board);
            if (action.equals("raise")) {
                comActionDisplay = "Raise to 6";
                comStack = comStack - 5;
                potSize = potSize + 5;
                gameStage = "preflop3bet";
            } else {
                comActionDisplay = "Folds";
                revealComHand();
                gameStage = "waitingNextHand";
            }


        } else if (gameStage.equals("preflop3bet")) {
            if (Gdx.input.justTouched()) {
                if (greenRaiseButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY())) {
                    Gdx.input.getTextInput(this, "Raise to...", "", "18");

                } else if (orangeCallButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY())) {
                    p1Stack = p1Stack - 4;
                    playerActionDisplay = "";
                    comActionDisplay = "";
                    flopReveal = true;
                    gameStage = "flopCallPreflopRaise";

                } else if (redFoldButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY())) {
                    playerActionDisplay = "Fold";
                    gameStage = "waitingNextHand";
                }
            }
        } else if (gameStage.equals("preflop4bet")) {
            if (playerActionAmount < 25) {
                String action = PokerAI.decide4bet25(comHand, board);
                if (action.equals("raise")) {
                    comActionDisplay = "Raise to " + playerActionAmount * 3;
                    comStack = 200 - playerActionAmount * 3;
                    potSize = 400 - p1Stack - comStack;
                    gameStage = "preflopPlayerFaces4bet";
                } else {
                    comActionDisplay = "Folds";
                    revealComHand();
                    gameStage = "waitingNextHand";
                }
            } else {
                String action = PokerAI.decide4bet13(comHand, board);
                if (action.equals("raise")) {
                    comActionDisplay = "Raise to " + 200;
                    comStack = 0;
                    potSize = 400 - p1Stack - comStack;
                    gameStage = "preflopPlayerFacesAllin4bet";
                } else {
                    comActionDisplay = "Folds";
                    revealComHand();
                    gameStage = "waitingNextHand";
                }
            }

        } else if (gameStage.equals("flopCallPreflopRaise")) {
            if (orangeCallButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY())) {
                comActionDisplay = "Checks";
                potSize = 400 - p1Stack - comStack;
                gameStage = "playerCheckedFlop";
            } else if (greenRaiseButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY())) {
                Gdx.input.getTextInput(this, "Bet...", "", "");
            }
        } else if (gameStage.equals("waitingNextHand")) {
            if (nextButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY())) {
                goToNextHand();
            }
        } else if (gameStage.equals("preflopFacing5bet")) {
            String action = PokerAI.decide5betCall13(comHand, board);
            if (p1Stack == 0) {
                if (action.equals("call")) {
                    comActionDisplay = "Calls";
                    comStack = 0;
                    potSize = 400 - p1Stack - comStack;
                    gameStage = "preflopAllin";
                } else {
                    comActionDisplay = "Folds";
                    revealComHand();
                    gameStage = "waitingNextHand";
                }
            } else {
                if (action.equals("call")) {
                    comActionDisplay = "All in";
                    comStack = 0;
                    potSize = 400 - p1Stack;
                    gameStage = "com6bet";
                } else {
                    comActionDisplay = "Folds";
                    revealComHand();
                    gameStage = "waitingNextHand";
                }
            }

        } else if (gameStage.equals("com6bet")) {
            if (p1Stack == 0) {
                if (orangeCallButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY())) {
                    p1Stack = comStack;
                    playerActionDisplay = "Calls";
                    comActionDisplay = "";
                    flopReveal = true;
                    gameStage = "preflopAllin";

                } else if (redFoldButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY())) {
                    playerActionDisplay = "Fold";
                    gameStage = "waitingNextHand";
                }
            } else {
                String action = PokerAI.decideSmall5bet(comHand, board);
                if (action.equals("raise")) {
                    comActionDisplay = "Raise to " + 200;
                    comStack = 0;
                    potSize = 400 - p1Stack - comStack;
                    gameStage = "preflopPlayerFaces6bet";
                } else {
                    comActionDisplay = "Folds";
                    revealComHand();
                    gameStage = "waitingNextHand";
                }
            }


        } else if (gameStage.equals("preflopPlayerFaces4bet")) {
            if (greenRaiseButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY())) {
                Gdx.input.getTextInput(this, "Raise to...", "", "");


            } else if (orangeCallButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY())) {
                p1Stack = comStack;
                playerActionDisplay = "";
                comActionDisplay = "";
                flopReveal = true;
                gameStage = "flopPlayerCalled4bet";

            } else if (redFoldButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY())) {
                playerActionDisplay = "Fold";
                gameStage = "waitingNextHand";
            }
        } else if (gameStage.equals("preflopPlayerFacesAllin4bet")) {
            if (orangeCallButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY())) {
                comActionDisplay = "Checks";
                potSize = 400 - p1Stack - comStack;
                gameStage = "playerCheckedFlop4bet";
            } else if (greenRaiseButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY())) {
                Gdx.input.getTextInput(this, "Bet...", "", "");
            }
        }else if(gameStage.equals("preflopPlayerFaces6bet")) {
            if (orangeCallButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY())) {
                comActionDisplay = "Calls";
                playerActionDisplay="Calls";
                p1Stack=0;
                potSize = 400 ;
                gameStage = "preflopAllin";
            } else if (greenRaiseButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY())) {
                Gdx.input.getTextInput(this, "Bet...", "", "");
            }
        } else if (gameStage.equals("playerDonkFlop4bet")) {
            ArrayList<TheDeck> currentBoard = new ArrayList<>();
            currentBoard.add(board.get(0));
            currentBoard.add(board.get(1));
            currentBoard.add(board.get(2));
            String action = PokerAI.decideFacingFlopDonk4bet(comHand, currentBoard);
            if (action.equals("raise")) {
                comActionAmount = playerActionAmount + potSize;
                comActionDisplay = "Raise to " + comActionAmount;
                comStack = comStack - comActionAmount;
                potSize = potSize + comActionAmount + playerActionAmount;
                gameStage = "comRaisesFlopDonk";
            } else {
                comActionDisplay = "Folds";
                revealComHand();
                gameStage = "waitingNextHand";
            }
        } else if (gameStage.equals("playerCheckFlop4bet")) {
            ArrayList<TheDeck> currentBoard = new ArrayList<>();
            currentBoard.add(board.get(0));
            currentBoard.add(board.get(1));
            currentBoard.add(board.get(2));
            String action = PokerAI.decideFacingFlopCheck4bet(comHand, currentBoard);
            if (action.equals("bet")) {
                comActionAmount = 200 - potSize / 2;
                comActionDisplay = "All in";
                comStack = 0;
                potSize = potSize + comActionAmount;
                gameStage = "preflopAllin";
            } else {
                comActionDisplay = "Checks";
                revealComHand();
                gameStage = "waitingNextHand";
            }
        } else if (gameStage.equals("preflopAllin")) {
            revealComHand();
            flopReveal = true;
            turnReveal = true;
            riverReveal = true;
            gameStage = "waitingNextHand";
        } else if (gameStage.equals("playerBetFlop")) {
            String action = PokerAI.decideFacingFlopDonk(comHand, board);
            if (action.equals("raise")) {
                comActionAmount = playerActionAmount + potSize;
                comActionDisplay = "Raise to " + comActionAmount;
                comStack = comStack - comActionAmount;
                potSize = potSize + comActionAmount + playerActionAmount;
                gameStage = "comRaisesFlopDonk";
            } else {
                comActionDisplay = "Folds";
                revealComHand();
                gameStage = "waitingNextHand";
            }
        } else if (gameStage.equals("playerCheckedFlop")) {
            ArrayList<TheDeck> currentBoard = new ArrayList<>();
            currentBoard.add(board.get(0));
            currentBoard.add(board.get(1));
            currentBoard.add(board.get(2));
            String action = PokerAI.decideFacingFlopCheck(comHand, currentBoard);
            if (action.equals("bet")) {
                comActionAmount = potSize;
                comActionDisplay = "Bets " + comActionAmount;
                comStack = comStack - comActionAmount;
                potSize = potSize + comActionAmount;
                gameStage = "flopPlayerFacesFlopCbet";
            } else {
                comActionDisplay = "";
                playerActionDisplay = "";
                turnReveal = true;
                gameStage = "turnAfterCheckCheck";
            }
        } else if (gameStage.equals("comRaisesFlopDonk")) {
            if (greenRaiseButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY())) {
                Gdx.input.getTextInput(this, "Raise to...", "", "");

            } else if (orangeCallButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY())) {
                p1Stack = comStack;
                potSize = 400 - comStack - p1Stack;
                playerActionDisplay = "";
                comActionDisplay = "";
                turnReveal = true;
                gameStage = "turnPlayerCalledFlopRaise";

            } else if (redFoldButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY())) {
                playerActionDisplay = "Fold";
                gameStage = "waitingNextHand";
            }
        } else if (gameStage.equals("playerReraisesFlop")) {
            ArrayList<TheDeck> currentBoard = new ArrayList<>();
            currentBoard.add(board.get(0));
            currentBoard.add(board.get(1));
            currentBoard.add(board.get(2));
            String action = PokerAI.decideFacingFlopReraise(comHand, currentBoard);
            if (action.equals("raise")) {
                comActionAmount = potSize;
                comActionDisplay = "Goes All in ";
                comStack = 0;
                potSize = 400 - p1Stack;
                gameStage = "preflopAllin";
            } else {
                comActionDisplay = "Folds";
                revealComHand();
                gameStage = "waitingNextHand";
            }
        } else if (gameStage.equals("turnPlayerCalledFlopRaise")) {
            if (orangeCallButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY())) {
                comActionDisplay = "Checks";
                potSize = 400 - p1Stack - comStack;
                gameStage = "playerCheckedTurnAfterCallingFlopReraise";
            } else if (greenRaiseButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY())) {
                Gdx.input.getTextInput(this, "Bet...", "", "");
            }
        } else if (gameStage.equals("turnPlayerDonksAfterCallingFlopReraise")) {
            ArrayList<TheDeck> currentBoard = new ArrayList<>();
            currentBoard.add(board.get(0));
            currentBoard.add(board.get(1));
            currentBoard.add(board.get(2));
            currentBoard.add(board.get(3));
            String action = PokerAI.decideFacingDonkAfterFlopReraise(comHand, currentBoard);
            if (p1Stack == 0) {
                if (action.equals("raise")) {
                    comActionAmount = potSize;
                    comActionDisplay = "Calls";
                    comStack = 0;
                    potSize = 400;
                    gameStage = "preflopAllin";
                } else {
                    comActionDisplay = "Folds";
                    revealComHand();
                    gameStage = "waitingNextHand";
                }
            } else {
                if (action.equals("raise")) {
                    comActionAmount = potSize;
                    comActionDisplay = "Goes All in ";
                    comStack = 0;
                    potSize = 400 - p1Stack;
                    gameStage = "preflopAllin";
                } else {
                    comActionDisplay = "Folds";
                    revealComHand();
                    gameStage = "waitingNextHand";
                }
            }

        } else if (gameStage.equals("turnPlayerCheckedAfterCallingFlopReraise")) {
            ArrayList<TheDeck> currentBoard = new ArrayList<>();
            currentBoard.add(board.get(0));
            currentBoard.add(board.get(1));
            currentBoard.add(board.get(2));
            currentBoard.add(board.get(3));
            String action = PokerAI.decideFacingCheckAfterFlopReraiseCall(comHand, currentBoard);
            if (action.equals("bet")) {
                comActionAmount = potSize;
                comActionDisplay = "All In";
                comStack = 0;
                potSize = 400 - p1Stack;
                gameStage = "preflopAllin";
            } else {
                comActionDisplay = "Check";
                gameStage = "riverPlayerCheckedAfterCallingFlopReraiseCheckCheck";
            }
        }else if(gameStage.equals("flopPlayerFacesFlopCbet")){
            if (greenRaiseButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY())) {
                Gdx.input.getTextInput(this, "Raise to...", "", "");


            } else if (orangeCallButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY())) {
                p1Stack = comStack;
                playerActionDisplay = "Calls";
                comActionDisplay = "";
                turnReveal = true;
                gameStage = "turnPlayerCalledFlopBet";

            } else if (redFoldButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY())) {
                playerActionDisplay = "Fold";
                gameStage = "waitingNextHand";
            }
        }else if(gameStage.equals("turnPlayerCalledFlopBet")){
            if (orangeCallButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY())) {
                comActionDisplay = "Checks";
                potSize = 400 - p1Stack - comStack;
                gameStage = "playerCheckedTurnAfterCallingFlopBet";
            } else if (greenRaiseButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY())) {
                Gdx.input.getTextInput(this, "Bet...", "", "");
            }
        }else if(gameStage.equals("turnPlayerDonksAfterCallingFlopBet")){
            ArrayList<TheDeck> currentBoard = new ArrayList<>();
            currentBoard.add(board.get(0));
            currentBoard.add(board.get(1));
            currentBoard.add(board.get(2));
            currentBoard.add(board.get(3));
            String action = PokerAI.decideFacingDonkAfterFlopReraiseCall(comHand, currentBoard);
            if (action.equals("raise")) {
                comActionAmount = 3*playerActionAmount;
                comActionDisplay = "Raise to "+comActionAmount;
                comStack = comStack-comActionAmount;
                potSize = 400 - p1Stack-comStack;
                gameStage = "turnPlayerFacingTurnReraiseAfterCallFlopBet";
            } else {
                comActionDisplay = "Folds";
                revealComHand();
                gameStage = "waitingNextHand";
            }
        }else if(gameStage.equals("playerCheckedTurnAfterCallingFlopBet")){
            ArrayList<TheDeck> currentBoard = new ArrayList<>();
            currentBoard.add(board.get(0));
            currentBoard.add(board.get(1));
            currentBoard.add(board.get(2));
            currentBoard.add(board.get(3));
            String action = PokerAI.decideFacingCheckAfterPlayerCalledFlopBet(comHand, currentBoard);
            if (action.equals("raise")) {
                comActionAmount = potSize;
                comActionDisplay = "Bets "+comActionAmount;
                comStack = comStack-comActionAmount;
                potSize = 400 - p1Stack-comStack;
                gameStage = "turnPlayerFacingTurnBetAfterCallFlopBet";
            } else {
                comActionDisplay = "Folds";
                revealComHand();
                gameStage = "waitingNextHand";
            }
        }else if(gameStage.equals("turnPlayerFacingTurnBetAfterCallFlopBet")){
            if (greenRaiseButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY())) {
                Gdx.input.getTextInput(this, "Raise to...", "", "");


            } else if (orangeCallButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY())) {
                p1Stack = comStack;
                playerActionDisplay = "Calls";
                comActionDisplay = "";
                riverReveal = true;
                gameStage = "turnPlayerCalledFlopBetCalledTurnBet";

            } else if (redFoldButton.checkIfClicked(Gdx.input.getX(), Gdx.input.getY())) {
                playerActionDisplay = "Fold";
                gameStage = "waitingNextHand";
            }
        }
    }


    private void goToNextHand() {
        basicD = Arrays.asList(TheDeck.values());
        playerHand = new ArrayList<>();
        comHand = new ArrayList<>();
        board = new ArrayList<>();

        gameStage = "preps";
        comActionDisplay = "";
        playerActionDisplay = "";
        playerActionAmount = 0;
        comActionAmount = 0;
        button = 1;
        p1Stack = 200;
        comStack = 200;
        basicDeck = new ArrayList<>(basicD);
        nextButton = new ClickableButton(590, 640, 0, 50, new Texture(Gdx.files.internal("nextB.png")));
        buttonPic = new ClickableButton(50, 100, 240, 290, new Texture(Gdx.files.internal("button.jpg")));
        redFoldButton = new ClickableButton(450, 500, 230, 280, new Texture(Gdx.files.internal("redB.png")));
        orangeCallButton = new ClickableButton(520, 570, 230, 280, new Texture(Gdx.files.internal("orangeB.png")));
        greenRaiseButton = new ClickableButton(590, 640, 230, 280, new Texture(Gdx.files.internal("greenB.png")));


        revealBolleans();

        p1HandCoordinates();
        comHandCoordinates();

        giveP1Hand();

        giveComHand();

        formBoard();

        batch = new SpriteBatch();
    }

    private void clearScreenForRedraw() {
        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, Color.BLACK.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private void drawButtons() {
        if (button == 1) {
            buttonPic.drawSelf(batch);
        } else {
            buttonPic.drawSelf(batch);
        }
        redFoldButton.drawSelf(batch);
        orangeCallButton.drawSelf(batch);
        greenRaiseButton.drawSelf(batch);
        if (gameStage.equals("waitingNextHand")) {
            nextButton.drawSelf(batch);
        }
    }

    private void drawFonts() {
        font.draw(batch, "Com stack:" + comStack, 130, 200);
        font.draw(batch, comActionDisplay, 130, 150);
        font.draw(batch, playerActionDisplay, 400, 150);
        font.draw(batch, "POT:" + potSize, 250, 100);
        font.draw(batch, "Player stack:" + p1Stack, 400, 200);
        font.draw(batch, "Fold", 460, 230);
        font.draw(batch, "Call", 530, 230);
        font.draw(batch, "Raise", 595, 230);
    }

    private void drawCards() {
        batch.draw(card2, card2X, card2Y, 100f, 200f);
        batch.draw(card1, card1X, card1Y, 100f, 200f);


        batch.draw(OPcard1, OPcard2X, OPcard2Y, 100f, 200f);
        batch.draw(OPcard2, OPcard1X, OPcard1Y, 100f, 200f);
        if (flopReveal == true) {
            batch.draw(flop1, 0, 330, 75f, 150f);
            batch.draw(flop2, 75, 330, 75f, 150f);
            batch.draw(flop3, 150, 330, 75f, 150f);
        }
        if (turnReveal == true) {
            batch.draw(turn1, 240, 330, 75f, 150f);
        }
        if (riverReveal == true) {
            batch.draw(river1, 320, 330, 75f, 150f);
        }
    }

    @Override
    public void input(String text) {
        try {
            int tempRaiseLimit = comActionAmount - playerActionAmount;
            playerActionAmount = Integer.parseInt(text);
            Gdx.app.log("a", "" + playerActionAmount + " " + gameStage);
            if (playerActionAmount > p1Stack || playerActionAmount < 1 || playerActionAmount < tempRaiseLimit) {
                Gdx.input.getTextInput(this, "Incorrect Amount", "", "");
            } else {
                if (gameStage.equals("preflop3bet")) {
                    p1Stack = 200 - playerActionAmount;
                    gameStage = "preflop4bet";
                } else if (gameStage.equals("preflopPlayerFaces4bet")) {
                    if (playerActionAmount < 200) {
                        p1Stack = p1Stack - playerActionAmount;
                        playerActionDisplay = "Raises " + playerActionAmount;
                        gameStage = "preflopFacing5bet";
                    } else if (playerActionAmount == 200) {
                        p1Stack = p1Stack - playerActionAmount;
                        gameStage = "preflopFacing5bet";
                    }
                } else if (gameStage.equals("flopCallPreflopRaise")) {
                    p1Stack = p1Stack - playerActionAmount;
                    playerActionDisplay = "Bets " + playerActionAmount;
                    gameStage = "playerBetFlop";
                } else if (gameStage.equals("comRaisesFlopDonk")) {
                    p1Stack = p1Stack - playerActionAmount;
                    playerActionDisplay = "Raises to " + playerActionAmount;
                    gameStage = "playerReraisesFlop";
                } else if (gameStage.equals("flopPlayerCalled4bet")) {
                    p1Stack = p1Stack - playerActionAmount;
                    playerActionDisplay = "Bets " + playerActionAmount;
                    gameStage = "playerDonkFlop4bet";
                } else if (gameStage.equals("turnPlayerCalledFlopRaise")) {
                    p1Stack = p1Stack - playerActionAmount;
                    playerActionDisplay = "Bets " + playerActionAmount;
                    gameStage = "turnPlayerDonksAfterCallingFlopReraise";
                }else if(gameStage.equals("turnPlayerCalledFlopBet")){
                    p1Stack = p1Stack - playerActionAmount;
                    playerActionDisplay = "Bets " + playerActionAmount;
                    gameStage = "turnPlayerDonksAfterCallingFlopBet";
                }else if(gameStage.equals("turnPlayerFacingTurnBetAfterCallFlopBet")){

                }

            }
        } catch (NumberFormatException e) {

            Gdx.input.getTextInput(this, "Incorrect Amount", "", "");
            e.printStackTrace();
        }
    }

    @Override
    public void canceled() {

    }
}
