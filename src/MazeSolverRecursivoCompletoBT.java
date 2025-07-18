import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MazeSolverRecursivoCompletoBT implements MazeSolver {
    private boolean[][] grid;
    private Cell end;
    ArrayList<Cell> path;
    HashSet<Cell> visited;

    public MazeSolverRecursivoCompletoBT() {
        path = new ArrayList<>();
        visited = new HashSet<>();
    }

    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        path.clear();
        visited.clear();
        this.grid = grid;
        this.end = end;

        if (grid == null || grid.length == 0) {
            return path;
        }
        if (findPath(start)) {
            System.out.println("RUTA VISITADA");
            System.out.println(visited);
            System.out.println("RUTA OPTIMA");
            System.out.println(path);
            return path;
        }
        return new ArrayList<>();
    }

    private boolean findPath(Cell current) {
        if (!isMaze(current)) {
            return false;

        }
        if (!isValid(current)) {
            return false;

        }
        path.add(current);
        visited.add(current);
        if (current.equals(end)) {
            return true;
        }
        //Me muevo en las cuatro direcciones
        if (findPath(new Cell(current.row,current.col + 1))||// Derecha
            findPath(new Cell(current.row+1,current.col))||// Abajo
            findPath(new Cell(current.row,current.col - 1))||// Izquierda       
            findPath(new Cell(current.row-1,current.col))// Arriba
            
            ) { 
            return true;
            
        }
        return false; // No path found

    }

    private boolean isMaze(Cell current) {
        int row = current.getRow();
        int col = current.getCol();
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return false;

        }
        return true;
    }

    public boolean isValid(Cell current) {
        int row = current.getRow();
        int col = current.getCol();
        if (!grid[row][col] || visited.contains(current)) {
            return false;
        }
        return true;
    }
}
