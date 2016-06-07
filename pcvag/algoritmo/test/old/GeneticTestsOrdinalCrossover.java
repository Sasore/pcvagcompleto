package old;

import junit.framework.Assert;
import models.Aresta;
import models.Commons;
import models.Rota;
import org.junit.Test;

/**
 * Created by emanuelvictor on 07/09/14.
 */
public class GeneticTestsOrdinalCrossover {


    //TODO o crossover vai funcionar da seguinte maneira:
    //Serão cruzados os genes, ou seja, cada  número.
    // O primeiro filho será posto em uma primeira nova rota e o segundo filho em uma segunda nova rota
    // Se 20 rotas forem cruzadas logo serão formadas 40, dessas quarenta 20 serão selecionadas para próxima geração




//    private Rota[] testCrossoverCXRotas(Rota rotaPai1, Rota rotaPai2) {
//
//
//        Rota rotaFilho1 = new Rota();
//        Rota rotaFilho2 = new Rota();
//
//        for (int i = 0; i < rotaPai1.getArestas().length; i++) {
////            Rota[] r = crossoverCromossomeCX(rotaPai1.getArestas()[0].getCusto(),rotaPai2.getArestas()[1].getCusto());
//        }
//        Rota[] rotas = new Rota[2];
//
//        rotas[0] = rotaPai1;
//        rotas[1] = rotaPai2;
//        return rotas;
//
//    }


//    @Test
//    public /*int[]*/ void crossoverCromossomeCX(/*int pai1,int pai2*/) {
//
//        int pai1 = 5; int pai2 = 15;
////        System.out.println("Pai 1 = " + pai1+" Pai 2 = " + pai2);
//
//        String stringCromossomoA = this.completeBinaryCX(Integer.toBinaryString(pai1));
//
//
//
//        String stringCromossomoB = this.completeBinaryCX(Integer.toBinaryString(pai2));
//
//        System.out.println("Pai 1 = " + stringCromossomoA +" = "+ pai1+" Pai 2 = " + stringCromossomoB +" = "+ pai2);
//        String strFilho1 = stringCromossomoA.substring(0, 4)+stringCromossomoB.substring(4,8);
//        String strFilho2 = stringCromossomoB.substring(0, 4)+stringCromossomoA.substring(4,8);
//
//
//        int filho1 = Integer.parseInt(strFilho1, 2);
//        int filho2 = Integer.parseInt(strFilho2, 2);
//
//
//        System.out.println("Filho 1 = " + strFilho1 +" = "+ filho1+" Filho 2 = " + strFilho2 +" = "+ filho2);
//
////        System.out.println("Filho 1 = " + filho1+" Filho 2 = " + filho2);
//
////        return filhos;
//    }

//    private String completeBinaryCX(String b) {
//        StringBuffer aux = new StringBuffer();
//        if (b.length() < 8) {
//            int cont = 8 - b.length();
//            for (int j = 0; j < cont; j++) {
//                aux.append("0");
//            }
//            aux.append(b);
//        }
//        return aux.toString();
//    }
//
//    private int[] crossoverCromossomeOX(int pai1,int pai2) {
//        int[] filhos = new int[2];
//
//        filhos[0] = pai1;
//
//        filhos[1] = pai2;
//
//        return filhos;
//    }

//    private String completeBinaryOX(String b) {
//        StringBuffer aux = new StringBuffer();
//        if (b.length() < 10) {
//            int cont = 10 - b.length();
//            for (int j = 0; j < cont; j++) {
//                aux.append("0");
//            }
//            aux.append(b);
//        }
//        return aux.toString();
//    }
//
//
//    private Rota[] getRotas(){
//        int[][] identicalAdjacentArray = Commons.IDENTICAL_ADJACENT_ARRAY;
//
//        Rota[] rotas = new Rota[Commons.IDENTICAL_ADJACENT_ARRAY.length];
//
//
//        for (int i = 0; i < Commons.IDENTICAL_ADJACENT_ARRAY.length; i++) {
//            Aresta[] arestas = new Aresta[Commons.IDENTICAL_ADJACENT_ARRAY.length];
//            for (int j = 0; j < rotas.length; j++) {
//                arestas[j] = new Aresta(i, j, identicalAdjacentArray[i][j]);
//
//            }
//
//            rotas[i] = new Rota(arestas);
//        }
//        return rotas;
//
//    }
//
//    @Test
//    public void testEquals() {
//        int[][] identicalAdjacentArray = Commons.IDENTICAL_ADJACENT_ARRAY;
//
//        Rota[] rotas = new Rota[Commons.IDENTICAL_ADJACENT_ARRAY.length];
//
//
//        for (int i = 0; i < Commons.IDENTICAL_ADJACENT_ARRAY.length; i++) {
//            Aresta[] arestas = new Aresta[Commons.IDENTICAL_ADJACENT_ARRAY.length];
//            for (int j = 0; j < rotas.length; j++) {
//                arestas[j] = new Aresta(i, j, identicalAdjacentArray[i][j]);
//
//            }
//
//            rotas[i] = new Rota(arestas);
//        }
//
//
//        for (int j = 0; j < Commons.IDENTICAL_ADJACENT_ARRAY.length; j++) {
//            System.out.print(rotas[j].toString());
//            System.out.println(" ");
//        }
//        Rota rota1 = rotas[0];
//        Rota rota2 = rotas[3];
//
//
//        Assert.assertEquals(rota1, rotas[0]);
//    }


}
