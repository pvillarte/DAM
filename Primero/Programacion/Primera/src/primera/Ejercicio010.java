/*Calcular el factorial de un número, solo mostrar resultado por consola*/
package primera;

public class Ejercicio010 {
    public static void main (String arg[]){
        int num = 16;
        int acum=1;
        for (int cont=num;cont>0;cont--) //bucle descendente
            acum*=cont;    //Es lo mismo que poner acum=acum*cont
        System.out.println(num+"! = "+acum);
        
        acum=1;
        for (int cont=1;cont<=num;cont++)   //bucle ascendente
            acum*=cont;
        System.out.println(num+"! = "+acum);  
    }
}
