package Ejercicio19;
import java.awt.*;

public class Pelota extends Rectangle {
    
    int velX=2;
    int velY=1;
    Color color;
    
    public Pelota(){
        super(Pong.RESX/2, Pong.RESY/2, 10, 10);
        color = Color.WHITE;
    }
    
    public void update(Raqueta j1, Raqueta j2){
        x+=velX;
        y+=velY;
        if (intersects(j1)||intersects(j2))
            velX = -velX;
        if (y<0 || y+height>Pong.RESY)
            velY = -velY;
    }
    
    public void gol(Raqueta r1, Raqueta r2){
        if (x>Pong.RESX+100){
            x=Pong.RESX-50;
            velX = -velX;
            y= Pong.RESY/2;
            r1.setGolesEncajados();
        } else if (x<-width-100){
                x=30;
                velX = -velX;
                y= Pong.RESY/2;
                r2.setGolesEncajados();
            }
    }
    
    public void paint (Graphics g){
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
}
