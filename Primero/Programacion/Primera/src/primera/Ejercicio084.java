/*Coge alternativamente una palabra de cada frase para montar una frase que las 
combine*/
package primera;

public class Ejercicio084 {
    public static void main(String[] args) {
        String frase1 = "Había vez circo alegraba el ";
        String frase2 = "una un que siempre corazón sin temer jamás. ";
        String frase3 = "";
        int inicio1 = 0;
        int fin1 = frase1.indexOf(" ");
        int inicio2 = 0;
        int fin2 = frase2.indexOf(" ");
        
        while((fin1 != -1)||(fin2 != -1)){
            if (fin1 != -1){
                frase3 = frase3.concat(frase1.substring(inicio1,fin1+1));
                inicio1 = fin1+1;
                fin1 = frase1.indexOf(" ", inicio1);
            }
            if (fin2 != -1){
                frase3 = frase3.concat(frase2.substring(inicio2,fin2+1));
                inicio2 = fin2+1;
                fin2 = frase2.indexOf(" ", inicio2);
            }
        }
        System.out.println(frase3);
    }
}
