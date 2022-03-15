/* Intercambiar diagonales de la matriz*/
package primera;

public class Ejercicio040 {
    public static void main (String Arg[]){
        //Declaramos la tabla principal y una variable auxiliar
        int tabla [][]={{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12},{13, 14, 15, 16}};
        int aux = 0;
        
        //Cambiamos diagonales haciendo cambios cuando numColu == numFila
        for (int numFilaColu=0; numFilaColu<(tabla.length); numFilaColu++){
                    aux = tabla [numFilaColu][numFilaColu];
                    tabla [numFilaColu][numFilaColu] = tabla [numFilaColu][tabla.length-(numFilaColu+1)];
                    tabla [numFilaColu][tabla.length-(numFilaColu+1)] = aux;                       
                }
        
        //Mostramos por pantalla
        for (int numFila=0; numFila<tabla.length; numFila++){
            for (int numColu=0; numColu<tabla[numFila].length;numColu++)
                System.out.printf("%2d   ", tabla[numFila][numColu]); 
            System.out.println();
        }         
    }
}
