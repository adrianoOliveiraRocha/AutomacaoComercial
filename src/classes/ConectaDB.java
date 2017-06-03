
package classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.Random;

public class ConectaDB {

    private static final String url = "jdbc:mysql://localhost:3306/ac?zeroDateTimeBehavior=convertToNull";
    private static final String user = "root";
    private static final String pass = "453231";

       
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    ResultSetMetaData resultSetMetaData;
    //Para gerar número aleatório pra qualquer ocasião
    public int gerarNumero(String tabela, String campo) throws SQLException{
        int existe = 0;
        //gerar número aleatório
        Random gerador = new Random();
        int numeroAleatorio = 0 + gerador.nextInt(1999999999);
        //montando pesquisa
        String query = "select * from "+tabela+" where "+campo+" = "+numeroAleatorio;
        //JOptionPane.showMessageDialog(null, query);
        ResultSet pesquisaNumero;
        pesquisaNumero = pesquisaDB(query);
        while(pesquisaNumero.next()){
            existe++;
        }
        while(existe != 0){
            gerarNumero(tabela, campo);
        }
        return numeroAleatorio;
        //Criar método que fecha o resultSet
    }
    //Para qualquer pesquisa
    public ResultSet pesquisaDB(String query) {
        try{
            connection = DriverManager.getConnection(url, user, pass);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        }catch(SQLException se){
            JOptionPane.showMessageDialog(null, "Houve um erro! Entre em contato com o desenvolvedor\n"
                    + "Código do erro!"+se.getErrorCode()+"\n"+se.getMessage());
        }
        return resultSet;
    }
    //Para qualquer cadastro
    public boolean cadastro(String query){
        
        try{
            connection = DriverManager.getConnection(url, user, pass);
            statement = connection.createStatement();
            statement.execute(query);
            return true;
        }catch(SQLException se){
            JOptionPane.showMessageDialog(null, "Houve um erro! Entre em contato com o Desenvolvedor\n"
                    + "Código do erro!"+se.getErrorCode()+"\n"+se.getMessage()+
                    "\nCausa "+se.getCause());
            return false;
        }
        
    }

    public boolean verificarDisponibilidadeDeCodigo(String tabela, String campo, String codigo) throws SQLException {
        ResultSet pesquisaNumero; int existe = 0;
        String query = "select * from "+tabela+" where "+campo+" = '"+codigo+"' ";
        pesquisaNumero = pesquisaDB(query);
        while(pesquisaNumero.next()){
            existe++;
        }
        if(existe > 0){
            return false;//Não está disponível
        }
        return true;//Está disponível
    }
    
    //public pesquisaCodBarras

    public ResultSet verificarCodBarras(String codbarras) {
        String query = "select * from Produto where codBarras = '"+codbarras+"'";
        ResultSet resposta = pesquisaDB(query);
        return resposta;
    }

    public void closeDB() throws SQLException {
        try{
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch(Exception exception){
            JOptionPane.showMessageDialog(null, "Erro ao fechar componentes sql");
        }
    }
    /*Gera número de compra ou venda*/
    int gerarNumeroPedido(String pedido, String numero, Date data) throws SQLException {
        int existe = 0;
        //gerar número aleatório
        Random gerador = new Random();
        int numeroAleatorio = 0 + gerador.nextInt(1999999999);
        //montando pesquisa
        String query = "select * from "+pedido+" where "+numero+" = "+numeroAleatorio+ " and data = "+data;
        
        ResultSet pesquisaNumero;
        pesquisaNumero = pesquisaDB(query);
        while(pesquisaNumero.next()){
            existe++;
        }
        while(existe != 0){
            gerarNumeroPedido(pedido, numero, data);
        }
        return numeroAleatorio;
        //Criar método que fecha o resultSet
    }
}
