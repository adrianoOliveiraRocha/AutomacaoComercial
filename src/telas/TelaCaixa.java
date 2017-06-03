
package telas;

import classes.ConectaDB;
import classes.ContaReceber;
import classes.ItemPedido;
import classes.Pedido;
import classes.Produto;
import classes.Sessao;
import classes.Venda;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.math.RoundingMode;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TelaCaixa extends TelaModelo{
    private Sessao s;
    private Venda v;
    private ItemPedido ip;
    private String codFuncionario;
    private ConectaDB cdb;
    private JPanel PItemVenda;
    private JLabel codBarraslb;
    private JTextField codBarrastf;
    private JLabel descricaolb;
    private JTextField descricaotf;
    private JLabel precolb;
    private JTextField precotf;
    private JLabel quantidadelb;
    private JTextField quantidadetf;
    private JButton registrarItem;
    private JButton fecharVenda;
    private JPanel PTitulo;
    private JLabel titulolb;
    private JLabel totallb;
    private JTextField resultadotf;
    private JLabel dinheirolb;
    private JTextField dinheirotf;
    private JLabel trocolb;
    private JTextField trocotf;
    private double valorInicialDouble;
    private JLabel somenteNumerosquantidadelb;
    private int somenteNumerosQuantidade = 0;
    private double valorParcial = 0;// = quantidade + preço do item
    private JLabel totalVendalb;
    private JTextField totalVendatf;
    DecimalFormat df = new DecimalFormat("#,###.00");/*Serve pra exibir valores formatados*/
    private JLabel descontolb;
    private JTextField descontotf;
    private JButton creditoBtn;
    private JButton fecharSessao;
    private JPanel PVendaCredito;
    private JLabel codClientelb;
    private JTextField codClientetf;
    private JLabel dataVencimentolb;
    private JLabel dialb;
    private JPanel PVendaCreditoCodCliente;
    //private JPanel PVendaCreditoDataVencimento;
    private JTextField diatf;
    private JLabel meslb;
    private JLabel anolb;
    private JTextField anotf;
    private JTextField mestf;
    private JLabel exibiNomelb;
    private JPanel PExibirTotal;
    private JButton cancelaVendaCredito;
    private JButton cadastrarClientePF;
    private int registraSessao;
    private Pedido p;
    private double TotalVenda = 0;
    private double resultadoParcial;
    double total = 0;
    private JButton cadastrarClientePJ;
    private boolean existeCredito = false;
    private JButton confirmar;
    
    int estoque = 0;
    public TelaCaixa(String codigoFuncionario, String valorInicial) throws SQLException{
        /*Esse contrutor é chamado na primeira Venda. É criada uma nova sessão.
        O valor inicial é registrado na sessão.*/
        this.codFuncionario = codigoFuncionario;
        this.valorInicialDouble = Double.parseDouble(valorInicial);
        
        this.setTitle("Caixa");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocation(140, 30);
        this.setExtendedState( MAXIMIZED_BOTH ); 
        this.inicializarComponentes();
        codBarrastf.grabFocus();
        
        criarSessao();
        criarPeidido1();
        this.setVisible(true);
        
    }

    private TelaCaixa(String codFuncionario, int registraSessao) throws SQLException {
        /*Esse construtor é chamado a partir da segunda venda da da sessão. A diferença é que 
        não é criada uma nova Sessão. O número da Sessão já criada é mantido. Temos tudo novo, menos
         a sessão. O comando que aciona esse mátodo é fachar venda. Um novo Pedido é criado, uma nova 
        Venda é criada. Porém, o número da Sessão é o da anterior.*/
        this.registraSessao = registraSessao;
        this.codFuncionario = codFuncionario;
        this.valorInicialDouble = valorInicialDouble;
        
        this.setTitle("Caixa");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocation(140, 30);
        this.setExtendedState( MAXIMIZED_BOTH ); 
        this.inicializarComponentes();
        codBarrastf.grabFocus();
        criarPedido();
        this.setVisible(true);
    }

    private void inicializarComponentes() {
        Font f = new Font("Courier", Font.BOLD, 20);        
        Font f2 = new Font("Courier", Font.BOLD, 40);        
        Font f3 = new Font("Courier", Font.ITALIC, 20);        
        
        PTitulo = new JPanel();
        //PTitulo.setBackground(Color.white);
        PTitulo.setLayout(null);
        PTitulo.setSize(1320, 100);
        PTitulo.setLocation(25, 20);
        this.add(PTitulo);
        
        titulolb = new JLabel("FP Super");
        titulolb.setForeground(Color.blue);
        titulolb.setFont(f2);
        titulolb.setSize(500, 100);
        titulolb.setLocation(440, 5);
        PTitulo.add(titulolb);
        
        PItemVenda = new JPanel();
        //PItemVenda.setBackground(Color.white);
        PItemVenda.setLayout(null);
        PItemVenda.setSize(850, 450);
        PItemVenda.setLocation(25, 150);
        this.add(PItemVenda);
        
        PVendaCredito = new JPanel();
        //PVendaCredito.setBackground(Color.yellow);
        PVendaCredito.setLayout(null);
        PVendaCredito.setSize(430, 450);
        PVendaCredito.setLocation(900, 150);
        this.add(PVendaCredito);
        /*Painel que contém dados do cliente*/
        PVendaCreditoCodCliente = new JPanel();
        PVendaCreditoCodCliente.setVisible(false);
        PVendaCreditoCodCliente.setBackground(Color.white);
        PVendaCreditoCodCliente.setLayout(null);
        PVendaCreditoCodCliente.setSize(430, 300);
        PVendaCreditoCodCliente.setLocation(0, 100);
        PVendaCredito.add(PVendaCreditoCodCliente);
        
        codClientelb = new JLabel("Código do Cliente");
        codClientelb.setFont(f);
        codClientelb.setSize(250, 20);
        codClientelb.setLocation(110, 20);
        PVendaCreditoCodCliente.add(codClientelb);
                
        codClientetf = new JTextField();
        codClientetf.setFont(f);
        codClientetf.setSize(400, 20);
        codClientetf.setLocation(15, 60);
        codClientetf.addKeyListener(new TrataTeclado());
        PVendaCreditoCodCliente.add(codClientetf);
        
        /*Exibi o nome do cliente*/
        exibiNomelb = new JLabel();
        exibiNomelb.setFont(f);
        exibiNomelb.setSize(300, 20);
        exibiNomelb.setLocation(25, 120);
        PVendaCreditoCodCliente.add(exibiNomelb);
                                
        codBarraslb = new JLabel("Código de Barras:");
        codBarraslb.setFont(f);
        codBarraslb.setSize(500, 20);
        codBarraslb.setLocation(25, 20);
        PItemVenda.add(codBarraslb);
        codBarrastf = new JTextField();
        codBarrastf.setFont(f);
        codBarrastf.setSize(400, 20);
        codBarrastf.setLocation(420, 20);
        codBarrastf.addKeyListener(new TrataTeclado());
        PItemVenda.add(codBarrastf);
        
        descricaolb = new JLabel("Descrição:");
        descricaolb.setFont(f);
        descricaolb.setSize(170, 20);
        descricaolb.setLocation(25, 60);
        PItemVenda.add(descricaolb);
        descricaotf = new JTextField();
        descricaotf.setFont(f);
        descricaotf.setEditable(false);
        descricaotf.setSize(400, 30);
        descricaotf.setLocation(420, 60);
        PItemVenda.add(descricaotf);
        
        precolb = new JLabel("Preço:");
        precolb.setFont(f);
        precolb.setSize(170, 20);
        precolb.setLocation(25, 100);
        PItemVenda.add(precolb);
        precotf = new JTextField();
        precotf.setFont(f);
        precotf.setEditable(false);
        precotf.setSize(100, 20);
        precotf.setLocation(420, 100);
        PItemVenda.add(precotf);
        
        quantidadelb = new JLabel("Quantidade:");
        quantidadelb.setFont(f);
        quantidadelb.setSize(170, 20);
        quantidadelb.setLocation(25, 140);
        PItemVenda.add(quantidadelb);
        somenteNumerosquantidadelb = new JLabel("Somente Números");
        somenteNumerosquantidadelb.setFont(f3);
        somenteNumerosquantidadelb.setVisible(false);
        //somenteNumerosquantidadelb.setForeground(Color.red);
        somenteNumerosquantidadelb.setSize(200, 20);
        somenteNumerosquantidadelb.setLocation(630, 140);
        PItemVenda.add(somenteNumerosquantidadelb);
        quantidadetf = new JTextField();
        quantidadetf.setFont(f);
        quantidadetf.setSize(100, 20);
        quantidadetf.setLocation(420, 140);
        quantidadetf.addKeyListener(new TrataTeclado());
        PItemVenda.add(quantidadetf);
        
        totallb = new JLabel("Total Parcial:");
        totallb.setFont(f);
        totallb.setSize(350, 20);
        //totallb.setBackground(Color.red);
        totallb.setLocation(25, 180);
        PItemVenda.add(totallb);
        resultadotf = new JTextField();
        resultadotf.setEditable(false);
        resultadotf.setFont(f);
        resultadotf.setSize(100, 20);
        resultadotf.setLocation(420, 180);
        PItemVenda.add(resultadotf);
        /*Esse painel exibi o total da venda*/
        PExibirTotal = new JPanel();
        //PExibirTotal.setBackground(Color.red);
        PExibirTotal.setLayout(null);
        PExibirTotal.setSize(430, 200);
        PExibirTotal.setLocation(0, 70);
        PVendaCredito.add(PExibirTotal);
        
        totalVendalb = new JLabel("Total R$");
        totalVendalb.setForeground(Color.blue);
        totalVendalb.setFont(f2);
        totalVendalb.setSize(350, 50);
        totalVendalb.setLocation(100, 30);
        PExibirTotal.add(totalVendalb);
        totalVendatf = new JTextField();
        totalVendatf.setForeground(Color.blue);
        totalVendatf.setEditable(false);
        totalVendatf.setFont(f2);
        totalVendatf.setSize(200, 50);
        totalVendatf.setLocation(100, 100);
        PExibirTotal.add(totalVendatf);
        
        descontolb = new JLabel("Desconto sobre a venda:");
        descontolb.setFont(f);
        descontolb.setSize(350, 20);
        descontolb.setLocation(25, 220);
        PItemVenda.add(descontolb);
        descontotf = new JTextField();
        descontotf.setToolTipText("Percentual");
        descontotf.setFont(f);
        descontotf.setSize(100, 20);
        descontotf.setLocation(420, 220);
        descontotf.addKeyListener(new TrataTeclado());
        PItemVenda.add(descontotf);
        
        dinheirolb = new JLabel("Dinherio:");
        dinheirolb.setFont(f);
        dinheirolb.setSize(170, 20);
        dinheirolb.setBackground(Color.red);
        dinheirolb.setLocation(25, 260);
        PItemVenda.add(dinheirolb);
        dinheirotf = new JTextField();
        dinheirotf.setFont(f);
        dinheirotf.setSize(100, 20);
        dinheirotf.setLocation(420, 260);
        dinheirotf.addKeyListener(new TrataTeclado());
        PItemVenda.add(dinheirotf);
        
        trocolb = new JLabel("Troco:");
        trocolb.setFont(f);
        trocolb.setSize(170, 20);
        trocolb.setBackground(Color.red);
        trocolb.setLocation(25, 300);
        PItemVenda.add(trocolb);
        trocotf = new JTextField();
        trocotf.setEditable(false);
        trocotf.setFont(f);
        trocotf.setSize(100, 20);
        trocotf.setLocation(420, 300);
        PItemVenda.add(trocotf);
        
        registrarItem = new JButton("F1 Registrar Item");
        registrarItem.setToolTipText("Pressiona F1 para registrar item");
        registrarItem.setSize(170, 35);
        registrarItem.setLocation(50, 400);
        registrarItem.addActionListener(new TrataBotoes());
        PItemVenda.add(registrarItem);
        
        fecharVenda = new JButton("F2 Fechar Venda");
        fecharVenda.setToolTipText("Pressiona F2 para Fechar Venda");
        fecharVenda.setSize(170, 35);
        fecharVenda.setLocation(250, 400);
        fecharVenda.addActionListener(new TrataBotoes());
        PItemVenda.add(fecharVenda);
        
        creditoBtn = new JButton("F3 Crédito");
        creditoBtn.setToolTipText("Pressiona F3 para Fechar Venda");
        creditoBtn.setSize(170, 35);
        creditoBtn.setLocation(450, 400);
        creditoBtn.addActionListener(new TrataBotoes());
        PItemVenda.add(creditoBtn);
        
        fecharSessao = new JButton("F4 Fechar Sessão");
        fecharSessao.setToolTipText("Pressiona F4 para Fechar Venda");
        fecharSessao.setToolTipText("Click em F4 para fechar a sessão");
        fecharSessao.setSize(170, 35);
        fecharSessao.setLocation(650, 400);
        fecharSessao.addActionListener(new TrataBotoes());
        PItemVenda.add(fecharSessao);
        
        cancelaVendaCredito  = new JButton("Cancelar Crérito");
        cancelaVendaCredito.setSize(170, 20);
        cancelaVendaCredito.setLocation(15, 170);
        cancelaVendaCredito.setVisible(true);
        cancelaVendaCredito.addActionListener(new TrataBotoes());
        PVendaCreditoCodCliente.add(cancelaVendaCredito);
        
        confirmar  = new JButton("Confirmar");
        confirmar.setSize(170, 20);
        confirmar.setLocation(240, 170);
        confirmar.setVisible(true);
        confirmar.addActionListener(new TrataBotoes());
        PVendaCreditoCodCliente.add(confirmar);
        
        cadastrarClientePF  = new JButton("Cadastrar Cliente Pessoa Física");
        cadastrarClientePF.setSize(300, 20);
        cadastrarClientePF.setLocation(60, 210);
        cadastrarClientePF.setVisible(true);
        cadastrarClientePF.addActionListener(new TrataBotoes());
        PVendaCreditoCodCliente.add(cadastrarClientePF);
        
        cadastrarClientePJ  = new JButton("Cadastrar Cliente Pessoa Jurídica");
        cadastrarClientePJ.setSize(300, 20);
        cadastrarClientePJ.setLocation(60, 250);
        cadastrarClientePJ.setVisible(true);
        cadastrarClientePJ.addActionListener(new TrataBotoes());
        PVendaCreditoCodCliente.add(cadastrarClientePJ);
        
    }

    private void criarSessao() throws SQLException {
        s = new Sessao();
        s.setNumero();
        this.registraSessao = s.getNumero();
        s.setData();
        s.setCodigoFuncionario(codFuncionario);
        s.setValorTotal(valorInicialDouble);
        s.setHoraInicio();
        s.registrarSessao();
        registraSessao = s.getNumero();
    }
    
    public void criarPeidido1() throws SQLException{
        p = new Pedido();//setData e setHora são chamados automaticamente
        p.setNumero();
        p.setTipo(1);
        p.setData();
        p.setValorTotal(0);
        p.setDesconto(0);
        p.setCodFuncionario(codFuncionario);
        p.setNumeroSessao(s.getNumero());
        p.registrarPedido();
        criarVenda();
    }
    
    public void criarPedido() throws SQLException{
        p = new Pedido();//setData e setHora são chamados automaticamente
        p.setNumero();
        p.setTipo(1);
        p.setData();
        p.setValorTotal(0);
        p.setDesconto(0);
        p.setCodFuncionario(codFuncionario);
        p.setNumeroSessao(registraSessao);
        p.registrarPedido();
        criarVenda();
    }
    
    public void criarVenda(){
        v = new Venda();
        v.setNumeroVenda(p.getNumero());
        v.setNumeroCliente(0);
        v.setData();
        v.setData(p.getData());
        v.registrarVenda();
    }
    
    public class TrataTeclado extends KeyAdapter{
        
        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getSource().equals(codBarrastf)){
                limpar();
                try {
                    pesquisaProduto(codBarrastf.getText());
                } catch (SQLException ex) {
                    Logger.getLogger(TelaCaixa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(e.getSource().equals(quantidadetf)){
                if(!Pedido.somenteNumeros(quantidadetf.getText())){
                    somenteNumerosquantidadelb.setVisible(true);
                }
                if(!"".equals(quantidadetf.getText())){
                   int quantidade = Integer.parseInt(quantidadetf.getText());
                   resultadoParcial = Double.parseDouble(precotf.getText()) * quantidade;
                   resultadotf.setText(String.valueOf(df.format(resultadoParcial)));
                }
            }else if(e.getSource().equals(descontotf)){
                double desconto = 0;//O desconto começa sempre em zero
                if("".equals(descontotf.getText())){/*descontotf está vazio. então o desconto é zero*/
                    try {
                        exibiValorDescontado(0);
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaCaixa.class.getName()).log(Level.SEVERE, null, ex);//captura o erro
                    }
                }
                
                try{
                   desconto = Double.parseDouble(descontotf.getText().replace(',', '.'));//trtando as vírgulas
                   exibiValorDescontado(desconto/100);
                }catch(NumberFormatException n){
                   //Captura o erro mas não faz nada
                } catch (SQLException ex) {
                   Logger.getLogger(TelaCaixa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(e.getSource().equals(codClientetf)){
                try {
                    pesquisaCliente();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaCaixa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(e.getSource().equals(dinheirotf)){
                String dinheiroS = dinheirotf.getText();
                dinheiroS = dinheiroS.replace(",", ".");
                double dinheiro = 0;
                try{
                    dinheiro = Double.parseDouble(dinheiroS);
                }catch(NumberFormatException nfe){
                    JOptionPane.showMessageDialog(rootPane, "O Campo dinheiro só aceita números!");
                }
                try {
                    calcularTotal();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaCaixa.class.getName()).log(Level.SEVERE, null, ex);
                }
                double troco = dinheiro - total;
                trocotf.setText(df.format(troco));
            }
        }

        private void pesquisaProduto(String codBarras) throws SQLException {
            estoque = 0;
            cdb = new ConectaDB();
            ResultSet pesquisaProduto;
            String pesquisaProdutoS = "select * from Produto where codBarras = '"+codBarras+"'";
            pesquisaProduto = cdb.pesquisaDB(pesquisaProdutoS);
            while(pesquisaProduto.next()){
                estoque = Integer.parseInt(String.valueOf(pesquisaProduto.getObject("estoque")));
                descricaotf.setText((String) pesquisaProduto.getObject("descricao"));
                precotf.setText(String.valueOf(pesquisaProduto.getObject("precoVenda")));
                quantidadetf.grabFocus();
            }
        }

        private void exibiValorDescontado(double desconto) throws SQLException {
            calcularTotal();
            double totalDescontado = total -(desconto * total);
            totalVendatf.setText(df.format(totalDescontado));
        }

        private void pesquisaCliente() throws SQLException {
            int codCliente = 0; boolean clienteExiste = false;
            exibiNomelb.setText("");
                if(!"".equals(codClientetf.getText())){//Se for vazio não faz nada
                    try{
                        codCliente = Integer.parseInt(codClientetf.getText());
                    }catch(NumberFormatException nfe){
                        JOptionPane.showMessageDialog(null, "Somente números!");
                    }
                    String pesquisaCliente = "select nome from Cliente where numeroCliente = "+codCliente+"";
                    ResultSet pesquisaClienteRS; 
                    ConectaDB pesquisaClienteCDB = new ConectaDB(); 
                    pesquisaClienteRS = pesquisaClienteCDB.pesquisaDB(pesquisaCliente);
                    while(pesquisaClienteRS.next()){
                        clienteExiste = true;
                        exibiNomelb.setText((String)pesquisaClienteRS.getObject("nome"));
                    }
                if(clienteExiste == false){
                    exibiNomelb.setText("Cliente não cadastrado");
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Cliente existe. Vamos registrar");
                }
            }
        }
    }
    
    public class TrataBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            /*Fechar Venda*/
            if(e.getSource().equals(fecharVenda)){
                try {
                    fecharVenda();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaCaixa.class.getName()).log(Level.SEVERE, null, ex);
                }
                dispose();
                try {
                    new TelaCaixa(codFuncionario, registraSessao);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaCaixa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(e.getSource().equals(fecharSessao)){
                try {
                    fecharSessao();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaCaixa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(e.getSource().equals(registrarItem)){
                registrarItem();
            }
            else if(e.getSource().equals(creditoBtn)){
                credito();
            }
            else if(e.getSource().equals(cancelaVendaCredito)){
                cancelarCredito();
            }
            else if(e.getSource().equals(cadastrarClientePF)){
                try {
                    abrirTelaCadastroDeClientePF();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaCaixa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(e.getSource().equals(cadastrarClientePJ)){
                try {
                    abrirTelaCadastroDeClientePJ();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaCaixa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(e.getSource().equals(confirmar)){
                try {
                    registrarClienteNaVenda();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaCaixa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        private void apagarVenda(int numero) {
            String apagaVenda = "delete from Venda where numero = "+numero+"";
            String apagaPedido = "delete from Pedido where numero = "+numero+"";
            cdb = new ConectaDB();
            if(cdb.cadastro(apagaVenda)){
                if(cdb.cadastro(apagaPedido)){
                    
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Problemas ao apagar o Pedido");
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Problemas ao apagar a Venda");
            }
        }

        private void valorTotalDaSessao() throws SQLException {
            /*Verificar se o Pedido atual tem ítens. Se não, apaga*/
            if(!existeItem(p.getNumero())){
                apagarVenda(p.getNumero());
            }
            //Obter valor total da sessão
            JOptionPane.showMessageDialog(null, "valorTotalDaSessao()");
            String totaisPedidos = "select Pedido.valorTotal from Pedido "
                    + "where Pedido.numeroSessao = "+registraSessao+"";
            ArrayList<Double> totais = new ArrayList<Double>();
            ResultSet pesquisaTotais;
            ConectaDB cdbPesquisaTotais = new ConectaDB();
            pesquisaTotais = cdbPesquisaTotais.pesquisaDB(totaisPedidos);
            while(pesquisaTotais.next()){
                totais.add(Double.parseDouble(String.valueOf(pesquisaTotais.getObject("valorTotal"))));
            }
            double totalSessao = 0;
            for(int cont = 0; cont < totais.size(); cont++){
                totalSessao = totais.get(cont) + totalSessao;
            }
            //Obter valor inicial da sessão
            String valorInicial = "select valorTotal from Sessao where numero = "+registraSessao+"";
            ResultSet pesquisaValorInicial;
            ConectaDB pesquisaValorInicialCDB = new ConectaDB(); 
            pesquisaValorInicial = pesquisaValorInicialCDB.pesquisaDB(valorInicial);
            double valorInicialDouble = 0;
            while(pesquisaValorInicial.next()){
                valorInicialDouble = Double.parseDouble(String.valueOf(pesquisaValorInicial.getObject("valorTotal")));
            }
            totalSessao = totalSessao + valorInicialDouble;
            //Obter hora do sistema
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");   
            String horaFim = String.valueOf(dateFormat.format( new java.util.Date() ));
            //Atualizar Sessão 
            String updateSessao = "update Sessao set valorTotal = "+totalSessao+", horaFim = '"+horaFim+"' "
                    + "where numero = "+registraSessao+"";
            ConectaDB updateCDB = new ConectaDB();
            if(updateCDB.cadastro(updateSessao)){
                JOptionPane.showMessageDialog(null, "Sessão Finalizada com Sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Problemas ao fincaliza a Sessão!");
            }
            dispose();
            pesquisaEstoqueEmBaixa();
        }
        
        private void fecharVenda() throws SQLException {
            /*Testar se existem ítens desse pedido*/
            if(existeItem(p.getNumero())){/*Verifica se existem ítens nesse pedido*/
                calcularTotal();
                if("".equals(descontotf.getText())){//Sem desconto
                    String atualizaValorS = "update Pedido set valorTotal = "+total+" "
                        + "where numero = "+p.getNumero()+" and data = '"+p.getData()+"'";
                    cdb.cadastro(atualizaValorS);
                }else{//Com desconto
                    double desconto = (Double.parseDouble(descontotf.getText())/100) * total;
                    double totalDescontado = total - desconto;
                    String atualizaValorSComDesconto = "update Pedido set valorTotal = "+totalDescontado+", desconto = "+desconto+" "
                        + "where numero = "+p.getNumero()+" and data = '"+p.getData()+"'";
                    cdb.cadastro(atualizaValorSComDesconto);
                } 
                atualizarEstoque(p.getNumero(), p.getData());
            }else{
                apagarVenda(p.getNumero());
            }
        }

        private void registrarItem() {
            /*Tem que existir um produto encontrado no BD*/
                if(!"".equals(descricaotf.getText()) && !"".equals(quantidadetf.getText())){//Dados ok!
                    if(Integer.parseInt(quantidadetf.getText())  > estoque){
                        JOptionPane.showMessageDialog(rootPane, "Hà apenas "+estoque+" unidade(s) desse produto no estoque");
                    }else{
                        ip = null;
                        ip = new ItemPedido();
                        try {
                            ip.setNumero();
                            ip.setNumeroPedido(p.getNumero());
                        } catch (SQLException ex) {
                            Logger.getLogger(TelaCaixa.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        ip.setCodBarras(codBarrastf.getText());
                        ip.setDataPedido(p.getData());
                        ip.setQuantidade(Integer.parseInt(quantidadetf.getText()));
                        ip.registrarItem();
                        TotalVenda = resultadoParcial + TotalVenda;
                        totalVendatf.setText(df.format(TotalVenda));
                        codBarrastf.setText("");
                        limpar();
                    }
                }
        }

        private void fecharSessao() throws SQLException {
            valorTotalDaSessao();
        }

        private boolean existeItem(int numeroPedido) throws SQLException {
            boolean existe = false;
            String pesquisaItensS = "select * from ItemPedido "
                    + "where numeroPedido = "+numeroPedido+"";
            ResultSet pesquisaItensRS;
            ConectaDB pesquisaItensCDB = new ConectaDB();
            pesquisaItensRS = pesquisaItensCDB.pesquisaDB(pesquisaItensS);
            while(pesquisaItensRS.next()){
                existe = true;
            }
            return existe;
        }

        private void credito() {
            existeCredito = true;
            PExibirTotal.setVisible(false);
            PVendaCreditoCodCliente.setVisible(true);
            codClientetf.grabFocus();
        }

        private void cancelarCredito() {
            existeCredito = false;
            PExibirTotal.setVisible(true);
            PVendaCreditoCodCliente.setVisible(false);
        }

        private void abrirTelaCadastroDeClientePF() throws SQLException {
            new TelaCadastroClientePF();
        }

        private void abrirTelaCadastroDeClientePJ() throws SQLException {
            new TelaCadastroClientePJ();
        }

        private void registrarClienteNaVenda() throws SQLException {
            String registraCliente = "update Venda set numeroCliente = "+Integer.parseInt(codClientetf.getText())+" "
                    + "where Venda.numero = "+p.getNumero()+"";
            ConectaDB registraClienteCDB = new ConectaDB();
            JOptionPane.showMessageDialog(null, registraCliente);
            if(!registraClienteCDB.cadastro(registraCliente)){
                JOptionPane.showMessageDialog(null, "Problemas ao registrar cliente!");
            }else{
                gerarContaReceber();
                JOptionPane.showMessageDialog(rootPane, "Conta a receber registrada!");
                PExibirTotal.setVisible(true);
                PVendaCreditoCodCliente.setVisible(false);
            }
        }

        private void gerarContaReceber() throws SQLException {
            ContaReceber cr = new ContaReceber();
            cr.setNumero();
            cr.setNumeroVenda(p.getNumero());
            cr.setDataVenda(p.getData());
            cr.registrar();
        }

        private void atualizarEstoque(int numeroPedido, Date dataPedido) throws SQLException {
            /*Pesquisa estoque atual e quantidade que saiu do estoque*/
            String pesquisaS = "select Produto.codBarras, Produto.estoque, ItemPedido.quantidade \n" +
            "from Produto, ItemPedido, Pedido \n" +
            "where ItemPedido.codBarras = Produto.codBarras\n" +
            "and Pedido.numero = "+numeroPedido+"\n" +
            "and Pedido.`data` = '"+dataPedido+"'\n" +
            "and Pedido.numero = ItemPedido.numeroPedido";
            ResultSet pesquisaRS;
            ConectaDB pesquisaCDB = new ConectaDB();
            pesquisaRS = pesquisaCDB.pesquisaDB(pesquisaS);
            
            while(pesquisaRS.next()){
                String codBarras = (String) pesquisaRS.getObject("codBarras");
                int estoque = Integer.parseInt(String.valueOf(pesquisaRS.getObject("estoque")));
                int saiuDoEstoque = Integer.parseInt(String.valueOf(pesquisaRS.getObject("quantidade")));
                int atualiza = estoque - saiuDoEstoque;
                String atualizaS = "update Produto set estoque = "+atualiza+" where Produto.codBarras = '"+codBarras+"'";
                ConectaDB atualizaCDB = new ConectaDB();
                
                if(!atualizaCDB.cadastro(atualizaS)){
                    JOptionPane.showMessageDialog(null, "Problemas ao atualizar estoque. Entre em contato com o desenvolvedor.");
                }
            }
        }

        private void pesquisaEstoqueEmBaixa() throws SQLException {
            boolean existe = false;
            String pesquisa = "select codBarras from Produto where estoque < estoqueMin";
            ResultSet pesquisaRS;
            ConectaDB pesquisaCDB = new ConectaDB();
            pesquisaRS = pesquisaCDB.pesquisaDB(pesquisa);
            while(pesquisaRS.next()){
                existe = true;
            }
            if(existe == true){
                new ListaProdutosEstoqueEmBaixa();
            }
        }
    }
    private void limpar() {
        descricaotf.setText("");
        quantidadetf.setText("");
        precotf.setText("");
        resultadotf.setText("");
        codBarrastf.grabFocus();
    }
     private void calcularTotal() throws SQLException {
            String selecinaItensS = "select ItemPedido.quantidade, Produto.precoVenda \n" +
                "from ItemPedido, Pedido, Produto\n" +
                "where ItemPedido.numeroPedido = "+ip.getNumeroPedido()+"\n" +
                "and Pedido.`data` = '"+ip.getDataPedido()+"'\n" +
                "and ItemPedido.codBarras = Produto.codBarras\n" +
                "and ItemPedido.numeroPedido = Pedido.numero";
            ArrayList<Integer> quantidades = new ArrayList<Integer>();
            ArrayList<Double> precos = new ArrayList<Double>();
            ResultSet selecinaItensRS;
            cdb = new ConectaDB(); JOptionPane.showMessageDialog(null, "calcularTotal()");
            selecinaItensRS = cdb.pesquisaDB(selecinaItensS);
            while(selecinaItensRS.next()){
                quantidades.add(Integer.parseInt(String.valueOf(selecinaItensRS.getObject("quantidade"))));
                precos.add(Double.parseDouble(String.valueOf(selecinaItensRS.getObject("precoVenda"))));
            }
            total = 0;
            for(int cont = 0; cont < quantidades.size(); cont++){
                total = quantidades.get(cont) * precos.get(cont) + total;
            }
    }
}
