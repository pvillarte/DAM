package E7_Septimo;

import java.applet.Applet;
import java.awt.*;

public class Solitario extends Applet {

    Image imagen, imgReverso;
    Graphics noseve;
    public static final int RESX = 1600;
    public static final int RESY = 900;
    public static final int NUM_CARTAS = 52;
    public static final int CPP = 13;
    public static final int NUM_PALOS = 4;
    Image[][] imgCartas;
    String[] nombresPalos = {"_of_clubs.png","_of_spades.png", "_of_diamonds.png", "_of_hearts.png"};
    Rectangle reverso;
    Baraja baraja;
    MazoSecundario mSecundario;
    Carta activa;
    MazoPalo[] mazosPalos;
    MazoJuego[] mazosJuego;
    int activaX, activaY;
    
    public void init() {
        setupApplet();
        cargarImagenes();
        reverso = new Rectangle(20, 20, Carta.ANCHURA, Carta.ALTURA);
        baraja = new Baraja(imgCartas, imgReverso);
        mSecundario = new MazoSecundario();
        mazosPalos = new MazoPalo[4];
        for (int i=0; i< mazosPalos.length; i++)
            mazosPalos[i] = new MazoPalo((Carta.ANCHURA+10)*i+600);
        mazosJuego = new MazoJuego[7];
        for (int i=0; i< mazosJuego.length; i++)
            mazosJuego[i] = new MazoJuego(i);
    }

    public void paint(Graphics g) {
        noseve.setColor(Color.GREEN);
        noseve.fillRect(0, 0, RESX, RESY);
        noseve.drawImage(imgReverso, 20, 20, Carta.ANCHURA, Carta.ALTURA, this);
        for (int i=0; i< mazosPalos.length; i++)
            mazosPalos[i].paint(noseve, this);
        for (int i=0; i< mazosJuego.length; i++)
            mazosJuego[i].paint(noseve, this);
        mSecundario.paint(noseve, this);
        if (activa != null) activa.paint(noseve, this);
        g.drawImage(imagen, 0, 0, this);
    }

    public boolean mouseDown(Event e, int x, int y){
        if (baraja.cartas.isEmpty()){
            for (int i=0; i< mSecundario.cartas.size(); i++)
                baraja.cartas.add(mSecundario.cartas.get(i));
            mSecundario.cartas.clear();
            repaint();
        }
        if (reverso.contains(x,y) && !baraja.cartas.isEmpty()){
            mSecundario.añadir(baraja.sacarCarta());
            repaint();
        }
        if (!mSecundario.cartas.isEmpty() && mSecundario.ultimaCarta().contains(x, y)){
            activa = mSecundario.ultimaCarta();
            activaX = activa.x;
            activaY = activa.y;
        }
        for (int i=0; i< mazosJuego.length; i++)
            if (!mazosJuego[i].cartas.isEmpty() && mazosJuego[i].cartas.get(mazosJuego[i].cartas.size()-1).contains(x, y)){
                activa = mazosJuego[i].cartas.get(mazosJuego[i].cartas.size()-1);
                activaX = activa.x;
                activaY = activa.y;
            }
        return true;
    }
    
    public boolean mouseUp(Event e, int x, int y){
        boolean encontrado;
        if (activa != null) {
            encontrado=false;
            for (int i=0; i<mazosPalos.length; i++)
                if (activa.intersects(mazosPalos[i]))
                    if (mazosPalos[i].añadir(activa)){
                        if (mSecundario.cartas.contains(activa)){
                                mSecundario.eliminar();
                        } else {
                            for (int j=0; j<mazosJuego.length; j++)
                                if (j!=i && mazosJuego[j].cartas.contains(activa)){
                                    mazosJuego[j].eliminar();
                                }
                        }
                        encontrado = true;
                        mazosPalos[i].recolocar();
                        break;
                    }
            for (int i=0; i< mazosJuego.length; i++){
                if (mazosJuego[i].cartas.isEmpty()){
                    if (activa.intersects(mazosJuego[i])){
                        if(mazosJuego[i].añadir(activa)){
                             if (mSecundario.cartas.contains(activa)){
                                    mSecundario.eliminar();
                            } else {
                                for (int j=0; j<mazosJuego.length; j++)
                                    if (j!=i && mazosJuego[j].cartas.contains(activa)){
                                        mazosJuego[j].eliminar();
                                    }
                            }
                            encontrado = true;
                            break;
                        }
                    }
                } else if (activa.intersects(mazosJuego[i].ultimaCarta())){
                    if(mazosJuego[i].añadir(activa)){
                         if (mSecundario.cartas.contains(activa)){
                                mSecundario.eliminar();
                        } else {
                            for (int j=0; j<mazosJuego.length; j++)
                                if (j!=i && mazosJuego[j].cartas.contains(activa)){
                                    mazosJuego[j].eliminar();
                                }
                        }
                        encontrado = true;
                        break;
                    }
                }
            }
            
            if (!encontrado){
                activa.x = activaX;
                activa.y = activaY;
            }
            activa = null;
        }
        activa = null;
        repaint();
        return true;
    }
    
    public boolean mouseDrag(Event e, int x, int y) {
        if (activa != null) {
            activa.update(x, y);
        }
        repaint();
        return true;
    }
    
    public void update(Graphics g) {
        paint(g);
    }

    public void setupApplet() {
        this.resize(RESX, RESY);
        imagen = this.createImage(RESX, RESY);
        noseve = imagen.getGraphics();
        this.setLayout(new BorderLayout());
    }
    
    public void cargarImagenes() {
        imgCartas = new Image[NUM_PALOS][CPP];
        imgReverso = getImage(getCodeBase(), "E7_Septimo/Cartas/reverso.png");
        for (int i = 0; i < NUM_PALOS; i++) 
            for (int j=0; j<CPP; j++)
            imgCartas[i][j] = getImage(getCodeBase(), "E7_Septimo/Cartas/" + (j + 1) + nombresPalos[i]);
    }
}