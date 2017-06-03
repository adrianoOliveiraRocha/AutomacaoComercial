
package classes;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Representante {

    private int numeroRepresentante;
    private String nomeRepresentante;
    private String telefone;
    private String celular;
    private String email;
    private static ConectaDB cdb;
    int numeroFornecedor;
    public Representante(){
        cdb = new ConectaDB();
    }
    
    public int getNumeroRepresentante() {
        return numeroRepresentante;
    }

    public void setNumeroRepresentante() throws SQLException {
        numeroRepresentante = cdb.gerarNumero("Representante", "numeroRepresentante");
    }

    public String getNomeRepresentante() {
        return nomeRepresentante;
    }

    public void setNomeRepresentante(String nomeRepresentante) {
        this.nomeRepresentante = nomeRepresentante;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    
    public boolean testaVazio(String campo){
        if("".equals(campo)) return false;
        else return true;
    }

    public void cadastrarRepresentante(int numeroFornecedor) throws SQLException {
        String query = "insert into Representante values("+this.getNumeroRepresentante()+", "
                + "'"+this.getNomeRepresentante()+"', '"+this.getTelefone()+"', "
                + "'"+this.getCelular()+"', '"+this.getEmail()+"')";
        if(cdb.cadastro(query)){
            relacionar(numeroFornecedor);
        }else{
            JOptionPane.showMessageDialog(null, "Não cadastrado!");
        }
    }

    public void relacionar(int numeroFornecedor) {
        String query = "insert into RF values("+numeroFornecedor+", "+this.getNumeroRepresentante()+")";
        if(cdb.cadastro(query)){
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        }
    }
    
    public static boolean atualizar(String query) {
        return cdb.cadastro(query);
    }
}
