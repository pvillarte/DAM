/*Mostramos el camino de ida y de vuelta*/
package primera;

public class Ejercicio091 {
    public static void main(String[] args) {
        mostrarFrase(5);
    }
    
    public static void mostrarFrase(int a) {
        if(a>0){
            System.out.println("mostrarFrase("+a+")");
            mostrarFrase(a-1);
            System.out.println("mostrarFrase("+a+")");
        }
    }
}
