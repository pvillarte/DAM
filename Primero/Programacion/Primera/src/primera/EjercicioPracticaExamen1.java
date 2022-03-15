/*cambia orden palabra mediante recursividad*/
package primera;

public class EjercicioPracticaExamen1 {
    public static void main(String[] args) {
        String palabra="buenas tardes señoras y señores";
        int num=palabra.length()-1;
        
        invierteOrden(palabra, num);
        System.out.println();
        
        String inverso = invierteOrden2(palabra, 0, "");
        System.out.println(inverso);
    }
    
    public static void invierteOrden (String palabra, int num){
        if (num>=0){
            System.out.print(palabra.charAt(num));
            invierteOrden(palabra,num-1);
        }
    }
    
    public static String invierteOrden2 (String palabra, int num, String aux){
        if (num<palabra.length()){
            aux=invierteOrden2(palabra, num+1, aux);
            aux += palabra.charAt(num);
        }
        return aux;
    }
}
