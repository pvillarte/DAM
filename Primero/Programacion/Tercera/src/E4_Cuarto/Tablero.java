package E4_Cuarto;

import java.applet.*;
import java.awt.*;
import java.net.*;

public class Tablero extends Applet{
    
    public static final int TAM = 5;
    Image imagen;
    Graphics noseve;
    Image[][] imagenes;
    Lugar[][] lugares;
    AudioClip exito, error, acierto;
    Point blanco;
    Button boton;
    
    
    public void init(){
        this.resize(700, 700);
        imagen = this.createImage(700, 700);
        noseve = imagen.getGraphics();
        imagenes = new Image[TAM][TAM];
        lugares = new Lugar[TAM][TAM];
        blanco = new Point(TAM-1, TAM-1);
        boton= new Button("Mueve mueve");
        this.add(boton);
        for (int i = 0; i < TAM; i++){
            for (int j = 0; j < TAM; j++){
                imagenes[i][j] = this.getImage(this.getCodeBase(), "E4_Cuarto/botones/" + ((i*TAM)+j+1) + ".gif");
                lugares[i][j] = new Lugar(imagenes[i][j], i*TAM+j+1);
            }
        }
        try{
            error = getAudioClip(new URL(this.getCodeBase(), "E4_Cuarto/sonidos/error.wav"));
            acierto = getAudioClip(new URL(this.getCodeBase(), "E4_Cuarto/sonidos/nice.wav"));
            exito = getAudioClip(new URL(this.getCodeBase(), "E4_Cuarto/sonidos/exito.wav"));
        }catch(MalformedURLException m){}
    }

    public void update(Graphics g){
        paint(g);
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.WHITE);
        noseve.fillRect(0, 0, 700, 700);
        for (int i = 0; i < TAM; i++)
            for (int j = 0; j < TAM; j++)
                lugares[i][j].paint(noseve, this, i, j);
        g.drawImage(imagen, 0, 0, this);
    }
    
    public boolean mover(Point click){
        Point desplazamiento, hasta;
        desplazamiento = new Point(delta(click.x, blanco.x), delta(click.y, blanco.y));
        if(((desplazamiento.x==0)&&(desplazamiento.y==0))||((desplazamiento.x!=0)&&(desplazamiento.y!=0)))
            return false;
        hasta = new Point(click.x + desplazamiento.x, click.y + desplazamiento.y);
        if(!((hasta.x==blanco.x)&&(hasta.y==blanco.y)))
            mover(hasta);
        lugares[blanco.x][blanco.y].setImagen(lugares[click.x][click.y].getImagen());
        lugares[blanco.x][blanco.y].valor = lugares[click.x][click.y].valor;
        lugares[click.x][click.y].setImagen(null);
        lugares[click.x][click.y].valor=25;
        blanco=click;
        repaint();
        return true;
    }

    public boolean comprobarVictoria() {
        boolean correcto = true;
        for (int i = 0; i < TAM; i++)
            for (int j = 0; j < TAM; j++){
            if (lugares[i][j].valor != i*TAM+j+1)
                correcto = false;
            }
        return correcto;
    }
    
    public int delta(int a, int b){
        if(a==b) return 0;
        else return ((b-a)/Math.abs(b-a));
    }
    
    public boolean mouseDown(Event ev, int x, int y){
        Point click;
        click = new Point(y/Lugar.DIM, x/Lugar.DIM);
        ((mover(click))?(acierto):(error)).play();
        if(comprobarVictoria()){
            exito.play();
        }
        return true;     
    }
    
    public boolean action(Event ev, Object o){
        if(ev.target instanceof Button)
            for(int i=0; i<150; i++){
                Point movAleatorio = new Point((int)(TAM*Math.random()),(int)(TAM*Math.random()));
                mover(movAleatorio);
            }
        return true;
    }
}