/*Invertir el contenido de los elementos del vector*/
package primera;

public class Ejercicio017 {
    public static void main (String arg[]){
        int datos[]={1,2,3,4,5};
        int aux;
        for (int i =0;i<(datos.length/2);i++){
            aux = datos [i];
            datos [i] = datos [datos.length-1-i];
            datos [datos.length-1-i] = aux;
        }
        for (int i=0; i<datos.length ; i++)
            System.out.printf("datos [%d] = %d \n", i, datos[i]);
    }    
}
