
package examen3_Pablo_Villarte;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

public class TableroNombres {
    
    ArrayList<CasillaBandera> cList;
    CasillaBandera[][] casillas;
    String[] nombresPaises = {"Portugal", "Irlanda", "Andorra", "Finlandia", 
        "Belgica", "Alemania", "UK", "Grecia",
        "Ucrania", "Singapur", "Francia", "Suiza",
        "Croacia", "RepCheca", "Austria", "España"};
    
    public TableroNombres(){
        casillas = new CasillaBandera[examen3_Pablo_Villarte.Juego.LADOTABLERO][examen3_Pablo_Villarte.Juego.LADOTABLERO];
        cList = new ArrayList();
        for (int i=0;  i<nombresPaises.length; i++)
            cList.add(new CasillaBandera(i+1, nombresPaises));
        Collections.shuffle(cList);
        for (int i=0;  i<nombresPaises.length; i++)
            casillas[i%4][i/4] = cList.get(i);
        for (int i=0; i<casillas.length; i++)
            for (int j=0; j<casillas[i].length; j++)
                casillas[i][j].posicionar(i, j);
    }
    
    public void paint(Graphics g, Applet a){
        g.setColor(Color.BLACK);
        for (int i=0; i<casillas.length; i++)
            for (int j=0; j<casillas[i].length; j++)
            casillas[i][j].paint(g, a);
    }
    
}
