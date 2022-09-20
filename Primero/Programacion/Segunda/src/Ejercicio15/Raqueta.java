
package Ejercicio15;

import java.awt.*;

public class Raqueta extends Bloque {
    
    public static final int VELX = 5;
    
    public Raqueta(){
        super(50, 270, 60, 10, Color.WHITE);
    }
    
    public void dibujar(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    
    public void update(int direccion){
        if (direccion == Arkanoid.IZQUIERDA)
            x -= VELX;
        else
            x += VELX;
        if (x<0) x=0;
        if (x>240) x=240;
    }
}
