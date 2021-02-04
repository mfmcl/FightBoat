package FightBoat.src;

import java.awt.EventQueue;

public class Main {

    public static Grid testGrid = new Grid(10);
    // public static BoatBattleship testBB = new BoatBattleship(testGrid, 0, 3, true);

    public static void main(String[] args) {
        

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new GUI().display();
            }
        });

    }
}
