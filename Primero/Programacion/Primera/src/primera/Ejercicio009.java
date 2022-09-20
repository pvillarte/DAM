/*Introducir un número y sacar su tabla de mutiplicar del 1  al 9*/
package primera;


public class Ejercicio009 {
    public static void main (String arg[]){
        int num = 4;
        System.out.println("TABLA DE MULTIPLICAR DEL NÚMERO "+num);
        for (int cont=1;cont<=10;cont++){
            System.out.println (num+" * "+cont+" = "+(num*cont)); 
        }             
    }  
}
