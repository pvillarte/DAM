
package Arkanoid;

import java.awt.*;

public class Nave extends Rectangle{
    
    public static final int VEL = 10;
    
    public Nave(){
        super(Game.RESX/2-20, Game.RESY/2-20, 40, 40);
    }
    
    public void paint(Graphics g){
        g.setColor(Color.CYAN);
        g.fillOval(x, y, width, height);
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
        if (x>Game.RESX-width) x=Game.RESX-width;
        if (y>Game.RESY-height) y=Game.RESY-height;
    }
}
