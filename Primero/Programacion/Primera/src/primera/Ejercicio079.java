/*Sustituir una subcadena por otra. replace
Buscar una subcadena dentro de otra. indexOf*/
package primera;

public class Ejercicio079 {
    public static void main(String[] args) {
        String frase = "En un lugar lugar de la Mancha, de cuyo nombre no quiero acordarme.";
        System.out.println(frase);
        
        frase = frase.replace('a', 'x');
        System.out.println(frase);
        
        frase = frase.replace("lugxr", "sitio");
        System.out.println(frase);
        
        //Cuántas veces aparece una cadena dentro de otra.
        int contador = 0;
        int posicion = frase.indexOf("sitio");
        while (posicion != -1){
            contador++;
            posicion=frase.indexOf("sitio", posicion+1);
        }
        System.out.printf("Sitio aparece repetido en la frase %d veces.\n", contador);
    }
}
