
package Ejercicio02;

abstract class Animal {                                                         //abstract (modificador) Impide que se creen objetos de esta clase
    
    private int id;
    private String fechaNacimiento;
    private String nombre;                                                      //Atributo encapsulado
    private boolean vacunado;

    public Animal(int id, String fNac, String nom, boolean vac) {
        this.id = id;
        this.fechaNacimiento = fNac;
        this.nombre = nom;
        this.vacunado = vac;
    }
    
    abstract void mostrar();     //Las subclases de animal, al declarar un método abstracto, estan obligadas a implementar este método
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public boolean isVacunado() {
        return vacunado;
    }
    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }
}
