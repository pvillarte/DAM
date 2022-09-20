/*Coge alternativamente una palabra de cada frase para montar una frase que las 
combine*/
package primera;

public class Ejercicio084bis {
    public static void main(String[] args) {
        String frase1 = "Había vez circo alegraba el ";
        String frase2 = "una un que siempre corazón sin temer jamás. ";
        String frase3 = "";
        int numPalabras1 = cuentaPalabrasDeFrase(frase1);
        int numPalabras2 = cuentaPalabrasDeFrase(frase2);
        String[] palabras1 =vectorDePalabrasAPartirDeFrase(numPalabras1, frase1);
        String[] palabras2 =vectorDePalabrasAPartirDeFrase(numPalabras2, frase2);
        frase3 = alternaVectoresDePalabrasEnFrase(palabras1, palabras2, frase3);
        System.out.println(frase3);
    }

    public static String alternaVectoresDePalabrasEnFrase(String[] palabras1, String[] palabras2, String frase3) {
        int i =0;
        while (i<palabras1.length || i<palabras2.length){
            if (i<(palabras1.length))
                frase3=frase3.concat(palabras1[i]);
            if (i<(palabras2.length))
                frase3=frase3.concat(palabras2[i]);
            i++;
        }
        return frase3;
    }
    
    public static String[] vectorDePalabrasAPartirDeFrase(int numPalabras, String frase) {
        String[] palabras = new String[numPalabras];
        int inicio = 0;
        int fin = frase.indexOf(" ");                                         
        for (int i = 0; i<palabras.length; i++){
            palabras[i]=frase.substring(inicio, fin+1);
            inicio=fin+1;
            fin = frase.indexOf(" ", inicio);
        }
        return palabras;
    }

    public static int cuentaPalabrasDeFrase(String frase) {
        int numPalabras = 0;
        int numEspacio = frase.indexOf(" ");
        while (numEspacio != -1){
            numPalabras++;
            numEspacio = frase.indexOf(" ", numEspacio+1);
        }
        return numPalabras;
    }
}
