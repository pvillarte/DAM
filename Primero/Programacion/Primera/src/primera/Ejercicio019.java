/*Calcular valor promedio de los elementos contenidos en el vector*/
package primera;

public class Ejercicio019 {
    public static void main (String arg[]){
        int datos[] = {50,150,-200,100,-250};
        int acum=0;
        int promedio;
        for (int i=0;i<datos.length;i++){
            acum += datos[i];   
        }
        promedio=acum/datos.length;
        System.out.printf ("El valor promedio de todos datos del vector es %d \n",promedio);
    }
}
