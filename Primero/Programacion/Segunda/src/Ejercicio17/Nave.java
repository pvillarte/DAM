
package Ejercicio17;
import java.awt.*;
import java.util.List;

public class Nave extends Rectangle{
    
    public Nave(){
        super(300, 800, 60, 60);
    }
    
    public boolean update(List<Marciano> m){
        for (int i=0; i<m.size(); i++)
            if (this.intersects(m.get(i)))
                return true;
        return false;
    }
}
