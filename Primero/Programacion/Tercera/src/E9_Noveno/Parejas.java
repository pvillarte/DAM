
package E9_Noveno;

import java.applet.Applet;
import java.awt.*;

public class Parejas extends Applet implements Runnable{
    
    Image imgReverso;
    Image[] imagenes;
    Donut[][] donuts;
    int contador, temporal;
    Donut c1, c2;
    Thread animacion;
    
    public void init (){
        this.resize(900, 700);
        imgReverso = getImage(getCodeBase(), "E9_Noveno/donutsMatch/reverso.png");
        imagenes = new Image[8];
        for (int i=1; i<=8; i++)
            imagenes[i-1] = getImage(getCodeBase(), "E9_Noveno/donutsMatch/img"+i+".png");
        donuts = new Donut[4][4];
        for (int i=0; i<4; i++)
            for (int j=0; j<4; j++)
                donuts[i][j]= new Donut(i*Donut.DIM, j*Donut.DIM, imgReverso, imagenes[((i*4)+j)%8]);
        desordenar(donuts);
        contador=0;
    }
    
    public void start(){
        animacion = new Thread();
        animacion.start();
    }
    
    public void paint (Graphics g){
        for (int i=0; i<donuts.length; i++)
            for (int j=0; j<donuts[i].length; j++)
                donuts[i][j].paint(g, this);
    }
    
    public void desordenar(Donut[][]d){
        Image aux;
        int aleatorio, aleatorio2;
        for(int i = 0; i<d.length; i++){
            for (int j = 0; j<d[i].length; j++){
                aleatorio = (int) (Math.random()*d.length);
                aleatorio2 = (int) (Math.random()*d[i].length);
                aux = d[i][j].getImagen();
                d[i][j].setImagen(d[aleatorio][aleatorio2].getImagen());
                d[aleatorio][aleatorio2].setImagen(aux);
            }
        }
    }
    
    public boolean mouseDown(Event ev, int x, int y){
        for (int i=0; i<donuts.length; i++)
            for (int j=0; j<donuts[i].length; j++)
                if (donuts[i][j].contains(x,y)){
                    if (!donuts[i][j].isDescubierta()){
                        donuts[i][j].setDescubierta(true);
                        switch (getNumDescubiertas()){
                            case 0:
                                c1=donuts[i][j];
                                break;
                            case 1:
                                c2=donuts[i][j];
                                if (c1.getImagen()==c2.getImagen()){
                                    c1=c2=null;
                                }else{
                                    temporal = contador;
                                }                               
                        }
                    } else {
                        donuts[i][j].setDescubierta(false);
                    }
                }
        repaint();
        return true;
    }

    public void run() {
        do{
            contador++;
            if(contador-temporal == 3){
                c1.setDescubierta(false);
                c2.setDescubierta(false);
                c1=c2=null;
                repaint();
            }
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){};
        }while(true);
    }   
    
    public int getNumDescubiertas(){
        int num=0;
        if (c1 != null) num++;
        if (c2 != null) num++;
        return num;
    }
}
