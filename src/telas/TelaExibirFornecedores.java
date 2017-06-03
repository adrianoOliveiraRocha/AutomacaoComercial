package telas;

import classes.ConectaDB;
import classes.ResultSetTableModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author adriano
 */
public class TelaExibirFornecedores extends TelaModelo{
    private String numeroFornecedorS;
    private JPanel PBotoes;
    private JScrollPane jscrollPane;
    private ResultSetTableModel tableModel;
    private JTable resultTable;
    private JButton novo;
    private JButton editar;
    private JButton excluir;
    private JButton atualizar;
    private JButton sair;
    public TelaExibirFornecedores() throws Throwable{
        this.setTitle("Fornecedores Cadastrados");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1050, 350);
        this.setLocation(100, 20);
        incializarComponentes();
        criarTabela();
        this.setVisible(true);
    }

    private void incializarComponentes() {
        PBotoes = new JPanel();
        //PBotoes.setBackground(Color.yellow);
        PBotoes.setLayout(null);
        PBotoes.setSize(1000, 40);
        PBotoes.setLocation(25, 280);
        PBotoes.setVisible(true);
        this.add(PBotoes);
        
        novo = new JButton("Novo");
        novo.setSize(130, 20);
        novo.setLocation(58, 10);
        novo.addActionListener(new TrataBotao());
        PBotoes.add(novo);
        
        editar = new JButton("Editar");
        editar.setSize(130, 20);
        editar.setLocation(246, 10);
        editar.addActionListener(new TrataBotao());
        PBotoes.add(editar);
        
        excluir = new JButton("Excluir");
        excluir.setSize(130, 20);
        excluir.setLocation(432, 10);
        excluir.addActionListener(new TrataBotao());
        PBotoes.add(excluir);
        
        atualizar = new JButton("Atualizar");
        atualizar.setSize(130, 20);
        atualizar.setLocation(622, 10);
        atualizar.addActionListener(new TrataBotao());
        PBotoes.add(atualizar);
        
        sair = new JButton("Sair");
        sair.setSize(130, 20);
        sair.setLocation(810, 10);
        sair.addActionListener(new TrataBotao());
        PBotoes.add(sair);
    }

    private void criarTabela() throws Throwable {
        if(jscrollPane == null){
            String url = "jdbc:mysql://localhost:3306/ac?zeroDateTimeBehavior=convertToNull";
            String user = "root";
            String pass = "453231";
            String query = "select  numeroFornecedor, nomeFantasia, telefone, email, "
                    + "endereco, bairro from Fornecedor";
            tableModel = new ResultSetTableModel(url, user, pass, query);
            resultTable = new JTable(tableModel);
            resultTable.setToolTipText("Fornecedores Cadastrados");
            jscrollPane = new JScrollPane(resultTable);
            jscrollPane.setSize(950, 200);
            jscrollPane.setLocation(50, 50);
            jscrollPane.setVisible(true);
            this.add(jscrollPane);
        }else{
            this.dispose();
            new TelaExibirFornecedores();
        }
    }
    
    public class TrataBotao implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(novo)){
                try {
                    new TelaCadastroFornecedor();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaExibirFornecedores.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(e.getSource().equals(atualizar)){
                try {
                    criarTabela();
                } catch (Throwable ex) {
                    Logger.getLogger(TelaExibirFornecedores.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(e.getSource().equals(sair)){
                dispose();
            }else if(e.getSource().equals(editar)){
                int selecionado = resultTable.getSelectedRow() + 1;/*Equivale ao número da 
                linha da tabela*/
                if(selecionado == 0){
                    JOptionPane.showMessageDialog(rootPane, "Selecione um Fornecedor");
                }else if(selecionado > 0){
                    ResultSet r;
                    ConectaDB cdb = new ConectaDB();
                    r = cdb.pesquisaDB("select * from Fornecedor");
                    try {
                        while(r.next()){
                            if(selecionado == r.getRow()){
                                numeroFornecedorS = String.valueOf(r.getObject(1));
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaExibirFornecedores.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        /*Chamando a TelaEditarFornecedor e passando o número do fornecedor como argumento*/
                        new TelaEditarFornecedor(numeroFornecedorS);
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaExibirFornecedores.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }else if(e.getSource().equals(excluir)){
                int selecionado = resultTable.getSelectedRow() + 1;/*Equivale ao número da 
                linha da tabela*/
                if(selecionado == 0){
                    JOptionPane.showMessageDialog(rootPane, "Selecione um Fornecedor");
                }else{
                    ResultSet r;
                    ConectaDB cdb = new ConectaDB();
                    r = cdb.pesquisaDB("select * from Fornecedor");
                    try {
                        while(r.next()){
                            if(selecionado == r.getRow()){
                                numeroFornecedorS = String.valueOf(r.getObject(1));
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaExibirFornecedores.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    int numeroFornecedorAExcluir = Integer.parseInt(numeroFornecedorS);
                    excluir(numeroFornecedorAExcluir);
                }
            }
        }

        private void excluir(int numeroFornecedorAExcluir) {
            String query = "delete from Fornecedor where numeroFornecedor = "+numeroFornecedorAExcluir+"";
            ConectaDB excluiF = new ConectaDB();
            if(excluiF.cadastro(query)){
                JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível realizar a operação!");
            }
        }
        
    }
    

}
