package FightBoat.src;
public class BoatCruiser extends Boat {
    boolean placed = false;
    boolean horizontal;
    int xInitial, yInitial;
    Grid grid;

    BoatCruiser(Grid grid, int xInitial, int yInitial, boolean horizontal) {
        this.grid = grid;
        this.xInitial = xInitial;
        this.yInitial = yInitial;
        this.horizontal = horizontal;
    }

    @Override
    public void placeBoat() {
        if (!placed) {
            if (horizontal) {
                if ((grid.checkFree(xInitial, yInitial)) && (grid.checkFree(xInitial + 1, yInitial))
                        && (grid.checkFree(xInitial + 2, yInitial))) {
                    for (int i = 0; i < 3; i++) {
                        grid.toggleSquare((xInitial + i), yInitial);
                    }
                    placed = true;
                }
            } else if (!horizontal) {
                if ((grid.checkFree(xInitial, yInitial)) && (grid.checkFree(xInitial, yInitial + 1))
                        && (grid.checkFree(xInitial, yInitial + 2))) {
                    for (int i = 0; i < 3; i++) {
                        grid.toggleSquare((xInitial), yInitial + i);
                    }
                    placed = true;
                }
            }
        }
    }
}