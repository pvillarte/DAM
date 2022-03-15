
package Ejercicio14;

import java.applet.Applet;
import java.awt.*;
import java.util.*;

public class Jugando extends Applet implements Runnable {
    public static final int NUMPELOTAS= 10;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    java.util.List<Pelota> listaPelotas;
    
    public void init(){
        imagen = this.createImage(300, 300); //Con este método instanciamos la imagen
        noseve = imagen.getGraphics();
        listaPelotas= new ArrayList<Pelota>();
        for (int i=0; i<NUMPELOTAS; i++)
            listaPelotas.add(new Pelota());
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
        noseve.fillRect(0, 0, 300, 300);
        for (int i=0; i<listaPelotas.size(); i++)
            listaPelotas.get(i).dibujar(noseve);
        if (listaPelotas.size()==0){
            noseve.setColor(Color.white);
            noseve.drawString("AMEISIN",50, 20);
        }
        g.drawImage(imagen, 0, 0, this);
    }
    
    public void run(){
        do{
            for (int i=0; i<listaPelotas.size(); i++)
            listaPelotas.get(i).actualizar();
            repaint();
            try{
                Thread.sleep(30);
            }catch(InterruptedException e){};
        }while(true);
    }
    public boolean mouseDown(Event ev, int x, int y){
        for (int i=0; i<listaPelotas.size(); i++)
            if(listaPelotas.get(i).contains(x, y))
                listaPelotas.remove(i);
        return true;
    }
    
}
