/*Mostrar p`por pantalla el número de veces que aparecera el caracter 'a' en un
vector de Strings. */
package primera;

public class Ejercicio080 {
    public static void main(String[] args) {
        String frase[] = {"En un lugar", " de la Mancha ", "de cuyo nombre", "no quiero", "acordarme."};
        int contador = 0;
        for (int i=0; i<frase.length; i++)
                for (int j=0; j< frase[i].length(); j++)
                    if (frase[i].charAt(j)=='a')
                        contador++;

        System.out.printf("La letra a aparece %d veces en el vector de Strings.\n", contador);
    }
}
