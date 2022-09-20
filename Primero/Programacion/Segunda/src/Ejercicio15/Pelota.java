
package Ejercicio15;

import java.awt.*;
import java.util.List;

public class Pelota extends Bloque{
    
    int velX=-3;
    int velY=-2;
    
    public Pelota(){
        super(50, 200, 9, 9, Color.WHITE);
    }
        
    public void dibujar(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
    
    public void update(Raqueta r, List<Ladrillo> l){
        x += velX;
        y += velY;
        
        if ((x<0)||(x>300-width))
            velX *= -1;
        if ((y<0))
            velY *= -1;
        
        if (y>500){
            x=50;
            y=200;
            velX=-3;
            velY=-2;
        }
            
        if (this.intersects(r)){
            if(y+height/2>r.y && y+height/2<r.y+r.height)
                velX =-velX;
            else 
                velY =-velY;
        }
        
        for (int i=0; i<l.size(); i++){
            if (this.intersects(l.get(i))){
                if(y+height/2>l.get(i).y && y+height/2<l.get(i).y+l.get(i).height)
                    velX =-velX;
                else 
                    velY =-velY;
                l.remove(i);
                break;
            }
        }
    }
}
