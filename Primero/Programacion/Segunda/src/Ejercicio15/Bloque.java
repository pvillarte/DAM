
package Ejercicio15;

import java.awt.*;

abstract class Bloque extends Rectangle{
    
    Color color;
    static final Color[] COLORES ={Color.YELLOW, Color.RED, Color.ORANGE,  Color.PINK, Color.CYAN};
    
    public Bloque(int posX, int posY, int anchura, int altura, Color color){
        super(posX, posY, anchura, altura);
        this.color= color;
    }
    
    public abstract void dibujar(Graphics g);
}
