
package Ejercicio15;

import java.applet.Applet;
import java.awt.*;
import java.util.*;
public class Arkanoid extends Applet implements Runnable {
    
    public static final int FILAS = 5;
    public static final int COLUMNAS = 10;
    public static final int IZQUIERDA = 0;
    public static final int DERECHA = 1;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    Raqueta raqueta;
    Pelota pelota;
    java.util.List<Ladrillo> ladrillos;
    
   public void init(){
        imagen = this.createImage(300, 300); //Con este método instanciamos la imagen
        noseve = imagen.getGraphics();
        ladrillos = new ArrayList<>();
        for (int i=0; i<FILAS; i++)
            for (int j=0; j<COLUMNAS; j++)
                ladrillos.add(new Ladrillo(30*j+1, 12*i+1, 28, 10, Bloque.COLORES[i]));
        raqueta= new Raqueta();
        pelota = new Pelota();
   }
    
    public void update (Graphics g){
        paint(g);
    }
    
    public void start(){
        animacion = new Thread(this);
        animacion.start();      //Llama al método run
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.black);
        noseve.fillRect(0, 0, 600, 600);
        for (int i=0; i<ladrillos.size(); i++)
                ladrillos.get(i).dibujar(noseve);
        raqueta.dibujar(noseve);
        pelota.dibujar(noseve);
        g.drawImage(imagen, 0, 0, this);
    }
    
    public void run(){
        do{
            pelota.update(raqueta, ladrillos);
            repaint();
            try{
                Thread.sleep(20);
            }catch(InterruptedException e){}
        }while(true);
    }
    
    public boolean keyDown(Event ev, int tecla){
        if (tecla == 1006) raqueta.update(IZQUIERDA);
        if (tecla == 1007) raqueta.update(DERECHA);
        return true;
    }
}
