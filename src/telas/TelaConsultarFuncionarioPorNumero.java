
package telas;

import classes.ConectaDB;
import classes.Funcionario;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaConsultarFuncionarioPorNumero extends TelaModelo{
    protected JPanel PBotoes;
    protected JPanel PPrincipal;
    protected JLabel codigoFuncionariolb;
    protected JTextField codigoFuncionariotf;
    protected JLabel cpflb;
    protected JLabel somenteNumeroscpflb;
    protected JTextField cpftf;
    protected JLabel somenteNumerosCodFuncionariolb;
    protected JLabel somenteNumeroscarteiraTrabalholb;
    protected JLabel somenteNumerosrglb;
    protected JLabel somenteNumerospislb;
    protected JLabel somenteNumerostelefonelb;
    protected JLabel somenteNumeroscelularlb;
    protected JLabel somenteNumerosceplb;
    protected JLabel nomelb;
    protected JTextField nometf;
    protected JLabel rglb;
    protected JTextField rgtf;
    protected JLabel carteiraTrabalholb;
    protected JTextField carteiraTrabalhotf;
    protected JLabel pislb;
    protected JTextField pistf;
    protected JLabel telefonelb;
    protected JTextField telefonetf;
    protected JLabel celularlb;
    protected JTextField celulartf;
    protected JLabel emaillb;
    protected JTextField emailtf;
    protected JLabel enderecolb;
    protected JTextField enderecotf;
    protected JLabel complementolb;
    protected JTextField complementotf;
    protected JLabel bairrolb;
    protected JTextField bairrotf;
    protected JLabel ceplb;
    protected JTextField ceptf;
    protected JLabel cidadelb;
    protected JTextField cidadetf;
    protected JLabel uflb;
    protected JTextField uftf;
    protected JLabel dataAdmissaolb;
    protected JTextField dataAdmissaotf;
    protected JLabel dataDemissaolb;
    protected JTextField dataDemissaotf;
    protected ConectaDB cdb;
    protected JButton sair;
    
    protected int testeSomenteNumeros[] = new int[7];
    public TelaConsultarFuncionarioPorNumero(){
        this.setLayout(null);
        this.setTitle("Consultar Funcionário");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 650);
        this.setLocation(140, 50);
        
        inicializarComponentes();
        this.setVisible(true);
        zeraTesteSomenteNumeros();
    }

    private void inicializarComponentes() {
                
        PPrincipal = new JPanel();
        PPrincipal.setLayout(null);
        //PPrincipal.setBackground(Color.yellow);
        PPrincipal.setSize(750, 550);
        PPrincipal.setLocation(25, 0);
        this.add(PPrincipal);
        
        PBotoes = new JPanel();
        PBotoes.setLayout(null);
        //PBotoes.setBackground(Color.yellow);
        PBotoes.setSize(750, 40);
        PBotoes.setLocation(25, 570);
        this.add(PBotoes);
        
        codigoFuncionariolb = new JLabel("Número:");
        codigoFuncionariolb.setSize(100, 20);
        codigoFuncionariolb.setLocation(10, 20);
        PPrincipal.add(codigoFuncionariolb);
        somenteNumerosCodFuncionariolb = new JLabel("Somente Números");
        somenteNumerosCodFuncionariolb.setForeground(Color.red);
        somenteNumerosCodFuncionariolb.setVisible(false);
        somenteNumerosCodFuncionariolb.setSize(200, 20);
        somenteNumerosCodFuncionariolb.setLocation(550, 20);
        PPrincipal.add(somenteNumerosCodFuncionariolb);
        codigoFuncionariotf = new JTextField();
        codigoFuncionariotf.setToolTipText("Digite o Número do Funcioário");
        codigoFuncionariotf.setSize(300, 20);
        codigoFuncionariotf.setLocation(220, 20);
        codigoFuncionariotf.addKeyListener(new TrataTeclado());
        PPrincipal.add(codigoFuncionariotf);
        
        cpflb = new JLabel("CPF:");
        cpflb.setSize(100, 20);
        cpflb.setLocation(10, 80);
        PPrincipal.add(cpflb);
        somenteNumeroscpflb = new JLabel("Somente Números");
        somenteNumeroscpflb.setForeground(Color.red);
        somenteNumeroscpflb.setVisible(false);
        somenteNumeroscpflb.setSize(200, 20);
        somenteNumeroscpflb.setLocation(550, 80);
        PPrincipal.add(somenteNumeroscpflb);
        cpftf = new JTextField();
        cpftf.setEditable(false);
        cpftf.setSize(300, 20);
        cpftf.setLocation(220, 80);
        cpftf.addKeyListener(new TrataTeclado());
        PPrincipal.add(cpftf);
        
        nomelb = new JLabel("Nome:");
        nomelb.setSize(100, 20);
        nomelb.setLocation(10, 50);
        PPrincipal.add(nomelb);
        nometf = new JTextField();
        nometf.setEditable(false);
        nometf.setSize(300, 20);
        nometf.setLocation(220, 50);
        PPrincipal.add(nometf);
        
        rglb = new JLabel("RG:");
        rglb.setSize(100, 20);
        rglb.setLocation(10, 110);
        PPrincipal.add(rglb);
        somenteNumerosrglb = new JLabel("Somente Números");
        somenteNumerosrglb.setForeground(Color.red);
        somenteNumerosrglb.setVisible(false);
        somenteNumerosrglb.setSize(200, 20);
        somenteNumerosrglb.setLocation(550, 110);
        PPrincipal.add(somenteNumerosrglb);
        rgtf = new JTextField();
        rgtf.setEditable(false);
        rgtf.setSize(300, 20);
        rgtf.setLocation(220, 110);
        rgtf.addKeyListener(new TrataTeclado());
        PPrincipal.add(rgtf);
        
        carteiraTrabalholb = new JLabel("Carteira de Trabalho:");
        carteiraTrabalholb.setSize(200, 20);
        carteiraTrabalholb.setLocation(10, 140);
        PPrincipal.add(carteiraTrabalholb);
        somenteNumeroscarteiraTrabalholb = new JLabel("Somente Números");
        somenteNumeroscarteiraTrabalholb.setForeground(Color.red);
        somenteNumeroscarteiraTrabalholb.setVisible(false);
        somenteNumeroscarteiraTrabalholb.setSize(200, 20);
        somenteNumeroscarteiraTrabalholb.setLocation(550, 140);
        PPrincipal.add(somenteNumeroscarteiraTrabalholb);
        carteiraTrabalhotf = new JTextField();
        carteiraTrabalhotf.setEditable(false);
        carteiraTrabalhotf.setSize(300, 20);
        carteiraTrabalhotf.setLocation(220, 140);
        carteiraTrabalhotf.addKeyListener(new TrataTeclado());
        PPrincipal.add(carteiraTrabalhotf);
        
        pislb = new JLabel("PIS:");
        pislb.setSize(200, 20);
        pislb.setLocation(10, 170);
        PPrincipal.add(pislb);
        somenteNumerospislb = new JLabel("Somente Números");
        somenteNumerospislb.setForeground(Color.red);
        somenteNumerospislb.setVisible(false);
        somenteNumerospislb.setSize(200, 20);
        somenteNumerospislb.setLocation(550, 170);
        PPrincipal.add(somenteNumerospislb);
        pistf = new JTextField();
        pistf.setEditable(false);
        pistf.setSize(300, 20);
        pistf.setLocation(220, 170);
        pistf.addKeyListener(new TrataTeclado());
        PPrincipal.add(pistf);
        
        telefonelb = new JLabel("Telefone Fixo:");
        telefonelb.setSize(200, 20);
        telefonelb.setLocation(10, 200);
        PPrincipal.add(telefonelb);
        somenteNumerostelefonelb = new JLabel("Somente Números");
        somenteNumerostelefonelb.setForeground(Color.red);
        somenteNumerostelefonelb.setVisible(false);
        somenteNumerostelefonelb.setSize(200, 20);
        somenteNumerostelefonelb.setLocation(550, 200);
        PPrincipal.add(somenteNumerostelefonelb);
        telefonetf = new JTextField();
        telefonetf.setEditable(false);
        telefonetf.setSize(300, 20);
        telefonetf.setLocation(220, 200);
        telefonetf.addKeyListener(new TrataTeclado());
        PPrincipal.add(telefonetf);

        celularlb = new JLabel("Celular:");
        celularlb.setSize(200, 20);
        celularlb.setLocation(10, 230);
        PPrincipal.add(celularlb);
        somenteNumeroscelularlb = new JLabel("Somente Números");
        somenteNumeroscelularlb.setForeground(Color.red);
        somenteNumeroscelularlb.setVisible(false);
        somenteNumeroscelularlb.setSize(200, 20);
        somenteNumeroscelularlb.setLocation(550, 230);
        PPrincipal.add(somenteNumeroscelularlb);
        celulartf = new JTextField();
        celulartf.setEditable(false);
        celulartf.setSize(300, 20);
        celulartf.setLocation(220, 230);
        celulartf.addKeyListener(new TrataTeclado());
        PPrincipal.add(celulartf);
        
        emaillb = new JLabel("E-MAIL:");
        emaillb.setSize(200, 20);
        emaillb.setLocation(10, 260);
        PPrincipal.add(emaillb);
        emailtf = new JTextField();
        emailtf.setEditable(false);
        emailtf.setSize(300, 20);
        emailtf.setLocation(220, 260);
        PPrincipal.add(emailtf);
        
        enderecolb = new JLabel("Endereço:");
        enderecolb.setSize(200, 20);
        enderecolb.setLocation(10, 290);
        PPrincipal.add(enderecolb);
        enderecotf = new JTextField();
        enderecotf.setEditable(false);
        enderecotf.setSize(300, 20);
        enderecotf.setLocation(220, 290);
        PPrincipal.add(enderecotf);
        
        complementolb = new JLabel("Complemento:");
        complementolb.setSize(200, 20);
        complementolb.setLocation(10, 320);
        PPrincipal.add(complementolb);
        complementotf = new JTextField();
        complementotf.setEditable(false);
        complementotf.setSize(300, 20);
        complementotf.setLocation(220, 320);
        PPrincipal.add(complementotf);
        
        bairrolb = new JLabel("Bairro:");
        bairrolb.setSize(200, 20);
        bairrolb.setLocation(10, 350);
        PPrincipal.add(bairrolb);
        bairrotf = new JTextField();
        bairrotf.setEditable(false);
        bairrotf.setSize(300, 20);
        bairrotf.setLocation(220, 350);
        PPrincipal.add(bairrotf);
        
        ceplb = new JLabel("CEP:");
        ceplb.setSize(200, 20);
        ceplb.setLocation(10, 380);
        PPrincipal.add(ceplb);
        somenteNumerosceplb = new JLabel("Somente Números");
        somenteNumerosceplb.setForeground(Color.red);
        somenteNumerosceplb.setVisible(false);
        somenteNumerosceplb.setSize(200, 20);
        somenteNumerosceplb.setLocation(550, 380);
        PPrincipal.add(somenteNumerosceplb);
        ceptf = new JTextField();
        ceptf.setEditable(false);
        ceptf.setSize(300, 20);
        ceptf.setLocation(220, 380);
        ceptf.addKeyListener(new TrataTeclado());
        PPrincipal.add(ceptf);
        
        cidadelb = new JLabel("Cidade:");
        cidadelb.setSize(200, 20);
        cidadelb.setLocation(10, 410);
        PPrincipal.add(cidadelb);
        cidadetf = new JTextField();
        cidadetf.setEditable(false);
        cidadetf.setSize(150, 20);
        cidadetf.setLocation(220, 410);
        PPrincipal.add(cidadetf);
        
        uflb = new JLabel("UF:");
        uflb.setSize(200, 20);
        uflb.setLocation(10, 440);
        PPrincipal.add(uflb);
        uftf = new JTextField();
        uftf.setEditable(false);
        uftf.setSize(25, 20);
        uftf.setLocation(220, 440);
        PPrincipal.add(uftf);

        dataAdmissaolb = new JLabel("Data de Admissão:");
        dataAdmissaolb.setSize(200, 20);
        dataAdmissaolb.setLocation(10, 470);
        PPrincipal.add(dataAdmissaolb);
        dataAdmissaotf = new JTextField();
        dataAdmissaotf.setEditable(false);
        dataAdmissaotf.setSize(150, 20);
        dataAdmissaotf.setLocation(220, 470);
        PPrincipal.add(dataAdmissaotf);
        
        dataDemissaolb = new JLabel("Data de Demissão:");
        dataDemissaolb.setSize(200, 20);
        dataDemissaolb.setLocation(10, 500);
        PPrincipal.add(dataDemissaolb);
        dataDemissaotf = new JTextField();
        dataDemissaotf.setEditable(false);
        dataDemissaotf.setEditable(false);
        dataDemissaotf.setSize(150, 20);
        dataDemissaotf.setLocation(220, 500);
        PPrincipal.add(dataDemissaotf);
        
        sair = new JButton("Sair");
        sair.setSize(130, 20);
        sair.setLocation(310, 10);
        sair.addActionListener(new TrataBotao());
        PBotoes.add(sair);
    }
    
    protected void limpar() {
         nometf.setText("");
         cpftf.setText("");
         rgtf.setText("");
         carteiraTrabalhotf.setText("");
         pistf.setText("");
         telefonetf.setText("");
         celulartf.setText("");
         emailtf.setText("");
         enderecotf.setText("");
         complementotf.setText("");
         bairrotf.setText("");
         ceptf.setText("");
         cidadetf.setText("");
         uftf.setText("");
         dataAdmissaotf.setText("");
         dataDemissaotf.setText("");
         
        }
    
    private void zeraTesteSomenteNumeros() {
        for(int c = 0; c < testeSomenteNumeros.length; c ++){
            testeSomenteNumeros[c] = 0;
        }
    }
    
    protected void limpaSomenteNumeros() {
        somenteNumerosCodFuncionariolb.setVisible(false);
        somenteNumeroscpflb.setVisible(false);
        somenteNumerosrglb.setVisible(false);
        somenteNumeroscarteiraTrabalholb.setVisible(false);
        somenteNumerospislb.setVisible(false);
        somenteNumerostelefonelb.setVisible(false);
        somenteNumeroscelularlb.setVisible(false);
        somenteNumerosceplb.setVisible(false);
    }
    
    public class TrataTeclado implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            zeraTesteSomenteNumeros();
            limpaSomenteNumeros();
            if(e.getSource().equals(codigoFuncionariotf)){
                limpar(); zeraTesteSomenteNumeros(); limpaSomenteNumeros();
                ResultSet r;
                cdb = new ConectaDB();
                r = cdb.pesquisaDB("select * from Funcionario "
                        + "where codigoFuncionario = '"+codigoFuncionariotf.getText()+"'");
                try {
                    while(r.next()){
                        limpaSomenteNumeros(); zeraTesteSomenteNumeros();
                        nometf.setText((String) r.getObject(2));
                        cpftf.setText((String) r.getObject(3));
                        rgtf.setText((String) r.getObject(4));
                        carteiraTrabalhotf.setText((String) r.getObject(5));
                        pistf.setText((String) r.getObject(6));
                        telefonetf.setText((String) r.getObject(7));
                        celulartf.setText((String) r.getObject(8));
                        emailtf.setText((String) (r.getObject(9)));
                        enderecotf.setText((String) r.getObject(10));
                        complementotf.setText((String) r.getObject(11));
                        bairrotf.setText((String) r.getObject(12));
                        ceptf.setText((String) r.getObject(13));
                        cidadetf.setText((String) r.getObject(14));
                        uftf.setText((String) r.getObject(17));
                        dataAdmissaotf.setText(String.valueOf(r.getObject(15)));
                        dataDemissaotf.setText(String.valueOf(r.getObject(16)));
                                                
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(TelaConsultarFuncionarioPorNumero.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(e.getSource().equals(cpftf)){
                if(!Funcionario.somenteNumeros(cpftf.getText())){
                    testeSomenteNumeros[0] = 1;
                    somenteNumeroscpflb.setVisible(true);
                }
            }
            else if(e.getSource().equals(rgtf)){
                if(!Funcionario.somenteNumeros(rgtf.getText())){
                    testeSomenteNumeros[1] = 1;
                    somenteNumerosrglb.setVisible(true);
                }
            }
            else if(e.getSource().equals(carteiraTrabalhotf)){
                if(!Funcionario.somenteNumeros(carteiraTrabalhotf.getText())){
                    testeSomenteNumeros[2] = 1;
                    somenteNumeroscarteiraTrabalholb.setVisible(true);
                }
            }
            else if(e.getSource().equals(pistf)){
                if(!Funcionario.somenteNumeros(pistf.getText())){
                    testeSomenteNumeros[3] = 1;
                    somenteNumerospislb.setVisible(true);
                }
            }
            else if(e.getSource().equals(telefonetf)){
                if(!Funcionario.somenteNumeros(telefonetf.getText())){
                    testeSomenteNumeros[4] = 1;
                    somenteNumerostelefonelb.setVisible(true);
                }
            }
            else if(e.getSource().equals(celulartf)){
                if(!Funcionario.somenteNumeros(celulartf.getText())){
                    testeSomenteNumeros[5] = 1;
                    somenteNumeroscelularlb.setVisible(true);
                }
            }
            else if(e.getSource().equals(ceptf)){
                if(!Funcionario.somenteNumeros(ceptf.getText())){
                    testeSomenteNumeros[6] = 1;
                    somenteNumerosceplb.setVisible(true);
                }
            }
        }

    }
    
    public class TrataBotao implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(sair)){
                dispose();
            }
        }
        
    }
}
