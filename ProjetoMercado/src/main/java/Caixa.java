public class Caixa {
    private Cliente cliente;
    private Carrinho carrinho;
    private String tipoPagamento;

    public Caixa(Cliente cliente, String tipoPagamento) {
        this.cliente = cliente;
        this.tipoPagamento = tipoPagamento;
    }

    
    
    public double totalCompra(Carrinho car){
        return 0.0;
    }
    
    public void fazPagamento(String tipoPagamento){
        
    }
    
    public boolean checaFidelidade(Cliente cli){
        return true;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }
    
    
}