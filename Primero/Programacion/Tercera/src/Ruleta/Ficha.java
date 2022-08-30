
package Ruleta;
import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

public class Ficha extends Rectangle {
    
    public static final int DIM = 65;
    private int valor;
    Image imagen;
    private ArrayList<Integer> numerosApostados;
    
    public Ficha(Image img, int val, int id){
        super(0,0,0,0);
        width = height = DIM;
        x = (Ruleta.RESX-2*DIM-100);
        y = (DIM*id+100+5*id+5);
        valor = val;
        imagen = img;
        numerosApostados = new ArrayList();
    }
    
    public void paint(Graphics g, Applet a){
        g.drawImage(imagen, x, y, width, height, a);
    }
   
    public void update(int x, int y){
        this.x = x-(DIM/2);
        this.y = y-(DIM/2);
    }
    
    public void apuesta(Casilla[][] casillas, Casilla cero, CasillaApuesta[] apuestasMultiples){
        numerosApostados.clear();
        boolean sigueComprobando = true;
        if (sigueComprobando)
            sigueComprobando = apuestasDeCero(cero, casillas, apuestasMultiples);
        if (sigueComprobando)
            sigueComprobando = apuestasMultiplesSimples(apuestasMultiples);
        if (sigueComprobando)
            sigueComprobando = apuestasMultiplesAvanzadasColumnas(apuestasMultiples);
        if (sigueComprobando)
            sigueComprobando = apuestasMultiplesTransversales(apuestasMultiples, casillas);
        if (sigueComprobando)
            sigueComprobando = apuestasMultiplesDocenas(apuestasMultiples);
        if (sigueComprobando)
            apuestasSimplesDoblesCuadruples(casillas);
    }

    private void apuestasSimplesDoblesCuadruples(Casilla[][] casillas) {
        //En caso de que no se realice ninguna apuesta especial, se comprueban las simples, dobles y a 4 números
        for (int i=0; i<casillas.length; i++)
            for (int j=0; j<casillas[i].length; j++)
                if (intersects(casillas[i][j]))
                    numerosApostados.add(1+3*i+j);        
    }

    private boolean apuestasMultiplesDocenas(CasillaApuesta[] apuestasMultiples) {
        boolean continua = true;
        //Apuestas múltiples docenas simples o dobles (a 12 o 24 números)
        if (intersects(apuestasMultiples[CasillaApuesta.DOCENA2])){
            continua = false;
            for (int i=13; i<25; i++)
                numerosApostados.add(i);
            if (intersects(apuestasMultiples[CasillaApuesta.DOCENA1]))
                for (int i=1; i<13; i++)
                    numerosApostados.add(i);
            else if (intersects(apuestasMultiples[CasillaApuesta.DOCENA3]))
                for (int i=25; i<37; i++)
                    numerosApostados.add(i);
        } else if (intersects(apuestasMultiples[CasillaApuesta.DOCENA1])){
            continua = false;
            for (int i=1; i<13; i++)
                numerosApostados.add(i);
        } else if (intersects(apuestasMultiples[CasillaApuesta.DOCENA3])){
            continua = false;
            for (int i=25; i<37; i++)
                numerosApostados.add(i);
        }
        return continua;
    }

    private boolean apuestasMultiplesTransversales(CasillaApuesta[] apuestasMultiples, Casilla[][] casillas) {
        boolean continua = true;
        //Apuestas múltiples transversales (a 3 numeros de una columna o 6 numeros de columnas contiguas)
        if (intersects(apuestasMultiples[CasillaApuesta.DOCENA1])||
                intersects(apuestasMultiples[CasillaApuesta.DOCENA2])||
                intersects(apuestasMultiples[CasillaApuesta.DOCENA3])){
            for (int i=0; i<12; i++)
                if (intersects(casillas[i][0])){
                    for (int j=1; j<=3; j++)
                        numerosApostados.add(i*3+j);
                    continua = false;
                }
        }
        return continua;
    }

    private boolean apuestasMultiplesAvanzadasColumnas(CasillaApuesta[] apuestasMultiples) {
        boolean continua = true;
        //Apuestas múltiples avanzadas de columnas
        if (intersects(apuestasMultiples[CasillaApuesta.COLUMNA2])){
            continua = false;
            for (int i=2; i<37; i+=3)
                numerosApostados.add(i);
            if (intersects(apuestasMultiples[CasillaApuesta.COLUMNA1]))
                for (int i=3; i<37; i+=3)
                    numerosApostados.add(i);
            else if (intersects(apuestasMultiples[CasillaApuesta.COLUMNA3]))
                for (int i=1; i<37; i+=3)
                    numerosApostados.add(i);
        } else if (intersects(apuestasMultiples[CasillaApuesta.COLUMNA1])){
            continua = false;
            for (int i=3; i<37; i+=3)
                numerosApostados.add(i);
        } else if (intersects(apuestasMultiples[CasillaApuesta.COLUMNA3])){
            continua = false;
            for (int i=1; i<37; i+=3)
                numerosApostados.add(i);
        }
        return continua;
    }

    private boolean apuestasMultiplesSimples(CasillaApuesta[] apuestasMultiples) {
        boolean continua = true;
        //Apuestas múltiples simples
        for (int i=0; i<=CasillaApuesta.PASA; i++)
            if ((apuestasMultiples[i]).contains(x+DIM/2, y+DIM/2)){
                numerosApostados = apuestasMultiples[i].getNumerosApostadosSimples();
                continua = false;
            }
        return continua;
    }

    private boolean apuestasDeCero(Casilla cero, Casilla[][] casillas, CasillaApuesta[] apuestasMultiples) {
        boolean continua = true;
        if (cero.intersects(this)){
            continua = false;
            numerosApostados.add(0);
            //Apuesta cuadro (0,1,2,3) Viene de la apuesta transversal (1,2,3) más el 0, formando el cuadro
            if (intersects(casillas[0][0]) && intersects(apuestasMultiples[CasillaApuesta.DOCENA1]))
                for (int i=1; i<4; i++)
                    numerosApostados.add(i);
            //Apuestas transversales (a 3 numeros) incluyendo cero(0,1,2 ||0,2,3)
            if (intersects(casillas[0][1]) && intersects(casillas[0][0])){
                numerosApostados.add(1);
                numerosApostados.add(2);
            }
            if (intersects(casillas[0][1]) && intersects(casillas[0][2])){
                numerosApostados.add(2);
                numerosApostados.add(3);
            }
        }
        return continua;
    }
    
    public int calculoApuesta (int numAle){
        boolean acierto = false;
        for (int i=0; i<numerosApostados.size(); i++){
            if (numerosApostados.get(i) == numAle)
                acierto = true;
        }
        if (acierto) return (36*valor/numerosApostados.size());
        else return 0;
    }

    public ArrayList<Integer> getNumerosApostados() {
        return numerosApostados;
    }
    public void setNumerosApostados(ArrayList<Integer> numerosApostados) {
        this.numerosApostados = numerosApostados;
    }
    public int getValor() {
        return valor;
    }
    
    public void setValor(int valor){
        this.valor = valor;
    }    
}
