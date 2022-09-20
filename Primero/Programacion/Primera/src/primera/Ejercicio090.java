/*Realizarr una función recursiva que realice la multiplicación de dos números
mediante sumas*/
package primera;

public class Ejercicio090 {
    public static void main(String[] args) {
        int resultado = multiplicar(4, 12);
        System.out.println(resultado);
    }
    
    public static int multiplicar (int a, int b){
    if (b==0)
        return 0;
    else
        return a+multiplicar(a, b-1);
    }
}
