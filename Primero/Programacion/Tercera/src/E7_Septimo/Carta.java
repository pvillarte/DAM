
package E7_Septimo;

import java.applet.Applet;
import java.awt.*;

public class Carta extends Rectangle {
    
    Image imagen, reverso;
    static final int ANCHURA = 125;
    static final int ALTURA = 210;
    static final int ROJO = 0;
    static final int NEGRO = 1;
    static final int TREBOLES = 0;
    static final int PICAS = 1;
    static final int DIAMANTES = 2;
    static final int CORAZONES = 3;
    private int palo;
    private int valor;
    private int color;
    
    public Carta(Image img, Image rev, int palo, int valor){
        super(200, 20, ANCHURA, ALTURA);
        imagen=img;
        this.palo=palo;
        this.valor=valor;
        reverso=rev;
        color=(palo<2)?(ROJO):(NEGRO);
    }
    
    public void paint (Graphics g, Applet a){
        g.drawImage(imagen, x, y, ANCHURA, ALTURA, a);
    }
    
    public void update(int x, int y){
        this.x = x-ANCHURA/2;
        this.y = y-ALTURA/2;
    }

    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public int getColor() {
        return color;
    }
    public void setColor(int color) {
        this.color = color;
    }
    
    public int getPalo() {
        return palo;
    }

    public void setPalo(int palo) {
        this.palo = palo;
    }
}
