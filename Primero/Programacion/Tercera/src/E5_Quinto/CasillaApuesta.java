
package E5_Quinto;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

public class CasillaApuesta extends Rectangle {
    
    static final int ROJO = 0;
    static final int NEGRO = 1;
    static final int PAR = 2;
    static final int IMPAR = 3;
    static final int FALTA = 4;
    static final int PASA = 5;
    static final String [] TIPO = {"Rojo", "Negro", "Par", "Impar", "Falta", "Pasa"}; 
    int tipo;
    final int[] rojos={1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 26, 27, 30, 32, 34, 36};
    public static ArrayList<Integer> listaRojos;
    
    public CasillaApuesta(int posX, int posY, int tipo){
        super(posX, posY, 0, 0);
        height = Casilla.DIM;
        width = Casilla.DIM*2;
        this.tipo = tipo;
        listaRojos = new ArrayList();
        for (int i=0; i<rojos.length; i++)
            listaRojos.add(rojos[i]);
    }
    
    public ArrayList<Integer> getNumerosApostados(){
        ArrayList apostados = new ArrayList();
        apostados.clear();
        switch(tipo){
            case ROJO:
                for (int i=0; i<rojos.length; i++)
                    apostados.add(rojos[i]);
                break;
            case NEGRO:
                for (int i=1; i<37; i++)
                    if (!listaRojos.contains(i)) apostados.add(i);
                break;
            case PAR:
                for (int i=2; i<37; i+=2)
                    apostados.add(i);
                break;
            case IMPAR:
                for (int i=1; i<37; i+=2)
                    apostados.add(i);
                break;
            case FALTA:
                for (int i=1; i<19; i++)
                    apostados.add(i);
                break;
            case PASA:
                for (int i=19; i<37; i++)
                    apostados.add(i);
                break;
        }
        return apostados;
    }
    
    public void paint(Graphics g, Applet a){
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
        g.setFont(new Font ("Monospaced", Font.BOLD, 42));
        g.drawString(TIPO[tipo], x+10, y+40);
    }
}
