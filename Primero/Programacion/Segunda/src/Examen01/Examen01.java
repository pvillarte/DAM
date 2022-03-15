
package Examen01;
import java.applet.Applet;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Examen01 extends Applet implements Runnable {
    Thread animacion;
    Image imagen;
    Graphics noseve;
    public static final int RESX = 500;
    public static final int RESY = 500;
    public static final int PASOTIEMPO = 20;
    List<Objeto> objetos;
    final int NUMOBJETOS = 10;
    
    public void init() {
        this.resize(RESX, RESY);
        imagen = this.createImage(RESX, RESY);
        noseve = imagen.getGraphics();
        objetos = new ArrayList<>();
        for (int i = 0; i<NUMOBJETOS; i++)
            objetos.add(new Objeto());
    }
    
    public void paint(Graphics g) {
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, RESX, RESY);
        for (int i = 0; i<NUMOBJETOS; i++)
            objetos.get(i).paint(noseve);
        g.drawImage(imagen, 0, 0, this);
    }

    public void start() {
        animacion = new Thread(this);
        animacion.start();
    }

    public void run() {
        do {
            for (int i = 0; i<NUMOBJETOS; i++){
                objetos.get(i).update();
                if (objetos.get(i).isSprintando())
                    objetos.get(i).setDelayVelExtra(objetos.get(i).getDelayVelExtra()-PASOTIEMPO);
                if (objetos.get(i).getDelayVelExtra()<=0)
                    objetos.get(i).setSprintando(false); 
            }
            repaint();
            try {
                Thread.sleep(PASOTIEMPO);
            } catch (InterruptedException e) {
            }
        } while (true);
    }

    public void update(Graphics g) {
        paint(g);
    }
    
    public boolean mouseDown(Event ev, int x, int y) {
        for (int i = 0; i < NUMOBJETOS; i++) 
            if (objetos.get(i).contains(x, y)){
                objetos.get(i).setSprintando(true);
                objetos.get(i).setDelayVelExtra(2000);
                }
        return true;
    }
}