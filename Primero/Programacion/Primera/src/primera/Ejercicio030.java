/* Mostrar por pantalla cuánto se ha vendido de cada producto,
sin utilizar vector auxiliar*/

package primera;

public class Ejercicio030 {
    public static void main (String Arg[]){
        int ventas;
        int tabla[][]={{10,20,30,40,5},{50,60,70,80,5},{90,100,110,120,5}};     //Declaramos variables
        String producto[]={"naranjas","peras","melones"};                       //Un vector para tipos de producto                                                    //Un vector para ventas acumuladas
        for (int tipoProducto=0;tipoProducto<tabla.length;tipoProducto++){      //Recorremos los distintos productos(filas) del vector
            ventas=0;                                                           //Una misma variable para acumular kilos vendidos
            for (int dia=0;dia<tabla[tipoProducto].length;dia++)                //Recorremos los dias de la semana (columnas) del vector
                ventas += tabla[tipoProducto][dia];
            System.out.printf("Esta semana se han vendido %d kilos de %s. \n",ventas, producto[tipoProducto]);
        }
    }
}
