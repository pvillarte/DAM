/*Haz que la frase2 sea igual a la frase1, pero intercambiando por 'sustitutos'
cuando en la frase1 aparezca 'sustituir'*/
package primera;

public class Ejercicio070 {
    public static void main(String[] arg) {
        char[] frase1 = {'e', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'e', 'n', ' ', 'l', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};   
        char[] sustituir = {'e', 'n'};
        char[] sustitutos = {'X', 'X', 'X', 'X', 'X'};
        char[] frase2 = new char[99];
   
        cadenaPorCadena(frase1, sustituir, sustitutos, frase2);
        System.out.println(frase1);
        System.out.println(frase2); 
    }

    public static void cadenaPorCadena(char[] frase1, char[] sustituir, char[] sustitutos, char[] frase2) {
        for (int i=0, j=0; i<frase1.length; i++, j++)
            if (frase1[i]==sustituir[0]){
                int c=1;
                while ((c<sustituir.length)&&((frase1[i+c])==(sustituir[c])))
                    c++;
                if (c==sustituir.length){
                    for (int k=0;k<sustitutos.length;k++)
                        frase2[j+k]=sustitutos[k];
                    i += sustituir.length-1;
                    j += sustitutos.length-1;
                }else
                    frase2[j]=frase1[i];
            }
            else
                frase2[j]=frase1[i];
    }
}
