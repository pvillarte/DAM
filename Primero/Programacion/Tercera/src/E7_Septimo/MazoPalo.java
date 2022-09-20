
package E7_Septimo;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

public class MazoPalo extends Rectangle implements Mazo {
    
    int palo;
    public ArrayList<Carta> cartas;
        
    public MazoPalo(int posX) {
        super(posX, MazoSecundario.POSICIONY, Carta.ANCHURA, Carta.ALTURA);
        cartas = new ArrayList();
    }
    
    public void paint(Graphics g, Applet a){
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
        for (int i=0; i< cartas.size(); i++)
            cartas.get(i).paint(g, a);
    }
    
    public boolean añadir(Carta carta){
        if (cartas.isEmpty() && carta.getValor() == 1){
            this.palo = carta.getPalo();
            cartas.add(carta);
            return true;
        } else if (!cartas.isEmpty() && palo == carta.getPalo() && carta.getValor() == cartas.get(cartas.size()-1).getValor()+1){
            cartas.add(carta);
            return true;
        }
        return false;
    }
    
    public void recolocar(){
        ultimaCarta().x = x;
        ultimaCarta().y = y;
    }

    public Carta ultimaCarta() {
        return cartas.get(cartas.size()-1);
    }

    public void eliminar() {
        cartas.remove(cartas.size()-1);
    }
}
