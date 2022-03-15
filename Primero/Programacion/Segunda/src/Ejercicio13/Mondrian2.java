package Ejercicio13;

import Ejercicio12.Rectangulo;
import java.applet.Applet;
import java.awt.*;

public class Mondrian2 extends Applet implements Runnable{
    Thread animacion;
    Image imagen;
    Graphics noSeVe;
    Rectangulo[] rectangulos;
    Rectangulo fondo;
    int[] posicionesX={0, 250, 80, 80, 100, 90, 200, 0 , 200};
    int[] posicionesY={0, 0, 160, 220, 10, 120, 0, 110, 55};
    int[] anchuras={90, 90, 100, 220, 90, 110, 45, 70, 60}; 
    int[] alturas={90, 90, 120, 90, 80, 90, 45, 200, 135};
    Color[] colores={Color.yellow, Color.yellow, Color.yellow, Color.blue,
        Color.blue, Color.lightGray, Color.red, Color.red, Color.magenta};
    
     public void init(){
        imagen = this.createImage(300, 300); //Con este método instanciamos la imagen
        noSeVe = imagen.getGraphics();
        rectangulos= new Rectangulo[9];
        for(int i=0; i<rectangulos.length; i++){
            rectangulos[i] = new Rectangulo(posicionesX[i], posicionesY[i], anchuras[i], alturas[i], colores[i]);
        }
        fondo = new Rectangulo(0,0,300,300,Color.black);
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
        for(int i=0; i<rectangulos.length; i++){
            rectangulos[i].dibujar(noSeVe);
        }
        g.drawImage(imagen, 0, 0, this);
    }
    
    public void run(){
        do{
            for(int i=0; i<rectangulos.length;i++)
                rectangulos[i].actualizar();
            repaint();      
            try{
                Thread.sleep(10);
            }catch(InterruptedException e){};
        }while(true);
    }

}
