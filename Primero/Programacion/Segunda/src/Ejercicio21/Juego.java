package Ejercicio21;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Juego extends Applet implements Runnable {

    Thread animacion;
    Image imagen;
    Graphics noseve;
    Font fuenteTexto;
    public static final int RESX = 500;
    public static final int RESY = 500;
    public static final int PASOTIEMPO = 15;
    List<Pelota> pelotas;

    public void init() {
        this.resize(RESX, RESY);
        imagen = this.createImage(RESX, RESY);
        noseve = imagen.getGraphics();
        fuenteTexto = new Font("SansSerif", Font.PLAIN, 36);
        pelotas = new ArrayList<>();
        pelotas.add(new Pelota());
    }

    public void paint(Graphics g) {
        noseve.setColor(Color.black);
        noseve.fillRect(0, 0, RESX, RESY);
        for (int i = 0; i < pelotas.size(); i++) {
            pelotas.get(i).paint(noseve);
        }
        g.drawImage(imagen, 0, 0, this);
    }

    public void start() {
        animacion = new Thread(this);
        animacion.start();
    }

    public void run() {
        do {
            for (int i = 0; i < pelotas.size(); i++) {
                pelotas.get(i).update();
            }
            colisiones(pelotas);
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
        for (int i = 0; i < pelotas.size(); i++) {
            if (pelotas.get(i).contains(x, y)) 
                if (pelotas.get(i).width>15){
                    pelotas.add(new Pelota(pelotas.get(i), true));
                    pelotas.add(new Pelota(pelotas.get(i), false));
                    pelotas.remove(i);
                    break;
                }else{
                    pelotas.remove(i);
                }
        }
        return true;
    }
    
    public void colisiones(List<Pelota> pelotas){
        for(int i=0; i<pelotas.size(); i++)
            for(int j=pelotas.size()-1; j>i; j--)
                if(pelotas.get(i).intersects(pelotas.get(j))){
                    int auxVelX = pelotas.get(i).velX;
                    int auxVelY = pelotas.get(i).velY;
                    pelotas.get(i).velX = pelotas.get(j).velX;
                    pelotas.get(i).velY = pelotas.get(j).velY;
                    pelotas.get(j).velX = auxVelX;
                    pelotas.get(j).velY = auxVelY;
                }
    }
}
