import java.util.List;

public class Maze {
    private boolean[][] grid;

    public void predefinedMaze() {
        this.grid = new boolean[][] {
            { true, true, true, true },
            { false, true, true, true },
            { true, true, false, false },
            { true, true, true, true },
        };
    }
    public Maze(boolean[][] grid) {
        this.grid = grid;
    }

    public void printMazeWithPathAndVisited(List<Cell> visited, List<Cell> path) {
    char[][] display = new char[grid.length][grid[0].length];

    // Paso 1: inicializar con muros y caminos
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
            display[i][j] = grid[i][j] ? '-' : '*';
        }
    }

    // Paso 2: marcar celdas visitadas con flechas
    for (int i = 0; i < visited.size() - 1; i++) {
        Cell a = visited.get(i);
        Cell b = visited.get(i + 1);
        int dr = b.getRow() - a.getRow();
        int dc = b.getCol() - a.getCol();

        char flecha = '-';
        if (dr == 1 && dc == 0) flecha = 'v';
        else if (dr == -1 && dc == 0) flecha = '^';
        else if (dr == 0 && dc == 1) flecha = '>';
        else if (dr == 0 && dc == -1) flecha = '<';

        display[a.getRow()][a.getCol()] = flecha;
    }

    // Paso 3: marcar última celda del camino con >
    if (!path.isEmpty()) {
        Cell end = path.get(path.size() - 1);
        display[end.getRow()][end.getCol()] = '>';
    }

    // Imprimir
    for (char[] row : display) {
        for (char c : row) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}


    public boolean[][] getGrid() {
        return grid;
    }

}
