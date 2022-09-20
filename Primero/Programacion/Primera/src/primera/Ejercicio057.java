/* Implementar una función que modifique el conetido  de la tabla de los kilos,
multiplicando por el multiplicador, los elementos de los que se hayan vendido
menos de 10 kilos*/
package primera;

public class Ejercicio057 {
    public static void main (String Arg[]){
        int kilos[][] = {{1, 22, 3, 41, 22, 31},{15, 23, 1, 16, 2, 18}};
        String productos[] = {"Peras", "Manzanas"};
        int multiplicador = 5;
        modificar(kilos, multiplicador);
        muestraTabla(kilos, productos);
    }
    
    public static void modificar (int tabla[][], int multi){
        for (int i=0; i<tabla.length; i++)
            for (int j = 0; j<tabla[i].length;j++)
                if (tabla[i][j]<10)
                    tabla[i][j] *= multi;
    }
    
    public static void muestraTabla (int tabla [][], String productos[]){
        for (int i = 0 ; i<tabla.length; i++){
            System.out.printf("Tabla de %s modificada : { ", productos[i]);            
            for (int j=0; j< tabla[i].length; j++)
                System.out.printf("%d ", tabla[i][j]);
            System.out.println("}");
        }
    }
}
