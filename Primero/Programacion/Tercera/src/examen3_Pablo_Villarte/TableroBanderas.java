
package examen3_Pablo_Villarte;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class TableroBanderas {
    
    ArrayList<Bandera> banderas;
    
    public TableroBanderas(Image[] imgs){
        banderas= new ArrayList();
        for (int i=0; i<examen3_Pablo_Villarte.Juego.NUMBANDERAS; i++)
            banderas.add(new Bandera(imgs[i], i+1));
        Collections.shuffle(banderas);
        for (int i=0; i<examen3_Pablo_Villarte.Juego.NUMBANDERAS; i++)
            banderas.get(i).recolocarInicial(i%4, i/4);
    }
    
    public void paint(Graphics g, Applet a){
        for (int i=0; i<examen3_Pablo_Villarte.Juego.NUMBANDERAS; i++)
            banderas.get(i).paint(g, a);
    }
    
}
