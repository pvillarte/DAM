/*
Mostrar por pantalla si la variable introducida termina en 5 o no
*/
package primera;

public class Ejercicio006 {
    public static void main (String arg[]){
        int x = 55;
        if ((x%10)==5)
            System.out.println ("El número acaba en 5");
        else 
            System.out.println ("El número no acaba en 5");     
    }   
}
/*Dividiendo entre 10 evitamos realizar dos operaciones, puesto que si el resto
es 5 ya englobamos todos posibe resultados
*/