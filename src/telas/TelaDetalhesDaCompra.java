

package telas;

import classes.ConectaDB;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.BorderFactory;
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

class TelaDetalhesDaCompra extends TelaModelo{
    DecimalFormat df = new DecimalFormat("#,###.00");/*Serve pra exibir valores formatados*/
    private JPanel PCmopraAvulsa;
    private JPanel PFornecedor;
    private JPanel PRepresentante;
    private JPanel PFuncionario;
    private JLabel fornecedorTitulolb;
    private JLabel representanteTitulolb;
    private JLabel funcionarioTitulolb;
    private JLabel numeroFornecedorlb;
    private JTextField numeroFornecedortf;
    private JLabel nomeFantasialb;
    private JTextField nomeFantasiatf;
    private JLabel cnpjlb;
    private JTextField cnpjtf;
    private JLabel telefonelb;
    private JTextField telefonetf;
    private JLabel emiallb;
    private JTextField emialtf;
    private JLabel enderecolb;
    private JTextField enderecotf;
    private JLabel numeroRepresentantelb;
    private JTextField numeroRepresentantetf;
    private JLabel nomeRepresentantelb;
    private JTextField nomeRepresentantetf;
    private JLabel telefoneRepresentantelb;
    private JTextField telefoneRepresentantetf;
    private JLabel celularRepresentantelb;
    private JTextField celularRepresentantetf;
    private JLabel emaillb;
    private JTextField emailtf;
    private JLabel numeroFuncionariolb;
    private JTextField numeroFuncionariotf;
    private JLabel nomeFuncionariolb;
    private JTextField nomeFuncionariotf;
    private JLabel cpfFuncionariolb;
    private JTextField cpfFuncionariotf;
    private JLabel rgFuncionariolb;
    private JTextField rgFuncionariotf;
    private JPanel PBotoes;
    private JButton sair;
    private JLabel numeroCompraAvulsalb;
    private JTextField numeroCompraAvulsatf;
    private JLabel totalCompraAvulsalb;
    private JTextField totalCompraAvulsatf;
    private JLabel dataCompraAvulsalb;
    private JTextField dataCompraAvulsatf;
    private ArrayList quantidades;
    private ConectaDB cdb;
    private ArrayList precos;
    private ConectaDB cdbF;
    private JTextField emaiFornecedorltf;
    private ConectaDB cdbR;
    private ConectaDB cdbFunc;

    public TelaDetalhesDaCompra(int numeroCompraAvulsa) throws SQLException {
        
        this.setLayout(null);
        this.setTitle("Detalhes da Compra");
        this.setSize(1100, 630);
        this.setLocation(50, 0);
        inicializarPaneis();
        numeroCompraAvulsatf.setText(String.valueOf(numeroCompraAvulsa));
        preencherDadosDaCompra(numeroCompraAvulsa);
        preencherDadosFornecedor(numeroCompraAvulsa);
        preencheDadosFuncionario(numeroCompraAvulsa);
        this.setResizable(false);
        
    }

    private void inicializarPaneis() {
        
        PCmopraAvulsa = new JPanel();
        PCmopraAvulsa.setLayout(null);
        PCmopraAvulsa.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        //PCmopraAvulsa.setBackground(Color.yellow);
        PCmopraAvulsa.setSize(1050, 60);
        PCmopraAvulsa.setLocation(25, 20);
        this.add(PCmopraAvulsa);
        
        numeroCompraAvulsalb = new JLabel("Número");
        numeroCompraAvulsalb.setSize(100, 20);
        numeroCompraAvulsalb.setLocation(125, 20);
        PCmopraAvulsa.add(numeroCompraAvulsalb);
        numeroCompraAvulsatf = new JTextField();
        numeroCompraAvulsatf.setEditable(false);
        numeroCompraAvulsatf.setSize(100, 20);
        numeroCompraAvulsatf.setLocation(245, 20);
        PCmopraAvulsa.add(numeroCompraAvulsatf);
        
        totalCompraAvulsalb = new JLabel("Total");
        totalCompraAvulsalb.setSize(100, 20);
        totalCompraAvulsalb.setLocation(470, 20);
        PCmopraAvulsa.add(totalCompraAvulsalb);
        totalCompraAvulsatf = new JTextField();
        totalCompraAvulsatf.setEditable(false);
        totalCompraAvulsatf.setSize(100, 20);
        totalCompraAvulsatf.setLocation(590, 20);
        PCmopraAvulsa.add(totalCompraAvulsatf);
        
        dataCompraAvulsalb = new JLabel("Data");
        dataCompraAvulsalb.setSize(100, 20);
        dataCompraAvulsalb.setLocation(765, 20);
        PCmopraAvulsa.add(dataCompraAvulsalb);
        dataCompraAvulsatf = new JTextField();
        dataCompraAvulsatf.setEditable(false);
        dataCompraAvulsatf.setSize(100, 20);
        dataCompraAvulsatf.setLocation(885, 20);
        PCmopraAvulsa.add(dataCompraAvulsatf);
        
        PFornecedor = new JPanel();
        PFornecedor.setLayout(null);
        PFornecedor.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        //PFornecedor.setBackground(Color.yellow);
        PFornecedor.setSize(500, 300);
        PFornecedor.setLocation(33, 100);
        this.add(PFornecedor);
        
        fornecedorTitulolb = new JLabel("Fornecedor");
        fornecedorTitulolb.setSize(100, 20);
        fornecedorTitulolb.setLocation(200, 10);
        PFornecedor.add(fornecedorTitulolb);
        
        numeroFornecedorlb = new JLabel("Número");
        numeroFornecedorlb.setSize(100, 20);
        numeroFornecedorlb.setLocation(10, 40);
        PFornecedor.add(numeroFornecedorlb);
        numeroFornecedortf = new JTextField();
        numeroFornecedortf.setEditable(false);
        numeroFornecedortf.setSize(300, 20);
        numeroFornecedortf.setLocation(130, 40);
        PFornecedor.add(numeroFornecedortf);
        
        nomeFantasialb = new JLabel("Nome");
        nomeFantasialb.setSize(100, 20);
        nomeFantasialb.setLocation(10, 70);
        PFornecedor.add(nomeFantasialb);
        nomeFantasiatf = new JTextField();
        nomeFantasiatf.setEditable(false);
        nomeFantasiatf.setSize(300, 20);
        nomeFantasiatf.setLocation(130, 70);
        PFornecedor.add(nomeFantasiatf);
        
        cnpjlb = new JLabel("CNPJ");
        cnpjlb.setSize(100, 20);
        cnpjlb.setLocation(10, 100);
        PFornecedor.add(cnpjlb);
        cnpjtf = new JTextField();
        cnpjtf.setEditable(false);
        cnpjtf.setSize(300, 20);
        cnpjtf.setLocation(130, 100);
        PFornecedor.add(cnpjtf);
        
        telefonelb = new JLabel("Telefone");
        telefonelb.setSize(100, 20);
        telefonelb.setLocation(10, 130);
        PFornecedor.add(telefonelb);
        telefonetf = new JTextField();
        telefonetf.setEditable(false);
        telefonetf.setSize(300, 20);
        telefonetf.setLocation(130, 130);
        PFornecedor.add(telefonetf);
        
        emiallb = new JLabel("EMAIL");
        emiallb.setSize(100, 20);
        emiallb.setLocation(10, 160);
        PFornecedor.add(emiallb);
        emaiFornecedorltf = new JTextField();
        emaiFornecedorltf.setEditable(false);
        emaiFornecedorltf.setSize(300, 20);
        emaiFornecedorltf.setLocation(130, 160);
        PFornecedor.add(emaiFornecedorltf);
        
        enderecolb = new JLabel("Endereço");
        enderecolb.setSize(100, 20);
        enderecolb.setLocation(10, 190);
        PFornecedor.add(enderecolb);
        enderecotf = new JTextField();
        enderecotf.setEditable(false);
        enderecotf.setSize(300, 20);
        enderecotf.setLocation(130, 190);
        PFornecedor.add(enderecotf);
                
        PRepresentante = new JPanel();
        PRepresentante.setLayout(null);
        PRepresentante.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        //PRepresentante.setBackground(Color.yellow);
        PRepresentante.setSize(500, 300);
        PRepresentante.setLocation(566, 100);
        this.add(PRepresentante);
        
        representanteTitulolb = new JLabel("Representante");
        representanteTitulolb.setSize(150, 20);
        representanteTitulolb.setLocation(200, 10);
        PRepresentante.add(representanteTitulolb);
        
        numeroRepresentantelb = new JLabel("Número");
        numeroRepresentantelb.setSize(100, 20);
        numeroRepresentantelb.setLocation(10, 40);
        PRepresentante.add(numeroRepresentantelb);
        numeroRepresentantetf = new JTextField();
        numeroRepresentantetf.setEditable(false);
        numeroRepresentantetf.setSize(300, 20);
        numeroRepresentantetf.setLocation(130, 40);
        PRepresentante.add(numeroRepresentantetf);
        
        nomeRepresentantelb = new JLabel("Nome");
        nomeRepresentantelb.setSize(100, 20);
        nomeRepresentantelb.setLocation(10, 70);
        PRepresentante.add(nomeRepresentantelb);
        nomeRepresentantetf = new JTextField();
        nomeRepresentantetf.setEditable(false);
        nomeRepresentantetf.setSize(300, 20);
        nomeRepresentantetf.setLocation(130, 70);
        PRepresentante.add(nomeRepresentantetf);
        
        telefoneRepresentantelb = new JLabel("Telefone");
        telefoneRepresentantelb.setSize(100, 20);
        telefoneRepresentantelb.setLocation(10, 100);
        PRepresentante.add(telefoneRepresentantelb);
        telefoneRepresentantetf = new JTextField();
        telefoneRepresentantetf.setEditable(false);
        telefoneRepresentantetf.setSize(300, 20);
        telefoneRepresentantetf.setLocation(130, 100);
        PRepresentante.add(telefoneRepresentantetf);
        
        celularRepresentantelb = new JLabel("Celular");
        celularRepresentantelb.setSize(100, 20);
        celularRepresentantelb.setLocation(10, 130);
        PRepresentante.add(celularRepresentantelb);
        celularRepresentantetf = new JTextField();
        celularRepresentantetf.setEditable(false);
        celularRepresentantetf.setSize(300, 20);
        celularRepresentantetf.setLocation(130, 130);
        PRepresentante.add(celularRepresentantetf);
        
        emaillb = new JLabel("EMAIL");
        emaillb.setSize(100, 20);
        emaillb.setLocation(10, 160);
        PRepresentante.add(emaillb);
        emailtf = new JTextField();
        emailtf.setEditable(false);
        emailtf.setSize(300, 20);
        emailtf.setLocation(130, 160);
        PRepresentante.add(emailtf);
        
        PFuncionario = new JPanel();
        PFuncionario.setLayout(null);
        PFuncionario.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        //PFuncionario.setBackground(Color.yellow);
        PFuncionario.setSize(1050, 120);
        PFuncionario.setLocation(25, 420);
        this.add(PFuncionario);
        
        funcionarioTitulolb = new JLabel("Funcionário");
        funcionarioTitulolb.setSize(100, 20);
        funcionarioTitulolb.setLocation(480, 10);
        PFuncionario.add(funcionarioTitulolb);
        
        numeroFuncionariolb = new JLabel("Número");
        numeroFuncionariolb.setSize(100, 20);
        numeroFuncionariolb.setLocation(10, 40);
        PFuncionario.add(numeroFuncionariolb);
        numeroFuncionariotf = new JTextField();
        numeroFuncionariotf.setEditable(false);
        numeroFuncionariotf.setSize(300, 20);
        numeroFuncionariotf.setLocation(120, 40);
        PFuncionario.add(numeroFuncionariotf);
        
        nomeFuncionariolb = new JLabel("Nome");
        nomeFuncionariolb.setSize(100, 20);
        nomeFuncionariolb.setLocation(600, 40);
        PFuncionario.add(nomeFuncionariolb);
        nomeFuncionariotf = new JTextField();
        nomeFuncionariotf.setEditable(false);
        nomeFuncionariotf.setSize(300, 20);
        nomeFuncionariotf.setLocation(720, 40);
        PFuncionario.add(nomeFuncionariotf);
        
        cpfFuncionariolb = new JLabel("CPF:");
        cpfFuncionariolb.setSize(100, 20);
        cpfFuncionariolb.setLocation(10, 70);
        PFuncionario.add(cpfFuncionariolb);
        cpfFuncionariotf = new JTextField();
        cpfFuncionariotf.setEditable(false);
        cpfFuncionariotf.setSize(300, 20);
        cpfFuncionariotf.setLocation(120, 70);
        PFuncionario.add(cpfFuncionariotf);
        
        rgFuncionariolb = new JLabel("RG");
        rgFuncionariolb.setSize(100, 20);
        rgFuncionariolb.setLocation(600, 70);
        PFuncionario.add(rgFuncionariolb);
        rgFuncionariotf = new JTextField();
        rgFuncionariotf.setEditable(false);
        rgFuncionariotf.setSize(300, 20);
        rgFuncionariotf.setLocation(720, 70);
        PFuncionario.add(rgFuncionariotf);
        
        PBotoes = new JPanel();
        PBotoes.setLayout(null);
        //PBotoes.setBackground(Color.yellow);
        PBotoes.setSize(1050, 40);
        PBotoes.setLocation(25, 560);
        this.add(PBotoes);
        
        sair = new JButton("Sair");
        sair.setSize(100, 20);
        sair.setLocation(475, 10);
        sair.addActionListener(new TrataBotao());
        PBotoes.add(sair);
    }

    private void preencherDadosDaCompra(int numeroCompraAvulsa) throws SQLException {
        //Calculando o total
        quantidades = new ArrayList();
        precos = new ArrayList();
        ResultSet totalR;
        cdb = new ConectaDB();
        totalR = cdb.pesquisaDB("select * from ItemPedidoCompraAvulsa "
                + "where numeroCompraAvulsa = "+numeroCompraAvulsa+"");
        int[] quantidadesInt = new int[quantidades.size()];
        int[] precosInt = new int[precos.size()];
        while(totalR.next()){
            quantidades.add(totalR.getObject("quantidade"));
            precos.add(totalR.getObject("precoUnitario"));
        }
        double total = 0;
        for(int x = 0; x < quantidades.size(); x++){
            total = Integer.parseInt(String.valueOf(quantidades.get(x))) * Double.parseDouble(String.valueOf(precos.get(x)))
                    +total;
        }
        totalCompraAvulsatf.setText(String.valueOf(df.format(total)));
        cdb.closeDB();
        //Fim Calculando o total
        //Obtendo a data
        ResultSet getData;
        getData = cdb.pesquisaDB("select data from CompraAvulsa where numero = "+numeroCompraAvulsa+"");
        while(getData.next()){
            dataCompraAvulsatf.setText(String.valueOf(getData.getObject("data")));
        }
        cdb.closeDB();
        //Fim Obtendo a data
    }

    private void preencherDadosFornecedor(int numeroCompraAvulsa) throws SQLException {
        int numeroRepresentante = 0;
        ResultSet dadosFornecedor;
        cdbF = new ConectaDB();
        dadosFornecedor = cdbF.pesquisaDB("select Fornecedor.numeroFornecedor, Fornecedor.nomeFantasia, \n" +
            "Fornecedor.cnpj, Fornecedor.telefone, Fornecedor.email, Fornecedor.endereco, CompraAvulsa.numeroRepresentante\n" +
            "from Fornecedor, CompraAvulsa where CompraAvulsa.numeroFornecedor = Fornecedor.numeroFornecedor \n" +
            "and CompraAvulsa.numero = "+numeroCompraAvulsa+"");
        
        while(dadosFornecedor.next()){
            numeroRepresentante = Integer.parseInt(String.valueOf(dadosFornecedor.getObject("numeroRepresentante")));
            numeroFornecedortf.setText(String.valueOf(dadosFornecedor.getObject("numeroFornecedor")));
            nomeFantasiatf.setText((String) dadosFornecedor.getObject("nomeFantasia"));
            cnpjtf.setText((String) dadosFornecedor.getObject("cnpj"));
            telefonetf.setText((String) dadosFornecedor.getObject("telefone"));
            emaiFornecedorltf.setText((String) dadosFornecedor.getObject("email"));
            enderecotf.setText((String) dadosFornecedor.getObject("endereco"));
        }
        cdbF.closeDB();
        preencherDadosRepresentante(numeroRepresentante);
    }
    
    private void preencherDadosRepresentante(int numeroRepresentante) throws SQLException{
        
        if(0 != numeroRepresentante){
            ResultSet dadosRepresentante;
            cdbR = new ConectaDB();
            dadosRepresentante = cdbR.pesquisaDB("select numeroRepresentante, nomeRepresentante, telefone, celular, email "
                    + "from Representante where numeroRepresentante = "+numeroRepresentante+"");
            while(dadosRepresentante.next()){
                numeroRepresentantetf.setText(String.valueOf(dadosRepresentante.getObject("numeroRepresentante")));
                nomeRepresentantetf.setText((String) dadosRepresentante.getObject("nomeRepresentante"));
                telefoneRepresentantetf.setText((String) dadosRepresentante.getObject("telefone"));
                celularRepresentantetf.setText((String) dadosRepresentante.getObject("celular"));
                emailtf.setText((String) dadosRepresentante.getObject("email"));
            }
            cdbR.closeDB();
        }
    }

    private void preencheDadosFuncionario(int numeroCompraAvulsa) throws SQLException {
        ResultSet pesquisFuncionario;
        cdbFunc = new ConectaDB();
        pesquisFuncionario = cdbFunc.pesquisaDB("select Funcionario.codigoFuncionario,  Funcionario.nome, Funcionario.cpf, Funcionario.rg from CompraAvulsa, Funcionario \n" +
           "where CompraAvulsa.codigoFuncionario = Funcionario.codigoFuncionario \n" +
           "and CompraAvulsa.numero = "+numeroCompraAvulsa+"");
        while(pesquisFuncionario.next()){
            numeroFuncionariotf.setText((String) pesquisFuncionario.getObject("codigoFuncionario"));
            nomeFuncionariotf.setText((String) pesquisFuncionario.getObject("nome"));
            cpfFuncionariotf.setText((String) pesquisFuncionario.getObject("cpf"));
            rgFuncionariotf.setText((String) pesquisFuncionario.getObject("rg"));
        }
        cdbFunc.closeDB();
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
