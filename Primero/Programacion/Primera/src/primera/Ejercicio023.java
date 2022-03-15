/*Desplaza todos valores del vector hacia la derecha y el último al primer lugar. 
Repite el proceso hasta volver a valor inicial*/
 
package primera;


public class Ejercicio023 {
    public static void main (String arg[]){
        int datos[]={10,20,30,40,50,60};
        for (int n = 1; n<=datos.length;n++){
            int aux = datos[datos.length-1];
            for (int i=(datos.length-1);i>0;i--)
                datos[i]=datos[i-1];
            datos[0]= aux;
            System.out.printf ("%dª)  ",n);
            for (int i=0;i<datos.length;i++)                            //Bucle para mostrar el vector por pantalla
            System.out.printf ("dat[%d] = %d    ",i, datos[i]);
        System.out.println();
        }
        
    }
}
