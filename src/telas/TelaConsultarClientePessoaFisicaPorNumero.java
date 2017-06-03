
package telas;

import classes.ConectaDB;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author adriano
 */
class TelaConsultarClientePessoaFisicaPorNumero extends TelaModelo{
    private JPanel PPrincipal;
    private JPanel PBotoes;
    private JLabel numeroClientelb;
    private JLabel somenteNumerosnumeroClientelb;
    private JTextField numeroClientetf;
    private JLabel nomelb;
    private JTextField nometf;
    private JLabel telefonelb;
    private JTextField telefonetf;
    private JLabel celularlb;
    private JTextField celulartf;
    private JLabel emaillb;
    private JTextField emailtf;
    private JLabel enderecolb;
    private JTextField enderecotf;
    private JLabel bairrolb;
    private JTextField bairrotf;
    private JLabel ceplb;
    private JTextField ceptf;
    private JLabel cidadelb;
    private JTextField cidadetf;
    private JLabel uflb;
    private JTextField uftf;
    private JLabel dataNacimentolb;
    private JTextField dataNacimentotf;
    private JButton sair;
    private JLabel cpflb;
    private JTextField cpftf;
    private JLabel rglb;
    private JTextField rgtf;
    private ConectaDB cdb;

    private int numeroCliente;
    private JLabel diaVencimentolb;
    private JTextField diaVencimentotf;
    public TelaConsultarClientePessoaFisicaPorNumero(int numero) throws SQLException {
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 550);
        this.setLocation(140, 50);   
        this.setTitle("Consultar Cliente por Número");
        numeroCliente = numero;
        inicializarComponentes();
        preencherCampos();
        this.setVisible(true);
    }

    private void inicializarComponentes() {
        PPrincipal = new JPanel();
        PPrincipal.setLayout(null);
        //PPrincipal.setBackground(Color.yellow);
        PPrincipal.setSize(750, 450);
        PPrincipal.setLocation(25, 0);
        this.add(PPrincipal);
        
        PBotoes = new JPanel();
        PBotoes.setLayout(null);
        //PBotoes.setBackground(Color.yellow);
        PBotoes.setSize(750, 40);
        PBotoes.setLocation(25, 480);
        this.add(PBotoes);
        
        numeroClientelb = new JLabel("Número:");
        numeroClientelb.setSize(100, 20);
        numeroClientelb.setLocation(10, 20);
        PPrincipal.add(numeroClientelb);
        numeroClientetf = new JTextField(String.valueOf(numeroCliente));
        numeroClientetf.setToolTipText("Digite o Número do Cliente");
        numeroClientetf.setSize(300, 20);
        numeroClientetf.setLocation(220, 20);
        numeroClientetf.setEditable(false);
        PPrincipal.add(numeroClientetf);
        
        nomelb = new JLabel("Nome:");
        nomelb.setSize(100, 20);
        nomelb.setLocation(10, 50);
        PPrincipal.add(nomelb);
        nometf = new JTextField();
        nometf.setEditable(false);
        nometf.setSize(300, 20);
        nometf.setLocation(220, 50);
        PPrincipal.add(nometf);
        
        telefonelb = new JLabel("Telefone:");
        telefonelb.setSize(100, 20);
        telefonelb.setLocation(10, 80);
        PPrincipal.add(telefonelb);
        telefonetf = new JTextField();
        telefonetf.setEditable(false);
        telefonetf.setSize(300, 20);
        telefonetf.setLocation(220, 80);
        PPrincipal.add(telefonetf);
        
        celularlb = new JLabel("Celular:");
        celularlb.setSize(100, 20);
        celularlb.setLocation(10, 110);
        PPrincipal.add(celularlb);
        celulartf = new JTextField();
        celulartf.setEditable(false);
        celulartf.setSize(300, 20);
        celulartf.setLocation(220, 110);
        PPrincipal.add(celulartf);
        
        emaillb = new JLabel("EMAIL:");
        emaillb.setSize(100, 20);
        emaillb.setLocation(10, 140);
        PPrincipal.add(emaillb);
        emailtf = new JTextField();
        emailtf.setEditable(false);
        emailtf.setSize(300, 20);
        emailtf.setLocation(220, 140);
        PPrincipal.add(emailtf);
        
        cpflb = new JLabel("CPF:");
        cpflb.setSize(100, 20);
        cpflb.setLocation(10, 170);
        PPrincipal.add(cpflb);
        cpftf = new JTextField();
        cpftf.setEditable(false);
        cpftf.setSize(300, 20);
        cpftf.setLocation(220, 170);
        PPrincipal.add(cpftf);
        
        rglb = new JLabel("RG:");
        rglb.setSize(100, 20);
        rglb.setLocation(10, 200);
        PPrincipal.add(rglb);
        rgtf = new JTextField();
        rgtf.setEditable(false);
        rgtf.setSize(300, 20);
        rgtf.setLocation(220, 200);
        PPrincipal.add(rgtf);
        
        enderecolb = new JLabel("Endereço:");
        enderecolb.setSize(100, 20);
        enderecolb.setLocation(10, 230);
        PPrincipal.add(enderecolb);
        enderecotf = new JTextField();
        enderecotf.setEditable(false);
        enderecotf.setSize(300, 20);
        enderecotf.setLocation(220, 230);
        PPrincipal.add(enderecotf);
        
        bairrolb = new JLabel("Bairro:");
        bairrolb.setSize(100, 20);
        bairrolb.setLocation(10, 260);
        PPrincipal.add(bairrolb);
        bairrotf = new JTextField();
        bairrotf.setEditable(false);
        bairrotf.setSize(300, 20);
        bairrotf.setLocation(220, 260);
        PPrincipal.add(bairrotf);
        
        ceplb = new JLabel("CEP:");
        ceplb.setSize(100, 20);
        ceplb.setLocation(10, 290);
        PPrincipal.add(ceplb);
        ceptf = new JTextField();
        ceptf.setEditable(false);
        ceptf.setSize(300, 20);
        ceptf.setLocation(220, 290);
        PPrincipal.add(ceptf);
        
        cidadelb = new JLabel("Cidade:");
        cidadelb.setSize(100, 20);
        cidadelb.setLocation(10, 320);
        PPrincipal.add(cidadelb);
        cidadetf = new JTextField();
        cidadetf.setEditable(false);
        cidadetf.setSize(300, 20);
        cidadetf.setLocation(220, 320);
        PPrincipal.add(cidadetf);
        
        uflb = new JLabel("UF:");
        uflb.setSize(100, 20);
        uflb.setLocation(10, 350);
        PPrincipal.add(uflb);
        uftf = new JTextField();
        uftf.setEditable(false);
        uftf.setSize(25, 20);
        uftf.setLocation(220, 350);
        PPrincipal.add(uftf);
        
        dataNacimentolb = new JLabel("Data Nacimento:");
        dataNacimentolb.setSize(130, 20);
        dataNacimentolb.setLocation(10, 380);
        PPrincipal.add(dataNacimentolb);
        dataNacimentotf = new JTextField();
        dataNacimentotf.setEditable(false);
        dataNacimentotf.setSize(150, 20);
        dataNacimentotf.setLocation(220, 380);
        PPrincipal.add(dataNacimentotf);
        
        diaVencimentolb = new JLabel("Dia Vencimento:");
        diaVencimentolb.setSize(130, 20);
        diaVencimentolb.setLocation(10, 410);
        PPrincipal.add(diaVencimentolb);
        diaVencimentotf = new JTextField();
        diaVencimentotf.setEditable(false);
        diaVencimentotf.setSize(25, 20);
        diaVencimentotf.setLocation(220, 410);
        PPrincipal.add(diaVencimentotf);
        
        sair = new JButton("Sair");
        sair.setSize(130, 20);
        sair.setLocation(310, 10);
        sair.addActionListener(new TrataBotao());
        PBotoes.add(sair);
    }

    private void preencherCampos() throws SQLException {
        
        ResultSet r;
        cdb = new ConectaDB();
        r = cdb.pesquisaDB("select * from Cliente , PessoaFisica "
                + "where Cliente.numeroCliente = "+numeroCliente+" and "
                + "PessoaFisica.numeroCliente = "+numeroCliente+"");
        while(r.next()){
            nometf.setText((String) r.getObject("nome"));
            telefonetf.setText((String) r.getObject("telefone"));
            celulartf.setText((String) r.getObject("celular"));
            emailtf.setText((String) r.getObject("email"));
            enderecotf.setText((String) r.getObject("endereco"));
            bairrotf.setText((String) r.getObject("bairro"));
            ceptf.setText((String) r.getObject("cep"));
            cidadetf.setText((String) r.getObject("cidade"));
            uftf.setText((String) r.getObject("uf"));
            cpftf.setText((String) r.getObject("cpf"));
            rgtf.setText((String) r.getObject("rg"));
            dataNacimentotf.setText(String.valueOf(r.getObject("dataNacimento")));
            diaVencimentotf.setText((String) r.getObject("diaVencimento"));
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
