package FightBoat.src;

public class BoatCarrier extends Boat {
    boolean placed = false;
    boolean horizontal;
    int xInitial, yInitial;
    Grid grid;

    BoatCarrier(Grid grid, int xInitial, int yInitial, boolean horizontal) {
        this.grid = grid;
        this.xInitial = xInitial;
        this.yInitial = yInitial;
        this.horizontal = horizontal;
    }

    @Override
    public void placeBoat() {
        if (!placed) {
            if ((grid.checkFree(xInitial, yInitial)) && (grid.checkFree(xInitial + 1, yInitial))
                    && (grid.checkFree(xInitial, yInitial + 1)) && (grid.checkFree(xInitial + 1, yInitial + 1))) {
                grid.toggleSquare(xInitial, yInitial);
                grid.toggleSquare((xInitial + 1), yInitial);
                grid.toggleSquare(xInitial, (yInitial + 1));
                grid.toggleSquare((xInitial + 1), (yInitial + 1));
                placed = true;
            }
        }
    }
}
