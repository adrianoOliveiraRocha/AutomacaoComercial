
package telas;

import classes.ResultSetTableModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author adriano
 */
class ListaProdutosEstoqueEmBaixa extends TelaModelo{
    private JPanel PBotoes;
    private JButton inserirProduto;
    private JButton sair;

    public ListaProdutosEstoqueEmBaixa() throws SQLException {
        this.setTitle("Produtos Com Estoque em Baixa");
        this.setLayout(null);
        this.setSize(1100, 400);
        this.setResizable(false);
        this.setLocation(100, 100);
        criarListeDeProdutosComEstoqueEmBaixa();
        criarPainelBotoes();
    }

    private void criarListeDeProdutosComEstoqueEmBaixa() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ac?zeroDateTimeBehavior=convertToNull";
        String user = "root";
        String pass = "453231";
        String query = "select * from Produto where estoque < estoqueMin";
        ResultSetTableModel rstm = new ResultSetTableModel(url, user, pass, query);
        JTable tabelaProdutosEmFalta = new JTable(rstm);
        JScrollPane jsp = new JScrollPane(tabelaProdutosEmFalta);
        jsp.setSize(1000, 250);
        jsp.setLocation(50, 50);
        this.add(jsp);
    }

    private void criarPainelBotoes() {
        PBotoes = new JPanel();
        PBotoes.setLayout(null);
        PBotoes.setSize(1000, 40);
        PBotoes.setLocation(50, 330);
        
        inserirProduto = new JButton("Inserir Produto");
        inserirProduto.setSize(150, 20);
        inserirProduto.setLocation(233, 10);
        inserirProduto.addActionListener(new TrataBotoes());
        PBotoes.add(inserirProduto);
        sair = new JButton("Sair");
        sair.setSize(120, 20);
        sair.setLocation(626, 10);
        sair.addActionListener(new TrataBotoes());
        PBotoes.add(sair);
        this.add(PBotoes);
    }
    
    public class TrataBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(inserirProduto)){
                new TelaCadastroProduto();
            }else if(e.getSource().equals(sair)){
                dispose();
            }
        }
        
    }
    
}
