
package Ejercicio02;

public class Canguro extends Animal{

    private int salto;
    private int velocidad;
    
    public Canguro(int id, String fNac, String nom, boolean vac, int sal, int vel){
        super(id, fNac, nom, vac);
        this.salto = sal;
        this.velocidad = vel;
    }
        
    public void mostrar(){       //No puede haber objetos de una clase abstracta (son simples definiciones)
        System.out.printf("Hola, soy un canguro, me llamo %s, corro a %d km/h: chuchu\n", this.getNombre(), getVelocidad());
    }

    public int getSalto() {
        return salto;
    }
    public void setSalto(int salto) {
        this.salto = salto;
    }
    public int getVelocidad() {
        return velocidad;
    }
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
}
