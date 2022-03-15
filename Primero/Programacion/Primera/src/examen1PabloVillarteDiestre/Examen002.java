/*
El mismo ejercicio anterior, pero en lugar de tratar con una cadena
de caracteres, hacerlo con un String.  Sobre el mismo String. 2 puntos
*/
package examen1PabloVillarteDiestre;

public class Examen002 {
    public static void main(String[] args) {
        String frase = "En un lugar de la Mancha de cuyo nombre no quiero acordarme ";
        int longitudPalabra = 0;
        
        for (int i=0; i < frase.length(); i++){
            if (frase.charAt(i)!= ' ')
                longitudPalabra++;
            else{
                 if (longitudPalabra>=3){
                    frase= frase.substring(0, i-longitudPalabra).concat(frase.substring(i-longitudPalabra, i).toUpperCase()).concat(frase.substring(i));
                }
                longitudPalabra=0;
            }
        }
        
        System.out.println(frase);
    }
}
