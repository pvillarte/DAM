
package examen3_Pablo_Villarte;

import java.awt.*;

public class Marcador {
    
    int x, y, DIM;
    private int errores;
    public Marcador(){
        errores=0;
        x=100;
        y=examen3_Pablo_Villarte.Juego.RESY-200;
        DIM=100;
    }

    public void paint (Graphics g){
        g.drawRect(x, y, 4*DIM, DIM);
        g.setFont(new Font ("Monospaced", Font.BOLD, 56));
        g.drawString("Errores: "+String.valueOf(errores), x+30, y+70);
    }
    public int getErrores() {
        return errores;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }
}
