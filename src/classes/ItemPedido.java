    
package classes;

import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ItemPedido {
    /*PK tripla*/
    private int numero;
    private int numeroPedido;//FK liga à Pedido
    private String codBarras;//FK liga à Produto
    /*PK tripla*/
    private Date dataPedido;
    private int quantidade;
    private ConectaDB cdb;
    public ItemPedido(){
        cdb = new ConectaDB();
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero() throws SQLException {
        this.numero = cdb.gerarNumero("ItemPedido", "numero");
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) throws SQLException {
        this.numeroPedido = numeroPedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }
    
    public void registrarItem(){
        String query = "insert into ItemPedido values("
                + ""+this.getNumero()+", "+this.getNumeroPedido()+", '"+this.getCodBarras()+"', "
                + "'"+this.getDataPedido()+"', "+this.getQuantidade()+")";
        if(!cdb.cadastro(query)){
            JOptionPane.showMessageDialog(null, "Problemas ao Registrar ítem");
        }
    }
}
