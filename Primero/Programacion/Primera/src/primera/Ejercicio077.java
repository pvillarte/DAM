/*Ordena los nombres por orden alfabético*/
package primera;

public class Ejercicio077 {
    public static void main(String[] args) {
        String nombres[] = {"Pepe", "Juan", "Antonio", "María", "Luisa"};
        String intercambio;
        for (int x=1; x<nombres.length-1; x++)
            for (int i=0; i<nombres.length-x; i++)
                if(nombres[i].compareTo(nombres[i+1])>0){
                    intercambio=nombres[i+1];
                    nombres[i+1]=nombres[i];
                    nombres[i]=intercambio;
                }
        for (int i=0; i<nombres.length; i++)
            System.out.println(nombres[i]);
    }
}
