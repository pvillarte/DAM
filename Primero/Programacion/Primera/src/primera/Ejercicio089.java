/*Calcula el factorial de un número por medio de la recursividad*/
package primera;

public class Ejercicio089 {
    public static void main(String[] args) {
        int resultado = factorial(5);
        System.out.print(resultado);
    }
    public static int factorial (int a){
        if (a==1){
            return 1;
        }else{
            return a*factorial(a-1);
        }
    }
}
