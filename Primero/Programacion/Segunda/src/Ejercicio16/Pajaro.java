
package Ejercicio16;
import java.awt.*;
import java.util.List;

public class Pajaro extends Rectangle {
    int velY;
    
    public Pajaro(){
        super(80, 20, 15, 15);
        velY=1;
    }
    
    public void dibujar (Graphics g){
        g.setColor(Color.blue);
        g.fillRect(x, y, width, height);
    }
    
    public void update (boolean a){
        if (!a)
            y +=velY;
    }
}
