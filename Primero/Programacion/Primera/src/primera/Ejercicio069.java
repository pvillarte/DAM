/*Tenemos que copiar en cadena2 el contenido de frase, dos veces
La primera normal y la segunda, con los caracteres invertidos*/
package primera;

public class Ejercicio069 {
    public static void main(String[] arg) {
        char[] frase = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};   
        char[] cadena2 = new char [frase.length*2];
        for (int i=0; i<frase.length; i++){
            cadena2[i]=frase[i];
            cadena2[frase.length+i]=frase[frase.length-i-1];
        }
        System.out.println(cadena2);
    }
}
