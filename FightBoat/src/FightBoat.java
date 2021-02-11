/**
 * FightBoat v1.0
 *  
 * by mfmcl and NikolaDatkova
 * 
 * AP CS A GRASPS Project
 * 
 * Simple battleship clone
 * 
 * Updated Feb 11 2021
 * 
 * 
 * 
 * Square value legend:
 * 0 - empty square
 * 2 - destroyer 2x1
 * 3 - cruiser 3x1
 * 4 - battleship 4x1
 * 5 - carrier 2x2
 * 6 - square hit
 * 7 - square miss
 * 9 - sunken boat (not implemented)
 */

package FightBoat.src;

public class FightBoat {

    public static void main(String[] args) {

        // create players
        Player p1 = new Player("Player 1", 8);
        Player p2 = new Player("Player 2", 8);

        // set players against each other
        p1.setOpponent(p2);
        p2.setOpponent(p1);

        // create game window for each player
        p1.createGameWindow();
        p2.createGameWindow();
    }
}
