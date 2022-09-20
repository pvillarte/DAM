/*Tenemos una cadena de caracteres, de cada palabra hay que colocar en 
mayúsculas la primera y la ultima letra*/
package primera;

public class Ejercicio074 {
    public static void main(String[] args) {
        char[] frase = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'e', 'n', ' ', 'l', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        extremosDePalabrasDeFraseAMayus(frase);
        System.out.println(frase);        
    }

    public static void extremosDePalabrasDeFraseAMayus(char[] frase) {
        int longitud=0;
        for (int i=0; i<frase.length; i++){
            longitud=0;
            while (frase[i+longitud]!=' ')
                longitud++;
            frase[i]=Character.toUpperCase(frase[i]);
            frase[i+longitud-1]=Character.toUpperCase(frase[i+longitud-1]);
            i += longitud;    
        }
    }
}
