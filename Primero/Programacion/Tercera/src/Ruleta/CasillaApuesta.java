
package Ruleta;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

public class CasillaApuesta extends Rectangle {
    
    static final int ROJO = 0;
    static final int NEGRO = 1;
    static final int PAR = 2;
    static final int IMPAR = 3;
    static final int FALTA = 4;
    static final int PASA = 5;
    static final int DOCENA1 = 6;
    static final int DOCENA2= 7;
    static final int DOCENA3 = 8;
    static final int COLUMNA1 = 9;
    static final int COLUMNA2 = 10;
    static final int COLUMNA3 = 11;
    static final String[] TIPOSTRING = {"Rojo", "Negro", "Par", "Impar", "Falta", "Pasa",
        "1ª Docena", "2ª Docena", "3ª Docena", "C1", "C2", "C3"}; 
    final int TIPO;
    final int[] rojos={1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 26, 27, 30, 32, 34, 36};
    public static ArrayList<Integer> listaRojos;
    
    public CasillaApuesta(Casilla[][] casillas, int tipo){
        super(0, 0, 0, 0);
        this.TIPO = tipo;
        height=Casilla.DIM;
        width = (6>this.TIPO)?(2*Casilla.DIM):((9>this.TIPO)?(4*Casilla.DIM):(Casilla.DIM));
        setupPosicionCasillas(tipo, casillas);
        listaRojos = new ArrayList();
        for (int i=0; i<rojos.length; i++)
            listaRojos.add(rojos[i]);
    }

    public CasillaApuesta(int i, int i0, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<Integer> getNumerosApostadosSimples(){
        ArrayList apostados = new ArrayList();
        apostados.clear();
        switch(TIPO){
            case ROJO:
                for (int i=0; i<rojos.length; i++)
                    apostados.add(rojos[i]);
                break;
            case NEGRO:
                for (int i=1; i<37; i++)
                    if (!listaRojos.contains(i)) apostados.add(i);
                break;
            case PAR:
                for (int i=2; i<37; i+=2)
                    apostados.add(i);
                break;
            case IMPAR:
                for (int i=1; i<37; i+=2)
                    apostados.add(i);
                break;
            case FALTA:
                for (int i=1; i<19; i++)
                    apostados.add(i);
                break;
            case PASA:
                for (int i=19; i<37; i++)
                    apostados.add(i);
                break;
        }
        return apostados;
    }
    
    public void paint(Graphics g, Applet a){
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
        g.setFont(new Font ("Monospaced", Font.BOLD, 42));
        g.drawString(TIPOSTRING[TIPO], x+10, y+40);
    }

    private void setupPosicionCasillas(int tipo1, Casilla[][] casillas) {
        switch (tipo1) {
            case ROJO:
                x = casillas[6][0].x;
                y = casillas[6][0].y+2*Casilla.DIM;
                break;
            case NEGRO:
                x = casillas[4][0].x;
                y = casillas[4][0].y+2*Casilla.DIM;
                break;
            case PAR:
                x = casillas[2][0].x;
                y = casillas[2][0].y+2*Casilla.DIM;
                break;
            case IMPAR:
                x = casillas[8][0].x;
                y = casillas[8][0].y+2*Casilla.DIM;
                break;
            case FALTA:
                x = casillas[0][0].x;
                y = casillas[0][0].y+2*Casilla.DIM;
                break;
            case PASA:
                x = casillas[10][0].x;
                y = casillas[10][0].y+2*Casilla.DIM;
                break;
            case DOCENA1:
                x = casillas[0][0].x;
                y = casillas[0][0].y+Casilla.DIM;
                break;
            case DOCENA2:
                x = casillas[4][0].x;
                y = casillas[4][0].y+Casilla.DIM;
                break;
            case DOCENA3:
                x = casillas[8][0].x;
                y = casillas[8][0].y+Casilla.DIM;
                break;
            case COLUMNA1:
                x = casillas[11][2].x+Casilla.DIM;
                y = casillas[11][2].y;
                break;
            case COLUMNA2:
                x = casillas[11][1].x+Casilla.DIM;
                y = casillas[11][1].y;
                break;
            case COLUMNA3:
                x = casillas[11][0].x+Casilla.DIM;
                y = casillas[11][0].y;
                break;
        }
    }
}
