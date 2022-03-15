
package Arkanoid;
import java.applet.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Game extends Applet implements Runnable {
    
    final int PASO = 15;
    public static final int RESX = 800;
    public static final int  RESY = 800;
    Thread animacion;
    Image imagen;
    Graphics bufferImage;
    Nave nave;
    List<Bala> balas;
    
    public void init(){
        this.resize(RESX, RESY);
        imagen = this.createImage(RESX, RESY);
        bufferImage = imagen.getGraphics();
        nave = new Nave();
        balas = new ArrayList<>();
    }
    
    public void start() {
        animacion = new Thread(this);
        animacion.start();
    }
    
    public void run(){
        do{
            repaint();
            try {
                Thread.sleep(PASO);
            } catch (InterruptedException e) {
            }
        }while (true);
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void paint(Graphics g) {
        bufferImage.setColor(Color.BLACK);
        bufferImage.fillRect(0, 0, RESX, RESY);
        nave.paint(bufferImage);
        g.drawImage(imagen, 0, 0, this);
    }
    
    public boolean keyDown(Event ev, int tecla){
            nave.update(tecla);
        return true;
    }
    
    public boolean mouseDown(Event ev, int x, int y) {
            balas.add(new Bala(x, y, nave.x, nave.y));
        return true;
    }
}
