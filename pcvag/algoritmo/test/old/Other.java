import org.junit.Test;

import java.util.Random;

/**
 * Created by emanuelvictor on 08/09/14.
 */
public class Other {

    public static final int[][] MATRIZ_ADJACENTE =
    /**Matriz adjacente*/
    new int[][]{
        /**     01  02  03  04  05  06  07  08  09  10  11  12  13  14  15  16  17  18*/
        /**1**/{00, 7, 23, 87, 78, 32, 87, 8, 22, 87, 22, 56, 48, 45, 43, 32, 35, 21},
        /**2**/{7, 00, 43, 87, 24, 87, 8, 99, 87, 56, 49, 65, 23, 55, 49, 42, 22, 28},
        /**3**/{23, 43, 00, 24, 10, 14, 87, 64, 43, 48, 87, 22, 34, 23, 55, 49, 23, 48},
        /**4**/{87, 87, 24, 00, 9, 34, 43, 87, 55, 43, 49, 27, 32, 90, 90, 7, 45, 30},
        /**5**/{78, 24, 10, 9, 00, 87, 99, 43, 33, 44, 49, 49, 49, 60, 28, 39, 45, 44},
        /**6**/{32, 87, 14, 34, 87, 00, 6, 45, 47, 31, 49, 49, 22, 49, 20, 22, 44, 23},
        /**7**/{87, 8, 87, 43, 99, 06, 00, 54, 87, 21, 87, 77, 54, 70, 65, 49, 55, 67},
        /**8**/{8, 99, 64, 87, 43, 45, 54, 00, 11, 32, 49, 55, 77, 21, 29, 45, 23, 63},
        /**9**/{22, 87, 43, 55, 33, 47, 87, 11, 00, 15, 56, 32, 99, 49, 78, 88, 54, 47},
        /**10*/{87, 56, 48, 43, 44, 31, 21, 32, 15, 00, 17, 43, 56, 49, 21, 98, 21, 44},
        /**11*/{22, 49, 87, 49, 49, 49, 87, 49, 56, 17, 00, 15, 94, 76, 77, 23, 23, 34},
        /**12*/{56, 65, 22, 27, 49, 49, 77, 55, 32, 43, 15, 00, 13, 77, 34, 43, 45, 34},
        /**13*/{48, 23, 34, 32, 49, 22, 54, 77, 99, 56, 94, 13, 00, 12, 43, 32, 34, 34},
        /**14*/{45, 55, 23, 90, 60, 49, 70, 21, 49, 49, 76, 77, 12, 00, 11, 31, 65, 45},
        /**15*/{43, 49, 55, 90, 28, 20, 65, 29, 78, 21, 77, 34, 43, 11, 00, 32, 16, 55},
        /**16*/{32, 42, 49, 7, 39, 22, 49, 45, 88, 98, 23, 43, 32, 31, 32, 00, 44, 10},
        /**17*/{35, 22, 23, 45, 45, 44, 55, 23, 54, 21, 23, 45, 34, 65, 16, 44, 00, 11},
        /**18*/{21, 28, 48, 30, 44, 23, 67, 63, 47, 44, 34, 34, 34, 45, 55, 10, 11, 00},
    };

    /**Melhor rota disponível : 1 ->  2  = 7
     *                        : 2 ->  7  = 8
     *                        : 7 ->  6  = 6
     *                        : 6 ->  3  = 14
     *                        : 3 ->  5  = 10
     *                        : 5 ->  4  = 6
     *                        : 4 -> 16  = 7
     *                        :16 -> 18  = 10
     *                        :18 -> 17  = 11
     *                        :17 -> 15  = 16
     *                        :15 -> 14  = 11
     *                        :14 -> 13  = 12
     *                        :13 -> 12  = 13
     *                        :12 -> 11  = 15
     *                        :11 -> 10  = 17
     *                        :10 ->  9  = 15
     *                        : 9 ->  8  = 11
     *                        : 8 ->  1  = 8
     *                             TOTAL = 200 << ESSE É O MÁXIMO GLOBAL */

    @Test
    public  /*int[][]*/ void gerarCromossomosAleatoriamente(/*int[][] cromossomos*/) {

        //RPRESENTAM OS INDIVÍDUOS QUE SERÃO CRUZADOS
        int[][] cromossomos = new int[MATRIZ_ADJACENTE.length][MATRIZ_ADJACENTE.length];


        int[] cromossomo_temp = new int[MATRIZ_ADJACENTE.length];
        int POP_NUM = 10;


        int i, i2;
        for (i = 0; i < POP_NUM; i++) {
            boolean cromossomo_valido = false;
            while (!cromossomo_valido) {
                cromossomo_valido = true;
                cromossomo_temp = resetaCromossomo();

                // gerando cromossomo - ok
                for (i2 = 0; i2 < MATRIZ_ADJACENTE.length; i2++) {
                    cromossomo_temp[i2] = valorValidoNoCromossomo(cromossomo_temp);
                }
                cromossomo_valido = cromossomoValido(cromossomo_temp, cromossomos);
            }
            cromossomos[i] = cromossomo_temp;
        }

        for (int j = 0; j < cromossomos.length; j++) {
            for (int k = 0; k < cromossomos[j].length; k++) {
//                if (k == cromossomos[j][k]) {
//                    System.out.print("* ("+ k +") --> " + cromossomos[j][k]+" ");
//                    continue;
//                }
                System.out.print("("+ k +") " + cromossomos[j][k]+" ");
            }
            System.out.println();
        }

//        return cromossomos;
    }

    //Inicializa todos os cromossomos com -1
    private static int[] resetaCromossomo() {
        int[] c = new int[MATRIZ_ADJACENTE.length];
        int i;
        for (i = 0; i < MATRIZ_ADJACENTE.length; i++) {
            c[i] = -1;
        }
        return c;
    }

    private static int valorValidoNoCromossomo(int[] c_tmp) {
        int r;
        boolean valido;
        do {
            r = new Random().nextInt(MATRIZ_ADJACENTE.length);
            valido = true;
            for (int ii = 0; ii < MATRIZ_ADJACENTE.length; ii++) {
                if (c_tmp[ii] == r)
                    valido = false;
            }
        } while (!valido);
        return r;
    }

    //Compara com todos os outros cromossomos anteriores
    private static boolean cromossomoValido(int[] c_tmp, int[][] cromossomos) {
        int j, j2;
        boolean crom_valido = true;

        for (j = 0; j < MATRIZ_ADJACENTE.length; j++) {
            int n_iguais = 0;
            for (j2 = 0; j2 < MATRIZ_ADJACENTE.length; j2++) {
                if (c_tmp[j2] == cromossomos[j][j2]) {
                    n_iguais++;
                }
            }

            if (n_iguais == MATRIZ_ADJACENTE.length)
                crom_valido = false;
        }
        return crom_valido;
    }

}
