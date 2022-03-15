/*Mete las palabras de frase en fraseA y fraseB alternativamente*/

package primera;

public class Ejercicio088 {
    public static void main(String[] args) {
        String frase = "Había una vez un circo que alegraba siempre el corazón ";
        String fraseA = "";
        String fraseB = "";
        int inicio = 0;
        int fin = frase.indexOf(" ");
        boolean destinoA = true;
        
        while (fin != -1){
            if (destinoA){
                fraseA = fraseA.concat(frase.substring(inicio, fin));
                destinoA=false;
            }else{
                fraseB = fraseB.concat(frase.substring(inicio, fin));
                destinoA=true;
            }
            inicio=fin;
            fin= frase.indexOf(" ", inicio+1);
        }
        System.out.println(fraseA);
        System.out.println(fraseB);
    }
}
