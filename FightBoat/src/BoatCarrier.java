package FightBoat.src;

public class BoatCarrier extends Boat {

    BoatCarrier(Grid grid, int xInitial, int yInitial) {
        super(grid, xInitial, yInitial, false);
        boatSize = 4;
    }

    @Override
    public int square(int i) {
        if (i < 2)
            return grid.getSquare(xInitial + i, yInitial);
        else
            return grid.getSquare(xInitial + (i - 2), yInitial + 1);
    }

    @Override
    // true if all squares for placing boat are false
    public boolean allBoat() {
        return square(0) == 0 && square(1) == 0 && square(2) == 0 && square(3) == 0;
    }

    @Override
    public void placeBoat() {
        if (placed || !allBoat()) {
            System.out.println("cannot place boat");
            return;
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                grid.setSquare(xInitial + i, yInitial + j, 5);
            }
        }
        placed = true;
    }

    @Override
    public boolean checkIfSunk() {
        return square(0) == 6 && square(1) == 6 && square(2) == 6 && square(3) == 6;        
    }
}
