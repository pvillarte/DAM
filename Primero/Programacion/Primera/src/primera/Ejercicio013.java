/*División entera mediante restas*/
package primera;

public class Ejercicio013 {
    public static void main (String arg[]){
        int dividendo =7;
        int divisor=2;
        int cociente=0;
        int resto = dividendo;   
        while (resto>=divisor){  //Usamos este bucle al no saber el número de iteraciones
            cociente++;
            resto -= divisor;
        }        
        System.out.println(dividendo+"/"+divisor+" = "+cociente+"    Resto = "+resto);
        System.out.printf("El resultado de %d/%d es %d    Resto = %d \n", dividendo, divisor, cociente, resto);
    }
}
