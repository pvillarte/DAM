/*Pasa todos carácteres de la cadena a mayúsculas*/
package primera;

public class Ejercicio060 {
    public static void main(String[] arg) {
        char frase[] =  {'E', 'n', ' ', 'u', 'n', ' ','l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};        
        convertirMayusculas(frase);
        System.out.println(frase);
    }
    
    public static void convertirMayusculas (char[] f){
        for (int i=0; i<f.length; i++){
            f[i]=Character.toUpperCase(f[i]);
        }       
    }
}
