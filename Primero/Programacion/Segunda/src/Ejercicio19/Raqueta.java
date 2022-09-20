
package Ejercicio19;

import java.awt.*;

public class Raqueta extends Rectangle {
    
    public static final int VEL = 10;
    public static final int UP = 0;
    public static final int DOWN = 1;
    Color color;
    private int golesEncajados;
    
    public Raqueta(int posX, Color color){
        super(posX, Pong.RESY/2-25, 5, 50);
        this.color = color;
        golesEncajados=0;
    }
    
    public void update(int movimiento){
        if(movimiento == UP)
            y -= VEL;
        else
            y += VEL;
        if (y<0) y=0;
        if (y+height>Pong.RESY) y=Pong.RESY-height;
    }
    
    public void paint (Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    
    public int getGolesEncajados() {
        return golesEncajados;
    }

    public void setGolesEncajados() {
        golesEncajados++;
    }
   
}

