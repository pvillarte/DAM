package E6_Sexto;

import java.util.ArrayList;
import java.awt.*;

public class Baraja {

    ArrayList<Carta> cartas;
    
    public Baraja(Image[][] imgs, Image reverso){
        cartas = new ArrayList();
        for (int i=0; i<Blackjack.NUM_PALOS; i++)
            for (int j=0; j<Blackjack.CPP; j++)
                cartas.add(new Carta(imgs[i][j], i, j, reverso));
    }
    
    public Carta sacaCarta(){
        int indiceExtraccion = (int)(Math.random()*cartas.size());
        Carta extraida = cartas.get(indiceExtraccion);
        cartas.remove(indiceExtraccion);
        return extraida;
    }
}
