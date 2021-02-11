package FightBoat.src;

public class Grid {

    private int[][] grid;

    public Grid(int gridSize) {
        grid = new int[gridSize][gridSize];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = 0;
            }
        }
    }

    // sets value of grid[x][y] to int n
    public void setSquare(int x, int y, int n) {
        grid[x][y] = n;
    }
    
    // returns value of grid[x][y]
    public int getSquare(int x, int y) {
        return grid[x][y];
    }

    // returns true of value of square at grid[x][y] is 0
    // 0 means there is no boat on this square
    public boolean checkFree(int x, int y) {
        if (grid[x][y] == 0) {
            return true;            
        } else {
            return false;
        }
    }

    // public boolean[][] getGrid() {
    //     return grid;
    // }

    // for debugging

    // prints value of square at grid[x][y]
    public void printSquare(int x, int y) {
        System.out.println(grid[x][y]);
    }

    // prints entire grid
    public void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Grid grid = new Grid(8);
        Boat a = new BoatBattleship(grid, 5, 1, true);
        Boat b = new BoatCarrier(grid, 2, 1);
        a.placeBoat();
        b.placeBoat();

        grid.printGrid();
        
    }
}
