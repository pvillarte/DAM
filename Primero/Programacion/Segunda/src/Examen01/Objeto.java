package Examen01;

import java.awt.*;

public class Objeto extends Rectangle{
    
    private int velX;
    private int velY;
    Color color;
    final Color[] COLORES={Color.BLUE, Color.CYAN, Color.GRAY, Color.MAGENTA,
        Color.ORANGE, Color.PINK, Color.YELLOW, Color.RED, Color.GREEN};
    public static final int CUADRADO=0;
    public static final int RECTANGULO=1;
    public static final int OVALO=2;
    public static final int CIRCULO=3;
    int forma; 
    private int delayVelExtra=2000;
    private boolean sprintando=false;
    
    
    public Objeto(){
        super((int)(Math.random()*(Examen01.RESX-40)), (int)(Math.random()*(Examen01.RESY-40)), 0, 0);
        color = COLORES[(int)(Math.random()*COLORES.length)];
        velX=(int)(3-Math.random()*7);
        velY=(int)(3-Math.random()*7);
        if(velX==0) velX++;
        if(velY==0) velY++;
        forma = (int)(Math.random()*4);
        
        if (forma == CUADRADO || forma == CIRCULO){
            width = height = (int)(Math.random()*30)+10;
        }else{
            width = (int)(Math.random()*30)+10;
            height = (int)(Math.random()*30)+10;
        }
    }
    
    public void paint (Graphics g){
        g.setColor(color);
        if (forma==CIRCULO || forma == OVALO)
            g.fillOval(x, y, width, height);
        else
            g.fillRect(x, y, width, height);
    }
    
    public void update (){
        if (isSprintando()){
            x += (3*velX);
            y += (3*velY);
        } else {
            x += velX;
            y += velY;
        }
        if(x<0) velX = Math.abs(velX);
        if(x>Examen01.RESX-width) velX = -Math.abs(velX);
        if(y<0) velY = Math.abs(velY);
        if(y>Examen01.RESY-height) velY = -Math.abs(velY);
    }
    
    public int getVelX() {
        return velX;
    }
    public void setVelX(int velX) {
        this.velX = velX;
    }
    public int getVelY() {
        return velY;
    }
    public void setVelY(int velY) {
        this.velY = velY;
    }
    public int getDelayVelExtra() {
        return delayVelExtra;
    }
    public void setDelayVelExtra(int delayVelocidadExtra) {
        this.delayVelExtra = delayVelocidadExtra;
    }
    public boolean isSprintando() {
        return sprintando;
    }
    public void setSprintando(boolean sprintando) {
        this.sprintando = sprintando;
    }
}
