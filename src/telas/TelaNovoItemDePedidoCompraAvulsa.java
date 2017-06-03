
package telas;

import classes.ConectaDB;
import classes.ItemPedidoCompraAvulsa;
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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaNovoItemDePedidoCompraAvulsa extends TelaModelo{
    private JPanel PBotoes;
    private JPanel PPrincipal;
    private JLabel codBarraslb;
    private JTextField codBarrastf;
    private JLabel somenteNumeroscodBarraslb;
    private final ConectaDB cdb;
    private JLabel descricaolb;
    private JTextField descricaotf;
    private JLabel quantidadeEstoquelb;
    private JTextField quantidadeEstoquetf;
    private JLabel marcalb;
    private JTextField marcatf;
    private JLabel quantidadelb;
    private JTextField quantidadetf;
    private JLabel somenteNumerosquantidadelb;
    private JLabel precoCustolb;
    private JTextField precoCustotf;
    private JButton inserirItemPedido;
    private JButton cadastrarProduto;
    private int numeroCompraAvulsa;
    private Date dataCompraAvulsa;
    private JButton finalizar;
    private JLabel totallb;
    private JLabel totaltf;
    private double total = 0;
    public TelaNovoItemDePedidoCompraAvulsa(int numero, Date data){
        numeroCompraAvulsa = numero;
        dataCompraAvulsa = data;
        cdb = new ConectaDB();
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Item de Pedido");
        this.setSize(800, 300);
        this.setLocation(140, 50);
        inicializarComponentes();
        this.setVisible(true);
    }

    private void inicializarComponentes() {
                
        PPrincipal = new JPanel();
        PPrincipal.setLayout(null);
        //PPrincipal.setBackground(Color.yellow);
        PPrincipal.setSize(750, 200);
        PPrincipal.setLocation(25, 0);
        this.add(PPrincipal);

        PBotoes = new JPanel();
        PBotoes.setLayout(null);
        //PBotoes.setBackground(Color.yellow);
        PBotoes.setSize(750, 40);
        PBotoes.setLocation(25, 210);
        this.add(PBotoes);
        
        codBarraslb = new JLabel("Código de Barras");
        codBarraslb.setSize(150, 20);
        codBarraslb.setLocation(40, 20);
        PPrincipal.add(codBarraslb);
        somenteNumeroscodBarraslb = new JLabel("Somente Números");
        somenteNumeroscodBarraslb.setForeground(Color.red);
        somenteNumeroscodBarraslb.setVisible(false);
        somenteNumeroscodBarraslb.setSize(150, 20);
        somenteNumeroscodBarraslb.setLocation(550, 20);
        PPrincipal.add(somenteNumeroscodBarraslb);
        codBarrastf = new JTextField();
        codBarrastf.setToolTipText("Código de barras do produto");
        codBarrastf.setSize(300, 20);
        codBarrastf.setLocation(220, 20);
        codBarrastf.addKeyListener(new trataTeclado());
        PPrincipal.add(codBarrastf);
        
        descricaolb = new JLabel("Descrição:");
        descricaolb.setSize(150, 20);
        descricaolb.setLocation(40, 50);
        PPrincipal.add(descricaolb);
        descricaotf = new JTextField();
        descricaotf.setEditable(false);
        descricaotf.setSize(300, 20);
        descricaotf.setLocation(220, 50);
        PPrincipal.add(descricaotf);
        
        marcalb = new JLabel("Marca:");
        marcalb.setSize(150, 20);
        marcalb.setLocation(40, 80);
        PPrincipal.add(marcalb);
        marcatf = new JTextField();
        marcatf.setEditable(false);
        marcatf.setSize(300, 20);
        marcatf.setLocation(220, 80);
        PPrincipal.add(marcatf);
        
        quantidadeEstoquelb = new JLabel("Em Estoque:");
        quantidadeEstoquelb.setSize(150, 20);
        quantidadeEstoquelb.setLocation(40, 110);
        PPrincipal.add(quantidadeEstoquelb);
        quantidadeEstoquetf = new JTextField();
        quantidadeEstoquetf.setEditable(false);
        quantidadeEstoquetf.setSize(40, 20);
        quantidadeEstoquetf.setLocation(220, 110);
        PPrincipal.add(quantidadeEstoquetf);
        
        precoCustolb = new JLabel("Preço de Custo R$:");
        precoCustolb.setSize(150, 20);
        precoCustolb.setLocation(290, 110);
        PPrincipal.add(precoCustolb);
        precoCustotf = new JTextField();
        precoCustotf.setEditable(false);
        precoCustotf.setSize(70, 20);
        precoCustotf.setLocation(450, 110);
        PPrincipal.add(precoCustotf);
        
        quantidadelb = new JLabel("Quantidade:");
        quantidadelb.setSize(150, 20);
        quantidadelb.setLocation(40, 140);
        PPrincipal.add(quantidadelb);
        somenteNumerosquantidadelb = new JLabel("Somente Números");
        somenteNumerosquantidadelb.setForeground(Color.red);
        somenteNumerosquantidadelb.setVisible(false);
        somenteNumerosquantidadelb.setSize(150, 20);
        somenteNumerosquantidadelb.setLocation(290, 140);
        PPrincipal.add(somenteNumerosquantidadelb);
        quantidadetf = new JTextField();
        quantidadetf.setSize(40, 20);
        quantidadetf.setLocation(220, 140);
        quantidadetf.addKeyListener(new trataTeclado());
        PPrincipal.add(quantidadetf);
        
        totallb = new JLabel("Total:");
        totallb.setSize(150, 20);
        totallb.setLocation(40, 170);
        PPrincipal.add(totallb);
        totaltf = new JLabel("0");
        totaltf.setSize(70, 20);
        totaltf.setLocation(220, 170);
        PPrincipal.add(totaltf);
        
        inserirItemPedido = new JButton("Inserir");
        inserirItemPedido.setSize(130, 20);
        inserirItemPedido.setLocation(90, 10);
        inserirItemPedido.setVisible(true);
        inserirItemPedido.addActionListener(new trataBotao());
        PBotoes.add(inserirItemPedido);
        
        cadastrarProduto = new JButton("Cadastrar");
        cadastrarProduto.setSize(130, 20);
        cadastrarProduto.setLocation(310, 10);
        cadastrarProduto.setVisible(true);
        cadastrarProduto.addActionListener(new trataBotao());
        PBotoes.add(cadastrarProduto);
        
        finalizar = new JButton("Finalizar");
        finalizar.setSize(130, 20);
        finalizar.setLocation(530, 10);
        finalizar.setVisible(true);
        finalizar.addActionListener(new trataBotao());
        PBotoes.add(finalizar);
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
            if(e.getSource().equals(codBarrastf)){
                somenteNumeroscodBarraslb.setVisible(false);
                somenteNumerosquantidadelb.setVisible(false);
                quantidadetf.setText("");
                descricaotf.setText("");
                quantidadeEstoquetf.setText("");
                marcatf.setText("");
                precoCustotf.setText("");
                if(!"".equals(codBarrastf.getText())){
                    if(!ItemPedidoCompraAvulsa.somenteNumeros(codBarrastf.getText())){
                    somenteNumeroscodBarraslb.setForeground(Color.red);
                    somenteNumeroscodBarraslb.setText("Somente Números");
                    somenteNumeroscodBarraslb.setVisible(true);
                }else{
                    somenteNumeroscodBarraslb.setForeground(Color.red);
                    somenteNumeroscodBarraslb.setText("Não Encontrado");
                    somenteNumeroscodBarraslb.setVisible(true);
                    ResultSet r;
                    String query = "select * from Produto "
                            + "where codBarras = "+codBarrastf.getText()+"";
                    try{
                        r = cdb.pesquisaDB(query);
                        while(r.next()){
                            somenteNumeroscodBarraslb.setForeground(Color.blue);
                            somenteNumeroscodBarraslb.setText("Encontrado");
                            descricaotf.setText((String) r.getObject(2));
                            quantidadeEstoquetf.setText(String.valueOf(r.getObject(4)));
                            marcatf.setText(String.valueOf(r.getObject(3)));
                            precoCustotf.setText(String.valueOf(r.getObject(6)));
                            quantidadetf.grabFocus();
                        }
                    }catch(SQLException ex){
                        JOptionPane.showMessageDialog(rootPane, "Erro! "+ex.getCause()
                        +"\n"+ex.getMessage());
                    }
                }
                }
            }else if(e.getSource().equals(quantidadetf)){
                somenteNumerosquantidadelb.setVisible(false);
                somenteNumerosquantidadelb.setForeground(Color.red);
                somenteNumerosquantidadelb.setText("Somente Números");
                if(!"".equals(quantidadetf.getText())){
                    if(!ItemPedidoCompraAvulsa.somenteNumeros(quantidadetf.getText())){
                        somenteNumerosquantidadelb.setVisible(true);
                    }else{
                        int quantidade = Integer.parseInt(quantidadetf.getText());
                        double precoCusto = Double.parseDouble(precoCustotf.getText());
                        double total = quantidade * precoCusto;
                        somenteNumerosquantidadelb.setForeground(Color.blue);
                        somenteNumerosquantidadelb.setText("R$"+String.valueOf(total));
                        somenteNumerosquantidadelb.setVisible(true);
                    }
                }
            }
        }
        
    }
    
    public class trataBotao implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            /*inserirItemPedido*/
            if(e.getSource().equals(inserirItemPedido)){
                /*Dados não informados corretamente*/
                if("".equals(codBarrastf.getText()) ||
                        "".equals(quantidadetf.getText()) ||
                        "".equals(precoCustotf.getAccessibleContext())){
                    JOptionPane.showMessageDialog(precoCustolb, "Prencha todos os campos corretamente!");
                }
                /*Dados informados corretamente*/
                else{
                    try {
                    criarNovo();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaNovoItemDePedidoCompraAvulsa.class.getName()).log(Level.SEVERE, null, ex);
                }
                    somenteNumeroscodBarraslb.setForeground(Color.red);
                    somenteNumeroscodBarraslb.setVisible(false);
                }
                
            }
            /*Fim inserirItemPedido*/
            else if(e.getSource().equals(cadastrarProduto)){
                new TelaCadastroProduto();
            }
            
            else if(e.getSource().equals(finalizar)){
                dispose();
            }
        }

        private void criarNovo() throws SQLException {
            ItemPedidoCompraAvulsa ipcv = new ItemPedidoCompraAvulsa();
                try {
                    ipcv.setNumero();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaNovoItemDePedidoCompraAvulsa.class.getName()).log(Level.SEVERE, null, ex);
                }
                ipcv.setData(dataCompraAvulsa);
                ipcv.setNumeroCompraAvulsa(numeroCompraAvulsa);
                ipcv.setCodBarras(codBarrastf.getText());
                ipcv.setQuantidade(Integer.parseInt(quantidadetf.getText()));
                ipcv.setPrecoUnitario(Double.parseDouble(precoCustotf.getText()));
                ipcv.inserir();
                limpar();
                double totalParcial = ipcv.getQuantidade() * ipcv.getPrecoUnitario();
                total = total + totalParcial;
                totaltf.setText(String.valueOf(total));
        }

        private void limpar() {
            codBarrastf.setText("");
            codBarrastf.grabFocus();/*Foco no cdBarras*/
            descricaotf.setText("");
            marcatf.setText("");
            quantidadetf.setText("");
            quantidadeEstoquetf.setText("");
            somenteNumerosquantidadelb.setForeground(Color.red);
            somenteNumerosquantidadelb.setText("Somente Números");
            somenteNumerosquantidadelb.setVisible(false);
            precoCustotf.setText("");
        }

    }
    
}
