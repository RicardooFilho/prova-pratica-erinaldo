package ex1;

public class Item {

    private String nome;
    private Double preco;
    private Integer qtdeEstoque;

    private Boolean adicionado = true;

    public Item(String nome, Double preco, Integer qtdeEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.qtdeEstoque = qtdeEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Boolean getAdicionado() {
        return adicionado;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQtdeEstoque() {
        return qtdeEstoque;
    }

    public void setQtdeEstoque(Integer qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }

    public void setAdicionado(Boolean adicionado) {
        this.adicionado = adicionado;
    }

    @Override
    public String toString() {
        return  "Nome: " + nome +
                ", Preco: " + preco +
                ", Quantidade no Estoque: " + qtdeEstoque +
                ',' + (adicionado ? " Adicionado" : " Removido");
    }
}
