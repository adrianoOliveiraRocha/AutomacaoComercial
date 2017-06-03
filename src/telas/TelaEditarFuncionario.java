

package telas;

import classes.ConectaDB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
/**
 *
 * @author adriano
 */
class TelaEditarFuncionario extends TelaCadastroFuncionario{
    private final JButton salvar;

    public TelaEditarFuncionario() throws SQLException{
        this.setTitle("Editar Funcionário");
        codigoFuncionariotf.setText("");
        codigoFuncionariotf.setEditable(true);
        codigoFuncionariotf.addKeyListener(new codFuncionario());
        codigoFuncionariotf.grabFocus();
        
        cadastrar.setVisible(false);
        novo.setVisible(false);
        diaAdmissaolb.setVisible(false);
        diaAdmissaotf.setSize(150, 20);
        diaAdmissaotf.setLocation(220, 470);
        diaAdmissaotf.setEditable(false);
        mesAdmissaolb.setVisible(false);
        mesAdmissaotf.setVisible(false);
        anoAdmissaolb.setVisible(false);
        anoAdmissaotf.setVisible(false);
        numeroenderecotf.setVisible(false);
        
        limpar.setLocation(300, 10);
        sair.setLocation(525, 10);
        
        salvar = new JButton("Salvar");
        salvar.setSize(150, 20);
        salvar.setLocation(75, 10);
        salvar.setVisible(true);
        salvar.addActionListener(new TratabotaoSaivar());
        PBotoes.add(salvar);
    }
    
    private void limpar() {
         nometf.setText("");
         cpftf.setText("");
         rgtf.setText("");
         carteiraTrabalhotf.setText("");
         pistf.setText("");
         dddtf.setText("");
         numerotf.setText("");
         dddcelulartf.setText("");
         numerocelulartf.setText("");
         emailtf.setText("");
         ruatf.setText("");
         complementotf.setText("");
         bairrotf.setText("");
         ceptf.setText("");
         cidadetf.setText("");
         uftf.setText("");
         diaAdmissaotf.setText("");
        }
    
    public class TratabotaoSaivar implements ActionListener{
        private ConectaDB cdb;

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(salvar)){
                String atualizacao = "update Funcionario set nome = '"+nometf.getText()+"', "
                        + " cpf = '"+cpftf.getText()+"', rg = '"+rgtf.getText()+"', "
                        + "carteiraTrabalho = '"+carteiraTrabalhotf.getText()+"', pis = '"+pistf.getText()+"', "
                        + "telefone = '"+dddtf.getText()+numerotf.getText()+"', "
                        + "celular = '"+dddcelulartf.getText()+numerocelulartf.getText()+"', "
                        + "email = '"+emailtf.getText()+"', endereco = '"+ruatf.getText()+"', "
                        + "complemento = '"+complementotf.getText()+"', bairro = '"+bairrotf.getText()+"', "
                        + "cep = '"+ceptf.getText()+"', cidade = '"+cidadetf.getText()+"', "
                        + "uf = '"+uftf.getText()+"'"
                        + "where codigoFuncionario = '"+codigoFuncionariotf.getText()+"'";
                        
                //JOptionPane.showMessageDialog(rootPane, atualizacao);
                cdb = new ConectaDB();
                if(cdb.cadastro(atualizacao)){
                    JOptionPane.showMessageDialog(rootPane, "Operação realizada com sucesso!");
                    limpar(); codigoFuncionariotf.setText(""); codigoFuncionariotf.grabFocus();
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Não foi possível realizar essa operação!");
                }
            }
        }

    }
    
    public class codFuncionario implements KeyListener{
        private ConectaDB cdb;

        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            limpar();
            if(e.getSource().equals(codigoFuncionariotf)){
                if(!"".equals(codigoFuncionariotf.getText())){
                    String query = "select * from Funcionario "
                            + "where codigoFuncionario = '"+codigoFuncionariotf.getText()+"'";
                    ResultSet r;
                    cdb = new ConectaDB();
                    r = cdb.pesquisaDB(query);
                    try {
                        while(r.next()){
                            long telefoneCompleto = Long.parseLong(String.valueOf(r.getObject("telefone")));
                            long dddtelefone = telefoneCompleto/100000000;
                            long telefone = telefoneCompleto%100000000;
                            long celularCompleto = Long.parseLong(String.valueOf(r.getObject("celular")));
                            long dddcelular = celularCompleto/100000000;
                            long celular = celularCompleto%100000000;
                            
                            nometf.setText((String) r.getObject("nome"));
                            cpftf.setText((String) r.getObject("cpf"));
                            rgtf.setText((String) r.getObject("rg"));
                            carteiraTrabalhotf.setText((String) r.getObject("carteiraTrabalho"));
                            pistf.setText((String) r.getObject("pis"));
                            dddtf.setText(String.valueOf(dddtelefone));
                            numerotf.setText(String.valueOf(telefone));
                            dddcelulartf.setText(String.valueOf(dddcelular));
                            numerocelulartf.setText(String.valueOf(celular));
                            emailtf.setText((String) r.getObject("email"));
                            ruatf.setText((String) r.getObject("endereco"));
                            complementotf.setText((String) r.getObject("complemento"));
                            bairrotf.setText((String) r.getObject("bairro"));
                            ceptf.setText((String) r.getObject("cep"));
                            cidadetf.setText((String) r.getObject("cidade"));
                            uftf.setText((String) r.getObject("uf"));
                            diaAdmissaotf.setText(String.valueOf(r.getObject("dataAdmissao")));
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaEditarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        
    }
}
