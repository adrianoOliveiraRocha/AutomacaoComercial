
package telas;

import classes.Cliente;
import classes.PessoaJuridica;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TelaCadastroClientePJ extends TelaCadastroCliente{
    protected JPanel PBotoes;
    protected JButton cadastrar, limpar, sair, novo;
    
    private JTextField razaoSocialtf;
    private JLabel razaoSociallb;
    private JTextField cnpjtf;
    private JLabel cnpjlb;
    private JLabel somenteNumeroscnpjlb;
    private JTextField inscricaoEstadualtf;
    private JLabel inscricaoEstaduallb;
    private JTextField responsaveltf;
    private JLabel responsavellb;
    
    private PessoaJuridica pj;
    private JLabel vencimentolb;
    private JTextField vencimentotf;
    private JLabel somenteNumerosvencimentolb;
    
    public TelaCadastroClientePJ() throws SQLException{
        pj = new PessoaJuridica();
        pj.setTipo(1);
        pj.setNumeroCliente();
        this.exibirNC = String.valueOf(pj.getNumeroCliente());
        this.numeroClientetf.setText(exibirNC);
        this.setSize(800, 580);
        this.setLocation(140, 50);   
        this.setTitle("Cadastro de Clientes Pessoa Jurídica");
        inicializarComponentes();
        nometf.grabFocus();
        this.setVisible(true);
    }

    private void inicializarComponentes() {
        PBotoes = new JPanel();
        //PBotoes.setBackground(Color.yellow);
        PBotoes.setLayout(null);
        PBotoes.setSize(750, 40);
        PBotoes.setLocation(20, 500);
        this.add(PBotoes);
        
        razaoSociallb = new JLabel("Razao Social:");
        razaoSociallb.setSize(200, 20);
        razaoSociallb.setLocation(25, 320);
        PPrincipal.add(razaoSociallb);
        razaoSocialtf = new JTextField();
        razaoSocialtf.setSize(300, 20);
        razaoSocialtf.setLocation(220, 320);
        PPrincipal.add(razaoSocialtf);
        
        cnpjlb = new JLabel("CNPJ:");
        cnpjlb.setSize(200, 20);
        cnpjlb.setLocation(25, 350);
        PPrincipal.add(cnpjlb);
        cnpjtf = new JTextField();
        cnpjtf.setSize(300, 20);
        cnpjtf.setLocation(220, 350);
        cnpjtf.addKeyListener(new trataTeclado());
        PPrincipal.add(cnpjtf);
        somenteNumeroscnpjlb = new JLabel("Somente Números");
        somenteNumeroscnpjlb.setForeground(Color.red);
        somenteNumeroscnpjlb.setVisible(false);
        somenteNumeroscnpjlb.setSize(200, 20);
        somenteNumeroscnpjlb.setLocation(570, 350);
        PPrincipal.add(somenteNumeroscnpjlb);
        
        inscricaoEstaduallb = new JLabel("Inscrição Estadual:");
        inscricaoEstaduallb.setSize(200, 20);
        inscricaoEstaduallb.setLocation(25, 380);
        PPrincipal.add(inscricaoEstaduallb);
        inscricaoEstadualtf = new JTextField();
        inscricaoEstadualtf.setSize(300, 20);
        inscricaoEstadualtf.setLocation(220, 380);
        PPrincipal.add(inscricaoEstadualtf); 
        
        responsavellb = new JLabel("Responsável:");
        responsavellb.setSize(200, 20);
        responsavellb.setLocation(25, 410);
        PPrincipal.add(responsavellb);
        responsaveltf = new JTextField();
        responsaveltf.setSize(300, 20);
        responsaveltf.setLocation(220, 410);
        PPrincipal.add(responsaveltf);
        
        vencimentolb = new JLabel("Dia Vencimento:");
        vencimentolb.setSize(200, 20);
        vencimentolb.setLocation(25, 440);
        PPrincipal.add(vencimentolb);
        vencimentotf = new JTextField();
        vencimentotf.setSize(25, 20);
        vencimentotf.setLocation(220, 440);
        vencimentotf.addKeyListener(new trataTeclado());
        PPrincipal.add(vencimentotf);
        somenteNumerosvencimentolb = new JLabel("Somente Números");
        somenteNumerosvencimentolb.setForeground(Color.red);
        somenteNumerosvencimentolb.setSize(200, 20);
        somenteNumerosvencimentolb.setLocation(570, 440);
        somenteNumerosvencimentolb.setVisible(false);
        PPrincipal.add(somenteNumerosvencimentolb);
                
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
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getSource().equals(cnpjtf)){
                somenteNumeroscnpjlb.setVisible(false);
                if(!Cliente.somenteNumeros(cnpjtf.getText())){
                    somenteNumeroscnpjlb.setVisible(true);
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
            if(e.getSource().equals(sair)){
                dispose();
            }else if(e.getSource().equals(limpar)){
                limpar();
            }else if(e.getSource().equals(novo)){
                limpar();
                try {
                    novo();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaCadastroClientePJ.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(e.getSource().equals(cadastrar)){
                boolean testaVazio = pj.testaVazio(nometf.getText());/*Método da classe Cliente*/
                if(!pj.testaVazio(nometf.getText()) || !pj.testaVazio(vencimentotf.getText())){
                    JOptionPane.showMessageDialog(rootPane, "Os campos nome e dia do vencimento devem"
                            + " ser preenchidos");
                }else{
                    String telefone = "("+dddtelefonetf.getText()+")"+telefonetf.getText();
                    String celular = "("+dddcelulartf.getText()+")"+celulartf.getText();
                    pj.setNome(nometf.getText());
                    pj.setTelefone(telefone);
                    pj.setCelular(celular);
                    pj.setEmail(emailtf.getText());
                    pj.setEndereco(enderecotf.getText());
                    pj.setNumero(numerotf.getText());
                    pj.setBairro(bairrotf.getText());
                    pj.setCep(ceptf.getText());
                    pj.setCidade(cidadetf.getText());
                    pj.setUf(uftf.getText());
                    pj.setRazaoSocial(razaoSocialtf.getText());
                    pj.setCnpj(cnpjtf.getText());
                    pj.setInscricaoEstadual(inscricaoEstadualtf.getText());
                    pj.setResponsavel(responsaveltf.getText());
                    pj.setDiaVencimento(vencimentotf.getText());
                    try {
                        pj.cadastrarClientePJ();
                        limpar(); novo(); nometf.grabFocus();
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaCadastroClientePJ.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

        private void limpar() {
            nometf.setText("");
            telefonetf.setText(""); celulartf.setText("");
            dddtelefonetf.setText(""); dddcelulartf.setText("");
            emailtf.setText(""); enderecotf.setText(""); numerotf.setText("");
            bairrotf.setText(""); ceptf.setText("");
            cidadetf.setText(""); uftf.setText("");
            razaoSocialtf.setText(""); cnpjtf.setText("");
            inscricaoEstadualtf.setText(""); responsaveltf.setText("");
            somenteNumeroscnpjlb.setVisible(false);
            somenteNumerostelefonelb.setVisible(false);
            somenteNumeroscelularlb.setVisible(false);
            somenteNumerosnumerolb.setVisible(false);
            somenteNumerosceplb.setVisible(false);
            somenteNumerosvencimentolb.setVisible(false);
            vencimentotf.setText("");
            nometf.grabFocus();
        }
        
    }
    private void novo() throws SQLException {
                exibirNC = String.valueOf(pj.setNumeroCliente());
                this.numeroClientetf.setText(exibirNC);
                nometf.grabFocus();
            }
}
