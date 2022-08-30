
package E7_Septimo;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

public class MazoJuego extends Rectangle implements Mazo{
    
    static final int POSICIONY = 300;
    public ArrayList<Carta> cartas;
    
    public MazoJuego(int posX){
        super(200+posX*(Carta.ANCHURA+15), POSICIONY, Carta.ANCHURA, Carta.ALTURA);
        cartas = new ArrayList();
    }
    
    public void paint(Graphics g, Applet a){
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
        for (int i=0; i< cartas.size(); i++)
            cartas.get(i).paint(g, a);
    }
    
    public boolean añadir(Carta carta){
        if (cartas.isEmpty()){
            cartas.add(carta);
            recolocar();
            return true;
        } else {
            if (carta.getColor() != cartas.get(cartas.size()-1).getColor()
            && carta.getValor() == cartas.get(cartas.size()-1).getValor()-1){
                cartas.add(carta);
                recolocar();
                return true;
            }
        }
        return false;    
    }
    
    public void recolocar(){
        ultimaCarta().x = x;
        ultimaCarta().y = y+cartas.size()*30-30;
    }
    
    public Carta ultimaCarta() {
        return cartas.get(cartas.size()-1);
    }

    public void eliminar() {
        cartas.remove(cartas.size()-1);
    }
}
