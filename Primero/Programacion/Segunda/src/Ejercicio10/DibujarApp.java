package Ejercicio10;
import java.awt.*;

public class DibujarApp extends Frame{
    MiCanvas canvas;
    
    public static void main(String[] args) {
        DibujarApp app = new DibujarApp();
    }
    
    public DibujarApp() {
        super("Trabajando con objetos de Java");
        setup();
        pack();
        resize(400, 400);
        show();
    }
    
    public void setup(){
        setupMenu();
        canvas = new MiCanvas();
        add("Center", canvas);
    }

    public void setupMenu() throws HeadlessException {
        MenuBar menuBar = new MenuBar();
        Menu menu1 = new Menu("Fichero");
        menu1.add(new MenuItem("Nuevo"));
        menu1.addSeparator();
        menu1.add(new MenuItem("Salir"));
        menuBar.add(menu1);
        Menu menu2 = new Menu("Dibujar");
        menu2.add(new MenuItem("Línea"));
        menu2.add(new MenuItem("Óvalo"));
        menu2.add(new MenuItem("Rectángulo"));
        menuBar.add(menu2);
        this.setMenuBar(menuBar);
    }
    
    public boolean handleEvent(Event ev){        
        if (ev.id == Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
        } else if (ev.id== Event.ACTION_EVENT){
            if(ev.target instanceof MenuItem){
                if(ev.arg.equals("Salir")){
                    System.exit(0);
                    return true;
                } else if (ev.arg.equals("Línea")){
                    canvas.setTipo(DosPuntos.LINEA);
                    return true;
                } else if (ev.arg.equals("Óvalo")){
                    canvas.setTipo(DosPuntos.OVALO);
                    return true;
                } else if (ev.arg.equals("Rectángulo")){
                    canvas.setTipo(DosPuntos.RECTANGULO);
                    return true;
                }
            } 
        } 
        return false;
    }
}
