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

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    private JButton getGridButton(int x, int y, ArrayList<JButton> listOfWhom) {
        int index = y * gridSize + x;
        return listOfWhom.get(index);
    }

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

    JButton createGridButton(final int x, final int y, ArrayList<JButton> listOfWhom) {
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

    public void createAdequateBoat(Grid gridOfWhom, int x, int y, boolean horizontal) {
        switch (shipsPlaced) {
            case 0:
                dd = new BoatDestroyer(gridOfWhom, x, y, horizontal);
                dd.placeBoat();
                shipsPlaced++;
                break;
            case 1:
                cc = new BoatCruiser(gridOfWhom, x, y, horizontal);
                cc.placeBoat();
                shipsPlaced++;
                break;
            case 2:
                bb = new BoatBattleship(gridOfWhom, x, y, horizontal);
                bb.placeBoat();
                shipsPlaced++;
                break;
            case 3:
                cv = new BoatCarrier(gridOfWhom, x, y);
                cv.placeBoat();
                shipsPlaced++;
                break;
        }
    }

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

    public void attack(int x, int y) {
        boolean wasHit = opponent.playerGrid.getSquare(x, y);
        if (wasHit) {
            opponent.playerGrid.toggleSquare(x, y);
            opponent.recolour(opponent.playerGrid, opponent.playerListOfButtons);
            checkDamage();
            opponentGrid.toggleSquare(x, y);
            recolour(opponentGrid, opponentListOfButtons);
        } else if (!wasHit) {
            System.out.println("not hit");
        }
    }

    public void checkDamage()
    {
        JTextArea ribbons = new JTextArea("hi");
        ribbons.setEditable(false);
        ribbons.setBounds(10, 10, 100, 25);
        if(opponent.dd.checkIfSunk())
        {
            JFrame destroyed = new JFrame(playerName);
            destroyed.setBackground(Color.white);
            destroyed.setSize(300, 200);
            destroyed.setLocation(600, 300);
            JPanel destroyedP = new JPanel();
            destroyedP.setBackground(Color.white);
            destroyedP.add(ribbons);
            destroyed.add(destroyedP);
            destroyedP.setLayout(null);
            destroyed.setVisible(true);
        }   
    }

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
