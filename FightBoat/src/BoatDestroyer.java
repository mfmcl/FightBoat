package FightBoat.src;

public class BoatDestroyer extends Boat {

    BoatDestroyer(Grid grid, int xInitial, int yInitial, boolean horizontal) {
        super(grid, xInitial, yInitial, horizontal);
        boatSize = 2;
    }

    @Override
    // true if all squares for placing boat are false
    public boolean allBoat() {
        return square(0) == 0 && square(1) == 0;        
    }

    @Override
    public boolean checkIfSunk() {
        return square(0) == 6 && square(1) == 6;        
    }
}
