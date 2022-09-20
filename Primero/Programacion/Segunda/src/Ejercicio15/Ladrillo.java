
package Ejercicio15;
import java.awt.*;
public class Ladrillo extends Bloque {
    
    public Ladrillo(int posX, int posY, int anchura, int altura, Color color){
        super(posX, posY, anchura, altura, color);
    }
    
    public void dibujar(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}
