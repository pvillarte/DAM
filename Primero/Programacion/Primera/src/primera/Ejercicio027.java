/*Modificar la tabla de manera que los negativos pasen a ser positivos y los
positivos se multipliquen por 5*/
package primera;

public class Ejercicio027 {
    public static void main (String Arg[]){
        int tabla[][] = {{10,15,-30,-50},{5,4,-17,-70},{19,-79,7,-99}}; //Declaramos la tabla
        for (int fila = 0; fila<tabla.length;fila++){                   //Recorremos filas
            for (int columna=0;columna<tabla[fila].length;columna++){   //Recorremos columnas
                if (tabla[fila][columna]<0)                             //Para valores negativos, los convertimos a positivos
                    tabla[fila][columna]*= -1;
                else                                                    //Para los postivos, multiplicamos por 5
                    tabla[fila][columna]*= 5;
                System.out.printf("%d    ", tabla[fila][columna]);      //Mostramops el valor, ya modificado
            }
            System.out.println();                                       //Tras cada fila, pasamos de línea
        }
    }
}
