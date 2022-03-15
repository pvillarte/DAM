/*Implementar una función que devuelva el número de 
caracteres en blanco de una frase*/
package primera;

public class Ejercicio058 {
    public static void main(String args[]) {
        int contador = 0;
        char frase[] =  {'E', 'n', ' ', 'u', 'n', ' ','l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'l', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        System.out.printf("La frase introducida tiene %d espacios \n", contadorEspacios(frase, contador));
    }  
    
    public static int contadorEspacios(char f[], int con){
        for (int i=0; i<f.length; i++)
            if (f[i]==' ')
                con +=1;
        return con;
    }
}
