/* Tenemos lo  mismo que en el ejercicio anterior, pero cargaremos los resultados
de las modificaciones en una tabla llamada ventas*/
package primera;

public class Ejercicio055 {
    public static void main (String Arg[]){
        int kilos[][] = {{14, 22, 33, 41, 22, 31},{15, 23, 41, 16, 27, 18}};
        double preciosKilo[] = {3.55, 2.22};
        double ventas[][]= new double [kilos.length][kilos[0].length];
        calculoIngresos(kilos, preciosKilo, ventas);
        muestraTablaInt(kilos);
        muestraTablaD(ventas);
        
    }
    public static void calculoIngresos (int kilos[][], double multi[], double ventas[][]){
        for (int i = 0 ; i<kilos.length; i++)
            for (int j=0; j< kilos[i].length; j++)
                ventas [i][j] = kilos [i][j]*multi[i];
    }
    
    public static void muestraTablaD (double tabla [][]){
        System.out.println("Ingresos");
        for (int i = 0 ; i<tabla.length; i++){
            for (int j=0; j< tabla[i].length; j++)
                System.out.printf("| %6.2f |", tabla[i][j]);
            System.out.println();
        }
    }
    
    public static void muestraTablaInt (int tabla [][]){
        System.out.println("Kilos vendidos");
        for (int i = 0 ; i<tabla.length; i++){
            for (int j=0; j< tabla[i].length; j++)
                System.out.printf("| %2d |", tabla[i][j]);
            System.out.println();
        }    
    }
}
