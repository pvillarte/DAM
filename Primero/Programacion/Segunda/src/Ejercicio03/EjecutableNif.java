
package Ejercicio03;

public class EjecutableNif {
    public static void main(String[] args) throws Exception {
        
        Nif persona1, persona2;
        
        
        persona1 = new Nif(17438604);
        persona2 = new Nif(17456622);
        
        Nif paco;
        paco = new Nif(12345678);
        
        paco.letra= 'A';
        paco.muestraNif();
        //persona2.muestraNif();
        
        //persona1.muestraNif();
        //persona2.muestraNif();
        
    }
}

/*
public static void main(String[] args) {
    try{                                                  //try{-INSTRUCCIONES-}catch(-EXCEPCION-){INSTRUCCIONES}
        int a = 7/0;                                      //Utilizamos para que el programa no intrrumpa su ejecucion al dar este tipo de errores.
        System.out.println("No llega");
    }catch(ArithmeticException excepcion){
        System.out.println("Has dividido por cero");
    }
    System.out.println("Continua la ejecucion");
}
*/
