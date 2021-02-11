package FightBoat.src;

public class Main {

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
