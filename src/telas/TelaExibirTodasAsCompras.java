

package telas;

import classes.ConectaDB;
import classes.ResultSetTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author adriano
 */
public class TelaExibirTodasAsCompras extends TelaModelo {
    private JPanel PPrincipal;
    private JPanel PBotoes;
    private ResultSetTableModel rstm;
    private JTable tabelaClientes;
    private JScrollPane jspc;
    private JButton detalhes;
    private JButton excluir;
    private JButton atualizar;
    private JButton sair;

    public TelaExibirTodasAsCompras() throws SQLException{
        this.setLayout(null);
        this.setTitle("Histórico de Compras");
        this.setSize(1200, 340);
        this.setLocation(50, 50);
        inicializarComponentes();
        preencherListaCompras();
        this.setVisible(true);
    }

    private void inicializarComponentes() {
        PPrincipal = new JPanel();
        PPrincipal.setLayout(null);
        //PPrincipal.setBackground(Color.yellow);
        PPrincipal.setSize(1100, 250);
        PPrincipal.setLocation(50, 20);
        this.add(PPrincipal);
        
        PBotoes = new JPanel();
        PBotoes.setLayout(null);
        //PBotoes.setBackground(Color.yellow);
        PBotoes.setSize(1100, 40);
        PBotoes.setLocation(50, 270);
        this.add(PBotoes);
        
        
        
        detalhes = new JButton("Detalhes");
        detalhes.setSize(130, 20);
        detalhes.setLocation(120, 10);
        detalhes.addActionListener(new TrataBotao());
        PBotoes.add(detalhes);
        
        excluir = new JButton("Excluir");
        excluir.setSize(130, 20);
        excluir.setLocation(370, 10);
        PBotoes.add(excluir);
        
        atualizar = new JButton("Atualizar");
        atualizar.setSize(130, 20);
        atualizar.setLocation(620, 10);
        atualizar.addActionListener(new TrataBotao());
        PBotoes.add(atualizar);
        
        sair = new JButton("Sair");
        sair.setSize(130, 20);
        sair.setLocation(870, 10);
        sair.addActionListener(new TrataBotao());
        PBotoes.add(sair);
    }

    private void preencherListaCompras() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ac?zeroDateTimeBehavior=convertToNull";
        String user = "root";
        String pass = "453231";
        String query = "select numero, data, codigoFuncionario, numeroFornecedor, "
                + "numeroRepresentante from CompraAvulsa";
        rstm = new ResultSetTableModel(url, user, pass, query);
        tabelaClientes = new JTable(rstm);
        jspc = new JScrollPane(tabelaClientes);
        jspc.setSize(1100, 250);
        jspc.setLocation(0, 0);
        PPrincipal.add(jspc);
    }
    
    public class TrataBotao implements ActionListener{
        private ConectaDB cdb;

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(sair)){
                dispose();
            }
            else if(e.getSource().equals(atualizar)){
                try {
                    dispose();
                    new TelaExibirTodasAsCompras();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaExibirTodosClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(e.getSource().equals(detalhes)){
                try {
                    //JOptionPane.showMessageDialog(null, "Retornado = "+numeroCompraVaulsa);
                    new TelaDetalhesDaCompra(retornaNumeroCompraAvulsa());
                } catch (SQLException ex) {
                    Logger.getLogger(TelaExibirTodasAsCompras.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        private int retornaNumeroCompraAvulsa() throws SQLException {
            int selecionado = tabelaClientes.getSelectedRow();
            if(selecionado == -1){
                JOptionPane.showMessageDialog(null, "Selecione uma compra! "+selecionado);
            }else{
                ResultSet r;
                cdb = new ConectaDB();
                r = cdb.pesquisaDB("select numero from CompraAvulsa");
                
                while(r.next()){
                    if((selecionado+1) == (r.getRow())){
                        return Integer.parseInt(String.valueOf(r.getObject("numero")));
                    }
                }
            }
            return 0;
        }
        
    }
}
