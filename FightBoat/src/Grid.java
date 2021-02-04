package FightBoat.src;

public class Grid {
    
    private boolean[][] grid;

    public Grid(int gridSize) {
        grid = new boolean[gridSize][gridSize];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = false;
            }
        }
    }

    public void toggleSquare(int x, int y) {
        grid[x][y] = !(grid[x][y]);
    }

    public boolean checkFree(int x, int y)
    {
        return !(grid[x][y]);
    }

    public boolean getSquare(int x, int y) {
        return grid[x][y];
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public void printSquare(int x, int y) {
        System.out.println(grid[x][y]);
    }

    public void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[j][i] + "\t");
            }
            System.out.println();
        }
        System.out.println("");
    }
}
