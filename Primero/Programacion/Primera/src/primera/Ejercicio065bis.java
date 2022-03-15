/*Invierte el orden de las letras de las palabras de la cadena de caracteres*/
package primera;

public class Ejercicio065bis {
    public static void main(String[] arg) {
        char[] frase = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        int longitudPalabra=0;
        char aux=' ';
        for(int i=0;i<frase.length; i++)
            if (frase[i] != ' ')
                longitudPalabra++;
            else{
                for(int j=0 ; j<longitudPalabra/2; j++){
                    aux = frase[i-j-1];
                    frase[i-j-1]= frase[i-longitudPalabra+j];
                    frase[i-longitudPalabra+j]=aux;
                }
                longitudPalabra=0;    
            }
        System.out.println(frase);       
    }
}
