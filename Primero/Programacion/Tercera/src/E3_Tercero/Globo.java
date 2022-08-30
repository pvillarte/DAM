
package E3_Tercero;
import java.applet.Applet;
import java.awt.*;

public class Globo extends Rectangle{ 
    
    Image imagen;
    private int tipoGlobo, daño;
    
    public Globo (Image [] img){
        super((int)(Guillermo.RESX-75-Math.random()*(2*Guillermo.RESX/3)), Guillermo.RESY, 75, 150);
        tipoGlobo=(int)(Math.random()*img.length);
        imagen=img[tipoGlobo];
        switch (tipoGlobo){
            case 0:
                daño=1;
                break;
            case 1:
                daño=3;
                break;
            case 2:
                daño=5;
        }
    }
    
    public void paint(Graphics g, Applet a){
        g.drawImage(imagen, x, y, width, height, a);
    }
    
    public void update (){
        switch (tipoGlobo){
            case 0:
                y -= 4;
                break;
            case 1:
                y -= 3;
                break;
            case 2:
                y -= 2;
        }
    }
    public int getDaño() {
        return daño;
    }
    public void setDaño(int daño) {
        this.daño = daño;
    }   
}
