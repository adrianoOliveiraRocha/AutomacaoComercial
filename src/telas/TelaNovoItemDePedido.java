
package telas;

import classes.ItemPedido;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaNovoItemDePedido extends TelaModelo{
    private JPanel PBotoes;
    private JPanel PPrincipal;
    private JLabel numerolb;
    private JTextField numerotf;
    private JLabel datalb;
    private JTextField datatf;
    private JLabel numeroCompralb;
    private JTextField numeroCompratf;
    private ItemPedido i;
    private JLabel cdoBarraslb;
    private JTextField cdoBarrastf;
    private JLabel quantidadelb;
    private JTextField quantidadetf;
    private JLabel somenteNumerosquantidadelb;
    private JLabel precoUnitariolb;
    private JTextField precoUnitariotf;
    public TelaNovoItemDePedido(String numeroPedido, String dataPedido) throws SQLException{
        i = new ItemPedido();
        i.setNumero();
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Item de Pedido");
        this.setSize(800, 610);
        this.setLocation(140, 50);
        inicializarComponentes(numeroPedido, dataPedido);
        cdoBarrastf.grabFocus();
        this.setVisible(true);
    }

  
    private void inicializarComponentes(String numeroPedido, String dataPedido) {
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
        
        numerolb = new JLabel("Número do Item");
        numerolb.setSize(150, 20);
        numerolb.setLocation(40, 20);
        PPrincipal.add(numerolb);
        numerotf = new JTextField(String.valueOf(i.getNumero()));
        numerotf.setEditable(false);
        numerotf.setToolTipText("Gerado pelo Sistema");
        numerotf.setSize(300, 20);
        numerotf.setLocation(220, 20);
        PPrincipal.add(numerotf);
        
        numeroCompralb = new JLabel("Número da Compra");
        numeroCompralb.setSize(150, 20);
        numeroCompralb.setLocation(40, 50);
        PPrincipal.add(numeroCompralb);
        numeroCompratf = new JTextField(numeroPedido);
        numeroCompratf.setEditable(false);
        numeroCompratf.setToolTipText("Gerado pelo Sistema");
        numeroCompratf.setSize(300, 20);
        numeroCompratf.setLocation(220, 50);
        PPrincipal.add(numeroCompratf);
        
        datalb = new JLabel("Data da Compra:");
        datalb.setSize(150, 20);
        datalb.setLocation(40, 80);
        PPrincipal.add(datalb);
        datatf = new JTextField();
        datatf.setText(dataPedido);
        datatf.setEditable(false);
        datatf.setToolTipText("Data do Sistema");
        datatf.setSize(300, 20);
        datatf.setLocation(220, 80);
        PPrincipal.add(datatf);
        
        cdoBarraslb = new JLabel("Código de Barras:");
        cdoBarraslb.setSize(150, 20);
        cdoBarraslb.setLocation(40, 110);
        PPrincipal.add(cdoBarraslb);
        cdoBarrastf = new JTextField();
        cdoBarrastf.setToolTipText("Digite o código de barras do produto");
        cdoBarrastf.setSize(300, 20);
        cdoBarrastf.setLocation(220, 110);
        PPrincipal.add(cdoBarrastf);
        
        quantidadelb = new JLabel("Quantidade:");
        quantidadelb.setSize(150, 20);
        quantidadelb.setLocation(40, 140);
        PPrincipal.add(quantidadelb);
        
        somenteNumerosquantidadelb = new JLabel("Somente Números");
        somenteNumerosquantidadelb.setForeground(Color.red);
        somenteNumerosquantidadelb.setVisible(false);
        somenteNumerosquantidadelb.setSize(200, 20);
        somenteNumerosquantidadelb.setLocation(570, 140);
        PPrincipal.add(somenteNumerosquantidadelb);
        
        quantidadetf = new JTextField();
        quantidadetf.setToolTipText("Digite o código de barras do produto");
        quantidadetf.setSize(25, 20);
        quantidadetf.setLocation(220, 140);
        PPrincipal.add(quantidadetf);
        
        precoUnitariolb = new JLabel("Preço Unitário:");
        precoUnitariolb.setSize(150, 20);
        precoUnitariolb.setLocation(40, 170);
        PPrincipal.add(precoUnitariolb);
        precoUnitariotf = new JTextField();
        precoUnitariotf.setToolTipText("Digite o código de barras do produto");
        precoUnitariotf.setSize(300, 20);
        precoUnitariotf.setLocation(220, 170);
        PPrincipal.add(precoUnitariotf);
    }
    
}
