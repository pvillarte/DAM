/*En un vector de enteros, modificar el contenido de sus elementos, convirtiendo a los negativos en positivos y multiplicando los positivos por dos
 */
package primera;

public class Ejercicio018 {
    public static void main (String arg[]){
        int datos [] = {2, -4, 4, -8, -5, 7};                       //Declaramos el vector
        for (int i=0; i<datos.length;i++){                          //Bucle para pasar por cada uno de los datos del vector
            if (datos[i]<0)                                         //Si es negativo, le cambiamos el signo multioplicando por -1
                datos[i] *= -1;
            else                                                    //En caso contrario, multiplicamos por 2
                datos [i] *= 2;
            }
        for (int i=0;i<datos.length;i++)                            //Bucle para mostrar el vector por pantalla
            System.out.printf ("datos[%d] = %d \n",i, datos[i]);   
    }
}