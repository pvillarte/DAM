
package E3_Tercero;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class Arquero {
    
    Image imagen;
    private int y, dimension, cargaDisparo, PS;
    boolean disparoCargado;
    final int CADENCIA = 36;
    Font fuenteTexto;
    
    
    public Arquero (Image img){
        disparoCargado = false;
        this.imagen=img;
        dimension=150;
        y=100;
        cargaDisparo = 0;
        PS=10;
        fuenteTexto = new Font("Monospaced", Font.BOLD, 20);
    }
    
    public void update(){
        if (cargaDisparo == CADENCIA) { 
            setDisparoCargado(true);
        }
        if(cargaDisparo<CADENCIA) cargaDisparo++;
    }
    
    public void move(int y){
        if (y>dimension/2 && y<Guillermo.RESY-dimension/2){
            this.y=y-dimension/2;
        }
    }
    
    public void paint (Graphics g, Applet a){
        g.drawImage(imagen, 20, y, dimension, dimension, a);
        indicadorCarga(g);
        g.setFont(fuenteTexto);
        g.setColor(Color.black);
        g.drawString("PS: "+PS, 45, y+160);
        
    }

    public void indicadorCarga(Graphics g) {
        g.setColor((cargaDisparo<CADENCIA/3)?(Color.red):(Color.yellow));
        if (disparoCargado) g.setColor(Color.green);
        g.fillArc(150, y, 30, 30, 0, cargaDisparo*(360/CADENCIA));
        g.setColor(Color.lightGray);
        g.fillOval(155, y+5, 20, 20);
    }
    
    public int getCargaDisparo() {
        return cargaDisparo;
    }
    public void setCargaDisparo(int cargaDisparo) {
        this.cargaDisparo = cargaDisparo;
    }
    public boolean isDisparoCargado() {
        return disparoCargado;
    }
    public void setDisparoCargado(boolean disparoCargado) {
        this.disparoCargado = disparoCargado;
    }
    public int getPS() {
        return PS;
    }
    public void setPS(int PS) {
        this.PS = PS;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
