
package telas;

import classes.Cliente;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaCadastroCliente extends TelaModelo{
    
    protected JPanel PPrincipal;
    
    //Dados da classe Cliente
    protected JLabel numeroClientelb;
    protected JTextField numeroClientetf;
    //Tipo
    protected JLabel nomelb;
    protected JTextField nometf;
    protected JLabel telefonelb;
    protected JLabel somenteNumerostelefonelb;
    protected JTextField telefonetf;
    protected JTextField dddtelefonetf;
    protected JLabel celularlb;
    protected JLabel somenteNumeroscelularlb;
    protected JTextField celulartf;
    protected JTextField dddcelulartf;
    protected JLabel emaillb;
    protected JTextField emailtf;
    protected JLabel enderecolb;
    protected JTextField enderecotf;
    protected JLabel numerolb;
    protected JLabel somenteNumerosnumerolb;
    protected JTextField numerotf;
    protected JLabel bairrolb;
    protected JTextField bairrotf;
    protected JLabel ceplb;
    protected JLabel somenteNumerosceplb;
    protected JTextField ceptf;
    protected JLabel cidadelb;
    protected JTextField cidadetf;
    protected JLabel uflb;
    protected JTextField uftf;
    
    //Pessoa Física
    protected JLabel cpflb;
    protected JTextField cpftf;
    protected JLabel somenteNumeroscpflb;
    protected JLabel rglb;
    protected JLabel somenteNumerosrglb;
    protected JTextField rgtf;
    
    protected JLabel cnpjlb;
    protected JTextField cnpjtf;
    boolean testeSomenteNumeros;
    String exibirNC;
    protected JLabel razaoSocialb;
    protected JTextField razaoSocialtf;
    protected JLabel inscricaoEstaduallb;    
    protected JLabel dataNacimentolb;    
    protected JLabel responsavellb;    
    protected JLabel somenteNumerosdataNacimentolb;    
    protected JTextField inscricaoEstadualtf;
    protected JTextField responsaveltf;
    protected JTextField dataNacimentotf;
    public TelaCadastroCliente(){
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inicializarComponentes();
        this.setVisible(true);
    }

    private void inicializarComponentes() {
        
        PPrincipal = new JPanel();
        PPrincipal.setLayout(null);
        PPrincipal.setSize(750, 480);
        PPrincipal.setLocation(25, 0);
        //PPrincipal.setBackground(Color.yellow);
        this.add(PPrincipal);
        
        numeroClientelb = new JLabel("Número:");
        numeroClientelb.setSize(100, 20);
        numeroClientelb.setLocation(25, 20);
        PPrincipal.add(numeroClientelb);
        numeroClientetf = new JTextField();
        numeroClientetf.setEditable(false);
        numeroClientetf.setToolTipText("Gerado pelo sistema");
        numeroClientetf.setText(exibirNC);
        numeroClientetf.setSize(300, 20);
        numeroClientetf.setLocation(220, 20);
        PPrincipal.add(numeroClientetf);
        
        nomelb = new JLabel("Nome:");
        nomelb.setSize(100, 20);
        nomelb.setLocation(25, 50);
        PPrincipal.add(nomelb);
        PPrincipal.add(nomelb);
        nometf = new JTextField();
        nometf.setSize(300, 20);
        nometf.setLocation(220, 50);
        PPrincipal.add(nometf);
        
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
        emaillb.setSize(200, 20);
        emaillb.setLocation(25, 140);
        PPrincipal.add(emaillb);
        emailtf = new JTextField();
        emailtf.setSize(300, 20);
        emailtf.setLocation(220, 140);
        PPrincipal.add(emailtf);
        
        enderecolb = new JLabel("Endereço:");
        enderecolb.setSize(200, 20);
        enderecolb.setLocation(25, 170);
        PPrincipal.add(enderecolb);
        somenteNumerosnumerolb = new JLabel("Somente Números");
        somenteNumerosnumerolb.setForeground(Color.red);
        somenteNumerosnumerolb.setVisible(false);
        somenteNumerosnumerolb.setSize(200, 20);
        somenteNumerosnumerolb.setLocation(570, 170);
        PPrincipal.add(somenteNumerosnumerolb);
        enderecotf = new JTextField();
        enderecotf.setSize(240, 20);
        enderecotf.setLocation(220, 170);
        PPrincipal.add(enderecotf);
        numerotf = new JTextField();
        numerotf.setToolTipText("Número");
        numerotf.setSize(50, 20);
        numerotf.setLocation(470, 170);
        numerotf.addKeyListener(new trataTeclado());
        PPrincipal.add(numerotf);
        
        bairrolb = new JLabel("Beirro:");
        bairrolb.setSize(200, 20);
        bairrolb.setLocation(25, 200);
        PPrincipal.add(bairrolb);
        bairrotf = new JTextField();
        bairrotf.setSize(300, 20);
        bairrotf.setLocation(220, 200);
        PPrincipal.add(bairrotf);
        
        ceplb = new JLabel("CEP:");
        ceplb.setSize(200, 20);
        ceplb.setLocation(25, 230);
        PPrincipal.add(ceplb);
        somenteNumerosceplb = new JLabel("Somente Números");
        somenteNumerosceplb.setForeground(Color.red);
        somenteNumerosceplb.setVisible(false);
        somenteNumerosceplb.setSize(200, 20);
        somenteNumerosceplb.setLocation(570, 230);
        PPrincipal.add(somenteNumerosceplb);
        ceptf = new JTextField();
        ceptf.setSize(300, 20);
        ceptf.setLocation(220, 230);
        ceptf.addKeyListener(new trataTeclado());
        PPrincipal.add(ceptf);
        
        cidadelb = new JLabel("Cidade:");
        cidadelb.setSize(200, 20);
        cidadelb.setLocation(25, 260);
        PPrincipal.add(cidadelb);
        cidadetf = new JTextField();
        cidadetf.setSize(300, 20);
        cidadetf.setLocation(220, 260);
        PPrincipal.add(cidadetf);
        
        uflb = new JLabel("UF:");
        uflb.setSize(200, 20);
        uflb.setLocation(25, 290);
        PPrincipal.add(uflb);
        uftf = new JTextField();
        uftf.setSize(25, 20);
        uftf.setLocation(220, 290);
        PPrincipal.add(uftf);
        
        cpflb = new JLabel("CPF:");
        cpflb.setSize(200, 20);
        cpflb.setLocation(25, 320);
        cpflb.setVisible(false);
        PPrincipal.add(cpflb);
        somenteNumeroscpflb = new JLabel("Somente Números");
        somenteNumeroscpflb.setForeground(Color.red);
        somenteNumeroscpflb.setVisible(false);
        somenteNumeroscpflb.setSize(200, 20);
        somenteNumeroscpflb.setLocation(570, 320);
        PPrincipal.add(somenteNumeroscpflb);
        cpftf = new JTextField();
        cpftf.setSize(200, 20);
        cpftf.setLocation(220, 320);
        cpftf.setVisible(false);
        PPrincipal.add(cpftf);
        
        rglb = new JLabel("RG:");
        rglb.setSize(200, 20);
        rglb.setLocation(25, 350);
        rglb.setVisible(false);
        PPrincipal.add(rglb);
        somenteNumerosrglb = new JLabel("Somente Números");
        somenteNumerosrglb.setForeground(Color.red);
        somenteNumerosrglb.setVisible(false);
        somenteNumerosrglb.setSize(200, 20);
        somenteNumerosrglb.setLocation(570, 350);
        PPrincipal.add(somenteNumerosrglb);
        rgtf = new JTextField();
        rgtf.setSize(200, 20);
        rgtf.setLocation(220, 350);
        rgtf.setVisible(false);
        PPrincipal.add(rgtf);
        
        dataNacimentolb = new JLabel("Data Nacimento:");
        dataNacimentolb.setSize(200, 20);
        dataNacimentolb.setLocation(25, 380);
        dataNacimentolb.setVisible(false);
        PPrincipal.add(dataNacimentolb);
        somenteNumerosdataNacimentolb = new JLabel("Somente Números");
        somenteNumerosdataNacimentolb.setForeground(Color.red);
        somenteNumerosdataNacimentolb.setVisible(false);
        somenteNumerosdataNacimentolb.setSize(200, 20);
        somenteNumerosdataNacimentolb.setLocation(570, 380);
        PPrincipal.add(somenteNumerosdataNacimentolb);
        dataNacimentotf = new JTextField();
        dataNacimentotf.setSize(200, 20);
        dataNacimentotf.setLocation(220, 380);
        dataNacimentotf.setVisible(false);
        PPrincipal.add(dataNacimentotf);
        
        razaoSocialb = new JLabel("Razão Social:");
        razaoSocialb.setSize(200, 20);
        razaoSocialb.setLocation(25, 320);
        razaoSocialb.setVisible(false);
        PPrincipal.add(razaoSocialb);
        razaoSocialtf = new JTextField();
        razaoSocialtf.setSize(200, 20);
        razaoSocialtf.setLocation(220, 320);
        razaoSocialtf.setVisible(false);
        PPrincipal.add(razaoSocialtf);
        
        cnpjlb = new JLabel("CNPJ:");
        cnpjlb.setSize(200, 20);
        cnpjlb.setLocation(25, 350);
        cnpjlb.setVisible(false);
        PPrincipal.add(cnpjlb);
        cnpjtf = new JTextField();
        cnpjtf.setSize(200, 20);
        cnpjtf.setLocation(220, 350);
        cnpjtf.setVisible(false);
        PPrincipal.add(cnpjtf);
        
        inscricaoEstaduallb = new JLabel("Inscricao Estadual:");
        inscricaoEstaduallb.setSize(200, 20);
        inscricaoEstaduallb.setLocation(25, 380);
        inscricaoEstaduallb.setVisible(false);
        PPrincipal.add(inscricaoEstaduallb);
        inscricaoEstadualtf = new JTextField();
        inscricaoEstadualtf.setSize(200, 20);
        inscricaoEstadualtf.setLocation(220, 380);
        inscricaoEstadualtf.setVisible(false);
        PPrincipal.add(inscricaoEstadualtf);
        
        responsavellb = new JLabel("Responsável:");
        responsavellb.setSize(200, 20);
        responsavellb.setLocation(25, 410);
        responsavellb.setVisible(false);
        PPrincipal.add(responsavellb);
        responsaveltf = new JTextField();
        responsaveltf.setSize(200, 20);
        responsaveltf.setLocation(220, 410);
        responsaveltf.setVisible(false);
        PPrincipal.add(responsaveltf);
        
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
            /*Chama o método static da classe Cliente que testa se o usuário digitou
                 somente números no campo cpf*/
            if(e.getSource().equals(telefonetf)){
                somenteNumerostelefonelb.setVisible(false);
                if(!Cliente.somenteNumeros(telefonetf.getText())){
                    somenteNumerostelefonelb.setVisible(true);
                }
            }else if(e.getSource().equals(dddtelefonetf)){
                somenteNumerostelefonelb.setVisible(false);
                if(!Cliente.somenteNumeros(dddtelefonetf.getText())){
                    somenteNumerostelefonelb.setVisible(true);
                }
            }else if(e.getSource().equals(celulartf)){
                somenteNumeroscelularlb.setVisible(false);
                if(!Cliente.somenteNumeros(celulartf.getText())){
                    somenteNumeroscelularlb.setVisible(true);
                }
            }else if(e.getSource().equals(dddcelulartf)){
                somenteNumeroscelularlb.setVisible(false);
                if(!Cliente.somenteNumeros(dddcelulartf.getText())){
                    somenteNumeroscelularlb.setVisible(true);
                }
            }else if(e.getSource().equals(numerotf)){
                somenteNumerosnumerolb.setVisible(false);
                if(!Cliente.somenteNumeros(numerotf.getText())){
                    somenteNumerosnumerolb.setVisible(true);
                }
            }else if(e.getSource().equals(ceptf)){
                somenteNumerosceplb.setVisible(false);
                if(!Cliente.somenteNumeros(ceptf.getText())){
                    somenteNumerosceplb.setVisible(true);
                }
            }
        }
        
}
}
