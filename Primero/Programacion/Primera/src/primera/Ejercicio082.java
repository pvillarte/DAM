/*Elimina los espacios en blanco de un string*/
package primera;

public class Ejercicio082 {
    public static void main(String[] args) {
        String frase = "Hola como estás, encantado de conocerte.";
        
        int posicion = frase.indexOf(" ");
        while (posicion != -1){
            frase = frase.substring(0, posicion).concat(frase.substring(posicion+1));
            posicion = frase.indexOf(" ", posicion+1);
        }
        
        
        /*for (int i=0; i<frase.length(); i++)
            if (frase.charAt(i)==' '){
                frase= frase.substring(0, i) + frase.substring(i+1);
                i--;
            }*/
        
        
        System.out.println(frase);
    }
}
