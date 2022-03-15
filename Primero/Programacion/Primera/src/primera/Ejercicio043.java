/*Ordenacion de un vector por método de selección directa*/
package primera;

public class Ejercicio043 {
    public static void main (String Arg []){
        int vector[] = {25, 2, 73, 81, 16, 4, 33};
        int aux;        
        int posMin;
        
        for (int j = 0; j<vector.length-1; j++){
            posMin=j;
            for (int i = j; i<vector.length; i++)
                if (vector[i]<vector[posMin])
                    posMin = i;
            aux = vector[j];
            vector [j]=vector[posMin];
            vector [posMin]= aux;
        }
        
        //Mostramos vector por pantalla
        System.out.print("vector = {  ");           
        for (int i=0; i<vector.length; i++)
            System.out.printf("%d  ", vector[i]);
        System.out.print("}");        
        
    }
}
