/* Dada la tabla de salarios y el vector de empleados, queremos que se muestre por
pantalla, de cada empleado, su nombre y cuánto ha ganado en esos seis meses
Hay que implementar una funcion que sume los salarios de un empleado*/
package primera;

public class Ejercicio052 {
    public static void main (String Arg[]){
        int salarios[][] = {{700, 900, 1300, 800, 790, 850}, {1000, 950, 1080, 1070, 1200, 1100}, {1300, 930, 1200, 1170, 1000, 1000}, {1500, 1950, 1880, 1978, 2200, 2100}};
        String empleados [] = {"Javier Marías","Antonio Muñoz", "Isabel Allende", "José Ramírez"};
        int totalesEmpleado [] = new int [empleados.length];
        sumaSalariosEmpleado(salarios, totalesEmpleado);
        muestraSalarioSemestral(totalesEmpleado, empleados);
    }
    
    public static void sumaSalariosEmpleado (int salarios[][], int totalesEmpleado [] ){
        for (int i =0; i<salarios.length; i++)
            for (int j =0; j<salarios[i].length; j++)
                totalesEmpleado[i] += salarios[i][j];
    }
    
    public static void muestraSalarioSemestral (int totalesEmpleado [], String empleados []){
        for (int i =0; i<empleados.length; i++)
            System.out.printf("%s ha ganado %d€ en el primer semestre.\n", empleados[i], totalesEmpleado[i]);
    }
}
