package Ejercicio07;
import java.awt.*;

public class FrameApp extends Frame {
    MenuBar porDefecto;
    MenuBar alternativo;
    String tituloInicial;
    int cursores[] = {DEFAULT_CURSOR, CROSSHAIR_CURSOR,  E_RESIZE_CURSOR, HAND_CURSOR,
        MOVE_CURSOR, NE_RESIZE_CURSOR, NW_RESIZE_CURSOR, TEXT_CURSOR, WAIT_CURSOR};
    int posCursor = 0;
    Color colores[] = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
        Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK};
    int posColor1 = 0;
    int posColor2 = 0;
    String fuentes[] = {"Helvetica", "TimesRoman", "Courier", "Dialog", "DialogInput", "Arial"};
    int posLetra = 0;
    
    public static void main(String[] args) {
        FrameApp app = new FrameApp();
    }   
    
    public FrameApp(){
        super("Trabajando con frames");
        tituloInicial= this.getTitle();
        setup();
        resize(400, 400);
        show();
    }    
    
    public void setup(){
        setupMenu();
        setupPaneles();
    }

    public void setupPaneles() throws HeadlessException {
        Panel panelPrincipal= new Panel();
        panelPrincipal.setLayout(new GridLayout(4, 1));
        panelPrincipal.add(new Label("Cambiar caracteríticas de la ventana", Label.CENTER));
        Panel panel1 = new Panel();
        panel1.add(new Button("Título"));
        panel1.add(new Button("MenuBar"));
        panel1.add(new Button("Resizable"));
        panelPrincipal.add(panel1);
        panelPrincipal.add(new Label("Salidas en la ventana", Label.CENTER));
        Panel panel2 = new Panel();
        panel2.add(new Button("Cursor"));
        panel2.add(new Button("Background"));
        panel2.add(new Button("Foreground"));
        panel2.add(new Button("Font"));
        panelPrincipal.add(panel2);
        this.add("South", panelPrincipal);
    }

    public void setupMenu() throws HeadlessException {
        porDefecto= new MenuBar();
        Menu fileMenu = new Menu("File");
        fileMenu.add(new MenuItem("Exit"));
        porDefecto.add(fileMenu);
        alternativo= new MenuBar();
        Menu fileMenu2 = new Menu("Archivo");
        fileMenu2.add(new MenuItem("Salir"));
        alternativo.add(fileMenu2);
        this.setMenuBar(porDefecto);
    }
    public void paint(Graphics g) {
        g.drawString("Cambia el color al pulsar Foreground", 100, 150);
    }
    
    public boolean handleEvent(Event ev){        
        if (ev.id == Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
        } else if (ev.id == Event.ACTION_EVENT){
            if(ev.target instanceof Button){
                if (ev.arg.equals("Título")){
                    if (this.getTitle().equals(tituloInicial))
                        this.setTitle("Título alternativo");
                    else
                        this.setTitle(tituloInicial);
                    return true;
                } else if (ev.arg.equals("MenuBar")){
                    if (this.getMenuBar().equals(porDefecto))
                        this.setMenuBar(alternativo);
                    else
                        this.setMenuBar(porDefecto);
                    return true;
                } else if (ev.arg.equals("Resizable")){
                    this.setResizable(!this.isResizable());
                    return true;
                } else if (ev.arg.equals("Cursor")){
                    posCursor = (++posCursor)%cursores.length;
                    this.setCursor(cursores[posCursor]);
                    return true;
                } else if (ev.arg.equals("Background")){
                    posColor1 = (++posColor1)%colores.length;
                    this.setBackground(colores[posColor1]);
                    return true;
                } else if (ev.arg.equals("Foreground")){
                    posColor2 = (++posColor2)%colores.length;
                    this.setForeground(colores[posColor2]);
                    return true;
                } else if (ev.arg.equals("Font")){
                    posLetra = (++posLetra)%fuentes.length;
                    this.setFont(new Font(fuentes[posLetra], Font.PLAIN, 15));
                    return true;
                }
            } else if (ev.target instanceof MenuItem){
                if (ev.arg.equals("Salir") || ev.arg.equals("Exit")){
                    System.exit(0);
                    return true;
                }
            } 
        }
        return false;
    }
}
