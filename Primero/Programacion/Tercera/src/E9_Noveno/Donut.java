
package E9_Noveno;

import java.applet.Applet;
import java.awt.*;

public class Donut extends Rectangle{
    
    public static final int DIM = 100;
    private Image imagen;
    public Image reverso;
    private boolean descubierta;
    
    public Donut (int posX, int posY, Image reverso, Image imagen){
        super (posX, posY, DIM, DIM);
        this.imagen = imagen;
        this.reverso = reverso;
        descubierta = false;
    }
    
    public void paint (Graphics g, Applet a){
        if (isDescubierta())
            g.drawImage(imagen, x, y, width, height, a);
        else
            g.drawImage(reverso, x, y, width, height, a);
    }
    
    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public boolean isDescubierta() {
        return descubierta;
    }

    public void setDescubierta(boolean descubierta) {
        this.descubierta = descubierta;
    }
    
}
