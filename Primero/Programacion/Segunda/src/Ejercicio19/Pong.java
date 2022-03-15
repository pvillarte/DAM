
package Ejercicio19;

import java.applet.Applet;
import java.awt.*;

public class Pong extends Applet implements Runnable{
    Thread animacion;
    Image imagen;
    Graphics noseve;
    Font fuenteTexto;
    Raqueta jugador1, jugador2;
    public static final int RESX=800;
    public static final int RESY=500;
    public static final int PASOTIEMPO=15;
    Pelota pelota;
        
    public void init(){
        this.resize(RESX,RESY);
        imagen = this.createImage(RESX, RESY);
        noseve = imagen.getGraphics();
        fuenteTexto = new Font("SansSerif", Font.PLAIN, 36);
        jugador1 = new Raqueta(10, Color.BLUE);
        jugador2 = new Raqueta(RESX-15, Color.YELLOW);
        pelota= new Pelota();
    }
    public void start(){
        animacion = new Thread(this);
        animacion.start();     
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.black);
        noseve.fillRect(0, 0, RESX, RESY);
        noseve.setColor(Color.yellow);
        noseve.setFont(fuenteTexto);
        noseve.drawString(jugador1.getGolesEncajados() + ":"+ jugador2.getGolesEncajados(), RESX/2-30, 30);
        pelota.paint(noseve);
        jugador1.paint(noseve);
        jugador2.paint(noseve);
        g.drawImage(imagen, 0, 0, this);
    }
    
    public void run() {
        do{
            pelota.update(jugador1, jugador2);
            pelota.gol(jugador1, jugador2);
            repaint();
            try{
                Thread.sleep(PASOTIEMPO);
            }catch(InterruptedException e){}
        }while(true);
    }
    
    public boolean keyDown(Event ev, int tecla){
        if(tecla==87 || tecla==119)
            jugador1.update(Raqueta.UP);
        if(tecla==83 || tecla==115)
            jugador1.update(Raqueta.DOWN);
        if (tecla==Event.UP)
            jugador2.update(Raqueta.UP);
        if (tecla==Event.DOWN)
            jugador2.update(Raqueta.DOWN);
        return true;
    }
}

