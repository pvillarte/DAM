/*Hallar el elemento mayor y menor de un vector*/
package primera;

public class Ejercicio016 {
    public static void main (String arg[]){
        int datos[]= {-3,-4,55,2,300};
        int mayor = datos [0];
        int menor = datos [0];
        int posMax = 1;
        int posMin = 1;
        
        for (int i=1;i<datos.length;i++)
            if (datos [i]> mayor){
                mayor = datos[i]; 
                posMax = i+1;
            }else if (datos [i]< menor){
                menor = datos[i];
                posMin = i+1;
            }      

        System.out.printf("El valor máximo del vector es %d y ocupa la %dª posición \n", mayor, posMax);
        System.out.printf("El valor mínimo del vector es %d y ocupa la %dª posición \n", menor, posMin);

    }
}
