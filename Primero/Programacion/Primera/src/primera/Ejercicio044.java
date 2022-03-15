/*Ordenacion de un vector por método de selección directa*/
package primera;

public class Ejercicio044 {
    public static void main (String Arg[]){
        int vector[] = {25, 2, 73, 81, 16, 4, 33};
        int aux=0; 
        int j;
        
        for (int i=1; i<vector.length; i++){
            j=i;
            while ((j>0) && (vector[j]<vector[j-1])){
                aux = vector[j-1];
                vector[j-1]=vector[j];
                vector[j] = aux;
                j--;
            }
        }
        
        //Mostramos vector por pantalla
        System.out.print("vector = {  ");        
        for (int i=0; i<vector.length;i++)
            System.out.printf("%d  ", vector[i]);
        System.out.print("}");         
    } 
}
