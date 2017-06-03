
package telas;

import classes.ConectaDB;
import classes.Representante;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
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
class TelaEditarRepresentante extends TelaModelo{
    private JPanel PPrincipal;
    private JPanel PBotoes;
    private JLabel numeroRepresentantelb;
    private JTextField numeroRepresentantetf;
    private JLabel nomeRepresentantelb;
    private JTextField nomeRepresentantetf;
    private JLabel telefonelb;
    private JLabel somenteNumerostelefonelb;
    private JTextField telefonetf;
    private JTextField dddtelefonetf;
    private JLabel celularlb;
    private JLabel somenteNumeroscelularlb;
    private JTextField celulartf;
    private JTextField dddcelulartf;
    private JLabel emaillb;
    private JTextField emailtf;
    private JButton salvar;
    private JButton limpar;
    private JButton sair;
    private ConectaDB cdb;
    private final int[] testeSomenteNumeros = new int[4];
    
    public TelaEditarRepresentante(int selecionado) throws SQLException {
        this.setTitle("Cadastro de Representante");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 335);
        this.setLocation(140, 50);
        zerarTesteSomenteNumeros();
        inicializarComponentes();
        prencherCampos(selecionado);
        cdb.closeDB();
        this.setVisible(true);
    }

    private void inicializarComponentes() {
        
        PPrincipal = new JPanel();
        //PPrincipal.setBackground(Color.yellow);
        PPrincipal.setLayout(null);
        PPrincipal.setSize(750, 200);
        PPrincipal.setLocation(25, 25);
        this.add(PPrincipal);
        
        PBotoes = new JPanel();
        //PBotoes.setBackground(Color.yellow);
        PBotoes.setLayout(null);
        PBotoes.setSize(750, 40);
        PBotoes.setLocation(25, 255);
        this.add(PBotoes);
        
        numeroRepresentantelb = new JLabel("Número:");
        numeroRepresentantelb.setSize(100, 20);
        numeroRepresentantelb.setLocation(25, 20);
        PPrincipal.add(numeroRepresentantelb);
        numeroRepresentantetf = new JTextField();
        numeroRepresentantetf.setEditable(false);
        numeroRepresentantetf.setSize(300, 20);
        numeroRepresentantetf.setLocation(220, 20);
        PPrincipal.add(numeroRepresentantetf);
        
        nomeRepresentantelb = new JLabel("Nome:");
        nomeRepresentantelb.setSize(100, 20);
        nomeRepresentantelb.setLocation(25, 50);
        PPrincipal.add(nomeRepresentantelb);
        nomeRepresentantetf = new JTextField();
        nomeRepresentantetf.grabFocus();
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
        telefonetf.addKeyListener(new TrataTeclado());
        PPrincipal.add(telefonetf);
        dddtelefonetf = new JTextField();
        dddtelefonetf.setSize(25, 20);
        dddtelefonetf.setLocation(220, 80);
        dddtelefonetf.addKeyListener(new TrataTeclado());
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
        celulartf.addKeyListener(new TrataTeclado());
        PPrincipal.add(celulartf);
        dddcelulartf = new JTextField();
        dddcelulartf.setSize(25, 20);
        dddcelulartf.setLocation(220, 110);
        dddcelulartf.addKeyListener(new TrataTeclado());
        PPrincipal.add(dddcelulartf);
        
        emaillb = new JLabel("Email:");
        emaillb.setSize(130, 20);
        emaillb.setLocation(25, 140);
        PPrincipal.add(emaillb);
        emailtf = new JTextField();
        emailtf.setSize(300, 20);
        emailtf.setLocation(220, 140);
        PPrincipal.add(emailtf);

        salvar = new JButton("Salvar");
        salvar.setSize(120, 20);
        salvar.setLocation(97, 10);
        salvar.setVisible(true);
        salvar.addActionListener(new TrataBotao());
        PBotoes.add(salvar);
        
        limpar = new JButton("Limpar");
        limpar.setSize(120, 20);
        limpar.setLocation(314, 10);
        limpar.addActionListener(new TrataBotao());
        PBotoes.add(limpar);
        
        sair = new JButton("Sair");
        sair.setSize(120, 20);
        sair.setLocation(531, 10);
        sair.addActionListener(new TrataBotao());
        PBotoes.add(sair);
    }

    private void prencherCampos(int selecionado) throws SQLException {
        String query = "select * from Representante";
        ResultSet r;
        cdb = new ConectaDB();
        r = cdb.pesquisaDB(query);
        while(r.next()){
            if(selecionado == r.getRow()){
                String dddtelefone, telefone, dddcelular, celular;
                long numeroTelefoneLong = Long.parseLong(String.valueOf(r.getObject("telefone")));
                dddtelefone = String.valueOf(numeroTelefoneLong/100000000);
                telefone = String.valueOf(numeroTelefoneLong%100000000);
                long numerocelularLong = Long.parseLong(String.valueOf(r.getObject("celular")));
                dddcelular = String.valueOf(numerocelularLong/100000000);
                celular = String.valueOf(numerocelularLong%100000000);
                numeroRepresentantetf.setText(String.valueOf(r.getObject("numeroRepresentante")));
                nomeRepresentantetf.setText((String) r.getObject("nomeRepresentante"));
                dddtelefonetf.setText(dddtelefone);
                dddcelulartf.setText(dddcelular);
                telefonetf.setText(telefone);
                celulartf.setText(celular);
                emailtf.setText((String) r.getObject("email"));
            }
        }
    }

    private void zerarTesteSomenteNumeros() {
        for(int c = 0; c < testeSomenteNumeros.length; c++){
            testeSomenteNumeros[c] = 0;
        }
    }
    
    public class TrataBotao implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(sair)){
                dispose();
            }else if(e.getSource().equals(limpar)){
                limpar();
            }else if(e.getSource().equals(salvar)){
                /*Verificando os campos numéricos*/
                int teste = 0;
                for(int c = 0; c < testeSomenteNumeros.length; c++){
                    if(testeSomenteNumeros[c] == 1)
                        teste ++;
                }
                /*Fim Verificando os campos numéricos*/
                if(teste > 0){
                    JOptionPane.showMessageDialog(rootPane, "Atenção para os campos numéricos!");
                }else{
                    String query = "update Representante set nomeRepresentante = '"+nomeRepresentantetf.getText()+"', "
                        + "telefone = '"+dddtelefonetf.getText()+telefonetf.getText()+"', "
                        + "celular = '"+dddcelulartf.getText()+celulartf.getText()+"', email = '"+emailtf.getText()+"' "
                            + "where numeroRepresentante = "+Integer.parseInt(numeroRepresentantetf.getText())+"";
                    boolean resposta = cdb.cadastro(query);
                    if(resposta){
                        JOptionPane.showMessageDialog(rootPane, "Operação realizada com sucesso!");
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Não foi possível realizar essa operação!");
                    }
            }
            }
        }

        private void limpar() {
            nomeRepresentantetf.setText("");
            dddtelefonetf.setText("");
            dddcelulartf.setText("");
            telefonetf.setText("");
            celulartf.setText("");
            emailtf.setText("");
            nomeRepresentantetf.grabFocus();
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
            somenteNumerostelefonelb.setVisible(false);
            somenteNumeroscelularlb.setVisible(false);
            zerarTesteSomenteNumeros();
            if("".equals(nomeRepresentantetf.getText())){
                JOptionPane.showMessageDialog(rootPane, "O Campo 'Nome' é obrigatório");
            }else{
                if(!Representante.somenteNumeros(dddtelefonetf.getText())){
                    somenteNumerostelefonelb.setVisible(true);
                    testeSomenteNumeros[0] = 1;
                }else if(!Representante.somenteNumeros(telefonetf.getText())){
                    somenteNumerostelefonelb.setVisible(true);
                    testeSomenteNumeros[1] = 1;
                }else if(!Representante.somenteNumeros(dddcelulartf.getText())){
                    somenteNumeroscelularlb.setVisible(true);
                    testeSomenteNumeros[2] = 1;
                }else if(!Representante.somenteNumeros(celulartf.getText())){
                    somenteNumeroscelularlb.setVisible(true);
                    testeSomenteNumeros[3] = 1;
                }
            }
        }
    }
}
