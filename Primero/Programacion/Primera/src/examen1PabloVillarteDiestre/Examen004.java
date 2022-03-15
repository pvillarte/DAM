/*
Calcular el máximo común divisor de dos números mediante el algoritmo de
Euclides, que consiste en ir restando el número más pequeño del más grande,
hasta que queden dos números iguales.
a) Hacerlo con un bucle.  1,5 puntos
b) Hacerlo con recursividad.  1,5 puntos
*/
package examen1PabloVillarteDiestre;

public class Examen004 {
    public static void main(String[] args) {
        //Apartado A
        int numero1 = 21;
        int numero2 = 6;
        System.out.printf("El máximo común divisor de %d y %d es: ", numero1, numero2);
        while (numero1 != numero2){
            if (numero1>numero2)
                numero1 -= numero2;
            else
                numero2 -= numero1;
        }
        System.out.println(numero1);
        
        //Apartado B
        numero1 = 36;
        numero2 = 8;
        int mcd = euclides(numero1, numero2);
        System.out.printf("El máximo común divisor de %d y %d es: %d\n", numero1, numero2, mcd);
    }
    
    public static int euclides(int a, int b){
        if (a != b){
            if(a>b)
                return euclides(a-b, b);
            else
                return euclides(a, b-a);
        } else
            return a;
    }
}
