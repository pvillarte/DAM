/*Tenemos una frase y un caracter. Debemos eliminar ese caracter de la frase
Sin cadena auxiliar*/
package primera;

public class Ejercicio072 {
    public static void main(String[] args) {
        char[] frase = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'e', 'n', ' ', 'l', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};   
        char elimina = 'n';
        eliminaCaracterDeCadena(frase, elimina);
        System.out.println(frase);
    }

    public static void eliminaCaracterDeCadena(char[] frase, char elimina) {
        int longitud = frase.length;
        for (int i=0; i<longitud; i++)
            if(frase[i]==elimina){
                longitud--;                         //Lo coloco antes para así evitar poner (longitud-1) en las siguientes líneas
                for (int j=i; j<(longitud); j++)
                    frase[j]=frase[j+1];
                frase[longitud]=' ';
                i--;
            }
    }
}
