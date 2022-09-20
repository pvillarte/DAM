/*Desplaza todos valores del vector hacia la derecha y el último al primer lugar*/
package primera;

public class Ejercicio021 {
    public static void main (String arg[]){
        int datos[]={10,20,30,40,50,60};
        int aux = datos[datos.length-1];
        for (int i=(datos.length-1);i>0;i--)
            datos[i]=datos[i-1];
        datos[0]= aux;
        for (int i=0;i<datos.length;i++)                            //Bucle para mostrar el vector por pantalla
            System.out.printf ("datos[%d] = %d \n",i, datos[i]);   
    }
}
