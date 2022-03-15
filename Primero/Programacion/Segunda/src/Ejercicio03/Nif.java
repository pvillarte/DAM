
package Ejercicio03;

public class Nif {
    public int dni;
    public char letra; //static es un modificador para crear atributos constantes
    public static char tabla[] ={'T', 'R', 'W','A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
    
    
    public Nif(int dni, char letra) throws Exception{
        this.dni=dni;
        if(letra!=tabla[dni%23])
            throw new Exception("Me has pasado mal el NIF");    //Throw para lanzar una excepcion
        this.letra = tabla[dni % 23];
    }
    
    public Nif(int dni) throws Exception{
        //this.dni=dni;
        //this.letra=tabla[dni%23];
        this(dni, tabla[dni % 23]);
    }
    
    public void muestraNif(){
        System.out.printf("%d - %c\n", dni, letra);
    }

}
