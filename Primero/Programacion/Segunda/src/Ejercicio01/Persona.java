package Ejercicio01;

public class Persona {
    public String nombre;
    public String apellidos;
    public double altura;
    public double peso;
    
    public Persona(){
        nombre = "Pepe";
        apellidos = "López";
        altura = 1.76;
        peso= 89;
    }
    
    public Persona(String nom, String ape){                                     //Polimorfismo
        nombre = nom;
        apellidos = ape;
        altura = 1.7;
        peso = 70;
    }
    
    public Persona(String nom, String ape, double altura, double peso){         //Polimorfismo
        this.nombre = nom;
        this.apellidos = ape;                                                   //No es obligatorio si no hay ambigÜedad, pero también se puede
        this.altura = altura;                                                   //This se utiliza para referirse a atributos
        this.peso = peso;                                                       
    }
    
    public void mostrar(){
        System.out.println(this.nombre + " " + this.apellidos  + " = ("+ this.altura  + "m "+ this.peso + "kg). ");
    }
}
