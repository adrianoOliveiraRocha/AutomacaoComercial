
package telas;

import classes.ConectaDB;
import classes.Fornecedor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class TelaEditarFornecedor extends TelaModelo{
    private JPanel PPrincipal;
    private JPanel PBotoes;
    
    private JTextField numeroFornecedortf;
    private JLabel numeroFornecedorlb;
    private JTextField razaoSocialtf;
    private JLabel razaoSociallb;
    private JTextField nomeFantasiatf;
    private JLabel nomeFantasialb;
    private JTextField cnpjtf;
    private JLabel cnpjlb;
    private JTextField inscricaoEstadualtf;
    private JLabel inscricaoEstaduallb;
    private JTextField telefonetf;
    private JTextField dddtelefonetf;
    private JLabel telefonelb;
    private JTextField celulartf;
    private JTextField dddcelulartf;
    private JLabel celularlb;
    private JTextField emailtf;
    private JLabel emaillb;
    private JTextField enderecotf;
    private JLabel enderecolb;
    private JTextField numerotf;
    private JTextField complementotf;
    private JLabel complementolb;
    private JTextField bairrotf;
    private JLabel bairrolb;
    private JTextField ceptf;
    private JLabel ceplb;
    private JTextField cidadetf;
    private JLabel cidadelb;
    private JTextField uftf;
    private JLabel uflb;
    private JTextField abreviacaotf;
    private JLabel abreviacaolb;
    private ConectaDB cdb;
    private Fornecedor f;
    private final String exibirNF;
    
    private JLabel somenteNumeroscnpjlb;
    private JLabel somenteNumerosinscricaoEstaduallb;
    private JLabel somenteNumerostelefonelb;
    private JLabel somenteNumeroscelularlb;
    private JLabel somenteNumerosnumerolb;
    private JLabel somenteNumerosceplb;
    private JButton salvar;
    private JButton limpar;
    private JButton sair;
    int testeSomenteNumeros[] = new int[6]; int resposta;
    public TelaEditarFornecedor(String numeroFornecedorS) throws SQLException{
        exibirNF = numeroFornecedorS;
        this.setTitle("Editar Fornecedor");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 530);
        this.setLocation(140, 50);
        inicializarComponentes();
        razaoSocialtf.grabFocus();
        preencherCampos(); cdb.closeDB();
        this.setVisible(true);
    }

    private void inicializarComponentes() {
        PBotoes = new JPanel();
        //PBotoes.setBackground(Color.yellow);
        PBotoes.setLayout(null);
        PBotoes.setSize(750, 40);
        PBotoes.setLocation(25, 460);
        this.add(PBotoes);
        
        PPrincipal = new JPanel();
        //PPrincipal.setBackground(Color.yellow);
        PPrincipal.setLayout(null);
        PPrincipal.setSize(750, 450);
        PPrincipal.setLocation(25, 0);
        this.add(PPrincipal);
        
        numeroFornecedorlb = new JLabel("Número:");
        numeroFornecedorlb.setSize(100, 20);
        numeroFornecedorlb.setLocation(25, 20);
        PPrincipal.add(numeroFornecedorlb);
        numeroFornecedortf = new JTextField();
        numeroFornecedortf.setEditable(false);
        numeroFornecedortf.setToolTipText("Gerado pelo sistema");
        numeroFornecedortf.setText(exibirNF);
        numeroFornecedortf.setSize(300, 20);
        numeroFornecedortf.setLocation(220, 20);
        PPrincipal.add(numeroFornecedortf);
        
        razaoSociallb = new JLabel("Razão Social:");
        razaoSociallb.setSize(100, 20);
        razaoSociallb.setLocation(25, 50);
        PPrincipal.add(razaoSociallb);
        razaoSocialtf = new JTextField();
        razaoSocialtf.setSize(300, 20);
        razaoSocialtf.setLocation(220, 50);
        PPrincipal.add(razaoSocialtf);
        
        nomeFantasialb = new JLabel("Nome Fantasia:");
        nomeFantasialb.setSize(130, 20);
        nomeFantasialb.setLocation(25, 80);
        PPrincipal.add(nomeFantasialb);
        nomeFantasiatf = new JTextField();
        nomeFantasiatf.setSize(300, 20);
        nomeFantasiatf.setLocation(220, 80);
        PPrincipal.add(nomeFantasiatf);
        
        cnpjlb = new JLabel("CNPJ:");
        cnpjlb.setSize(100, 20);
        cnpjlb.setLocation(25, 110);
        PPrincipal.add(cnpjlb);
        cnpjtf = new JTextField();
        cnpjtf.setSize(300, 20);
        cnpjtf.setLocation(220, 110);
        cnpjtf.addKeyListener(new trataTeclado());
        PPrincipal.add(cnpjtf);
        somenteNumeroscnpjlb = new JLabel("Somente Números");
        somenteNumeroscnpjlb.setForeground(Color.red);
        somenteNumeroscnpjlb.setVisible(false);
        somenteNumeroscnpjlb.setSize(200, 20);
        somenteNumeroscnpjlb.setLocation(570, 110);
        PPrincipal.add(somenteNumeroscnpjlb);
        
        inscricaoEstaduallb = new JLabel("Inscrição Estadual:");
        inscricaoEstaduallb.setSize(140, 20);
        inscricaoEstaduallb.setLocation(25, 140);
        PPrincipal.add(inscricaoEstaduallb);
        inscricaoEstadualtf = new JTextField();
        inscricaoEstadualtf.setSize(300, 20);
        inscricaoEstadualtf.setLocation(220, 140);
        inscricaoEstadualtf.addKeyListener(new trataTeclado());
        PPrincipal.add(inscricaoEstadualtf);
        somenteNumerosinscricaoEstaduallb = new JLabel("Somente Números");
        somenteNumerosinscricaoEstaduallb.setForeground(Color.red);
        somenteNumerosinscricaoEstaduallb.setVisible(false);
        somenteNumerosinscricaoEstaduallb.setSize(200, 20);
        somenteNumerosinscricaoEstaduallb.setLocation(570, 140);
        PPrincipal.add(somenteNumerosinscricaoEstaduallb);
        
        telefonelb = new JLabel("Telefone:");
        telefonelb.setSize(100, 20);
        telefonelb.setLocation(25, 170);
        PPrincipal.add(telefonelb);
        somenteNumerostelefonelb = new JLabel("Somente Números");
        somenteNumerostelefonelb.setForeground(Color.red);
        somenteNumerostelefonelb.setVisible(false);
        somenteNumerostelefonelb.setSize(200, 20);
        somenteNumerostelefonelb.setLocation(570, 170);
        PPrincipal.add(somenteNumerostelefonelb);
        telefonetf = new JTextField();
        telefonetf.setSize(150, 20);
        telefonetf.setLocation(220, 170);
        telefonetf.addKeyListener(new trataTeclado());
        PPrincipal.add(telefonetf);
        
        celularlb = new JLabel("Celular:");
        celularlb.setSize(100, 20);
        celularlb.setLocation(25, 200);
        PPrincipal.add(celularlb);
        somenteNumeroscelularlb = new JLabel("Somente Números");
        somenteNumeroscelularlb.setForeground(Color.red);
        somenteNumeroscelularlb.setVisible(false);
        somenteNumeroscelularlb.setSize(200, 20);
        somenteNumeroscelularlb.setLocation(570, 200);
        PPrincipal.add(somenteNumeroscelularlb);
        celulartf = new JTextField();
        celulartf.setSize(150, 20);
        celulartf.setLocation(220, 200);
        celulartf.addKeyListener(new trataTeclado());
        PPrincipal.add(celulartf);
                
        emaillb = new JLabel("Email:");
        emaillb.setSize(130, 20);
        emaillb.setLocation(25, 230);
        PPrincipal.add(emaillb);
        emailtf = new JTextField();
        emailtf.setSize(300, 20);
        emailtf.setLocation(220, 230);
        PPrincipal.add(emailtf);
    
        enderecolb = new JLabel("Endereço:");
        enderecolb.setSize(200, 20);
        enderecolb.setLocation(25, 260);
        PPrincipal.add(enderecolb);
        somenteNumerosnumerolb = new JLabel("Somente Números");
        somenteNumerosnumerolb.setForeground(Color.red);
        somenteNumerosnumerolb.setVisible(false);
        somenteNumerosnumerolb.setSize(200, 20);
        somenteNumerosnumerolb.setLocation(570, 260);
        PPrincipal.add(somenteNumerosnumerolb);
        enderecotf = new JTextField();
        enderecotf.setSize(240, 20);
        enderecotf.setLocation(220, 260);
        PPrincipal.add(enderecotf);
                        
        complementolb = new JLabel("Complemento:");
        complementolb.setSize(200, 20);
        complementolb.setLocation(25, 290);
        PPrincipal.add(complementolb);
        complementotf = new JTextField();
        complementotf.setSize(300, 20);
        complementotf.setLocation(220, 290);
        PPrincipal.add(complementotf);
        
        bairrolb = new JLabel("Bairro:");
        bairrolb.setSize(200, 20);
        bairrolb.setLocation(25, 320);
        PPrincipal.add(bairrolb);
        bairrotf = new JTextField();
        bairrotf.setSize(300, 20);
        bairrotf.setLocation(220, 320);
        PPrincipal.add(bairrotf);
        
        ceplb = new JLabel("CEP:");
        ceplb.setSize(200, 20);
        ceplb.setLocation(25, 350);
        PPrincipal.add(ceplb);
        somenteNumerosceplb = new JLabel("Somente Números");
        somenteNumerosceplb.setForeground(Color.red);
        somenteNumerosceplb.setVisible(false);
        somenteNumerosceplb.setSize(200, 20);
        somenteNumerosceplb.setLocation(570, 350);
        PPrincipal.add(somenteNumerosceplb);
        ceptf = new JTextField();
        ceptf.setSize(300, 20);
        ceptf.setLocation(220, 350);
        ceptf.addKeyListener(new trataTeclado());
        PPrincipal.add(ceptf);
        
        cidadelb = new JLabel("Cidade:");
        cidadelb.setSize(200, 20);
        cidadelb.setLocation(25, 380);
        PPrincipal.add(cidadelb);
        cidadetf = new JTextField();
        cidadetf.setSize(300, 20);
        cidadetf.setLocation(220, 380);
        PPrincipal.add(cidadetf);
        
        uflb = new JLabel("UF:");
        uflb.setSize(25, 20);
        uflb.setLocation(25, 410);
        PPrincipal.add(uflb);
        uftf = new JTextField();
        uftf.setSize(25, 20);
        uftf.setLocation(220, 410);
        PPrincipal.add(uftf);
        
        salvar = new JButton("Salvar");
        salvar.setSize(130, 20);
        salvar.setLocation(90, 10);
        salvar.setVisible(true);
        salvar.addActionListener(new TrataBotao());
        PBotoes.add(salvar);
        
        limpar = new JButton("Limpar");
        limpar.setSize(130, 20);
        limpar.setLocation(310, 10);
        limpar.setVisible(true);
        limpar.addActionListener(new TrataBotao());
        PBotoes.add(limpar);
        
        sair = new JButton("Sair");
        sair.setSize(130, 20);
        sair.setLocation(530, 10);
        sair.setVisible(true);
        sair.addActionListener(new TrataBotao());
        PBotoes.add(sair);
        
    }

    private void preencherCampos() throws SQLException {
        limpar();
        cdb = new ConectaDB();
        ResultSet r = cdb.pesquisaDB("select * from Fornecedor");
        while(r.next()){
            
            if(Integer.parseInt(exibirNF) == Integer.parseInt(String.valueOf(r.getObject(1)))){
                razaoSocialtf.setText((String) r.getObject("rezaoSocial"));
                nomeFantasiatf.setText((String) r.getObject("nomeFantasia"));
                cnpjtf.setText((String) r.getObject("cnpj"));
                inscricaoEstadualtf.setText((String) r.getObject("inscricaoEstadual"));
                telefonetf.setText((String) r.getObject("telefone"));
                celulartf.setText((String) r.getObject("celular"));
                emailtf.setText((String) r.getObject("email"));
                enderecotf.setText((String) r.getObject("endereco"));
                complementotf.setText((String) r.getObject("complemento"));
                bairrotf.setText((String) r.getObject("bairro"));
                ceptf.setText((String) r.getObject("cep"));
                cidadetf.setText((String) r.getObject("cidade"));
                uftf.setText((String) r.getObject("uf"));
            }
            
        }
    }

    private void limpar() {
        razaoSocialtf.setText("");
        nomeFantasiatf.setText("");
        cnpjtf.setText("");
        inscricaoEstadualtf.setText("");
        telefonetf.setText("");
        celulartf.setText("");
        emailtf.setText("");
        enderecotf.setText("");
        complementotf.setText("");
        bairrotf.setText("");
        ceptf.setText("");
        cidadetf.setText("");
        uftf.setText("");
    }
    
    public class TrataBotao implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(sair)){
                dispose();
            }else if(e.getSource().equals(limpar)){
                limpar();
            }else if(e.getSource().equals(salvar)){
                resposta = 0;
                for(int x = 0; x < testeSomenteNumeros.length; x++){
                    if(testeSomenteNumeros[x] == 1){
                        resposta ++;
                    }
                }
                
                if(resposta == 0){
                    String query = "update Fornecedor set rezaoSocial = '"+razaoSocialtf.getText()+"', "
                            + "nomeFantasia = '"+nomeFantasiatf.getText()+"', cnpj = '"+cnpjtf.getText()+"', "
                            + "inscricaoEstadual = '"+inscricaoEstadualtf.getText()+"', telefone = '"+telefonetf.getText()+"', "
                            + "celular = '"+celulartf.getText()+"', email = '"+emailtf.getText()+"', "
                            + "endereco = '"+enderecotf.getText()+"', complemento = '"+complementotf.getText()+"', "
                            + "bairro = '"+bairrotf.getText()+"', cep = '"+ceptf.getText()+"', "
                            + "cidade = '"+cidadetf.getText()+"', uf = '"+uftf.getText()+"' "
                            + "where numeroFornecedor = "+Integer.parseInt(numeroFornecedortf.getText())+"";
                            
                            if(cdb.cadastro(query)){
                                JOptionPane.showMessageDialog(rootPane, "Operação Realizada Com Sucesso!");
                            }                            
                }else{
                    JOptionPane.showMessageDialog(rootPane, resposta);
                }
                
            }
        }
        
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
                testeSomenteNumeros[0] = 0;
                if(!"".equals(cnpjtf.getText())){
                    if(!Fornecedor.somenteNumeros(cnpjtf.getText())){
                        somenteNumeroscnpjlb.setVisible(true);
                        testeSomenteNumeros[0] = 1;
                    }
                }
            }else if(e.getSource().equals(inscricaoEstadualtf)){
                somenteNumerosinscricaoEstaduallb.setVisible(false);
                testeSomenteNumeros[1] = 0;
                if(!"".equals(inscricaoEstadualtf.getText())){
                    if(!Fornecedor.somenteNumeros(inscricaoEstadualtf.getText())){
                        somenteNumerosinscricaoEstaduallb.setVisible(true);
                        testeSomenteNumeros[1] = 1;
                    }
                }
            }else if(e.getSource().equals(telefonetf)){
                somenteNumerostelefonelb.setVisible(false);
                testeSomenteNumeros[2] = 0;
                if(!"".equals(telefonetf.getText())){
                    if(!Fornecedor.somenteNumeros(telefonetf.getText())){
                        somenteNumerostelefonelb.setVisible(true);
                        testeSomenteNumeros[3] = 1;
                    }
                }
            }else if(e.getSource().equals(celulartf)){
                somenteNumeroscelularlb.setVisible(false);
                testeSomenteNumeros[4] = 0;
                if(!"".equals(celulartf.getText())){
                    if(!Fornecedor.somenteNumeros(celulartf.getText())){
                        somenteNumeroscelularlb.setVisible(true);
                        testeSomenteNumeros[4] = 1;
                    }
                }
            }else if(e.getSource().equals(ceptf)){
                somenteNumerosceplb.setVisible(false);
                testeSomenteNumeros[5] = 0;
                if(!"".equals(ceptf.getText())){
                    if(!Fornecedor.somenteNumeros(ceptf.getText())){
                        somenteNumerosceplb.setVisible(true);
                        testeSomenteNumeros[5] = 1;
                    }
                }
            }
        }
        
    }
}
