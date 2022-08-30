
package examen3_Pablo_Villarte;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.net.*;

public class Juego extends Applet implements Runnable{
    
    Image imagen;
    Graphics noseve;
    public static final int RESX = 1200;
    public static final int RESY = 800;
    public static final int NUMBANDERAS = 16;
    public static final int LADOTABLERO = (int)(Math.sqrt(NUMBANDERAS));
    Image[] imgBanderas;
    TableroBanderas tableroBanderas;
    TableroNombres tNombres;
    Bandera activa;
    int initialX, initialY;
    Marcador marcador;
    AudioClip exito, error, acierto;
    Thread animacion;
    Crono crono;
    boolean victoria, derrota, exitoPlayed;
    
    public void init(){
        this.resize(RESX, RESY);
        imagen = this.createImage(RESX, RESY);
        noseve = imagen.getGraphics();
        imgBanderas = new Image [NUMBANDERAS];
        for (int i=0; i<NUMBANDERAS; i++)
            imgBanderas[i] = this.getImage(this.getCodeBase(), ("examen3_Pablo_Villarte/Banderas/pais"+(i+1)+".jpg"));
        tableroBanderas = new TableroBanderas(imgBanderas);
        tNombres= new TableroNombres();
        marcador= new Marcador();
        crono = new Crono(120);
        victoria = derrota = exitoPlayed = false;
        try{
            error = getAudioClip(new URL(this.getCodeBase(), "examen3_Pablo_Villarte/sonidos/error.wav"));
            acierto = getAudioClip(new URL(this.getCodeBase(), "examen3_Pablo_Villarte/sonidos/correct.wav"));
            exito = getAudioClip(new URL(this.getCodeBase(), "examen3_Pablo_Villarte/sonidos/exito.wav"));
        }catch(MalformedURLException m){}
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.white);
        noseve.fillRect(0, 0, RESX, RESY);
        tNombres.paint(noseve, this);
        tableroBanderas.paint(noseve, this);
        marcador.paint(noseve);
        if (activa != null)
            activa.paint(noseve, this);
        crono.paint(noseve);
        if (crono.getTiempo()<1){
            noseve.setColor(Color.BLACK);
            noseve.setFont(new Font("Monospaced", Font.BOLD, 90));
            noseve.drawString("GAME ", 200, 440);
            noseve.drawString("OVER ", 200, 540);
        }   
        if (victoria){
            noseve.setColor(Color.BLACK);
            noseve.setFont(new Font("Monospaced", Font.BOLD, 90));
            noseve.drawString("GANASTE", 115, 90);
            if (!exitoPlayed){
                exito.play();
                animacion.stop();
                exitoPlayed=true;
            }
        }    
        g.drawImage(imagen, 0, 0, this);
    }
    
    public void update(Graphics g) {
        paint(g);
    }
    
    public boolean mouseDown(Event ev, int x, int y){
        if(!derrota && !victoria){
            for (int i=0; i<NUMBANDERAS; i++)
                if (tableroBanderas.banderas.get(i).contains(x, y) && !tableroBanderas.banderas.get(i).isColocada()){
                    activa=tableroBanderas.banderas.get(i);
                    initialX=tableroBanderas.banderas.get(i).x;
                    initialY=tableroBanderas.banderas.get(i).y;
                }
        }
        return true;
    }
    
    public boolean mouseDrag(Event ev, int x, int y){
        if(!derrota && !victoria){
            if (activa != null){
                activa.x=x-Bandera.DIMANCHURA/2;
                activa.y=y-Bandera.DIMALTURA/2;
                }
            repaint();
        }
        return true;
    }
    
    public boolean mouseUp(Event ev, int x, int y){
        if(!derrota && !victoria){
            if (activa != null){
                boolean intersecta=false;
                for (int i=0; i<LADOTABLERO; i++)
                    for (int j=0; j<LADOTABLERO; j++)
                        if (activa.intersects(tNombres.casillas[i][j]) && activa.id == tNombres.casillas[i][j].getIdPais()){
                            activa.reposicionar(tNombres.casillas[i][j].x,tNombres.casillas[i][j].y);
                            activa.setColocada(true);
                            intersecta=true;
                            acierto.play();
                            break;
                    }
                if (!intersecta){
                    error.play();
                    activa.x=initialX;
                    activa.y=initialY;
                    marcador.setErrores(marcador.getErrores()+1);
                }
            }
            activa=null;
            victoria=comprobarVictoria();
            repaint();
        }
        return true;
    }
    
    public void run() {
        do {
            crono.setTiempo(crono.getTiempo()-1);
            repaint();
            if (crono.getTiempo()==0){
                derrota=true;
                animacion.stop();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        } while (true);
    }
        
    public void start() {
        animacion = new Thread(this);
        animacion.start();
    }
    
    public boolean comprobarVictoria(){
        boolean ganaste = true;
        for (int i=0; i<NUMBANDERAS; i++)
            if (!tableroBanderas.banderas.get(i).isColocada())
                ganaste = false;
        return ganaste;
    }
}
