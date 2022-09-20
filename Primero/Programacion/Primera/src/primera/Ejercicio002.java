/*
Calcula si un número es o no mayor que el otro
*/
package primera;


public class Ejercicio002 {
    public static void main (String arg[]){
        int x, y;    //Definimos variables
        x = 65;      //Damos un valor a las variables
        y = 44;
        if (x>y){
           System.out.println("El mayor es "+x); //Si mas de una condición, las llaves obligatorias
           System.out.println("Se imprime");
        }else
            System.out.println("El mayor es "+y);//Para una condición, no hace falta parentesis 
        System.out.println("Fin de ejecución");//Esto queda fuera del else
    }
}
