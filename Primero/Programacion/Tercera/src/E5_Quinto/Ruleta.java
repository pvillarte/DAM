package E5_Quinto;

import java.applet.Applet;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Ruleta extends Applet implements Runnable {

    Thread animacion;
    Image imagen;
    Graphics noseve;
    public static final int RESX = 1500;
    public static final int RESY = 1000;
    public static final int NUMFICHAS = 10;
    final int[] VALORES = {1, 5, 10, 25, 50, 100, 500, 1000, 5000, 10000};
    final int DINEROINICIAL = 20000;
    Image[] imgFichas;
    List<Ficha>[] fichas;
    Ficha activa;
    Casilla[][] casillas;
    Button sacaNumero;
    int dinero, numAleatorio;
    int historico[];
    Casilla casillaCero;
    CasillaApuesta[] casillasApuesta;
    
    public void init() {
        setupApplet();
        setupFichas();
        setupValoresIniciales();
        setupHistorico();
        setupCasillas();
        setupBotonApuesta();
    }

    public void paint(Graphics g) {
        noseve.setColor(Color.LIGHT_GRAY);
        noseve.fillRect(0, 0, RESX, RESY);
        paintCasillas();
        paintFichas();
        paintHistoricoValores();
        paintNumeroSacado();
        paintCartera();
        g.drawImage(imagen, 0, 0, this);
    }
    
    public void start() {
        animacion = new Thread(this);
        animacion.start();
    }
    
    public void run() {
        do {
            repaint();
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
            }
        } while (true);
    }

    public void update(Graphics g) {
        paint(g);
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
            activa.apuesta(casillas, casillaCero, casillasApuesta);
        }
        activa = null;
        return true;
    }

    public boolean mouseDrag(Event e, int x, int y) {
        if (activa != null) {
            activa.update(x, y);
        }
        return true;
    }

    public boolean keyDown(Event ev, int tecla) {
        if (tecla == 127)
            for (int i=0; i<NUMFICHAS; i++)
                fichas[i].remove(activa);
        return true;
    }
    
    public boolean action(Event ev, Object o){
        if(ev.target instanceof Button)
            numAleatorio = (int)(Math.random()*37);
        for (int i=historico.length-1; i>0; i--)
            historico[i]=historico[i-1];
        historico[0] = numAleatorio;
        for (int i = 0; i <NUMFICHAS; i++)
            for (int j = 1; j < fichas[i].size(); j++) {
                dinero -= fichas[i].get(j).getValor();
                dinero += fichas[i].get(j).calculoApuesta(numAleatorio);
            }
        for (int i = 0; i <NUMFICHAS; i++)
            while (fichas[i].size()>1)
                fichas[i].remove(1);
        return true;
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
    
    public void paintNumeroSacado() {
        noseve.setFont(new Font("Monospaced", Font.BOLD, 60));
        noseve.setColor((Casilla.listaRojos.contains(numAleatorio))?(Color.RED):(Color.BLACK));
        String frase;
        frase = "";
        switch (numAleatorio) {
            case -1:
                noseve.drawString("n/a", 500, 220);
                break;
            case 0:
                noseve.setColor(Color.GREEN);
                noseve.drawString(String.valueOf(numAleatorio), 500, 220);
                frase += "Cero";
                break;
            default:
                noseve.drawString(String.valueOf(numAleatorio), 500, 220);
                frase += (Casilla.listaRojos.contains(numAleatorio))?("Rojo - "):("Negro - ");
                frase += (numAleatorio%2 == 0)?("Par - "):("Impar - ");
                frase += (numAleatorio <= 18)?("Falta"):("Pasa");
                break;
        }
        noseve.setColor(Color.BLACK);
        noseve.setFont(new Font("Monospaced", Font.BOLD, 36));
        noseve.drawString(frase, 500, 300);
    }
    
    public void paintFichas() {
        for (int i = 0; i < NUMFICHAS; i++)
            for (int j = 0; j < fichas[i].size(); j++)
                fichas[i].get(j).paint(noseve, this);
    }

    public void paintCasillas() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 12; j++)
                casillas[i][j].paint(noseve, this);
        casillaCero.paint(noseve, this);
        for (int i=0; i< casillasApuesta.length; i++)
            casillasApuesta[i].paint(noseve, this);
    }
    
    public void setupFichas() {
        imgFichas = new Image[NUMFICHAS];
        fichas = new List[NUMFICHAS];
        for (int i = 0; i < NUMFICHAS; i++) {
            fichas[i] = new ArrayList();
            imgFichas[i] = getImage(getCodeBase(), "E5_Quinto/Fichas/ficha" + (i + 1) + ".png");
            fichas[i].add(new Ficha(imgFichas[i], VALORES[i], i));
        }
    }
    
    public void paintCartera() {
        noseve.setColor(Color.BLACK);
        noseve.setFont(new Font("Monospaced", Font.BOLD, 40));
        noseve.drawString("Cartera: "+String.valueOf(dinero)+"€", 500, 120);
    }

    public void setupHistorico() {
        historico = new int[10];
        for (int i=0; i<historico.length; i++)
            historico[i]= -1;
    }

    public void setupCasillas() {
        casillas = new Casilla[3][12];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 12; j++) 
                casillas[i][j] = new Casilla(i * Casilla.DIM + 20, j * Casilla.DIM + 30, 1 + i + (j * 3));
        casillaCero = new Casilla(4 * Casilla.DIM + 20, 40, 0);
        casillasApuesta = new CasillaApuesta[6];
        for (int i=0; i<casillasApuesta.length; i++)
            casillasApuesta[i] = new CasillaApuesta(4*Casilla.DIM+20, i*Casilla.DIM + 4*Casilla.DIM+30, i);
    }
    
    public void setupApplet() {
        this.resize(RESX, RESY);
        imagen = this.createImage(RESX, RESY);
        noseve = imagen.getGraphics();
        this.setLayout(new BorderLayout());
    }
    
    public void setupBotonApuesta() throws HeadlessException {
        sacaNumero = new Button("Saca numero");
        this.add("North", sacaNumero);
    }

    public void setupValoresIniciales() {
        dinero = DINEROINICIAL;
        numAleatorio = -1;
    }
}