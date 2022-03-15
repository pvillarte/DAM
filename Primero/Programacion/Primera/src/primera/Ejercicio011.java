/*Multiplicación mediante sumas*/
package primera;

public class Ejercicio011 {
    public static void main (String arg[]){
        int num1=7;
        int num2=10;
        int resultado=0;     //usaremos esta variable para ir acumulando
        for (int cont=1;cont<=num1;cont++)
            resultado+=num2;
        System.out.println(num1+"*"+num2+" = "+resultado);
    }  
}
