
package classes;

import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CompraAvulsa {
    private ConectaDB cdb;
    private int numero;
    private Date data;
    private String codigoFuncionario;
    private String numeroFornecedor;
    private String numeroRepresentante;
    private double desconto;
    
    public CompraAvulsa() throws SQLException{
        cdb = new ConectaDB();
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
    public void setNumero() throws SQLException {
        this.numero = cdb.gerarNumero("CompraAvulsa", "numero");
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
    public void setData() {
        this.data = new Date(System.currentTimeMillis());;
    }

    /**
     * @return the numeroFornecedor
     */
    public String getNumeroFornecedor() {
        return numeroFornecedor;
    }

    /**
     * @param numeroFornecedor the numeroFornecedor to set
     */
    public void setNumeroFornecedor(String numeroFornecedor) {
        this.numeroFornecedor = numeroFornecedor;
    }

    /**
     * @return the numeroRepresentante
     */
    public String getNumeroRepresentante() {
        return numeroRepresentante;
    }

    /**
     * @param numeroRepresentante the numeroRepresentante to set
     */
    public void setNumeroRepresentante(String numeroRepresentante) {
        this.numeroRepresentante = numeroRepresentante;
    }

    /**
     * @return the desconto
     */
    public double getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    /**
     * @return the codigoFuncionario
     */
    public String getCodigoFuncionario() {
        return codigoFuncionario;
    }

    /**
     * @param codigoFuncionario the codigoFuncionario to set
     */
    public void setCodigoFuncionario(String codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }
    
    public String trataVirgula(String text) {
        text = text.replaceAll(",", ".");
        return text;
    }

    public void salvarCompraAvulsa() throws SQLException {
        
        String query = "insert into CompraAvulsa values("+this.getNumero()+", '"+this.getData()+"', "
                + "'"+this.getCodigoFuncionario()+"', "+this.getNumeroFornecedor()+", "
                + ""+this.getNumeroRepresentante()+", "+this.getDesconto()+")";
                
        if(cdb.cadastro(query)){
            /*Os dados principais da compra vulsa são salvos logo depois da abertura da TelaRealizarCompraAvulsa
             Isso acontece porque, para que os itens sejam salvos, esses dados principais devem existir
             no BD*/
        }else{
            JOptionPane.showMessageDialog(null, "Problemas ao Salvar Dados iniciais da Compra!\n"
            +"Entre em cnontato com o Desenvolvedor");
        }
        cdb.closeDB();
    }
    
}
