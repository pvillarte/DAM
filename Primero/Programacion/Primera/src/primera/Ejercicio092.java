/*Division entera mediante restas*/
package primera;

public class Ejercicio092 {
    public static void main(String[] args) {
        int cociente = dividir(17, 3);
        System.out.println(cociente);
    }
    
    public static int dividir (int dividendo, int divisor) {
        if (dividendo<divisor)
            return 0;
        else
            return dividir(dividendo-divisor, divisor)+1;
    }
}
