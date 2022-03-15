/*Función que cuente el número de campanadas que han sonado a una hora por bucle
A continuación, el mismo ejercicio, pero utilizando la recursivdad*/
package primera;

public class Ejercicio093 {
    public static void main(String[] args) {
        int hora = 23;
        System.out.println("Han sonado "+campanadas(hora)+" campanadas.");
        System.out.println("Han sonado "+campanadasRecursivas(hora)+" campanadas.");
    }
    
    public static int campanadas (int hora){
        int recuento = 0;
        for (int i = hora; i>0; i--)
            if (i<=12)
                recuento +=i;
            else
                recuento += (i-12);
        return recuento;
    }
    
    public static int campanadasRecursivas (int hora){
        if (hora==1)
            return 1;
        else
            if (hora<=12)
                return campanadasRecursivas(hora-1)+hora;
            else
                return campanadasRecursivas(hora-1)+(hora-12);
    }
}
