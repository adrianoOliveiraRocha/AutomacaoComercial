

package telas;

import classes.ConectaDB;
import classes.Funcionario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author adriano
 */
class TelaFuncionarioSelecionadoDaLista extends TelaConsultarFuncionarioPorNumero{
    private final JButton salvar;
        
    public TelaFuncionarioSelecionadoDaLista(int selecionado) throws SQLException {
        this.setTitle("Editar Funcionário");
        
        pesquisarFuncionario(selecionado);
        
        permitirEdicao();
        
        salvar = new JButton("Salvar");
        salvar.setVisible(true);
        salvar.setSize(130, 20);
        salvar.setLocation(165, 10);
        salvar.addActionListener(new EditarCancelar());
        PBotoes.add(salvar);
        
        sair.setLocation(456, 10);
        
    }

    private void pesquisarFuncionario(int selecionado) throws SQLException {
        ResultSet r;
        cdb = new ConectaDB();
        r = cdb.pesquisaDB("select * from Funcionario");
        while(r.next()){
            if(r.getRow() == selecionado){
                codigoFuncionariotf.setEditable(false);
                codigoFuncionariotf.setText((String) r.getObject("codigoFuncionario"));
                nometf.setText((String) r.getObject("nome"));
                cpftf.setText((String) r.getObject("cpf"));
                rgtf.setText((String) r.getObject("rg"));
                carteiraTrabalhotf.setText((String) r.getObject("carteiraTrabalho"));
                pistf.setText((String) r.getObject("pis"));
                telefonetf.setText((String) r.getObject("telefone"));
                celulartf.setText((String) r.getObject("celular"));
                emailtf.setText((String) r.getObject("email"));
                enderecotf.setText((String) r.getObject("endereco"));
                complementotf.setText((String) r.getObject("complemento"));
                bairrotf.setText((String) r.getObject("bairro"));
                ceptf.setText((String) r.getObject("cep"));
                cidadetf.setText((String) r.getObject("cidade"));
                uftf.setText( (String)r.getObject("uf"));
                dataAdmissaotf.setText( String.valueOf(r.getObject("dataAdmissao")));
                dataDemissaotf.setText( String.valueOf(r.getObject("dataDemissao")));
            }
        }
    }

    private void permitirEdicao() {
        nometf.setEditable(true); cpftf.setEditable(true);
        rgtf.setEditable(true); carteiraTrabalhotf.setEditable(true);
        pistf.setEditable(true); telefonetf.setEditable(true); 
        celulartf.setEditable(true); emailtf.setEditable(true);
        enderecotf.setEditable(true); complementotf.setEditable(true);
        bairrotf.setEditable(true); ceptf.setEditable(true);
        cidadetf.setEditable(true); uftf.setEditable(true);
    }
    
    public class EditarCancelar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(salvar)){
                int teste = 0;
                for(int c = 0; c < testeSomenteNumeros.length; c++){
                    if(testeSomenteNumeros[c] == 1){
                        teste ++;
                    }
                }
                if(teste > 0){
                    JOptionPane.showMessageDialog(rootPane, "Atenção para os campos numéricos");
                }else{
                    String quey = "update Funcionario set nome = '"+nometf.getText()+"', cpf = '"+cpftf.getText()+"', "
                        + "rg = '"+rgtf.getText()+"', carteiraTrabalho = '"+carteiraTrabalhotf.getText()+"', "
                        + "pis = '"+pistf.getText()+"', telefone = '"+telefonetf.getText()+"', celular = '"+celulartf.getText()+"', "
                        + "email = '"+emailtf.getText()+"', endereco = '"+enderecotf.getText()+"', complemento = '"+complementotf.getText()+"', "
                        + "bairro = '"+bairrotf.getText()+"', cep = '"+ceptf.getText()+"', cidade = '"+cidadetf.getText()+"', "
                        + "uf = '"+uftf.getText()+"'"
                        + "where codigoFuncionario = '"+codigoFuncionariotf.getText()+"'";
                if(cdb.cadastro(quey)){
                    JOptionPane.showMessageDialog(rootPane, "Operação realizada com sucesso!");
                    limpar(); limpaSomenteNumeros();
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Não foi possível realizar a operação!!");
                }
                }
            }
        }
        
    }
}
