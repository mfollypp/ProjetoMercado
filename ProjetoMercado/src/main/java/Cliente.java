public class Cliente {
    private boolean fidelidade;
    private Carrinho carrinho;

    public Cliente(boolean fidelidade) {
        this.fidelidade = fidelidade;
        
    }

    
    
    public void criaFidelidade(){
        
    }
    
    public void fechaCompra(Carrinho car){
        
    }
    
    public void setFidelidade(boolean fidelidade) {
        this.fidelidade = fidelidade;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public boolean getFidelidade() {
        return fidelidade;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }   
    
}