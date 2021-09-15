package entities;

public class Componente extends Produto {

    private String tipo;
    private String Requisitos;

    public Componente(int codigo, String nome, String descricao, double valor, String tipo, String requisitos) {
        super(codigo, nome, descricao, valor);
        this.tipo = tipo;
        Requisitos = requisitos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRequisitos() {
        return Requisitos;
    }

    public void setRequisitos(String requisitos) {
        Requisitos = requisitos;
    }
}
