package FightBoat.src;

public class BoatCruiser extends Boat {

    BoatCruiser(Grid grid, int xInitial, int yInitial, boolean horizontal) {
        super(grid, xInitial, yInitial, horizontal);
        boatSize = 3;
    }

    @Override
    // true if values of all squares for placing boat are 0
    public boolean allBoat() {
        return square(0) == 0 && square(1) == 0 && square(2) == 0;
    }

    @Override
    // true if values of all boat squares are 6
    public boolean checkIfSunk() {
        return square(0) == 6 && square(1) == 6 && square(2) == 6;
    }
}