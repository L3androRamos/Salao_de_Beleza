import conexao.ConexaoBancodeDados;
import modelo.Cliente;
import modelo.Servico;
import PersistenciaCliente;
Import PersistenciaServico;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Scanner;

public class RunBancoDeDados { public static void main(String[] args) {

    try {
        menuInicial();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
    public static void menuInicial() throws SQLException {
        out("Para cadastrar aluno digite 1 \nPara tipo de Servico digite 2\n");
        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();

        switch (opcao){
            case 1:
                out("Cadastrando Cliente");
                cadastrarCliente();
                break;
            case 2:
                out("Cadastrando Servico");
                cadastrarServico();
                break;


            default:
                out("Opção inválida");
                break;
        }
    }


