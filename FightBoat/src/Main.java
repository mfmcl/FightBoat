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

        Boat testBoat = new Boat(testGrid, 0, 3, false);
        testBoat.placeBoat();
        testGrid.printGrid();
        System.out.println("");

        BoatBattleship testBB = new BoatBattleship(testGrid, 4, 4, true);
        testBB.placeBoat();
        testGrid.printGrid();
        System.out.println("");

        System.out.println(testBB.allBoat);
        System.out.println(testBB.someBoat);

        testBB.sink(testGrid, 4, 4);

        testGrid.printGrid();
        System.out.println("");
        System.out.println(testBB.allBoat);
        System.out.println(testBB.someBoat);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createWindow();
            }
        });
    }
}
