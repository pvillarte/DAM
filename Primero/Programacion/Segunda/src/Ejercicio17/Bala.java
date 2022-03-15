
package Ejercicio17;

import java.awt.*;
import java.util.List;

public class Bala extends Rectangle{
    int velY=-6;
    
    public Bala(int posX){
        super(posX, 800, 8, 16);
    }
        
    public void dibujar(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x, y, width, height);
    }
    
    public int update(int idBala, List<Bala> b, List<Marciano> m){
        y += velY;
        for (int i=0; i< m.size(); i++)
            if (this.intersects(m.get(i))){
                m.remove(i);
                b.remove(idBala);
                return 1;
            }
        return 0;
    }
}
