public class EjerciciosPD {

    /**
     * Calcula el n-ésimo número de Fibonacci de forma iterativa.
     * 
     * @param n posición deseada en la serie de Fibonacci.
     * @return el número de Fibonacci en la posición n.
     */
    public int getFibonacci(int n) {
        return (n <= 1) ? Math.max(n, 0) : getFibonacci(n - 1) + getFibonacci(n - 2);
    }

    public int getFibonacciPD(int n) {
        if (n <= 1)
            return Math.max(n, 0);
        int[] f = new int[n + 1];
        f[1] = 1;
        for (int i = 2; i <= n; i++)
            f[i] = f[i - 1] + f[i - 2];
        return f[n];
    }

}
