/*
Realizar una función que sea capaz de multiplicar una tabla de enteros de
dimensiones 4*4, por un vector de 4 enteros y devuelva una nueva tabla con el
contenido de dicha multiplicación. Mostrar la tabla resultante por pantalla.
2 Puntos
*/
package examen1PabloVillarteDiestre;

public class Examen003 {
    public static void main(String[] args) {
        int tabla[][] = {{1, 2, 3, 4}, {2, 4, 6, 8}, {3, 6, 9, 12}, {4, 8, 12, 16}};
        int vectorMulti[] = {1, 2, 3, 4};
        int tablaResultante[][] = new int [4][4];
        multiplicacion(tabla, tablaResultante, vectorMulti);
    }

    public static void multiplicacion(int[][] tabla, int[][] tablaResultante, int[] vectorMulti) {
        for (int fila=0; fila<tabla.length; fila++)
            for (int columna=0; columna<tabla[fila].length; columna++)
                tablaResultante[fila][columna] = tabla[fila][columna]*vectorMulti[columna];
        
        for (int fila=0; fila<tabla.length; fila++){
            for (int columna=0; columna<tabla[fila].length; columna++)
                System.out.printf("| %2d ",tablaResultante[fila][columna]);
            System.out.println("|");
        }
    }
}
