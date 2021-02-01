package Fightboat.src;

public class Boat {
    boolean placed;

    Boat()
    {
        boolean placed = false;
    }

    public void placeBoat(Grid grid, int x, int y)
    {
        grid.getSquare(x, y) = true;
        placed = true;
    }

    public void getSunk(Grid grid)
    {
        grid.getSquare() = false;
    }

}
