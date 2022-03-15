package Examen03;
import java.awt.*;

public class Examen03 extends Frame {
    
    final String [] COMUNIDADES = {"Aragón", "Cataluña", "Extremadura"};
    final String[][] PROVINCIAS = {{"Zaragoza", "Huesca", "Teruel"}, 
        {"Barcelona", "Tarragona", "Gerona", "Lérida"},{"Caceres", "Badajoz"}};
    int mostrar=0;
    Choice selectorComunidades;
    MiChoice selectorProvincias;
    
    public Examen03(){
        super("Ejercicio03");
        selectorComunidades= new Choice();
        for (int i=0; i< COMUNIDADES.length; i++)
            selectorComunidades.add(COMUNIDADES[i]);
        selectorProvincias= new MiChoice(mostrar);
        this.add("West", selectorComunidades);
        this.add("East", selectorProvincias);
        resize(400, 400);
        show();
    }
    
    public static void main(String[] args) {
        Examen03 app = new Examen03();
    }
    
    class MiChoice extends Choice {
        public MiChoice(int numComunidad){
            super();
            for (int i=0; i<PROVINCIAS[numComunidad].length; i++)
                this.add(PROVINCIAS[numComunidad][i]);
        }
    }
    
    public boolean handleEvent(Event ev){        
        if (ev.id == Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
        }
        if (ev.target instanceof Choice && ev.target.equals(selectorComunidades)){
            if (ev.id == Event.ACTION_EVENT){
                selectorProvincias.removeAll();
                mostrar = selectorComunidades.getSelectedIndex();
                for (int i=0; i<PROVINCIAS[mostrar].length; i++)
                    selectorProvincias.add(PROVINCIAS[mostrar][i]);
            }
            return true;
        }
        return false;
    }
}
