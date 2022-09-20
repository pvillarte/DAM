/*Ordena la frase en orden alfabético*/
package primera;

public class Ejercicio083 {
    public static void main(String[] args) {
        String frase = "5Cinco 6Seis 2Dos 4Cuatro 1Uno 3Tres ";
        
        //Contamos el número de palabras
        int numPalabras = 0;
        int numEspacio = frase.indexOf(" ");
        while (numEspacio != -1){
            numPalabras++;
            numEspacio = frase.indexOf(" ", numEspacio+1);
        }
        
        //Creamos un vector con cada palabra de la frase
        String[] palabras = new String[numPalabras];
        int inicio = 0;     
        int fin = frase.indexOf(" ");                                         
        for (int i = 0; i<palabras.length; i++){
            palabras[i]=frase.substring(inicio, fin+1);
            inicio=fin+1;
            fin = frase.indexOf(" ", inicio);
        }
        
        //Ordenamos el vector alfabéticamente
        String aux;
        for (int j=1; j<palabras.length-1; j++)
            for (int i=0; i<palabras.length-j; i++)
                if (palabras[i].compareTo(palabras[i+1])>0){
                    aux=palabras[i+1];
                    palabras[i+1]=palabras[i];
                    palabras[i]=aux;
                }
        
        //Cargamos los resultados del vector ordenado en la frase
        frase = "";
        for (int i = 0; i<palabras.length; i++)
            frase = frase.concat(palabras[i]);
        
        //Mostramos el resultado
        System.out.println(frase);
    }
}
