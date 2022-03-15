/*
1º) Mostrar por pantalla el trimeste con más nacimientos
2º) Mes en el que más bajas se han producido. Defunciones y traslados
3º) Mostrar por pantalla cuantas personas nuevas han venido al pueblo y cuantas han desaparecido
*/
package primera;

public class Ejercicio097 {
    public static void main(String[] args) {
        String[] MOVIMIENTOS = {"nacimientos", "defunciones", "traslados fuera", "traslados dentro"};
        final String[] MESES = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "noviembre", "Diciembre"};
        int movPoblacion[][] ={{3, 2, 0, 0}, {1, 5, 0, 1}, {9, 4, 0, 0}, {3, 8, 0, 0}, {6, 1, 0, 0}, {3, 5, 0, 1}, {3, 12, 1, 0}, {2, 3, 0, 1}, {1, 7, 1, 1}, {9, 2, 0, 0}, {1, 5, 3, 0}, {5, 8, 2, 1}};
        
        muestraTrimestreMaxNacimientos(movPoblacion, MOVIMIENTOS);
        muestraMesMaxBajas(movPoblacion, MESES);
        muestraAltasYBajas(movPoblacion);
    }

    public static void muestraAltasYBajas(int[][] movPoblacion) {
        int altas=0;
        int bajas=0;
        for (int i=0; i<movPoblacion.length; i++)
            for (int j=0; j<movPoblacion[i].length; j++)
                switch(j){
                    case 0: case 3:
                        altas += movPoblacion[i][j];
                        break;
                    case 1: case 2:
                        bajas += movPoblacion[i][j];
                        break;
                }
        System.out.printf("3º) Ha habido %d altas y %d bajas a lo largo del año.\n", altas, bajas);
    }


    public static void muestraTrimestreMaxNacimientos(int[][] nacimientos, String[] MOVIMIENTOS) {
        String[] ORDINALTRIMESTRE = {"primero", "segundo", "tercero", "cuarto"};
        int nacimientosTrimestrales[] = new int[4];
        int posMax = 0;
        for (int i=0; i<nacimientos.length; i++)
            switch(i){
                case 0: case 1: case 2:
                    nacimientosTrimestrales[0] += nacimientos[i][0];
            break;
                case 3: case 4: case 5:
                    nacimientosTrimestrales[1] += nacimientos[i][0];
            break;
                case 6: case 7: case 8:
                    nacimientosTrimestrales[2] += nacimientos[i][0];
            break;
                case 9: case 10: case 11:
                    nacimientosTrimestrales[3] += nacimientos[i][0];
            break;            
            }
        
        for (int i=0; i<nacimientosTrimestrales.length; i++)
            if (nacimientosTrimestrales[i]>nacimientosTrimestrales[posMax])
                posMax=i;
        System.out.printf("1º) El trimestre con mas %s ha sido el %s, con un total de %d.\n", MOVIMIENTOS[0], ORDINALTRIMESTRE[posMax], nacimientosTrimestrales[posMax]);
    }
    
    public static void muestraMesMaxBajas(int[][] movPoblacion, String[] MESES) {
        int posMax=0;
        int bajas[] = new int[12];
        for (int i=0; i<movPoblacion.length; i++)
            bajas[i] = movPoblacion[i][1] + movPoblacion[i][2];
        for (int i=0; i<bajas.length; i++)
            if (bajas[i]>bajas[posMax])
                posMax=i;
        System.out.printf("2º) El mes con mas bajas ha sido %s, con un total de %d.\n", MESES[posMax], bajas[posMax]);
    }
}
