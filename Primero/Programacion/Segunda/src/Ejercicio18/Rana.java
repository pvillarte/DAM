
package Ejercicio18;
import java.awt.*;
import java.util.List;

public class Rana extends Rectangle {
    
    public static final int VEL = 10;
    
    public Rana(){
        super(Juego.RESX/2, Juego.RESY-40, 20, 20);
    }
    
    public void dibujar(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(x, y, width, height);
        g.setColor(Color.WHITE);
        g.drawRect(x, y, width, height);
    }
    
    public void update(int tecla){
        switch(tecla){
            case Event.LEFT:
                x -= VEL;
                break;
            case Event.RIGHT:
                x += VEL;
                break;
            case Event.UP:
                y -= VEL;
                break;
            case Event.DOWN:
                y += VEL;
                break;
        }
        if (x<0) x=0;
        if (y<0) y=0;
        if (x>Juego.RESX-width) x=Juego.RESX-width;
        if (y>Juego.RESY-height) y=Juego.RESY-height;
    }
    
    public boolean collision(List<Coche> c){
        for(int i=0; i<c.size(); i++)
            if(this.intersects(c.get(i))){
                c.remove(i);
                x=Juego.RESX/2;
                y=Juego.RESY-40;
                return true;
            }
        return false;
    }
}