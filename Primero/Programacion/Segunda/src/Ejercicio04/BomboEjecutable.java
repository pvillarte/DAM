
package Ejercicio04;

public class BomboEjecutable {
    public static void main(String[] args) {
        Bombo bombona;
        bombona= new Bombo(48);
        
        int[][] resultados;
        resultados= new int[6][8];
        
        for(int i=0; i<6; i++){
            System.out.println("----------------------------------------");
            System.out.print("|");
            for(int j=0; j<8; j++){
                resultados[i][j]=bombona.sacarBola();
                System.out.printf("%2d | ",resultados[i][j]);
            }
            System.out.println();
        }
        System.out.println("----------------------------------------");
    }
}

