package FightBoat.src;

import java.awt.EventQueue;

public class Main {

    public static Grid testGrid = new Grid(10);
    // public static BoatBattleship testBB = new BoatBattleship(testGrid, 0, 3, true);

    public static void main(String[] args) {
        
        testGrid.printGrid();
        
        BoatBattleship bb = new BoatBattleship(testGrid, 3, 3, false);
        bb.placeBoat();

        testGrid.printGrid();
        System.out.println(bb.allBoat());
        
        testGrid.printGrid();
        bb.sink(testGrid, 3, 3);
        
        testGrid.printGrid();
        System.out.println(bb.allBoat());


        // EventQueue.invokeLater(new Runnable() {

        //     @Override
        //     public void run() {
        //         new GUI().display();
        //     }
        // });

    }
}
