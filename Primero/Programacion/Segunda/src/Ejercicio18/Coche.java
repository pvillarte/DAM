
package Ejercicio18;

import java.awt.*;

public class Coche extends Rectangle{
    int velX;
    int velY;
    boolean derecha;
    public static final Color[] colores={Color.yellow, Color.orange, Color.blue,
        Color.pink, Color.lightGray, Color.magenta, Color.cyan};
    Color color;
    
    public Coche(){
        super(0, 0, 35, 20);
        velX = (int)(Math.random()*6+1);
        velY = (int)(Math.random()*5-2);
        if (Math.random()<0.5){
            x=-width;
            y=((int)(Math.random()*(Juego.RESY/3-height)+Juego.RESY/2));
        } else {
            x=Juego.RESX+width;
            y=((int)(Math.random()*(Juego.RESY/3-height)+Juego.RESY/6));
            velX *= -1;
        }
        color=colores[(int)(Math.random()*colores.length)];
    }
    //if inmediato
    //(condicionBooleana)?(resultadoSiTrue):(resultadoSiFalse)
    public void update (Carretera[] carriles){
        x += velX;
        y += velY;
        
        if (!(carriles[0].contains(this)||carriles[1].contains(this)))
            velY = -velY;
    }
    
    public void dibujar (Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}
