
package E3_Tercero;
import java.applet.Applet;
import java.awt.*;
import java.util.List;

public class Flecha extends Rectangle{ 
    
    Image imagen;
    
    public Flecha (Image img, int y){
        super(70, y-35, 120, 80);
        imagen=img;
    }
    
    public void paint(Graphics g, Applet a){
        g.drawImage(imagen, x, y, width, height, a);
    }
    
    public int update (List<Globo> globos){
        x += 10;
        for (int i=0; i<globos.size(); i++)
            if (this.intersects(globos.get(i))) {
                int p = globos.get(i).getDaño();
                globos.remove(i);
                return p;
            }
        return 0;
    }
}
