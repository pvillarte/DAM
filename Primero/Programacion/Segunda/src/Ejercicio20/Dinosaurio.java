
package Ejercicio20;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Dinosaurio extends Rectangle{
    
    private boolean saltando=false;
    int contadorSalto=0;
    private int vidas=2;
    private Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    
    public Dinosaurio(){
        super(10, Juego.RESY-100, 30, 50);
        color = Color.green;
    }
    
    public void update(){
        color=(vidas==2)?(Color.GREEN):(Color.RED);
        if (y<Juego.RESY-100)  y += 2;
            salto();
    }
    
    public boolean collision(Cactus primerCactus){
        if (this.intersects(primerCactus))
            return true;
        return false;
    }
    
    public void salto(){
        if(isSaltando()){ 
            y -= 6;
            contadorSalto++; 
        }
        if(contadorSalto==30){
            setSaltando(false);
            contadorSalto=0;  
        }
    }
    
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    
    public boolean isSaltando() {
        return saltando;
    }
    public void setSaltando(boolean estaSaltando) {
        this.saltando = estaSaltando;
    }
    
    public int getVidas() {
        return vidas;
    }
    public void restaVidas() {
        this.vidas--;
    }
    public void restauraVidas() {
        this.vidas++;
    }
    
}
