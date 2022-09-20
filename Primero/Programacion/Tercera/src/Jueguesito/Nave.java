
package Jueguesito;
import java.awt.*;

public class Nave extends Rectangle {
    
    final double VEL = 4;
    private boolean N, E, S, O;
    double xReal, yReal;
    private boolean disparoActivo, disparando;
    int xCentro, yCentro, dimension;
    private int delay;
    final int FIRERATE = 10; 
    
    public Nave(){
        super(500, 500, 0, 0);
        dimension = 50;
        width = height = dimension; 
        N = false; 
        E = false;  
        S = false;  
        O = false;
        xReal=x;
        yReal=y;
        delay = 0;
    }
    
    public void paint(Graphics g){
        g.setColor(Color.BLUE);
        g.fillOval(x, y, width, height);
    }
    
    public void update(){
        movement();
        xCentro = x+dimension/2;
        yCentro = y+dimension/2;
        delay++;
        if (delay == FIRERATE){
            disparoActivo = true;
            delay=0;
        }
    }
    
    public void movement() {
        if((N && !E && !S && !O)||(N && E && !S && O))
            yReal -= VEL;
        if((!N && !E && S && !O)||(!N && E && S && O))
            yReal += VEL;
        if((!N && !E && !S && O)||(N && !E && S && O))
            xReal -= VEL;
        if((!N && E && !S && !O)||(N && E && S && !O))
            xReal += VEL;
        if(N && E && !S && !O){
            yReal -= VEL*(Math.sqrt(2)/2);
            xReal += VEL*(Math.sqrt(2)/2);
        }
        if(N && !E && !S && O){
            yReal -= VEL*(Math.sqrt(2)/2);
            xReal -= VEL*(Math.sqrt(2)/2);
        }
        if(!N && E && S && !O){
            yReal += VEL*(Math.sqrt(2)/2);
            xReal += VEL*(Math.sqrt(2)/2);
        }
        if(!N && !E && S && O){
            yReal += VEL*(Math.sqrt(2)/2);
            xReal -= VEL*(Math.sqrt(2)/2);
        }
        
        x = (int)(xReal);
        y = (int)(yReal);
    }
    public boolean isN() {
        return N;
    }
    public void setN(boolean N) {
        this.N = N;
    }
    public boolean isE() {
        return E;
    }
    public void setE(boolean E) {
        this.E = E;
    }
    public boolean isS() {
        return S;
    }
    public void setS(boolean S) {
        this.S = S;
    }
    public boolean isO() {
        return O;
    }
    public void setO(boolean O) {
        this.O = O;
    }
    public boolean isDisparoActivo() {
        return disparoActivo;
    }
    public void setDisparoActivo(boolean activa) {
        this.disparoActivo = activa;
    }
    public boolean isDisparando() {
        return disparando;
    }
    public void setDisparando(boolean disparando) {
        this.disparando = disparando;
    }
    public int getDelay() {
        return delay;
    }
    public void setDelay(int delay) {
        this.delay = delay;
    }
    
}
