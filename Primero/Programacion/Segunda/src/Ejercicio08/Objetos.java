
package Ejercicio08;
import java.awt.*;

public class Objetos extends Frame {
    TextArea textArea;
    
    public Objetos(){
        super("Trabajando con objetos de Java");
        setup();
        resize(400, 400);
        show();
    }
    
    public static void main(String[] args) {
        Objetos app = new Objetos();
    }
    
    public void setup (){
        Panel principal = new Panel();
        principal.setLayout(new GridLayout(2,3));
        Panel paneles[][] = new Panel[2][3];
        for (int i=0; i<paneles.length; i++)
            for (int j=0; j<paneles[i].length; j++)
                paneles[i][j]= new Panel();
        
        paneles[0][0].add(new Label("Campo de testo: "));
        paneles[0][0].add(new MiTextField("", 15));
        principal.add(paneles[0][0]);
        
        textArea= new TextArea(5, 10);
        textArea.setBackground(Color.yellow);
        paneles[0][1].add(textArea);
        principal.add(paneles[0][1]);
        
        /*Choice eleccion = new Choice();
        eleccion.add("Uno");
        eleccion.add("Dos");*/
        String[]opciones = {"Uno", "Dos", "Tres"};
        MiChoice selector = new MiChoice(opciones, textArea);
        paneles[0][2].add(selector);
        principal.add(paneles[0][2]);
        
        String[] deportes= {"Futbol", "Balonmano", "Baloncesto", "Tenis", "Esgrima", "Patinaje"};
        MiLista listaDeportes= new MiLista(deportes, textArea);
        paneles[1][1].add(listaDeportes);
        principal.add(paneles[1][1]);
        
        Canvas lienzo;
        paneles[1][2].add(new MiCanvas());
        principal.add(paneles[1][2]);
        
        this.add(principal);
    }
    
    public boolean handleEvent(Event ev){        
        if (ev.id == Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
        } 
        return false;
    }
}

class MiTextField extends TextField {
    public MiTextField(String textoInicial, int tamaño){
        super(textoInicial, tamaño);
    }
    
    public boolean action(Event ev, Object ob){
        this.setText(this.getText().toUpperCase());
        return true;
    }
}

class MiChoice extends Choice {
    TextArea texto;
    public MiChoice(String[] opciones, TextArea txt){
        super();
        texto=txt;
        for (int i=0; i<opciones.length; i++)
            this.add(opciones[i]);
    }
    public boolean action(Event ev, Object ob){
        texto.setText(this.getSelectedItem());
        return true;
    }

}

class MiLista extends List {
    TextArea texto;
    public MiLista(String[] lista, TextArea txt){
        super(5, true);
        texto=txt;
        for (int i=0; i<lista.length; i++){
            this.add(lista[i]);
        }
    }
    
    public boolean handleEvent(Event ev){
        if (ev.id == Event.ACTION_EVENT){
            texto.setText("Doble click");
            return true;
        } else if (ev.id == Event.LIST_SELECT){
            //texto.setText("Selección");
            String[] seleccionados = this.getSelectedItems();
            String textoACargar = "";
            for (int i=0; i<seleccionados.length; i++)
                textoACargar += seleccionados[i]+"\n";
            texto.setText(textoACargar);
            return true;
        } else if (ev.id == Event.LIST_DESELECT){
            //texto.setText("Deselección");
            String[] seleccionados = this.getSelectedItems();
            String textoACargar = "";
            for (int i=0; i<seleccionados.length; i++)
                textoACargar += seleccionados[i]+"\n";
            texto.setText(textoACargar);
            return true;
        }
        return false;
    }
}

class MiCanvas extends Canvas{
    int posX = 20;
    int posY = 20;
    public MiCanvas(){
        super();
        this.resize(75,75);
        this.setBackground(Color.YELLOW);
        this.setForeground(Color.RED);
        this.show();
    }
    public void paint(Graphics g){
        g.fillRect(posX, posY, 5, 5);
    }
    public boolean mouseDown(Event ev, int posEjeX, int posEjeY){
        posX = posEjeX;
        posY = posEjeY;
        repaint();
        return true;
    }
}

