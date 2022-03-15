
package Ejercicio20;
import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

public class Juego extends Applet implements Runnable{
    Thread animacion;
    Image imagen;
    Graphics noseve;   
    Font fuenteTexto;
    public static final int RESX=800;
    public static final int RESY=500;
    public static final int PASOTIEMPO=15;
    java.util.List<Cactus> cactus;
    Dinosaurio dino;
    boolean gameOver;
    int puntos, puntosSinRecibirDaño, delayAcumulado;
    
    public void init (){
        this.resize(RESX,RESY);
        imagen = this.createImage(RESX, RESY);
        noseve = imagen.getGraphics();
        cactus = new ArrayList<>();
        dino = new Dinosaurio();
        fuenteTexto = new Font("SansSerif", Font.PLAIN, 36);
        gameOver=false;
        puntos=0;
        puntosSinRecibirDaño=0;
        delayAcumulado = 0;
    }
    
    public void paint(Graphics g){
        setupEscenario();
        for (int i=0; i< cactus.size(); i++){
            cactus.get(i).paint(noseve);
        }
        dino.paint(noseve);
        if(isGameOver()){
            noseve.setColor(Color.YELLOW);
            noseve.setFont(fuenteTexto);
            noseve.drawString("Game Over",325,200);
            animacion.stop();
        }
        g.drawImage(imagen, 0, 0, this);
    }

    
    public void start(){
        animacion = new Thread(this);
        animacion.start();        
    }
    
    public void run() {
        do{
            delayAcumulado++;
            if(delayAcumulado==200){
                cactus.add(new Cactus());
                delayAcumulado=0;
            }
            for (int i=0; i< cactus.size(); i++) 
                cactus.get(i).update(puntos);
            dino.update();
            if (cactus.size()>0 && cactus.get(0).x< -cactus.get(0).width){
                cactus.remove(0);
                puntos++;
                puntosSinRecibirDaño++;
            }
            if(cactus.size()>0 && dino.collision(cactus.get(0))){
                dino.restaVidas();
                cactus.remove(0);
                puntosSinRecibirDaño=0;
            }            
            if (dino.getVidas()==2)
                puntosSinRecibirDaño=0;
            if (puntosSinRecibirDaño==4)
                dino.restauraVidas();
            if (dino.getVidas()==0)
                setGameOver(true);
            repaint();
            try{
                Thread.sleep(PASOTIEMPO);
            }catch(InterruptedException e){}
        }while(true);
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public boolean keyDown(Event ev, int tecla){
        if (tecla==32 && dino.y==RESY-100) //Tecla 32=barra espaciadora
            dino.setSaltando(true);  
        return true;
    }
    
    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
    
    public void setupEscenario() {
        noseve.setColor(Color.black);
        noseve.fillRect(0, 0, RESX, RESY);
        noseve.setColor(Color.orange);
        noseve.fillRect(0, RESY-50, RESX, 50);
        noseve.setColor(Color.YELLOW);
        noseve.setFont(fuenteTexto);
        noseve.drawString(String.valueOf(puntos),50,100);
        noseve.drawString("Vidas: "+dino.getVidas(),RESX-150,100);
    }
}
