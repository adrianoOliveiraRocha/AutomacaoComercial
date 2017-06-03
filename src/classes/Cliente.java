
package classes;

import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Cliente {

    private int numeroCliente;
    //0 = PessoaFisica. 1 = PessoaJuridica
    private int tipo;
    private String nome;
    private String telefone;
    private String celular;
    private String email;
    private String endereco;
    private String numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String diaVencimento;
    
    protected ConectaDB cdb;
    
    public Cliente(){
        cdb = new ConectaDB();
    }
        
    public void setTipo(int tipo){
        this.tipo = tipo;
    }
    
    public int getTipo(){
        return this.tipo;
    }
    
    public int getNumeroCliente() {
        return numeroCliente;
    }

    public int setNumeroCliente() throws SQLException {
        numeroCliente = cdb.gerarNumero("Cliente", "numeroCliente");
        return numeroCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
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
  
        
    public static boolean testaData(String text, String text0, String text1) {
         //Se um dos três valores for vazio, os outros também devem ser
        if("".equals(text) || "".equals(text0) || "".equals(text1)){
            return false;
        }else{
            return true;
        }
    }
    
    //Testa amlitude do dia e do mês 
    public static boolean testeAmplitude(String text, int inicio, int fim) {
        /*testa primeiro se temos somente número. Se for falso, o teste não será reali
         zado pois dará um erro. já temos um método para isso*/
        boolean somenteNumeros = Cliente.somenteNumeros(text);
        
        if(somenteNumeros == true){
            /*Se há um número, prosseguimos com o teste. Esse número não pode ser vazio
             Se não, não faz sentido testar*/
               if(!"".equals(text)){
            int testeText = Integer.parseInt(text);
            /*Finalmente, testamos a amplitude*/
            if(testeText >= inicio && testeText <= fim){
                return true;//Dentro da amplitude
            }else{
                return false;//Fora da amplitude
            }
        }else{
            return true;//Não há nada a testar
        }
        }else{
            return true;/*O teste não foi feito porque não temos somente números. 
             já temos um método para isso*/
        }
     
    }
    
    public boolean testaVazio(String campo){
        if("".equals(campo)) return false;
        else return true;
    }

    /**
     * @return the dataPagamento
     */
    public String getDiaVencimento() {
        return diaVencimento;
    }

    /**
     * @param diaVencimento the dataPagamento to set
     */
    public void setDiaVencimento(String diaVencimento) {
        this.diaVencimento = diaVencimento;
    }
    
}
