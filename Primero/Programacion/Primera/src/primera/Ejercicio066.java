/*En una cadena de caracteres, para cada palabra, aplica una función que mueva
las letras una posicion a la derecha y la ultima a la primera y viceversa*/
package primera;

public class Ejercicio066 {
    public static void main(String[] arg) {
        char[] frase = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        int longitudPalabra=0;
        for(int i=0;i<frase.length; i++)
            if (frase[i] != ' ')
                longitudPalabra++;
            else{
                desplazaDerecha(frase, longitudPalabra, i);
                //desplazaIzquierda(frase, longitudPalabra, i);
                longitudPalabra=0;    
            }
        System.out.println(frase);       
    }
    
    public static void desplazaIzquierda (char[] f, int longitud, int indice){
        char aux = f[indice-longitud];
        for (int i = 0; i<longitud; i++)
            f[indice-longitud+i]=f[indice-longitud+i+1];
        f[indice-1]=aux;       
    }
    
    public static void desplazaDerecha (char[] f, int longitud, int indice){
        char aux = f[indice-1];
        for (int i = 1; i<longitud; i++)
            f[indice-i]=f[indice-i-1];
        f[indice-longitud]=aux;       
    }
}
