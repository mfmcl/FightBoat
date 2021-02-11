package FightBoat.src;

public class Boat {
    Grid grid;
    int xInitial;
    int yInitial;
    int boatSize;
    int numHits = 0;
    boolean horizontal;
    boolean placed = false;
    boolean sunk = false;


    public Boat(Grid grid, int xInitial, int yInitial, boolean horizontal) {
        this.grid = grid;
        this.xInitial = xInitial;
        this.yInitial = yInitial;
        this.horizontal = horizontal;
    }

    public boolean square(int i) {
        if (horizontal)
            return grid.getSquare(xInitial + i, yInitial);
        else
            return grid.getSquare(xInitial, yInitial + i);
    }

    // a bunch of useless never used methods which are here merely for the sake of
    // demonstrating what these methods should be capable of doing in extensions

    // places a boat only if the space is free
    public void placeBoat() {
        // 
    }

    // checks if a boat sunk (if all boat squares are false, a boat is sunk)
    public boolean checkIfSunk() {
        return (!(grid.getSquare(xInitial, yInitial)));
    }

    public void setSunk() {
        sunk = true;
    }
}
