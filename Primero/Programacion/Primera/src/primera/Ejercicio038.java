/*Partiendo con una tabla de 4*4 con números del 1 al 16
Transportarlos a otra tabla que estara en un principio vacía intercambiando 
filas por columnas*/
package primera;

public class Ejercicio038 {
    public static void main (String Arg[]){
        //Declaramos las dos tablas
        int tabla1 [][]={{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12},{13, 14, 15, 16}};
        int tabla2 [][]= new int [4][4]; //Otra forma de declarar tablas con todo ceros
        
        //Metemos valores tabla1 en tabla2 intercambiando filas por columnas
        for (int numFila=0; numFila<tabla1.length; numFila++)
            for (int numColu=0; numColu<tabla1[numFila].length;numColu++)
                tabla2 [numFila][numColu] = tabla1[numColu][numFila];
        
        //Mostramos tabla2 para comprobar resultado
        for (int numFila=0; numFila<tabla2.length; numFila++){
            for (int numColu=0; numColu<tabla2[numFila].length;numColu++)
                System.out.printf("%2d   ", tabla2[numFila][numColu]); 
            System.out.println();
        }
    }   
}
