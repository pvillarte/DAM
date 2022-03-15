
package Ejercicio12;

import java.awt.*;

public class Rectangulo {
    public static final int ARRIBA = 0;
    public static final int DERECHA = 1;
    public static final int ABAJO = 2;
    public static final int IZQUIERDA = 3;
    int posX, posY, anchura, altura, direccion, posInicialX, posInicialY,
        posFinalX, posFinalY;
    Color color;
    
    public Rectangulo(int x, int y, int anc, int alt, Color color) {
        posX=x;
        posY=y;
        posInicialX=x;
        posInicialY=y;
        posFinalX=x+20;
        posFinalY=y+20;
        anchura=anc;
        altura=alt;
        this.color=color;
        direccion=DERECHA;
    }
    
    public void dibujar (Graphics g){
        g.setColor(color);
        g.fillRect(posX, posY, anchura, altura);
    }
    
    public void actualizar() {
        switch(direccion){
            case ARRIBA:
                posY--;
                if(posY<=posInicialY)
                    direccion = DERECHA;
                break;
            case DERECHA:
                posX++;
                if(posX>=posFinalX)
                    direccion = ABAJO;
                break;
            case ABAJO:
                posY++;
                if(posY>=posFinalY)
                    direccion = IZQUIERDA;
                break;
            case IZQUIERDA:
                posX--;
                if(posX<=posInicialX)
                    direccion = ARRIBA;
        }
    }
}
