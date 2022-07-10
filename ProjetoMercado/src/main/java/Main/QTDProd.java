package Main;

//Folly
public enum QTDProd {
    ESTOQUE(20),
    PRATELEIRA(10);
    
    private final int valor;
    
    QTDProd(final int novoValor){
        valor = novoValor;
    }
    
    public int getQtd(){
        return valor;
    }
}