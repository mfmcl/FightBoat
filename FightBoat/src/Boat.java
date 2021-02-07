package FightBoat.src;

public class Boat {
    boolean placed = false;
    boolean killed = false;
    boolean horizontal;
    int xInitial, yInitial;
    Grid grid;

    public Boat() {

    }

    public Boat(Grid grid, int xInitial, int yInitial, boolean horizontal) {
        this.grid = grid;
        this.xInitial = xInitial;
        this.yInitial = yInitial;
        this.horizontal = horizontal;
    }

    // a bunch of useless never used methods which are here merely for the sake of
    // demonstrating what these methods should be capable of doing in extensions

    // places a boat only if the space is free
    public void placeBoat() {
        if ((grid.getSquare(xInitial, yInitial)) == false) {
            grid.toggleSquare(xInitial, yInitial);
            placed = true;
        }
    }

    // checks if a boat sunk (if all boat squares are false, a boat is sunk)
    public boolean checkIfSunk() {
        return (!grid.getSquare(xInitial, yInitial));
    }
}
