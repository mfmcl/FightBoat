package FightBoat.src;

public class BoatBattleship extends Boat {
    boolean placed = false;
    boolean horizontal, allBoat, someBoat;
    boolean bb_1, bb_2, bb_3, bb_4;
    int xInitial, yInitial;
    Grid grid;

    BoatBattleship(Grid grid, int xInitial, int yInitial, boolean horizontal) {
        this.grid = grid;
        this.xInitial = xInitial;
        this.yInitial = yInitial;
        this.horizontal = horizontal;

        if (horizontal) {
            bb_1 = grid.getSquare(xInitial, yInitial);
            bb_2 = grid.getSquare(xInitial + 1, yInitial);
            bb_3 = grid.getSquare(xInitial + 2, yInitial);
            bb_4 = grid.getSquare(xInitial + 3, yInitial);
        } else if (!horizontal) {
            bb_1 = grid.getSquare(xInitial, yInitial);
            bb_2 = grid.getSquare(xInitial, yInitial + 1);
            bb_3 = grid.getSquare(xInitial, yInitial + 2);
            bb_4 = grid.getSquare(xInitial, yInitial + 3);
        }
        allBoat = bb_1 && bb_2 && bb_3 && bb_4;
        someBoat = bb_1 || bb_2 || bb_3 || bb_4;
    }

    @Override
    public void placeBoat() {
        if (!placed) {
            if (horizontal) {
                if (allBoat) {
                    for (int i = 0; i < 4; i++) {
                        grid.toggleSquare((xInitial + i), yInitial);
                    }
                    placed = true;
                }
            } else if (!horizontal) {
                if (allBoat) {
                    for (int i = 0; i < 4; i++) {
                        grid.toggleSquare((xInitial), yInitial + i);
                    }
                    placed = true;
                }
            }
        }
    }

    @Override
    public boolean checkBoat() {
        System.out.println(bb_1);
        System.out.println(bb_2);
        System.out.println(bb_3);
        System.out.println(bb_4);
        return someBoat;
    }
}
