/* Tendremos un array bidimensional de doubles con los kilos vendidos de dos
productos cada día de la semana
Y un vector de doubles con los precios de los dos productos
Hacer una función que sea capaz de modificar el contenido de la tabla, 
multiplicando los kilos por el precio del producto*/
package primera;

public class Ejercicio054 {
    public static void main (String Arg[]){
        double ventas[][] = {{14, 22, 33, 41, 22, 31},{15, 23, 41, 16, 27, 18}};
        double preciosKilo[] = {3.55, 2.22};
        calculoIngresos(ventas, preciosKilo);
        muestraTabla(ventas);
    }
    public static void calculoIngresos (double tabla[][], double multi[]){
        for (int i = 0 ; i<tabla.length; i++)
            for (int j=0; j< tabla[i].length; j++)
                tabla[i][j] *= multi[i]; 
    }
    
    public static void muestraTabla (double tabla [][]){
        for (int i = 0 ; i<tabla.length; i++){
            for (int j=0; j< tabla[i].length; j++)
                System.out.printf("| %6.2f |", tabla[i][j]);
            System.out.println();
        }
    }
    
}
