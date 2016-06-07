import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by emanuelvictor on 19/09/14.
 */
public class Executor {
    private final static SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");

    private int[][] populacao = AlgoritmoGenetico.gerarPopulacaoAleatoria(25, Matriz.MATRIZ_18_CIDADES);


    private static int[][] initResultados(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = 999999;
            }
        }
        return matriz;
    }

    /**
     * Lista de melhores fitness
     * Para a matriz de 06 cidades a melhor rota possível é = 0  1  4  3  2  5 com fitness = 110
     * Para a matriz de 09 cidades a melhor rota possível é = 1  0  7  8  4  3  2  5  6  com fitness = 120
     * Para a matriz de 12 cidades a melhor rota possível é = 0  1  6  5  2  4  3  11  10  9  8  7   com fitness = 147
     * Para a matriz de 18 cidades a melhor rota possível é = 0  1  6  5  2  4  3  15  17  16  14  12  11  10  8  7   com fitness = 200
     */


    @Test
    public void testesFinais() {

        int[][] matrizDeResultados = new int[5][4];



        AlgoritmoGenetico algoritmo = new AlgoritmoGenetico();
        algoritmo.setFitnessASerEncontrado(200);
        algoritmo.setMatrizAdjacente(Matriz.MATRIZ_18_CIDADES);
        algoritmo.setNumeroDeGeracoes(50);
        algoritmo.setTamanhoDaPopulacao(25);
        algoritmo.setElitismo(30);


        int taxaCrossover = 80;
        Calendar calendarInit1 = Calendar.getInstance();
        initResultados(matrizDeResultados);
        Crossover crossover = Crossover.PMX;



        System.out.println("   Teste com crossover "+crossover);
        System.out.println("   Mutaçao        2%  4%  6%  8% 10%");
        for (int i = 0; i < 4; i++) {
            taxaCrossover = taxaCrossover + 5;
            if (taxaCrossover==100)
                System.out.print("Crossover "+taxaCrossover + "% =");
            else
                System.out.print(" Crossover "+taxaCrossover + "% =");
            int taxaMutacao = 2;
            for (int j = 0; j < 5; j++) {
                int[][] popAux = new int[populacao.length][populacao[0].length];
                for (int c = 0; c < populacao.length; c++) {
                    for (int f = 0; f < populacao[c].length; f++) {
                        popAux[c][f] = populacao[c][f];
                    }
                }
                for (int k = 0; k < 100; k++) {
                    algoritmo.setCrossover(crossover);
                    algoritmo.setTaxaDeCrossover(taxaCrossover);
                    algoritmo.setTaxaDeMutacao(taxaMutacao);

                    int resultado = algoritmo.execute(popAux);
                    if (resultado < matrizDeResultados[j][i]) {
                        matrizDeResultados[j][i] = resultado;
                    }
                }
                System.out.print(" " + matrizDeResultados[j][i]);
                taxaMutacao = taxaMutacao + 2;
            }
            System.out.println();

        }

        System.out.println("   Iniciou em " + df.format(calendarInit1.getTime()) + " e terminou em " + df.format(Calendar.getInstance().getTime()));
        System.out.println("____________________________________________________");


        taxaCrossover = 80;
        Calendar calendarInit2 = Calendar.getInstance();
        initResultados(matrizDeResultados);
        crossover = Crossover.OX;
        System.out.println("   Teste com crossover "+crossover);
        System.out.println("   Mutaçao        2%  4%  6%  8% 10%");
        for (int i = 0; i < 4; i++) {
            taxaCrossover = taxaCrossover + 5;
            if (taxaCrossover==100)
                System.out.print("Crossover "+taxaCrossover + "% =");
            else
                System.out.print(" Crossover "+taxaCrossover + "% =");
            int taxaMutacao = 2;
            for (int j = 0; j < 5; j++) {
                int[][] popAux = new int[populacao.length][populacao[0].length];
                for (int c = 0; c < populacao.length; c++) {
                    for (int f = 0; f < populacao[c].length; f++) {
                        popAux[c][f] = populacao[c][f];
                    }
                }
                for (int k = 0; k < 100; k++) {
                    algoritmo.setCrossover(crossover);
                    algoritmo.setTaxaDeCrossover(taxaCrossover);
                    algoritmo.setTaxaDeMutacao(taxaMutacao);

                    int resultado = algoritmo.execute(popAux);
                    if (resultado < matrizDeResultados[j][i]) {
                        matrizDeResultados[j][i] = resultado;
                    }
                }
                System.out.print(" " + matrizDeResultados[j][i]);
                taxaMutacao = taxaMutacao + 2;
            }
            System.out.println();
        }


        System.out.println("   Iniciou em " + df.format(calendarInit2.getTime()) + " e terminou em " + df.format(Calendar.getInstance().getTime()));
        System.out.println("____________________________________________________");


        taxaCrossover = 80;
        Calendar calendarInit3 = Calendar.getInstance();
        initResultados(matrizDeResultados);
        crossover = Crossover.PMX;
        System.out.println("   Teste com crossover "+crossover);
        System.out.println("   Mutaçao        0%  0%  0%  0%  0%");
        for (int i = 0; i < 4; i++) {
            taxaCrossover = taxaCrossover + 5;
            if (taxaCrossover==100)
                System.out.print("Crossover "+taxaCrossover + "% =");
            else
                System.out.print(" Crossover "+taxaCrossover + "% =");
            for (int j = 0; j < 5; j++) {
                int[][] popAux = new int[populacao.length][populacao[0].length];
                for (int c = 0; c < populacao.length; c++) {
                    for (int f = 0; f < populacao[c].length; f++) {
                        popAux[c][f] = populacao[c][f];
                    }
                }
                for (int k = 0; k < 100; k++) {
                    algoritmo.setCrossover(crossover);
                    algoritmo.setTaxaDeCrossover(taxaCrossover);
                    algoritmo.setTaxaDeMutacao(0);

                    int resultado = algoritmo.execute(popAux);
                    if (resultado < matrizDeResultados[j][i]) {
                        matrizDeResultados[j][i] = resultado;
                    }
                }
                System.out.print(" " + matrizDeResultados[j][i]);
            }
            System.out.println();

        }

        System.out.println("   Iniciou em " + df.format(calendarInit3.getTime()) + " e terminou em " + df.format(Calendar.getInstance().getTime()));
        System.out.println("____________________________________________________");


        taxaCrossover = 80;
        Calendar calendarInit4 = Calendar.getInstance();
        initResultados(matrizDeResultados);
        crossover = Crossover.OX;
        System.out.println("   Teste com crossover "+crossover);
        System.out.println("   Mutaçao        0%  0%  0%  0%  0%");
        for (int i = 0; i < 4; i++) {
            taxaCrossover = taxaCrossover + 5;
            if (taxaCrossover==100)
                System.out.print("Crossover "+taxaCrossover + "% =");
            else
                System.out.print(" Crossover "+taxaCrossover + "% =");
            for (int j = 0; j < 5; j++) {
                int[][] popAux = new int[populacao.length][populacao[0].length];
                for (int c = 0; c < populacao.length; c++) {
                    for (int f = 0; f < populacao[c].length; f++) {
                        popAux[c][f] = populacao[c][f];
                    }
                }
                for (int k = 0; k < 100; k++) {
                    algoritmo.setCrossover(crossover);
                    algoritmo.setTaxaDeCrossover(taxaCrossover);
                    algoritmo.setTaxaDeMutacao(0);

                    int resultado = algoritmo.execute(popAux);
                    if (resultado < matrizDeResultados[j][i]) {
                        matrizDeResultados[j][i] = resultado;
                    }
                }
                System.out.print(" " + matrizDeResultados[j][i]);
            }
            System.out.println();
        }
        System.out.println("   Iniciou em " + df.format(calendarInit4.getTime()) + " e terminou em " + df.format(Calendar.getInstance().getTime()));
        System.out.println("____________________________________________________");
    }
    @Test
    public void TEST(){

        Calendar calendarInitPMX = Calendar.getInstance();
        int[][] popAux = new int[populacao.length][populacao[0].length];
        for (int c = 0; c < populacao.length; c++) {
            for (int f = 0; f < populacao[c].length; f++) {
                popAux[c][f] = populacao[c][f];
            }
        }
        AlgoritmoGenetico algoritmo = new AlgoritmoGenetico();
        algoritmo.setFitnessASerEncontrado(200);
        algoritmo.setMatrizAdjacente(Matriz.MATRIZ_18_CIDADES);
        algoritmo.setNumeroDeGeracoes(500000);
        algoritmo.setTamanhoDaPopulacao(25);
        algoritmo.setElitismo(0);
        algoritmo.setCrossover(Crossover.PMX);
        algoritmo.imprimirEvolucao(true);
        algoritmo.setTaxaDeCrossover(85);
        algoritmo.setTaxaDeMutacao(2);
        algoritmo.execute(popAux);

        System.out.println("CROSSOVER PMX   Iniciou em " + df.format(calendarInitPMX.getTime()) + " e terminou em " + df.format(Calendar.getInstance().getTime()));

        popAux = new int[populacao.length][populacao[0].length];
        for (int c = 0; c < populacao.length; c++) {
            for (int f = 0; f < populacao[c].length; f++) {
                popAux[c][f] = populacao[c][f];
            }
        }

        Calendar calendarInitOX = Calendar.getInstance();
        algoritmo = new AlgoritmoGenetico();
        algoritmo.setFitnessASerEncontrado(200);
        algoritmo.setMatrizAdjacente(Matriz.MATRIZ_18_CIDADES);
        algoritmo.setNumeroDeGeracoes(500000);
        algoritmo.setTamanhoDaPopulacao(25);
        algoritmo.setElitismo(0);
        algoritmo.setCrossover(Crossover.OX);
        algoritmo.imprimirEvolucao(true);
        algoritmo.setTaxaDeCrossover(85);
        algoritmo.setTaxaDeMutacao(2);
        algoritmo.execute(popAux);

        System.out.println("CROSSOVER OX   Iniciou em " + df.format(calendarInitOX.getTime()) + " e terminou em " + df.format(Calendar.getInstance().getTime()));
    }


    @Test
    public void testMatriz9(){
        AlgoritmoGenetico algoritmo = new AlgoritmoGenetico();
        algoritmo.setFitnessASerEncontrado(120);
        algoritmo.setMatrizAdjacente(Matriz.MATRIZ_09_CIDADES);
        algoritmo.setNumeroDeGeracoes(null);
        algoritmo.setTamanhoDaPopulacao(50);
        algoritmo.setCrossover(Crossover.PMX);
        algoritmo.imprimirEvolucao(true);
        algoritmo.setTaxaDeCrossover(100);
        algoritmo.setTaxaDeMutacao(2);
        int [][] pop = AlgoritmoGenetico.gerarPopulacaoAleatoria(50, Matriz.MATRIZ_09_CIDADES);
        algoritmo.execute(pop);
    }
}
