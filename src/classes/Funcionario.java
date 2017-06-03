
package classes;

import java.sql.SQLException;

public class Funcionario {
    private String codigoFuncionario;//obrigatório
    private String nome;//obrigatório
    private String cpf;//obrigatório
    private String rg;//obrigatório
    private String carteiraTrabalho;//obrigatório
    private String pis;
    private String telefone;
    private String celular;
    private String email;
    private String endereco;//obrigatório
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;//obrigatório
    private String uf;
    private String dataAdimissao;//obrigatório. No banco de dados o tipo é date
    private String dataDemissao;
    protected ConectaDB cdb;
    
    public Funcionario(){
        /*Esse objeto (cdb) será usado para pesquisar o múnero gerado no BD e para 
         cadastrar o Funcionario*/
        cdb = new ConectaDB();
    }
   public String getcodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setcodigoFuncionario() throws SQLException{
        this.codigoFuncionario = String.valueOf(cdb.gerarNumero("Funcionario", "codigoFuncionario"));
    }

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

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

    public String getCarteiraTrabalho() {
        return carteiraTrabalho;
    }


    public void setCarteiraTrabalho(String carteiraTrabalho) {
        this.carteiraTrabalho = carteiraTrabalho;
    }


    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
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

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
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

    public String getDataAdimissao() {
        return dataAdimissao;
    }

    public void setDataAdimissao(String dataAdimissao) {
        this.dataAdimissao = dataAdimissao;
    }

    public String getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(String dataDemissao) {
        this.dataDemissao = dataDemissao;
    }
    
    public void setUf(String uf){
        this.uf = uf;
    }
    
    public String getUf(){
        return this.uf;
    }
    
    public boolean testarCodigo(String codigo) throws SQLException{
        boolean resposta = cdb.verificarDisponibilidadeDeCodigo("Funcionario", "codigoFuncionario", codigo);
        if(resposta == false){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean cadastrarFuncionario() throws SQLException{
        
        String query = "insert into Funcionario values('"+this.getcodigoFuncionario()+"', "
             + "'"+this.getNome()+"', '"+this.getCpf()+"', '"+this.getRg()+"', '"+this.getCarteiraTrabalho()+"', '"+this.getPis()+"', "
             + "'"+this.getTelefone()+"', '"+this.getCelular()+"', '"+this.getEmail()+"', '"+this.getEndereco()+"', "
             + "'"+this.getComplemento()+"', '"+this.getBairro()+"', '"+this.getCep()+"', '"+this.getCidade()+"', "
             + "'"+this.getDataAdimissao()+"', "+null+", '"+this.getUf()+"')";
        
        boolean respostaCadastro = cdb.cadastro(query);
        
        if(respostaCadastro == true){
            cdb.closeDB();
            return true;
        }else{
            return false;
        }
        
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
    //Testa amlitude do dia e do mês 
    public boolean testeAmplitude(String text, int inicio, int fim) {
        int amplitude = Integer.parseInt(text);
        if(amplitude < inicio || amplitude > fim){
            return false;
        }else
            return true;
    }
    /*Recebe uma matriz com todos os campos obrigatórios dessa classe e testa se 
     algum não foi preenchido*/
    public boolean verificaObrigatórios(String[] obrigatorios) {
        for(int cont = 0; cont < obrigatorios.length; cont++){
            if("".equals(obrigatorios[cont]))
                return false;//Algum campo obrigatório não foi preenchido
        }
        return true;//todos os compos obrigatórios foram preenchidos
    }
}
