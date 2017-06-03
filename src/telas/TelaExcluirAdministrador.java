

package telas;

import classes.ConectaDB;
import classes.ResultSetTableModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
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
class TelaExcluirAdministrador extends TelaModelo{
    private JPanel PBotoes;
    private JButton editar;
    private JButton limpar;
    private JButton sair;
    private JPanel PPrincipal;
    private JLabel loginlb;
    private JTextField logintf;
    private JLabel respostalb;
    private JLabel senhalb;
    private JTextField senhatf;
    private JLabel nomelb;
    private JTextField nometf;
    private JLabel cpflb;
    private JLabel somenteNumeroscpflb;
    private JTextField cpftf;
    private JLabel rglb;
    private JLabel somenteNumerosrglb;
    private JTextField rgtf;
    private JLabel carteiraTrabalholb;
    private JLabel somenteNumeroscarteiraTrabalholb;
    private JTextField carteiraTrabalhotf;
    private JLabel pislb;
    private JLabel somenteNumerospislb;
    private JTextField pistf;
    private JLabel telefonelb;
    private JLabel somenteNumerostelefonelb;
    private JLabel dddlb;
    private JLabel numerolb;
    private JTextField dddtf;
    private JTextField numerotf;
    private JLabel celularlb;
    private JLabel somenteNumeroscelularlb;
    private JLabel dddcelularlb;
    private JLabel numerocelularlb;
    private JTextField dddcelulartf;
    private JTextField numerocelulartf;
    private JLabel emaillb;
    private JTextField emailtf;
    private JLabel enderecolb;
    private JLabel somenteNumerosnumeroEnderecolb;
    private JTextField ruatf;
    private JTextField numeroenderecotf;
    private JLabel complementolb;
    private JTextField complementotf;
    private JLabel bairrolb;
    private JTextField bairrotf;
    private JLabel ceplb;
    private JLabel somenteNumerosCeplb;
    private JTextField ceptf;
    private JLabel cidadelb;
    private JTextField cidadetf;
    private JLabel uflb;
    private JTextField uftf;
    private JLabel dataAdmissaolb;
    private JLabel somenteNumerosdataAdmissaolb;
    private JLabel formatodataAdmissaolb;
    private JLabel diaAdmissaolb;
    private JTextField diaAdmissaotf;
    private JLabel mesAdmissaolb;
    private JTextField mesAdmissaotf;
    private JLabel anoAdmissaolb;
    private JTextField anoAdmissaotf;
    private JPanel PainelPrincipal;
    private JPanel PainelBotoes;
    private ResultSetTableModel rstm;
    private JTable tabelaAdministradores;
    private JScrollPane jscrollAdministrador;
    private JButton excluir;

    public TelaExcluirAdministrador() throws SQLException {
        this.setTitle("Excluir Administrador");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(900, 250);
        this.setLocation(140, 10);
        inicializarComponentes();
        criarTabelaAdministradores();
        this.setVisible(true);
        this.setResizable(false);
    }

    private void inicializarComponentes() {
        PainelPrincipal = new JPanel();
        PainelBotoes = new JPanel();
        
        PainelPrincipal.setLayout(null);
        PainelPrincipal.setSize(900, 100);
        //PainelPrincipal.setBackground(Color.yellow);
        PainelPrincipal.setLocation(0, 50);
        this.add(PainelPrincipal);
        
        PainelBotoes.setLayout(null);
        PainelBotoes.setSize(800, 40);
        PainelBotoes.setLocation(50, 180);
        //PainelBotoes.setBackground(Color.yellow);
        this.add(PainelBotoes);
        
        excluir = new JButton("Excluir");
        excluir.addActionListener(new TrataBotoes());
        excluir.setSize(100, 20);
        excluir.setLocation(200, 10);
        PainelBotoes.add(excluir);
        
        sair = new JButton("Sair");
        sair.addActionListener(new TrataBotoes());
        sair.setSize(100, 20);
        sair.setLocation(500, 10);
        PainelBotoes.add(sair);
    }

    private void criarTabelaAdministradores() throws SQLException {
        /*Lista de Administradores*/
        String query = "select login, senha, nome, cpf from Administrador, Funcionario "
                + "where senha = codigoFuncionario";
        String url = "jdbc:mysql://localhost:3306/ac?zeroDateTimeBehavior=convertToNull";
        String user = "root";
        String pass = "453231";
        
        rstm = new ResultSetTableModel(url, user, pass, query);
        tabelaAdministradores = new JTable(rstm);
        jscrollAdministrador = new JScrollPane(tabelaAdministradores);
        jscrollAdministrador.setSize(800, 100);
        jscrollAdministrador.setLocation(50, 0);
        PainelPrincipal.add(jscrollAdministrador);
    }
    
    public class TrataBotoes implements ActionListener{
        private ConectaDB cdb1;

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(sair)){
                dispose();
            }else if(e.getSource().equals(excluir)){
                String senha = "";
                int selecionado = tabelaAdministradores.getSelectedRow();
                if(-1 == selecionado){
                    JOptionPane.showMessageDialog(null, "Selecione um Administrador!");
                }else{
                    ResultSet pesquisaAdmin;
                    ConectaDB cdb = new ConectaDB();
                    pesquisaAdmin = cdb.pesquisaDB("select * from Administrador");
                    try {
                        while(pesquisaAdmin.next()){
                            if((selecionado + 1) == pesquisaAdmin.getRow()){
                                senha = (String) pesquisaAdmin.getObject("senha");
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaExcluirAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        excluiAdmin(senha);
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaExcluirAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

        private void excluiAdmin(String senha) throws SQLException {
            String query = "delete from Administrador where senha = '"+senha+"'";
            String query1 = "delete from Funcionario where codigoFuncionario= '"+senha+"'";
            ConectaDB cdbDeletAdmin = new ConectaDB();
            if(cdbDeletAdmin.cadastro(query)){
                excluiFuncionario(query1);
            }else{
                JOptionPane.showMessageDialog(null, "Problemas ao deletar Administrador!");
            }
        }

        private void excluiFuncionario(String query1) {
            ConectaDB cdbDeletFunc = new ConectaDB();
            if(cdbDeletFunc.cadastro(query1)){
                JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Problemas ao deletar Funcionário!");
            }
        }
        
    }
    
}
