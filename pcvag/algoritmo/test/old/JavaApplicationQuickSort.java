package old;

/**
 * Created by emanuelvictor on 09/09/14.
 */
public class JavaApplicationQuickSort {


    // @param args the command line arguments

    public static int[][] vetor = {
                                  /*0*/  {56,0},
                                  /*1*/  {446,1},
                                  /*2*/  {389,2},
                                  /*3*/  {18,3},
                                  /*4*/  {446,4},
                                  /*5*/  {17,5},
                                  /*6*/  {493,6},
                                  /*7*/  {186,7},
                                  /*8*/  {455,8},
                                  /*9*/  {94,9},
                                  /*10*/ {374,10},
                                  /*11*/ {119,11},
                                  /*12*/ {81,12},
                                  /*13*/ {250,13},
                                  /*14*/ {496,14},
                                  /*15*/ {84,15},
                                  /*16*/ {129,16},
                                  /*17*/ {73,17},
                                  /*18*/ {414,18},
                                  /*19*/ {156,19},
                                  /*20*/ {199,20},
                                  /*21*/ {84,21},
                                  /*22*/ {17,22},
                                  /*23*/ {16,23},
                                  /*24*/ {56,24}
    };

    public static void main(String[] args) {
        // TODO code application logic here

        System.out.print("Vetor de Entrada: ");
        imprime(vetor);
        quick_sort(vetor,0, vetor.length - 1);
        System.out.print("\nVetor Ordenado: ");
        imprime(vetor);
    }

    public static void imprime(int[][] aux) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(" " + aux[i][0]);
            System.out.print(" (" + aux[i][1]+") ");
        }
    }


    public static void quick_sort(int[][] v, int ini, int fim) {
        int meio;

        if (ini < fim) {
            meio = partition(v, ini, fim);
            quick_sort(v, ini, meio);
            quick_sort(v, meio + 1, fim);
        }
    }

    public static int partition(int[][] v, int ini, int fim) {
        int pivo, topo, i;
        pivo = v[ini][0];
        topo = ini;

        for (i = ini + 1; i <= fim; i++) {
            if (v[i][0] < pivo) {
                v[topo] = v[i];
                v[i] = v[topo + 1];
                topo++;
            }
        }
        v[topo][0] = pivo;
        return topo;
    }
}