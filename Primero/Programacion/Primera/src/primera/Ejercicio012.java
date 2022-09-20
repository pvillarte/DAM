/*Efectua la operación variaciones de 7 elementos tomados de 4 4 (x!/y!) */
package primera;

public class Ejercicio012 {
    public static void main (String arg[]){
        int elementos = 7;
        int tomados = 4;
        int acum = 1;
        for (int cont=elementos;cont>tomados;cont--)
                acum*=cont;
            System.out.println("Variaciones de "+elementos+" elementos tomados de "+tomados+" en "+tomados+" es "+acum);
            System.out.printf("Variaciones de %d elementos tomados de %d en %d es %d \n", elementos, tomados, tomados, acum); //contabarra (\) es secuencia de escape
    }
}
