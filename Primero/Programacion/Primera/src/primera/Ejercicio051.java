/* Combinaciones de 5 elementos tomados de 2 en 2*/
package primera;

public class Ejercicio051 {
    public static void main (String Arg[]){
        int elementos = 12;
        int tomados = 3;
        System.out.printf("Existen %d combinaciones de %d elementos tomados de %d en %d.\n", combinatoria(elementos,tomados), elementos, tomados, tomados);
    }
    
    public static int factorial (int x){
        int resultado = 1;
        for (int i=1; i<=x; i++)
            resultado *= i;
        return resultado;
    }
    
    public static int combinatoria (int n, int m){
        int resultado;
        resultado = factorial(n)/(factorial(n-m)*factorial(m));
        return resultado;
    }
}
