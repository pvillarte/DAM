
package E3_Tercero;
import java.applet.Applet;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Guillermo extends Applet implements Runnable{
    
    Image imagen;
    Graphics noseve;
    Thread animacion;
    Image[] globosImg;
    public static final int RESX = 1200;
    public static final int RESY = 800;
    Image arqueroImg, flechaImg;
    Arquero guillermo;
    List<Flecha> flechas;
    List<Globo> globos;
    int delayGlobo, acumDelayGlobo, puntos;
    Font fuenteGameOver, fuentePuntos;
    boolean gameOver;
    
    public void init(){
        this.resize(RESX, RESY);
        imagen = this.createImage(RESX, RESY);
        noseve = imagen.getGraphics();
        arqueroImg = this.getImage(this.getCodeBase(), ("E3_Tercero/directorioImagenes/arquero.png"));
        flechaImg = this.getImage(this.getCodeBase(), ("E3_Tercero/directorioImagenes/flecha.png"));
        globosImg= new Image[3];
        for (int i=0; i<globosImg.length; i++)
            globosImg[i] = this.getImage(this.getCodeBase(), ("E3_Tercero/directorioImagenes/globo"+(i+1)+".png"));
        guillermo = new Arquero(arqueroImg);
        flechas = new ArrayList<>();
        globos = new ArrayList<>();
        delayGlobo=100;
        acumDelayGlobo=0;
        fuenteGameOver = new Font ("Arial", Font.BOLD, 50);
        fuentePuntos = new Font ("Monospaced", Font.BOLD, 25);
        gameOver= false;
    }
    
    public void start() {
        animacion = new Thread(this);
        animacion.start();
    }
    
    public void run() {
        do {
            acumDelayGlobo++;
            guillermo.update();
            if (acumDelayGlobo == delayGlobo){
                globos.add(new Globo(globosImg));
                acumDelayGlobo=0;
                if(delayGlobo>30) delayGlobo--;
            }
            for (int i=0; i<flechas.size(); i++)
                puntos += flechas.get(i).update(globos);
            for (int i=0; i<globos.size(); i++)
                globos.get(i).update();
            if (flechas.size()>0 && flechas.get(0).x>RESX) flechas.remove(0);
            if (globos.size()>0 && globos.get(0).y<-200){ 
                guillermo.setPS(guillermo.getPS()-globos.get(0).getDaño());
                globos.remove(0);
            }
            if (guillermo.getPS()<=0) gameOver=true;
            repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
            }
        } while (true);
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.lightGray);
        noseve.fillRect(0, 0, RESX, RESY);
        if(gameOver){
            noseve.setColor(Color.black);
            noseve.setFont(fuenteGameOver);
            noseve.drawString("Game Over",470,200);
            animacion.stop();
        }
        for (int i=0; i<flechas.size(); i++)
            flechas.get(i).paint(noseve, this);
        for (int i=0; i<globos.size(); i++)
            globos.get(i).paint(noseve, this);
        guillermo.paint(noseve, this);
        noseve.setColor(Color.black);
        noseve.setFont(fuentePuntos);
        noseve.drawString("Puntuacion: "+puntos,RESX-260,50);
        g.drawImage(imagen, 0, 0, this);
    }
    
    public void update(Graphics g) {
        paint(g);
    }
    
    public boolean mouseMove(Event e, int x, int y){
            guillermo.move(y);
        return true;
    }
        
    public boolean mouseDown(Event e, int x, int y){
        if (guillermo.isDisparoCargado()) {
            flechas.add(new Flecha(flechaImg, y));
            guillermo.setDisparoCargado(false);
            guillermo.setCargaDisparo(0);
        }
        return true;
    }
    
    public boolean keyDown(Event ev, int tecla){
        if (tecla==32 && puntos>10){
            puntos -= 10;
            for (int i=0; i<5; i++)
                flechas.add(new Flecha(flechaImg, guillermo.getY()+i*30));
        }
        return true;
    }
    
}
