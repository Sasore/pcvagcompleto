package models;

/**
 * Created by emanuelvictor on 07/09/14.
 */
public class Aresta {
    private int origem;
    private int destino;
    private int custo;


    public Aresta(int origem, int destino, int custo) {
        this.origem = origem;
        this.destino = destino;
        this.custo = custo;
    }

    public int getOrigem() {
        return origem;
    }

    public void setOrigem(int origem) {
        this.origem = origem;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    @Override
    public String toString() {
        return "Aresta{" +
                "origem=" + origem +
                ", destino=" + destino +
                ", custo=" + custo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aresta)) return false;

        Aresta aresta = (Aresta) o;

        if (custo != aresta.custo) return false;
        if (destino != aresta.destino) return false;
        if (origem != aresta.origem) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = origem;
        result = 31 * result + destino;
        result = 31 * result + custo;
        return result;
    }
}