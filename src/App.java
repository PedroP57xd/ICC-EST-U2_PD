
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // runEjerciciosPD();
        runMaze();
    }

    public static void runEjerciciosPD() {
        EjerciciosPD ejerciciosPD = new EjerciciosPD();
        System.out.println("Ejercicios de Programación Dinámica");
        int start = (int) System.nanoTime();
        int resultado = ejerciciosPD.getFibonacci(50);
        int end = (int) System.nanoTime();
        int duracion = end - start;
        System.out.println("Resultado " + resultado + ", en duracion: " + duracion + " ms");

        System.out.println("Ejercicios de Programación Dinámica con optimización");
        start = 0;
        resultado = ejerciciosPD.getFibonacciPD(50);
        end = (int) System.nanoTime();
        duracion = end - start;
        System.out.println("Resultado " + resultado + ", en duracion: " + duracion + " ms");
    }
    public static void runMaze(){
        boolean[][] predefinedMaze = {
            { true, true, true, true },
            { false, true, true, true },
            { true, true, false, false },
            { true, true, true, true },
        };
    Maze maze = new Maze(predefinedMaze);
    System.out.println("Laberinto cargado");
    MazeSolverRecursivoCompletoBT solver = new MazeSolverRecursivoCompletoBT();
List<Cell> path = solver.getPath(maze.getGrid(), start, end);
List<Cell> visited = solver.getVisitedAsList();

System.out.println("Laberinto con flechas:");
maze.printMazeWithPathAndVisited(visited, path);

    Cell start = new Cell(0, 0);
    Cell end = new Cell(3, 3);
    List<MazeSolver> solvers = Arrays.asList(
        new MazeSolverRecursivo(),
        new MazeSolverRecursivoCompletoBT()

    );
    MazeSolver solver = solvers.get(1);
    List<Cell> path ;
    path = MazeSolver.getPath(maze.getGrid(), start, end);
    System.out.println(path);
    }

}
