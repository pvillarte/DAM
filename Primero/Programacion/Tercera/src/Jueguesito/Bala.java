
package Jueguesito;
import java.awt.*;

public class Bala extends Rectangle{
    
    final double VEL = 8;
    int difX, difY, xCentro, yCentro, dimension;
    double modulo, velX, velY, xReal, yReal;
            
    public Bala(int naveXCentro, int naveYCentro, int mouseX, int mouseY){
        super(0, 0, 0, 0);
        xCentro = naveXCentro;
        yCentro = naveYCentro;
        dimension = 8;
        width = height = dimension;
        x = xCentro-dimension/2;
        y = yCentro-dimension/2;
        difX = (mouseX-xCentro);
        difY = (mouseY-yCentro);
        modulo = Math.sqrt(difX*difX+difY*difY);
        xReal = x;
        yReal = y;
        velX = (VEL*difX)/modulo;
        velY = (VEL*difY)/modulo;
    }
    
    public void paint(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(x, y, width, height);
    }
    
    public void update(){
        xReal += velX;
        yReal += velY;
        x = (int)(xReal);
        y = (int)(yReal);
    }
}
