
package Ejercicio18;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Carretera extends Rectangle{
    
     public Carretera(int x, int y, int anch, int alt){
         super(x, y, anch, alt);
     }
     
     public void dibujar(Graphics g){
         g.setColor(Color.BLACK);
         g.fillRect(x, y, width, height);
     }
}
