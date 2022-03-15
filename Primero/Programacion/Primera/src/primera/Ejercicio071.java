/*Copia las palabras de frase 1 en frase 2 en sentido contrario*/
package primera;

public class Ejercicio071 {
    public static void main(String[] args) {
        char[] frase1 = {' ','E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'e', 'n', ' ', 'l', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        char[] frase2 = new char[frase1.length];
        
        cambioOrdenPalabras(frase1, frase2);
        
        System.out.println(frase1);
        System.out.println(frase2);        
    } 

    public static void cambioOrdenPalabras(char[] frase1, char[] frase2) {
        int j=0;
        int pal;
        for (int i=frase1.length-1; i>=0; i--){
            pal=0;
            if (frase1[i]==' ')
                frase2[j++]=frase1[i];
            else{
                while (frase1[i-pal] != ' ')
                    pal++;
                i -= (pal-1);
                for (int k=0; k<pal; k++)
                    frase2[j++]=frase1[i+k];               
            }
        }
    } 
}
