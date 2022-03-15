
package Ejercicio02;

public class Perro extends Animal{
    
    private String raza;
    boolean peligrosidad;
    
    public Perro(int id, String fNac, String nom, boolean vac, String raza, boolean pel){
        super(id, fNac, nom, vac);                                              //super()para llamar al metodo constructor de la superclase
        this.raza = raza;
        this.peligrosidad = pel;
    }
    
    public void mostrar(){

        if(peligrosidad){
                    System.out.printf("Hola, soy un perro, me llamo %s, soy de raza %s y soy peligroso: GUAU GUAU\n", this.getNombre(), getRaza());
        }else
                    System.out.printf("Hola, soy un perro, me llamo %s, soy de raza %s y no soy peligroso: GUAU GUAU\n", this.getNombre(), getRaza());
    }


    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    } 
    
}
