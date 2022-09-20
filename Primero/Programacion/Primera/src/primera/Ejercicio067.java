/*Escribe el contenido de la frase en cadena2 dos veces*/
package primera;

public class Ejercicio067 {
    public static void main(String[] arg) {
        char[] frase = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};   
        int repeticiones = 5;
        char[] cadena2 = new char [frase.length*repeticiones];
        repetirCadena(repeticiones, frase, cadena2);
        System.out.println(cadena2);
    }

    public static void repetirCadena(int repeticiones, char[] frase, char[] cadena2) {
        for (int rep=0; rep<repeticiones; rep++)
            for (int i=0; i<frase.length; i++)
                cadena2[(rep*frase.length)+i]=frase[i];
    }
}
