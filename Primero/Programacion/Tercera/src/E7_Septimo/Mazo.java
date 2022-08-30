
package E7_Septimo;

import java.applet.Applet;
import java.awt.Graphics;

public interface Mazo {
    
    public boolean añadir(Carta c);
    public void paint (Graphics g, Applet a);
    public void recolocar ();
    public Carta ultimaCarta();
    public void eliminar();
    
}
