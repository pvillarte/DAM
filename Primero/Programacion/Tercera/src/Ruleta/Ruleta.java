package Ruleta;

import java.applet.Applet;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Ruleta extends Applet implements Runnable{

    Thread animacion;
    Image imagen;
    Graphics noseve;
    public static final int RESX = 1500;
    public static final int RESY = 1000;
    public static final int NUMFICHAS = 10;
    final int[] VALORES = {1, 5, 10, 25, 50, 100, 500, 1000, 5000, 10000};
    Button sacaNumero;
    
    Casilla[][] casillas;
    Casilla cero;
    CasillaApuesta[] casillasApuesta;
    
    boolean ruletaActiva, primerajugadaConcluida;
    int PosicionBola;
    int[] numerosAleatorios;
    int numeroPremiado, numeroPremiadoAux;
    
    List<Ficha>[] fichas;
    Image[] imgFichas;
    Ficha activa;
    
    int[] historico;
    int dinero;
    
    public void init() {
        this.resize(RESX, RESY);
        imagen = this.createImage(RESX, RESY);
        noseve = imagen.getGraphics();
        this.setLayout(new BorderLayout());
        sacaNumero = new Button("Saca numero");
        this.add("North", sacaNumero);
        PosicionBola = 0;
        numerosAleatorios = new int[20];
        ruletaActiva = primerajugadaConcluida = false;
        dinero = 20000;
        setupFichas();
        setupCasillas();
        setupHistorico();
    }

    public void paint(Graphics g) {
        noseve.setColor(Color.LIGHT_GRAY);
        noseve.fillRect(0, 0, RESX, RESY);
        noseve.setColor(Color.BLUE);
        noseve.setFont(new Font ("Monospaced", Font.BOLD, 80));
        noseve.drawString(String.valueOf(PosicionBola), 50, RESY-150);
        paintCasillas();
        paintFichas();
        paintHistoricoValores();
        if (primerajugadaConcluida)
            paintNumeroSacado();
        paintCartera();
        g.drawImage(imagen, 0, 0, this);
    }
    
    
    public void run() {
        int i=0;
        for (int j=0; j<numerosAleatorios.length; j++)
                numerosAleatorios[j]=(int)(37*Math.random());
        numeroPremiado = (int)(37*Math.random());
        do {
            PosicionBola = (i<numerosAleatorios.length)?(numerosAleatorios[i]):(numeroPremiado);
            i++;
            repaint();
            try {
                Thread.sleep((i<numerosAleatorios.length-5)?(150):(500));
            } catch (InterruptedException e) {}
        } while (i<=numerosAleatorios.length);
        
        for (int j=historico.length-1; j>0; j--)
            historico[j]=historico[j-1];
        historico[0] = numeroPremiado;
        
        for (int k = 0; k <NUMFICHAS; k++)
            for (int j = 1; j < fichas[k].size(); j++) {
                dinero -= fichas[k].get(j).getValor();
                dinero += fichas[k].get(j).calculoApuesta(numeroPremiado);
            }
        
        for (int k = 0; k <NUMFICHAS; k++)
            while (fichas[k].size()>1)
                fichas[k].remove(1);
        primerajugadaConcluida = true;
        numeroPremiadoAux= numeroPremiado;
        ruletaActiva = false;
        repaint();
    }

    public void update(Graphics g) {
        paint(g);
    }

    public boolean action(Event ev, Object o){
        if(ev.target instanceof Button && !ruletaActiva){
            ruletaActiva = true;
            animacion = new Thread(this);
            animacion.start();
        }
        return true;
    }
    
    public boolean mouseDown(Event e, int x, int y) {
        for (int i = 0; i < NUMFICHAS; i++)
            for (int j = fichas[i].size() - 1; j >= 0; j--)
                if (fichas[i].get(j).contains(x, y))
                    if (j == 0) {
                        fichas[i].add(new Ficha(imgFichas[i], VALORES[i], i));
                        activa = fichas[i].get(fichas[i].size() - 1);
                        break;
                    } else {
                        activa = fichas[i].get(j);
                        break;
                    }
        return true;
    }

    public boolean mouseUp(Event e, int x, int y) {
        if (activa != null) {
            activa.apuesta(casillas, cero, casillasApuesta);
        }
        activa = null;
        return true;
    }

    public boolean mouseDrag(Event e, int x, int y) {
        if (activa != null) {
            activa.update(x, y);
        }
        repaint();
        return true;
    }
    
    public void setupCasillas() {
        casillas = new Casilla[12][3];
        for (int i = 0; i < casillas.length; i++)
            for (int j = 0; j < casillas[i].length; j++) 
                casillas[i][j] = new Casilla(i * Casilla.DIM + 150, 2*Casilla.DIM-(j * Casilla.DIM) + 100, 1 + j + (i * 3));
        cero = new Casilla(casillas[0][0].x-Casilla.DIM, casillas[0][2].y, 0);
        casillasApuesta = new CasillaApuesta[12];
        for (int i=0; i<casillasApuesta.length; i++)
            casillasApuesta[i] = new CasillaApuesta(casillas, i);
    }
    
    public void setupHistorico() {
        historico = new int[10];
        for (int i=0; i<historico.length; i++)
            historico[i]= -1;
    }
    
    public void setupFichas() {
        imgFichas = new Image[NUMFICHAS];
        fichas = new List[NUMFICHAS];
        for (int i = 0; i < NUMFICHAS; i++) {
            fichas[i] = new ArrayList();
            imgFichas[i] = getImage(getCodeBase(), "Ruleta/Fichas/ficha" + (i + 1) + ".png");
            fichas[i].add(new Ficha(imgFichas[i], VALORES[i], i));
        }
    }
    
    public void paintHistoricoValores() {
        noseve.setColor(Color.BLACK);
        for (int i = 0; i < historico.length; i++)
            noseve.drawRect(RESX-100, 100+70*i, 70, 70);
        for (int i = 0; i < historico.length; i++){
            noseve.setColor((Casilla.listaRojos.contains(historico[i]))?(Color.RED):(Color.BLACK));
            switch (historico[i]) {
                case -1:
                    noseve.setFont(new Font("Monospaced", Font.BOLD, 32));
                    noseve.drawString("n/a", RESX-90, 150+70*i);
                    break;
                case 0:
                    noseve.setFont(new Font("Monospaced", Font.BOLD, 42));
                    noseve.setColor(Color.GREEN);
                    noseve.drawString(String.valueOf(historico[i]), RESX-90, 150+70*i);
                    break;
                default:
                    noseve.setFont(new Font("Monospaced", Font.BOLD, 42));
                    noseve.drawString(String.valueOf(historico[i]), RESX-90, 150+70*i);
                    break;
            }
        }
    }
    
    public void paintFichas() {
        for (int i = 0; i < NUMFICHAS; i++)
            for (int j = 0; j < fichas[i].size(); j++)
                fichas[i].get(j).paint(noseve, this);
    }
    
    public void paintCasillas() {
        for (int i = 0; i < casillas.length; i++)
            for (int j = 0; j < casillas[i].length; j++)
                casillas[i][j].paint(noseve, this);
        cero.paint(noseve, this);
        for (int i=0; i< casillasApuesta.length; i++)
            casillasApuesta[i].paint(noseve, this);
    }
    
    public void paintNumeroSacado() {
        noseve.setFont(new Font("Monospaced", Font.BOLD, 60));
        noseve.setColor((Casilla.listaRojos.contains(numeroPremiadoAux))?(Color.RED):(Color.BLACK));
        String frase;
        frase = "";
        switch (numeroPremiadoAux) {
            case -1:
                noseve.drawString("n/a", 400, RESY-200);
                break;
            case 0:
                noseve.setColor(Color.GREEN);
                noseve.drawString(String.valueOf(numeroPremiadoAux), 400, RESY-200);
                frase += "Cero";
                break;
            default:
                noseve.drawString(String.valueOf(numeroPremiadoAux), 400, RESY-200);
                frase += (Casilla.listaRojos.contains(numeroPremiadoAux))?("Rojo - "):("Negro - ");
                frase += (numeroPremiadoAux%2 == 0)?("Par - "):("Impar - ");
                frase += (numeroPremiadoAux <= 18)?("Falta"):("Pasa");
                break;
        }
        noseve.setColor(Color.BLACK);
        noseve.setFont(new Font("Monospaced", Font.BOLD, 36));
        noseve.drawString(frase, 400, RESY-100);
    }
    
    public void paintCartera() {
        noseve.setColor((dinero>0)?(Color.BLACK):(Color.RED));
        noseve.setFont(new Font("Monospaced", Font.BOLD, 40));
        noseve.drawString("Balance: "+String.valueOf(dinero)+"€", 1000, RESY-100);
    }
}




