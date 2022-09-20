/* Tenemos un array bidimensional en el que se guardan el número de entradas 
vendidas en las cuatro salas de cine del centro comercial cada dia de la semana
Muestra el día que mas entradas se vendieron y el que menos(y cuantas)*/
package primera;

public class Ejercicio032 {
    public static void main (String Arg[]){
        int salas[] = {1,2,3,4};
        int ventasDiarias []={0,0,0,0,0,0,0};
        int diaMaxVentas = 0;
        int diaMinVentas = 0;

        String diaSemana[] = {"lunes", "martes", "miércoles", "jueves", "viernes", "sábado", "domingo"};
        int tablaVentas[][] = {{5,3,2,10},{40,30,20,100},{50,30,15,150},{50,0,20,10},{50,310,20,110},{50,3300,20,10},{40,20,30,10}};
        
        for (int numDia=0; numDia<tablaVentas.length;numDia++)
            for (int numSala=0;numSala<tablaVentas[numDia].length;numSala++)
                ventasDiarias [numDia] += tablaVentas[numDia][numSala];        
        
        for (int numDia=0;numDia<ventasDiarias.length;numDia++){
            if (ventasDiarias[numDia]>ventasDiarias[diaMaxVentas])
                diaMaxVentas = numDia;
            if (ventasDiarias[numDia]<ventasDiarias[diaMinVentas])
                diaMinVentas = numDia;
        }
        System.out.printf("El día con más ventas ha sido el %s, con %d ventas; y el día con menos el %s, con %d. \n",diaSemana[diaMaxVentas],ventasDiarias[diaMaxVentas], diaSemana[diaMinVentas], ventasDiarias[diaMinVentas]);
    }  
}
