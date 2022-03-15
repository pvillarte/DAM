/*Binario a decimal*/
package primera;

public class EjercicioPracticaExamen3 {
    public static void main(String[] args) {
        int numBin = 11111111;
        int numDec = binarioADecimal(numBin);
        System.out.println(numDec);
    }

    public static int binarioADecimal(int numBin) {
        int numDec = 0;
        int cifras = 0;
        int potencia2;
        int potencia10;
        cifras = cuentaCifras(numBin, cifras);
        for (int i = cifras; i>0; i--){
            potencia2 = potencia (2, i-1);
            potencia10 = potencia (10, i-1);
            if (numBin>=potencia10){
                numDec += potencia2;
                numBin -= potencia10;
            }
        }
        return numDec;
    }

    public static int cuentaCifras(int numero, int cifras) {
        while (numero !=0){
            numero /= 10;
            cifras++;
        }
        return cifras;
    }
    
    public static int potencia (int base, int exponente){
        int acum=1;
        for (int i=0; i<exponente; i++)
            acum *= base; 
        return acum;
    }
}
