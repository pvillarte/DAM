/*De decimal a hexadecimal con recursividad*/
package primera;

public class EjercicioPracticaExamen2 {
    public static void main(String[] args) {
        int numero = 255;
        decimalAHexadecimal (numero);
        System.out.println();
    }
    
    public static void decimalAHexadecimal(int numero){
        if (numero>0){
            decimalAHexadecimal(numero/16);
            switch (numero%16){
                case 10:
                    System.out.print('A');
                    break;
                case 11:
                    System.out.print('B');
                    break;
                case 12:
                    System.out.print('C');
                    break;
                case 13:
                    System.out.print('D');
                    break;
                case 14:
                    System.out.print('E');
                    break;
                case 15:
                    System.out.print('F');
                    break;
                default:
                    System.out.print(numero%16);
            }
        }
    }
}
