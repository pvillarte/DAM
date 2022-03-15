/*Mostrar por pantalla las tablas de multiplicar*/
 
package primera;

public class Ejercicio025 {
    public static void main (String arg[]){
        for(int i=1; i<10; i++){             //Bucle principal
            System.out.println ("TABLA DEL "+i);  //Esto se ejecuta i veces
            for (int j=1;j<=10;j++) {          //Bucle anidado
                int resultado = i*j;
                System.out.printf("%d*%d = %d \n",i,j,resultado); //Esto se ejecuta i*j veces 
            }
            System.out.println();
        }
    }      
}
