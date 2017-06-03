
package classes;

import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ItemPedidoCompraAvulsa {

    private int numero;
    private Date data;
    private int numeroCompraAvulsa;
    private String codBarras;
    private int quantidade;
    private double precoUnitario;
    private ConectaDB cdb;
    
    /**
     * @return the numero
     */
    public ItemPedidoCompraAvulsa(){
        cdb = new ConectaDB();
    }
    
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero() throws SQLException {
        this.numero = cdb.gerarNumero("ItemPedidoCompraAvulsa", "numero");
        cdb.closeDB();
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the numeroCompraAvulsa
     */
    public int getNumeroCompraAvulsa() {
        return numeroCompraAvulsa;
    }

    /**
     * @param numeroCompraAvulsa the numeroCompraAvulsa to set
     */
    public void setNumeroCompraAvulsa(int numeroCompraAvulsa) {
        this.numeroCompraAvulsa = numeroCompraAvulsa;
    }

    /**
     * @return the codBarras
     */
    public String getCodBarras() {
        return codBarras;
    }

    /**
     * @param codBarras the codBarras to set
     */
    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the precoUnitario
     */
    public double getPrecoUnitario() {
        return precoUnitario;
    }

    /**
     * @param precoUnitario the precoUnitario to set
     */
    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
    
    /*Trata os dados dos campos numéricos*/
        public static boolean somenteNumeros(String elemento) {
        try{
            long elementoTeste = Long.parseLong(elemento);
            return true;//Só tem números
        }catch(NumberFormatException ex){
            if("".equals(elemento)){/*Nesse caso, vai dar erro por ser vazio. 
             Porém, o campo não é obrigatório. Então, retorna*/
                return true;
            }else{
                return false;
            }
            
        }        
    }

    public void inserir() throws SQLException {
        String query = "insert into ItemPedidoCompraAvulsa values("
                + ""+this.getNumero()+", '"+this.getData()+"', "+this.getNumeroCompraAvulsa()+","
                + "'"+this.getCodBarras()+"', "+this.getQuantidade()+", "+this.getPrecoUnitario()+")";
                if(cdb.cadastro(query)){
                    //JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!");
                }else{
                    JOptionPane.showMessageDialog(null, "Problemas ao inserir ítem!");
                }
                cdb.closeDB();
    }
    
}
