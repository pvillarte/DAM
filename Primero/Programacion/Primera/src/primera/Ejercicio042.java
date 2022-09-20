/*Ordenacion de un vector por método de la burbuja*/
package primera;

public class Ejercicio042 {
    public static void main (String Arg []){
        int vector[] = {25, 2, 73, 81, 16, 4, 33};
        int aux;
        
        for (int j=0; j<vector.length-1; j++)        //Cada vez que ordenamos uno, el bucle siguiente no tiene que llegar hasta 0
            for (int i=vector.length-1; i>j; i--)    //Ordenamos valores de uno en uno comparandolo con los anteriores
                if (vector[i]<vector[i-1]){
                    aux=vector[i];
                    vector[i]=vector[i-1];
                    vector[i-1]=aux;           
                }
        
        //Mostramos vector por pantalla
        System.out.print("vector = {  ");           
        for (int i=0; i<vector.length; i++)
            System.out.printf("%d  ", vector[i]);
        System.out.print("}");
    }   
}
