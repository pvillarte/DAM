/*
Calcula el mayor valor entre tres variables
*/
package primera;

public class Ejercicio004 {
     public static void main (String arg[]){
        int x = 50;
        int y = 5;
        int z = 5;
        if (x==y){
            if (y==z)
                System.out.println("Los tres valores son iguales a "+x);
        }
        if (x>y){
            if (x>z)
                System.out.println("x es el mayor y vale "+x);
            else 
                System.out.println("z es el mayor y vale "+z);              
        }else if (y>z)
            System.out.println("y es el mayor y vale "+y);
        else if (z>y)
            System.out.println("z es el mayor y vale "+z);
     }
}