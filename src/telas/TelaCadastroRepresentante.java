
package telas;

import classes.ConectaDB;
import classes.Representante;
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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class TelaCadastroRepresentante extends TelaModelo{
    private JPanel PPrincipal;
    private JPanel PBotoes;
    private JButton cadastrar, limpar, sair, atualizar;
    
    private JLabel numeroRepresentantelb;
    private JTextField numeroRepresentantetf;
    private JLabel nomeRepresentantelb;
    private JTextField nomeRepresentantetf;
    private JLabel telefonelb;
    private JTextField telefonetf;
    private JLabel celularlb;
    private JTextField celulartf;
    private JLabel emaillb;
    private JTextField emailtf;
    private JLabel somenteNumerostelefonelb;
    private JTextField dddtelefonetf;
    private JTextField dddcelulartf;
    private JLabel somenteNumeroscelularlb;
    
    private final Representante representante;
    private String exibirNR;
    
    private int []testeSomenteNumeros = new int[4];
    private ConectaDB cdb;
    private JButton novoFornecedor;
    private JPanel PFornecedores;
    private JLabel listaFornecedores;
    private ResultSetTableModel tabelaFornecedores;
    private JTable Fornecedores;
    private JScrollPane jsFornecedores;
    private JButton cadastrarFornecedor;
    
    int numeroFornecedor;
    public TelaCadastroRepresentante() throws SQLException{
    
        representante = new Representante();
        representante.setNumeroRepresentante();
        exibirNR = String.valueOf(representante.getNumeroRepresentante());
        this.setTitle("Cadastro de Representante");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocation(140, 50);
        inicializarComponentes();
        nomeRepresentantetf.grabFocus();
        criarListaFornecedores();
        this.setVisible(true);
    }

    private void inicializarComponentes() {
                
        PPrincipal = new JPanel();
        PPrincipal.setForeground(Color.yellow);
        PPrincipal.setLayout(null);
        PPrincipal.setSize(750, 200);
        PPrincipal.setLocation(25, 0);
        this.add(PPrincipal);
        
        PBotoes = new JPanel();
        //PBotoes.setBackground(Color.yellow);
        PBotoes.setLayout(null);
        PBotoes.setSize(750, 40);
        PBotoes.setLocation(25, 520);
        this.add(PBotoes);
        
        numeroRepresentantelb = new JLabel("Número:");
        numeroRepresentantelb.setSize(100, 20);
        numeroRepresentantelb.setLocation(25, 20);
        PPrincipal.add(numeroRepresentantelb);
        numeroRepresentantetf = new JTextField();
        numeroRepresentantetf.setEditable(false);
        numeroRepresentantetf.setToolTipText("Gerado pelo sistema");
        numeroRepresentantetf.setText(exibirNR);
        numeroRepresentantetf.setSize(300, 20);
        numeroRepresentantetf.setLocation(220, 20);
        PPrincipal.add(numeroRepresentantetf);
        
        nomeRepresentantelb = new JLabel("Nome:");
        nomeRepresentantelb.setSize(100, 20);
        nomeRepresentantelb.setLocation(25, 50);
        PPrincipal.add(nomeRepresentantelb);
        
        nomeRepresentantetf = new JTextField();
        nomeRepresentantetf.setSize(300, 20);
        nomeRepresentantetf.setLocation(220, 50);
        PPrincipal.add(nomeRepresentantetf);
        
        telefonelb = new JLabel("Telefone:");
        telefonelb.setSize(100, 20);
        telefonelb.setLocation(25, 80);
        PPrincipal.add(telefonelb);
        somenteNumerostelefonelb = new JLabel("Somente Números");
        somenteNumerostelefonelb.setForeground(Color.red);
        somenteNumerostelefonelb.setVisible(false);
        somenteNumerostelefonelb.setSize(200, 20);
        somenteNumerostelefonelb.setLocation(570, 80);
        PPrincipal.add(somenteNumerostelefonelb);
        telefonetf = new JTextField();
        telefonetf.setSize(150, 20);
        telefonetf.setLocation(250, 80);
        telefonetf.addKeyListener(new trataTeclado());
        PPrincipal.add(telefonetf);
        dddtelefonetf = new JTextField();
        dddtelefonetf.setSize(25, 20);
        dddtelefonetf.setLocation(220, 80);
        dddtelefonetf.addKeyListener(new trataTeclado());
        PPrincipal.add(dddtelefonetf);
        
        celularlb = new JLabel("Celular:");
        celularlb.setSize(100, 20);
        celularlb.setLocation(25, 110);
        PPrincipal.add(celularlb);
        somenteNumeroscelularlb = new JLabel("Somente Números");
        somenteNumeroscelularlb.setForeground(Color.red);
        somenteNumeroscelularlb.setVisible(false);
        somenteNumeroscelularlb.setSize(200, 20);
        somenteNumeroscelularlb.setLocation(570, 110);
        PPrincipal.add(somenteNumeroscelularlb);
        celulartf = new JTextField();
        celulartf.setSize(150, 20);
        celulartf.setLocation(250, 110);
        celulartf.addKeyListener(new trataTeclado());
        PPrincipal.add(celulartf);
        dddcelulartf = new JTextField();
        dddcelulartf.setSize(25, 20);
        dddcelulartf.setLocation(220, 110);
        dddcelulartf.addKeyListener(new trataTeclado());
        PPrincipal.add(dddcelulartf);
        
        emaillb = new JLabel("Email:");
        emaillb.setSize(130, 20);
        emaillb.setLocation(25, 140);
        PPrincipal.add(emaillb);
        emailtf = new JTextField();
        emailtf.setSize(300, 20);
        emailtf.setLocation(220, 140);
        PPrincipal.add(emailtf);
        
        cadastrar = new JButton("Cadastrar");
        cadastrar.setSize(120, 20);
        cadastrar.setLocation(54, 10);
        cadastrar.setVisible(true);
        cadastrar.addActionListener(new trataBotao());
        PBotoes.add(cadastrar);
        
        limpar = new JButton("Limpar");
        limpar.setSize(120, 20);
        limpar.setLocation(228, 10);
        limpar.setVisible(true);
        limpar.addActionListener(new trataBotao());
        PBotoes.add(limpar);
        
        atualizar = new JButton("Atualizar");
        atualizar.setSize(120, 20);
        atualizar.setLocation(402, 10);
        atualizar.setVisible(true);
        atualizar.addActionListener(new trataBotao());
        PBotoes.add(atualizar);
        
        sair = new JButton("Sair");
        sair.setSize(120, 20);
        sair.setLocation(576, 10);
        sair.setVisible(true);
        sair.addActionListener(new trataBotao());
        PBotoes.add(sair);
    }

    private void criarListaFornecedores() {
        PFornecedores = new JPanel();
        //PFornecedores.setBackground(Color.yellow);
        PFornecedores.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        PFornecedores.setLayout(null);
        PFornecedores.setSize(750, 300);
        PFornecedores.setLocation(25, 200);
        PFornecedores.setVisible(true);
        
        try{
            listaFornecedores = new JLabel("Fornecedores Cadastrados");
            listaFornecedores.setSize(200, 20);
            listaFornecedores.setLocation(250, 20);
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
            jsFornecedores.setSize(750, 180);
            jsFornecedores.setLocation(0, 50);
            jsFornecedores.setVisible(true);
            jsFornecedores.setToolTipText("Selecione um Fornecedor");
            PFornecedores.add(jsFornecedores);
        
            cadastrarFornecedor = new JButton("Cadastrar Fornecedor");
            cadastrarFornecedor.setSize(200, 20);
            cadastrarFornecedor.setLocation(250, 250);
            cadastrarFornecedor.addActionListener(new trataBotao());
            PFornecedores.add(cadastrarFornecedor);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, ex.getCause());
        }
        
        this.add(PFornecedores);
        
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
            if(e.getSource().equals(dddtelefonetf)){
                testeSomenteNumeros[0] = 0;
                somenteNumerostelefonelb.setVisible(false);
                if(!Representante.somenteNumeros(dddtelefonetf.getText())){
                    testeSomenteNumeros[0] = 1;
                    somenteNumerostelefonelb.setVisible(true);
                }
            }else if(e.getSource().equals(telefonetf)){
                testeSomenteNumeros[1] = 0;
                somenteNumerostelefonelb.setVisible(false);
                if(!Representante.somenteNumeros(telefonetf.getText())){
                    testeSomenteNumeros[1] = 1;
                    somenteNumerostelefonelb.setVisible(true);
                }
            }else if(e.getSource().equals(dddcelulartf)){
                testeSomenteNumeros[2] = 0;
                somenteNumeroscelularlb.setVisible(false);
                if(!Representante.somenteNumeros(dddcelulartf.getText())){
                    testeSomenteNumeros[2] = 1;
                    somenteNumeroscelularlb.setVisible(true);
                }
            }else if(e.getSource().equals(celulartf)){
                testeSomenteNumeros[3] = 0;
                somenteNumeroscelularlb.setVisible(false);
                if(!Representante.somenteNumeros(celulartf.getText())){
                    testeSomenteNumeros[3] = 1;
                    somenteNumeroscelularlb.setVisible(true);
                }
            }
        }
    }
    
    
    public class trataBotao implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(limpar)){
                try {
                    limpar();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaCadastroRepresentante.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(e.getSource().equals(atualizar)){
                atualizar();
                
            }else if(e.getSource().equals(sair)){
                dispose();
            }else if(e.getSource().equals(cadastrar)){
                /*Primerio, testa se os campos numéricos estão preenchidos corretamente*/
                int teste = 0;
                for(int x = 0; x < testeSomenteNumeros.length; x++){
                    if(testeSomenteNumeros[x] == 1) teste++;
                }
                if(teste > 0){
                    JOptionPane.showMessageDialog(rootPane, "Atenção parar os campos numéricos!");
                }else{
                    if(Fornecedores.getSelectedRow() == -1){
                        JOptionPane.showMessageDialog(rootPane, "Por favor, selecione um Fornecedor!");
                    }else{
                        /*Obtendo o número do Fornecedor*/
                        ResultSet r;
                        cdb = new ConectaDB();
                        String query = "select * from Fornecedor";
                        r = cdb.pesquisaDB(query);
                        
                        try {
                            while(r.next()){
                                if(r.getRow() == (Fornecedores.getSelectedRow()+1)){
                                    numeroFornecedor = Integer.parseInt(String.valueOf(r.getObject(1)));
                                }
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(TelaCadastroRepresentante.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        /*Configurando o Representante*/
                        String telefone = dddtelefonetf.getText()+telefonetf.getText();
                        String celular = dddcelulartf.getText()+celulartf.getText();
                        representante.setNomeRepresentante(nomeRepresentantetf.getText());
                        representante.setTelefone(telefone);
                        representante.setCelular(celular);
                        representante.setEmail(emailtf.getText());
                        try {
                            representante.cadastrarRepresentante(numeroFornecedor);
                            limpar();
                            /*Fim Configurando o Representante*/
                        } catch (SQLException ex) {
                            Logger.getLogger(TelaCadastroRepresentante.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }else if(e.getSource().equals(cadastrarFornecedor)){
                try {
                    new TelaCadastroFornecedor();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaCadastroRepresentante.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        
            
        }
        private void limpar() throws SQLException {
            /*numeroRepresentantetf.setText("");
            nomeRepresentantetf.setText(""); telefonetf.setText("");
            dddtelefonetf.setText(""); celulartf.setText("");
            dddcelulartf.setText(""); emailtf.setText("");
            somenteNumerostelefonelb.setVisible(false);
            somenteNumeroscelularlb.setVisible(false);
            representante.setNumeroRepresentante();*/
            atualizar();
            exibirNR = String.valueOf(representante.getNumeroRepresentante());
            numeroRepresentantetf.setText(exibirNR);
            nomeRepresentantetf.grabFocus();
        }
        private void atualizar() {
            dispose();
                try {
                    new TelaCadastroRepresentante();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaCadastroRepresentante.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        
        
}

