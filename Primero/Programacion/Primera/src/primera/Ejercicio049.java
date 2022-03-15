/*Crear una función capaz de ordenar un vector*/
//el siguiente ordenar cada uno de los 4 vectores de salarios
package primera;

public class Ejercicio049 {
    public static void main (String Arg[]){
        int v1[] = {30, 5, 7, 1};
        ordenaVector(v1);
        muestraVector(v1);
    }
    
    public static void ordenaVector (int vector[]){
    int aux;
    for (int j=0; j<vector.length-1; j++)
        for (int i=vector.length-1; i>j; i--)
            if (vector[i]<vector[i-1]){
                aux = vector[i-1];
                vector[i-1] = vector[i];
                vector[i] = aux;
            }
    }
    
    public static void muestraVector (int vector[]){
        System.out.print("v1 = { | "); 
        for (int i=0; i<vector.length; i++)
            System.out.print(vector[i]+" | ");
        System.out.println("}"); 
    }
}
