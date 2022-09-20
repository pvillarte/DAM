/*Implementar una función que sutituya un carácter por otro deseado*/
package primera;

public class Ejercicio061 {
    public static void main(String[] arg) {
        char frase[] =  {'E', 'n', ' ', 'u', 'n', ' ','l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '}; 
        char sustituto = 'x';
        char sustituir = 'a';
        sustituirCaracter(frase, sustituto, sustituir);
        System.out.println(frase);
    }
    
    public static void sustituirCaracter(char[]f, char sustituto, char sustituir){
        for (int i=0; i<f.length; i++){
            if (f[i]==sustituir)
                f[i]=sustituto;
        }     
    }
}
