
package classes;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Fornecedor {

    private int numeroFornecedor;
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private String inscricaoEstadual;
    private String telefone;
    private String celular;
    private String email;
    private String endereco;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String abreviacao;
    
    private ConectaDB cdb;
    public Fornecedor(){
        cdb = new ConectaDB();
    }
    public void setnumeroFornecedor() throws SQLException{
        numeroFornecedor = cdb.gerarNumero("Fornecedor", "numeroFornecedor");
    }
    public void setrazaoSocial(String razaoSocial){
        this.razaoSocial = razaoSocial;
    }
    public void setnomeFantasia(String nomeFantasia){
        this.nomeFantasia = nomeFantasia;
    }
    public void setcnpj(String cnpj){
        this.cnpj = cnpj;
    }
    public void setinscricaoEstadual(String inscricaoEstadual){
        this.inscricaoEstadual = inscricaoEstadual;
    }
    public void settelefone(String telefone){
        this.telefone = telefone;
    }
    public void setcelular(String celular){
        this.celular = celular;
    }
    public void setemail(String email){
        this.email = email;
    }
    public void setendereco(String endereco){
        this.endereco = endereco;
    }
    public void setcomplemento(String complemento){
        this.complemento = complemento;
    }
    public void setbairro(String bairro){
        this.bairro = bairro;
    }
    public void setcep(String cep){
        this.cep = cep;
    }
    public void setcidade(String cidade){
        this.cidade = cidade;
    }
    public void setuf(String uf){
        this.uf = uf;
    }
    public void setabreviacao(String abreviacao){
        this.abreviacao = abreviacao;
    }
    
    public int getnumeroFornecedor(){
        return numeroFornecedor;
    }
    public String getrazaoSocial(){
        return razaoSocial;
    }
    public String getnomeFantasia(){
        return nomeFantasia;
    }
    public String getcnpj(){
        return cnpj;
    }
    public String getinscricaoEstadual(){
        return inscricaoEstadual;
    }
    public String gettelefone(){
        return telefone;
    }
    public String getcelular(){
        return celular;
    }
    public String getemail(){
        return email;
    }
    public String getendereco(){
        return endereco;
    }
    public String getcomplemento(){
        return complemento;
    }
    public String getbairro(){
        return bairro;
    }
    public String getcep(){
        return cep;
    }
    public String getcidade(){
        return cidade;
    }
    public String getuf(){
        return uf;
    }
    public String getabreviacao(){
        return abreviacao;
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

    public void cadastrarFornecedor() throws SQLException {
        String query = "insert into Fornecedor values("
                + ""+this.getnumeroFornecedor()+", '"+this.getrazaoSocial()+"', '"+this.getnomeFantasia()+"', "
                + "'"+this.getcnpj()+"', '"+this.getinscricaoEstadual()+"', '"+this.gettelefone()+"', '"+this.getcelular()+"', "
                + "'"+this.getemail()+"', '"+this.getendereco()+"', '"+this.getcomplemento()+"', '"+this.getbairro()+"', "
                + "'"+this.getcep()+"', '"+this.getcidade()+"', '"+this.getuf()+"')";
        if(cdb.cadastro(query)){
        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        cdb.closeDB();
    }else {
            JOptionPane.showMessageDialog(null, "Não cadastrado!");
        }
        
    }

}
