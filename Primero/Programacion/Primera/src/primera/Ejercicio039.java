/*Intercambiar filas por columnas*/
package primera;

public class Ejercicio039 {
    public static void main (String Arg[]){
        //Declaramos la tabla principal y una auxiliar
        int tabla1 [][]={{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12},{13, 14, 15, 16}};
        int aux = 0; 
            
        //Cambiamos filas por columnas haciendo intercambios unicamente cuando numColu > numFila
        for (int numFila=0; numFila<(tabla1.length-1); numFila++)
            for (int numColu=0; numColu<tabla1[numFila].length;numColu++)
                if (numFila < numColu){
                    aux = tabla1 [numFila][numColu];
                    tabla1 [numFila][numColu] = tabla1 [numColu][numFila];
                    tabla1 [numColu][numFila] = aux;                       
                } 
        
        /* Método alternatico (mostrado por Agustín)
        for (int numFila=0; numFila<(tabla1.length-1); numFila++)
            for (int numColu=numFila; numColu<tabla1[numFila].length;numColu++){
                aux = tabla1 [numFila][numColu];
                tabla1 [numFila][numColu] = tabla1 [numColu][numFila];
                tabla1 [numColu][numFila] = aux;                       
            }         
        */
                  
        //Mostramos la tabla para comprobar resultado
        for (int numFila=0; numFila<tabla1.length; numFila++){
            for (int numColu=0; numColu<tabla1[numFila].length;numColu++)
                System.out.printf("%2d   ", tabla1[numFila][numColu]); 
            System.out.println();
        } 
    }
}
