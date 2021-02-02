package FightBoat.src;

import javax.swing.*;
public class Main {

    public static void createWindow() {   
        JFrame frame = new JFrame("FightBoat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Grid testGrid = new Grid(8);
        testGrid.printGrid();
        System.out.println("");

        BoatBattleship testBB = new BoatBattleship(testGrid, 0, 3, true);
        testBB.placeBoat();
        testGrid.printGrid();
        System.out.println("");

        System.out.println(testBB.bb_1);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createWindow();
            }
        });
    }
}
