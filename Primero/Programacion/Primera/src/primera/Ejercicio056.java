/* Implementar una función que devuelva un vector con el número de kilos
vendidos de cada producto
En el programa principal mostrar los resultados*/
package primera;

public class Ejercicio056 {
    public static void main (String Arg[]){
        int kilos[][] = {{14, 22, 33, 41, 22, 31},{15, 23, 41, 16, 27, 18}};
        String productos[] = {"Peras", "Manzanas"};
        int totalKilos [] = new int [productos.length];
        sumarKilosProducto(kilos, totalKilos);
        for (int i=0; i<totalKilos.length; i++)
            System.out.printf("Se han vendido %d kilos de %s\n", totalKilos[i], productos[i]);
        
        //Método alternativo        
        int sumaDeKilos[]= sumarKilos(kilos);
        for (int i=0; i<sumaDeKilos.length; i++)
            System.out.printf("Se han vendido %d kilos de %s\n", sumaDeKilos[i], productos[i]);
    }
        
    public static void sumarKilosProducto (int kilos[][],  int total[]){
        for (int i=0; i<kilos.length; i++)
            for (int j = 0; j<kilos[i].length;j++)
                total[i] += kilos[i][j];
    }
    
    //Método alternativo
    public static int[] sumarKilos (int kilos[][]){
        int vector[] = {0, 0};
        for (int i=0; i<kilos.length; i++)
            for (int j = 0; j<kilos[i].length;j++)
                vector[i] += kilos[i][j];
        return vector;
    }
}
