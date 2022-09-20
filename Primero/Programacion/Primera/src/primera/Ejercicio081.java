/*Cada vez que aparezca la subcadena, poner esta en mayúsculas
Además de esto, concatena los strings*/
package primera;

public class Ejercicio081 {
    public static void main(String[] args) {
        String frase[] = {"en un lugar", " en la Mancha ", "de cuyo nombre", " no quiero ", "acordarme."};
        String subCadena = "en";
        for (int i=0; i<frase.length; i++)
            frase[i]=frase[i].replace(subCadena, subCadena.toUpperCase());

        frase[0] = frase[0].concat(" maravilloso");
        for (int i=0; i<frase.length; i++)
            System.out.print(frase[i]);
    }
}
