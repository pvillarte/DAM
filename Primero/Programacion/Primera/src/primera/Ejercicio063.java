/*Realizar las mismas sustituciones que en el ejercicio anterior, pero solo
puedes utilizar frase2 y ningun vector auxiliar*/
package primera;

public class Ejercicio063 {
    
    public static void main(String[] arg){
        char[] frase1 = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        char sustituir = 'a';
        char[] sustitutos = {'p', 'e', 'p', 'e'};
        char[] frase2 = new char [100];
        for (int i=0; i<frase1.length; i++)
            frase2[i] = frase1[i];
        
        caracterPorCadena(frase2, sustituir, sustitutos, frase1.length);
        System.out.println(frase2);
    }
    
    public static void caracterPorCadena(char[] f, char sustituir, char[] sustitutos, int longitud){
        for (int i=0; i<longitud; i++)
            if (f[i]==sustituir){
                f[i]=sustitutos[0];
                for (int j=1; j<sustitutos.length; j++, longitud++){
                    for (int k=longitud; k>i; k--)
                        f[k]=f[k-1];
                    f[++i]=sustitutos[j];
                }      
            }             
    }
}
