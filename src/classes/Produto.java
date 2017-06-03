
package classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Produto {

    private String codBarras;
    private String descricao;
    private String marca;
    private String dataValidade;
    private int quantidade;
    private int estoqueMin;
    private double precoCusto;
    private double precoVenda;
    protected ConectaDB cdb;
    
    public Produto(){
        cdb = new ConectaDB();
    }
    
    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int estoque) {
        this.quantidade = estoque;
    }

    public int getEstoqueMin() {
        return estoqueMin;
    }

    public void setEstoqueMin(int estoqueMin) {
        this.estoqueMin = estoqueMin;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
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

    public ResultSet verificarCodBarras(String codbarras) {
        ResultSet resposta = cdb.verificarCodBarras(codbarras);
        return resposta;
    }
    
      public boolean testaVazio(String campo){
        if("".equals(campo)) return false;
        else return true;
    }

  
    public String trataVirgula(String text) {
        text = text.replaceAll(",", ".");
        return text;
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

    public void inserirNovoProduto() throws SQLException{
                
        String query = "insert into Produto values("
                + "'"+this.getCodBarras()+"', '"+this.getDescricao()+"', '"+this.getMarca()+"', "
                + ""+this.getQuantidade()+", "+this.getEstoqueMin()+", "+this.getPrecoCusto()+", "
                + ""+this.getPrecoVenda()+")";
                
        boolean resposta = cdb.cadastro(query);
        if(resposta){
            JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!");
            cdb.closeDB();
        }else{
            JOptionPane.showMessageDialog(null, "Operação não realizada!");
            cdb.closeDB();
        }
    }

    public void inserirUnidadesProdutoExistente(String exibirQuantidade, String text) throws SQLException {
        //JOptionPane.showMessageDialog(null, exibirQuantidade+"\n"+text);
        quantidade = Integer.parseInt(exibirQuantidade) + Integer.parseInt(text);
        int quantidadeExistente = Integer.parseInt(exibirQuantidade);
        int quantidadeAcrecentada = Integer.parseInt(text);
        int novoTotal = quantidadeExistente + quantidadeAcrecentada;
        
        String query = "update Produto set descricao = '"+this.getDescricao()+"', marca = '"+this.getMarca()+"', "
                + "estoque = "+novoTotal+", estoqueMin = "+this.getEstoqueMin()+", "
                + "precoCusto = "+this.getPrecoCusto()+", precoVenda = "+this.getPrecoVenda()+" "
                + "where codBarras = '"+this.getCodBarras()+"'";
        
        if(cdb.cadastro(query)){
            JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!");
            cdb.closeDB();
        }else{
            JOptionPane.showMessageDialog(null, "Operação não realizada!");
            cdb.closeDB();
        }
    }
}
