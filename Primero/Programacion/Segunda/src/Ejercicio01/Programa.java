package Ejercicio01;

public class Programa {
    public static void main(String[] args) {
        
        Persona persona1, persona2, persona3;
        
        persona1 = new Persona();                                               //new es un instruccion que reserva memoria
        persona2 = new Persona("Jamon", "Serrano");
        persona3 = new Persona("Camilo José", "Cela", 1.51, 120.5);   

        persona1.mostrar();
        persona2.mostrar();
        persona3.mostrar();
        
        persona1=persona3;
        persona3.mostrar();

    }
}
