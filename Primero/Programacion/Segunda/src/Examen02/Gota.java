
package Examen02;

import java.awt.*;

public class Gota extends Rectangle {
    
    public Gota(){
        super ((int)(Math.random()*(Examen02.RESX-10)), -30, 10, 30);
    }
    
    public void paint (Graphics g){
        g.setColor(Color.BLUE);
        g.fillOval(x, y, width, height);
    }
    
    public void update (){
        y += 2;
    }
}
