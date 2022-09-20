
package Jueguesito;
import java.applet.Applet;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Jueguesito extends Applet implements Runnable{
    
    Image imagen;
    Graphics noseve;
    Thread animacion;
    List<Bala> balas;
    Nave nave;
    public static final int RESX = 1200;
    public static final int RESY = 800;
    int mouseX, mouseY;
    
    public void init(){
        this.resize(RESX, RESY);
        imagen = this.createImage(RESX, RESY);
        noseve = imagen.getGraphics();
        balas = new ArrayList<>();
        nave = new Nave();
    }
    
    public void start() {
        animacion = new Thread(this);
        animacion.start();
    }
    
    public void run() {
        do {
            if (nave.isDisparando() && nave.isDisparoActivo()){
                balas.add(new Bala(nave.xCentro, nave.yCentro, mouseX, mouseY));
                nave.setDisparoActivo(false);
                nave.setDelay(0);
            }
            nave.update();
            for (int i=0; i<balas.size(); i++)
                balas.get(i).update();
            repaint();
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
            }
        } while (true);
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.lightGray);
        noseve.fillRect(0, 0, RESX, RESY);
        for (int i=0; i<balas.size(); i++)
            balas.get(i).paint(noseve);
        nave.paint(noseve);
        g.drawImage(imagen, 0, 0, this);
    }
    
    public boolean mouseDown (Event e, int x, int y){
        nave.setDisparando(true);
        mouseX=x;
        mouseY=y;
        return true;
    }
    public boolean mouseDrag (Event e, int x, int y){
        mouseX=x;
        mouseY=y;
        return true;
    }
    public boolean mouseUp (Event e, int x, int y){
        nave.setDisparando(false);           
        return true;
    }
    
    public boolean keyDown(Event e, int tecla){
        if (tecla == 119)
            nave.setN(true);
        if (tecla == 100)
            nave.setE(true);          
        if (tecla == 115)
            nave.setS(true);
        if (tecla == 97)
            nave.setO(true);
        return true;
    }
    
    public boolean keyUp(Event e, int tecla){
        if (tecla == 119)
            nave.setN(false);
        if (tecla == 100)
            nave.setE(false);       
        if (tecla == 115)
            nave.setS(false);
        if (tecla == 97)
            nave.setO(false);
        return true;
    }
    
    public void update(Graphics g) {
        paint(g);
    }

}
