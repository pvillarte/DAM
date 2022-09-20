
package E6_Sexto;

import java.applet.Applet;
import java.awt.*;

public class Carta {
    
    Image imagen, reverso;
    static final int ANCHURA = 150;
    static final int ALTURA = 300;
    int palo; 
    private int puntos, valor;
    private int posX, posY;
    String palos[] = {"Treboles", "Diamantes", "Corazones", "Picas"};
    
    public Carta(Image img, int pal, int val, Image rev){
        imagen=img;
        palo=pal;
        valor=val+1;
        reverso=rev;
        puntos = (valor>9)?(10):((valor==1)?(11):(valor));
    }
    
    public void paint (Graphics g, Applet a){
        g.drawImage(imagen, posX, posY, ANCHURA, ALTURA, a);
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }
    public void setPosY(int posY) {
        this.posY = posY;
    }
    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    public int getPuntos() {
        return puntos;
    }
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    
}
