/*Media de goles por temporada de cada futbolista sin utilizar vector auxiliar*/
package primera;

public class Ejercicio041 {
    public static void main (String Arg []){
        //Declaramos la tabla principal y una variable auxiliar
        int golesTemp [][]={{13, 21, 31, 41, 22},{14, 16, 27, 18, 20},{31, 10, 11, 33, 12},{13, 21, 14, 15, 16}}; //4 temporadas
        String[] futbolistas = {"Messi", "Ronaldo", "Suárez", "Grizman", "Neymar"}; //5 jugadores
        double acum;
        
        //Acumulamos goles de cada jugador en todas temporadas y mostramos la media
        for (int numFut = 0 ; numFut<futbolistas.length; numFut++){
            acum = 0; 
            for (int numTemp = 0 ; numTemp<golesTemp.length; numTemp++)
                acum += golesTemp[numTemp][numFut];
            System.out.printf("La media de goles de %s es %.2f goles por temporada\n", futbolistas[numFut],(acum/golesTemp.length));
        }
    }
}
