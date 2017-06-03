
package classes;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class Sessao {

    private int numero;
    private Date data;
    private String codigoFuncionario;
    private double valorTotal;
    private String horaInicio;
    private String horaFim;
    
    private ConectaDB cdb;
    
    public Sessao(){
        cdb = new ConectaDB();
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero() throws SQLException {
        this.setNumero(getCdb().gerarNumero("Sessao", "numero"));
    }

    public Date getData() {
        return data;
    }

    public void setData() {
        this.setData(new Date(System.currentTimeMillis()));
    }

    public String getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(String codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio() {
        this.horaInicio = obterHora();
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim() {
        this.horaFim = obterHora();
    }

    public ConectaDB getCdb() {
        return cdb;
    }
  
  

    public void registrarSessao() {
        String query = "insert into Sessao values("
                + ""+this.getNumero()+", '"+this.getData()+"', '"+this.getHoraInicio()+"', "
                + ""+null+", "+this.getCodigoFuncionario()+", "+this.getValorTotal()+")";
        if(!cdb.cadastro(query)){
            JOptionPane.showMessageDialog(null, "Problema ao registrar a sessão");
        }
    }
    
    public String obterHora(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");   
        return String.valueOf(dateFormat.format( new java.util.Date() ));
    }

    public void registrarHoraFim(int numeroSessao) throws SQLException {
        
        String configuraHoraFimSessao = "update Sessao set horaFim = '"+this.getHoraFim()+"' "+
                "where numero = "+numeroSessao+"";
        cdb.cadastro(configuraHoraFimSessao);
        cdb.closeDB();
    }

    public void atualizarValortotalSessao(double valorTotalVendas, double valorInicialDouble, 
            int numeroSessao) throws SQLException {
        double valorFinal = valorTotalVendas + valorInicialDouble;
        String SValorFinal = "update Sessao set valorTotal = '"+valorFinal+"' "+
                "where numero = "+numeroSessao+"";
        cdb.cadastro(SValorFinal);
        cdb.closeDB();
    }
    
}
