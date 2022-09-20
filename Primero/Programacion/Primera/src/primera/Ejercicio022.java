/*Bucles anidados*/
package primera;

public class Ejercicio022 {
        public static void main (String arg[]){
            for(int i=0; i<5; i++){             //Bucle principal
                System.out.println ("Fila: "+i);  //Esto se ejecuta 5 veces
                for (int j=0;j<5;j++)           //Bucle anidado
                    System.out.println("Fila: "+i+" Columna: "+j); //Esto se ejecuta 25 veces (5*5)
            }
        }    
}