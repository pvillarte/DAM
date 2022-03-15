/*Contamos con dos vectores, calcula los multiplos del primero en base al segundo*/
package primera;

public class Ejercicio024 {
    public static void main (String Arg[]){
        int[] multiplos = {5,7,9};
        int datos [] = {10,20,30,40,50,60};
        for (int j=0;j<multiplos.length;j++){
            System.out.printf("datos[]*multiplos[%d] = ", j);
            for (int i=0;i<datos.length;i++)
                System.out.printf("%d / ", (datos[i]*multiplos[j]) );     
        System.out.println();
        }
    }
}
