package telas;

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
/**
 *
 * @author adriano
 */
class TelaEditarAdministrador extends TelaModelo{
    private JPanel PPrincipal;
    private JPanel PBotoes;
    private JLabel loginlb;
    private JTextField logintf;
    private JLabel respostalb;
    private JLabel senhalb;
    private JTextField senhatf;
    private JLabel nomelb;
    private JTextField nometf;
    private JLabel cpflb;
    private JLabel somenteNumeroscpflb;
    private JTextField cpftf;
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
    private JTextField enderecotf;
    private JLabel complementolb;
    private JTextField complementotf;
    private JLabel bairrolb;
    private JTextField bairrotf;
    private JLabel ceplb;
    private JLabel somenteNumerosCeplb;
    private JTextField ceptf;
    private JLabel cidadelb;
    private JTextField cidadetf;
    private JLabel uflb;
    private JTextField uftf;
    private JLabel dataAdmissaolb;
    private JLabel formatodataAdmissaolb;
    private JTextField dataAdmissaotf;
    private JButton editar;
    private JButton cancelar;
    private ConectaDB cdb;
    int[] testeSomenteNumeros = new int[9];

    public TelaEditarAdministrador(String login, String senha) throws SQLException {
        this.setTitle("Editar Administrador");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 640);
        this.setLocation(140, 25);
        innicializarComponentes(login, senha);
        preencherCampos(senha);
        cdb.closeDB();
        this.setVisible(true);
    }

    private void innicializarComponentes(String login, String senha) {
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
        
        logintf = new JTextField(login);
        logintf.setEditable(false);
        logintf.setToolTipText("Digite o login do novo Administrador");
        logintf.setSize(300, 20);
        logintf.setLocation(220, 20);
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
        senhatf = new JTextField(senha);
        senhatf.setEditable(false);
        senhatf.setSize(300, 20);
        senhatf.setLocation(220, 50);
        PPrincipal.add(senhatf);
        
        nomelb = new JLabel("Nome*:");
        nomelb.setSize(100, 20);
        nomelb.setLocation(10, 80);
        PPrincipal.add(nomelb);
        nometf = new JTextField();
        nometf.setSize(300, 20);
        nometf.setLocation(220, 80);
        PPrincipal.add(nometf);
        
        cpflb = new JLabel("CPF*:");
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
        
        rglb = new JLabel("RG*:");
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
        rgtf.setSize(300, 20);
        rgtf.setLocation(220, 140);
        rgtf.addKeyListener(new TrataTeclado());
        PPrincipal.add(rgtf);
        
        carteiraTrabalholb = new JLabel("Carteira de Trabalho*:");
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
                
        enderecotf = new JTextField();
        enderecotf.setSize(300, 20);
        enderecotf.setLocation(220, 320);
        PPrincipal.add(enderecotf);
        
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
        formatodataAdmissaolb = new JLabel("AAAA/MM/DD");
        formatodataAdmissaolb.setVisible(true);
        formatodataAdmissaolb.setSize(200, 20);
        formatodataAdmissaolb.setLocation(550, 530);
        PPrincipal.add(formatodataAdmissaolb);
        
        dataAdmissaotf = new JTextField();
        dataAdmissaotf.setEditable(false);
        dataAdmissaotf.setSize(150, 20);
        dataAdmissaotf.setLocation(220, 530);
        PPrincipal.add(dataAdmissaotf);
        
        editar = new JButton("Editar");
        editar.setSize(130, 20);
        editar.setLocation(90, 10);
        editar.setVisible(true);
        editar.addActionListener(new TrataBotao());
        PBotoes.add(editar);
        
        cancelar = new JButton("Sair");
        cancelar.setSize(130, 20);
        cancelar.setLocation(530, 10);
        cancelar.setVisible(true);
        cancelar.addActionListener(new TrataBotao());
        PBotoes.add(cancelar);
    }

    private void preencherCampos(String senha) throws SQLException {
        ResultSet r;
        cdb = new ConectaDB();
        String pesquisa = "select * from Funcionario where codigoFuncionario = '"+senha+"'";
        r = cdb.pesquisaDB(pesquisa);
        while(r.next()){
            nometf.setText((String) r.getObject("nome"));
            cpftf.setText((String) r.getObject("cpf"));
            rgtf.setText((String) r.getObject("rg"));
            carteiraTrabalhotf.setText((String) r.getObject("carteiraTrabalho"));
            pistf.setText((String) r.getObject("pis"));
            String dddTelefone = retornaDDDTelefone((String) r.getObject("telefone"));
            dddtf.setText(dddTelefone);
            String numeroTelefone = retornaTelefone((String) r.getObject("telefone"));
            numerotf.setText(numeroTelefone);
            String dddCelular = retornaDDDCelular((String) r.getObject("celular"));
            dddcelulartf.setText(dddCelular);
            String numeroCelular = retornaNumeroCelular((String) r.getObject("celular"));
            numerocelulartf.setText(numeroCelular);
            emailtf.setText((String) r.getObject("email"));
            enderecotf.setText((String) r.getObject("endereco"));
            complementotf.setText((String) r.getObject("complemento"));
            bairrotf.setText((String) r.getObject("bairro"));
            ceptf.setText((String) r.getObject("cep"));
            cidadetf.setText((String) r.getObject("cidade"));
            uftf.setText((String) r.getObject("uf"));
            dataAdmissaotf.setText(String.valueOf(r.getObject("dataAdmissao")) );
        }
    }

    private String retornaDDDTelefone(String telefone) {
        String ddd =""; 
        long telefoneNumero = Long.parseLong(telefone);
        long divisor = 100000000;
        ddd = String.valueOf(telefoneNumero / divisor);
        return ddd;
    }

    private String retornaTelefone(String string) {
        String telefone = "";
        long telefoneNumero = Long.parseLong(string);
        long divisor = 100000000;
        telefone = String.valueOf(telefoneNumero % divisor);
        return telefone;
    }

    private String retornaDDDCelular(String string) {
        String ddd =""; 
        long telefoneNumero = Long.parseLong(string);
        long divisor = 100000000;
        ddd = String.valueOf(telefoneNumero / divisor);
        return ddd;
    }

    private String retornaNumeroCelular(String string) {
        String celular = "";
        long celularNumero = Long.parseLong(string);
        long divisor = 100000000;
        celular = String.valueOf(celularNumero % divisor);
        return celular;
    }
    
    public class TrataBotao implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(cancelar)){
                dispose();
            }
            else if(e.getSource().equals(editar)){
                if(TesteObrigatorios() == 0){
                    if(TesteSomenteNumeros() == 0){
                        String telefone = dddtf.getText()+numerotf.getText();
                        String celular = dddcelulartf.getText()+numerocelulartf.getText();
                        String edicao = "update Funcionario set nome = '"+nometf.getText()+"', cpf = '"+cpftf.getText()+"', "
                        + "rg = '"+rgtf.getText()+"', carteiraTrabalho = '"+carteiraTrabalhotf.getText()+"', "
                        + "pis = '"+pistf.getText()+"', telefone = '"+telefone+"', celular = '"+celular+"', "
                        + "email = '"+emailtf.getText()+"', endereco = '"+enderecotf.getText()+"', "
                        + "complemento = '"+complementotf.getText()+"', bairro = '"+bairrotf.getText()+"', "
                        + "cep = '"+ceptf.getText()+"', cidade = '"+cidadetf.getText()+"', uf = '"+uftf.getText()+"'"
                        + " where codigoFuncionario = '"+senhatf.getText()+"'";
                if(cdb.cadastro(edicao)){
                    JOptionPane.showMessageDialog(rootPane, "Operação realizada com sucesso!");
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Não foi possível realizar essa operação!!");
                
                }
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Atenção para os campos numéricos");
                    }
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Atenção para os campos obrigatórios");
                }
                             
            }
            try {
                cdb.closeDB();
            } catch (SQLException ex) {
                Logger.getLogger(TelaEditarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        private int TesteSomenteNumeros() {
            int resposta = 0;
            
            for(int x = 0; x < testeSomenteNumeros.length; x++){
                if(testeSomenteNumeros[x] == 1){ 
                    resposta ++;
                }
            }
            return resposta;
        }

        private int TesteObrigatorios() {
            nomelb.setForeground(Color.black); cpflb.setForeground(Color.black);
            rglb.setForeground(Color.black); carteiraTrabalholb.setForeground(Color.black);
            int resposta = 0;
            Funcionario f = new Funcionario();
            String[] obrigatorios = new String[4];
            obrigatorios[0] = nometf.getText();
            obrigatorios[1] = cpftf.getText();
            obrigatorios[2] = rgtf.getText();
            obrigatorios[3] = carteiraTrabalhotf.getText();
            
            if(!f.verificaObrigatórios(obrigatorios)){
                nomelb.setForeground(Color.red); cpflb.setForeground(Color.red);
                rglb.setForeground(Color.red); carteiraTrabalholb.setForeground(Color.red);
                resposta = 1;
            }
            return resposta;
        }
        
                
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
            zeraSomenteNumeros();
            zeraTesteSomenteNumeros();
                        
            if(e.getSource().equals(cpftf)){
                testeSomenteNumeros[0] = 0;
                somenteNumeroscpflb.setVisible(false);
                if(!Funcionario.somenteNumeros(cpftf.getText())){
                    testeSomenteNumeros[0] = 1;
                    somenteNumeroscpflb.setVisible(true);
                }
            }
            else if(e.getSource().equals(rgtf)){
                testeSomenteNumeros[1] = 0;
                somenteNumerosrglb.setVisible(false);
                if(!Funcionario.somenteNumeros(rgtf.getText())){
                    testeSomenteNumeros[1] = 1;
                    somenteNumerosrglb.setVisible(true);
                }
            }
            else if(e.getSource().equals(carteiraTrabalhotf)){
                testeSomenteNumeros[2] = 0;
                somenteNumeroscarteiraTrabalholb.setVisible(false);
                if(!Funcionario.somenteNumeros(carteiraTrabalhotf.getText())){
                    testeSomenteNumeros[2] = 1;
                    somenteNumeroscarteiraTrabalholb.setVisible(true);
                }
            }
            else if(e.getSource().equals(pistf)){
                testeSomenteNumeros[3] = 0;
                somenteNumerospislb.setVisible(false);
                if(!Funcionario.somenteNumeros(pistf.getText())){
                    testeSomenteNumeros[3] = 1;
                    somenteNumerospislb.setVisible(true);
                }
            }
            else if(e.getSource().equals(dddtf)){
                testeSomenteNumeros[4] = 0;
                somenteNumerostelefonelb.setVisible(false);
                if(!Funcionario.somenteNumeros(dddtf.getText())){
                    testeSomenteNumeros[4] = 1;
                    somenteNumerostelefonelb.setVisible(true);
                }
            }
            else if(e.getSource().equals(numerotf)){
                testeSomenteNumeros[5] = 0;
                somenteNumerostelefonelb.setVisible(false);
                if(!Funcionario.somenteNumeros(numerotf.getText())){
                    testeSomenteNumeros[5] = 1;
                    somenteNumerostelefonelb.setVisible(true);
                }
            }
            else if(e.getSource().equals(dddcelulartf)){
                testeSomenteNumeros[6] = 0;
                somenteNumeroscelularlb.setVisible(false);
                if(!Funcionario.somenteNumeros(dddcelulartf.getText())){
                    testeSomenteNumeros[6] = 1;
                    somenteNumeroscelularlb.setVisible(true);
                }
            }else if(e.getSource().equals(numerocelulartf)){
                testeSomenteNumeros[7] = 0;
                somenteNumeroscelularlb.setVisible(false);
                if(!Funcionario.somenteNumeros(numerocelulartf.getText())){
                    testeSomenteNumeros[7] = 1;
                    somenteNumeroscelularlb.setVisible(true);
                }
            }
            else if(e.getSource().equals(ceptf)){
                testeSomenteNumeros[8] = 0;
                somenteNumerosCeplb.setVisible(false);
                if(!Funcionario.somenteNumeros(ceptf.getText())){
                    testeSomenteNumeros[8] = 1;
                    somenteNumerosCeplb.setVisible(true);
                }
            }
        }

        private void zeraSomenteNumeros() {
            somenteNumeroscpflb.setVisible(false);
        }

        private void zeraTesteSomenteNumeros() {
            for(int x = 0; x < testeSomenteNumeros.length; x++){
                testeSomenteNumeros[x] = 0;
            }
        }
    
    }
}
