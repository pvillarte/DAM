
package Ejercicio09;
import java.awt.*;
//Desplegable con 3 opciones deayyuno comida cena y al lado lista con opciones para cada uno.
//Abajo aparece todas las opciones elegidas

public class Restaurante extends Frame {
    
    String [] comidas = {"Desayuno", "Almuerzo", "Cena"};
    String [][] platos = {{"Leche", "Café", "Huevos", "Tostadas", "Mermelada", "Bacon"},
        {"Lentejas", "Garbanzos", "Paella", "Sopa", "Macarrones", "Merluza", "Albóndigas", "Hamburguesa", "Filete"},
        {"Tortilla", "Sopa", "Hamburguesa", "Pizza", "Ensalada", "Pollo", "Sandwich"}};
    Choice chComidas;
    List[] listasPlatos;
    List presentar;
    TextField comanda;
    String mostrar;
    
    public static void main(String[] args) {
        Restaurante app = new Restaurante();
    }
    
    public Restaurante(){
        super("Aplicación restaurante");
        setup();
        pack();
        resize(275, 175);
        show();
    }
    
    public void setup(){
        this.add("North", new Label("Elige la comanda", Label.CENTER));
        
        chComidas= new Choice();
        for (int i=0; i< comidas.length; i++)
            chComidas.add(comidas[i]);
        this.add("West", chComidas);
        
        listasPlatos = new List[comidas.length];
        for (int i=0; i<comidas.length; i++){
            listasPlatos[i] = new List(5, true);
            for (int j=0; j<platos[i].length; j++)
                listasPlatos[i].add(platos[i][j]);
        }
        presentar = listasPlatos[0];
        this.add("East",presentar);
        
        comanda = new TextField("", 40);
        this.add("South", comanda);
    }
    
    public boolean handleEvent(Event ev){        
        if (ev.id == Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
        } else if (ev.target instanceof Choice){
            if (ev.id == Event.ACTION_EVENT){
                this.remove(presentar);
                presentar=listasPlatos[chComidas.getSelectedIndex()];
                this.add("East", presentar);
                this.show();
                comanda.setText(chComidas.getSelectedItem()+": ");
                return true;
            }
        } else if (ev.target instanceof List){
            if (ev.id == Event.LIST_SELECT||ev.id == Event.LIST_DESELECT){
                mostrar=chComidas.getSelectedItem()+": ";
                String[] seleccionados = presentar.getSelectedItems();
                for (int i=0; i<seleccionados.length; i++)
                    mostrar+=seleccionados[i]+" ";
                comanda.setText(mostrar);
                return true;
            }
        }
        return false;
    }
}
