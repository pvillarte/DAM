/*Extraer una subcadena de una cadena. funcion substring*/
package primera;

public class Ejercicio078 {
    public static void main(String[] args) {
        String frase = "En un lugar de la Mancha, de cuyo lugar no quiero acordarme";
        int inicio = 7;
        int fin = 20;
        System.out.println("La subcadena contiene: " + frase.substring(inicio, fin));
        System.out.println("La subcadena contiene: " + frase.substring(inicio));
    }
}
