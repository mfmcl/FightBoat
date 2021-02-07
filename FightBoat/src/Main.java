package FightBoat.src;

import java.awt.EventQueue;

public class Main {

    public static void main(String[] args) {
        
        // welcome players
        Player p1 = new Player("P1",8);
        Player p2 = new Player("P2",8);

        // set against each other
        p1.setOpponent(p2);
        p2.setOpponent(p1);

        // create windows
        p1.createGameWindow();
        p2.createGameWindow();
    }
}
