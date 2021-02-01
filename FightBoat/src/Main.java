package FightBoat.src;

public class Main {
    public static void main(String[] args) {
        Grid g = new Grid(8);
        g.toggleSquare(0, 0);
        g.printGrid();
    }
}
