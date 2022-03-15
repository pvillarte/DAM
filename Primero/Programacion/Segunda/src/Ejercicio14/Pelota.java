
package Ejercicio14;

import java.awt.*;

public class Pelota extends Rectangle {
    Color[]  colores ={Color.GREEN, Color.BLUE, Color.RED, Color.YELLOW, Color.ORANGE, Color.PINK};
    Color color;
    int velX, velY;
    
    public Pelota(){
        super((int)(Math.random()*250), (int)(Math.random()*250), 0, 0);
        int diametro = (int)(Math.random()*15)+10;
        width = height = diametro;
        color = colores[(int)(Math.random()*colores.length)];
        velX = ((int)(Math.random()*6)+1);
        velY = ((int)(Math.random()*6)+1);
    }
        
    public void dibujar(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
    
    public void actualizar(){
        x += velX;
        y += velY;
        if ((x<0)||(x>300-width))
            velX *= -1;
        if ((y<0)||(y>300-height))
            velY *= -1;

    }
}
