/*Invertir el contenido de una cadena en otra cadena*/
package primera;

public class Ejercicio068 {
    public static void main(String[] arg) {
        char[] frase = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};   
        char[] fraseInvertida = new char [frase.length];
        for (int i=0; i<frase.length; i++){
            fraseInvertida[i]=frase[frase.length-i-1];
        }
        System.out.println(frase);
        System.out.println(fraseInvertida);
    }
}
