package telas;

import classes.Funcionario;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class TelaCadastroFuncionario extends TelaModelo{

    private JPanel PPrincipal;
    protected JPanel PBotoes;
    
    private JLabel somenteNumeroscelularlb;
    private JLabel somenteNumerospislb;
    private JLabel somenteNumerosnumeroEnderecolb;
    private JLabel somenteNumerosCeplb;
    private JLabel codigoFuncionariolb;
    protected JTextField codigoFuncionariotf;
    private JLabel nomelb;
    private JLabel obriganomelb;
    protected JTextField nometf;
    private JLabel cpflb;
    private JLabel somenteNumeroscpflb;
    private JLabel obrigacpflb;
    protected JTextField cpftf;
    private JLabel rglb;
    private JLabel somenteNumerosrglb;
    private JLabel obrigarglb;
    protected JTextField rgtf;
    private JLabel carteiraTrabalholb;
    private JLabel somenteNumeroscarteiraTrabalholb;
    private JLabel obrigacarteiraTrabalholb;
    protected JTextField carteiraTrabalhotf;
    private JLabel pislb;
    protected JTextField pistf;
    private JLabel telefonelb;
    private JLabel somenteNumerostelefonelb;
    private JLabel dddlb;
    private JLabel numerolb;
    protected JTextField dddtf;
    protected JTextField numerotf;
    private JLabel celularlb;
    private JLabel dddcelularlb;
    private JLabel numerocelularlb;
    protected JTextField dddcelulartf;
    protected JTextField numerocelulartf;
    private JLabel emaillb;
    protected JTextField emailtf;
    private JLabel enderecolb;
    private JLabel rualb;
    private JLabel numeroenderecolb;
    protected JTextField ruatf;
    protected JTextField numeroenderecotf;
    private JLabel complementolb;
    protected JTextField complementotf;
    private JLabel bairrolb;
    protected JTextField bairrotf;
    private JLabel ceplb;
    protected JTextField ceptf;
    private JLabel cidadelb;
    protected JTextField cidadetf;
    private JLabel uflb;
    protected JTextField uftf;
    private JLabel dataAdmissaolb;
    private JLabel obrigadataAdmissaolb;
    private JLabel somenteNumerosdataAdmissaolb;
    private JLabel formatodataAdmissaolb;
    protected JLabel diaAdmissaolb;
    protected JLabel mesAdmissaolb;
    protected JLabel anoAdmissaolb;
    protected JTextField diaAdmissaotf;
    protected JTextField mesAdmissaotf;
    protected JTextField anoAdmissaotf;
    protected JLabel dataDemissaolb;
    protected JLabel diaDemissaolb;
    protected JLabel mesDemissaolb;
    protected JLabel anoDemissaolb;
    protected JTextField diaDemissaotf;
    protected JTextField mesDemissaotf;
    protected JTextField anoDemissaotf;
   
    protected JButton cadastrar, limpar, sair;
    //Declaração do novo Funcionário
    protected Funcionario fc;
    protected JButton novo;
    
   
    
    public TelaCadastroFuncionario() throws SQLException{
        fc = new Funcionario();
        
        this.setLayout(null);
        this.setTitle("Cadastro de Funcionários");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 610);
        this.setLocation(140, 50);
        fc = new Funcionario();
        fc.setcodigoFuncionario();
        inicializarComponentes();
        nometf.grabFocus();
        this.setVisible(true);
    }

    private void inicializarComponentes() {
        
        PBotoes = new JPanel();
        PBotoes.setLayout(null);
        PBotoes.setSize(750, 40);
        PBotoes.setLocation(25, 520);
        this.add(PBotoes);
        
        PPrincipal = new JPanel();
        PPrincipal.setLayout(null);
        PPrincipal.setSize(750, 500);
        PPrincipal.setLocation(25, 0);
        this.add(PPrincipal);
        
        codigoFuncionariolb = new JLabel("Código:*");
        codigoFuncionariolb.setSize(100, 20);
        codigoFuncionariolb.setLocation(10, 20);
        PPrincipal.add(codigoFuncionariolb);
        codigoFuncionariotf = new JTextField();
        codigoFuncionariotf.setText(fc.getcodigoFuncionario());
        codigoFuncionariotf.setEditable(false);
        codigoFuncionariotf.setToolTipText("Gerado pelo sistema");
        codigoFuncionariotf.setSize(300, 20);
        codigoFuncionariotf.setLocation(220, 20);
        PPrincipal.add(codigoFuncionariotf);
        //Somente números. obrigatório
        cpflb = new JLabel("CPF:*");
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
        cpftf.setSize(300, 20);
        cpftf.setLocation(220, 80);
        cpftf.addKeyListener(new trataTeclado());
        PPrincipal.add(cpftf);
        
        nomelb = new JLabel("Nome:*");
        nomelb.setSize(100, 20);
        nomelb.setLocation(10, 50);
        PPrincipal.add(nomelb);
        nometf = new JTextField();
        nometf.setSize(300, 20);
        nometf.setLocation(220, 50);
        PPrincipal.add(nometf);
        
        rglb = new JLabel("RG:*");
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
        rgtf.addKeyListener(new trataTeclado());
        rgtf.setSize(300, 20);
        rgtf.setLocation(220, 110);
        PPrincipal.add(rgtf);
        
        carteiraTrabalholb = new JLabel("Carteira de Trabalho:*");
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
        carteiraTrabalhotf.setSize(300, 20);
        carteiraTrabalhotf.setLocation(220, 140);
        carteiraTrabalhotf.addKeyListener(new trataTeclado());
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
        pistf.setSize(300, 20);
        pistf.setLocation(220, 170);
        pistf.addKeyListener(new trataTeclado());
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
        dddlb = new JLabel("DDD:");
        dddlb.setSize(50, 20);
        dddlb.setLocation(220, 200);
        PPrincipal.add(dddlb);
        numerolb = new JLabel("Número:");
        numerolb.setSize(100, 20);
        numerolb.setLocation(340, 200);
        PPrincipal.add(numerolb);
        dddtf = new JTextField();
        dddtf.setSize(35, 20);
        dddtf.setLocation(275, 200);
        dddtf.addKeyListener(new trataTeclado());
        PPrincipal.add(dddtf);
        numerotf = new JTextField();
        numerotf.setSize(100, 20);
        numerotf.setLocation(420, 200);
        numerotf.addKeyListener(new trataTeclado());
        PPrincipal.add(numerotf);
        
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
        dddcelularlb = new JLabel("DDD:");
        dddcelularlb.setSize(50, 20);
        dddcelularlb.setLocation(220, 230);
        PPrincipal.add(dddcelularlb);
        numerocelularlb = new JLabel("Número:");
        numerocelularlb.setSize(100, 20);
        numerocelularlb.setLocation(340, 230);
        PPrincipal.add(numerocelularlb);
        dddcelulartf = new JTextField();
        dddcelulartf.setSize(35, 20);
        dddcelulartf.setLocation(275, 230);
        dddcelulartf.addKeyListener(new trataTeclado());
        PPrincipal.add(dddcelulartf);
        numerocelulartf = new JTextField();
        numerocelulartf.setSize(100, 20);
        numerocelulartf.setLocation(420, 230);
        numerocelulartf.addKeyListener(new trataTeclado());
        PPrincipal.add(numerocelulartf);
                
        emaillb = new JLabel("E-MAIL:");
        emaillb.setSize(200, 20);
        emaillb.setLocation(10, 260);
        PPrincipal.add(emaillb);
        emailtf = new JTextField();
        emailtf.setSize(300, 20);
        emailtf.setLocation(220, 260);
        PPrincipal.add(emailtf);
        
        enderecolb = new JLabel("Endereço:");
        enderecolb.setSize(200, 20);
        enderecolb.setLocation(10, 290);
        PPrincipal.add(enderecolb);
        somenteNumerosnumeroEnderecolb = new JLabel("Somente Números");
        somenteNumerosnumeroEnderecolb.setForeground(Color.red);
        somenteNumerosnumeroEnderecolb.setVisible(false);
        somenteNumerosnumeroEnderecolb.setSize(200, 20);
        somenteNumerosnumeroEnderecolb.setLocation(550, 290);
        PPrincipal.add(somenteNumerosnumeroEnderecolb);
        ruatf = new JTextField();
        ruatf.setSize(240, 20);
        ruatf.setLocation(220, 290);
        PPrincipal.add(ruatf);
        numeroenderecotf = new JTextField();
        numeroenderecotf.setToolTipText("Número");
        numeroenderecotf.setSize(50, 20);
        numeroenderecotf.setLocation(470, 290);
        numeroenderecotf.addKeyListener(new trataTeclado());
        PPrincipal.add(numeroenderecotf);
        
        complementolb = new JLabel("Complemento:");
        complementolb.setSize(200, 20);
        complementolb.setLocation(10, 320);
        PPrincipal.add(complementolb);
        complementotf = new JTextField();
        complementotf.setSize(300, 20);
        complementotf.setLocation(220, 320);
        PPrincipal.add(complementotf);
        
        bairrolb = new JLabel("Bairro:");
        bairrolb.setSize(200, 20);
        bairrolb.setLocation(10, 350);
        PPrincipal.add(bairrolb);
        bairrotf = new JTextField();
        bairrotf.setSize(300, 20);
        bairrotf.setLocation(220, 350);
        PPrincipal.add(bairrotf);
        
        ceplb = new JLabel("CEP:");
        ceplb.setSize(200, 20);
        ceplb.setLocation(10, 380);
        PPrincipal.add(ceplb);
        somenteNumerosCeplb = new JLabel("Somente Números");
        somenteNumerosCeplb.setForeground(Color.red);
        somenteNumerosCeplb.setVisible(false);
        somenteNumerosCeplb.setSize(200, 20);
        somenteNumerosCeplb.setLocation(550, 380);
        PPrincipal.add(somenteNumerosCeplb);
        ceptf = new JTextField();
        ceptf.setSize(300, 20);
        ceptf.setLocation(220, 380);
        ceptf.addKeyListener(new trataTeclado());
        PPrincipal.add(ceptf);
        
        cidadelb = new JLabel("Cidade:");
        cidadelb.setSize(200, 20);
        cidadelb.setLocation(10, 410);
        PPrincipal.add(cidadelb);
        cidadetf = new JTextField();
        cidadetf.setSize(150, 20);
        cidadetf.setLocation(220, 410);
        PPrincipal.add(cidadetf);
        
        uflb = new JLabel("UF:");
        uflb.setSize(200, 20);
        uflb.setLocation(10, 440);
        PPrincipal.add(uflb);
        uftf = new JTextField();
        uftf.setSize(25, 20);
        uftf.setLocation(220, 440);
        PPrincipal.add(uftf);
        
        dataAdmissaolb = new JLabel("Data de Admissão:*");
        dataAdmissaolb.setSize(200, 20);
        dataAdmissaolb.setLocation(10, 470);
        PPrincipal.add(dataAdmissaolb);
        somenteNumerosdataAdmissaolb = new JLabel("Somente Números");
        somenteNumerosdataAdmissaolb.setForeground(Color.red);
        somenteNumerosdataAdmissaolb.setVisible(false);
        somenteNumerosdataAdmissaolb.setSize(200, 20);
        somenteNumerosdataAdmissaolb.setLocation(550, 470);
        PPrincipal.add(somenteNumerosdataAdmissaolb);
        
        formatodataAdmissaolb = new JLabel("AAAA/MM/DD");
        formatodataAdmissaolb.setVisible(true);
        formatodataAdmissaolb.setSize(200, 20);
        formatodataAdmissaolb.setLocation(550, 470);
        PPrincipal.add(formatodataAdmissaolb);
        
        diaAdmissaolb = new JLabel("Dia:*");
        diaAdmissaolb.setSize(50, 20);
        diaAdmissaolb.setLocation(220, 470);
        PPrincipal.add(diaAdmissaolb);
        diaAdmissaotf = new JTextField();
        diaAdmissaotf.setSize(25, 20);
        diaAdmissaotf.setLocation(270, 470);
        diaAdmissaotf.addKeyListener(new trataTeclado());
        PPrincipal.add(diaAdmissaotf);
        
        mesAdmissaolb = new JLabel("Mês:*");
        mesAdmissaolb.setSize(50, 20);
        mesAdmissaolb.setLocation(320, 470);
        PPrincipal.add(mesAdmissaolb);
        mesAdmissaotf = new JTextField();
        mesAdmissaotf.setSize(25, 20);
        mesAdmissaotf.setLocation(370, 470);
        mesAdmissaotf.addKeyListener(new trataTeclado());
        PPrincipal.add(mesAdmissaotf);
        
        anoAdmissaolb = new JLabel("Ano:*");
        anoAdmissaolb.setSize(50, 20);
        anoAdmissaolb.setLocation(420, 470);
        PPrincipal.add(anoAdmissaolb);
        anoAdmissaotf = new JTextField();
        anoAdmissaotf.setSize(50, 20);
        anoAdmissaotf.setLocation(470, 470);
        anoAdmissaotf.addKeyListener(new trataTeclado());
        PPrincipal.add(anoAdmissaotf);
        
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
            //Possível implementação futuramente
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //Possível implementação futuramente
        }

        @Override
        public void keyReleased(KeyEvent e) {
            boolean teste;
            
            if(e.getSource().equals(cpftf)){
                somenteNumeroscpflb.setVisible(false);
                teste = fc.somenteNumeros(cpftf.getText());
                if(teste == false){
                    somenteNumeroscpflb.setVisible(true);
                }
            }else if(e.getSource().equals(rgtf)){
                somenteNumerosrglb.setVisible(false);
                teste = fc.somenteNumeros(rgtf.getText());
                if(teste == false){
                    somenteNumerosrglb.setVisible(true);
                }
            }else if(e.getSource().equals(carteiraTrabalhotf)){
                somenteNumeroscarteiraTrabalholb.setVisible(false);
                teste = fc.somenteNumeros(carteiraTrabalhotf.getText());
                if(teste == false){
                    somenteNumeroscarteiraTrabalholb.setVisible(true);
                }
            }else if(e.getSource().equals(pistf)){
                somenteNumerospislb.setVisible(false);
                teste = fc.somenteNumeros(pistf.getText());
                if(teste == false){
                    somenteNumerospislb.setVisible(true);
                }
            }else if(e.getSource().equals(dddtf)){
                somenteNumerostelefonelb.setVisible(false);
                teste = fc.somenteNumeros(dddtf.getText());
                if(teste == false){
                    somenteNumerostelefonelb.setVisible(true);
                }
            }else if(e.getSource().equals(numerotf)){
                somenteNumerostelefonelb.setVisible(false);
                teste = fc.somenteNumeros(numerotf.getText());
                if(teste == false){
                    somenteNumerostelefonelb.setVisible(true);
                }
            }else if(e.getSource().equals(dddcelulartf)){
                somenteNumeroscelularlb.setVisible(false);
                teste = fc.somenteNumeros(dddcelulartf.getText());
                if(teste == false){
                    somenteNumeroscelularlb.setVisible(true);
                }
            }else if(e.getSource().equals(numerocelulartf)){
                somenteNumeroscelularlb.setVisible(false);
                teste = fc.somenteNumeros(numerocelulartf.getText());
                if(teste == false){
                    somenteNumeroscelularlb.setVisible(true);
                }
            }else if(e.getSource().equals(numeroenderecotf)){
                somenteNumerosnumeroEnderecolb.setVisible(false);
                teste = fc.somenteNumeros(numeroenderecotf.getText());
                if(teste == false){
                    somenteNumerosnumeroEnderecolb.setVisible(true);
                }
            }else if(e.getSource().equals(ceptf)){
                somenteNumerosCeplb.setVisible(false);
                teste = fc.somenteNumeros(ceptf.getText());
                if(teste == false){
                    somenteNumerosCeplb.setVisible(true);
                }
            }else if(e.getSource().equals(diaAdmissaotf)){
                formatodataAdmissaolb.setVisible(true);
                somenteNumerosdataAdmissaolb.setVisible(false);
                teste = fc.somenteNumeros(diaAdmissaotf.getText());
                if(teste == false){
                    formatodataAdmissaolb.setVisible(false);
                    somenteNumerosdataAdmissaolb.setVisible(true);
                }else if(teste == true){
                    //Teste a amplitude
                boolean testeAmplitude = fc.testeAmplitude(diaAdmissaotf.getText(), 1, 31);
                if(false == testeAmplitude){
                    JOptionPane.showMessageDialog(rootPane, "Digite um valor entre 1 e 31 para o dia");
                    diaAdmissaotf.setText("");
                }
                }
                
            }else if(e.getSource().equals(mesAdmissaotf)){
                formatodataAdmissaolb.setVisible(true);
                somenteNumerosdataAdmissaolb.setVisible(false);
                teste = fc.somenteNumeros(mesAdmissaotf.getText());
                if(teste == false){
                    formatodataAdmissaolb.setVisible(false);
                    somenteNumerosdataAdmissaolb.setVisible(true);
                }else if(teste == true){
                    //Teste a amplitude
                boolean testeAmplitude = fc.testeAmplitude(mesAdmissaotf.getText(), 1, 12);
                if(false == testeAmplitude){
                    JOptionPane.showMessageDialog(rootPane, "Digite um valor entre 1 e 12 para o mês");
                    mesAdmissaotf.setText("");
                }
                }
            }else if(e.getSource().equals(anoAdmissaotf)){
                formatodataAdmissaolb.setVisible(true);
                somenteNumerosdataAdmissaolb.setVisible(false);
                teste = fc.somenteNumeros(anoAdmissaotf.getText());
                if(teste == false){
                    formatodataAdmissaolb.setVisible(false);
                    somenteNumerosdataAdmissaolb.setVisible(true);
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
                limpar(); nometf.grabFocus();
            }
            else if(e.getSource().equals(novo)){
                limpar();
                try {
                    novo();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaCadastroClientePF.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(e.getSource().equals(cadastrar)){
             //testando campos obrigatórios
             String []obrigatorios = new String[8];
                        obrigatorios[0] = codigoFuncionariotf.getText();
                        obrigatorios[1] = nometf.getText();
                        obrigatorios[2] = cpftf.getText();
                        obrigatorios[3] = rgtf.getText();
                        obrigatorios[4] = carteiraTrabalhotf.getText();
                        obrigatorios[5] = anoAdmissaotf.getText();
                        obrigatorios[6] = mesAdmissaotf.getText();
                        obrigatorios[7] = diaAdmissaotf.getText();
                        boolean testaObrigatorios = fc.verificaObrigatórios(obrigatorios);
                        if(testaObrigatorios == false){
                            JOptionPane.showMessageDialog(rootPane, "Todos os campos com asterísco devem ser preenchidos");
                        }
                        else{
                            try {
                        //Configurando os campos
                        String telefone = dddtf.getText()+numerotf.getText();
                        String celular = dddcelulartf.getText()+numerocelulartf.getText();
                        String endereco = ruatf.getText()+", "+numeroenderecotf.getText();
                        String dataAdmissao = anoAdmissaotf.getText()+"/"+mesAdmissaotf.getText()+"/"+diaAdmissaotf.getText();
                        fc.setNome(nometf.getText());
                        fc.setCpf(cpftf.getText());
                        fc.setRg(rgtf.getText());
                        fc.setCarteiraTrabalho(carteiraTrabalhotf.getText());
                        fc.setPis(pistf.getText());
                        fc.setTelefone(telefone);
                        fc.setCelular(celular);
                        fc.setEmail(emailtf.getText());
                        fc.setEndereco(endereco);
                        fc.setComplemento(complementotf.getText());
                        fc.setBairro(bairrotf.getText());
                        fc.setCep(ceptf.getText());
                        fc.setCidade(cidadetf.getText());
                        fc.setDataAdimissao(dataAdmissao);
                        fc.setDataDemissao(null);
                        fc.setUf(uftf.getText());
                        
                    boolean resposta = fc.testarCodigo(fc.getcodigoFuncionario());
                    if(resposta == false){
                        JOptionPane.showMessageDialog(rootPane, "O código digitado está indisponível. Tente outro!");
                    }else{
                        boolean respostaCadastro = fc.cadastrarFuncionario();
                        if(respostaCadastro == true){
                            JOptionPane.showMessageDialog(rootPane, "Cadastro Realizado com Sucesso!");
                            limpar(); novo();
                        }else{
                            JOptionPane.showMessageDialog(rootPane, "Cadastro Não Realizado!");
                        }
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(TelaCadastroFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                }
                            
                }
        }
        
    }
}
    private void limpar(){
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
        diaAdmissaotf.setText("");
        mesAdmissaotf.setText("");
        anoAdmissaotf.setText("");
        uftf.setText("");
        
        somenteNumeroscpflb.setVisible(false);
        somenteNumerosrglb.setVisible(false);
        somenteNumeroscarteiraTrabalholb.setVisible(false);
        somenteNumerospislb.setVisible(false);
        somenteNumerostelefonelb.setVisible(false);
        somenteNumeroscelularlb.setVisible(false);
        somenteNumerosnumeroEnderecolb.setVisible(false);
        somenteNumerosCeplb.setVisible(false);
        somenteNumerosdataAdmissaolb.setVisible(false);
    }
    private void novo() throws SQLException {
            fc.setcodigoFuncionario();
            codigoFuncionariotf.setText(fc.getcodigoFuncionario());
            nometf.grabFocus();
        }
}
    