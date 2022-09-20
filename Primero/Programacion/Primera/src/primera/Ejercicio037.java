/* Mostrar el nombre del empleado que más cobra y su salario medio mensual.
Tambien el que menos y su salario medio mensual
Mostrar mes en que mas y su salario medio y el que menos y su salario */
package primera;

public class Ejercicio037 {
    public static void main (String Arg[]){
        //Declaramos variables
        int salarios[][] = {{700, 900, 1300, 800, 790, 850}, {1000, 950, 1080, 1070, 1200, 1100}, {1300, 930, 1200, 1170, 1000, 1000}, {1500, 1950, 1880, 1978, 2200, 2100}};
        String empleados [] = {"Javier Marías","Antonio Muñoz", "Isabel Allende", "José Ramírez"};
        String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio"}; 
        double [] totalEmpleado = {0, 0, 0, 0};
        double [] mediaEmpleado = {0, 0, 0, 0};
        double [] totalMes = {0, 0, 0, 0, 0, 0};
        double [] mediaMes = {0, 0, 0, 0, 0, 0};
        int empMaxSal = 0, empMinSal = 0, mesMaxSal = 0, mesMinSal = 0;         //Variables del mismo tipo se pueden declarar de esta forma
        
        //Calculamos totales
        for (int numEmp = 0; numEmp<empleados.length;numEmp++)
            for (int numMes = 0; numMes<meses.length; numMes++){
                totalEmpleado [numEmp] += salarios[numEmp][numMes];
                totalMes [numMes] += salarios[numEmp][numMes];
            }
        
        //Calculamos medias
        for (int numEmp=0; numEmp<mediaEmpleado.length;numEmp++)
            mediaEmpleado[numEmp] = (totalEmpleado[numEmp]/meses.length);
        for (int numMes = 0; numMes<mediaMes.length; numMes++)
            mediaMes[numMes] = (totalMes[numMes]/empleados.length);
        
        //Hallamos media máxima y mínima
        for (int numEmp=0; numEmp<mediaEmpleado.length;numEmp++){
            if (mediaEmpleado[numEmp]>mediaEmpleado[empMaxSal])
                empMaxSal = numEmp;
            if (mediaEmpleado[numEmp]<mediaEmpleado[empMinSal])
                empMinSal = numEmp;
            }
        for (int numMes=0; numMes<mediaMes.length;numMes++){
            if (mediaMes[numMes]>mediaMes[mesMaxSal])
                mesMaxSal = numMes;
            if (mediaMes[numMes]<mediaMes[mesMinSal])
                mesMinSal = numMes;
        }
        
        //Mostramos resultado
        System.out.printf("El empleado mejor pagado es %s, con un salario medio de %.2f euros.\n",empleados[empMaxSal],mediaEmpleado[empMaxSal]);
        System.out.printf("El empleado peor pagado es %s, con un salario medio de %.2f euros.\n",empleados[empMinSal],mediaEmpleado[empMinSal]);
        System.out.println();
        System.out.printf("El mes mejor pagado es %s, con un salario medio de %.2f euros.\n", meses[mesMaxSal], mediaMes[mesMaxSal]);
        System.out.printf("El mes peor pagado es %s, con un salario medio de %.2f euros.\n", meses[mesMinSal], mediaMes[mesMinSal]);
    }
}
