package Ejercicio18;
import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

public class Juego extends Applet implements Runnable{
    Thread animacion;
    Image imagen;
    Graphics noseve;
    java.util.List<Coche> coches;
    int delayCoche;
    Rana rana;
    private boolean gameOver;
    Font fuenteTexto;
    public static final int RESX=800;
    public static final int RESY=600;
    public static final int PASOTIEMPO=15;
    int vidas;
    int cuentaAtras;
    int delayCuentaAtras;
    private boolean victoria;
    Carretera[] carreteras;

    public void init(){
        this.resize(RESX,RESY);
        imagen = this.createImage(RESX, RESY); //Con este método instanciamos la imagen
        noseve = imagen.getGraphics();
        coches = new ArrayList<>();
        rana = new Rana();
        gameOver=false;
        delayCoche=0;
        fuenteTexto = new Font("SansSerif", Font.PLAIN, 36);
        vidas=3;
        cuentaAtras=30;
        gameOver=false;
        victoria=false;
        carreteras = new Carretera[2];
                for (int i=0; i<carreteras.length; i++)
                    carreteras[i]= new Carretera(0, RESY/6+i*RESY/2-i*RESY/6, RESX, RESY/3);
    }
    public void start(){
        animacion = new Thread(this);
        animacion.start();      //Llama al método run
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.GRAY);
        noseve.fillRect(0, 0, RESX, RESY);
        noseve.fillRect(0, 0, RESX, RESY);
        for (int i=0; i<carreteras.length; i++)
            carreteras[i].dibujar(noseve);
        noseve.setColor(Color.WHITE);
        noseve.fillRect(0, RESY/2-1, RESX, 2);
        
        rana.dibujar(noseve);
        for (int i=0; i<coches.size(); i++){
            coches.get(i).dibujar(noseve);
        }
        noseve.setColor(Color.YELLOW);
        noseve.setFont(fuenteTexto);
        noseve.drawString("Vidas: "+ vidas,25,50);
        noseve.drawString("Tiempo restante: " + cuentaAtras,RESX-350,50);
        if(isGameOver()){
            noseve.setColor(Color.YELLOW);
            noseve.setFont(fuenteTexto);
            noseve.drawString("Game Over",325,200);
            animacion.stop();
        }
        if(isVictoria()){
            noseve.setColor(Color.YELLOW);
            noseve.setFont(fuenteTexto);
            noseve.drawString("Has ganado",325,200);
            noseve.drawString("Puntuación: "+String.valueOf(cuentaAtras+vidas*5),310,250);
            animacion.stop();
        }
        g.drawImage(imagen, 0, 0, this);
    }
    
    public void run() {
        do{
            delayCuentaAtras+=PASOTIEMPO;
            delayCoche+=PASOTIEMPO;
            if (delayCoche==PASOTIEMPO*30){
                coches.add(new Coche());
                delayCoche=0;
            }
            for (int i=0; i<coches.size(); i++){
                coches.get(i).update(carreteras);
            }
            for (int i=0; i<coches.size(); i++){
                if (coches.get(i).x<-40 ||coches.get(i).x>RESX+40)
                    coches.remove(i);
            }
            if(rana.collision(coches)) vidas--;
            if(vidas == 0 || cuentaAtras == 0) setGameOver(true);
            if(delayCuentaAtras>=1000){
                delayCuentaAtras=0;
                cuentaAtras--;
            }
            if (rana.y <= RESY/6-rana.height) setVictoria(true);
            repaint();
            try{
                Thread.sleep(PASOTIEMPO);
            }catch(InterruptedException e){}
        }while(true);
    }
    public boolean keyDown(Event ev, int tecla){
            rana.update(tecla);
        return true;
    }

    public boolean isVictoria() {
        return victoria;
    }
    public void setVictoria(boolean victoria) {
        this.victoria = victoria;
    }
    public boolean isGameOver() {
        return gameOver;
    }
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}
