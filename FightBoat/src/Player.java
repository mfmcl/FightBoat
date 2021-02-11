package FightBoat.src;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import java.util.ArrayList;

public class Player {
    String playerName;
    JFrame frame;
    JPanel panel;
    JLabel gridLabel1;
    JLabel gridLabel2;
    JTextArea instructions;
    int gridSize;
    Grid playerGrid;
    Grid opponentGrid;
    ArrayList<JButton> playerListOfButtons = new ArrayList();
    ArrayList<JButton> opponentListOfButtons = new ArrayList();
    ArrayList<Boat> listOfBoats = new ArrayList();
    ArrayList<Boat> sunkenBoats = new ArrayList();
    Boat destroyer;
    Boat cruiser;
    Boat battleship;
    Boat carrier;
    int x;
    int y;
    int boatsPlaced;
    int score = 0;
    Player opponent;
    Font font = new Font("Comic Sans MS", Font.BOLD, 12);

    public Player(String playerName, int gridSize) {
        this.playerName = playerName;
        this.gridSize = gridSize;

        playerGrid = new Grid(gridSize);
        opponentGrid = new Grid(gridSize);
        boatsPlaced = 0;
    }

    // sets opponent to our plaeyr
    // NOTE: cannot appear in constructor, because the opponent might
    // not yet have been created at the time the player is being created
    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    // creates game window for a player
    // contains two grids - one for placing boats and one for attacking
    // displays score and instructions for placing boats
    public void createGameWindow() {
        frame = new JFrame(playerName);
        panel = new JPanel();
        panel.setBackground(Color.white);

        gridLabel1 = new JLabel("Your field \t Score: " + score);
        gridLabel1.setFont(font);
        gridLabel1.setForeground(Color.YELLOW);
        gridLabel2 = new JLabel("Opponent's field \t Score: " + opponent.score);
        gridLabel2.setFont(font);
        gridLabel2.setForeground(Color.RED);

        instructions = new JTextArea(
                " 1. Place your destroyer (2x1)\n 2. Place your cruiser (3x1)\n 3. Place your battleship (4x1)\n 4. Place your aircraft carrier (2x2)");
        instructions.setFont(font);
        instructions.setBackground(Color.DARK_GRAY);
        instructions.setForeground(Color.WHITE);
        instructions.setEditable(false);

        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);
        panel.setBackground(Color.DARK_GRAY);

        createPlayerGrid();
        createOpponentGrid();

        panel.setLayout(null);
        frame.setVisible(true);
    }

    // creates a button (a basic unit of the playing grid) and places it to a list
    // of buttons for later acruiseress
    public JButton createGridButton(final int x, final int y, ArrayList<JButton> whichList) {
        final JButton buttonOfGrid = new JButton();
        buttonOfGrid.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                if (whichList.equals(playerListOfButtons)) {
                    getDecision(x, y);
                } else if (whichList.equals(opponentListOfButtons)) {
                    attack(x, y);
                }
            }
        });
        return buttonOfGrid;
    }

    // returns button at specific coordinates from specific grid
    public JButton getGridButton(int x, int y, ArrayList<JButton> whichList) {
        int index = y * gridSize + x;
        return whichList.get(index);
    }

    // creates a grid of buttons and assigns them to this player
    // adds buttons to list for easier access
    // separate from createOpponentGrid() for sake of clarity and easier usage
    // (no need to specify extra arguments)

    public void createPlayerGrid() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                JButton squareButton = createGridButton(j, i, playerListOfButtons);
                squareButton.setBounds(10 + (30 * j), 10 + (30 * i), 25, 25);
                playerListOfButtons.add(squareButton);
                panel.add(squareButton);
            }
        }
        recolor(playerGrid, playerListOfButtons);
        gridLabel1.setBounds(10, 250, 250, 25);
        instructions.setBounds(10, 275, 235, 80);
        panel.add(instructions);
        panel.add(gridLabel1);
    }

    // creates a grid of buttons and assigns them to opponent
    // adds buttons to list for easier access
    // separate from createPlayerGrid() for sake of clarity and easier usage
    // (no need to specify extra arguments)
    public void createOpponentGrid() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                JButton squareButton = createGridButton(j, i, opponentListOfButtons);
                squareButton.setBounds(400 + (30 * j), 10 + (30 * i), 25, 25);
                opponentListOfButtons.add(squareButton);
                panel.add(squareButton);
            }

        }
        recolor(opponentGrid, opponentListOfButtons);
        gridLabel2.setBounds(400, 250, 250, 25);
        panel.add(gridLabel2);
    }

    // asks player whether to place boat horizontally or vertically
    // TODO: make JOptionPane or replace with toggle in main window
    public void getDecision(final int x, final int y) {
        if (boatsPlaced < 3) {
            JFrame decision = new JFrame();
            JPanel decisionP = new JPanel();
            JLabel decisionL = new JLabel("How would you like to place your ship?");
    
            JButton horizontally = new JButton("Horizontally");
            horizontally.setBounds(10, 40, 120, 25);
            decisionP.add(horizontally);
            horizontally.addActionListener(new ActionListener() {
    
                @Override
                public void actionPerformed(ActionEvent event) {
                    createCorrectBoat(playerGrid, x, y, true);
                    recolor(playerGrid, playerListOfButtons);
                    playerGrid.printGrid();
                    decision.dispose();
                }
            });
    
            JButton vertically = new JButton("Vertically");
            vertically.setBounds(150, 40, 120, 25);
            decisionP.add(vertically);
    
            vertically.addActionListener(new ActionListener() {
    
                @Override
                public void actionPerformed(ActionEvent event) {
                    createCorrectBoat(playerGrid, x, y, false);
                    recolor(playerGrid, playerListOfButtons);
                    playerGrid.printGrid();
                    decision.dispose();
                }
            });
    
            decisionL.setBounds(10, 10, 250, 25);
            decisionP.add(decisionL);
            decision.setSize(300, 120);
            decision.setLocation(600, 300);
            decision.add(decisionP);
            decisionP.setLayout(null);
            decision.setVisible(true);
        } else {
            createCorrectBoat(playerGrid, x, y, true);
            recolor(playerGrid, playerListOfButtons);
            playerGrid.printGrid();
        }
    }

    // places correct type of boat based on current number of placed boats
    public void createCorrectBoat(Grid whichGrid, int x, int y, boolean horizontal) {
        switch (boatsPlaced) {
            case 0:
                destroyer = new BoatDestroyer(whichGrid, x, y, horizontal);
                destroyer.placeBoat();
                listOfBoats.add(destroyer);
                boatsPlaced++;
                break;
            case 1:
                cruiser = new BoatCruiser(whichGrid, x, y, horizontal);
                cruiser.placeBoat();
                listOfBoats.add(cruiser);
                boatsPlaced++;
                break;
            case 2:
                battleship = new BoatBattleship(whichGrid, x, y, horizontal);
                battleship.placeBoat();
                listOfBoats.add(battleship);
                boatsPlaced++;
                break;
            case 3:
                carrier = new BoatCarrier(whichGrid, x, y);
                carrier.placeBoat();
                listOfBoats.add(carrier);
                boatsPlaced++;
                break;
            default:
                break;
        }
    }

    // changes grid button colors based on their values (legend in class FightBoat)
    // TODO: could be a switch
    public void recolor(Grid whichGrid, ArrayList<JButton> whichList) {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (whichGrid.getSquare(j, i) == 0) {
                    getGridButton(j, i, whichList).setBackground(Color.GRAY);
                } else if (whichGrid.getSquare(j, i) == 6) {
                    getGridButton(j, i, whichList).setBackground(Color.RED);
                } else if (whichGrid.getSquare(j, i) == 7) {
                    getGridButton(j, i, whichList).setBackground(Color.LIGHT_GRAY);
                } else if (whichGrid.getSquare(j, i) == 9) {
                    getGridButton(j, i, whichList).setBackground(Color.BLACK);
                } else {
                    getGridButton(j, i, whichList).setBackground(Color.WHITE);
                }
            }

        }
    }

    // attacks selected square.
    // if hit, value of square set to 6. If miss, value of square set to 7
    public void attack(int x, int y) {
        boolean wasHit = !(opponent.playerGrid.getSquare(x, y) == 0 || opponent.playerGrid.getSquare(x, y) == 6);
        if (wasHit) {
            opponent.playerGrid.setSquare(x, y, 6);
            opponent.recolor(opponent.playerGrid, opponent.playerListOfButtons);
            opponentGrid.setSquare(x, y, 6);
            recolor(opponentGrid, opponentListOfButtons);
            opponent.checkDamage();
            score++;
            gridLabel1.setText("Your field \t Score: " + score);
            gridLabel2.setText("Opponent's field \t Score: " + opponent.score);
            opponent.gridLabel1.setText("Your field \t Score: " + opponent.score);
            opponent.gridLabel2.setText("Opponent's field \t Score: " + score);
            System.out.println("hit");
        } else {
            opponentGrid.setSquare(x, y, 7);
            recolor(opponentGrid, opponentListOfButtons);
            System.out.println("miss");
        }
    }

    // checks if a boat has just been sunk
    // TODO: set sunk boat values to 9 to make it clearer to player that a boat has been sunk
    public void checkDamage() {
        for (int i = 0; i < listOfBoats.size(); i++) {
            if (listOfBoats.get(i).checkIfSunk() && !(listOfBoats.get(i).sunk)) {
                listOfBoats.get(i).sunk = true;
                System.out.println("you sunk a ship");

            }
        }
    }

}
