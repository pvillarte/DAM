/*Escribir sobre frase2 el contenido de frase1, pero con los carácteres invertidos*/
package primera;

public class Ejercicio085 {
    public static void main(String[] args) {
        String frase1 = "Había una vez un circo que alegraba siempre el corazón";
        String frase2 = "";
        
        for (int i=frase1.length()-1; i>=0; i--)
            frase2 = frase2.concat(Character.toString(frase1.charAt(i)));
        System.out.println(frase2);
    }  
}
