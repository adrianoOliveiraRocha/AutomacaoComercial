package classes;

import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ContaReceber {

    private ConectaDB cdb;
    
    private int numero;
    private int numeroVenda;
    private Date dataVenda;

    public ContaReceber(){
        cdb = new ConectaDB();
    }
    
    /**
     * @param numero the numero to set
     */
    public void setNumero() throws SQLException {
        this.numero = cdb.gerarNumero("ContaReceber", "numero");
    }

    /**
     * @param numeroVenda the numeroVenda to set
     */
    public void setNumeroVenda(int numeroVenda) {
        this.numeroVenda = numeroVenda;
    }

    /**
     * @param dataVenda the dataVenda to set
     */
    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the numeroVenda
     */
    public int getNumeroVenda() {
        return numeroVenda;
    }

    /**
     * @return the dataVenda
     */
    public Date getDataVenda() {
        return dataVenda;
    }

    public void registrar() {
        String query ="insert into ContaReceber values("+this.getNumero()+", "
                + ""+this.getNumeroVenda()+", '"+this.getDataVenda()+"')";
        if(!cdb.cadastro(query)){    
            JOptionPane.showMessageDialog(null, "Problemas ao registrar conta a receber!");
        }
    }
}