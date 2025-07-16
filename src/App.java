public class App {
    public static void main(String[] args) throws Exception {
        runEjerciciosPD();
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
}
