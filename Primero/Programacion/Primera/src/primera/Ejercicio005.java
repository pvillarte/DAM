/*
Calcular si x es un número par o impar
*/
package primera;

public class Ejercicio005 {
    public static void main (String arg[]){
        int x = 8;
        int resto = x%2; //El porcentaje sirve para calcular el resto
        if(resto==0)
            System.out.println (x+" es un número par");
        else
            System.out.println (x+" es un número impar");
    }  
}
