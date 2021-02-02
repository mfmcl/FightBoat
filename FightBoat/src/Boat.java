package FightBoat.src;

public class Boat {
    boolean placed = false;
    boolean horizontal;
    int xInitial, yInitial;
    Grid grid;

    public Boat()
    {

    }
    
    public Boat(Grid grid, int xInitial, int yInitial, boolean horizontal)
    {
        this.grid = grid;
        this.xInitial = xInitial;
        this.yInitial = yInitial;
        this.horizontal = horizontal;
    }

	public void placeBoat()
    {
        if((grid.getSquare(xInitial, yInitial))==false)
        {
            grid.toggleSquare(xInitial, yInitial);
            placed = true;
        }
    }

    public boolean checkBoat()
    {
        return(grid.getSquare(xInitial, yInitial));
    }

    public void sink(Grid grid, int xHit, int yHit)
    {
        if(grid.getSquare(xHit, yHit))
        {
            grid.toggleSquare(xHit, yHit);
        }
    }

}
