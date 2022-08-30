
package E7_Septimo;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

public class MazoSecundario implements Mazo {
    
    static final int POSICIONX = 200;
    static final int POSICIONY = 20;
    public ArrayList<Carta> cartas;
    
    public MazoSecundario(){
        cartas = new ArrayList();
    }
       
    public boolean añadir(Carta carta){
        cartas.add(carta);
        recolocar();
        return true;
    }
    
    public void recolocar(){
        ultimaCarta().x = POSICIONX;
        ultimaCarta().y = POSICIONY;
    }
    
    public Carta ultimaCarta(){
        return cartas.get(cartas.size()-1);
    }
    
    public void eliminar (){
        cartas.remove(cartas.size()-1);
    }
    
    public void paint (Graphics g, Applet a){
        for (int i=0; i<cartas.size(); i++)
            cartas.get(i).paint(g, a);
    }  
}