
package E2_Segundo;
import java.applet.Applet;
import java.awt.*;

public class Pieza extends Rectangle {
    
    Image imagenPieza;
    private int idPieza;
    int dimension = 60;
    private boolean seleccionada;
    private boolean colocada; 
    
    public Pieza(Image[] imgs, int numPieza){
        super(0, 0, 0, 0);
        x = (int)(440+Math.random()*300);
        y = (int)(50+Math.random()*300);
        width = height = dimension;
        idPieza = numPieza;
        imagenPieza = imgs[idPieza%5+(idPieza/5)*5];
    }
    
    public void paint (Graphics g, Applet a){
        g.setColor(Color.black);
        g.drawImage(imagenPieza, x, y, width, height,  a);
        if(!colocada)
            g.drawRect(x, y, width, height);
    }
    
    public void move(int x, int y){
        this.x = x-width/2;
        this.y = y-height/2;
    }
    
    public void update (int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void snap () {
        this.x=(int)(50+(idPieza%5)*60);
        this.y=(int)(50+(idPieza/5)*60);
    }
    
    public boolean isSeleccionada() {
        return seleccionada;
    }
    public void setSeleccionada(boolean seleccionada) {
        this.seleccionada = seleccionada;
    }  
    public int getIdPieza() {
        return idPieza;
    }
    public void setIdPieza(int idPieza) {
        this.idPieza = idPieza;
    }
    public boolean isColocada() {
        return colocada;
    }
    public void setColocada(boolean colocada) {
        this.colocada = colocada;
    }
}
