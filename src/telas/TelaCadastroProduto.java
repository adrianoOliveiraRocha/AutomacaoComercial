
package telas;

import classes.Produto;
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

public class TelaCadastroProduto extends TelaModelo{
    private JPanel PPrincipal;
    private JPanel PBotoes;
    private JLabel codBarraslb;
    private JLabel obrigacodBarraslb;
    private JTextField codBarrastf;
    private JLabel descricaolb;
    private JLabel obrigadescricaolb;
    private JTextField descricaotf;
    private JLabel marcalb;
    private JTextField marcatf;
    private JLabel estoqueAtuallb;
    private JLabel estoque;
    private JLabel quantidadelb;
    private JTextField quantidadetf;
    private JLabel somenteNumerosquantidadelb;
    private JLabel estoqueMinlb;
    private JTextField estoqueMintf;
    private JLabel somenteNumerosestoqueMinlb;
    private JLabel precoCustolb;
    private JTextField precoCustotf;
    private JLabel somenteNumerosprecoCustolb;
    private JLabel precoVendalb;
    private JTextField precoVendatf;
    private JLabel somenteNumerosprecoVendalb;
    private JButton inserir;
    private JButton limpar;
    private JButton sair;
    
    String exibirQuantidade = "0";
    private int testeSomenteNumeros[];
    private Produto p;
    /*Essa variável será true se o código de barras digitado é de um produto já cadastrado*/
    private JButton editar;
    
    public TelaCadastroProduto(){
        //JOptionPane.showMessageDialog(precoCustolb, "TelaCadastroProduto()");
        p = new Produto();
        this.setTitle("Inserir Produtos");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 370);
        this.setLocation(140, 50);
        testeSomenteNumeros = new int[2];
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        PPrincipal = new JPanel();
        PPrincipal.setLayout(null);
        PPrincipal.setSize(750, 280);
        PPrincipal.setLocation(25, 0);
        this.add(PPrincipal);
        
        PBotoes = new JPanel();
        PBotoes.setLayout(null);
        PBotoes.setSize(750, 40);
        PBotoes.setLocation(25, 295);
        this.add(PBotoes);
        
        codBarraslb = new JLabel("Código:");
        codBarraslb.setSize(100, 20);
        codBarraslb.setLocation(25, 20);
        PPrincipal.add(codBarraslb);
        obrigacodBarraslb = new JLabel("Campo obrigatótio");
        obrigacodBarraslb.setVisible(false);
        obrigacodBarraslb.setForeground(Color.red);
        obrigacodBarraslb.setSize(150, 20);
        obrigacodBarraslb.setLocation(570, 20);
        PPrincipal.add(obrigacodBarraslb);
        codBarrastf = new JTextField();
        codBarrastf.setSize(300, 20);
        codBarrastf.setLocation(220, 20);
        codBarrastf.addKeyListener(new trataTeclado());
        PPrincipal.add(codBarrastf);
        
        descricaolb = new JLabel("Descrição:");
        descricaolb.setSize(100, 20);
        descricaolb.setLocation(25, 50);
        PPrincipal.add(descricaolb);
        obrigadescricaolb = new JLabel("Campo obrigatório");
        obrigadescricaolb.setVisible(false);
        obrigadescricaolb.setForeground(Color.red);
        obrigadescricaolb.setSize(150, 20);
        obrigadescricaolb.setLocation(570, 50);
        PPrincipal.add(obrigadescricaolb);
        descricaotf = new JTextField();
        descricaotf.setSize(300, 20);
        descricaotf.setLocation(220, 50);
        descricaotf.addKeyListener(new trataTeclado());
        PPrincipal.add(descricaotf);
        
        marcalb = new JLabel("Marca:");
        marcalb.setSize(100, 20);
        marcalb.setLocation(25, 80);
        PPrincipal.add(marcalb);
        marcatf = new JTextField();
        marcatf.setSize(300, 20);
        marcatf.setLocation(220, 80);
        PPrincipal.add(marcatf);
        
        estoqueAtuallb = new JLabel("Quantidade em estoque: ");
        estoqueAtuallb.setVisible(false);
        estoqueAtuallb.setSize(200, 20);
        estoqueAtuallb.setLocation(25, 110);
        PPrincipal.add(estoqueAtuallb);
        
        estoque = new JLabel();
        estoque.setVisible(false);
        estoque.setSize(50, 20);
        estoque.setLocation(320, 110);
        PPrincipal.add(estoque);
                
        quantidadelb = new JLabel("Quantidade:");
        quantidadelb.setSize(100, 20);
        quantidadelb.setLocation(25, 140);
        PPrincipal.add(quantidadelb);
        quantidadetf = new JTextField();
        quantidadetf.setSize(150, 20);
        quantidadetf.setLocation(220, 140);
        quantidadetf.addKeyListener(new trataTeclado());
        PPrincipal.add(quantidadetf);
        somenteNumerosquantidadelb = new JLabel("Somente Números");
        somenteNumerosquantidadelb.setForeground(Color.red);
        somenteNumerosquantidadelb.setVisible(false);
        somenteNumerosquantidadelb.setSize(200, 20);
        somenteNumerosquantidadelb.setLocation(550, 140);
        PPrincipal.add(somenteNumerosquantidadelb);
        
        estoqueMinlb = new JLabel("Estoque Mínimo:");
        estoqueMinlb.setSize(180, 20);
        estoqueMinlb.setLocation(25, 170);
        PPrincipal.add(estoqueMinlb);
        estoqueMintf = new JTextField();
        estoqueMintf.setSize(150, 20);
        estoqueMintf.setLocation(220, 170);
        estoqueMintf.addKeyListener(new trataTeclado());
        PPrincipal.add(estoqueMintf);
        somenteNumerosestoqueMinlb = new JLabel("Somente Números");
        somenteNumerosestoqueMinlb.setForeground(Color.red);
        somenteNumerosestoqueMinlb.setVisible(false);
        somenteNumerosestoqueMinlb.setSize(200, 20);
        somenteNumerosestoqueMinlb.setLocation(550, 170);
        PPrincipal.add(somenteNumerosestoqueMinlb);
        
        precoCustolb = new JLabel("Preço Custo:");
        precoCustolb.setSize(180, 20);
        precoCustolb.setLocation(25, 200);
        PPrincipal.add(precoCustolb);
        precoCustotf = new JTextField();
        precoCustotf.setSize(150, 20);
        precoCustotf.setLocation(220, 200);
        precoCustotf.addKeyListener(new trataTeclado());
        PPrincipal.add(precoCustotf);
        somenteNumerosprecoCustolb = new JLabel("Somente Números");
        somenteNumerosprecoCustolb.setForeground(Color.red);
        somenteNumerosprecoCustolb.setVisible(false);
        somenteNumerosprecoCustolb.setSize(200, 20);
        somenteNumerosprecoCustolb.setLocation(550, 200);
        PPrincipal.add(somenteNumerosprecoCustolb);
        
        precoVendalb = new JLabel("Preço Venda:");
        precoVendalb.setSize(180, 20);
        precoVendalb.setLocation(25, 230);
        PPrincipal.add(precoVendalb);
        precoVendatf = new JTextField();
        precoVendatf.setSize(150, 20);
        precoVendatf.setLocation(220, 230);
        precoVendatf.addKeyListener(new trataTeclado());
        PPrincipal.add(precoVendatf);
        somenteNumerosprecoVendalb = new JLabel("Somente Números");
        somenteNumerosprecoVendalb.setForeground(Color.red);
        somenteNumerosprecoVendalb.setVisible(false);
        somenteNumerosprecoVendalb.setSize(200, 20);
        somenteNumerosprecoVendalb.setLocation(550, 230);
        PPrincipal.add(somenteNumerosprecoVendalb);
        
        inserir = new JButton("Inserir");
        inserir.setSize(150, 20);
        inserir.setLocation(75, 10);
        inserir.setVisible(true);
        inserir.addActionListener(new trataBotao());
        PBotoes.add(inserir);
        
        editar = new JButton("Editar");
        editar.setSize(150, 20);
        editar.setLocation(75, 10);
        editar.setVisible(false);
        editar.addActionListener(new trataBotao());
        PBotoes.add(editar);
        
        limpar = new JButton("Limpar");
        limpar.setSize(150, 20);
        limpar.setLocation(300, 10);
        limpar.setVisible(true);
        limpar.addActionListener(new trataBotao());
        PBotoes.add(limpar);
        
        sair = new JButton("Sair");
        sair.setSize(150, 20);
        sair.setLocation(525, 10);
        sair.setVisible(true);
        sair.addActionListener(new trataBotao());
        PBotoes.add(sair);
        
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
            if(e.getSource().equals(quantidadetf)){
            testeSomenteNumeros[0] = 0;
            somenteNumerosquantidadelb.setVisible(false);
            if(!Produto.somenteNumeros(quantidadetf.getText())){
                testeSomenteNumeros[0] = 1;
                somenteNumerosquantidadelb.setVisible(true);
            }        
        }else if(e.getSource().equals(estoqueMintf)){
            testeSomenteNumeros[1] = 0;
            somenteNumerosestoqueMinlb.setVisible(false);
            if(!Produto.somenteNumeros(estoqueMintf.getText())){
                testeSomenteNumeros[1] = 1;
                somenteNumerosestoqueMinlb.setVisible(true);
            }
        }
        else if(e.getSource().equals(codBarrastf)){
            /*Sempre que for digitado um número no campo codBarras*/
            obrigacodBarraslb.setVisible(false);
            descricaotf.setText(""); marcatf.setText("");
            descricaotf.setEditable(true); marcatf.setEditable(true);
            estoqueMintf.setText(""); precoCustotf.setText("");
            precoVendatf.setText(""); estoqueAtuallb.setVisible(false);
            estoque.setText(""); estoque.setVisible(false); estoqueMintf.setEditable(true);
            precoCustotf.setEditable(true); precoVendatf.setEditable(true);
            inserir.setVisible(true); editar.setVisible(false);
            
           ResultSet resposta = p.verificarCodBarras(codBarrastf.getText());
           
                try {
                    /*Se o produto já existe no BD, seus dados aparecerão na tela
                     O sistema deve, nessse caso, somar a quantidade digitada à 
                     que já existe no BD*/
                    while(resposta.next()){
                        
                        String exibirDescricao = String.valueOf(resposta.getObject(2));
                        descricaotf.setText(exibirDescricao); 
                        String exibirMarca = String.valueOf(resposta.getObject(3));
                        marcatf.setText(exibirMarca); 
                        exibirQuantidade = String.valueOf(resposta.getObject(4));
                        estoqueAtuallb.setVisible(true); estoque.setText(exibirQuantidade); estoque.setVisible(true);
                        String exibirestoqueMin = String.valueOf(resposta.getObject(5));
                        estoqueMintf.setText(exibirestoqueMin); 
                        String exibirprecoCusto = String.valueOf(resposta.getObject(6));
                        precoCustotf.setText(exibirprecoCusto); 
                        String exibirprecoVenda = String.valueOf(resposta.getObject(7));
                        precoVendatf.setText(exibirprecoVenda); 
                        
                        inserir.setVisible(false); editar.setVisible(true);
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(TelaCadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
                }
        }else if(e.getSource().equals(descricaotf)){
            obrigadescricaolb.setVisible(false);
        }
    }
}
    
    public class trataBotao implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(sair)){
                dispose();
            }else if(e.getSource().equals(limpar)){
                limpar();
                               
        }else if(e.getSource().equals(inserir)){
            /*a operação é chamda somente se os campos numéricos estiverem preenchidos
             somente com números*/
            int teste = 0;
            for(int cont = 0; cont < testeSomenteNumeros.length; cont++){
                if(testeSomenteNumeros[cont] == 1){
                    teste++;
                }
                }
                if(teste > 0){
                    JOptionPane.showMessageDialog(precoCustolb, "Atenção para os campos numéricos");
                }
                else{
                    if("".equals(codBarrastf.getText())){
                        JOptionPane.showMessageDialog(precoCustolb, "O código de barras é obrigatório!");
                    }else{
                        configurarProduto();
                         try {
                    p.inserirNovoProduto();
                    limpar();
                    codBarrastf.grabFocus();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaCadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
                }
                    }
                    
                }
            
               
        }else if(e.getSource().equals(editar)){
            /*a operação é chamda somente se os campos numéricos estiverem preenchidos
             somente com números*/
            int teste = 0;
            for(int cont = 0; cont < testeSomenteNumeros.length; cont++){
                if(testeSomenteNumeros[cont] == 1){
                    teste++;
                }
                }
                if(teste > 0){
                    JOptionPane.showMessageDialog(precoCustolb, "Atenção para os campos numéricos");
                }
                else{
                    configurarProduto();
                try {
                    /*Envia quantidade existente + quantidade a acrescentar*/
                    p.inserirUnidadesProdutoExistente(exibirQuantidade, quantidadetf.getText());
                } catch (SQLException ex) {
                    Logger.getLogger(TelaCadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
        }
    }

        private void configurarProduto() {
            try{
                p.setCodBarras(codBarrastf.getText());
                p.setDescricao(descricaotf.getText());
                p.setMarca(marcatf.getText());
            
            if(!p.testaVazio(quantidadetf.getText())) quantidadetf.setText("0");
                p.setQuantidade(Integer.parseInt(quantidadetf.getText()));
            
            if(!p.testaVazio(estoqueMintf.getText())) estoqueMintf.setText("0");
                p.setEstoqueMin(Integer.parseInt(estoqueMintf.getText()));
            
            String precoCusto = p.trataVirgula(precoCustotf.getText());
            Double precoCustoDouble = Double.parseDouble(precoCusto);
            p.setPrecoCusto(precoCustoDouble);
            
            String precoVenda = p.trataVirgula(precoVendatf.getText());
            Double precoVendaDouble = Double.parseDouble(precoVenda);
            p.setPrecoVenda(precoVendaDouble);
                        
            }catch(NumberFormatException nex){
                JOptionPane.showMessageDialog(precoCustolb, "Atenção para os campos numéricos");
            }
            
        }
        
        private void limpar(){
            codBarrastf.setText(""); descricaotf.setText("");
            marcatf.setText(""); estoque.setText("");
            quantidadetf.setText("");
            estoqueMintf.setText(""); precoCustotf.setText("");
            precoCustotf.setText(""); precoVendatf.setText("");
            somenteNumerosquantidadelb.setVisible(false);
            somenteNumerosestoqueMinlb.setVisible(false);
            somenteNumerosprecoCustolb.setVisible(false);
            somenteNumerosprecoVendalb.setVisible(false);
            codBarrastf.grabFocus();
        }
    }
}