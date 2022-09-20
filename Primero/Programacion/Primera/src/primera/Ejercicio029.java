/* Acumular las sumas de una tabla por filas en un vector y tambien 
por columnas en otro*/
package primera;

public class Ejercicio029 {
    public static void main (String Arg[]){
        int tabla[][]={{10,20,-30,-40},{50,60,-70,80},{90,100,110,120}};            //Declaramos variables
        int v1[]={0,0,0,0};
        int v2[]={0,0,0};
        for (int fila=0;fila<tabla.length;fila++)                                   //Recorremos el vector
            for (int columna=0; columna<tabla[fila].length;columna++){
                v1[columna] += tabla[fila][columna];                                //Vamos acumulando los valores en los vectores
                v2[fila] += tabla[fila][columna];
            }
        System.out.print("v1 = ");                                                  //Mostramos los dos vectores por pantalla
        for (int i=0;i<v1.length;i++)                                                   
            System.out.printf("%d, ",v1[i]);
        System.out.println();
        System.out.print("v2 = ");
        for (int i=0;i<v2.length;i++)
            System.out.printf("%d, ",v2[i]);
        System.out.println();
    }
}
