/*Mostrar por pantalla el valor del elemento mayor de un vector y di en que posicion esta*/
package primera;

public class Ejercicio015 {
    public static void main (String arg[]){
        int datos [] = {-5, 7, 999, 3, -3}; //declaramos el vector y le asignamos valores
        int valorMayor = datos[0];   //creamos una variable para el valormaximo, que se ira modificando en el siguiente bucle
        int posicion = 1;
        for (int i=1; i<datos.length; i++){  //iteraciones iguales al numero de valores en el vector
            if (valorMayor<datos[i]){       //en caso de que se cumpla, acutalizamos el valor de el numeroMayor y la posicion
                valorMayor=datos[i];
                posicion=i+1;               
            }
        }
        System.out.printf("El elemento mayor del vector es %d y se encuentra en la %dª posicion \n",valorMayor, posicion); //mostramos resultado por pantalla
        
        int posMax = 0;                     //Metodo alternativo resolucion
        for (int i=1; i<datos.length;i++)
            if (datos[i]>datos[posMax])
                posMax=i;
        System.out.printf("El elemento mayor del vector se encuentra en la %dª posición y vale %d \n", posMax+1, datos[posMax]);
    }  
}
