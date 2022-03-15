/*Desplaza todos valores del vector hacia la izquierda y el primero al ultimo lugar*/
package primera;

public class Ejercicio020 {
   public static void main (String arg[]){
       int datos[]={10,20,30,40,50,60,70,80};
       int aux=datos[0];
       for (int i=0; i<(datos.length-1);i++)
           datos[i]=datos[i+1];
       datos[datos.length-1] = aux;
        for (int i=0;i<datos.length;i++)                            //Bucle para mostrar el vector por pantalla
            System.out.printf ("datos[%d] = %d \n",i, datos[i]);   
   } 
}
