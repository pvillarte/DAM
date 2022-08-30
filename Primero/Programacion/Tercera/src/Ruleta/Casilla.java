
package Ruleta;
import java.applet.Applet;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;


public class Casilla extends Rectangle {
    
    public static final int DIM = 80;
    final int[] rojos={1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 26, 27, 30, 32, 34, 36};
    public static List<Integer> listaRojos;
    int valor;
    Color color;
    
    public Casilla(int posX, int posY, int val){
        super(posX, posY, 0, 0);
        width = height = DIM;
        valor = val;
        listaRojos = new ArrayList();
        for (int i=0; i<rojos.length; i++)
            listaRojos.add(rojos[i]);
        color = (listaRojos.contains(valor))?(Color.RED):(Color.BLACK);
        if (valor==0) {
            color=Color.GREEN;
            height = 3*DIM;
        }
    }
    
    public void paint(Graphics g, Applet a){
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
        g.setColor(color);
        g.setFont(new Font ("Monospaced", Font.BOLD, 42));
        g.drawString(String.valueOf(valor), x+10, y+40);
    }
   
}
