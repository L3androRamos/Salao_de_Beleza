package modelo;

import conexao.PersistenciaCliente;
import conexao.PersistenciaServico;

import java.sql.SQLException;
import java.util.Scanner;

public class SalaodeBeleza {
    public SalaodeBeleza() {

    }
    public void exibirmenuInicial() throws SQLException {
        out("Para cadastrar cliente digite 1 \nPara Tipo de Servico digite 2");
        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();
        switch (opcao){
            case 1:
                out("Cadastro de Cliente");
                cadastrarCliente();
                break;
            case 2:
                out("Cadastrar Tipo de Servico");
                cadastrarTipoServico();
        }
    }
    private  void cadastrarTipoServico() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        PersistenciaServico persistenciaServico = new PersistenciaServico();

        Servico servico = new Servico();
        out("Digite o tipo de servico a ser realizado:");
        servico.setTipodeServico(scanner.nextLine());
        out("Verifique os dados");

        out("Tipo de serviço: " + servico.getTipodeServico());
        out("Para confirmar Serviço cadastrado digite S para salvar ou N para cancelar");
        String confirmacao = scanner.nextLine().toUpperCase();
        switch (confirmacao){
            case"S":
                persistenciaServico.Salvar(servico);
                break;
            case "N":
                out("Cadastro cancelado");
                cadastrarTipoServico();
                break;
            default:
                out("Opção invalida");
                exibirmenuInicial();
                break;
        }
        exibirmenuInicial();
    }

    private  void cadastrarCliente() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        PersistenciaCliente PersistenciaCliente = new PersistenciaCliente();



        out("Digite o nome do Cliente");
        String nome  = scanner.nextLine();
        Cliente cliente = new Cliente(nome);
        out("Verifique os dados do Cliente");
        out("Nome: "+ cliente.getNome());
        out("Para confirmar Cliente cadastrado digite S para salvar ou N para cancelar");
        String confirmacao = scanner.nextLine().toUpperCase();
        switch (confirmacao){
            case "S":
                PersistenciaCliente.Salvar(cliente);
                break;
            case "N":
                out("Cadastro cancelado");
                cadastrarCliente();
                break;
            default:
                out("Opção inválida");
                exibirmenuInicial();
                break;
        }
        exibirmenuInicial();
    }

    private static void out(String s) {
        System.out.println(s);
    }
}
