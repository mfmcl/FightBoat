package FightBoat.src;

public class BoatCarrier extends Boat {

    BoatCarrier(Grid grid, int xInitial, int yInitial) {
        super(grid, xInitial, yInitial, false);
    }

    @Override
    public boolean square(int i) {
        if (i < 2)
            return grid.getSquare(xInitial + i, yInitial);
        else
            return grid.getSquare(xInitial + (i - 2), yInitial + 1);
    }

    // true if all squares for placing boat are false
    public boolean allBoat() {
        return !square(0) && !square(1) && !square(2) && !square(3);
    }

    @Override
    public void placeBoat() {
        if (placed || !allBoat())
            return;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                grid.toggleSquare(xInitial + i, yInitial + j);
            }
        }
        placed = true;
    }

    @Override
    public boolean checkIfSunk() {
        return !square(0) && !square(1) && !square(2) && !square(3);
    }
}
