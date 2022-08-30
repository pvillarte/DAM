
package E2_Segundo;
import java.applet.Applet;
import java.awt.*;

public class Tablero extends Rectangle{
    
    Image imagen;
    Rectangle[][] celdas;
    boolean [][] celdasCompletas;
    int piezasLado;
    
    public Tablero(double numPiezas, int tamañoPieza, Image img){
        super(50, 50, 0, 0);
        imagen = img;
        piezasLado=(int) Math.sqrt(numPiezas);
        height = width = tamañoPieza*piezasLado;
        celdas = new Rectangle[piezasLado][piezasLado];
        celdasCompletas = new boolean[5][5];
        for (int i=0; i<piezasLado; i++)
            for (int j=0; j<piezasLado; j++){
                celdas[i][j]=new Rectangle(x+i*tamañoPieza, y+j*tamañoPieza, tamañoPieza, tamañoPieza);
                celdasCompletas[i][j] = false;
            }   
    }
    
    public void paint (Graphics g, Applet a){
        g.setColor(Color.black);
        g.drawImage(imagen, x, y, width, height,  a);
        for (int i=0; i<piezasLado; i++)
            for (int j=0; j<piezasLado; j++)
                if (!celdasCompletas[i][j])
                    g.drawRect(celdas[i][j].x, celdas[i][j].y, celdas[i][j].width, celdas[i][j].height);
        g.drawRect(x, y, width, height);
    }
}
