
package Ejercicio02;

public class SobreAnimales {
    
    public static void main(String[] args) {
        
        Perro perro1, perro2;
        Canguro canguro1;

        perro1 = new Perro(10, "10/03/2020", "Tobi", true, "Terrier", false);
        perro2 = new Perro(10, "23/01/2019", "Sultán", true, "Caniche", true);
        canguro1 = new Canguro(10, "15/02/2019", "Cangu", true, 3, 24);
        
        perro1.mostrar();
        perro2.mostrar();
        canguro1.mostrar();
        
        perro1.setRaza("Pastor alemán");
        perro1.mostrar();
    }
    
}
