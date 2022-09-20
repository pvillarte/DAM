/*Declaración y manipulación de vectores*/
package primera;

public class Ejercicio014 {
    public static void main (String arg[]){
        int datos [] = {17, 55, 33, 21, 88}; //Declaramos el vector y le damos valores
        for (int i=0;i<datos.length;i++)   //datos.length es una propiedad de los vectores que dice por cuantos elementos está formado
            System.out.printf("datos [%d] = %d \n", i, datos[i]);//Mostramos los 5 valores del vector datos (datos[1], datos[2], etc)
        for (int i=0;i<datos.length;i++){
            datos[i] *= 2;                    //multiplicamos cada dato del vector por 2
            System.out.printf("datos [%d] = %d \n", i, datos[i]);  //Mostramos los datos del vector multiplicados por dos
        }
    }
}
