
package classes;

import java.sql.Date;
import javax.swing.JOptionPane;

public class Venda extends Pedido{
    //O número da venda é o número do Pedido
    private long numeroCliente;
    private int numeroVenda;
    private Date dataVenda;
    public Venda(){
        cdb = new ConectaDB();
    }
    
    public long getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(long numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public void registrarVenda() {
        String query = "insert into Venda values("
                + ""+this.getNumeroVenda()+", "+this.getNumeroCliente()+", '"+this.getData()+"')";
        if(!cdb.cadastro(query)){
            JOptionPane.showMessageDialog(null, "Problemas ao registrar Venda");
        }
    }
    /**
     * @return the numeroVanda
     */
    public int getNumeroVenda() {
        return numeroVenda;
    }
    /**
     * @param numeroVanda the numeroVanda to set
     */
    public void setNumeroVenda(int numeroVanda) {
        this.numeroVenda = numeroVanda;
    }

    /**
     * @return the dataVenda
     */
    public Date getDataVenda() {
        return dataVenda;
    }

    /**
     * @param dataVenda the dataVenda to set
     */
    public void setData(Date data) {
        this.dataVenda = dataVenda;
    }
}
