package entities;

import java.util.List;

public class Kit extends Produto {

    private List<Produto> componentes;

    public Kit(int codigo, String nome, String descricao, double valor, List<Produto> componentes) {
        super(codigo, nome, descricao, valor);
        this.componentes = componentes;
    }

    public List<Produto> getComponentes() {
        return componentes;
    }
}
