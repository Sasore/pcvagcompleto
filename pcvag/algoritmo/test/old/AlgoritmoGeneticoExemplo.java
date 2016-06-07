import org.junit.Test;

import java.util.Random;

/**
 * Created by emanuelvictor on 07/09/14.
 */

public class AlgoritmoGeneticoExemplo {

    public static int NUMERO_CIDADES = 18;
    public static int NUMERO_POPULACAO = 10;

    public static void main(String[] args) {

        // definicoes iniciais
        boolean mostrarEvolucao = true;
        float taxaMortalidade = (float) 0.5;
        int numeroEvolucoes = 30;

        // matriz de adjacencia
        int[][] mapa = {
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

        String[] cidades = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17" };

        int[][] cromossomos = new int[NUMERO_POPULACAO][NUMERO_CIDADES];
        int[] resultados = new int[NUMERO_POPULACAO];

        gerarCromossomosAleatoriamente(cromossomos);
        calcularResultado(cromossomos, resultados, mapa);
        ordenar(cromossomos, resultados);
        if (mostrarEvolucao)
            imprimir(cromossomos, resultados, cidades);

        int i;
        for (i = 0; i < numeroEvolucoes; i++) {
            crossover(cromossomos, resultados, taxaMortalidade);
            calcularResultado(cromossomos, resultados, mapa);
            ordenar(cromossomos, resultados);
            if (mostrarEvolucao) {
                System.out.println("Geracao: " + (i + 1));
                imprimir(cromossomos, resultados, cidades);
            }
        }
        // mostrando resultado encontrado
        resultado(cromossomos, resultados, cidades);

    }

    private static void resultado(int[][] cromossomos, int[] resultados, String[] cidades) {
        int i, i2;
        i=0;
        for (i2 = 0; i2 < NUMERO_CIDADES; i2++) {
            System.out.print(cidades[cromossomos[i][i2]] + " => ");
        }
        System.out.print(cidades[cromossomos[i][0]] + " ");
        System.out.println(" Resultado: " + resultados[i]);

    }

    public static void crossover(int[][] cromossomos,
                                 int[] resultados, float taxaMortalidade) {

        int inicioExcluidos = (int) (taxaMortalidade * 10);

        int i, i2 = 0;

        for (i = inicioExcluidos; i < 10; i++) {

            boolean valido = false;

            while (!valido) {

                int[] c_tmp = resetaCromossomo();

                // pegando 2 pais aleatoriamente
                int pai1, pai2;

                pai1 = new Random().nextInt(inicioExcluidos);
                do {
                    pai2 = new Random().nextInt(inicioExcluidos);
                } while ((pai1 == pai2)
                        && (resultados[pai1] != resultados[pai2]));



                // Sorteia o GENES a trocar do pai 1
                for (i2 = 0; i2 < (int) NUMERO_CIDADES / 4; i2++) {
                    int pos;
                    pos = new Random().nextInt(NUMERO_CIDADES);
                    c_tmp[pos] = cromossomos[pai1][pos];
                }



                // Sorteia o GENES a trocar do pai 2
                for (i2 = 0; i2 < (int) NUMERO_CIDADES / 4; i2++) {
                    int pos = new Random().nextInt(NUMERO_CIDADES);
                    if (c_tmp[pos] == -1) {
                        if (valorValidoNoCromossomo(cromossomos[pai2][pos],c_tmp)) {
                            c_tmp[pos] = cromossomos[pai2][pos];
                        }
                    }
                }



                // preenchendo o restante com aleatorios
                for (i2 = 0; i2 < NUMERO_CIDADES; i2++) {
                    if (c_tmp[i2] == -1) {
                        int crom_temp = valorValidoNoCromossomo(c_tmp);
                        c_tmp[i2] = crom_temp;
                    }
                }



                // verificando se é valido
                valido = cromossomoValido(c_tmp, cromossomos);
                if (valido) {
                    cromossomos[i] = c_tmp;
                }
            }
        }

    }

    private static int[][] gerarCromossomosAleatoriamente(int[][] cromossomos) {

        // inicializando cromossomos aleatoriamente
        int[] c_tmp = new int[NUMERO_CIDADES];

        int i, i2;
        for (i = 0; i < NUMERO_POPULACAO; i++) {
            boolean crom_valido = false;
            while (!crom_valido) {
                crom_valido = true;
                c_tmp = resetaCromossomo();

                // gerando cromossomo - ok
                for (i2 = 0; i2 < NUMERO_CIDADES; i2++) {
                    c_tmp[i2] = valorValidoNoCromossomo(c_tmp);
                }
                crom_valido = cromossomoValido(c_tmp, cromossomos);
            }
            cromossomos[i] = c_tmp;
        }

//        for (int j = 0; j < cromossomos.length; j++) {
//            for (int k = 0; k < cromossomos[j].length; k++) {
//                if (k == cromossomos[j][k]) {
//                    System.out.print("CROMOSSOMO INVÁLIDO ("+ k +") --> " + cromossomos[j][k]+" ");
//                }
//                System.out.print("("+ k +") --> " + cromossomos[j][k]+" ");
//            }
//            System.out.println();
//        }

        return cromossomos;
    }

    //Inicializa todos os cromossomos com -1
    private static int[] resetaCromossomo() {
        int[] c = new int[NUMERO_CIDADES];
        int i;
        for (i = 0; i < NUMERO_CIDADES; i++) {
            c[i] = -1;
        }
        return c;
    }

    private static int valorValidoNoCromossomo(int[] c_tmp) {
        int r;
        boolean valido;
        do {
            r = new Random().nextInt(NUMERO_CIDADES);
            valido = true;
            for (int ii = 0; ii < NUMERO_CIDADES; ii++) {
                if (c_tmp[ii] == r)
                    valido = false;
            }
        } while (!valido);
        return r;
    }

    private static boolean valorValidoNoCromossomo(int valor, int[] c_tmp) {
        int crom_temp = valor;
        boolean valido;

        valido = true;
        for (int ii = 0; ii < NUMERO_CIDADES; ii++) {
            if (c_tmp[ii] == crom_temp)
                valido = false;
        }

        return valido;
    }

    //Compara com todos os outros cromossomos anteriores
    private static boolean cromossomoValido(int[] c_tmp, int[][] cromossomos) {
        int j, j2;
        boolean crom_valido = true;

        for (j = 0; j < NUMERO_POPULACAO; j++) {
            int n_iguais = 0;
            for (j2 = 0; j2 < NUMERO_CIDADES; j2++) {
                if (c_tmp[j2] == cromossomos[j][j2]) {
                    n_iguais++;
                }
            }

            if (n_iguais == NUMERO_CIDADES)
                crom_valido = false;
        }
        return crom_valido;
    }

    private static void imprimir(int[][] cromossomos, int[] resultados,
                                 String[] cidades) {
        int i, i2;
        for (i = 0; i < NUMERO_POPULACAO; i++) {
            for (i2 = 0; i2 < NUMERO_CIDADES; i2++) {
                System.out.print(cidades[cromossomos[i][i2]] + " => ");
            }
            System.out.print(cidades[cromossomos[i][0]] + " ");
            System.out.println(" Resultados: " + resultados[i]);
        }
    }

    private static void calcularResultado(int[][] cromossomos,
                                          int[] resultados, int[][] mapa) {
        int i, i2;
        // calculando o resultado
        for (i = 0; i < NUMERO_POPULACAO; i++) {
            int resTmp = 0;
            for (i2 = 0; i2 < NUMERO_CIDADES - 1; i2++) {
                resTmp += mapa[cromossomos[i][i2]][cromossomos[i][i2 + 1]];
            }
            resTmp+=mapa[cromossomos[i][0]][cromossomos[i][i2]];
            resultados[i] = resTmp;
        }

    }

    private static void ordenar(int[][] cromossomos, int[] resultados) {
        // ordenando
        int i, i2;
        for (i = 0; i < 10; i++) {
            for (i2 = i; i2 < 10; i2++) {
                if (resultados[i] > resultados[i2]) {
                    int vTmp;
                    int[] vvTmp = new int[10];
                    vTmp = resultados[i];
                    resultados[i] = resultados[i2];
                    resultados[i2] = vTmp;

                    vvTmp = cromossomos[i];
                    cromossomos[i] = cromossomos[i2];
                    cromossomos[i2] = vvTmp;
                }
            }
        }
    }

}



