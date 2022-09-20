/*Tenemos una cadena de caracteres y una subcadena. Muestra el número de veces
que la subcadena aparece dentro de la cadena*/
package primera;

public class Ejercicio064 {
    public static void main(String[] arg) {
        char[] cadena = {'E', 'n', 'n', 'n', 'n', ' ', 'u', 'n', 'n', 'n', 'n', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        char[] subCadena = {'n','n','n'};
        int repeticiones = repeticionSubCadena(cadena, subCadena);
        System.out.printf("La sub-cadena aparece %d veces dentro de la frase\n", repeticiones);    
    }
    
    public static int repeticionSubCadena (char[] cadena, char[] subCadena){
        int numRep = 0;
        for (int i=0; i<(cadena.length-subCadena.length+1); i++){
            int j = 0;
            while ((j<subCadena.length) && (cadena[i+j]==subCadena[j]))
                j++;
            if (j==subCadena.length)
               numRep++;    
        }
        return numRep;
    }
}
