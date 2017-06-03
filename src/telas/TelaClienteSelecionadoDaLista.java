/*
 * Tela que exibi os dados do cliente selecionado
 */

package telas;

import classes.ConectaDB;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author adriano
 */
class TelaClienteSelecionadoDaLista extends TelaCadastroCliente{
    private ConectaDB cdb;
    private ConectaDB clienteTabela;
    private JPanel PBotoes;
    private JButton salvar;
    private JButton limpar;
    private JButton sair;
    private int tipo;
    public TelaClienteSelecionadoDaLista(int selecionado) throws SQLException {
        this.setTitle("Editar Cliente");
        this.setSize(800, 550);
        this.setLocation(140, 50);   
        this.setLayout(null);
        this.setVisible(true);
        numerotf.setVisible(false);
        enderecotf.setSize(300, 20);
        tipo  = verificarTipo(selecionado);
        cdb.closeDB();
        if(tipo == 0){
            //Pessoa Física 
            constroiTelaPessoaFisica(selecionado); 
            cdb.closeDB();
        }else if(tipo == 1){
            //Pessoa Jurídica
            constroiTelaPessoaJuridica(selecionado);
            cdb.closeDB();
        }
        
        painelBotoes();
    }

    private int verificarTipo(int selecionado) throws SQLException {
        ResultSet r;
        cdb = new ConectaDB();
        int resposta = 0;
        r = cdb.pesquisaDB("select tipo from Cliente");
        while(r.next()){
            if(selecionado == r.getRow())
                resposta = Integer.parseInt(String.valueOf(r.getObject("tipo")));
        }
        return resposta;
    }

    private void constroiTelaPessoaFisica(int selecionado) throws SQLException {
        cpflb.setVisible(true);
        cpftf.setVisible(true);
        rglb.setVisible(true);
        rgtf.setVisible(true);
        dataNacimentolb.setVisible(true);
        dataNacimentotf.setVisible(true);
        
        preencheCamposPF(selecionado);
    }

    private void constroiTelaPessoaJuridica(int selecionado) throws SQLException {
        //PPrincipal.setSize(750, 480);
        razaoSocialb.setVisible(true);
        razaoSocialtf.setVisible(true);
        cnpjlb.setVisible(true);
        cnpjtf.setVisible(true);
        inscricaoEstaduallb.setVisible(true);
        inscricaoEstadualtf.setVisible(true);
        responsavellb.setVisible(true);
        responsaveltf.setVisible(true);
        
        preencheCamposPJ(selecionado);
    }

    private void preencheCamposPF(int selecionado) throws SQLException {
        /*Antes de mais nada, pegar o número do cliente selecionado na tabela*/
        int respostaNumero = obterNumeroCliente(selecionado);
        
        ResultSet pf;
        pf = cdb.pesquisaDB("select Cliente.numeroCliente, Cliente.nome, Cliente.telefone, Cliente.celular, "
                + "Cliente.email, Cliente.endereco, Cliente.bairro, Cliente.cep, Cliente.cidade, Cliente.uf, "
                + "PessoaFisica.cpf, PessoaFisica.rg, PessoaFisica.dataNacimento "
                + "from Cliente, PessoaFisica "
                + "where Cliente.numeroCliente = "+respostaNumero+" and PessoaFisica.numeroCliente = "+respostaNumero+"");
        while(pf.next()){
            long telefoneCompleto, celularCompleto, dddtelefone, telefone, dddcelular, celular;
            telefoneCompleto = Long.parseLong((String) pf.getObject("telefone"));
            dddtelefone = telefoneCompleto/100000000;
            telefone = telefoneCompleto%100000000;
            
            celularCompleto = Long.parseLong((String) pf.getObject("celular"));
            dddcelular = celularCompleto/100000000;
            celular = celularCompleto%100000000;
                        
            numeroClientetf.setText(String.valueOf(pf.getObject("numeroCliente")));
            nometf.setText((String) pf.getObject("nome"));
            dddtelefonetf.setText(String.valueOf(dddtelefone));
            telefonetf.setText(String.valueOf(telefone));
            dddcelulartf.setText(String.valueOf(dddcelular));
            celulartf.setText(String.valueOf(celular));
            emailtf.setText(((String) pf.getObject("email")));
            enderecotf.setText(((String) pf.getObject("endereco")));
            bairrotf.setText(((String) pf.getObject("bairro")));
            ceptf.setText(((String) pf.getObject("cep")));
            cidadetf.setText(((String) pf.getObject("cidade")));
            uftf.setText(((String) pf.getObject("uf")));
            cpftf.setText(((String) pf.getObject("cpf")));
            rgtf.setText(((String) pf.getObject("rg")));
            dataNacimentotf.setText(String.valueOf(pf.getObject("dataNacimento")));
            
        }
        
    }

    private void preencheCamposPJ(int selecionado) throws SQLException {
        int respostaNumero = obterNumeroCliente(selecionado);
        
        ResultSet pj;
        pj = cdb.pesquisaDB("select Cliente.numeroCliente, Cliente.nome, Cliente.telefone, Cliente.celular, "
                + "Cliente.email, Cliente.endereco, Cliente.bairro, Cliente.cep, Cliente.cidade, Cliente.uf, "
                + "PessoaJuridica.razaoSocial, PessoaJuridica.cnpj, PessoaJuridica.inscricaoEstadual, PessoaJuridica.responsavel "
                + "from Cliente, PessoaJuridica "
                + "where Cliente.numeroCliente = "+respostaNumero+" and PessoaJuridica.numeroCliente = "+respostaNumero+"");
        while(pj.next()){
            long telefoneCompleto, celularCompleto, dddtelefone, telefone, dddcelular, celular;
            telefoneCompleto = Long.parseLong((String) pj.getObject("telefone"));
            dddtelefone = telefoneCompleto/100000000;
            telefone = telefoneCompleto%100000000;
            
            celularCompleto = Long.parseLong((String) pj.getObject("celular"));
            dddcelular = celularCompleto/100000000;
            celular = celularCompleto%100000000;
            
            numeroClientetf.setText(String.valueOf(pj.getObject("numeroCliente")));
            nometf.setText((String) pj.getObject("nome"));
            dddtelefonetf.setText(String.valueOf(dddtelefone));
            telefonetf.setText(String.valueOf(telefone));
            dddcelulartf.setText(String.valueOf(dddcelular));
            celulartf.setText(String.valueOf(celular));
            emailtf.setText(((String) pj.getObject("email")));
            enderecotf.setText(((String) pj.getObject("endereco")));
            bairrotf.setText(((String) pj.getObject("bairro")));
            ceptf.setText(((String) pj.getObject("cep")));
            cidadetf.setText(((String) pj.getObject("cidade")));
            uftf.setText(((String) pj.getObject("uf")));
            razaoSocialtf.setText((String) pj.getObject("razaoSocial"));
            cnpjtf.setText((String) pj.getObject("cnpj"));
            inscricaoEstadualtf.setText((String) pj.getObject("inscricaoEstadual"));
            responsaveltf.setText((String) pj.getObject("responsavel"));
        }
    }

    private int obterNumeroCliente(int selecionado) throws SQLException {
        int numeroCliente = 0;
        ResultSet clienteselecionado;
        clienteTabela = new ConectaDB();
        clienteselecionado = clienteTabela.pesquisaDB("select * from Cliente");
        while(clienteselecionado.next()){
            if(selecionado == clienteselecionado.getRow()){
                numeroCliente = Integer.parseInt(String.valueOf(clienteselecionado.getObject("numeroCliente")));
            }
        }
        return numeroCliente;
    }

    private void painelBotoes() {
        PBotoes = new JPanel();
        PBotoes.setLayout(null);
        PBotoes.setSize(750, 40);
        PBotoes.setLocation(25, 480);
        //PBotoes.setBackground(Color.yellow);
        this.add(PBotoes);
        
        salvar = new JButton("Salvar");        
        salvar.setSize(130, 20);
        salvar.setLocation(90, 10);
        salvar.addActionListener(new BotoesAction());
        PBotoes.add(salvar);
        
        limpar = new JButton("Limpar");        
        limpar.setSize(130, 20);
        limpar.setLocation(320, 10);
        limpar.addActionListener(new BotoesAction());
        PBotoes.add(limpar);
        
        sair = new JButton("Sair");        
        sair.setSize(130, 20);
        sair.setLocation(540, 10);
        sair.addActionListener(new BotoesAction());
        PBotoes.add(sair);
    }
    
    public class BotoesAction implements ActionListener{ 

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(salvar)){
                salvar();
            }else if(e.getSource().equals(limpar)){
                limpar();
            }else if(e.getSource().equals(sair)){
                dispose();
            }
        }

        private void salvar() {
            if(tipo == 0){
                if(atualizaTabelaCliente() + atualizarPessoaFisica() == 2){
                    JOptionPane.showMessageDialog(rootPane, "operação realizada com sucesso!");
                }
            }else if(tipo == 1){
                if(atualizaTabelaCliente() + atualizarPessoaJuridica() == 2){
                    JOptionPane.showMessageDialog(rootPane, "operação realizada com sucesso!");
                }
            }
        }

        private int atualizaTabelaCliente() {
            String update = "update Cliente set nome = '"+nometf.getText()+"', telefone = '"+dddtelefonetf.getText()+telefonetf.getText()+"', "
                    + "celular = '"+dddcelulartf.getText()+celulartf.getText()+"', email = '"+emailtf.getText()+"', endereco = '"+enderecotf.getText()+"', "
                    + "bairro = '"+bairrotf.getText()+"', cep = '"+ceptf.getText()+"', cidade = '"+cidadetf.getText()+"', uf = '"+uftf.getText()+"' "
                    + "where numeroCliente = "+Integer.parseInt(numeroClientetf.getText())+"";
            return finalizar(update);
        }

        private int atualizarPessoaFisica() {
            String update = "update PessoaFisica set cpf = '"+cpftf.getText()+"', rg = '"+rgtf.getText()+"' "
                    + "where numeroCliente = "+Integer.parseInt(numeroClientetf.getText())+"";
            return finalizar(update);
        }

        private int atualizarPessoaJuridica() {
            String update = "update PessoaJuridica set razaoSocial = '"+razaoSocialtf.getText()+"', cnpj = '"+cnpjtf.getText()+"', "
                    + "inscricaoEstadual = '"+inscricaoEstadualtf.getText()+"', responsavel = '"+responsaveltf.getText()+"' "
                    + "where numeroCliente = "+Integer.parseInt(numeroClientetf.getText())+"";
            return finalizar(update);
        }

        private int finalizar(String update) {
            cdb = new ConectaDB();
            if(!cdb.cadastro(update)){
                JOptionPane.showMessageDialog(rootPane, "Não foi possível realizar a operação");
                JOptionPane.showMessageDialog(rootPane, update);
                return 0;
            }else{
                return 1;
            }
        }
    }
    
    private void limpar() {
        nometf.setText("");
        dddtelefonetf.setText("");
        telefonetf.setText("");
        dddcelulartf.setText("");
        celulartf.setText("");
        emailtf.setText("");
        enderecotf.setText("");
        bairrotf.setText("");
        ceptf.setText("");
        cidadetf.setText("");
        uftf.setText("");
        cpftf.setText("");
        rgtf.setText("");
        dataNacimentotf.setText("");
        razaoSocialtf.setText("");
        cnpjtf.setText("");
        inscricaoEstadualtf.setText("");
        responsaveltf.setText("");
        nometf.grabFocus();
    }
}
