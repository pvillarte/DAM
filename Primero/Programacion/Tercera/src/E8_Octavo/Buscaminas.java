
package E8_Octavo;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

public class Buscaminas extends Applet {
    
    
    
    final int DIM = 10;
    Image imgReverso, imgMina;
    public static final int RESX = 600;
    public static final int RESY = 600;
    public static final int NUMMINAS = 10;
    Casilla casillas[][];
    ArrayList<int[]> porRevisar;
    boolean perdedor;
    boolean victoria;
    
    public void init() {
        setupApplet();
        cargarImagenes();
        casillas= new Casilla[DIM][DIM];
        for (int i=0; i<DIM; i++)
            for (int j=0; j<DIM; j++)
                casillas[i][j]= new Casilla(100+(j*Casilla.TAM), 100+(i*Casilla.TAM), imgReverso);
        int aleatorios[] = obtenerAleatorios();
        for (int i=0; i<aleatorios.length; i++)
            casillas[aleatorios[i]/DIM][aleatorios[i]%DIM].setMina(imgMina);
        porRevisar = new ArrayList();
        setNumeros(casillas);
        perdedor=false;
        victoria=false;
    }
    
    public int[] obtenerAleatorios(){
        int[] resultados = new int [DIM];
        int[] vector= new int [DIM*DIM];
        for (int i=0; i<vector.length; i++){
            vector[i] = i;
        }
        for (int i=0; i<resultados.length; i++){
            int aleatorio = (int)(Math.random()*(DIM*DIM-i));
            resultados[i] = vector[aleatorio];
            vector[aleatorio] = vector[DIM*DIM-i-1];
        }
        return resultados;
    }

    public void paint(Graphics g) {
        for (int i=0; i<DIM; i++)
            for (int j=0; j<DIM; j++)
                casillas[i][j].paint(g, this);
        if (perdedor){
            g.setColor(Color.BLACK);
            g.setFont(new Font("Monospaced", Font.BOLD, 90));
            g.drawString("GAME ", 200, 90);
            g.drawString("OVER ", 200, 590);
        }   
        if (victoria){
            g.setColor(Color.BLACK);
            g.setFont(new Font("Monospaced", Font.BOLD, 90));
            g.drawString("GANASTE", 115, 90);
        }    
    }

    public void setupApplet() {
        this.resize(RESX, RESY);
    }
    
    public boolean mouseDown(Event e, int x, int y){
        if (!perdedor && !victoria){
            for (int i=0; i<casillas.length; i++)
                for (int j=0; j<casillas[i].length; j++)
                    if (casillas[i][j].contains(x,y)){              
                        casillas[i][j].setTapada(false);
                        if (casillas[i][j].getAlrededor()==0){
                            for (int k=i-1; k<i+2; k++){
                                if (k<0) k++;
                                if (k>casillas.length-1 || k>i+1) break;
                                for (int l=j-1; l<j+2; l++){
                                    if (l<0) l++;
                                    if (l>casillas.length-1 || l>j+1) break;
                                    if (casillas[k][l].getAlrededor()==0)
                                        porRevisar.add(new int[]{k,l});
                                }
                            }
                        }
                        if (casillas[i][j].getMina()!= null)
                            perdedor=true;
                    }
            destaparAlrededor();
            repaint();
            int aux = 0;
            for (int i=0; i<casillas.length; i++)
                for (int j=0; j<casillas[i].length; j++)
                    if (!casillas[i][j].isTapada())
                        aux++;
            if (aux >= DIM*DIM-NUMMINAS)
                victoria=true;
                    
        }
        return true;
    }
    
    public void destaparAlrededor(){
        for (int a=0; a<porRevisar.size(); a++){
            int i = porRevisar.get(a)[0];
            int j = porRevisar.get(a)[1];
            for (int k=i-1; k<i+2; k++){
                if (k<0) k++;
                if (k>casillas.length-1 || k>i+1) break;
                for (int l=j-1; l<j+2; l++){
                    if (l<0) l++;
                    if (l>casillas.length-1 || l>j+1) break;
                    if (casillas[k][l].isTapada()){
                        if (casillas[k][l].getAlrededor()==0)
                            porRevisar.add(new int[]{k,l});
                        else if (casillas[k][l].getMina()==null)
                            casillas[k][l].setTapada(false);
                    }
                    
                }
            }
            casillas[i][j].setTapada(false);
        }
        porRevisar.clear();
    }
    
    
    public void cargarImagenes() {
        imgReverso = getImage(getCodeBase(), "E8_Octavo/Imagenes/casilla.png");
        imgMina = getImage(getCodeBase(), "E8_Octavo/Imagenes/mina.png");
    }
    
    public void setNumeros(Casilla[][] celdas){
        for (int i=0; i<celdas.length; i++){
            for (int j=0; j<celdas[i].length; j++){
                celdas[i][j].setAlrededor(celdas[i][j].casillasAlrededor(i, j, celdas));
            }
        }  
    }
}