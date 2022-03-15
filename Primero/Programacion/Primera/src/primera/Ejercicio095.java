/*Pasar un número de decimal a binario*/
package primera;

public class Ejercicio095 {
    public static void main(String[] args) {
        int numero = 29; //En binario es 11101
        decimalABinario(numero);
        System.out.println();
    }
    
    public static void decimalABinario (int num){
        if (num>0){
            decimalABinario(num/2);
            System.out.print(num%2);
        }
    }
}
