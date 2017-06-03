
package classes;

public class Compra extends Pedido{

   //O número da compra é o número do Pedido
    private int numeroFornecedor;
    private int numeroRepresentante;

    
    public int getNumeroFornecedor() {
        return numeroFornecedor;
    }

    public void setNumeroFornecedor(int numeroFornecedor) {
        this.numeroFornecedor = numeroFornecedor;
    }

    public int getNumeroRepresentante() {
        return numeroRepresentante;
    }

    public void setNumeroRepresentante(int numeroRepresentante) {
        this.numeroRepresentante = numeroRepresentante;
    }
    
}
