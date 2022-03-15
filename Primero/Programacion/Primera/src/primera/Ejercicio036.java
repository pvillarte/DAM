/*Sacar listado de dieces*/
package primera;


public class Ejercicio036 {
    public static void main (String Arg[]){
        int notas[][] = {{7, 9, 3, 8}, {10, 9, 7, 9}, {9, 10, 7, 1}, {3, 10, 5, 6}, {6, 5, 4, 5}};  //Notas de 5 alumnos y 4 asignaturas. (5x4)
        String alumnos [] = {"Javier Marías","Antonio Muñoz", "Isabel Allende", "José Ramírez", "Paco Pérez"};    //5 filas tabla notas
        String asignaturas[] = {"Programación", "Leng. Marcas", "Sistemas", "Bases de Datos"};      //4 columnas tabla notas
        
        System.out.println("Listado de DIECES:");
        for (int numAlu = 0; numAlu<notas.length; numAlu++)
            for (int numAsignatura = 0; numAsignatura<notas[numAlu].length;numAsignatura++){
                if (notas[numAlu][numAsignatura]==10)
                    System.out.printf("%s en %s. \n", alumnos[numAlu],asignaturas[numAsignatura]);
            } 
    }
}
