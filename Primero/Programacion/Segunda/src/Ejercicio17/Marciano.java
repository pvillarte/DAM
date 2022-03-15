
package Ejercicio17;

import java.awt.*;

public class Marciano extends Rectangle{
    int velY=1;
    int velX=0;
    double aleatorio;
    int idColor;
    
    public Marciano(){
        super((int)((SpaceInvaders.RESX-90)*Math.random()+45), -30, 40, 40);  //Dejo algo de margen para que no se pegue al lateral
        idColor=velY;
    }
        
    public void update(){
        y += velY;
        x += velX;
        aleatorio= Math.random();
        if (aleatorio>0.262 && aleatorio<0.27 && velY<4){
            velY++;
        }
        if (aleatorio>0.27 && aleatorio<0.275 && velY>0){
            velY--;
        }
        if (aleatorio>0.285 && aleatorio<0.29 && velX<3){
            velX++;
        }
        if (aleatorio>0.295 && aleatorio<0.300 && velX>-3){
            velX--;
        }
        if (aleatorio>0.23 && aleatorio<0.24)
            velX *=-1;
        
        idColor=velY;
        
        if (x<10) x=10;                                 //Dejo algo de margen para que no se pegue al lateral 
        if (x>SpaceInvaders.RESX-width-10) x= SpaceInvaders.RESX-width-10;   //Dejo algo de margen para que no se pegue al lateral
        }
}
