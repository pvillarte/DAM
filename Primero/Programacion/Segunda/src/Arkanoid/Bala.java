
package Arkanoid;

import java.awt.*;

public class Bala extends Rectangle{
    
    int targetX, targetY;
    float interX, interY;
    float pendiente;
    
    public Bala(int mouseX, int mouseY, int x, int y){
        super(x, y, 10, 10);
        pendiente=(mouseX-x)/(mouseY-y);
        interX=x;
        interY=y;
        
    }
    
    public void paint(Graphics g){
        g.setColor(Color.CYAN);
        g.fillOval(x, y, width, height);
    }
    
    public void update(){
        interX += pendiente;
    }
    
}
