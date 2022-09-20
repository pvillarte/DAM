/*Crear una función que devuelva la suma de todos los elementos de una
tabla de enteros*/
package primera;

public class Ejercicio047 {
    public static void main (String Arg[]){
        int salarios[][] = {{700, 900, 1300, 800, 790, 850}, {1000, 950, 1080, 1070, 1200, 1100}, {1300, 930, 1200, 1170, 1000, 1000}, {1500, 1950, 1880, 1978, 2200, 2100}};
        System.out.printf("La suma de todos valores de la tabla de salarios es %d euros\n",sumaTabla(salarios));
    }
    
    public static int sumaTabla (int tabla[][]){
        int acum = 0;
        for (int i = 0; i<tabla.length; i++)
            for (int j = 0; j<tabla[i].length; j++)
                acum += tabla[i][j];
        return acum;   
    }
}
