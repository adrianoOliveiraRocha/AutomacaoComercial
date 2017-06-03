
package telas;

import classes.Administrador;
import classes.ConectaDB;
import classes.Funcionario;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaNovoAdministrador extends TelaModelo{
    
    private final Administrador ad;
    private final ConectaDB cdb;
    private JPanel PPrincipal;
    private JPanel PBotoes;
    private JLabel loginlb;
    private JTextField logintf;
    private JLabel senhalb;
    private JTextField senhatf;
    private JLabel respostalb;
    JButton cadastrar;
    private JButton limpar;
    private JButton sair;
    private JLabel nomelb;
    private JTextField nometf;
    private JLabel rglb;
    private JLabel somenteNumerosrglb;
    private JTextField rgtf;
    private JLabel carteiraTrabalholb;
    private JLabel somenteNumeroscarteiraTrabalholb;
    private JTextField carteiraTrabalhotf;
    private JLabel pislb;
    private JLabel somenteNumerospislb;
    private JTextField pistf;
    private JLabel telefonelb;
    private JLabel somenteNumerostelefonelb;
    private JLabel dddlb;
    private JLabel numerolb;
    private JTextField dddtf;
    private JTextField numerotf;
    private JLabel celularlb;
    private JLabel somenteNumeroscelularlb;
    private JLabel dddcelularlb;
    private JLabel numerocelularlb;
    private JTextField dddcelulartf;
    private JTextField numerocelulartf;
    private JLabel emaillb;
    private JTextField emailtf;
    private JLabel enderecolb;
    private JLabel somenteNumerosnumeroEnderecolb;
    private JTextField ruatf;
    private JTextField numeroenderecotf;
    private JLabel complementolb;
    private JTextField complementotf;
    private JLabel ceplb;
    private JLabel somenteNumerosCeplb;
    private JTextField ceptf;
    private JLabel bairrolb;
    private JTextField bairrotf;
    private JLabel cidadelb;
    private JTextField cidadetf;
    private JLabel uflb;
    private JTextField uftf;
    private JLabel dataAdmissaolb;
    private JLabel somenteNumerosdataAdmissaolb;
    private JLabel formatodataAdmissaolb;
    private JLabel diaAdmissaolb;
    private JTextField diaAdmissaotf;
    private JLabel mesAdmissaolb;
    private JTextField mesAdmissaotf;
    private JLabel anoAdmissaolb;
    private JTextField anoAdmissaotf;
    private JLabel cpflb;
    private JTextField cpftf;
    private JLabel somenteNumeroscpflb;
    
    public TelaNovoAdministrador(){
        
        ad = new Administrador();
        this.setTitle("Novo Administrador");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 640);
        this.setLocation(140, 25);
        cdb = new ConectaDB();
        innicializarComponentes();
        naoEditavel(); 
        this.setVisible(true);
    }

    private void innicializarComponentes() {
        PPrincipal = new JPanel();
        //PPrincipal.setBackground(Color.yellow);
        PPrincipal.setLayout(null);
        PPrincipal.setSize(750, 570);
        PPrincipal.setLocation(25, 0);
        this.add(PPrincipal);
        
        PBotoes = new JPanel();
        //PBotoes.setBackground(Color.yellow);
        PBotoes.setLayout(null);
        PBotoes.setSize(750, 40);
        PBotoes.setLocation(25, 580);
        this.add(PBotoes);
        
        loginlb = new JLabel("Login:");
        loginlb.setSize(100, 20);
        loginlb.setLocation(10, 20);
        PPrincipal.add(loginlb);
        
        logintf = new JTextField();
        logintf.grabFocus();
        logintf.setToolTipText("Digite o login do novo Administrador");
        logintf.setSize(300, 20);
        logintf.setLocation(220, 20);
        logintf.addKeyListener(new TrataTeclado());
        PPrincipal.add(logintf);
        
        respostalb = new JLabel();
        respostalb.setForeground(Color.blue);
        //respostalb.setVisible(false);
        respostalb.setSize(520, 20);
        respostalb.setLocation(550, 20);
        PPrincipal.add(respostalb);
        
        senhalb = new JLabel("Senha:");
        senhalb.setSize(100, 20);
        senhalb.setLocation(10, 50);
        PPrincipal.add(senhalb);
        senhatf = new JTextField();
        senhatf.setEditable(false);
        senhatf.setEditable(false);
        senhatf.setToolTipText("Digite a senha do novo Administrador");
        senhatf.setSize(300, 20);
        senhatf.setLocation(220, 50);
        senhatf.addKeyListener(new TrataTeclado());
        PPrincipal.add(senhatf);
        
        nomelb = new JLabel("Nome:*");
        nomelb.setSize(100, 20);
        nomelb.setLocation(10, 80);
        PPrincipal.add(nomelb);
        nometf = new JTextField();
        nometf.setSize(300, 20);
        nometf.setLocation(220, 80);
        PPrincipal.add(nometf);
        
        cpflb = new JLabel("CPF:*");
        cpflb.setSize(100, 20);
        cpflb.setLocation(10, 110);
        PPrincipal.add(cpflb);
        somenteNumeroscpflb = new JLabel("Somente Números");
        somenteNumeroscpflb.setForeground(Color.red);
        somenteNumeroscpflb.setVisible(false);
        somenteNumeroscpflb.setSize(200, 20);
        somenteNumeroscpflb.setLocation(550, 110);
        PPrincipal.add(somenteNumeroscpflb);
        cpftf = new JTextField();
        cpftf.setSize(300, 20);
        cpftf.setLocation(220, 110);
        cpftf.addKeyListener(new TrataTeclado());
        PPrincipal.add(cpftf);
        
        rglb = new JLabel("RG:*");
        rglb.setSize(100, 20);
        rglb.setLocation(10, 140);
        PPrincipal.add(rglb);
        somenteNumerosrglb = new JLabel("Somente Números");
        somenteNumerosrglb.setForeground(Color.red);
        somenteNumerosrglb.setVisible(false);
        somenteNumerosrglb.setSize(200, 20);
        somenteNumerosrglb.setLocation(550, 140);
        PPrincipal.add(somenteNumerosrglb);
        rgtf = new JTextField();
        rgtf.addKeyListener(new TrataTeclado());
        rgtf.setSize(300, 20);
        rgtf.setLocation(220, 140);
        PPrincipal.add(rgtf);
        
        carteiraTrabalholb = new JLabel("Carteira de Trabalho:*");
        carteiraTrabalholb.setSize(200, 20);
        carteiraTrabalholb.setLocation(10, 170);
        PPrincipal.add(carteiraTrabalholb);
        somenteNumeroscarteiraTrabalholb = new JLabel("Somente Números");
        somenteNumeroscarteiraTrabalholb.setForeground(Color.red);
        somenteNumeroscarteiraTrabalholb.setVisible(false);
        somenteNumeroscarteiraTrabalholb.setSize(200, 20);
        somenteNumeroscarteiraTrabalholb.setLocation(550, 170);
        PPrincipal.add(somenteNumeroscarteiraTrabalholb);
        carteiraTrabalhotf = new JTextField();
        carteiraTrabalhotf.setSize(300, 20);
        carteiraTrabalhotf.setLocation(220, 170);
        carteiraTrabalhotf.addKeyListener(new TrataTeclado());
        PPrincipal.add(carteiraTrabalhotf);

        pislb = new JLabel("PIS:");
        pislb.setSize(200, 20);
        pislb.setLocation(10, 200);
        PPrincipal.add(pislb);
        somenteNumerospislb = new JLabel("Somente Números");
        somenteNumerospislb.setForeground(Color.red);
        somenteNumerospislb.setVisible(false);
        somenteNumerospislb.setSize(200, 20);
        somenteNumerospislb.setLocation(550, 200);
        PPrincipal.add(somenteNumerospislb);
        pistf = new JTextField();
        pistf.setSize(300, 20);
        pistf.setLocation(220, 200);
        pistf.addKeyListener(new TrataTeclado());
        PPrincipal.add(pistf);
        
        telefonelb = new JLabel("Telefone Fixo:");
        telefonelb.setSize(200, 20);
        telefonelb.setLocation(10, 230);
        PPrincipal.add(telefonelb);
        somenteNumerostelefonelb = new JLabel("Somente Números");
        somenteNumerostelefonelb.setForeground(Color.red);
        somenteNumerostelefonelb.setVisible(false);
        somenteNumerostelefonelb.setSize(200, 20);
        somenteNumerostelefonelb.setLocation(550, 230);
        PPrincipal.add(somenteNumerostelefonelb);
        dddlb = new JLabel("DDD:");
        dddlb.setSize(50, 20);
        dddlb.setLocation(220, 230);
        PPrincipal.add(dddlb);
        numerolb = new JLabel("Número:");
        numerolb.setSize(100, 20);
        numerolb.setLocation(340, 230);
        PPrincipal.add(numerolb);
        dddtf = new JTextField();
        dddtf.setSize(35, 20);
        dddtf.setLocation(275, 230);
        dddtf.addKeyListener(new TrataTeclado());
        PPrincipal.add(dddtf);
        numerotf = new JTextField();
        numerotf.setSize(100, 20);
        numerotf.setLocation(420, 230);
        numerotf.addKeyListener(new TrataTeclado());
        PPrincipal.add(numerotf);
        
        celularlb = new JLabel("Celular:");
        celularlb.setSize(200, 20);
        celularlb.setLocation(10, 260);
        PPrincipal.add(celularlb);
        somenteNumeroscelularlb = new JLabel("Somente Números");
        somenteNumeroscelularlb.setForeground(Color.red);
        somenteNumeroscelularlb.setVisible(false);
        somenteNumeroscelularlb.setSize(200, 20);
        somenteNumeroscelularlb.setLocation(550, 260);
        PPrincipal.add(somenteNumeroscelularlb);
        dddcelularlb = new JLabel("DDD:");
        dddcelularlb.setSize(50, 20);
        dddcelularlb.setLocation(220, 260);
        PPrincipal.add(dddcelularlb);
        numerocelularlb = new JLabel("Número:");
        numerocelularlb.setSize(100, 20);
        numerocelularlb.setLocation(340, 260);
        PPrincipal.add(numerocelularlb);
        dddcelulartf = new JTextField();
        dddcelulartf.setSize(35, 20);
        dddcelulartf.setLocation(275, 260);
        dddcelulartf.addKeyListener(new TrataTeclado());
        PPrincipal.add(dddcelulartf);
        numerocelulartf = new JTextField();
        numerocelulartf.setSize(100, 20);
        numerocelulartf.setLocation(420, 260);
        numerocelulartf.addKeyListener(new TrataTeclado());
        PPrincipal.add(numerocelulartf);
                
        emaillb = new JLabel("E-MAIL:");
        emaillb.setSize(200, 20);
        emaillb.setLocation(10, 290);
        PPrincipal.add(emaillb);
        emailtf = new JTextField();
        emailtf.setSize(300, 20);
        emailtf.setLocation(220, 290);
        PPrincipal.add(emailtf);
        
        enderecolb = new JLabel("Endereço:");
        enderecolb.setSize(200, 20);
        enderecolb.setLocation(10, 320);
        PPrincipal.add(enderecolb);
        somenteNumerosnumeroEnderecolb = new JLabel("Somente Números");
        somenteNumerosnumeroEnderecolb.setForeground(Color.red);
        somenteNumerosnumeroEnderecolb.setVisible(false);
        somenteNumerosnumeroEnderecolb.setSize(200, 20);
        somenteNumerosnumeroEnderecolb.setLocation(550, 320);
        PPrincipal.add(somenteNumerosnumeroEnderecolb);
        ruatf = new JTextField();
        ruatf.setSize(240, 20);
        ruatf.setLocation(220, 320);
        PPrincipal.add(ruatf);
        numeroenderecotf = new JTextField();
        numeroenderecotf.setToolTipText("Número");
        numeroenderecotf.setSize(50, 20);
        numeroenderecotf.setLocation(470, 320);
        numeroenderecotf.addKeyListener(new TrataTeclado());
        PPrincipal.add(numeroenderecotf);

        complementolb = new JLabel("Complemento:");
        complementolb.setSize(200, 20);
        complementolb.setLocation(10, 350);
        PPrincipal.add(complementolb);
        complementotf = new JTextField();
        complementotf.setSize(300, 20);
        complementotf.setLocation(220, 350);
        PPrincipal.add(complementotf);
        
        bairrolb = new JLabel("Bairro:");
        bairrolb.setSize(200, 20);
        bairrolb.setLocation(10, 380);
        PPrincipal.add(bairrolb);
        bairrotf = new JTextField();
        bairrotf.setSize(300, 20);
        bairrotf.setLocation(220, 380);
        PPrincipal.add(bairrotf);
        
        ceplb = new JLabel("CEP:");
        ceplb.setSize(200, 20);
        ceplb.setLocation(10, 410);
        PPrincipal.add(ceplb);
        somenteNumerosCeplb = new JLabel("Somente Números");
        somenteNumerosCeplb.setForeground(Color.red);
        somenteNumerosCeplb.setVisible(false);
        somenteNumerosCeplb.setSize(200, 20);
        somenteNumerosCeplb.setLocation(550, 410);
        PPrincipal.add(somenteNumerosCeplb);
        ceptf = new JTextField();
        ceptf.setSize(300, 20);
        ceptf.setLocation(220, 410);
        ceptf.addKeyListener(new TrataTeclado());
        PPrincipal.add(ceptf);
        
        cidadelb = new JLabel("Cidade:");
        cidadelb.setSize(200, 20);
        cidadelb.setLocation(10, 440);
        PPrincipal.add(cidadelb);
        cidadetf = new JTextField();
        cidadetf.setSize(150, 20);
        cidadetf.setLocation(220, 440);
        PPrincipal.add(cidadetf);
        
        uflb = new JLabel("UF:");
        uflb.setSize(200, 20);
        uflb.setLocation(10, 470);
        PPrincipal.add(uflb);
        uftf = new JTextField();
        uftf.setSize(25, 20);
        uftf.setLocation(220, 470);
        PPrincipal.add(uftf);
        
        dataAdmissaolb = new JLabel("Data de Admissão:*");
        dataAdmissaolb.setSize(200, 20);
        dataAdmissaolb.setLocation(10, 530);
        PPrincipal.add(dataAdmissaolb);
        somenteNumerosdataAdmissaolb = new JLabel("Somente Números");
        somenteNumerosdataAdmissaolb.setForeground(Color.red);
        somenteNumerosdataAdmissaolb.setVisible(false);
        somenteNumerosdataAdmissaolb.setSize(200, 20);
        somenteNumerosdataAdmissaolb.setLocation(550, 530);
        PPrincipal.add(somenteNumerosdataAdmissaolb);
        
        formatodataAdmissaolb = new JLabel("DD/MM/AAAA");
        formatodataAdmissaolb.setVisible(true);
        formatodataAdmissaolb.setSize(200, 20);
        formatodataAdmissaolb.setLocation(550, 530);
        PPrincipal.add(formatodataAdmissaolb);
        
        diaAdmissaolb = new JLabel("Dia:*");
        diaAdmissaolb.setSize(50, 20);
        diaAdmissaolb.setLocation(220, 530);
        PPrincipal.add(diaAdmissaolb);
        diaAdmissaotf = new JTextField();
        diaAdmissaotf.setSize(25, 20);
        diaAdmissaotf.setLocation(270, 530);
        diaAdmissaotf.addKeyListener(new TrataTeclado());
        PPrincipal.add(diaAdmissaotf);
        
        mesAdmissaolb = new JLabel("Mês:*");
        mesAdmissaolb.setSize(50, 20);
        mesAdmissaolb.setLocation(320, 530);
        PPrincipal.add(mesAdmissaolb);
        mesAdmissaotf = new JTextField();
        mesAdmissaotf.setSize(25, 20);
        mesAdmissaotf.setLocation(370, 530);
        mesAdmissaotf.addKeyListener(new TrataTeclado());
        PPrincipal.add(mesAdmissaotf);
        
        anoAdmissaolb = new JLabel("Ano:*");
        anoAdmissaolb.setSize(50, 20);
        anoAdmissaolb.setLocation(420, 530);
        PPrincipal.add(anoAdmissaolb);
        anoAdmissaotf = new JTextField();
        anoAdmissaotf.setSize(50, 20);
        anoAdmissaotf.setLocation(470, 530);
        anoAdmissaotf.addKeyListener(new TrataTeclado());
        PPrincipal.add(anoAdmissaotf);
        
        cadastrar = new JButton("Cadastrar");
        cadastrar.setSize(130, 20);
        cadastrar.setLocation(90, 10);
        cadastrar.setVisible(true);
        cadastrar.addActionListener(new TrataBotao());
        PBotoes.add(cadastrar);
        
        limpar = new JButton("Limpar");
        limpar.setSize(130, 20);
        limpar.setLocation(310, 10);
        limpar.setVisible(true);
        PBotoes.add(limpar);
        
        sair = new JButton("Sair");
        sair.setSize(130, 20);
        sair.setLocation(530, 10);
        sair.setVisible(true);
        sair.addActionListener(new TrataBotao());
        PBotoes.add(sair);
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
            
            boolean teste;
            if(e.getSource().equals(rgtf)){
                somenteNumerosrglb.setVisible(false);
                teste = ad.somenteNumeros(rgtf.getText());
                if(teste == false){
                    somenteNumerosrglb.setVisible(true);
                }
            }else if(e.getSource().equals(cpftf)){
                somenteNumeroscpflb.setVisible(false);
                teste = ad.somenteNumeros(cpftf.getText());
                if(teste == false){
                    somenteNumeroscpflb.setVisible(true);
                }
            }else if(e.getSource().equals(carteiraTrabalhotf)){
                somenteNumeroscarteiraTrabalholb.setVisible(false);
                teste = ad.somenteNumeros(carteiraTrabalhotf.getText());
                if(teste == false){
                    somenteNumeroscarteiraTrabalholb.setVisible(true);
                }
            }else if(e.getSource().equals(pistf)){
                somenteNumerospislb.setVisible(false);
                teste = ad.somenteNumeros(pistf.getText());
                if(teste == false){
                    somenteNumerospislb.setVisible(true);
                }
            }else if(e.getSource().equals(dddtf)){
                somenteNumerostelefonelb.setVisible(false);
                teste = ad.somenteNumeros(dddtf.getText());
                if(teste == false){
                    somenteNumerostelefonelb.setVisible(true);
                }
            }else if(e.getSource().equals(numerotf)){
                somenteNumerostelefonelb.setVisible(false);
                teste = ad.somenteNumeros(numerotf.getText());
                if(teste == false){
                    somenteNumerostelefonelb.setVisible(true);
                }
            }else if(e.getSource().equals(dddcelulartf)){
                somenteNumeroscelularlb.setVisible(false);
                teste = ad.somenteNumeros(dddcelulartf.getText());
                if(teste == false){
                    somenteNumeroscelularlb.setVisible(true);
                }
            }else if(e.getSource().equals(numerocelulartf)){
                somenteNumeroscelularlb.setVisible(false);
                teste = ad.somenteNumeros(numerocelulartf.getText());
                if(teste == false){
                    somenteNumeroscelularlb.setVisible(true);
                }
            }else if(e.getSource().equals(numeroenderecotf)){
                somenteNumerosnumeroEnderecolb.setVisible(false);
                teste = ad.somenteNumeros(numeroenderecotf.getText());
                if(teste == false){
                    somenteNumerosnumeroEnderecolb.setVisible(true);
                }
            }else if(e.getSource().equals(ceptf)){
                somenteNumerosCeplb.setVisible(false);
                teste = ad.somenteNumeros(ceptf.getText());
                if(teste == false){
                    somenteNumerosCeplb.setVisible(true);
                }
            }else if(e.getSource().equals(diaAdmissaotf)){
                formatodataAdmissaolb.setVisible(true);
                somenteNumerosdataAdmissaolb.setVisible(false);
                if(!"".equals(diaAdmissaotf.getText())){
                    teste = ad.somenteNumeros(diaAdmissaotf.getText());
                if(teste == false){
                    formatodataAdmissaolb.setVisible(false);
                    somenteNumerosdataAdmissaolb.setVisible(true);
                }else if(teste == true){
                    //Teste a amplitude
                boolean testeAmplitude = ad.testeAmplitude(diaAdmissaotf.getText(), 1, 31);
                if(false == testeAmplitude){
                    JOptionPane.showMessageDialog(rootPane, "Digite um valor entre 1 e 31 para o dia");
                    diaAdmissaotf.setText("");
                }
                }
                }
                
            }else if(e.getSource().equals(mesAdmissaotf)){
                formatodataAdmissaolb.setVisible(true);
                somenteNumerosdataAdmissaolb.setVisible(false);
                if(!"".equals(mesAdmissaotf.getText())){
                    teste = ad.somenteNumeros(mesAdmissaotf.getText());
                if(teste == false){
                    formatodataAdmissaolb.setVisible(false);
                    somenteNumerosdataAdmissaolb.setVisible(true);
                }else if(teste == true){
                    //Teste a amplitude
                boolean testeAmplitude = ad.testeAmplitude(mesAdmissaotf.getText(), 1, 12);
                if(false == testeAmplitude){
                    JOptionPane.showMessageDialog(rootPane, "Digite um valor entre 1 e 12 para o mês");
                    mesAdmissaotf.setText("");
                }
                }
                }
            }else if(e.getSource().equals(anoAdmissaotf)){
                formatodataAdmissaolb.setVisible(true);
                somenteNumerosdataAdmissaolb.setVisible(false);
                if(!"".equals(anoAdmissaotf.getText())){
                    teste = ad.somenteNumeros(anoAdmissaotf.getText());
                if(teste == false){
                    formatodataAdmissaolb.setVisible(false);
                    somenteNumerosdataAdmissaolb.setVisible(true);
                }
                }
            }
            
            if(e.getSource().equals(logintf)){
                
                if("".equals(logintf.getText())){
                    /*Não faz nada pois o campo está vazio*/
                    respostalb.setText("");
                    respostalb.setVisible(false);
                    naoEditavel();
                }else{
                    try {
                        if(!cdb.verificarDisponibilidadeDeCodigo("Administrador", "login", logintf.getText())){
                            /*Enconrado*/
                            respostalb.setForeground(Color.red);
                            respostalb.setText("Login indisponível");
                            naoEditavel();
                        //JOptionPane.showMessageDialog(rootPane, "Encontrado");
                        }else{
                            /*Não enconrado*/
                            respostalb.setForeground(Color.blue);
                            respostalb.setText("Login disponível.");
                            respostalb.setVisible(true);
                            editavel();
                            //JOptionPane.showMessageDialog(rootPane, "Não Encontrado");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaNovoAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
    
    public class TrataBotao implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(cadastrar)){
                desobriga();
                if(testeVazios() == 0){
                    boolean senhaExiste = false;
                    
                    ResultSet r;
                    r = cdb.pesquisaDB("select * from Funcionario where codigoFuncionario = '"+senhatf.getText()+"'");
                    try {
                        while(r.next()){
                            JOptionPane.showMessageDialog(rootPane, "Essa senha não está disponível");
                            senhatf.setText("");
                            senhaExiste = true;
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaNovoAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if(!senhaExiste){
                        String telefone = "("+dddtf.getText()+")"+numerotf.getText();
                    String celular = "("+dddcelulartf.getText()+")"+numerocelulartf.getText();
                    String endereco = ruatf.getText()+", "+numeroenderecotf.getText();
                    String dataAdmissao = anoAdmissaotf.getText()+"/"+mesAdmissaotf.getText()+"/"+diaAdmissaotf.getText();
                    
                    ad.setLogin(logintf.getText());
                    ad.setSenha(senhatf.getText());
                    ad.setNome(nometf.getText());
                    ad.setCpf(cpftf.getText());
                    ad.setRg(rgtf.getText());
                    ad.setCarteiraTrabalho(carteiraTrabalhotf.getText());
                    ad.setPis(pistf.getText());
                    ad.setTelefone(telefone);
                    ad.setCelular(celular);
                    ad.setEmail(emailtf.getText());
                    ad.setEndereco(endereco);
                    ad.setComplemento(complementotf.getText());
                    ad.setBairro(bairrotf.getText());
                    ad.setCep(ceptf.getText());
                    ad.setCidade(cidadetf.getText());
                    ad.setDataAdimissao(dataAdmissao);
                    ad.setDataDemissao(null);
                    ad.setUf(uftf.getText());
                    ad.salvarAdministrador();
                    limpar();
                    }
                }else{
                    obriga();
                }
            }else if(e.getSource().equals(sair)){
                dispose();
            }else if(e.getSource().equals(limpar)){
                limpar();
            }
        }

        private void desobriga() {
            loginlb.setForeground(Color.black);
            senhalb.setForeground(Color.black);
            nomelb.setForeground(Color.black);
            cpflb.setForeground(Color.black);
            rglb.setForeground(Color.black);
            carteiraTrabalholb.setForeground(Color.black);
            diaAdmissaolb.setForeground(Color.black);
            mesAdmissaolb.setForeground(Color.black);
            anoAdmissaolb.setForeground(Color.black);
        }

        private int testeVazios() {
            if("".equals(nometf.getText()) || "".equals(senhatf.getText()) 
                    || "".equals(logintf) || "".equals(cpftf.getText()) || "".equals(rgtf.getText()) 
                    || "".equals(carteiraTrabalhotf.getText()) || "".equals(diaAdmissaotf.getText()) 
                    || "".equals(mesAdmissaotf.getText()) || "".equals(anoAdmissaotf.getText())){
                return 1;//Existe campo obrigatório vazio
            }else{
                return 0;//Não existe campo obrigatório vazio
            }
        }

        private void obriga() {
            loginlb.setForeground(Color.red);
            senhalb.setForeground(Color.red);
            nomelb.setForeground(Color.red);
            cpflb.setForeground(Color.red);
            rglb.setForeground(Color.red);
            carteiraTrabalholb.setForeground(Color.red);
            diaAdmissaolb.setForeground(Color.red);
            mesAdmissaolb.setForeground(Color.red);
            anoAdmissaolb.setForeground(Color.red);
            JOptionPane.showMessageDialog(rootPane, "Os campos em vermelho são obrigatórios");
            logintf.grabFocus();
        }

        private void limpar() {
            logintf.setText("");
            respostalb.setText("");
            senhatf.setText("");
            nometf.setText("");
            cpftf.setText("");
            rgtf.setText("");
            carteiraTrabalhotf.setText("");
            pistf.setText("");
            dddtf.setText("");
            numerotf.setText("");
            dddcelulartf.setText("");
            numerocelulartf.setText("");
            emailtf.setText("");
            ruatf.setText("");
            numeroenderecotf.setText("");
            complementotf.setText("");
            bairrotf.setText("");
            ceptf.setText("");
            cidadetf.setText("");
            uftf.setText("");
            diaAdmissaotf.setText("");
            mesAdmissaotf.setText("");
            anoAdmissaotf.setText("");
        }
        
    }
    
    private void naoEditavel() {
            senhatf.setEditable(false);
            senhatf.setText("");
            senhatf.setToolTipText("");
            nometf.setEditable(false);
            nometf.setText("");
            cpftf.setEditable(false);
            cpftf.setText("");
            rgtf.setEditable(false);
            rgtf.setText("");
            carteiraTrabalhotf.setEditable(false);
            carteiraTrabalhotf.setText("");
            pistf.setEditable(false);
            pistf.setText("");
            dddtf.setEditable(false);
            dddtf.setText("");
            numerotf.setEditable(false);
            numerotf.setText("");
            dddcelulartf.setEditable(false);
            dddcelulartf.setText("");
            numerocelulartf.setEditable(false);
            numerocelulartf.setText("");
            ruatf.setEditable(false);
            ruatf.setText("");
            bairrotf.setEditable(false);
            bairrotf.setText("");
            complementotf.setEditable(false);
            complementotf.setText("");
            emailtf.setEditable(false);
            emailtf.setText("");
            ceptf.setEditable(false);
            ceptf.setText("");
            numeroenderecotf.setEditable(false);
            numeroenderecotf.setText("");
            cidadetf.setEditable(false);
            cidadetf.setText("");
            uftf.setEditable(false);
            uftf.setText("");
            diaAdmissaotf.setEditable(false);
            diaAdmissaotf.setText("");
            mesAdmissaotf.setEditable(false);
            mesAdmissaotf.setText("");
            anoAdmissaotf.setEditable(false);
            anoAdmissaotf.setText("");
        }

        private void editavel() {
            senhatf.setEditable(true);
            senhatf.setToolTipText("Digite a senha");
            nometf.setEditable(true);
            cpftf.setEditable(true);
            rgtf.setEditable(true);
            carteiraTrabalhotf.setEditable(true);
            pistf.setEditable(true);
            dddtf.setEditable(true);
            numerotf.setEditable(true);
            dddcelulartf.setEditable(true);
            numerocelulartf.setEditable(true);
            ruatf.setEditable(true);
            bairrotf.setEditable(true);
            complementotf.setEditable(true);
            emailtf.setEditable(true);
            ceptf.setEditable(true);
            numeroenderecotf.setEditable(true);
            cidadetf.setEditable(true);
            uftf.setEditable(true);
            diaAdmissaotf.setEditable(true);
            mesAdmissaotf.setEditable(true);
            anoAdmissaotf.setEditable(true);
        }
}
