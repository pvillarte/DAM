/*Cálculo de escaños por el sistema D'hondt*/
package primera;

public class Ejercicio096 {
    public static void main(String[] args) {
        final String[] PARTIDOS = {"PSOE", "PP", "VOX", "Podemos", "Teruel Existe"};
        final int[] VOTOS={4839492, 3222975, 978211, 409287, 32177459};
        final int ESCANOS = 350;                                                //MODIFICADOR final para declarar constantes
        int[] divisores={1, 1, 1, 1, 1};
        int posMax;
        
        for (int i=0; i<ESCANOS; i++){
            posMax=0;
            for (int j=1; j<VOTOS.length; j++){
                if (VOTOS[j]/divisores[j]>VOTOS[posMax]/divisores[posMax])
                    posMax=j;
            }
            divisores[posMax]++;
        }
        
        for (int i=0; i<VOTOS.length; i++)
            System.out.println(PARTIDOS[i]+": "+(divisores[i]-1));
    }
}
