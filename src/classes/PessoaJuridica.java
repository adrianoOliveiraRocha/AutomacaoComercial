
package classes;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PessoaJuridica extends Cliente{

    private String razaoSocial;
    private String cnpj;
    private String inscricaoEstadual;
    private String responsavel;

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public void cadastrarClientePJ() throws SQLException {
        
        String query1, query2;
        boolean testeQuery1, testeQuery2;
        query1 = "insert into Cliente values("
                + ""+this.getNumeroCliente()+", "+this.getTipo()+", '"+this.getNome()+"', "
                + "'"+this.getTelefone()+"', '"+this.getCelular()+"', '"+this.getEmail()+"', "
                + "'"+this.getEndereco()+", "+this.getNumero()+"', '"+this.getBairro()+"', "
                + "'"+this.getCep()+"', '"+this.getCidade()+"', '"+this.getUf()+"', '"+this.getDiaVencimento()+"')";
        query2 = "insert into PessoaJuridica values("
                + "'"+this.getRazaoSocial()+"', '"+this.getCnpj()+"', '"+this.getInscricaoEstadual()+"', "
                + "'"+this.getResponsavel()+"', "+this.getNumeroCliente()+")";
        
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
