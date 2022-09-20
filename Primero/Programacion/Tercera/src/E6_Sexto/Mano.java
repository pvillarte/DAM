package E6_Sexto;

import java.applet.Applet;
import java.util.ArrayList;
import java.awt.*;

public class Mano {

    ArrayList<Carta> cartas;
    private boolean oculta;
    private int puntos, numAses;
    boolean crupier;
    
    public Mano(boolean crupier){
        cartas = new ArrayList();
        oculta = false;
        this.crupier = crupier;
        puntos = 0;
        numAses = 0;
    }
    
    public void añadir(Carta robada){
        cartas.add(robada);
        if(robada.getValor()==1) numAses++;
    }
    
    public void paint (Graphics g, Applet a){
        if (crupier){
            for (int i=0; i<cartas.size(); i++){
                cartas.get(i).setPosX(i*(Carta.ANCHURA/4)+50);
                cartas.get(i).setPosY(60);
                if(i==0)
                    g.drawImage(cartas.get(i).imagen, cartas.get(i).getPosX(), cartas.get(i).getPosY(), Carta.ANCHURA, Carta.ALTURA, a);
                else
                    g.drawImage((oculta)?(cartas.get(i).reverso):(cartas.get(i).imagen),
                            cartas.get(i).getPosX(), cartas.get(i).getPosY(), Carta.ANCHURA, Carta.ALTURA, a);
            }
        } else {
            for (int i=0; i<cartas.size(); i++){
                cartas.get(i).setPosX(i*(Carta.ANCHURA/4)+50);
                cartas.get(i).setPosY(Carta.ALTURA+120);
                g.drawImage(cartas.get(i).imagen, cartas.get(i).getPosX(), cartas.get(i).getPosY(), Carta.ANCHURA, Carta.ALTURA, a);
            }
        }
        if (cartas.size()>0){
            g.setFont(new Font("Monospaced", Font.BOLD, 32));
            g.setColor(Color.BLACK);
            if(oculta){
                g.drawString("Puntos : ???", 
                    cartas.get(cartas.size()-1).getPosX()+Carta.ANCHURA+40, 
                    cartas.get(cartas.size()-1).getPosY()+40);
            } else {
                g.drawString("Puntos :"+String.valueOf(getPuntos()), 
                    cartas.get(cartas.size()-1).getPosX()+Carta.ANCHURA+40, 
                    cartas.get(cartas.size()-1).getPosY()+40);
            }
        }
    }
    
    public void sumaPuntos(){
        int aux = numAses;
        puntos = 0;
        for (int i=0; i< cartas.size(); i++)
            puntos += cartas.get(i).getPuntos();
        while (puntos > 21 && aux>0){
            puntos -= 10;
            aux--;
        }
    }
    
    public boolean isOculta() {
        return oculta;
    }
    public void setOculta(boolean oculta) {
        this.oculta = oculta;
    }
    public int getPuntos() {
        return puntos;
    }
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
}
