/*Añadir una a al final de cada palabra*/
package primera;

public class Ejercicio086 {
    public static void main(String[] args) {
        String frase = "Había una vez un circo que alegraba siempre el corazón. ";
        char c = 'a';
        //frase=frase.replace(" ", "a ");
        int indice = frase.indexOf(" ");
        while(indice != -1){
            frase = frase.substring(0, indice).concat(Character.toString(c)).concat(frase.substring(indice));
            indice = frase.indexOf(" ", indice+2);
        }
        System.out.println(frase);
    }
}
