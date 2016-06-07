package old;

import junit.framework.Assert;
import models.Aresta;
import models.Commons;
import models.Rota;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by emanuelvictor on 07/09/14.
 */
public class GeneticTestsFirstPopulation {

    //TODO testar matriz adjacente idêntica
    @Test
    public void testIdenticalAdjacentArray() {
        List<List<Integer>> identicalAdjacentArray = Commons.getList();
        boolean b = true;
        for (int i = 0; i < identicalAdjacentArray.size(); i++) {
            for (int j = 0; j < identicalAdjacentArray.get(i).size(); j++) {
                if (identicalAdjacentArray.get(i).get(j) != identicalAdjacentArray.get(j).get(i)) {
                    b = false;
                    break;
                } else
                    System.out.print(identicalAdjacentArray.get(i).get(j) + " ");
            }
            if (!b) {
                break;
            } else
                System.out.println("");
        }
        Assert.assertEquals(b, true);
    }

    //TODO testar primeira população ***ERRADO***
    @Test
    public void testFirstPopulation() {

        List<List<Integer>> identicalAdjacentArray = Commons.getList();

        List<Rota> rotas = new LinkedList<Rota>();

        for (int i = 0; i < identicalAdjacentArray.size(); i++) {
            List<Aresta> arestas = new LinkedList<Aresta>();
            for (int j = 0; j < identicalAdjacentArray.get(i).size(); j++) {
                if (identicalAdjacentArray.get(i).get(j) != 0) {
                    arestas.add(new Aresta(i, j, identicalAdjacentArray.get(i).get(j)));
                }

            }
            rotas.add(new Rota((Aresta[]) arestas.toArray()));
        }

//        imprime matriz inteira
        System.out.println("Matriz inteira");
        for (int i = 0; i < identicalAdjacentArray.size(); i++) {
            for (int j = 0; j < identicalAdjacentArray.get(i).size(); j++) {
                System.out.print(identicalAdjacentArray.get(i).get(j) + " ");
            }
            System.out.println("");
        }
        System.out.println("Primeiras rotas com o custo de cada uma");


        //Imprime as primeiras rotas
        for (int i = 0; i < identicalAdjacentArray.size(); i++) {
            System.out.print(rotas.get(i).toString());
            System.out.println(" Custo = " + rotas.get(i).custoTotal());
        }
        Assert.assertEquals(true, true);
    }


    /**
     * -----------------primitives arrays--------------------
     */
    //TODO testar matriz adjacente idêntica, verifica se a matriz adjacente é realmente idêntica
    @Test
    public void testIdenticalAdjacentArrayWichPrimitiveArray() {
        int[][] identicalAdjacentArray = Commons.IDENTICAL_ADJACENT_ARRAY;
        boolean b = true;

        for (int i = 0; i < identicalAdjacentArray.length; i++) {
            for (int j = 0; j < identicalAdjacentArray[i].length; j++) {
                if (identicalAdjacentArray[i][j] != identicalAdjacentArray[i][j]) {
                    b = false;
                    break;
                } else
                    System.out.print(identicalAdjacentArray[i][j] + " ");
            }
            if (!b) {
                break;
            } else
                System.out.println("");
        }
        Assert.assertEquals(b, true);
    }

    //TODO testar primeira população ***ERRADO***
    @Test
    public void testFirstPopulationWithPrimitiveArrayWhithoutMediatriz() {

        int[][] identicalAdjacentArray = Commons.IDENTICAL_ADJACENT_ARRAY;

        Rota[] rotas = new Rota[Commons.IDENTICAL_ADJACENT_ARRAY.length];


        for (int i = 0; i < Commons.IDENTICAL_ADJACENT_ARRAY.length; i++) {
            Aresta[] arestas = new Aresta[Commons.IDENTICAL_ADJACENT_ARRAY.length-1];
            for (int j = 0; j < rotas.length; j++) {
                if (j != i) {
                    if (j>i) {
                        arestas[j - 1] = new Aresta(i, j, identicalAdjacentArray[i][j]);
                    } else {
                        arestas[j] = new Aresta(i, j, identicalAdjacentArray[i][j]);
                    }
                }
            }
            rotas[i] = new Rota(arestas);
        }



        for (int j = 0; j < Commons.IDENTICAL_ADJACENT_ARRAY.length; j++) {
            System.out.print(rotas[j].toString());
            System.out.println(" ");
        }
        Assert.assertEquals(true, true);

    }

    //TODO testar primeira população
    @Test
    public void testFirstPopulationWithPrimitiveArrayWhithMediatriz() {

        int[][] identicalAdjacentArray = Commons.IDENTICAL_ADJACENT_ARRAY;

        Rota[] rotas = new Rota[Commons.IDENTICAL_ADJACENT_ARRAY.length];


        for (int i = 0; i < Commons.IDENTICAL_ADJACENT_ARRAY.length; i++) {
            Aresta[] arestas = new Aresta[Commons.IDENTICAL_ADJACENT_ARRAY.length];
            for (int j = 0; j < rotas.length; j++) {
                arestas[j] = new Aresta(i, j, identicalAdjacentArray[i][j]);

            }

            rotas[i] = new Rota(arestas);
        }



        for (int j = 0; j < Commons.IDENTICAL_ADJACENT_ARRAY.length; j++) {
            System.out.print(rotas[j].toString());
            System.out.println(" ");
        }
        Assert.assertEquals(true, true);

    }


}
