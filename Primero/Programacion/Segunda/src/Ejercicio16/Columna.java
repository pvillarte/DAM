package Ejercicio16;
import java.awt.*;

public class Columna {
    private Rectangle r1;
    private Rectangle r2;
    int altura;
    
    public Columna(){
        altura = (int) (150*Math.random()+50);
        r1= new Rectangle(600, 0, 30, altura);
        r2= new Rectangle(600, altura+50, 30, 300-altura+50);
    }
        public void dibujar (Graphics g){
        g.setColor(Color.RED);
        g.fillRect(getR1().x, getR1().y, getR1().width, getR1().height);
        g.fillRect(getR2().x, getR2().y, getR2().width, getR2().height);
    }
        
    public void update(){
        r1.x -=1;
        r2.x -=1;
    }

    public Rectangle getR1() {
        return r1;
    }
    public void setR1(Rectangle r1) {
        this.r1 = r1;
    }
    public Rectangle getR2() {
        return r2;
    }
    public void setR2(Rectangle r2) {
        this.r2 = r2;
    }
    
}
