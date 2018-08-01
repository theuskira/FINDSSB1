package br.com.icoddevelopers.findssp;

public class ProdutosSupermercado {

    String supermercado;
    String produto;
    String corredor;
    String prateleira;

    public ProdutosSupermercado(){

    }

    public ProdutosSupermercado(String _supermercado, String _produto, String _corredor, String _prateleira){
        this.supermercado = _supermercado;
        this.produto = _produto;
        this.corredor = _corredor;
        this.prateleira = _prateleira;
    }

    public String getSupermercado() {
        return supermercado;
    }

    public void setSupermercado(String supermercado) {
        this.supermercado = supermercado;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getCorredor() {
        return corredor;
    }

    public void setCorredor(String corredor) {
        this.corredor = corredor;
    }

    public String getPrateleira() {
        return prateleira;
    }

    public void setPrateleira(String prateleira) {
        this.prateleira = prateleira;
    }
}
