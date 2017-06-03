
package classes;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class Pedido {
    protected ConectaDB cdb;
    
    private int numero;
    private int tipo;
    private Date data;
    private double valorTotal = 0;
    private double desconto = 0;
    private String codFuncionario;
    private int numeroSessao;

    public Pedido(){
        cdb = new ConectaDB();
        setData();
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero() throws SQLException {
        this.numero = cdb.gerarNumeroPedido("Pedido", "numero", data);
        cdb.closeDB();
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Date getData() {
        return data;
    }

    public void setData() {
        this.data = new Date(System.currentTimeMillis());
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = this.getValorTotal() + valorTotal - desconto;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        /*Quando há desconto, o valor total é recalculado*/
        this.desconto = desconto;
        double descontoAbsoluto = (desconto/100) * this.getValorTotal();
        this.valorTotal = this.getValorTotal() - descontoAbsoluto;
    }

    public String getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(String codFuncionario) {
        this.codFuncionario = codFuncionario;
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
        
    public boolean verificarExistenciadeFuncionario(String codFucnionario) throws SQLException{
        if(!cdb.verificarDisponibilidadeDeCodigo("Funcionario", "codigoFuncionario", codFucnionario)){
            return true;
        }else{
            return false;    
        }
        
    }
    
    public int getNumeroSessao() {
        return numeroSessao;
    }

    public void setNumeroSessao(int numeroSessao) {
        this.numeroSessao = numeroSessao;
    }

    public void atualizarDesconto(double desconto) {
        
    }

    public void registrarPedido() {
        String query1 = "insert into Pedido values("
        + ""+this.getNumero()+", "+this.getTipo()+", '"+this.getData()+"', "
        + ""+this.getValorTotal()+", "+this.getDesconto()+", '"+this.getCodFuncionario()+"', "
        + ""+this.getNumeroSessao()+");";
        if(!cdb.cadastro(query1)){
            JOptionPane.showMessageDialog(null, "Problemas ao registrar Pedido");
        }
    }
}
