/*Tratar con strings*/
package primera;

public class Ejercicio076 {
    public static void main(String[] args) {
        String frase = "En un lugar de la Mancha, de cuyo lugar no quiero acordarme.";
        char[] cadena = new char[150];
        
        for (int i=0; i<frase.length(); i++)
            System.out.printf(" %c -", frase.charAt(i));       
        System.out.println();   
        for (int i=0; i<frase.length(); i++)
            cadena[i]=frase.charAt(i);
        System.out.println(cadena);
        System.out.println(frase);
        
    }
}
