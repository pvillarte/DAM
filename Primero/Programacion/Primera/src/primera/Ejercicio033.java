/*Mostrar la pelicula mas taquillera y la menos taquillera, cada una de ellas 
con el número de entradas vendida*/

package primera;

public class Ejercicio033 {
    public static void main (String Arg[]){
        int tablaVentas[][] = {{5,3,2,0,5,6,5},{111,646,544,40,30,20,100},{6,1,8,50,30,15,150},{2000,500,100,50,0,20,10}};
        String pelicula[] = {"James Bond","Spider-man","Torrente V","Peppa Pig"};
        int masTaquillera=0;
        int menosTaquillera=0;
        int ventasPelicula[] = {0,0,0,0};
        for (int numPeli=0; numPeli<tablaVentas.length;numPeli++)
            for (int numDia=0 ; numDia<tablaVentas[numPeli].length; numDia++)
                ventasPelicula[numPeli] += tablaVentas[numPeli][numDia];
        
        for (int numPeli=1; numPeli<ventasPelicula.length; numPeli++){
            if (ventasPelicula[numPeli]>ventasPelicula[masTaquillera])
                masTaquillera=numPeli;
            if (ventasPelicula[numPeli]<ventasPelicula[menosTaquillera])
                menosTaquillera=numPeli;
        }
        System.out.printf("La película mas taquillera ha sido %s, con %d ventas \n",pelicula[masTaquillera],ventasPelicula[masTaquillera]);
        System.out.printf("La película menos taquillera ha sido %s, con %d ventas \n",pelicula[menosTaquillera],ventasPelicula[menosTaquillera]);
    }
}
