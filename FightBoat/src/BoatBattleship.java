package FightBoat.src;

public class BoatBattleship extends Boat {

    BoatBattleship(Grid grid, int xInitial, int yInitial, boolean horizontal) {
        super(grid, xInitial, yInitial, horizontal);
    }

    public boolean square(int i) {
        if (horizontal)
            return grid.getSquare(xInitial + i, yInitial);
        else
            return grid.getSquare(xInitial, yInitial + i);
    }

    public boolean allBoat() {
        return !square(0) && !square(1) && !square(2) && !square(3);
    }

    @Override
    public void placeBoat() {
        if (placed || !allBoat())
            return;
        if (horizontal) {
            for (int i = 0; i < 4; i++) {
                grid.toggleSquare((xInitial + i), yInitial);
            }
        } else {
            for (int i = 0; i < 4; i++) {
                grid.toggleSquare((xInitial), yInitial + i);
            }
        }
        placed = true;
    }

    @Override
    public boolean checkIfSunk() {
        return !square(0) && !square(1) && !square(2) && !square(3);
    }
}
