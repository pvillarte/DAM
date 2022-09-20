/*
Mostrar por pantalla si un número es multiplo de otro o no lo es
*/
package primera;

public class Ejercicio007 {
    public static void main (String arg[]){
        int x = 3;
        int y = 21;
        int aux; //Definimos variable auxiliar para cambiar valores entre x e y
        if (x<y){
            aux=x;
            x=y;
            y=aux;      
        }
        if ((x%y)==0)
            System.out.println (x+" es multiplo de "+y);
        else 
            System.out.println ("Ningún número es multiplo del otro");            
    } 
}
