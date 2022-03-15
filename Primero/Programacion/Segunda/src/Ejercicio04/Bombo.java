
package Ejercicio04;
import java.util.Random;
        
public class Bombo {
    private int numBolas;
    private int bolas[];
    Random aleatorio;
    
    public Bombo(int numBolas){
        this.numBolas= numBolas;
        aleatorio= new Random();
        bolas= new int[numBolas];
        for(int i=0; i<numBolas; i++)
            bolas[i]=i+1;
    }
    
    public int sacarBola(){
        int posBolaExtraida, bolaExtraida;
        posBolaExtraida = aleatorio.nextInt(numBolas);
        bolaExtraida = bolas[posBolaExtraida];
        bolas[posBolaExtraida]=bolas[--numBolas];       
        return bolaExtraida;
    }
    
}

