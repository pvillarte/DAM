
package E1_Primero;
import java.applet.Applet;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;


public class Caminar extends Applet implements Runnable{
    
    Image[][] fotogramas;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    public static final int RESX = 900;
    public static final int RESY = 900;
    List<DibujoAnimado> npcs;
    Font texto;
    
    public void init(){
        this.resize(RESX, RESY);
        imagen = this.createImage(RESX, RESY);
        noseve = imagen.getGraphics();
        texto = new Font("SansSerif", Font.PLAIN, 36);
        fotogramas = new Image [3][4];
        String elementos[]={"E1_Primero/Sprites/Guerrillero/g", "E1_Primero/Sprites/Hampon/h", "E1_Primero/Sprites/Vaquero/v"};
        for (int i=0; i<fotogramas.length; i++)
            for (int j=0; j<fotogramas[i].length; j++)
                fotogramas[i][j] = this.getImage(this.getCodeBase(), (elementos[i]+(j+1)+".gif"));
        npcs = new ArrayList<>();
        for (int i=0; i<10; i++)
            npcs.add(new DibujoAnimado(fotogramas));
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.CYAN);
        noseve.fillRect(0, 0, RESX, RESY);
        for (int i=0; i< npcs.size(); i++)
            npcs.get(i).paint(noseve, this);
        if (npcs.size()==0) {
            noseve.setColor(Color.yellow);
            noseve.setFont(texto);
            noseve.drawString("Game Over", 100, 100);}
        g.drawImage(imagen, 0, 0, this);
        
    }
    
    public void start() {
        animacion = new Thread(this);
        animacion.start();
    }
    
    public void run() {
        do {
            for (int i=0; i< npcs.size(); i++)
                npcs.get(i).update();
            for (int i=0; i< npcs.size(); i++)
                if (npcs.get(i).getX()>RESX) 
                    npcs.get(i).setX(-npcs.get(i).width);
            repaint();
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
            }
        } while (true);
    }

    public void update(Graphics g) {
        paint(g);
    }
    
    public boolean keyDown (Event e, int tecla){
        switch(tecla){
            case 71:
            case 103:
                for (int i=0; i< npcs.size(); i++)
                    npcs.get(i).setTipo(DibujoAnimado.GUERRILLERO);
                break;
            case 72:
            case 104:
                for (int i=0; i< npcs.size(); i++)
                    npcs.get(i).setTipo(DibujoAnimado.HAMPON);
                break;
            case 118:
            case 86:
                for (int i=0; i< npcs.size(); i++)
                    npcs.get(i).setTipo(DibujoAnimado.VAQUERO);
        }
        return true;
    }
    
    public boolean mouseDown (Event ev, int x, int y){
        for (int i=0; i<npcs.size(); i++)
            if(npcs.get(i).contains(x, y)){
                npcs.remove(i);
                //break;
            }
        return true;
    }
}
