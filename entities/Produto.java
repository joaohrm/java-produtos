package entities;

public abstract class Produto {

    private int codigo;
    private String nome;
    private String descricao;
    private double valor;

    public Produto(int codigo, String nome, String descricao, double valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto \""+this.nome+"\" de código #"+this.codigo+" possui o valor de R$ "+this.valor;
    }


}
