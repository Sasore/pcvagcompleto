import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by emanuelvictor on 07/09/14.
 */
public class Algoritmo {

    public static final int[][] MATRIZ_ADJACENTE =
            /**
             * Matriz adjacente ,
             * onde representa as cidades!
             * no total de 18 cidades e aqui são definidos os custos
             * */

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
     *                             TOTAL = 200 << ESSE É O MÁXIMO GLOBAL FITNESS*/


    /**
     * testar matriz adjacente idêntica, verifica se a matriz adjacente é realmente idêntica
     */


    //cria a matriz de rotas
    int[][] populacaoInicial;

    //tamanho da população são as quantidades de ROTAS máximo de rotas = 1000000000
    int TAM_POP = 100;

    //cria um vetor com a melhor rota armazenada
    int[] fitness = new int[TAM_POP];

    int NUM_GERACOES = 5000;

    @Test
    public void algoritmo() {
        populacaoInicial = gerarPrimeiraPopulacao(TAM_POP);
        fitness = calcularFitness(populacaoInicial);
        populacaoInicial = ordenar(populacaoInicial, fitness);
        System.out.println("População inicial ordenada");
        imprimir(populacaoInicial, fitness);


        for (int j = 0; j < NUM_GERACOES; j++) {
            // Seleciona o melhor indivíduo baseado no fitnesse com a roleta
            int i = roleta(fitness);
//            System.out.print("Indivíduo selecionado = " + i + " ROTA = ");
//            for (int k = 0; k < populacaoInicial[i].length ; k++) {
//                System.out.print(" " + populacaoInicial[i][k]);
//            }
            // Aplica o crossover do indivíduo selecionado pela roleta
            populacaoInicial = crossoverCX(i, populacaoInicial);
            // Aplica mutaçao
            populacaoInicial = mutacao(populacaoInicial);
            // Calcula o fitness
            fitness = calcularFitness(populacaoInicial);
            //Reordena a populaçao pelo fitness
            populacaoInicial = ordenar(populacaoInicial, fitness);
            // Imprime a nova populaçao
//            System.out.println("Nova populaçao população");
//            imprimir(populacaoInicial, fitness);
        }

        // Aplica a mutação

        System.out.println("Ultima população");
        imprimir(populacaoInicial, fitness);

    }


    private static int[][] gerarPrimeiraPopulacao(int TAM_POP) {

        int[][] rotas = new int[TAM_POP][MATRIZ_ADJACENTE.length];

        //Inicializando população inicial
        for (int k = 0; k < TAM_POP; k++) {

            int[] rotaAux = new int[MATRIZ_ADJACENTE.length];
            for (int i = 0; i < MATRIZ_ADJACENTE.length; i++) {
                rotaAux[i] = i;
            }

            int[] rota = new int[rotaAux.length];

            int tam = rota.length;

            for (int i = 0; i < tam; i++) {
                int r;
                do {
                    r = new Random().nextInt(tam - i);
                } while (r == i);

                rota[i] = rotaAux[r];
                rotaAux = preencheVetorSemOR(rotaAux, r);
            }

            boolean b = false;
            for (int i = 0; i < k; i++) {
                b = Arrays.equals(rotas[i], rota);
                if (b) {
                    break;
                }
            }

            if (!b) {
                for (int i = 0; i < tam; i++) {
                    rotas[k][i] = rota[i];
                }
            } else {
                System.out.println("Rotas iguais encontradas na posição " + k);
                k--;
                continue;
            }

        }

        return rotas;
    }

    private static int[] calcularFitness(int[][] populacao) {
        int[] fitness = new int[populacao.length];
        for (int i = 0; i < populacao.length; i++) {
            fitness[i] = calcularFitness(populacao[i]);
        }
        return fitness;
    }

    private static int calcularFitness(int[] individuo) {
        int fitness = 0;
        for (int j = 0; j < individuo.length; j++) {
            if (j + 1 != individuo.length) {
                fitness = fitness + MATRIZ_ADJACENTE[individuo[j]][individuo[j + 1]];
            } else {
                fitness = fitness + MATRIZ_ADJACENTE[individuo[j]][individuo[0]];
            }
        }
        return fitness;
    }

    // TODO TEMPORÁRIO, MUDAR PARA O QUICK_SORT
    private static int[][] ordenar(int[][] populacao, int[] fitness) {

        // ordenando
        int i, i2;
        for (i = 0; i < populacao.length; i++) {
            for (i2 = i; i2 < populacao.length; i2++) {
                if (fitness[i] > fitness[i2]) {
                    int vTmp = fitness[i];
                    fitness[i] = fitness[i2];
                    fitness[i2] = vTmp;

                    int[] vvTmp = populacao[i];
                    populacao[i] = populacao[i2];
                    populacao[i2] = vvTmp;
                }
            }
        }
        return populacao;
    }

    private static int[] preencheVetorSemOR(int[] vetorDeIndices, int r) {

        int[] vetAux = new int[vetorDeIndices.length - 1];
        int cont = 0;
        for (int j = 0; j < vetorDeIndices.length; j++) {
            if (j == r) {
                continue;
            }
            vetAux[cont] = vetorDeIndices[j];
            cont++;
        }
        vetorDeIndices = vetAux;
        return vetorDeIndices;
    }

    private static void imprimir(int[][] populacao, int[] fitness) {

        for (int j = 0; j < populacao.length; j++) {

            System.out.print("Rota " + j + " = ");
            for (int i = 0; i < MATRIZ_ADJACENTE.length; i++) {
                System.out.print(" " + populacao[j][i] + " ");
            }
            System.out.println(" fitness = " + fitness[j]);
        }

    }

    private static boolean estaContido(int[] vet, int i) {
        for (int j = 0; j < vet.length; j++) {
            if (vet[j] == i)
                return true;
        }
        return false;
    }

    //    @Test
    public static int[][] crossoverCX(int roleta, int[][] populacaoInicial) {

        int[][] novaPopulacao = populacaoInicial;

        int[] pai1 /*ou pai selecionado*/ = populacaoInicial[roleta];
        for (int c = 1; c < populacaoInicial.length; c++) {
            if (c != roleta) {
                if (new Random().nextInt(99) < 84) {

                    int[] pai2 = populacaoInicial[c];


                    int[] filho1 = pai1;
                    int[] filho2 = pai2;

                    int[] primeiraMetade = new int[pai1.length / 2];
                    int[] segundaMetade = new int[pai1.length / 2];

                    //preenche primeira metade do cromossomo (ou indivíduo) com os genes do pai1
                    for (int i = 0; i < pai1.length / 2; i++) {
                        primeiraMetade[i] = pai1[i];
                    }

                    //preenche segunda metade do cromossomo (ou indivíduo) com os genes (na sequência) do pai2 que não estão no pai1
                    int cont = 0;
                    for (int i = 0; i < pai2.length; i++) {
                        if (estaContido(primeiraMetade, pai2[i])) {
                            continue;
                        } else {
                            segundaMetade[cont] = pai2[i];
                            cont++;
                        }
                    }

                    cont = 0;
                    for (int i = filho1.length / 2; i < filho1.length; i++) {
                        filho1[i] = segundaMetade[cont];
                        cont++;
                    }


                    //preenche segunda metade do cromossomo (ou indivíduo) com os genes do pai2
                    for (int i = 0; i < pai2.length / 2; i++) {
                        segundaMetade[i] = pai2[i];
                    }

                    //preenche primeira metade do cromossomo (ou indivíduo) com os genes (na sequência) do pai1 que não estão no pai2
                    cont = 0;
                    for (int i = 0; i < pai2.length; i++) {
                        if (estaContido(segundaMetade, pai1[i])) {
                            continue;
                        } else {
                            primeiraMetade[cont] = pai1[i];
                            cont++;
                        }
                    }


                    cont = 0;
                    for (int i = filho2.length / 2; i < filho2.length; i++) {
                        filho2[i] = primeiraMetade[cont];
                        cont++;
                    }


                    //preenche segunda metade do cromossomo (ou indivíduo) com os genes do pai2
                    for (int i = 0; i < pai1.length / 2; i++) {
                        primeiraMetade[i] = pai1[i];
                    }

                    /*if (calcularFitness(filho1) > calcularFitness(populacaoInicial[c])&&calcularFitness(filho2) > calcularFitness(populacaoInicial[c])){
                        continue;

                    }else*/
                    if (estaContido(novaPopulacao, filho1)||estaContido(novaPopulacao, filho2)) {
                        continue;
                    } else if (calcularFitness(filho1) < calcularFitness(filho2)) {
                        novaPopulacao[c] = filho1;
                    } else {
                        novaPopulacao[c] = filho2;
                    }
                }
            }
        }
        populacaoInicial = novaPopulacao;
        return populacaoInicial;
    }


    private int roleta(int[] fitness) {

        // INVERTENDO VETOR **GAMBIA**
        int[] fitnessAux = new int[fitness.length];

        int cont = 0;
        for (int i = fitness.length - 1; i >= 0; i--) {
            fitnessAux[i] = fitness[cont];
            cont++;
        }

        //fazendo a roleta
        int somatoria = 0;

        for (int j = 0; j < TAM_POP; j++) {
            somatoria = somatoria + fitnessAux[j];//this.getMochila(j).getFitness();
        }

        somatoria = new Random().nextInt(somatoria);
        int posicaoEscolhida = -1;
        do {
            posicaoEscolhida++;
            somatoria = somatoria - fitnessAux[posicaoEscolhida];//this.getMochila(posicaoEscolhida).getFitness();
        } while (somatoria > 0);

        return posicaoEscolhida;
    }

    public int[][] mutacao(int[][] populacao) {
        for (int k = 0; k < populacao.length; k++) {
            if (new Random().nextInt(99) < 1) {
                for (int i = 0; i < populacao[k].length; i++) {
                    int aux = populacao[k][i];
                    populacao[k][i] = populacao[k][i + 1];
                    populacao[k][i + 1] = aux;
                    i++;
                }
            } else continue;
        }
        return populacao;
    }


    //DEVE VERIFICAR SE O NOVO FILHO JÁ EXISTE, CASO JÁ EXISTA, ELE IGNORA E PARTE PARA O PRÓXIMO CRUZAMENTO. OU GIRA O PAI E TENTA O CRUZAMENTO NOVAMENTE
    private static boolean estaContido(int[][] populacao, int individuo[]) {
        for (int k = 0; k < populacao.length-1; k++) {
            if (Arrays.equals(populacao[k],individuo)){
                return true;
            }
        }
        return false;
    }

}