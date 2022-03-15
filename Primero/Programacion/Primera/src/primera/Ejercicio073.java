/*Tenemos una frase y una palabra a eliminar. Debemos eliminar esa palabra
de la frase. Sin cadena auxiliar*/
package primera;

public class Ejercicio073 {

    public static void main(String[] args) {
        char[] frase = {'E', 'e', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'e', 'n', ' ', 'l', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        char[] elimina = {'e', 'n'};
        eliminaPalabraDeFrase(frase, elimina);
        System.out.println(frase);
    }

    public static void eliminaPalabraDeFrase(char[] frase, char[] elimina) {
        int longitud = frase.length - 1;
        for (int i = 0; i < longitud; i++) {
            int e = 0;
            while ((e < elimina.length) && (frase[i + e] == elimina[e])) 
                e++;
            if (e == elimina.length) {
                for (int z = 0; z < e; z++) {
                    for (int j = i; j < longitud; j++)
                        frase[j] = frase[j + 1];
                    frase[longitud] = '-';
                    longitud--;
                }
                i--;
            }
        }
    }
}
