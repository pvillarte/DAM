/*LLamadas a funciones*/
package primera;

public class Ejercicio045 {
    public static void main (String Arg[]){            //Void es que no devuelve nada. Main funcion o método principal. 
        String palabras;
        escribir();
        hablar("Buenos días");
        animalHabla("Me llamo Tobi","Guau, guau");
        palabras = concatenar("En un lugar"," de La Mancha");
        System.out.println(palabras);
        System.out.printf("La suma de 345 + 55 es %d \n",suma(345,55));
    }
    
    public static void escribir(){                      //Entre paréntesis los parámetros que la función quiere recibir
        System.out.println("Hola");
    }
    
    public static void hablar(String frase){           //Entre paréntesis los parámetros que la función quiere recibir y su declaración
        System.out.println(frase);
    }
    
    public static void animalHabla(String frase, String onomatopeya){
        System.out.println(frase + " : " + onomatopeya);
    }
    
    public static String concatenar(String frase1, String frase2){
        return frase1 + frase2;
    }
    public static int suma (int a, int b){
        return(a+b);
    }
}
