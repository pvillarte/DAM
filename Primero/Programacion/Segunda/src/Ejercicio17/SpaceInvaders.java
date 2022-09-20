package Ejercicio17;
import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

public class SpaceInvaders  extends Applet implements Runnable{
    Thread animacion;
    Image imagen;
    Graphics noseve;
    public static final int RESX=500;
    public static final int RESY=900;
    public static final int TIEMPO = 15;
    public static final int IZQUIERDA = 0;
    public static final int DERECHA = 1;
    Nave nave;
    java.util.List<Bala> balas;
    java.util.List<Marciano> marcianos;
    int delayMarcianos = 0;
    boolean disparoCargado = true;
    int delayDisparo= 0;
    Font fuenteTexto = new Font("SansSerif", Font.PLAIN, 36);
    private boolean fin;
    int puntuacion;
    
    Image imgNave;
    Image[] imgMarcianos;
    Image imgEspacio;

    public void init(){
        this.resize(RESX,RESY);
        imagen = this.createImage(RESX, RESY); //Con este método instanciamos la imagen
        noseve = imagen.getGraphics();
        nave = new Nave();
        balas = new ArrayList<>();
        marcianos = new ArrayList<>();
        puntuacion = 0;
        setFin(false);
        imgNave = getImage(getCodeBase(), "images/nave.png");
        imgEspacio = getImage(getCodeBase(), "images/space.jpg");
        imgMarcianos= new Image [5];
        for (int i=0; i<imgMarcianos.length; i++){
            String direccion = "images/"+i+".png";
            imgMarcianos[i] = getImage(getCodeBase(), direccion);
        }
    }
    public void start(){
        animacion = new Thread(this);
        animacion.start();      //Llama al método run
    }
    public void update(Graphics g){
        paint(g);
    }
    public void paint(Graphics g){
        noseve.drawImage(imgEspacio, 0, 0, RESX, RESY, this);
        for (int i=0; i<marcianos.size(); i++){
            noseve.drawImage(imgMarcianos[marcianos.get(i).idColor], marcianos.get(i).x,
                    marcianos.get(i).y, marcianos.get(i).width,marcianos.get(i).height, this);
        }
        for (int i=0; i<balas.size(); i++)
            balas.get(i).dibujar(noseve);
        noseve.setColor(Color.PINK);
        noseve.setFont(fuenteTexto);
        noseve.drawString(String.valueOf(puntuacion), 50, 50);
        noseve.drawImage(imgNave, nave.x, nave.y, 80, 80, this);
        if(isFin()){
            noseve.setColor(Color.PINK);
            noseve.setFont(fuenteTexto);
            noseve.drawString("Game Over", 170, 400);
            animacion.stop();
        }
        g.drawImage(imagen, 0, 0, this);
    }
    public void run() {
        do{
            for (int i=0; i<balas.size(); i++)
                puntuacion += balas.get(i).update(i, balas, marcianos);
            if (balas.size()>0)
                if (balas.get(0).y < -balas.get(0).height)
                    balas.remove(0);
            
            if (marcianos.size()>0){
                this.setFin(nave.update(marcianos));
                for (int i=0; i<marcianos.size(); i++)
                    if (marcianos.get(i).y > RESY){
                        marcianos.remove(i);
                    setFin(true);
                    repaint();
                    }
            }
            
            delayMarcianos += TIEMPO;
            delayDisparo += TIEMPO;
            if (delayDisparo == TIEMPO*10){
                delayDisparo=0;
                disparoCargado=true;
            }
            if (delayMarcianos == TIEMPO*150){
                delayMarcianos = 0;
                marcianos.add(new Marciano());
            }
            
            for (int i=0; i<marcianos.size(); i++)
                marcianos.get(i).update();
            
            repaint();
            try{
                Thread.sleep(TIEMPO);
            }catch(InterruptedException e){}
        }while(true);
    }

    public boolean mouseMove(Event ev, int posEjeX, int posEjeY){
        nave.x=posEjeX-(nave.width/2);
        if (nave.x<0) nave.x=0;
        if (nave.x>RESX-nave.width) nave.x=RESX-nave.width;
        return true;
    }
    public boolean mouseDown(Event ev, int posEjeX, int posEjeY){
        if (disparoCargado){
            balas.add(new Bala((nave.width/2)+nave.x+4));
            disparoCargado=false;
            delayDisparo=0;
        }
        return true;
    }
    public boolean isFin() {
        return fin;
    }
    public void setFin(boolean fin) {
        this.fin = fin;
    }
}
