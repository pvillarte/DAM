/*Dado un número entero que se encuentra dentro de una variable, diseccionarlo,
analizándolo hasta las centenas de millar.*/
package primera;

public class Ejercicio094 {
    public static void main(String[] args) {
        int numero = 320765;
        String[] unidades={" Centenas de millar", " Decenas de millar", " Unidades de millar", " Centenas", " Decenas", " Unidades"};
        
        analiza(numero, unidades);
        System.out.println();
        numero = 320765;
        
        analizaRecursivo(numero, unidades, 0);
        System.out.println();
        numero = 320765;
        
        mostrar(numero, unidades, 0);  //Solucion dada en clase
    }

    public static void analiza(int numero, String[] unidades) {
        int i=0;
        while (numero/10 != 0){
            System.out.println((numero%10)+unidades[unidades.length-i-1]);
            numero /= 10;
            i++;
        }
        System.out.println((numero%10)+unidades[unidades.length-i-1]);
    }
    
    public static void analizaRecursivo (int num, String[] uni, int j){
        if (num < 10){
            System.out.println((num%10)+uni[(uni.length-1)-j]);
        }else{
            analizaRecursivo(num/10, uni, ++j);
            System.out.println((num%10)+uni[uni.length-j]);
        }
    }
    
    public static void mostrar (int num, String[] uni, int i){
        if (num > 0){
            mostrar(num/10, uni, ++i);
            System.out.println((num%10)+uni[uni.length-i]);
        }
    }
}
