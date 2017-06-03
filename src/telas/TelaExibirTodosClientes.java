
package telas;

import classes.ConectaDB;
import classes.ResultSetTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
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
class TelaExibirTodosClientes extends TelaModelo{
    private JPanel PPrincipal;
    private JPanel PBotoes;
    private JButton editar;
    private JButton sair;
    private ResultSetTableModel rstm;
    private JTable tabelaClientes;
    private JScrollPane jspc;
    int tipo;
    private JButton excluir;
    private JButton atualizar;
    public TelaExibirTodosClientes() throws SQLException {
        this.setLayout(null);
        this.setTitle("Lista de Clientes");
        this.setSize(1200, 340);
        this.setLocation(50, 50);
        inicializarComponentes();
        preencherListaClientes();
        this.setVisible(true);
        this.setResizable(false);
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
        
        editar = new JButton("Editar");
        editar.setSize(130, 20);
        editar.setLocation(120, 10);
        editar.addActionListener(new TrataBotao());
        PBotoes.add(editar);
        
        excluir = new JButton("Excluir");
        excluir.setSize(130, 20);
        excluir.setLocation(370, 10);
        excluir.addActionListener(new TrataBotao());
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

    private void preencherListaClientes() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ac?zeroDateTimeBehavior=convertToNull";
        String user = "root";
        String pass = "453231";
        String query = "select nome, telefone, celular, email from Cliente";
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
            else if(e.getSource().equals(editar)){
                int selecionado = tabelaClientes.getSelectedRow()+1;
                if(0 == selecionado){
                    JOptionPane.showMessageDialog(rootPane, "Por favor! seleciona um Cliente!");
                }else{
                    String login = JOptionPane.showInputDialog("Digite seu login");
                    String senha = JOptionPane.showInputDialog("Digite sua senha");
                    ResultSet r;
                    cdb = new ConectaDB();
                    r = cdb.pesquisaDB("select * from Administrador where login = '"+login+"'"
                            + " and senha = '"+senha+"'");
                    int existe = 0;
                    try {
                        while(r.next()){
                            existe++; 
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaExibirTodososFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(existe == 0){
                        JOptionPane.showMessageDialog(rootPane, "Não encontrado!");
                    }else{
                        try {
                            //Administrador encontrado
                            new TelaClienteSelecionadoDaLista(selecionado);
                        } catch (SQLException ex) {
                            Logger.getLogger(TelaExibirTodosClientes.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            else if(e.getSource().equals(atualizar)){
                try {
                    dispose(); new TelaExibirTodosClientes();                     
                } catch (SQLException ex) {
                    Logger.getLogger(TelaExibirTodosClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(e.getSource().equals(excluir)){
                try {
                    excluirCliente();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaExibirTodosClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        private void excluirCliente() throws SQLException {
            int selecionado = tabelaClientes.getSelectedRow()+1;
                if(0 == selecionado){
                    JOptionPane.showMessageDialog(rootPane, "Por favor! seleciona um Cliente!");
                }else{
                    String login = JOptionPane.showInputDialog("Digite seu login");
                    String senha = JOptionPane.showInputDialog("Digite sua senha");
                    ResultSet r;
                    cdb = new ConectaDB();
                    r = cdb.pesquisaDB("select * from Administrador where login = '"+login+"'"
                            + " and senha = '"+senha+"'");
                    int existe = 0;
                    try {
                        while(r.next()){
                            existe++; 
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaExibirTodososFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(existe == 0){
                        JOptionPane.showMessageDialog(rootPane, "Não encontrado!");
                    }else{
                        //Administrador encontrado
                        Excluir(selecionado);
                    }
                }
        }

        private void Excluir(int selecionado) throws SQLException {
            int numeroCliente = 0;
            int tipo = 0;
            ResultSet listaClientesRS;
            ConectaDB listaClientesDB = new ConectaDB();
            listaClientesRS = listaClientesDB.pesquisaDB("select * from Cliente");
            while(listaClientesRS.next()){
                if(selecionado == listaClientesRS.getRow()){
                    numeroCliente = Integer.parseInt(String.valueOf(listaClientesRS.getObject("numeroCliente")));
                    tipo = Integer.parseInt(String.valueOf(listaClientesRS.getObject("tipo")));
                }
            }
            /*Obtive o número do cliente.
            Se houver vendas feitas a esse cliente, entra no if e faz o loop que apaga todas as vendas, pedidos, contas
            a receber do cliente. Depois desse loop o cliente será excluído. Se não houver vendas feitas a esse cliente 
            esse etapa é ignorada*/
            if(testeClienteVenda(numeroCliente)){
                int resposta = JOptionPane.showConfirmDialog(null, "Esse cliente está ligado à pelo menos uma venda\n"
                        + "Ao excluí-lo, o sistema perderá todas as vendas e contas a receber ligadas à ele.\n"
                        + "Deseja continuar?");
                switch(resposta){
                    case 0:
                        /*Encontra todas as vendas - pedidos - desse cliente*/
                        String encontraVendas = "select Venda.numero, Venda.data from Venda \n" +
                            "where Venda.numeroCliente = "+numeroCliente+"";
                        ResultSet encontraVendasRS;
                        ConectaDB encontraVendasCDB = new ConectaDB();
                        encontraVendasRS = encontraVendasCDB.pesquisaDB(encontraVendas);
                        /*Esse loop apagará todos os pedidos(vendas) e contas a receber ligados a esse cliente*/
                        while(encontraVendasRS.next()){
                            /*Captura o número da venda - pedido*/
                            int numeroPedidoVenda = Integer.parseInt(String.valueOf(encontraVendasRS.getObject("numero")));
                            Date dataPedido = Date.valueOf(String.valueOf(encontraVendasRS.getObject("data")));
                            JOptionPane.showMessageDialog(null, "Venda numero "+numeroPedidoVenda+" encontrada\n"
                                    + "data da venda = "+dataPedido);
                            /*Temos que alterar o valor total da sessão. Os valores dos pedidos que serão apagados deveram ser 
                            somados para sejam sutraídos do valor total da sessão*/
                            /*Deleta todos os ítens de pedido desse pedido*/
                            if(deletaItensDessePedidoVenda(numeroPedidoVenda, dataPedido)){//Tenta deletar os ítens do pedido
                                /*Ons ítens foram deletados sem problemas. Vamos deletar a venda. Mas, para deletar a 
                                venda, precisamos deletar as contas a receber que estejam ligadas a essa venda, pois, 
                                a PK da tabela Venda é FK na tabela ContaReceber*/
                                if(deleteContasReceber(numeroPedidoVenda, dataPedido)){/*Tenta deletar as contas a receber 
                                    ligadas à essa venda, se houver.
                                    Agora podemos deletar a venda*/
                                    if(deletaVenda(numeroCliente, numeroPedidoVenda, dataPedido)){/*Tenta deletar a venda*/
                                        /*Agora podemos deletar o pedido*/
                                        if(deletarPedido(numeroPedidoVenda, dataPedido)){
                                            /*Pedido deletado, podemos deletar o cliente apenas se não houver mais
                                            nenhuma vandaPedido ligada a ele. Por isso, o cliente deve ser deletado fora do loop while*/
                                        }else{
                                            JOptionPane.showMessageDialog(null, "Problemas ao excluir o pedido");
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Problemas ao excluir a venda");
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, "Problemas ao excluir contas a receber");
                                }
                                
                            }else{
                                JOptionPane.showMessageDialog(null, "Problema ao deletar ítens do pedido");
                            }
                            /*Deletou os ítens de pedido, a venda e o pedido. O loop continua até não existir mais 
                            nenhuma venda feita a esse cliente.*/
                        } 
                    break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "O cliente não será excluído!");
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Operação cancelada!");
                        break;
            }
            }
            /*Agora que o loop terminou, todos os pedidos(vendas) desse cliente foram apagados. Então, o cliente pode ser
                         deletado sem problemas*/
            JOptionPane.showMessageDialog(null, "O loop terminou. Na continuação o cliente será deletado");
            if(0 == tipo){
                excluirPessoaFisica(numeroCliente);
            }else{
                excluirPessoaJuridica(numeroCliente);
            }
        }

        private void excluirPessoaFisica(int numeroCliente) {
            String excluirPF = "delete from PessoaFisica where numeroCliente = "+numeroCliente+"";
            JOptionPane.showMessageDialog(null, excluirPF);
            ConectaDB excluirPFCDB = new ConectaDB();
            if(excluirPFCDB.cadastro(excluirPF)){
                excluirCliente(numeroCliente);
            }else{
                JOptionPane.showMessageDialog(null, "Problemas ao excluir Pessoa Física!");
            }            
        }

        private void excluirPessoaJuridica(int numeroCliente) {
            String excluirPJ = "delete from PessoaJuridica where numeroCliente = "+numeroCliente+"";
            JOptionPane.showMessageDialog(null, excluirPJ);
            ConectaDB excluirPJCDB = new ConectaDB();
            if(excluirPJCDB.cadastro(excluirPJ)){
                excluirCliente(numeroCliente);
            }else{
                JOptionPane.showMessageDialog(null, "Problemas ao excluir Pessoa Física!");
            }            
        }

        private void excluirCliente(int numeroCliente) {
            String excluirCliente = "delete from Cliente where numeroCliente = "+numeroCliente+"";
            JOptionPane.showMessageDialog(null, excluirCliente);
            ConectaDB excluirClienteCDB = new ConectaDB();
            if(excluirClienteCDB.cadastro(excluirCliente)){
                JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Problemas ao excluir Cliente!");
            }
        }

        private boolean testeClienteVenda(int numeroCliente) throws SQLException {
            boolean teste = false;
            String  pesquisaClienteVenda = "select * from Venda where Venda.numeroCliente = "+numeroCliente+"";
            JOptionPane.showMessageDialog(null, pesquisaClienteVenda);
            ResultSet pesquisaClienteVendaRS;
            ConectaDB pesquisaClienteVendaCDB = new ConectaDB();
            pesquisaClienteVendaRS = pesquisaClienteVendaCDB.pesquisaDB(pesquisaClienteVenda);
            while(pesquisaClienteVendaRS.next()){
                teste = true;
            }
            return teste;
        }

        private boolean deletaItensDessePedidoVenda(int numeroPedidoVenda, Date dataPedidoVenda) {
            String deletaItens = "delete from ItemPedido where ItemPedido.numeroPedido = "+numeroPedidoVenda+" "
                    + "and ItemPedido.dataPedido = '"+dataPedidoVenda+"'";
            JOptionPane.showMessageDialog(null, "deletaItens = "+deletaItens);
            ConectaDB deletaCDB = new ConectaDB();
            if(deletaCDB.cadastro(deletaItens)){
                return true;
            }else{
                return false;
            }
        }

        private boolean deletaVenda(int numeroCliente, int numeroVenda, Date dataVenda) {
            String delelatVenda = "delete from Venda where numeroCliente = "+numeroCliente+" "
                    + "and numero = "+numeroVenda+" and data = '"+dataVenda+"'";
            JOptionPane.showMessageDialog(null, "delelatVenda = "+delelatVenda);
            ConectaDB delelatVendaCDB = new ConectaDB();
            if(delelatVendaCDB.cadastro(delelatVenda)){
                return true;
            }else{
                return false;
            }
        }

        private boolean deletarPedido(int numeroPedidoVenda, Date dataPedido) throws SQLException {
            /*Antes de deletar o pedido, o valor total da ssesão é atualizado*/
            atualizarValorSessao(numeroPedidoVenda, dataPedido);
            /*Valor a Sessão atualizado*/
            String deletarPedido = "delete from Pedido where numero = "+numeroPedidoVenda+" and data = '"+dataPedido+"'";
            JOptionPane.showMessageDialog(null, "deletarPedido = "+deletarPedido);
            ConectaDB deletaPedidoCDB = new ConectaDB();
            if(deletaPedidoCDB.cadastro(deletarPedido)){
                return true;
            }else{
                return false;
            }
        }

        private boolean deleteContasReceber(int numeroPedidoVenda, Date dataPedido) {
            String deletarContasReceber = "delete from ContaReceber where numeroVenda = "+numeroPedidoVenda+" "
                    + "and dataVenda = '"+dataPedido+"'";
            JOptionPane.showMessageDialog(null, "deletarContasReceber = "+deletarContasReceber);
            ConectaDB deletaContasReceberCDB = new ConectaDB();
            if(deletaContasReceberCDB.cadastro(deletarContasReceber)){
                return true;
            }else{
                return false;
            }
        }

        private void atualizarValorSessao(int numeroPedido, Date dataPedido) throws SQLException {
            /*Obtendo o número da Sessao, ValorTotal da Sessão e valorTotal do Pedido*/
            int numeroSessao = obterNumeroSessao(numeroPedido, dataPedido);
            JOptionPane.showMessageDialog(null, "numeroSessao = "+numeroSessao);
            double valorTotalSessao = obterValorTotalSessao(numeroPedido, dataPedido);
            JOptionPane.showMessageDialog(null, "valorTotalSessao = "+valorTotalSessao);
            double valorTotalPedido = obterValorTotalPedido(numeroPedido, dataPedido);
            JOptionPane.showMessageDialog(null, "vvalorTotalPedido = "+valorTotalPedido);
            /*Calcula valor atualizado*/
            double valorAtualizado = valorTotalSessao - valorTotalPedido;
            /*Atualizar a Sessao*/
            String atualizaValorSessao = "update Sessao set valorTotal = "+valorAtualizado+" where numero = "+numeroSessao+"";
            JOptionPane.showMessageDialog(null, atualizaValorSessao);
            ConectaDB atualizaValorSessaoCDB = new ConectaDB();
            if(!atualizaValorSessaoCDB.cadastro(atualizaValorSessao)){
                JOptionPane.showMessageDialog(null, "Problema ao atualizar sessão!");
            }
        }

        private int obterNumeroSessao(int numeroPedido, Date dataPedido) throws SQLException {
            int resposta = 0;
            String pesquisaNumeroSessao = "select Sessao.numero from Pedido, Sessao\n" +
            "where Pedido.numero = "+numeroPedido+"\n" +
            "and Pedido.`data` = '"+dataPedido+"'\n" +
            "and Sessao.numero = Pedido.numeroSessao";
            JOptionPane.showMessageDialog(null, pesquisaNumeroSessao);
            ResultSet pesquisaNumeroSessaoRS;
            ConectaDB pesquisaNumeroSessaoCDB = new ConectaDB();
            pesquisaNumeroSessaoRS = pesquisaNumeroSessaoCDB.pesquisaDB(pesquisaNumeroSessao);
            while(pesquisaNumeroSessaoRS.next()){
                resposta = Integer.parseInt(String.valueOf(pesquisaNumeroSessaoRS.getObject("numero")));
            }
            return resposta;
        }

        private double obterValorTotalSessao(int numeroPedido, Date dataPedido) throws SQLException {
            double resposta = 0;
            String pesquisaValorTotalSessao = "select Sessao.valorTotal from Pedido, Sessao\n" +
            "where Pedido.numero = "+numeroPedido+"\n" +
            "and Pedido.`data` = '"+dataPedido+"'\n" +
            "and Sessao.numero = Pedido.numeroSessao";
            JOptionPane.showMessageDialog(null, pesquisaValorTotalSessao);
            ResultSet pesquisaValorTotalSessaoRS;
            ConectaDB pesquisaValorTotalSessaoCDB = new ConectaDB();
            pesquisaValorTotalSessaoRS = pesquisaValorTotalSessaoCDB.pesquisaDB(pesquisaValorTotalSessao);
            while(pesquisaValorTotalSessaoRS.next()){
                resposta = Double.parseDouble(String.valueOf(pesquisaValorTotalSessaoRS.getObject("valorTotal")));
            }
            return resposta;
        }

        private double obterValorTotalPedido(int numeroPedido, Date dataPedido) throws SQLException {
            double resposta = 0;
            String pesquisaValorTotalPedido = "select valorTotal from Pedido where numero = "+numeroPedido+" and"
                    + " data = '"+dataPedido+"'";
            ResultSet pesquisaValorTotalPedidoRS;
            ConectaDB pesquisaValorTotalPedidoCDB = new ConectaDB();
            pesquisaValorTotalPedidoRS = pesquisaValorTotalPedidoCDB.pesquisaDB(pesquisaValorTotalPedido);
            while(pesquisaValorTotalPedidoRS.next()){
                resposta = Double.parseDouble(String.valueOf(pesquisaValorTotalPedidoRS.getObject("valorTotal")));
            }
            return resposta;
        }
    }
}
