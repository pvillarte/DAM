/*
Dada una cadena de caracteres cuyas palabras están separadas por un espacio en blanco,
cambiar a mayúsculas las palabras cuya longitud sea superior a 3 caracteres.
a) Hacerlo sobre la propia cadena. 1,5 puntos
b) Hacerlo sobre una nueva cadena.  1,5 puntos
*/
package examen1PabloVillarteDiestre;

public class Examen001 {
    public static void main(String[] args) {
        char [] frase = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'l', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        char [] frase2 = new char[frase.length];
        int longitudPalabra = 0;
        
        // Mostramos primero la frase sin modificar para luego poder comparar los resultados
        System.out.print("Frase 1 sin modificar: ");
        System.out.println(frase);
        
        // Apartado B (Este apartado en primer lugar, puesto que en el apartado A se modifica los valores del vector de caracteres)     
        for (int i=0; i<frase.length; i++){
            if (frase[i] != ' '){
                frase2[i]=frase[i];
                longitudPalabra++;
            } else {
                frase2[i]=frase[i];
                if (longitudPalabra>=3){
                    for (int j=i-longitudPalabra; j<i; j++)
                        frase2[j]=Character.toUpperCase(frase[j]);
                }
                longitudPalabra=0;
            }
        }
        System.out.print("Frase 2 modificada: ");
        System.out.println(frase2);
        //Fin de apartado B
        
        //Apartado A
        for (int i=0; i<frase.length; i++){
            if (frase[i] != ' '){
                longitudPalabra++;
            } else {
                if (longitudPalabra>=3){
                    for (int j=i-longitudPalabra; j<i; j++)
                        frase[j]=Character.toUpperCase(frase[j]);
                }
                longitudPalabra=0;
            }
        }
        System.out.print("Frase 1 modificada: ");
        System.out.println(frase);
        //Fin de apartado A
    }
}