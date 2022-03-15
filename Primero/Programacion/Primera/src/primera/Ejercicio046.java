/*Hacer una función que devuelva el valor máximo de un vector de enteros*/
package primera;

public class Ejercicio046 {
    public static void main (String Arg[]){
        int vector1[] = {24, 45, 65, 12, 7, 123, 16, 50};
        int vector2[] = {2, 45, 650, 2, 7, 13, 16, 55};   
        
        System.out.printf("El valor máximo del vector es %d \n", maximo(vector1));
        System.out.printf("El valor máximo del vector es %d \n", maximo(vector2));
    }
    public static int maximo(int vector[]){
        int posMax = 0;
        for (int i= 1; i<vector.length; i++)
            if (vector[i]>vector[posMax])
                posMax=i;
        return(vector[posMax]);
    }
    
}
