/* Crea una función  que ordene las filas de la tabla salarios*/
package primera;

public class Ejercicio050 {
    public static void main (String Arg[]){
        int salarios[][] = {{700, 900, 1300, 800, 790, 850}, {1000, 950, 1080, 1070, 1200, 1100}, {1300, 930, 1200, 1170, 1000, 1000}, {1500, 1950, 1880, 1978, 2200, 2100}};
        String empleados [] = {"Javier Marías","Antonio Muñoz", "María Allende", "Pedro Ramírez"};
        ordenaFilasTabla(salarios);
        muestraTabla(salarios, empleados);
    }
    
    public static void ordenaFilasTabla (int tabla[][]){
        for (int fila=0; fila<tabla.length; fila++)
            ordenaVector(tabla[fila]);      
    }
    
    public static void ordenaVector (int vector[]){
    int aux;
    for (int j=1; j<vector.length; j++)
        for (int i=0; i<vector.length-j; i++)
            if (vector[i]>vector[i+1]){
                aux = vector[i+1];
                vector[i+1] = vector[i];
                vector[i] = aux;
            }
    }

    public static void muestraTabla (int tabla[][], String nombre[]){
    for (int i=0; i<tabla.length; i++){
        System.out.printf("Salarios del primer semestre de %s de menor a mayor = { | ", nombre[i]);
        for (int j=0; j<tabla[i].length; j++)
            System.out.printf("%4d | ", tabla[i][j]);
        System.out.println("}");
        }
    }    
}
