/*Qué alumno tiene las mejores notas y cuál es su media y quién las peores, con su media
Además de esto, mostrar que asignatura tiene las mejores notas y su media y las peores
Sacar listado de matriculas  (notas igual a 10)*/
package primera;

public class Ejercicio035 {
    public static void main (String Arg []){
        //Declaramos variables        
        int notas[][] = {{7, 9, 3, 8}, {10, 9, 7, 9}, {9, 10, 7, 1}, {3, 10, 5, 6}, {6, 5, 4, 5}};  //Notas de 5 alumnos y 4 asignaturas. (5x4)
        String alumnos [] = {"Javier Marías","Antonio Muñoz", "Isabel Allende", "José Ramírez", "Paco Pérez"};    //5 filas tabla notas
        String asignaturas[] = {"Programación", "Leng. Marcas", "Sistemas", "Bases de Datos"};      //4 columnas tabla notas
        double sumaNotasAlu [] = {0, 0, 0, 0, 0};
        double mediaAlu [] = {0, 0, 0, 0, 0};
        double sumaNotasAsignatura [] = {0, 0, 0, 0};
        double mediaAsignatura [] = {0, 0, 0, 0};
        int aluMaxNotas = 0;
        int aluMinNotas = 0;
        int asiMaxNotas = 0;
        int asiMinNotas = 0;
        
        //Calculamos totales
        for (int numAlu = 0; numAlu<notas.length; numAlu++)
            for (int numAsignatura = 0; numAsignatura<notas[numAlu].length;numAsignatura++){
                sumaNotasAlu[numAlu] += notas[numAlu][numAsignatura];
                sumaNotasAsignatura [numAsignatura] += notas [numAlu][numAsignatura];
            } 

        //Calculamos medias
        for (int numAlu=0; numAlu<mediaAlu.length;numAlu++)
            mediaAlu [numAlu] = (sumaNotasAlu[numAlu]/notas[numAlu].length); 
        for (int numAsignatura=0; numAsignatura<mediaAsignatura.length;numAsignatura++)
            mediaAsignatura[numAsignatura] = (sumaNotasAsignatura[numAsignatura]/notas.length);
        
        //Hallamos media máxima y mínima
        for (int numAlu = 0; numAlu<mediaAlu.length; numAlu++){
            if (mediaAlu[numAlu]>mediaAlu[aluMaxNotas])
                aluMaxNotas=numAlu;
            if (mediaAlu[numAlu]<mediaAlu[aluMinNotas])
                aluMinNotas=numAlu;
        }
        for (int numAsignatura = 0; numAsignatura<mediaAsignatura.length;numAsignatura++){
            if (mediaAsignatura[numAsignatura]>mediaAsignatura[asiMaxNotas])
                asiMaxNotas=numAsignatura;
            if (mediaAsignatura[numAsignatura]<mediaAsignatura[asiMinNotas])
                asiMinNotas=numAsignatura;
        }
        
        //Mostramos resultado
        System.out.printf("El alumno con mejores notas es %s, con un %.2f de nota media \n", alumnos[aluMaxNotas], mediaAlu[aluMaxNotas]);
        System.out.printf("El alumno con peores notas es %s, con un %.2f de nota media \n", alumnos[aluMinNotas], mediaAlu[aluMinNotas]);
        System.out.println();
        System.out.printf("La asignatura con mejores notas es %s, con un %.2f de nota media \n", asignaturas[asiMaxNotas], mediaAsignatura[asiMaxNotas]);
        System.out.printf("La asignatura con peores notas es %s, con un %.2f de nota media \n", asignaturas[asiMinNotas], mediaAsignatura[asiMinNotas]);
    } 
}
