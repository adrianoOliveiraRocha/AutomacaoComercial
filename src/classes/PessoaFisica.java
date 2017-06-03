
package classes;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PessoaFisica extends Cliente{
    private String cpf;
    private String rg;
    private String dataNacimento;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDataNacimento() {
        return dataNacimento;
    }

    public void setDataNacimento(String dataNacimento) {
        this.dataNacimento = dataNacimento;
    }
    
    public void cadastrarClientePF() throws SQLException {
        
        String query1, query2;
        boolean testeQuery1, testeQuery2;
        query1 = "insert into Cliente values("
                + ""+this.getNumeroCliente()+", "+this.getTipo()+", '"+this.getNome()+"', "
                + "'"+this.getTelefone()+"', '"+this.getCelular()+"', '"+this.getEmail()+"', "
                + "'"+this.getEndereco()+", "+this.getNumero()+"', '"+this.getBairro()+"', "
                + "'"+this.getCep()+"', '"+this.getCidade()+"', '"+this.getUf()+"', '"+this.getDiaVencimento()+"')";
        query2 = "insert into PessoaFisica values("
                + "'"+this.getCpf()+"', '"+this.getRg()+"', '"+this.getDataNacimento()+"', "
                + ""+this.getNumeroCliente()+")";
        
        if(testeQuery1 = cdb.cadastro(query1)){
            if(testeQuery2 = cdb.cadastro(query2)){
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                cdb.closeDB();
            }else{
                JOptionPane.showMessageDialog(null, "Problema na tabela PessoaFisica");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Problema na tabela Cliente");
        }
        
    }
    
    
}
