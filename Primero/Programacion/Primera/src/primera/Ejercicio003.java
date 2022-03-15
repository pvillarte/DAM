/*
Calcula si ambos valores son iguales
*/
package primera;
/*Usamos el debug para depurar código, para ello podemos marcar breakpoints
clicando a la izquierda donde marca las líneas. El programa se ejecuta hasta 
allí. Luego podemos ir ejecutando paso a paso.
*/

public class Ejercicio003 {
    public static void main (String arg[]){
        int x = 78;
        int y = 77;
        if(x==y)
            System.out.println("x e y son iguales y valen "+x);
        else if (x>y)
            System.out.println("El mayor es: "+x);
            else
            System.out.println("El mayor es: "+y);
        System.out.println("Fin de ejecución");
       
    }
}
