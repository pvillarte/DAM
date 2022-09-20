/*De una frase cambiamos las vocales minúsculas a mayusculas
Las vocales mayúsculas las pasamos a minúsculas
Y las consonantes las sustituimos por un @*/
package primera;

public class Ejercicio075 {
    public static void main(String[] args) {
        char[] frase = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'e', 'n', ' ', 'l', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        
        for (int i=0; i<frase.length; i++)
            switch(frase[i]){
                case 'A': case 'E': case 'I':case 'O': case 'U':
                    frase[i]=Character.toLowerCase(frase[i]);
                    break;
                case 'a': case 'e': case 'i': case 'o': case 'u':
                    frase[i]=Character.toUpperCase(frase[i]);
                    break;
                case ' ' :
                    break;                    
                default:
                    frase[i]='@';                   
            }
        
        System.out.println(frase);          
    }
}
