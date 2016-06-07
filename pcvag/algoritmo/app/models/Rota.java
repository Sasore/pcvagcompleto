package models;

import java.util.Arrays;

/**
 * Created by emanuelvictor on 07/09/14.
 */
public class Rota {



    private Aresta[] arestas = new Aresta[]{};

    private int custo;

    public Rota() {
    }

    public Rota(Aresta[] arestas) {
        this.arestas = arestas;
    }

    public Aresta[] getArestas() {
        return arestas;
    }

    public void setArestas(Aresta[] arestas) {
        this.arestas = arestas;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public final int custoTotal() {
        custo = 0;
        for (int i = 0; i < arestas.length; i++) {
            custo = custo + arestas[i].getCusto();
        }
        return custo;
    };

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();

        for (int j = 0; j < arestas.length; j++) {
            stringBuffer.append(arestas[j].getCusto() + " ");
        }

        stringBuffer.append(" Custo Total = " + custoTotal());
        return stringBuffer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rota)) return false;

        Rota rota = (Rota) o;

        if (custo != rota.custo) return false;
        if (!Arrays.equals(arestas, rota.arestas)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(arestas);
        result = 31 * result + custo;
        return result;
    }
}
