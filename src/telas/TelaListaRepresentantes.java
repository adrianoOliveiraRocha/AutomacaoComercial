
package telas;

import classes.ResultSetTableModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author adriano
 */
class TelaListaRepresentantes extends TelaModelo{
    private JPanel PPrincipal;
    private JPanel PBotoes;
    private ResultSetTableModel rstm;
    private JTable tabelaRepresentantes;
    private JScrollPane jscrollPaneRepresentantes;
    private JButton novo;
    private JButton editar;
    private JButton excluir;
    private JButton atualizar;
    private JButton sair;
    
    public TelaListaRepresentantes() throws SQLException {
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1050, 360);
        this.setLocation(100, 20);   
        this.setTitle("Representantes Cadastrados");
        inicializarComponentes();
        preencherCampos();
        this.setResizable(false);
        this.setVisible(true);
    }

    private void inicializarComponentes() {
        
        PBotoes = new JPanel();
        PBotoes.setLayout(null);
        //PBotoes.setBackground(Color.yellow);
        PBotoes.setSize(1000, 40);
        PBotoes.setLocation(25, 280);
        this.add(PBotoes);
        
        novo = new JButton("Novo");
        novo.setSize(130, 20);
        novo.setLocation(58, 10);
        novo.addActionListener(new TrataBotao());
        PBotoes.add(novo);
        
        editar = new JButton("Editar");
        editar.setSize(130, 20);
        editar.setLocation(246, 10);
        editar.addActionListener(new TrataBotao());
        PBotoes.add(editar);
        
        excluir = new JButton("Excluir");
        excluir.setSize(130, 20);
        excluir.setLocation(432, 10);
        PBotoes.add(excluir);
        
        atualizar = new JButton("Atualizar");
        atualizar.setSize(130, 20);
        atualizar.setLocation(622, 10);
        atualizar.addActionListener(new TrataBotao());
        PBotoes.add(atualizar);
        
        sair = new JButton("Sair");
        sair.setSize(130, 20);
        sair.setLocation(810, 10);
        sair.addActionListener(new TrataBotao());
        PBotoes.add(sair);
    }

    private void preencherCampos() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ac?zeroDateTimeBehavior=convertToNull";
        String userName = "root";
        String password = "453231";
        String query = "select * from Representante";
        rstm = new ResultSetTableModel(url, userName, password, query);
        tabelaRepresentantes = new JTable(rstm);
        jscrollPaneRepresentantes = new JScrollPane(tabelaRepresentantes);
        jscrollPaneRepresentantes.setSize(1000, 250);
        jscrollPaneRepresentantes.setLocation(25, 20);
        this.add(jscrollPaneRepresentantes);
    }
    
    public class TrataBotao implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(novo)){
                try {
                    new TelaCadastroRepresentante();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaListaRepresentantes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(e.getSource().equals(atualizar)){
                try {
                    dispose(); new TelaListaRepresentantes();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaListaRepresentantes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(e.getSource().equals(sair)){
                dispose();
            }else if(e.getSource().equals(editar)){
                int selecionado = tabelaRepresentantes.getSelectedRow() + 1;
                if(selecionado == 0){
                    JOptionPane.showMessageDialog(rootPane, "Seleciona um representante!!");
                }else{
                    try {
                        new TelaEditarRepresentante(selecionado);
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaListaRepresentantes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
    
}
