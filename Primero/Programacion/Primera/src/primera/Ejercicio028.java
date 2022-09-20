/* Tenemos una tabla de 3*4 y cada elemento de la primera fila los multiplicaremos
por un numero, cada uno de la segund por otro y la tercera por otro
Dichos números seran un vector*/
package primera;


public class Ejercicio028 {
    public static void main (String Arg[]){
        int tabla[][] = {{10,15,-3,-5},{5,4,-17,-7},{13,-9,7,-9}};              //Declaramos la tabla
        int vector [] = {2,-4,5};                                               //Declaramos el vector
        for (int fila = 0; fila<tabla.length;fila++){                           //Recorremos filas
            System.out.printf("tabla[%d] = ", fila); 
            for (int columna = 0; columna<tabla[fila].length;columna++)         //Recorremos columnas
                System.out.printf ("%d, ",tabla[fila][columna]*vector[fila]);   //Mostramos resultado con operaciones necesarias
        System.out.println(); 
        }     
    }
}
