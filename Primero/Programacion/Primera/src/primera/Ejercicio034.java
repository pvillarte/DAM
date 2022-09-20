/* Saca el valor máximo y el mínimo de ventas de la tabla. A partir de ahí, di en que día fue y con que película se corresponde.*/
package primera;

public class Ejercicio034 {
    public static void main (String Arg[]){
        int tablaVentas[][] = {{50,3,20,20,5,6,5},{111,646,544,40,30,20,100},{6,2,8,50,30,15,150},{2000,500,100,50,90,20,100}};
        String[] peliculas = {"James Bond","Spider-man","Torrente V","Peppa Pig"};
        String diaSemana[] = {"lunes", "martes", "miércoles", "jueves", "viernes", "sábado", "domingo"};
        int peliMaxVentas=0; //Posiciones para cada dato indicado
        int diaMaxVentas=0;
        int peliMinVentas=0;
        int diaMinVentas=0;
        for (int numPeli=0; numPeli<tablaVentas.length;numPeli++)
            for (int numDia=0 ; numDia<tablaVentas[numPeli].length; numDia++){
                if (tablaVentas[numPeli][numDia]>tablaVentas[peliMaxVentas][diaMaxVentas]){
                    diaMaxVentas=numDia;
                    peliMaxVentas=numPeli;
                }
                if (tablaVentas[numPeli][numDia]<tablaVentas[peliMinVentas][diaMinVentas]){
                    diaMinVentas=numDia;
                    peliMinVentas=numPeli;
                }
            }
        System.out.printf("La mejor jornada fue el %s, con la película %s y %d entradas vendidas \n",
                diaSemana[diaMaxVentas],peliculas[peliMaxVentas],tablaVentas[peliMaxVentas][diaMaxVentas]);
        System.out.printf("La peor jornada fue el %s, con la película %s y %d entradas vendidas \n",
                diaSemana[diaMinVentas],peliculas[peliMinVentas],tablaVentas[peliMinVentas][diaMinVentas]);
      
    }

}
