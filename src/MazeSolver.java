
import java.util.ArrayList;
import java.util.List;

public interface MazeSolver {
   // List<Cell> getPath(boolean[][] grid, Cell start, Cell end);

    static MazeRsult getPathWithResult(boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = getPath(grid, start, end);
        boolean found = !path.isEmpty();
        return new MazeRsult();
    }

    static List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        if (grid == null || grid.length == 0) {
            return List.of();
        }
        List<Cell> path = new ArrayList<>();
        if (findPath(grid, start, end, path)) {
            return path;
        }
        return List.of();
    }

    private static boolean findPath(boolean[][] grid, Cell start, Cell end, List<Cell> path) {
        if (start.getRow() < 0 || start.getRow() >= grid.length ||
            start.getCol() < 0 || start.getCol() >= grid[0].length ||
            !grid[start.getRow()][start.getCol()] || path.contains(start)) {
            return false;
        }

        path.add(start);

        if (start.getRow() == end.getRow() && start.getCol() == end.getCol()) {
            return true;
        }

        // Explore neighbors: up, down, left, right
        Cell[] directions = {
            new Cell(start.getRow() - 1, start.getCol()), // Up
            new Cell(start.getRow() + 1, start.getCol()), // Down
            new Cell(start.getRow(), start.getCol() - 1), // Left
            new Cell(start.getRow(), start.getCol() + 1)  // Right
        };

        for (Cell next : directions) {
            if (findPath(grid, next, end, path)) {
                return true;
            }
        }

        path.remove(path.size() - 1); // Backtrack
        return false;
    }
}