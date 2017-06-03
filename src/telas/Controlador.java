
package telas;

import classes.ConectaDB;
import classes.Produto;
import classes.ResultSetTableModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Controlador extends TelaModelo{
    private JPanel painelGeral;
    private JMenuBar barra;
    //Menu Funcionário
    private JMenu funcionariomenu;
    private JMenuItem cadastrarFuncionario;
    private JMenu consultarFuncionario;
    //Menu Funcionário
    private JMenu administrador;
    private JMenuItem novoAdministrador;
    private JMenuItem editarAdministrador;
    private JMenuItem excluirAdministrador;
    //Fim do Menu Funcionário
    //Menu Cliente
    private JMenu clientemenu;
    private JMenu cadastrarCliente;
    private JMenuItem cadastrarClientePF;
    private JMenuItem cadastrarClientePJ;
    private JMenu consultarCliente;
    private JMenuItem consultarClientePorNumero;
    private JMenuItem consultarClienteExibirTodos;
    //Fim do Menu Cliente
    //Menu Fornecedor
    private JMenu fornecedormenu;
    private JMenuItem cadastrarFornecedor;
    private JMenuItem consultarFornecedor;
    //Fim do Menu Cliente
    //Menu Representante
    private JMenu representantemenu;
    private JMenuItem cadastrarRepresentante;
    private JMenuItem consultarRepresentante;
    //Fim do Menu Representante
    //Menu Produto
    private JMenu produtomenu;
    private JMenuItem inserirProduto;
    private JMenuItem atualizarEstoque;
    //Fim do Menu Produto
    //Menu Compra
    private JMenu pedidomenu;
    private JMenu compra;
    private JMenuItem realizarCompra;
    private JMenu consultarCompra;
    private JMenu venda;
    private JMenuItem abrirSessaom;
    private JMenuItem vendaAvulca;
     //Fim do Menu Compra
    private JPanel PPrincipal;
    
    private ResultSetTableModel tableModel;
    private JTable resultTable;
    private JScrollPane jscrollPane; 
    private JPanel PBotoes;
    
    private ConectaDB cdb;
    private JMenuItem consultarFuncionarioPorNumero;
    private JMenuItem consultarFuncionarioLista;
    private JMenuItem consultarCompraLista;
    public Controlador() throws SQLException, Throwable{
        this.setTitle("FP Mercadinhos");
        this.setSize(1050, 700);
        this.setLocation(100, 20);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cdb = new ConectaDB();
        inicializarComponetes();
        criarTabela();
        this.setVisible(true);
    }

    private void inicializarComponetes(){
        
        PBotoes = new JPanel();
        PBotoes.setBackground(Color.white);
        PBotoes.setLayout(null);
        PBotoes.setSize(1000, 40);
        PBotoes.setLocation(25, 613);
        PBotoes.setVisible(true);
        this.add(PBotoes);
                
        barra = new JMenuBar();
        barra.setSize(1050, 30);
        barra.setLocation(0, 0);
        this.add(barra);
        
        administrador = new JMenu("Administrador");
        novoAdministrador = new JMenuItem("Novo");
        novoAdministrador.addActionListener(new trataMenu());
        administrador.add(novoAdministrador);
        editarAdministrador = new JMenuItem("Editar");
        editarAdministrador.addActionListener(new trataMenu());
        administrador.add(editarAdministrador);
        excluirAdministrador = new JMenuItem("Excluir");
        excluirAdministrador.addActionListener(new trataMenu());
        administrador.add(excluirAdministrador);
        barra.add(administrador);
        
        venda = new JMenu("Venda");
        abrirSessaom = new JMenuItem("Abrir Caixa");
        abrirSessaom.addActionListener(new trataMenu());
        venda.add(abrirSessaom);
        
        vendaAvulca = new JMenuItem("Venda Avulça");
        vendaAvulca.addActionListener(new trataMenu());
        venda.add(vendaAvulca);
        barra.add(venda);
        
        //Menu Funcionário
        funcionariomenu = new JMenu("Funcionário");
        barra.add(funcionariomenu);
        
        cadastrarFuncionario = new JMenuItem("Cadastrar");
        cadastrarFuncionario.addActionListener(new trataMenu());
        funcionariomenu.add(cadastrarFuncionario);
        
        consultarFuncionario = new JMenu("Consultar");
        consultarFuncionario.addActionListener(new trataMenu());
        funcionariomenu.add(consultarFuncionario);
        consultarFuncionarioPorNumero = new JMenuItem("Por Número");
        consultarFuncionarioPorNumero.addActionListener(new trataMenu());
        consultarFuncionario.add(consultarFuncionarioPorNumero);
        consultarFuncionarioLista = new JMenuItem("Exibir Todos");
        consultarFuncionarioLista.addActionListener(new trataMenu());
        consultarFuncionario.add(consultarFuncionarioLista);
        
        //Fim do Menu Funcionário
        //Menu Cliente
        clientemenu = new JMenu("Cliente");
        barra.add(clientemenu);
        
        cadastrarCliente = new JMenu("Cadastrar");
        //cadastrarCliente.addActionListener(new trataMenu());
        clientemenu.add(cadastrarCliente);
        cadastrarClientePF = new JMenuItem("Pessoa Física");
        cadastrarClientePF.addActionListener(new trataMenu());
        cadastrarCliente.add(cadastrarClientePF);
        cadastrarClientePJ = new JMenuItem("Pessoa Jurídica");
        cadastrarClientePJ.addActionListener(new trataMenu());
        cadastrarCliente.add(cadastrarClientePJ);
        
        consultarCliente = new JMenu("Consultar");
        consultarCliente.addActionListener(new trataMenu());
        clientemenu.add(consultarCliente);
        consultarClientePorNumero = new JMenuItem("Por Número");
        consultarClientePorNumero.addActionListener(new trataMenu());
        consultarCliente.add(consultarClientePorNumero);
        consultarClienteExibirTodos = new JMenuItem("Exibir Todos");
        consultarClienteExibirTodos.addActionListener(new trataMenu());
        consultarCliente.add(consultarClienteExibirTodos);
                
        //Menu Fornecedor
        fornecedormenu = new JMenu("Fornecedor");
        barra.add(fornecedormenu);
        
        cadastrarFornecedor = new JMenuItem("Cadastrar");
        cadastrarFornecedor.addActionListener(new trataMenu());
        fornecedormenu.add(cadastrarFornecedor);
        
        consultarFornecedor = new JMenuItem("Consultar");
        consultarFornecedor.addActionListener(new trataMenu());
        fornecedormenu.add(consultarFornecedor);
        
        //Fim do Menu Fornecedor
        //Menu Representante
        representantemenu = new JMenu("Representante");
        barra.add(representantemenu);
        
        cadastrarRepresentante = new JMenuItem("Cadastrar");
        cadastrarRepresentante.addActionListener(new trataMenu());
        representantemenu.add(cadastrarRepresentante);
        
        consultarRepresentante = new JMenuItem("Consultar");
        consultarRepresentante.addActionListener(new trataMenu());
        representantemenu.add(consultarRepresentante);
        
        //Fim do Menu Representante
        produtomenu = new JMenu("Produto");
        barra.add(produtomenu);
        inserirProduto = new JMenuItem("Inserir/Consultar/Editar");
        inserirProduto.addActionListener(new trataMenu());
        produtomenu.add(inserirProduto);
        
        atualizarEstoque = new JMenuItem("Atualizar Estoque");
        atualizarEstoque.addActionListener(new trataMenu());
        produtomenu.add(atualizarEstoque);
      
        compra = new JMenu("Compra");
        realizarCompra = new JMenuItem("Realizar Compra");
        realizarCompra.addActionListener(new trataMenu());
        compra.add(realizarCompra);
        consultarCompra = new JMenu("Consultar Compra");
        consultarCompraLista = new JMenuItem("Histórico de Compras");
        consultarCompraLista.addActionListener(new trataMenu());
        consultarCompra.add(consultarCompraLista);
        compra.add(consultarCompra);
        barra.add(compra);
        
    }

    public void criarTabela() throws SQLException, Throwable {
        if(null == jscrollPane){
            tableModel = new ResultSetTableModel("jdbc:mysql://localhost:3306/ac?zeroDateTimeBehavior=convertToNull",
                "root","453231","select codBarras as Código, descricao as 'Descrição', marca as 'Marca', estoque as 'Estoque', "
                    + "precoCusto as 'Custo', precoVenda as 'Preço' from Produto");
        resultTable = new JTable(tableModel);
        resultTable.setToolTipText("Produtos em estoque");
        jscrollPane = new JScrollPane(resultTable);
        jscrollPane.setSize(950, 400);
        jscrollPane.setLocation(50, 130);
        jscrollPane.setVisible(true);
        this.add(jscrollPane);
        
        }else{
            this.dispose();
            new Controlador(); 
        }
    }
    private class trataMenu implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            if(ae.getSource().equals(cadastrarFuncionario)){
                try {
                    TelaCadastroFuncionario tcf = new TelaCadastroFuncionario();
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(ae.getSource().equals(consultarFuncionario)){
                System.out.println("Escolheu consultar funcionário");
            }
            else if(ae.getSource().equals(cadastrarClientePF)){
                try {
                    TelaCadastroClientePF tccpf = new TelaCadastroClientePF();
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(ae.getSource().equals(cadastrarClientePJ)){
                try {
                    TelaCadastroClientePJ tccpj = new TelaCadastroClientePJ();
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(ae.getSource().equals(cadastrarFornecedor)){
                try {
                    TelaCadastroFornecedor tcf = new TelaCadastroFornecedor();
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(ae.getSource().equals(consultarFornecedor)){
                try {
                    new TelaExibirFornecedores();
                } catch (Throwable ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(ae.getSource().equals(cadastrarRepresentante)){
                try {
                    TelaCadastroRepresentante tcr = new TelaCadastroRepresentante();
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(ae.getSource().equals(consultarRepresentante)){
                try {
                    new TelaListaRepresentantes();
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(ae.getSource().equals(inserirProduto)){
                TelaCadastroProduto tcp = new TelaCadastroProduto();
            }
            else if(ae.getSource().equals(atualizarEstoque)){
                try {
                    criarTabela();
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Throwable ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(ae.getSource().equals(realizarCompra)){
                String codigoFuncionario = JOptionPane.showInputDialog("Digite o código do Funcionário");
                cdb = new ConectaDB();
                try{
                    if(!cdb.verificarDisponibilidadeDeCodigo("Funcionario", "codigoFuncionario", codigoFuncionario)){
                        cdb.closeDB();
                        new TelaRealizarCompraAvulsa(codigoFuncionario);
                    }else{
                        JOptionPane.showMessageDialog(null, "Não Identificado!");
                        cdb.closeDB();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch(NumberFormatException n){
                    JOptionPane.showMessageDialog(null, "Digite um valor para o saldo inicial");
                }
            }else if(ae.getSource().equals(consultarCompra)){
                //JOptionPane.showMessageDialog(clientemenu, "Consultar Compra");
            }else if(ae.getSource().equals(abrirSessaom)){
                String codigoFuncionario = JOptionPane.showInputDialog("Digite o código do Funcionário");
                //Pesquisa o código
                cdb = new ConectaDB();
                try {
                    if(!cdb.verificarDisponibilidadeDeCodigo("Funcionario", "codigoFuncionario", codigoFuncionario)){
                        cdb.closeDB();
                        String valorInicial = JOptionPane.showInputDialog("Saldo inicial");
                        Produto p = new Produto();
                        valorInicial = p.trataVirgula(valorInicial);
                        TelaCaixa tc = new TelaCaixa(codigoFuncionario, valorInicial);
                    }else{
                         JOptionPane.showMessageDialog(null, "Não Identificado!");
                         cdb.closeDB();
                     }
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch(NumberFormatException n){
                    JOptionPane.showMessageDialog(null, "Digite um valor para o saldo inicial");
                }
                
            }else if(ae.getSource().equals(vendaAvulca)){
                JOptionPane.showMessageDialog(clientemenu, "vendaAvulca");
            }else if(ae.getSource().equals(consultarFuncionarioPorNumero)){
                new TelaConsultarFuncionarioPorNumero();
            }else if(ae.getSource().equals(consultarFuncionarioLista)){
                try {
                    new TelaExibirTodososFuncionarios();
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            else if(ae.getSource().equals(novoAdministrador)){
                String login = JOptionPane.showInputDialog("Digite seu login");
                try {
                    if(!cdb.verificarDisponibilidadeDeCodigo("Administrador", "login", login)){
                        String senha = JOptionPane.showInputDialog("Digite sua senha");
                        if(!cdb.verificarDisponibilidadeDeCodigo("Administrador", "senha", senha)){
                            new TelaNovoAdministrador();
                        }else{
                            JOptionPane.showMessageDialog(clientemenu, "Senha não encontrada!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(clientemenu, "Login não encontrado!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(ae.getSource().equals(consultarClientePorNumero)){
                int existe = 0; String tipo = "";
                String numeroCliente = JOptionPane.showInputDialog("Digite o número do cliente");
                if(!"".equals(numeroCliente) && numeroCliente != null){
                    ResultSet r;
                cdb = new ConectaDB();
                int numero = Integer.parseInt(numeroCliente);
                r = cdb.pesquisaDB("select * from Cliente where numeroCliente = "+numero+"");
                try {
                    while(r.next()){
                        existe++;
                        tipo = String.valueOf(r.getObject("tipo")); 
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(existe > 0){
                    
                    if("0".equals(tipo)){
                        try {
                            //Pessoa Física
                            new TelaConsultarClientePessoaFisicaPorNumero(numero);
                        } catch (SQLException ex) {
                            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        try {
                            //Pessoa Jurídica
                            new TelaConsultarClientePessoaJuridicaPorNumero(numero);
                        } catch (SQLException ex) {
                            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }else {
                    JOptionPane.showMessageDialog(clientemenu, "Não existe");
                }
                }else{
                    JOptionPane.showMessageDialog(null, "o número do cliente é necessário!");
                }
                
            }
            else if(ae.getSource().equals(editarAdministrador)){
                String login = JOptionPane.showInputDialog("Digite seu login");
                try {
                    if(!cdb.verificarDisponibilidadeDeCodigo("Administrador", "login", login)){
                        String senha = JOptionPane.showInputDialog("Digite sua senha");
                        if(!cdb.verificarDisponibilidadeDeCodigo("Administrador", "senha", senha)){
                            new TelaEditarAdministrador(login, senha);
                        }else{
                            JOptionPane.showMessageDialog(clientemenu, "Senha não encontrada!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(clientemenu, "Login não encontrado!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(ae.getSource().equals(excluirAdministrador)){
                String login = JOptionPane.showInputDialog("Digite seu login");
                String senha = JOptionPane.showInputDialog("Digite sua senha");
                String pesquisa = "select * from Administrador where login = '"+login+"' and senha = '"+senha+"'";
                ResultSet pesquisaAdmin;
                pesquisaAdmin = cdb.pesquisaDB(pesquisa);
                boolean existe = false;
                
                try {
                    while(pesquisaAdmin.next()){
                        existe = true;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(existe == true){
                    try {
                        new TelaExcluirAdministrador();
                    } catch (SQLException ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(clientemenu, "Não encontrador!");
                }
                
            }
            else if(ae.getSource().equals(consultarClienteExibirTodos)){
                try {
                    new TelaExibirTodosClientes();
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(ae.getSource().equals(consultarCompraLista)){
                try {
                    new TelaExibirTodasAsCompras();
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
    }
    //início trataTeclado
    public class trataTeclado implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }
        
    }
    //Fim trataTeclado
}
}
