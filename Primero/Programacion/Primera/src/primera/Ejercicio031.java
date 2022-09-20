/*Lo mismo que el ejercicio anterior, pero sumando un vectos con preciosKilo
A partir de ahi mostramos los kilos vendidos y el dinero obtenido*/
package primera;

public class Ejercicio031 {
    public static void main (String Arg[]){
        int ventas;
        double precioKilo [] = {1.5, 2.19, 0.79};
        double totalIngresos=0;
        int tabla[][]={{10,20,30,40,5},{50,60,70,80,5},{90,100,110,120,5}};     //Declaramos variables
        String producto[]={"naranjas","peras","melones"};                       //Un vector para tipos de producto 
        for (int tipoProducto=0; tipoProducto<tabla.length;tipoProducto++){     //Filas
            ventas=0;
            for (int dia=0;dia<tabla[tipoProducto].length;dia++)                //Columnas
                ventas += tabla[tipoProducto][dia];
            totalIngresos += (ventas*precioKilo[tipoProducto]);
            System.out.printf("Esta semana se han vendido %d kilos de %s, equivalente a %.2f euros. \n", ventas, producto[tipoProducto],(ventas*precioKilo[tipoProducto]));           
        }
        System.out.printf("La recaudación semanal por la venta de fruta ha sido de %.2f euros. \n",totalIngresos);
    }
}
//Para numeros enteros %d, para string %s, para decimales %f