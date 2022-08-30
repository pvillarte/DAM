
package examen3_Pablo_Villarte;

import java.awt.*;

public class Crono {
    int x, y, DIM;
    private int tiempo;
    
    public Crono(int t){
        DIM=100;
        tiempo=t;
        x=examen3_Pablo_Villarte.Juego.RESX-600;
        y=examen3_Pablo_Villarte.Juego.RESY-200;
    }

    public void paint (Graphics g){
        g.setColor(Color.BLACK);
        g.drawRect(x, y, 5*DIM, DIM);
        g.setFont(new Font ("Monospaced", Font.BOLD, 37));
        g.drawString("Tiempo restante: "+String.valueOf(tiempo), x+30, y+70);
    }
    
    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
}
