
package Ejercicio16;
import java.applet.Applet;
import java.awt.*;
import java.util.*;

public class Flappy extends Applet implements Runnable {
    private boolean fin;
    boolean estaAleteando;
    public static final int TIEMPO = 15;
    int tiempoAcumulado;
    int contadorAleteo;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    Pajaro pajaro;
    java.util.List<Columna> columnas;
    Font fuenteTexto = new Font("SansSerif", Font.PLAIN, 36);
    int puntuacion;
    
   public void init(){
        this.resize(600,300);
        imagen = this.createImage(600, 300); //Con este método instanciamos la imagen
        noseve = imagen.getGraphics();
        pajaro = new Pajaro();
        columnas= new ArrayList<>();
        columnas.add(new Columna());
   }
    
    
    public void start(){
        animacion = new Thread(this);
        animacion.start();      //Llama al método run
        setFin(false);
    }
    
    public void update (Graphics g){
        paint(g);
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.LIGHT_GRAY);
        noseve.fillRect(0, 0, 600, 300);
        pajaro.dibujar(noseve);
        for (int i=0; i<columnas.size(); i++)
            columnas.get(i).dibujar(noseve);
        noseve.setColor(Color.GREEN);
        noseve.setFont(fuenteTexto);
        noseve.drawString(String.valueOf(puntuacion), 30, 30);
        if(isFin()){
            noseve.setColor(Color.YELLOW);
            noseve.setFont(fuenteTexto);
            noseve.drawString("Game Over", 225,125);
        }
        g.drawImage(imagen, 0, 0, this);
    }
    
    public void run(){
        do{
            if (estaAleteando)
                aleteo();
            pajaro.update(estaAleteando);
            tiempoAcumulado+=TIEMPO;
            if (tiempoAcumulado == TIEMPO*200){
                tiempoAcumulado=0;
                columnas.add(new Columna());
            }
            for (int i=0; i<columnas.size(); i++)
                columnas.get(i).update();
            if(columnas.get(0).getR1().x == pajaro.x)
                 puntuacion++;
            if(columnas.get(0).getR1().x < -columnas.get(0).getR1().width)
                columnas.remove(0);
            if (pajaro.intersects(columnas.get(0).getR1()) || pajaro.intersects(columnas.get(0).getR2())){
                fin=true;
                repaint();
                animacion.stop();
            }
            repaint();
            try{
                Thread.sleep(TIEMPO);
            }catch(InterruptedException e){}
        }while(true);
    }
    
    public boolean mouseDown(Event ev, int x, int y){
        contadorAleteo=0;
        estaAleteando=true;
        return true;
    }
    
    public void aleteo (){
        pajaro.y -= 2;
        contadorAleteo++;
        if (contadorAleteo ==10)
            estaAleteando=false;
    }

    public boolean isFin() {
        return fin;
    }
    public void setFin(boolean fin) {
        this.fin = fin;
    }
}
