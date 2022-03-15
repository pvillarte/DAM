/*Primer ejercicio con tablas*/
package primera;

public class Ejercicio026 {
    public static void main (String Arg[]){
        int tabla[][] ={{10,20,30,40},{50,60,70,80},{90,10,11,12}};
        for (int fila=0;fila <tabla.length;fila++){
            for (int columna=0;columna<tabla[fila].length;columna++)
                System.out.printf("%d     ", tabla[fila][columna]);
            System.out.println();
        }
    }
}
