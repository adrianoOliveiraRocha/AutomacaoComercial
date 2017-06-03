package telas;

import classes.ConectaDB;
import classes.ResultSetTableModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author adriano
 */
class TelaExibirTodososFuncionarios extends TelaModelo{
    private JPanel PPrincipal;
    private JPanel PBotoes;
    private ResultSetTableModel rstm;
    private JTable tabelaFuncionarios;
    private JScrollPane jspf;
    private JButton editar, sair;
    private JButton novo;
    private JButton excluir;
    private JButton atualizar;
    
    public TelaExibirTodososFuncionarios() throws SQLException {
        this.setLayout(null);
        this.setTitle("Lista de Funcionários");
        this.setSize(1200, 340);
        this.setLocation(50, 50);
        inicializarComponentes();
        preencherListaFuncionarios();
        this.setVisible(true);
    }

    private void inicializarComponentes() {
        
        PPrincipal = new JPanel();
        PPrincipal.setLayout(null);
        //PPrincipal.setBackground(Color.yellow);
        PPrincipal.setSize(1100, 250);
        PPrincipal.setLocation(50, 20);
        this.add(PPrincipal);
        
        PBotoes = new JPanel();
        PBotoes.setLayout(null);
        //PBotoes.setBackground(Color.yellow);
        PBotoes.setSize(1100, 40);
        PBotoes.setLocation(50, 270);
        this.add(PBotoes);
        
        novo = new JButton("Novo");
        novo.setSize(130, 20);
        novo.setLocation(75, 10);
        novo.addActionListener(new TrataBotao());
        PBotoes.add(novo);
        
        editar = new JButton("Editar");
        editar.setSize(130, 20);
        editar.setLocation(280, 10);
        editar.addActionListener(new TrataBotao());
        PBotoes.add(editar);
        
        excluir = new JButton("Excluir");
        excluir.setSize(130, 20);
        excluir.setLocation(485, 10);
        excluir.addActionListener(new TrataBotao());
        PBotoes.add(excluir);
        
        atualizar = new JButton("Atualizar");
        atualizar.setSize(130, 20);
        atualizar.setLocation(690, 10);
        atualizar.addActionListener(new TrataBotao());
        PBotoes.add(atualizar);
        
        sair = new JButton("Sair");
        sair.setSize(130, 20);
        sair.setLocation(895, 10);
        sair.addActionListener(new TrataBotao());
        PBotoes.add(sair);
    }

    private void preencherListaFuncionarios() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ac?zeroDateTimeBehavior=convertToNull";
        String user = "root";
        String pass = "453231";
        String query = "select nome, telefone, celular, email from Funcionario";
        rstm = new ResultSetTableModel(url, user, pass, query);
        tabelaFuncionarios = new JTable(rstm);
        jspf = new JScrollPane(tabelaFuncionarios);
        jspf.setSize(1100, 250);
        jspf.setLocation(0, 0);
        PPrincipal.add(jspf);
    }
    
    public class TrataBotao implements ActionListener{
        private ConectaDB cdb;

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(sair)){
                dispose();
            }else if(e.getSource().equals(editar)){
                int selecionado = tabelaFuncionarios.getSelectedRow()+1;
                if(0 == selecionado){
                    JOptionPane.showMessageDialog(rootPane, "Por favor! seleciona um Funcionário");
                }else{
                    String login = JOptionPane.showInputDialog("Digite seu login");
                    ResultSet r;
                    cdb = new ConectaDB();
                    r = cdb.pesquisaDB("select * from Administrador where login = '"+login+"'");
                    int existe = 0;
                    try {
                        while(r.next()){
                            existe++;
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaExibirTodososFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(existe == 0){
                        JOptionPane.showMessageDialog(rootPane, "Não encontrado!");
                    }else{
                        existe = 0;
                        String senha = JOptionPane.showInputDialog("Digite sua senha");
                        r = cdb.pesquisaDB("select * from Administrador where senha = '"+senha+"'");
                        try {
                            while(r.next()){
                                new TelaFuncionarioSelecionadoDaLista(selecionado);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(TelaExibirTodososFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            else if(e.getSource().equals(novo)){
                try {
                    new TelaCadastroFuncionario();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaExibirTodososFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(e.getSource().equals(atualizar)){
                try {
                    dispose(); new TelaExibirTodososFuncionarios();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaExibirTodososFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(e.getSource().equals(excluir)){
                int selecionado = tabelaFuncionarios.getSelectedRow()+1;
                if(0 == selecionado){
                    JOptionPane.showMessageDialog(rootPane, "Por favor! seleciona um Funcionário");
                }else{
                    //Verifica se o Administrador existe
                    String login, senha; boolean existe = false;
                    login = JOptionPane.showInputDialog("Digite seu login");
                    senha = JOptionPane.showInputDialog("Digite sua senha");
                    ResultSet pesquisaAdmin;
                    ConectaDB pesquisaAdminCDB = new ConectaDB();
                    pesquisaAdmin = pesquisaAdminCDB.pesquisaDB("select * from Administrador where"
                            + " login = '"+login+"' and senha = '"+senha+"'");
                    try {
                        while(pesquisaAdmin.next()){
                            existe = true;
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaExibirTodososFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if(existe){//Existe
                        try {
                            //Obtendo o Código do Funcionário
                            String codigoFuncionario = getCodBarras(selecionado);
                            //Esse método pesquisa se o funcionário em questão é Administrador
                            if(pesquisaAdmin(codigoFuncionario)){//É administrador
                                JOptionPane.showMessageDialog(null, "O Funcionário que você está "
                                        + " tentando excluir é administrador do sistema\nPara excluir um Administrador "
                                        + "escolha o menu Administrador opção excluir.");
                            }else{//Não é Administrador
                                //Agora, o teste é pra saber se o Funcionário está ligado a alguma Sessão
                                if(testeSessaoCompra(codigoFuncionario)){/*Significa que o Funcionário está ligado à uma Sessão 
                                    e, por isso, não pode ser deletado do sistema*/
                                    int resposta = JOptionPane.showConfirmDialog(null, "Esse funcionário está ligado "
                                            + "a pelo menos uma compra ou venda!\nAo excluí-lo, o sistema perderá "
                                            + "todos os dados aos quais ele está ligado.\n"
                                            + "Deseja continuar?");
                                    switch(resposta){
                                        case 0:
                                            JOptionPane.showMessageDialog(null, "Escolheu Continuar");
                                            break;
                                        case 1:
                                            JOptionPane.showMessageDialog(null, "O Funcioário não será excluído!");
                                            break;
                                        case 2:
                                            JOptionPane.showMessageDialog(null, "Operação Cancelada!");
                                            break;
                                    }
                                }else{/*Significa que o Funcionário não está ligado à uma Sessão ou a uma CompraAvulsa 
                                    e, por isso, pode ser deletado do sistema. Eu acho...*/
                                    excluir(codigoFuncionario);
                                }
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(TelaExibirTodososFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }else{//Não existe
                        JOptionPane.showMessageDialog(null, "Não encontrado!");
                    }
                }
            }
        }

        private String getCodBarras(int selecionado) throws SQLException {
            String cod = "";
            ResultSet pesquisacodigoFuncionario;
            ConectaDB pesquisaCodBarrasCDB = new ConectaDB();
            pesquisacodigoFuncionario = pesquisaCodBarrasCDB.pesquisaDB("select * from Funcionario");
            while(pesquisacodigoFuncionario.next()){
                if((selecionado) == pesquisacodigoFuncionario.getRow())
                cod = (String) pesquisacodigoFuncionario.getObject("codigoFuncionario");
            }
            return cod;
        }

        private boolean pesquisaAdmin(String codigoFuncionario) throws SQLException {
            boolean teste = false;
            String pesquisaAdminS = "select * from Administrador where senha = '"+codigoFuncionario+"'";
            ResultSet pesquisaAdminRS;
            ConectaDB pesquisaAdminCDB = new ConectaDB();
            pesquisaAdminRS = pesquisaAdminCDB.pesquisaDB(pesquisaAdminS);
            while(pesquisaAdminRS.next()){
                teste = true;
            }
            return teste;
        }

        private boolean excluirFuncionario(String codigoFuncionario) throws SQLException {
            String deletaFunc = "delete from Funcionario where codigoFuncionario = '"+codigoFuncionario+"'";
            ConectaDB deletaFuncCDB = new ConectaDB();
            if(deletaFuncCDB.cadastro(deletaFunc)){
                return true;
            }else{
                return false;
            }
        }

        private boolean testeSessaoCompra(String codigoFuncionario) throws SQLException {
            int teste = 0;
            /*Verifica se o funcionário participou de alguma Sessão*/
            teste = verificaSessao(codigoFuncionario) + teste;
            teste = verificaCompra(codigoFuncionario) + teste;
            JOptionPane.showMessageDialog(null, "teste = "+teste);
            if(teste > 0){
                return true;
            }else{
                return false;
            }
        }

        private int verificaSessao(String codigoFuncionario) throws SQLException {
            boolean participou = false;
            String pesquisaSessao = "select * from Sessao where codigoFuncionario = '"+codigoFuncionario+"'";
            ResultSet pesquisaSessaoRS;
            ConectaDB pesquisaSessaoCDB = new ConectaDB();
            pesquisaSessaoRS = pesquisaSessaoCDB.pesquisaDB(pesquisaSessao);
            while(pesquisaSessaoRS.next()){
               participou = true; 
            }
            if(participou == true){
                return 1;
            }else{
                return 0;
            }
        }

        private int verificaCompra(String codigoFuncionario) throws SQLException {
            boolean participou = false;
            String pesquisaCompra = "select * from CompraAvulsa where codigoFuncionario = '"+codigoFuncionario+"'";
            ResultSet pesquisaCompraRS;
            ConectaDB pesquisaCompraCDB = new ConectaDB();
            pesquisaCompraRS = pesquisaCompraCDB.pesquisaDB(pesquisaCompra);
            while(pesquisaCompraRS.next()){
               participou = true; 
            }
            if(participou == true){
                return 1;
            }else{
                return 0;
            }
        }

        private void excluir(String codigoFuncionario) {
            String deletaFuncionario = "delete from Funcionario where Funcionario.codigoFuncionario = '"+codigoFuncionario+"'";
            ConectaDB deletaFuncCDB = new ConectaDB();
            if(deletaFuncCDB.cadastro(deletaFuncionario)){
                JOptionPane.showMessageDialog(rootPane, "Funcionário deletado do sistema!");
            }else{
                JOptionPane.showMessageDialog(rootPane, "Problema ao tentar excluir funcionário do sistema!!");
            }
        }
    }
}
