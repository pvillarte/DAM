
package E5_Quinto;
import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

public class Ficha extends Rectangle {
    
    public static final int DIM = 65;
    private int valor;
    Image imagen;
    private ArrayList<Integer> numerosApostados;
    
    public Ficha(Image img, int val, int id){
        super(0,0,0,0);
        width = height = DIM;
        x = (Ruleta.RESX-2*DIM-100);
        y = (DIM*id+100+5*id+5);
        valor = val;
        imagen = img;
        numerosApostados = new ArrayList();
    }
    
    public void paint(Graphics g, Applet a){
        g.drawImage(imagen, x, y, width, height, a);
    }
   
    public void update(int x, int y){
        this.x = x-(DIM/2);
        this.y = y-(DIM/2);
    }
    
    public void apuesta(Casilla[][] casillas, Casilla cero, CasillaApuesta[] apuestas){
        numerosApostados.clear();
        for (int i=0; i<casillas.length; i++)
            for (int j=0; j<casillas[i].length; j++)
                if (intersects(casillas[i][j]))
                    numerosApostados.add(1+i+(j*3));
        if (cero.contains(this.x+DIM/2, this.y+DIM/2)) numerosApostados.add(0);
        for (int i=0; i<apuestas.length; i++)
            if ((apuestas[i]).contains(x+DIM/2, y+DIM/2)){
                numerosApostados = apuestas[i].getNumerosApostados();
            }             
    }
    
    public int calculoApuesta (int numAle){
        boolean acierto = false;
        for (int i=0; i<numerosApostados.size(); i++){
            if (numerosApostados.get(i) == numAle)
                acierto = true;
        }
        if (acierto) return (36*valor/numerosApostados.size());
        else return 0;
    }

    public ArrayList<Integer> getNumerosApostados() {
        return numerosApostados;
    }
    public void setNumerosApostados(ArrayList<Integer> numerosApostados) {
        this.numerosApostados = numerosApostados;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }    
}
