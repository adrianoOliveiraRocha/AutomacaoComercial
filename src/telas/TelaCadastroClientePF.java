
package telas;

import classes.Cliente;
import classes.PessoaFisica;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TelaCadastroClientePF extends TelaCadastroCliente{
    protected JPanel PBotoes;
    private JLabel cpflb;
    private JLabel somenteNumeroscpflb;
    private JTextField cpftf;
    private JLabel rglb;
    private JLabel somenteNumerosrglb;
    private JTextField rgtf;
    private JLabel dataNacimentolb;
    private JLabel somenteNumerosdataNacimentolb;
    private JLabel formatodataNacimentolb;
    private JLabel diaNacimentolb;
    private JTextField diaNacimentotf;
    private JLabel mesNacimentolb;
    private JTextField mesNacimentotf;
    private JLabel anoNacimentolb;
    private JTextField anoNacimentotf;
    protected JButton cadastrar, limpar, sair, novo;
    
    private PessoaFisica pf;
    private JLabel vencimentolb;
    private JTextField vencimentotf;
    private JLabel somenteNumerosvencimentolb;
    
    public TelaCadastroClientePF() throws SQLException{
        pf = new PessoaFisica();
        exibirNC = String.valueOf(pf.setNumeroCliente());
        this.numeroClientetf.setText(exibirNC);
        this.setSize(800, 550);
        this.setLocation(140, 50);   
        this.setTitle("Cadastro de Clientes Pessoa Física");
        inicializarComponentes();
        nometf.grabFocus();
        this.setVisible(true);
    }

    private void inicializarComponentes() {
        
        PBotoes = new JPanel();
        PBotoes.setLayout(null);
        PBotoes.setSize(750, 40);
        PBotoes.setLocation(25, 480);
        //PBotoes.setBackground(Color.red);
        this.add(PBotoes);
        
        cpflb = new JLabel("CPF:");
        cpflb.setSize(100, 20);
        cpflb.setLocation(25, 320);
        PPrincipal.add(cpflb);
        somenteNumeroscpflb = new JLabel("Somente Números");
        somenteNumeroscpflb.setForeground(Color.red);
        somenteNumeroscpflb.setVisible(false);
        somenteNumeroscpflb.setSize(200, 20);
        somenteNumeroscpflb.setLocation(570, 320);
        PPrincipal.add(somenteNumeroscpflb);
        cpftf = new JTextField();
        cpftf.setSize(150, 20);
        cpftf.setLocation(220, 320);
        cpftf.addKeyListener(new trataTeclado());
        PPrincipal.add(cpftf);
        
        rglb = new JLabel("RG:");
        rglb.setSize(100, 20);
        rglb.setLocation(25, 350);
        PPrincipal.add(rglb);
        somenteNumerosrglb = new JLabel("Somente Números");
        somenteNumerosrglb.setForeground(Color.red);
        somenteNumerosrglb.setVisible(false);
        somenteNumerosrglb.setSize(200, 20);
        somenteNumerosrglb.setLocation(570, 350);
        PPrincipal.add(somenteNumerosrglb);
        rgtf = new JTextField();
        rgtf.setSize(150, 20);
        rgtf.setLocation(220, 350);
        rgtf.addKeyListener(new trataTeclado());
        PPrincipal.add(rgtf);
        
        dataNacimentolb = new JLabel("Data de Nacimento:*");
        dataNacimentolb.setSize(200, 20);
        dataNacimentolb.setLocation(25, 380);
        PPrincipal.add(dataNacimentolb);
        somenteNumerosdataNacimentolb = new JLabel("Somente Números");
        somenteNumerosdataNacimentolb.setForeground(Color.red);
        somenteNumerosdataNacimentolb.setVisible(false);
        somenteNumerosdataNacimentolb.setSize(200, 20);
        somenteNumerosdataNacimentolb.setLocation(570, 380);
        PPrincipal.add(somenteNumerosdataNacimentolb);
        
        formatodataNacimentolb = new JLabel("DD/MM/AAAA");
        formatodataNacimentolb.setVisible(true);
        formatodataNacimentolb.setSize(200, 20);
        formatodataNacimentolb.setLocation(570, 380);
        PPrincipal.add(formatodataNacimentolb);
        
        diaNacimentolb = new JLabel("Dia:*");
        diaNacimentolb.setSize(50, 20);
        diaNacimentolb.setLocation(220, 380);
        PPrincipal.add(diaNacimentolb);
        diaNacimentotf = new JTextField();
        diaNacimentotf.setSize(25, 20);
        diaNacimentotf.setLocation(270, 380);
        diaNacimentotf.addKeyListener(new trataTeclado());
        PPrincipal.add(diaNacimentotf);
        
        mesNacimentolb = new JLabel("Mês:*");
        mesNacimentolb.setSize(50, 20);
        mesNacimentolb.setLocation(320, 380);
        PPrincipal.add(mesNacimentolb);
        mesNacimentotf = new JTextField();
        mesNacimentotf.setSize(25, 20);
        mesNacimentotf.setLocation(370, 380);
        mesNacimentotf.addKeyListener(new trataTeclado());
        PPrincipal.add(mesNacimentotf);
        
        anoNacimentolb = new JLabel("Ano:*");
        anoNacimentolb.setSize(50, 20);
        anoNacimentolb.setLocation(420, 380);
        PPrincipal.add(anoNacimentolb);
        anoNacimentotf = new JTextField();
        anoNacimentotf.setSize(50, 20);
        anoNacimentotf.setLocation(470, 380);
        anoNacimentotf.addKeyListener(new trataTeclado());
        PPrincipal.add(anoNacimentotf);
        
        vencimentolb = new JLabel("Dia Vencimento:*");
        vencimentolb.setSize(150, 20);
        vencimentolb.setLocation(25, 410);
        PPrincipal.add(vencimentolb);
        
        somenteNumerosvencimentolb = new JLabel("Somente Números");
        somenteNumerosvencimentolb.setForeground(Color.red);
        somenteNumerosvencimentolb.setSize(200, 20);
        somenteNumerosvencimentolb.setLocation(570, 410);
        somenteNumerosvencimentolb.setVisible(false);
        PPrincipal.add(somenteNumerosvencimentolb);
        
        vencimentotf = new JTextField();
        vencimentotf.setToolTipText("Dia do vencimento da fatura");
        vencimentotf.setSize(25, 20);
        vencimentotf.setLocation(220, 410);
        vencimentotf.addKeyListener(new trataTeclado());
        PPrincipal.add(vencimentotf);
        
        cadastrar = new JButton("Cadastrar");
        cadastrar.setSize(150, 20);
        cadastrar.setLocation(30, 10);
        cadastrar.setVisible(true);
        cadastrar.addActionListener(new trataBotao());
        PBotoes.add(cadastrar);
        
        limpar = new JButton("Limpar");
        limpar.setSize(150, 20);
        limpar.setLocation(210, 10);
        limpar.setVisible(true);
        limpar.addActionListener(new trataBotao());
        PBotoes.add(limpar);
        
        novo = new JButton("Novo");
        novo.setSize(150, 20);
        novo.setLocation(390, 10);
        novo.setVisible(true);
        novo.addActionListener(new trataBotao());
        PBotoes.add(novo);
        
        sair = new JButton("Sair");
        sair.setSize(150, 20);
        sair.setLocation(570, 10);
        sair.setVisible(true);
        sair.addActionListener(new trataBotao());
        PBotoes.add(sair);
    }
    
    public class trataTeclado implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            //Pode ser usado no futuro
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //Pode ser usado no futuro
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getSource().equals(cpftf)){
                somenteNumeroscpflb.setVisible(false);
                if(!Cliente.somenteNumeros(cpftf.getText())){
                    somenteNumeroscpflb.setVisible(true);
                }
            }else if(e.getSource().equals(rgtf)){
                somenteNumerosrglb.setVisible(false);
                if(!Cliente.somenteNumeros(rgtf.getText())){
                    somenteNumerosrglb.setVisible(true);
                }
            }else if(e.getSource().equals(diaNacimentotf)){
                if(!Cliente.testeAmplitude(diaNacimentotf.getText(), 1, 31)){
                    JOptionPane.showMessageDialog(rootPane, "Digite um valor entre 1 e 31 para Dia");
                    diaNacimentotf.setText("");
                }
                formatodataNacimentolb.setVisible(true);
                somenteNumerosdataNacimentolb.setVisible(false);
                if(!Cliente.somenteNumeros(diaNacimentotf.getText())){
                    formatodataNacimentolb.setVisible(false);
                    somenteNumerosdataNacimentolb.setVisible(true);
                }
            }else if(e.getSource().equals(mesNacimentotf)){
                if(!Cliente.testeAmplitude(mesNacimentotf.getText(), 1, 12)){
                    JOptionPane.showMessageDialog(rootPane, "Digite um valor entre 1 e 12 para Mês");
                    mesNacimentotf.setText("");
                }
                formatodataNacimentolb.setVisible(true);
                somenteNumerosdataNacimentolb.setVisible(false);
                if(!Cliente.somenteNumeros(mesNacimentotf.getText())){
                    formatodataNacimentolb.setVisible(false);
                    somenteNumerosdataNacimentolb.setVisible(true);
                }
            }else if(e.getSource().equals(anoNacimentotf)){
                formatodataNacimentolb.setVisible(true);
                somenteNumerosdataNacimentolb.setVisible(false);
                if(!Cliente.somenteNumeros(anoNacimentotf.getText())){
                    formatodataNacimentolb.setVisible(false);
                    somenteNumerosdataNacimentolb.setVisible(true);
                }
            }else if(e.getSource().equals(vencimentotf)){
                somenteNumerosvencimentolb.setVisible(false);
                if(!Cliente.somenteNumeros(vencimentotf.getText())){
                    somenteNumerosvencimentolb.setVisible(true);
                }
                if(!Cliente.testeAmplitude(vencimentotf.getText(), 1, 31)){
                    JOptionPane.showMessageDialog(rootPane, "Digite um número "
                            + "entre 1 e 31 para o dia do vencimento");
                    vencimentotf.setText("");
                }
            }
        }
        
    }
    
    public class trataBotao implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(limpar)){
                limpar();
            }else if(e.getSource().equals(sair)){
                dispose();
            }else if(e.getSource().equals(novo)){
                limpar();
                
                try {
                    novo();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaCadastroClientePF.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(e.getSource().equals(cadastrar)){
                String dataNacimento;
                /*o campo nome não pode estar vazio*/
                if(!pf.testaVazio(nometf.getText()) || !pf.testaVazio(vencimentotf.getText())){
                    JOptionPane.showMessageDialog(rootPane, "os campos nome e dia do vencimento "
                            + "devem ser preenchidos");
                }else{
                    /*Esse trecho não permite que a data esteja imcompleta. Isso daria um erro no BD*/
                    if(Cliente.testaData(diaNacimentotf.getText(), mesNacimentotf.getText(), 
                            anoNacimentotf.getText())){
                       dataNacimento = anoNacimentotf.getText()+"/"+mesNacimentotf.getText()+"/"+diaNacimentotf.getText(); 
                    }else{
                        dataNacimento = "";
                    }
                    String telefone = dddtelefonetf.getText()+telefonetf.getText();
                    String celular = dddcelulartf.getText()+celulartf.getText();
                    pf.setNome(nometf.getText());
                    pf.setTelefone(telefone);
                    pf.setCelular(celular);
                    pf.setEmail(emailtf.getText());
                    pf.setEndereco(enderecotf.getText());
                    pf.setNumero(numerotf.getText());
                    pf.setBairro(bairrotf.getText());
                    pf.setCep(ceptf.getText());
                    pf.setCidade(cidadetf.getText());
                    pf.setUf(uftf.getText());
                    pf.setCpf(cpftf.getText());
                    pf.setRg(rgtf.getText());
                    pf.setDataNacimento(dataNacimento);
                    pf.setDiaVencimento(vencimentotf.getText());
                    
                    
                    try {
                        pf.cadastrarClientePF();
                        limpar(); novo();
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaCadastroClientePF.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                
            }
        }


     }
        private void limpar() {
            nometf.setText("");
            telefonetf.setText(""); celulartf.setText("");
            emailtf.setText(""); enderecotf.setText(""); numerotf.setText("");
            bairrotf.setText(""); ceptf.setText("");
            cidadetf.setText(""); uftf.setText("");
            cpftf.setText(""); rgtf.setText("");
            dddtelefonetf.setText(""); dddcelulartf.setText("");
            diaNacimentotf.setText(""); mesNacimentotf.setText("");
            anoNacimentotf.setText("");
            vencimentotf.setText("");
            
            somenteNumerostelefonelb.setVisible(false);
            somenteNumeroscelularlb.setVisible(false);
            somenteNumerosnumerolb.setVisible(false);
            somenteNumerosceplb.setVisible(false);
            somenteNumeroscpflb.setVisible(false);
            somenteNumerosrglb.setVisible(false);
            somenteNumerosdataNacimentolb.setVisible(false);
            somenteNumerosvencimentolb.setVisible(false);
            nometf.grabFocus();
        }
            private void novo() throws SQLException {
                exibirNC = String.valueOf(pf.setNumeroCliente());
                /*O método não conseguiria enxergar o numeroClientetf dentro da classe 
                 trataBotao porque essa classe não estende a classe TelaCadastroCliente; que
                 é a classe que contém o elemento em questão*/
                this.numeroClientetf.setText(exibirNC);
                nometf.grabFocus();
        }
}
