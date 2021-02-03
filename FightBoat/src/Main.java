package FightBoat.src;
public class Main {

    public static void main(String[] args) {
        Grid testGrid = new Grid(8);
        testGrid.printGrid();
        System.out.println("");

        BoatBattleship testBB = new BoatBattleship(testGrid, 0, 3, true);
        testBB.placeBoat();

        testGrid.printGrid();
        System.out.println("");

        System.out.println(testGrid.getSquare(0, 4));

    }
}
