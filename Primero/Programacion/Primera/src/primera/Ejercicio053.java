/*Tenemos una tabla de enteros y un entero llamado multiplicador.
queremos modificar el contenido de todos los elementos de la tabla multiplcando
cada uno de ellos por el multiplicador. Para esto crearemos una función*/
package primera;

public class Ejercicio053 {
    public static void main (String Arg[]){
        int tabla [][] = {{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12},{13, 14, 15, 16}};
        int multiplicador = 4;
        multiplicaTablaPorEntero(tabla, multiplicador);
        muestraTabla(tabla);
    }
    public static void multiplicaTablaPorEntero(int tabla[][], int multi){
        for (int i = 0 ; i<tabla.length; i++)
            for (int j=0; j< tabla[i].length; j++)
                tabla [i][j] *= multi;
    }
    public static void muestraTabla (int tabla [][]){
        for (int i = 0 ; i<tabla.length; i++){
            for (int j=0; j< tabla[i].length; j++)
                System.out.printf("| %2d |", tabla[i][j]);
            System.out.println();
        }
    }
}
