
package telas;

import classes.CompraAvulsa;
import classes.ConectaDB;
import classes.ItemPedidoCompraAvulsa;
import classes.ResultSetTableModel;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaRealizarCompraAvulsa extends TelaModelo{
    
    protected ConectaDB cdb;
    private JPanel PBotoes;
    private JPanel PPrincipal;
    private JLabel numerolb;
    private JTextField numerotf;
    private JLabel datalb;
    private JTextField datatf;
    private JLabel descontolb;
    private JTextField descontotf;
    private JRadioButton percentual;
    private JTextField percentualtf;
    private JRadioButton absoluto;
    private JTextField absolutotf;
    private ButtonGroup grupo;
    private JLabel codFuncionariolb;
    private JTextField codFuncionariotf;
    private JLabel exibiNomeFuncionariolb;
    private JButton InserirItemsPedido;
    private JButton cancelar;
    private JButton fecharCompra;
    private JLabel somenteNumerosdescontolb;
    //testa se os campos numéricos estão preenchidos somente com números
    private JLabel numeroCompraAvulsalb;
    private JTextField numeroCompraAvulsatf;
    protected CompraAvulsa cav;
    /*Se, na hora de salvar a venda, essa variável (funciopnarioEncontrado )
    for false, a operação não pode ser efetuada*/
        
    private ResultSetTableModel tabelaFornecedores;
    private JTable Fornecedores;
    private JScrollPane jsFornecedores;
    private ResultSetTableModel tabelaRepresentantes;
    private JTable Representantes;
    private JScrollPane jsRepresentantes;
    private JLabel listaFornecedores;
    private JPanel PFornecedores;
    private JButton cadastrarFornecedor;
    private JButton excluirFornecedor;
    private JPanel PRepresentantes;
    private JLabel listaRepresentantes;
    private ResultSetTableModel tabelaRepreentantes;
    private JButton cadastrarRepresentante;
    private JButton excluirRepresentante;
    private JButton atualizar;
    private ItemPedidoCompraAvulsa ipcv;
    private String nomeFuncionario;
    public TelaRealizarCompraAvulsa(String codigoFuncionario) throws SQLException{
        
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Realizar Compra");
        this.setSize(1050, 680);
        this.setLocation(120, 20);
        
        cdb = new ConectaDB();
        criarCompraAvulsa(codigoFuncionario);
        criarListaFornecedores();
        criarListaRepresentantes(); 
        inicializarComponentes(codigoFuncionario);
        this.setVisible(true);
        
    }

    private void inicializarComponentes(String codigoFuncionario) throws SQLException {
        
        PBotoes = new JPanel();
        //PBotoes.setBackground(Color.yellow);
        PBotoes.setLayout(null);
        PBotoes.setSize(1000, 40);
        PBotoes.setLocation(25, 600);
        PBotoes.setVisible(true);
        this.add(PBotoes);
        
        PPrincipal = new JPanel();
        //PPrincipal.setBackground(Color.white);
        PPrincipal.setLayout(null);
        PPrincipal.setSize(1000, 580);
        PPrincipal.setLocation(25, 0);
        PPrincipal.setVisible(true);
        this.add(PPrincipal);
        
        numeroCompraAvulsalb = new JLabel("Número");
        numeroCompraAvulsalb.setSize(200, 20);
        numeroCompraAvulsalb.setLocation(10, 20);
        PPrincipal.add(numeroCompraAvulsalb);
        numeroCompraAvulsatf = new JTextField(String.valueOf(cav.getNumero()));
        numeroCompraAvulsatf.setEditable(false);
        numeroCompraAvulsatf.setSize(300, 20);
        numeroCompraAvulsatf.setLocation(220, 20);
        PPrincipal.add(numeroCompraAvulsatf);
        
        codFuncionariolb = new JLabel("Código do Funcionário");
        codFuncionariolb.setSize(200, 20);
        codFuncionariolb.setLocation(10, 50);
        PPrincipal.add(codFuncionariolb);
        exibiNomeFuncionariolb = new JLabel(this.identificarFuncionario(codigoFuncionario));
        exibiNomeFuncionariolb.setForeground(Color.blue);
        exibiNomeFuncionariolb.setSize(200, 20);
        exibiNomeFuncionariolb.setLocation(595, 50);
        PPrincipal.add(exibiNomeFuncionariolb);
        codFuncionariotf = new JTextField(codigoFuncionario);
        codFuncionariotf.setEditable(false);
        codFuncionariotf.setSize(300, 20);
        codFuncionariotf.setLocation(220, 50);
        codFuncionariotf.addKeyListener(new trataTeclado());
        PPrincipal.add(codFuncionariotf);
        
        descontolb = new JLabel("Desconto");
        descontolb.setSize(100, 20);
        descontolb.setLocation(10, 80);
        PPrincipal.add(descontolb);
        somenteNumerosdescontolb = new JLabel("Digite um valor numérico");
        somenteNumerosdescontolb.setForeground(Color.red);
        somenteNumerosdescontolb.setSize(200,20);
        somenteNumerosdescontolb.setLocation(595,80);
        somenteNumerosdescontolb.setVisible(false);
        PPrincipal.add(somenteNumerosdescontolb);
        descontotf = new JTextField("0");
        descontotf.addKeyListener(new trataTeclado());
        descontotf.setSize(100, 20);
        descontotf.setLocation(220, 80);
        PPrincipal.add(descontotf);
        
        percentual = new JRadioButton("Percentual");
        percentual.setSize(110, 20);
        percentual.setLocation(320, 80);
        percentual.addItemListener(new trataRadioButtons());
        PPrincipal.add(percentual);
        absoluto = new JRadioButton("Absoluto");
        absoluto.setSize(100, 20);
        absoluto.setLocation(435, 80);
        absoluto.addItemListener(new trataRadioButtons());
        grupo = new ButtonGroup();
        grupo.add(absoluto); grupo.add(percentual);
        
        PPrincipal.add(percentual);
        PPrincipal.add(absoluto);
                
        InserirItemsPedido = new JButton("Inserir Items");
        InserirItemsPedido.setSize(130, 20);
        InserirItemsPedido.setLocation(96, 10);
        InserirItemsPedido.setVisible(true);
        InserirItemsPedido.addActionListener(new trataBotao());
        PBotoes.add(InserirItemsPedido);
                 
        fecharCompra = new JButton("Fechar Compra");
        fecharCompra.setSize(140, 20);
        fecharCompra.setLocation(322, 10);
        fecharCompra.setVisible(true);
        fecharCompra.addActionListener(new trataBotao());
        PBotoes.add(fecharCompra);
        
        atualizar = new JButton("Atualizar");
        atualizar.setSize(130, 20);
        atualizar.setLocation(548, 10);
        atualizar.setVisible(true);
        atualizar.addActionListener(new trataBotao());
        PBotoes.add(atualizar);
        
        cancelar = new JButton("Cancelar");
        cancelar.setSize(130, 20);
        cancelar.setLocation(774, 10);
        cancelar.setVisible(true);
        cancelar.addActionListener(new trataBotao());
        PBotoes.add(cancelar);
        
        PPrincipal.add(PFornecedores);
        PPrincipal.add(PRepresentantes);
                
    }

    private void criarListaFornecedores() throws SQLException {
        PFornecedores = new JPanel();
        //PFornecedores.setBackground(Color.white);
        PFornecedores.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        PFornecedores.setLayout(null);
        PFornecedores.setSize(1000, 210);
        PFornecedores.setLocation(0, 130);
        PFornecedores.setVisible(true);
        
        try{
            listaFornecedores = new JLabel("Fornecedores Cadastrados");
        listaFornecedores.setSize(200, 20);
        listaFornecedores.setLocation(400, 20);
        PFornecedores.add(listaFornecedores);
        
        String url = "jdbc:mysql://localhost:3306/ac?zeroDateTimeBehavior=convertToNull";
        String username = "root";
        String password = "453231";
        String query = "select numeroFornecedor, nomeFantasia, cnpj, telefone"
                + " from Fornecedor";
                
        tabelaFornecedores = new ResultSetTableModel(url, username, password, query);
        Fornecedores = new JTable(tabelaFornecedores);
        Fornecedores.setToolTipText("Selecione um Fornecedor");
        jsFornecedores = new JScrollPane(Fornecedores);
        jsFornecedores.setSize(950, 100);
        jsFornecedores.setLocation(25, 50);
        jsFornecedores.setVisible(true);
        jsFornecedores.setToolTipText("Selecione um Fornecedor");
        PFornecedores.add(jsFornecedores);
        
        cadastrarFornecedor = new JButton("Cadastrar Fornecedor");
        cadastrarFornecedor.setSize(200, 20);
        cadastrarFornecedor.setLocation(400, 180);
        cadastrarFornecedor.addActionListener(new trataBotao());
        PFornecedores.add(cadastrarFornecedor);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, ex.getCause());
        }
        
    }

    private void criarListaRepresentantes() throws SQLException {
        PRepresentantes = new JPanel();
        //PRepresentantes.setBackground(Color.white);
        PRepresentantes.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        PRepresentantes.setLayout(null);
        PRepresentantes.setSize(1000, 210);
        PRepresentantes.setLocation(0, 370);
        PRepresentantes.setVisible(true);
        
        try{
            listaRepresentantes = new JLabel("Representantes Cadastrados");
            listaRepresentantes.setSize(230, 20);
            listaRepresentantes.setLocation(400, 20);
            PRepresentantes.add(listaRepresentantes);
            
            String url = "jdbc:mysql://localhost:3306/ac?zeroDateTimeBehavior=convertToNull";
            String username = "root";
            String password = "453231";
            String query = "select * from Representante";
            
            tabelaRepresentantes = new ResultSetTableModel(url, username, password, query);
            Representantes = new JTable(tabelaRepresentantes);
            Representantes.setToolTipText("Selecione um Representante");
            jsRepresentantes = new JScrollPane(Representantes);
            jsRepresentantes.setSize(950, 100);
            jsRepresentantes.setLocation(25, 50);
            jsRepresentantes.setVisible(true);
            PRepresentantes.add(jsRepresentantes);
            
            cadastrarRepresentante = new JButton("Cadastrar Representante");
            cadastrarRepresentante.setSize(230, 20);
            cadastrarRepresentante.setLocation(400, 180);
            cadastrarRepresentante.addActionListener(new trataBotao());
            
            PRepresentantes.add(cadastrarRepresentante);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, ex.getCause());
        }
        
    }

    private String identificarFuncionario(String codigoFuncionario) throws SQLException {
        String pesquisa = "select * from Funcionario "
                + "where codigoFuncionario = "+codigoFuncionario+"";
        ResultSet r;
        try{
            r = cdb.pesquisaDB(pesquisa);
            while(r.next()){
            nomeFuncionario = (String.valueOf(r.getObject(2)));
        }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            return null;
        }
        cdb.closeDB();
        return nomeFuncionario;
    }

    private void criarCompraAvulsa(String codFuncionario) throws SQLException {
        /*Os dados iniciais já estão sendo salvos
        O resto é só atualizações*/
        cav = new CompraAvulsa(); 
        cav.setNumero();
        cav.setData();
        cav.setCodigoFuncionario(codFuncionario);
        //Registrando
        cav.salvarCompraAvulsa();
    }
    
    public class trataTeclado implements KeyListener{
        

        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getSource().equals(descontotf)){
                somenteNumerosdescontolb.setVisible(false);
                descontotf.setText(cav.trataVirgula(descontotf.getText()));
            }
        }
    }
    
    public class trataBotao implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource().equals(InserirItemsPedido)){
                new TelaNovoItemDePedidoCompraAvulsa(cav.getNumero(), cav.getData());
            }
            //Fim Novo Item de Pedido
            else if(e.getSource().equals(cancelar)){
                try {
                    apagarDadosDaCompra();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaRealizarCompraAvulsa.class.getName()).log(Level.SEVERE, null, ex);
                }
                dispose();
            }else if(e.getSource().equals(cadastrarFornecedor)){
                try {
                    new TelaCadastroFornecedor();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaRealizarCompraAvulsa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(e.getSource().equals(cadastrarRepresentante)){
                try {
                    new TelaCadastroRepresentante();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaRealizarCompraAvulsa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(e.getSource().equals(atualizar)){
                try {
                    dispose();
                    new TelaRealizarCompraAvulsa(codFuncionariotf.getText());
                } catch (Throwable ex) {
                    Logger.getLogger(TelaRealizarCompraAvulsa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            /*Fechar Compra*/
            else if(e.getSource().equals(fecharCompra)){
                try {
                    //retorna o número de itens pertencentes a essa compra avulsa
                    int result = teste();
                    if(result > 0){
                        /*Existem ítens dessa compra*/
                        /*Início Fornecedor Selecionado*/
                        int selecionado = Fornecedores.getSelectedRow();
                        if(selecionado == -1){
                            /*Nemhum Fornecedor foi selecionado*/
                        }else{/*Um Fornecedor foi selecionado*/
                            ResultSet r;
                            r = cdb.pesquisaDB("select * from Fornecedor");
                            try {
                                while(r.next()){
                                    if(r.getRow() == selecionado + 1){
                                        /*Aqui eu capturu o numero do fornecedor que foi selecionado*/
                                        cav.setNumeroFornecedor(String.valueOf(r.getObject(1)));
                                    }
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(TelaRealizarCompraAvulsa.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            try {
                                cdb.closeDB();
                            } catch (SQLException ex) {
                                Logger.getLogger(TelaRealizarCompraAvulsa.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        /*Fim Fornecedor Selecionado*/
                        
                        /*Início Representante Selecionado*/
                        int selecionado1 = Representantes.getSelectedRow();
                        if(selecionado1 == -1){
                            /*Nenhum Representante foi Selecionado*/
                        }else{/*Um Representante foi selecionado*/
                            ResultSet r;
                            r = cdb.pesquisaDB("select * from Representante");
                            try{
                                while(r.next()){
                                    if(r.getRow() == selecionado1 + 1){
                                        /*Aqui eu capturu o numero do representante que foi selecionado*/
                                        cav.setNumeroRepresentante(String.valueOf(r.getObject(1)));
                                        testaRelacao();
                                    }
                                }
                            }catch(SQLException ex){
                                Logger.getLogger(TelaRealizarCompraAvulsa.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        /*Fim Representante Selecionado*/
                                                
                        String atualizacao = "update CompraAvulsa "
                                + "set numeroFornecedor = "+cav.getNumeroFornecedor()+", "
                                + "numeroRepresentante = "+cav.getNumeroRepresentante()+", "
                                + "desconto = "+cav.getDesconto()+" where numero = "+cav.getNumero()+"";
                        //JOptionPane.showMessageDialog(rootPane, atualizacao);
                        if(cdb.cadastro(atualizacao)){
                            JOptionPane.showMessageDialog(rootPane, "Operação realizada com sucesso!");
                        }else{
                            JOptionPane.showMessageDialog(rootPane, "Problemas ao atualizar compra avulsa!");
                        }
                        dispose();
                        
                    }else if(result == 0){
                        eleiminarDadosIniciais();/*Compra sem ítens é apagada*/
                    }   
                } catch (SQLException ex) {
                    Logger.getLogger(TelaRealizarCompraAvulsa.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                }
                
            }
        
        public int teste() throws SQLException{
            /*Teste se existem Itens nessa compra. Caso seja falso, a compra deve ser eliminada*/
            int teste = 0;
            ResultSet r;
            String query = "select * from ItemPedidoCompraAvulsa "
                    + "where numeroCompraAvulsa = "+cav.getNumero()+"";
            r = cdb.pesquisaDB(query);
            while(r.next()){
                teste ++;
            }
            return teste;
        }
         public void limpar() throws SQLException{
            cav.setNumero();
            numeroCompraAvulsatf.setText(String.valueOf(cav.getNumero()));
            codFuncionariotf.setText("");
            descontotf.setText("");
        }

        private void apagarDadosDaCompra() throws SQLException {
            /*Ao cancelar a CompraAvulsa os os itens de pedido da compra devem ser 
            apagados também*/
            String apagarItens = "delete from ItemPedidoCompraAvulsa "
                    + "where numeroCompraAvulsa = "+cav.getNumero()+"";
            cdb.cadastro(apagarItens); cdb.closeDB();
            String apagaCompra = "delete from CompraAvulsa "
                    + "where numero = "+cav.getNumero()+"";
            cdb.cadastro(apagaCompra); cdb.closeDB();
            JOptionPane.showMessageDialog(rootPane, "Compra cancelada!");
        }

        private void eleiminarDadosIniciais() {
            /*Esse método será chamado caso o botão fechar Compra tenha sido pressionado sem que
            Ítens tenham sido adicionados à compra*/
            String query = "delete from CompraAvulsa where "+cav.getNumero()+"";
            if(cdb.cadastro(query)){
                /*Os dados iniciais da compra foram apagados*/
                dispose();
            }else{
                JOptionPane.showMessageDialog(rootPane, "Problemas ao apagar dados iniciais");
            }
        }

        private void testaRelacao() throws SQLException {
            /*Testando se o Reŕesentante selecionado é mesmo representante do Fornecedor selecionado*/
            int testeRF = 0;
            int numeroFornecedor = Integer.parseInt(cav.getNumeroFornecedor());
            int numeroRepresentante = Integer.parseInt(cav.getNumeroRepresentante());
            ResultSet rf = cdb.pesquisaDB("select * from RF "
                + "where ligaFornecedor = "+numeroFornecedor+" and ligaRepresentante = "+numeroRepresentante+"");
            while(rf.next()){
                testeRF++;
            }
            if(testeRF > 0){
                JOptionPane.showMessageDialog(rootPane, "Teste Positivo");
            }else{
                JOptionPane.showMessageDialog(rootPane, "Representante e Fornecedor não relacionados");
                cav.setNumeroRepresentante(null);
            }
        /*Fim do teste*/
        }

       }
    
    public class trataRadioButtons implements ItemListener{
        
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(absoluto.isSelected()){
                /*absoluto*/
                if("".equals(descontotf.getText()) || "0".equals(descontotf.getText())){
                    /*Desconto 0*/
                    cav.setDesconto(0);
                }else{
                    cav.setDesconto(Double.parseDouble(descontotf.getText()));
            }
        }
            if(percentual.isSelected()){
                /*percentual*/
                if("".equals(descontotf.getText()) || "0".equals(descontotf.getText())){
                    /*Desconto 0*/
                    cav.setDesconto(0);
                }else{
                    cav.setDesconto((Double.parseDouble(descontotf.getText()))/100);
                }
            }
        
    }
    }
}
    

