
package Ejercicio21;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pelota extends Rectangle {
    int velX, velY;
    Color[] colores={Color.BLUE, Color.CYAN, Color.GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.YELLOW};
    Color color;
    
    public Pelota(){
        super(Juego.RESX/2-120, Juego.RESY/2-120, 240, 240);
        velX=(int)(5-Math.random()*11);
        velY=(int)(5-Math.random()*11);
        if(velX==0) velX++;
        if(velY==0) velY++;
        color = colores[(int)(Math.random()*colores.length)];
    }
    
    public Pelota(int xx, int yy){
        super(xx, yy, 240, 240);
        velX=(int)(5-Math.random()*11);
        velY=(int)(5-Math.random()*11);
        if(velX==0) velX++;
        if(velY==0) velY++;
        color = colores[(int)(Math.random()*colores.length)];
    }
    
    public Pelota(Pelota origen, boolean idDivision){
        super(origen.x, origen.y, origen.width/2, origen.height/2);
        if (idDivision){
            x=origen.x+origen.width/2;
            y=origen.y+origen.height/2;
        }
        velX=(int)(5-Math.random()*11);
        velY=(int)(5-Math.random()*11);
        if(velX==0) velX++;
        if(velY==0) velY++;
        color = colores[(int)(Math.random()*colores.length)];
    }
    
    public void paint (Graphics g){
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
    
    public void update (){
        x += velX;
        y += velY;
        if(x<0) velX = Math.abs(velX);
        if(x>Juego.RESX-width) velX = -Math.abs(velX);
        if(y<0) velY = Math.abs(velY);
        if(y>Juego.RESY-height) velY = -Math.abs(velY);
    }
}
