package Ejercicio05;

import java.awt.*;

public class OvaloApp extends Frame{
    
    static Ovalo ovalo;
    
    public static void main(String[] args) {
        OvaloApp app= new OvaloApp();
    }
    
    public OvaloApp(){
        super("Dibujando óvalos");
        ovalo = new Ovalo();
        Button boton1 = new Button("Siguiente");
        Button boton2 = new Button("Salir");
        Panel panel = new Panel(); //Caja en la que meter varios objetos(Tipo linear layout, unos objetos al lado del otro)
        panel.add(boton1);
        panel.add(boton2);
        this.add("South", panel);
        this.pack();
        this.resize(600, 600);
        this.show();
    }
    public void update(Graphics g){
        paint(g);
    }
    public void paint (Graphics g){
        ovalo.dibujar(g);
    }
    
    public boolean handleEvent(Event ev){
        if(ev.id == Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
        }else if(ev.id == Event.ACTION_EVENT){
            if(ev.target instanceof Button){    //target nos indica sobre que clase de objeto se ha producido el evento
                if(ev.arg.equals("Salir")){
                    System.exit(0);
                    return true; 
                }
                if(ev.arg.equals("Siguiente")){
                    ovalo.inicializarValores();
                    repaint();
                    return true; 
                }
            }
        }
        return false;
    }
}
