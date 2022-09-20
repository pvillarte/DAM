
package E8_Octavo;

import java.applet.Applet;
import java.awt.*;

public class Casilla extends Rectangle{
    
    public static final int TAM = 40;
    private Image mina;
    private Image reverso;
    private boolean tapada;
    private int alrededor;
    
    public Casilla(int posX, int posY, Image rev){
        super(posX, posY, TAM, TAM);
        mina = null;
        reverso = rev;
        tapada = true;
        alrededor = 0;
    }
    
    public int casillasAlrededor(int x, int y, Casilla[][] celdas){
        int aux = 0;
        for (int i=x-1; i<=x+1; i++){
            if (i<0) i++;
            if (i>celdas.length-1  || i>x+1) break;
            for (int j=y-1; j<=y+1; j++){
                if (j<0) j++;
                if (j>celdas[i].length-1 || j>y+1) break;
                if (celdas[i][j].getMina()!=null)
                    aux++;
            }
        }
        return aux;
    }
    
    public void paint (Graphics g, Applet a){
        g.drawImage(mina, x, y, TAM, TAM, a);
        if (tapada){
            g.drawImage(reverso, x, y, TAM, TAM, a);
        }
        if (!tapada && alrededor != 0 && mina == null){
            g.setColor((alrededor==1)?(Color.green):((alrededor==2)?(Color.yellow):((alrededor==3)?(Color.orange):(Color.RED))));
            g.setFont(new Font("Monospaced", Font.BOLD, 50));
            g.drawString(String.valueOf(alrededor), x+5, y+Casilla.TAM-5);
        }
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
    }
    
    public Image getMina() {
        return mina;
    }
    public void setMina(Image mina) {
        this.mina = mina;
    }
    public Image getReverso() {
        return reverso;
    }
    public void setReverso(Image reverso) {
        this.reverso = reverso;
    }
    public boolean isTapada() {
        return tapada;
    }
    public void setTapada(boolean tapada) {
        this.tapada = tapada;
    }
    public int getAlrededor() {
        return alrededor;
    }
    public void setAlrededor(int alrededor) {
        this.alrededor = alrededor;
    }
    
}
