
package Examen02;
import java.applet.Applet;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Examen02 extends Applet implements Runnable {
    Thread animacion;
    Image imagen;
    Graphics noseve;
    public static final int RESX = 500;
    public static final int RESY = 500;
    public static final int PASOTIEMPO = 15;
    List<Gota> gotas;
    final int DELAYLLUVIA=15;
    int acumuladorDelay;
    
    public void init() {
        this.resize(RESX, RESY);
        imagen = this.createImage(RESX, RESY);
        noseve = imagen.getGraphics();
        gotas = new ArrayList<>();
        acumuladorDelay=0;
    }
    
    public void paint(Graphics g) {
        noseve.setColor(Color.CYAN);
        noseve.fillRect(0, 0, RESX, RESY);
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, RESY-40, RESX, 40);
        for (int i = 0; i < gotas.size(); i++)
            gotas.get(i).paint(noseve);
        g.drawImage(imagen, 0, 0, this);
    }

    public void start() {
        animacion = new Thread(this);
        animacion.start();
    }

    public void run() {
        do {
            acumuladorDelay+=1;
            if (acumuladorDelay==DELAYLLUVIA){
                gotas.add(new Gota());
                acumuladorDelay=0;
            }
            for (int i = 0; i < gotas.size(); i++)
                gotas.get(i).update();
            
            if (gotas.size()>0 && gotas.get(0).y > RESY-gotas.get(0).height-40)
                    gotas.remove(0);
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
}