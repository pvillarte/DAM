package Ejercicio05;

import java.awt.*;          //Método 1 para importar(preferible)
import java.util.Random;

public class Ovalo {
    //java.awt.Color color;            Método 2 para importar
    int posX, posY, anchura, altura;
    Color color;
    Random r;
    
    public Ovalo(){
        r= new Random();
        inicializarValores();
    }

    public void inicializarValores() {
        posX=r.nextInt(200);
        posY=r.nextInt(200);
        altura=r.nextInt(400);
        anchura=r.nextInt(400);
        color=new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
    }
    
    public void dibujar(Graphics g){
        g.setColor(color);
        g.fillOval(posX, posY, anchura, altura);
    };
}
