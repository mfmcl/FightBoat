package FightBoat.src;

public class BoatDestroyer extends Boat {

    BoatDestroyer(Grid grid, int xInitial, int yInitial, boolean horizontal) {
        super(grid, xInitial, yInitial, horizontal);
        boatSize = 2;
    }

    // true if all squares for placing boat are false
    public boolean allBoat() {
        return !square(0) && !square(1);
    }

    @Override
    public void placeBoat() {
        if (placed || !allBoat())
            return;
        if (horizontal) {
            for (int i = 0; i < 2; i++) {
                grid.toggleSquare((xInitial + i), yInitial);
            }
        } else {
            for (int i = 0; i < 2; i++) {
                grid.toggleSquare((xInitial), yInitial + i);
            }
        }
    }

    @Override
    public boolean checkIfSunk() {
        return (!(square(0)) && !(square(1)));
    }
}
