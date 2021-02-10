package FightBoat.src;

public class BoatCruiser extends Boat {

    BoatCruiser(Grid grid, int xInitial, int yInitial, boolean horizontal) {
        super(grid, xInitial, yInitial, horizontal);
    }

    // true if all squares for placing boat are false
    public boolean allBoat() {
        return !square(0) && !square(1) && !square(2);
    }

    @Override
    public void placeBoat() {
        if (placed || !allBoat())
            return;
        if (horizontal) {
            for (int i = 0; i < 3; i++) {
                grid.toggleSquare((xInitial + i), yInitial);
            }
        } else {
            for (int i = 0; i < 3; i++) {
                grid.toggleSquare((xInitial), yInitial + i);
            }
        }
        placed = true;
    }

    @Override
    public boolean checkIfSunk() {
        return !square(0) && !square(1) && !square(2);
    }
}