package E4_Cuarto;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class Lugar {
    public static final int DIM = 48;
    private Image imagen;
    int valor;
    
    public Lugar(Image img, int valor){
        imagen = img;
        this.valor = valor;
    }
    
    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
    public void paint(Graphics g, Applet a, int fila, int columna){
        g.drawImage(imagen, columna*DIM, fila*DIM, DIM, DIM, a);
    }
}