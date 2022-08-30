package E7_Septimo;

import java.util.ArrayList;
import java.awt.*;
import java.util.Collections;

public class Baraja {

    ArrayList<Carta> cartas;
    
    public Baraja(Image[][] imgs, Image reverso){
        cartas = new ArrayList();
        for (int i=0; i<Solitario.NUM_PALOS; i++)
            for (int j=0; j<Solitario.CPP; j++)
                cartas.add(new Carta(imgs[i][j],reverso, i, j+1));
    }
    
    public Carta sacarCarta(){
        Collections.shuffle(cartas);
        Carta sacada = cartas.get(0);
        cartas.remove(sacada);
        return sacada;
    }
    
}
