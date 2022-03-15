/*Eliminar el exceso de espacios en blanco en una frase*/
package primera;

public class Ejercicio087 {
    public static void main(String[] args) {
        String frase = "Había            una   vez    un   circo que    alegraba siempre   el    corazón.";
        //RESOLUCIÓN A
        //frase = frase.replaceAll(" +", " ");
        
        //RESOLUCIÓN B
        /*
        int posicion = 0;
        posicion = frase.indexOf(" ");
        while (posicion != -1){
            posicion++;
            while (frase.indexOf(" ", posicion) == posicion)
                frase=frase.substring(0, posicion).concat(frase.substring(posicion+1));
            posicion=frase.indexOf(" ", posicion);
        }
        */
        
        //RESOLUCIÓN C
        boolean primero = true;
        int i = 0;
        while (i<frase.length())
            if (frase.charAt(i)==' '){
                if (primero){
                    primero = false;
                    i++;
                }else{
                    frase=frase.substring(0, i).concat(frase.substring(i+1));
                }
            } else {
                i++;
                primero = true;
            }
        
        System.out.println(frase);
    }
}
