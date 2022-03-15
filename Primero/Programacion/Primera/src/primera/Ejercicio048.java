/* Ejercicio teórico-práctico de cómo se pasan las direcciones de memoria*/
package primera;

public class Ejercicio048 {
    public static void main (String Arg []){
        //Declaramos variables
        int salarios[][] = {{700, 900, 1300, 800, 790, 850}, {1000, 950, 1080, 1070, 1200, 1100}, {1300, 930, 1200, 1170, 1000, 1000}, {1500, 1950, 1880, 1978, 2200, 2100}};
        String empleados [] = {"Javier Marías","Antonio Muñoz", "Isabel Allende", "José Ramírez"};
        String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio"};
        
        //Resolución 1A
        int totalEmpleados [] = salariosSemestrales(salarios); 
        for (int i=0; i<empleados.length;i++)
            System.out.printf("El salario semestral de %s asciende a %d€\n", empleados[i],totalEmpleados[i]); 
        System.out.println();
        //Resolución 1B
        int empleadosAcum[] = new int [4];
        salariosSemestrales2(salarios, empleadosAcum);        
        for (int i=0; i<empleados.length;i++)
            System.out.printf("El salario semestral de %s asciende a %d€\n", empleados[i],empleadosAcum[i]);
        System.out.println();
        
        //Resolución 2A        
        int totalMes [] = salariosMensuales(salarios);
        for (int i=0; i<meses.length;i++)
            System.out.printf("La suma de salarios de %s son %d€\n", meses[i],totalMes[i]);
        System.out.println();
        //Resolución 2B
        int mesAcum[]= new int [6];
        salariosMensuales2(salarios, mesAcum);
        for (int i=0; i<meses.length;i++)
            System.out.printf("La suma de salarios de %s son %d€\n", meses[i],mesAcum[i]);       
    } 
    
    //Suma de los salarios de 6 meses para cada empleado. (resolución 1A)
    public static int[] salariosSemestrales (int sal[][]){
        int acum [] = new int [4];
        for (int i=0; i<sal.length; i++)
            for (int j=0; j<sal[i].length; j++)
                acum[i] += sal[i][j];
        return acum;                         
    }       
    //Suma de los salarios de 6 meses para cada empleado. (resolución 1B)
    public static void salariosSemestrales2 (int sal[][], int acum[]){
        for (int i=0; i<sal.length; i++)
            for (int j=0; j<sal[i].length; j++)
                acum[i] += sal[i][j];                      
    }
    
    //Suma de los salarios de cada mes (resolución 2A)
    public static int [] salariosMensuales (int sal[][]){
        int acum[] = new int [6];
        for (int i=0; i<sal.length; i++)
            for (int j=0; j<sal[i].length; j++)
                acum[j] += sal[i][j];
        return acum;
    }
    //Suma de los salarios de cada mes (resolución 2B)  
    public static void salariosMensuales2 (int sal[][], int acum[]){
        for (int i=0; i<sal.length; i++)
            for (int j=0; j<sal[i].length; j++)
                acum[j] += sal[i][j];
    }    
}
