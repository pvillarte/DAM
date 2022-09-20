
package Ejercicio10;
import java.awt.*;
public class DosPuntos {
    public static final int LINEA = 0;
    public static final int OVALO = 1;
    public static final int RECTANGULO = 2;
    private int tipo;
    private int inicioX, inicioY, finX, finY;
    
    public DosPuntos(int iniX, int iniY, int finX, int finY, int tipo){
        inicioX = iniX;
        inicioY = iniY;
        this.finX = finX;
        this.finY = finY;
        this.tipo = tipo;
    }
    
    public DosPuntos(int iniX, int iniY, int tipo){
        this(iniX, iniY, iniX, iniY, tipo);
    }
    
    public DosPuntos(){
        this(0, 0, LINEA);
    }
    
    public void dibujar(Graphics g){
        int anchura, altura;
        anchura = Math.abs(finX-inicioX);
        altura = Math.abs(finY-inicioY);
        g.setColor(Color.BLUE);
        switch(tipo){
            case LINEA:
                g.drawLine(inicioX, inicioY, finX, finY);
                break;
            case OVALO:
                g.drawOval(inicioX, inicioY, anchura, altura);
                break;
            case RECTANGULO:
                g.drawRect(inicioX, inicioY, anchura, altura);
        }
    }

    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public int getInicioX() {
        return inicioX;
    }
    public void setInicioX(int inicioX) {
        this.inicioX = inicioX;
    }
    public int getInicioY() {
        return inicioY;
    }
    public void setInicioY(int inicioY) {
        this.inicioY = inicioY;
    }
    public int getFinX() {
        return finX;
    }
    public void setFinX(int finX) {
        this.finX = finX;
    }
    public int getFinY() {
        return finY;
    }
    public void setFinY(int finY) {
        this.finY = finY;
    }
}
