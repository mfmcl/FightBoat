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

    // returns value of boat square with index i
    public int square(int i) {
        if (horizontal)
            return grid.getSquare(xInitial + i, yInitial);
        else
            return grid.getSquare(xInitial, yInitial + i);
    }

    // returns true if values of all potential squares for boat placement are 0
    // 0 means there is no boat on this square
    public boolean allBoat() {
        // defined separately for each boat type
        return false;
    }

    // places boat by changing values of all boat squares
    // places boat in correct orientation
    // places boat only if it is possible
    public void placeBoat() {
        if (placed || !allBoat()) {
            System.out.println("cannot place boat");
            return;
        }
        if (horizontal) {
            for (int i = 0; i < boatSize; i++) {
                grid.setSquare((xInitial + i), yInitial, boatSize);
                placed = true;
            }
        } else {
            for (int i = 0; i < boatSize; i++) {
                grid.setSquare((xInitial), yInitial + i, boatSize);
                placed = true;
            }
        }
    }

    // checks if a boat is sunk (a bot is sunk if value of all boat squares is 9)
    public boolean checkIfSunk() {
        // defined separately for each boat type
        return false;
    }
}
