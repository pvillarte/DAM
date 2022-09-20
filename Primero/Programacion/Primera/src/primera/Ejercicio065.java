/*Invierte el orden de la primera y la última
letra de cada palabra de la cadena de caracteres*/
package primera;

public class Ejercicio065 {
    public static void main(String[] arg) {
        char[] frase = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        int longitudPalabra=0;
        char aux=' ';
        for(int i=0;i<frase.length; i++)
            if (frase[i] != ' ')
                longitudPalabra++;
            else{             
                aux = frase[i-1];
                frase[i-1]= frase[i-longitudPalabra];
                frase[i-longitudPalabra]=aux;
                longitudPalabra=0;    
            }
        System.out.println(frase);
    }
}
