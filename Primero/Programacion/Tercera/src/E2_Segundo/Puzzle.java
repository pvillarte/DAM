
package E2_Segundo;
import java.applet.Applet;
import java.awt.*;

public class Puzzle extends Applet{
        
    Image imagen;
    Graphics noseve;
    Image[] imagenes;
    public static final int RESX = 800;
    public static final int RESY = 400;
    Pieza piezas[];
    public static final int NUMPIEZAS = 25;
    int piezasLado = (int)(Math.sqrt(NUMPIEZAS));
    Tablero tablero;
    int piezaSeleccionada;
    Image imgTablero;
    
    public void init(){
        this.resize(RESX, RESY);
        imagen = this.createImage(RESX, RESY);
        noseve = imagen.getGraphics();
        imagenes = new Image [NUMPIEZAS];
        imgTablero=this.getImage(this.getCodeBase(), ("E2_Segundo/directorioImagenes/mapamundi3.png"));
        for (int i=1; i<=imagenes.length; i++)
            imagenes[i-1] = this.getImage(this.getCodeBase(), ("E2_Segundo/directorioImagenes/"+i+".png"));
        piezas = new Pieza[NUMPIEZAS];
        for (int i=0; i<piezas.length; i++)
            piezas[i] = new Pieza(imagenes, i);
        tablero = new Tablero(NUMPIEZAS, 60, imgTablero);
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.white);
        noseve.fillRect(0, 0, RESX, RESY);
        tablero.paint(noseve, this);
        for (int i=0; i<imagenes.length; i++)
           piezas[i].paint(noseve, this);
        noseve.drawRect(50, 50, 60*piezasLado, 60*piezasLado);
        if(piezaSeleccionada !=-1)
            piezas[piezaSeleccionada].paint(noseve, this);
        g.drawImage(imagen, 0, 0, this);  
    }
    
    public void update(Graphics g) {
        paint(g);
    }
    
    public boolean mouseDown(Event e, int x, int y){
        for (int i=0; i<NUMPIEZAS; i++)
            if(piezas[i].contains(x, y) && !piezas[i].isColocada()){
                piezas[i].setSeleccionada(true);
                piezaSeleccionada=piezas[i].getIdPieza();
                break;
            }
        return true;
    }
    
    public boolean mouseUp(Event e, int x, int y){
        if(piezaSeleccionada!=-1 && tablero.celdas[piezaSeleccionada%5][piezaSeleccionada/5].contains(x,y)){
            tablero.celdasCompletas[piezaSeleccionada%5][piezaSeleccionada/5]=true;
            piezas[piezaSeleccionada].snap();
            piezas[piezaSeleccionada].setColocada(true);
        }
        repaint();
        piezaSeleccionada= -1;
        return true;
    }
    
    public boolean mouseDrag (Event e, int x, int y){
        if(piezaSeleccionada != -1){
            piezas[piezaSeleccionada].move(x, y);
        }
        repaint();
        return true;
    }
}
