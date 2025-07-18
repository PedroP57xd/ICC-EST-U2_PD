import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MazeSolverRecursivo implements MazeSolver {

    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        if (grid == null || grid.length == 0) {
            return new ArrayList<>();
        }
        List<Cell> path = new ArrayList<>();
        if (findPath(grid, start, end, path)) {
            return path;
        }
        return new ArrayList<>();
    }

    private boolean findPath(boolean[][] grid, Cell start, Cell end, List<Cell> path) {
        int row = start.getRow();
        int col = start.getCol();
        if (row >= grid.length || col >= grid[0].length ||  !grid[row][col] ) {
            return false;
        }
        if(row == end.getRow() && col == end.getCol()) {
            path.add(start);
            return true;
            
        }
        if (findPath(grid,new Cell(row + 1 ,col), end, path)) {
            path.add(start);
            return true;
        }
        // Arriba
        if (findPath(grid, new Cell(row - 1, col), end, path)) {
            path.add(start);
            return true;
        }
        // Izquierda
        if (findPath(grid, new Cell(row, col - 1), end, path)) {
            path.add(start);
            return true;
        }
        // Derecha
        if (findPath(grid, new Cell(row, col + 1), end, path)) {
            path.add(start);
            return true;
        }

        return false; // No path found
    }



    

}
