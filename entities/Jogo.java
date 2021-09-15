package entities;

public class Jogo extends Produto {

    private String requisitos;

    public Jogo(int codigo, String nome, String descricao, double valor, String requisitos) {
        super(codigo, nome, descricao, valor);
        this.requisitos = requisitos;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }
}
