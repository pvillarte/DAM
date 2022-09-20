package E1_Primero;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class DibujoAnimado extends Rectangle {
    
    public static int GUERRILLERO = 0;
    public static int HAMPON = 1;
    public static int VAQUERO = 2;
    Image[][] imagenes;
    int fotogramaActual;
    private int tipo;
    int velocidad;
    
    public DibujoAnimado(Image[][] imgs){
        super((int)(Math.random()*(Caminar.RESX-60)), (int)(Math.random()*(Caminar.RESY-80)), 60, 80);
        velocidad = (int)(Math.random()*10)+5;
        imagenes = imgs;
        tipo = (int)(Math.random()*imagenes.length);
        fotogramaActual = (int)(Math.random()*imagenes.length);
    }
    
    public void paint (Graphics g, Applet a){
        g.drawImage(imagenes[tipo][fotogramaActual], x, y, width, height,  a);
    }
    
    public void update (){
        fotogramaActual = (fotogramaActual+1)%imagenes[tipo].length;
        x += velocidad;
    }  
    
    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public double getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
}
