package FightBoat.src;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.*;
import java.util.ArrayList;

public class Player {
    String playerName;
    JFrame frameP;
    JPanel panelP;
    JLabel gridLabel1;
    JLabel gridLabel2;
    JTextArea instructions;
    int gridSize;
    Grid playerGrid;
    Grid opponentGrid;
    ArrayList<JButton> playerListOfButtons = new ArrayList();
    ArrayList<JButton> opponentListOfButtons = new ArrayList();
    ArrayList<Boat> listOfBoats = new ArrayList();
    BoatDestroyer dd;
    BoatCruiser cc;
    BoatBattleship bb;
    BoatCarrier cv;
    int x;
    int y;
    int shipsPlaced;
    Player opponent;

    Player(String playerName, int gridSize) {
        this.playerName = playerName;
        frameP = new JFrame(playerName);
        panelP = new JPanel();
        panelP.setBackground(Color.white);
        gridLabel1 = new JLabel("Your field");
        gridLabel2 = new JLabel("Opponent's field");
        instructions = new JTextArea(
                " 1. Place your destroyer (2x1)\n 2. Place your cruiser (3x1)\n 3. Place your battleship (4x1)\n 4. Place your aircraft carrier (2x2)");
        instructions.setEditable(false);
        playerGrid = new Grid(gridSize);
        opponentGrid = new Grid(gridSize);
        this.gridSize = gridSize;
        shipsPlaced = 0;
    }

    // sets opponent to our plaeyr (cannot appear in constructor, because the
    // opponent might not yet have been created at the time the player is being
    // created)
    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    // creates a button (a basic unit of the playing grid) and places it to a list
    // of buttons for later access
    public JButton createGridButton(final int x, final int y, ArrayList<JButton> listOfWhom) {
        final JButton buttonOfGrid = new JButton();
        buttonOfGrid.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                if (listOfWhom.equals(playerListOfButtons)) {
                    getDecision(x, y);
                } else if (listOfWhom.equals(opponentListOfButtons)) {
                    attack(x, y);
                }
            }
        });
        return buttonOfGrid;
    }

    // for later access of a specific button in a grid
    public JButton getGridButton(int x, int y, ArrayList<JButton> listOfWhom) {
        int index = y * gridSize + x;
        return listOfWhom.get(index);
    }

    // creates a grid of buttons and assigns it to the player list of buttons for
    // later access
    public void createPlayerGrid() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                JButton squareButton = createGridButton(j, i, playerListOfButtons);
                squareButton.setBounds(10 + (30 * j), 10 + (30 * i), 25, 25);
                playerListOfButtons.add(squareButton);
                panelP.add(squareButton);
            }
        }
        recolour(playerGrid, playerListOfButtons);
        gridLabel1.setBounds(10, 250, 250, 25);
        instructions.setBounds(10, 275, 235, 80);
        panelP.add(instructions);
        panelP.add(gridLabel1);
    }

    // creates a grid of buttons and assigns it to the opponent list of buttons for
    // later access (could admittedly be merged with the previous method, but the
    // author chose split the two for clarity and easier usage (no need to specify
    // extra arguments))
    public void createOpponentGrid() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                JButton squareButton = createGridButton(j, i, opponentListOfButtons);
                squareButton.setBounds(400 + (30 * j), 10 + (30 * i), 25, 25);
                opponentListOfButtons.add(squareButton);
                panelP.add(squareButton);
            }

        }
        recolour(opponentGrid, opponentListOfButtons);
        gridLabel2.setBounds(400, 250, 250, 25);
        panelP.add(gridLabel2);
    }

    // asks whether a boat should be placed vertically or horizontally and places a
    // boat (in specific order)
    public void getDecision(final int x, final int y) {
        JFrame decision = new JFrame();
        JPanel decisionP = new JPanel();
        JLabel decisionL = new JLabel("How would you like to place your ship?");

        JButton horizontally = new JButton("Horizontally");
        horizontally.setBounds(10, 40, 120, 25);
        decisionP.add(horizontally);
        horizontally.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                createAdequateBoat(playerGrid, x, y, true);
                recolour(playerGrid, playerListOfButtons);
                playerGrid.printGrid();
            }
        });

        JButton vertically = new JButton("Vertically");
        vertically.setBounds(150, 40, 120, 25);
        decisionP.add(vertically);

        vertically.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                createAdequateBoat(playerGrid, x, y, false);
                recolour(playerGrid, playerListOfButtons);
                playerGrid.printGrid();
            }
        });

        decisionL.setBounds(10, 10, 250, 25);
        decisionP.add(decisionL);
        decision.setSize(300, 200);
        decision.setLocation(600, 300);
        decision.add(decisionP);
        decisionP.setLayout(null);
        decision.setVisible(true);
    }

    // makes sure each player gets to place exactly four boats
    public void createAdequateBoat(Grid gridOfWhom, int x, int y, boolean horizontal) {
        switch (shipsPlaced) {
            case 0:
                dd = new BoatDestroyer(gridOfWhom, x, y, horizontal);
                dd.placeBoat();
                listOfBoats.add(dd);
                shipsPlaced++;
                break;
            case 1:
                cc = new BoatCruiser(gridOfWhom, x, y, horizontal);
                cc.placeBoat();
                listOfBoats.add(cc);
                shipsPlaced++;
                break;
            case 2:
                bb = new BoatBattleship(gridOfWhom, x, y, horizontal);
                bb.placeBoat();
                listOfBoats.add(bb);
                shipsPlaced++;
                break;
            case 3:
                cv = new BoatCarrier(gridOfWhom, x, y);
                cv.placeBoat();
                listOfBoats.add(cv);
                shipsPlaced++;
                break;
        }
    }

    // checks the grids of a given player and makes sure the interface correxponds
    // to what is happening in the code as the game progresses
    public void recolour(Grid gridOfWhom, ArrayList<JButton> listOfWhom) {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (gridOfWhom.getSquare(j, i)) {
                    getGridButton(j, i, listOfWhom).setBackground(Color.gray);
                } else {
                    getGridButton(j, i, listOfWhom).setBackground(Color.cyan);
                }
            }

        }
    }

    // allows a player to attack a certain square (through a button, as mentioned
    // above)
    public void attack(int x, int y) {
        boolean wasHit = opponent.playerGrid.getSquare(x, y);
        if (wasHit) {
            opponent.playerGrid.toggleSquare(x, y);
            opponent.recolour(opponent.playerGrid, opponent.playerListOfButtons);
            opponentGrid.toggleSquare(x, y);
            recolour(opponentGrid, opponentListOfButtons);
            checkDamage();
        } else if (!wasHit) {
            System.out.println("not hit");
        }
    }

    // checks if a boat has just been killed
    public void checkDamage() {
        for (int i = 0; i < listOfBoats.size(); i++)
            {
                if((listOfBoats.get(i).checkIfSunk())&&(listOfBoats.get(i).killed==false))
                {
                    listOfBoats.get(i).killed = true;
                    System.out.println("you killed a ship");
                }
            }
    }

    // creates game interface for a player
    public void createGameWindow() {
        frameP.setSize(900, 500);
        frameP.setLocation(500, 200);
        frameP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameP.add(panelP);

        createPlayerGrid();
        createOpponentGrid();

        panelP.setLayout(null);
        frameP.setVisible(true);
    }
}
