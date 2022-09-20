
package Ejercicio20;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Cactus extends Rectangle {
    
    Color[] colores={Color.BLUE, Color.CYAN, Color.GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.YELLOW};
    Color color;
    
    public Cactus(){
        super(Juego.RESX, Juego.RESY-100 , 20, 50); 
        height=(int)(Math.random()*35+25);
        y=Juego.RESY-50-height;
        color = colores[(int)Math.random()*colores.length];
    }
    
    public void update(int puntuacion){
        x -= puntuacion/2+2;
    }
    
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    
}
