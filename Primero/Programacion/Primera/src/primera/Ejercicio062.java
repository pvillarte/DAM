/*Crear una función que devuelva una cadena de caracteres nueva, sutituyendo el
caracter a sustituir por una cadena de caracteres (sustitutos)*/
package primera;

public class Ejercicio062 {

    public static void main(String[] arg) {
        char[] frase = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        char sustituir = 'a';
        char[] sustitutos = {'-', 'a', '-'};
        char[] fMod = caracterPorCadena(frase, sustituir, sustitutos);
        System.out.println(fMod);
    }

    public static char[] caracterPorCadena(char[] f, char sustituir, char[] sustitutos) {
        char[] f2 = new char[100];
        for (int i = 0, j = 0; i < f.length; i++, j++)
            if (f[i] == sustituir)
                for (int k = 0; k < sustitutos.length; k++, j++)
                    f2[j] = sustitutos[k];
            else
                f2[j] = f[i];
        return f2;
    }
}

/*
v[i++]= x;  Asigna valor de x y después incrementa i
v[++i]= x;  Incrementa i y después asigna valor de x
*/
