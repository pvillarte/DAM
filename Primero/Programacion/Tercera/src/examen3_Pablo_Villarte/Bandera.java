
package examen3_Pablo_Villarte;

import java.applet.Applet;
import java.awt.*;

public class Bandera extends Rectangle {
    
    Image imagen;
    int id;
    public static final int DIMANCHURA = 100;
    public static final int DIMALTURA = 70;
    public static final int MARGEN = 50;
    private boolean colocada;
    
    public Bandera(Image img, int id){
        super(0, 0, DIMANCHURA, DIMALTURA);
        imagen = img;
        this.id= id;
        colocada=false;
    }
    
    public void paint(Graphics g, Applet a){
        g.setColor(Color.BLACK);
        g.drawImage(imagen, x, y, width, height, a);
        g.drawRect(x, y, width, height);
    }
    
    public void recolocarInicial (int posX, int posY){
        x = MARGEN + posX*DIMANCHURA;
        y = MARGEN + posY*DIMALTURA;
    }
    
    public void reposicionar (int x, int y){
        this.x=x;
        this.y=y;
    }

    public boolean isColocada() {
        return colocada;
    }

    public void setColocada(boolean colocada) {
        this.colocada = colocada;
    }
    
}
