
package examen3_Pablo_Villarte;

import java.applet.Applet;
import java.awt.*;

public class CasillaBandera extends Rectangle {
    
    Bandera bandera;
    String nombrePais;
    private int idPais;
    static final int MARGENX = 600;
    static final int MARGENY = 50;
    
    public CasillaBandera(int idPais, String[] nombresPaises){
        super (0, 0, Bandera.DIMANCHURA, Bandera.DIMALTURA);
        this.idPais= idPais;
        this.nombrePais = nombresPaises[idPais-1];    
    }
    
    public void paint (Graphics g, Applet a){
        g.drawRect(x, y, width, height);
        g.setFont(new Font ("Monospaced", Font.BOLD, 16));
        g.drawString(String.valueOf(nombrePais), x+5, y+20);
        if (bandera != null)
            bandera.paint(g, a);
    }
    
    public void posicionar(int posX, int posY){
        this.x= MARGENX+posX*Bandera.DIMANCHURA;
        this.y= MARGENY+posY*Bandera.DIMALTURA;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }
    
    
    
}
