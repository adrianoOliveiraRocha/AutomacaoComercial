
package classes;

import javax.swing.JOptionPane;

public class Administrador extends Funcionario{
    private String login;
    private String senha;
    
    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void salvarAdministrador() {
        String query0 = "insert into Funcionario values('"+this.getSenha()+"', "
             + "'"+this.getNome()+"', '"+this.getCpf()+"', '"+this.getRg()+"', '"+this.getCarteiraTrabalho()+"', '"+this.getPis()+"', "
             + "'"+this.getTelefone()+"', '"+this.getCelular()+"', '"+this.getEmail()+"', '"+this.getEndereco()+"', "
             + "'"+this.getComplemento()+"', '"+this.getBairro()+"', '"+this.getCep()+"', '"+this.getCidade()+"', "
             + "'"+this.getDataAdimissao()+"', "+null+", '"+this.getUf()+"')";
                
        String query1 = "insert into Administrador values('"+this.getLogin()+"', '"+this.getSenha()+"')";
        
        if(cdb.cadastro(query0)){
            if(cdb.cadastro(query1)){
                JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Problemas com a tabela Administrador");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Problemas com a tabela Funcionario");
        }
    }
}
