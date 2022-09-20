package E6_Sexto;

import java.applet.Applet;
import java.awt.*;

public class Blackjack extends Applet {

    Image imagen;
    Graphics noseve;
    public static final int RESX = 1600;
    public static final int RESY = 800;
    public static final int NUM_CARTAS = 52;
    public static final int CPP = 13;
    public static final int NUM_PALOS = 4;
    Image[][] imgCartas;
    Button sacaCarta, plantarse, nuevaRonda;
    String[] nombresPalos = {"_of_clubs.png", "_of_diamonds.png", "_of_hearts.png", "_of_spades.png"};
    Baraja mazo;
    Mano manoJugador, manoCrupier;
    Image imgReverso;
    TextField apuesta;
    boolean jugando, rondaTerminada;
    int cartera;
    
    public void init() {
        setupApplet();
        cargarImagenes();
        setupJuego();
        setupInterfaz();
    }

    public void paint(Graphics g) {
        noseve.setColor(Color.LIGHT_GRAY);
        noseve.fillRect(0, 0, RESX, RESY);
        manoJugador.paint(noseve, this);
        manoCrupier.paint(noseve, this);
        noseve.setColor(Color.BLACK);
        noseve.setFont(new Font ("Monospaced", Font.BOLD, 32));
        noseve.drawString("Dinero: " + String.valueOf(cartera), RESX-300, 100);
        g.drawImage(imagen, 0, 0, this);
    }

    public void update(Graphics g) {
        paint(g);
    }

    public boolean action(Event ev, Object o){
        if (ev.target instanceof TextField && !jugando){
            repartoInicial();
        }
        if (jugando && !apuesta.isEditable() && ev.target instanceof Button && ev.arg.equals("¡Carta!")){
            manoJugador.añadir(mazo.sacaCarta());
            manoJugador.sumaPuntos();
            if (manoJugador.getPuntos()>21) jugarRonda();
        }
        if (!apuesta.isEditable() && ev.target instanceof Button && ev.arg.equals("¡Me planto!")){
            jugarRonda();
        }
        if(rondaTerminada && ev.target instanceof Button && ev.arg.equals("Otra ronda")){
            nuevaRonda();
        }
        repaint();
        return true;
    }

    public void nuevaRonda() {
        mazo = new Baraja(imgCartas, imgReverso);
        manoJugador= new Mano(false);
        manoCrupier= new Mano(true);
        manoCrupier.setOculta(true);
        apuesta.setEditable(true);
        apuesta.setText("");
        repaint();
    }

    public void repartoInicial() {
        apuesta.setEditable(false);
        for (int i=0; i<2; i++){
            manoJugador.añadir(mazo.sacaCarta());
            manoCrupier.añadir(mazo.sacaCarta());
            manoJugador.sumaPuntos();
            manoCrupier.sumaPuntos();
        }
        jugando = true;
        cartera -= Integer.parseInt(apuesta.getText());
    }

    public void jugarRonda() {
        jugando = false;
        while (manoCrupier.getPuntos()<16){
            manoCrupier.añadir(mazo.sacaCarta());
            manoCrupier.sumaPuntos();
        }
        manoCrupier.setOculta(false);
        rondaTerminada = true;
        if (manoCrupier.getPuntos()>21 && manoJugador.getPuntos()>21 ||manoJugador.getPuntos()==manoCrupier.getPuntos()) 
            cartera += Integer.parseInt(apuesta.getText());
        else {
            if ((manoJugador.getPuntos()<=21 && manoJugador.getPuntos() > manoCrupier.getPuntos())|| manoCrupier.getPuntos()>21 && manoJugador.getPuntos()<=21)
                cartera += 2*Integer.parseInt(apuesta.getText());
        }
    }
    
    public void setupJuego() {
        mazo = new Baraja(imgCartas, imgReverso);
        manoJugador= new Mano(false);
        manoCrupier= new Mano(true);
        manoCrupier.setOculta(true);
        jugando = false;
        rondaTerminada = false;
        cartera = 10000;
    }
    
    public void setupApplet() {
        this.resize(RESX, RESY);
        imagen = this.createImage(RESX, RESY);
        noseve = imagen.getGraphics();
        this.setLayout(new BorderLayout());
    }
    
    public void cargarImagenes() {
        imgCartas = new Image[NUM_PALOS][CPP];
        imgReverso = getImage(getCodeBase(), "E6_Sexto/Cartas/reverso.png");
        for (int i = 0; i < NUM_PALOS; i++) 
            for (int j=0; j<CPP; j++)
            imgCartas[i][j] = getImage(getCodeBase(), "E6_Sexto/Cartas/" + (j + 1) + nombresPalos[i]);
    }
    
    public void setupInterfaz() throws HeadlessException {
        Label etiqueta = new Label("Introduce tu apuesta :", Label.RIGHT);
        apuesta = new TextField("", 10);
        Panel panel1 = new Panel();
        panel1.add(etiqueta);
        panel1.add(apuesta);
        this.add("North", panel1);
        sacaCarta= new Button("¡Carta!");
        plantarse = new Button("¡Me planto!");
        nuevaRonda = new Button("Otra ronda");
        Panel panel2 = new Panel();
        panel2.add(sacaCarta);
        panel2.add(plantarse);
        panel2.add(nuevaRonda);
        this.add("South", panel2);
    }
}