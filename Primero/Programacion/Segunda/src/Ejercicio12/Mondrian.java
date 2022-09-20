package Ejercicio12;
import java.awt.*;
import java.applet.Applet;
//Ciclo de vida applet: init(), start(), paint(Graphics g), stop()
public class Mondrian extends Applet implements Runnable{
    public static final int ARRIBA = 0;
    public static final int DERECHA = 1;
    public static final int ABAJO = 2;
    public static final int IZQUIERDA = 3;
    Thread animacion;
    Image imagen;
    Graphics noSeVe;
    int direccion;
    int posX, posY;
    Rectangulo fondo, ama1, ama2, ama3, az1, az2, gris, r1, r2, mag;
    
    public void init(){
        posX = 90;
        posY = 120;
        direccion = DERECHA;
        imagen = this.createImage(300, 300); //Con este método instanciamos la imagen
        noSeVe = imagen.getGraphics();
        setupRectangulos();
    }

    public void setupRectangulos() {
        fondo = new Rectangulo(0, 0, 300, 300, Color.black);
        ama1 = new Rectangulo(0, 0, 90, 90, Color.yellow);
        ama2 = new Rectangulo(250, 0, 90, 90, Color.yellow);
        ama3 = new Rectangulo(80, 160, 100, 120, Color.yellow);
        az1 = new Rectangulo(80, 220, 220, 90, Color.blue);
        az2 = new Rectangulo(100, 10, 90, 80, Color.blue);
        gris = new Rectangulo(posX, posY, 110, 90, Color.lightGray);
        r1 = new Rectangulo(200, 0, 45, 45, Color.red);
        r2 = new Rectangulo(0, 110, 70, 200, Color.red);
        mag = new Rectangulo(200, 55, 60, 135, Color.magenta);
    }

    public void start(){
        animacion = new Thread(this);
        animacion.start();      //Llama al método run
    }
    
    public void update (Graphics g){
        paint(g);
    }
    
    public void paint(Graphics g){
        fondo.dibujar(noSeVe);
        ama1.dibujar(noSeVe);
        ama2.dibujar(noSeVe);
        ama3.dibujar(noSeVe);
        az1.dibujar(noSeVe);
        az2.dibujar(noSeVe);
        gris.posX=posX;
        gris.posY=posY;
        gris.dibujar(noSeVe);
        r1.dibujar(noSeVe);
        r2.dibujar(noSeVe);
        mag.dibujar(noSeVe);
        g.drawImage(imagen, 0, 0, this);
    }
    
    public void run(){
        do{
            actualizar();
            repaint();
            try{
                Thread.sleep(30);
            }catch(InterruptedException e){};
        }while(true);
    }

    public void actualizar() {
        switch(direccion){
            case ARRIBA:
                posY--;
                if(posY<=90)
                    direccion = DERECHA;
                break;
            case DERECHA:
                posX++;
                if(posX>=120)
                    direccion = ABAJO;
                break;
            case ABAJO:
                posY++;
                if(posY>=120)
                    direccion = IZQUIERDA;
                break;
            case IZQUIERDA:
                posX--;
                if(posX<=90)
                    direccion = ARRIBA;
        }
    }
}
