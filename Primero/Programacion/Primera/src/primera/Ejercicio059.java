/* Implementar dos funciones similares, que carguen fraseMod con los caracteres
de frase, pero añadiendo'x' al final de casa palabra. En la primera
no devuelve nada y en la segunda devuelve una cadena de caracteres */
package primera;

public class Ejercicio059 {
    public static void main(String arg[]) {
        char frase[] =  {'E', 'n', ' ', 'u', 'n', ' ','l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        char fraseMod1[] = new char [50];
        char fraseMod2[] = modificarFrase(frase);
        modificarFrase(frase, fraseMod1);
        
        mostrarFrase(frase);
        mostrarFrase(fraseMod1);
        mostrarFrase(fraseMod2);
    }
    
    public static void modificarFrase (char f[], char fMod[]){
        for (int i=0, j=0; i<f.length; i++, j++){
            if (f[i]==' '){
                fMod[j] = 'x';
                j++;
            }
            fMod[j] = f[i];
        }
    }
    
    public static char [] modificarFrase (char f[]){
        char fMod[] = new char [50];
        for (int i=0, j=0; i<f.length; i++, j++){
            if (f[i]==' '){
                fMod[j] = 'x';
                j++;
            }
            fMod[j] = f[i];
        }
        return fMod;
    }
    
    public static void mostrarFrase (char f[]){
        for (int i=0; i<f.length; i++)
            System.out.printf("%c", f[i]);
        System.out.println();
    }
}
