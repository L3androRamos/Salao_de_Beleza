package conexao;
import modelo.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PersistenciaCliente extends ConexaoBancodeDados{
    Connection connection;
    public PersistenciaCliente() throws SQLException {
        this.connection = ConexaoBancodeDados.getInstance().getConnection();
    }
    public void Salvar(Cliente cliente) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String Nome = sdf.format(cliente.getNome());
        String Numero = sdf.format(cliente.getNumeroDeContato());
        // Salva o aluno no banco de dados
        String query = "INSERT INTO aluno ( nome, data_nascimento, data_matricula) VALUES ( '" + cliente.getNome() + "', '" + dataNascimento + "', '" + dataMatricula + "');";
        try {
            this.connection.createStatement().executeUpdate(query);
            System.out.println("Cliente salvo com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> buscarCliente() {
        String consultaTodos = "SELECT * FROM cliente ORDER BY nome ASC";
        return executaConsulta(consultaTodos);
    }
    public ArrayList<String> buscarCliente(int codigo) {
        String consultaPorCodigo = "SELECT * FROM cliente WHERE codigo = " + codigo + " ORDER BY nome ASC";
        return executaConsulta(consultaPorCodigo);
    }
    public ArrayList<String> buscarAlunos(String nome) {
        String consultaPorNome = "SELECT * FROM cliente WHERE nome LIKE '%" + nome + "%' ORDER BY nome ASC";
        return executaConsulta(consultaPorNome);
    }
    public ArrayList<String> executaConsulta(String consulta){
        ArrayList<String> resultado = new ArrayList<>();
        try {
            ResultSet linhas =  this.connection.createStatement().executeQuery(consulta);

            while (linhas.next()){
                int codigo = linhas.getInt("codigo");
                String materia = linhas.getString("nome");
                String linha = codigo + " - " + materia;
                resultado.add(linha);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }

    public void deletarCliente(int codigo) {
        String query = "DELETE FROM aluno WHERE codigo = " + codigo;
        executaDelete(query);
    }
    public void deletarCliente(String nome) {
        String query = "DELETE FROM aluno WHERE nome LIKE '%" + nome + "%'";
        executaDelete(query);
    }
    public void executaDelete(String consultaDeDelete){
        try {
            this.connection.createStatement().executeUpdate(consultaDeDelete);
            System.out.println("Cliente deletado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

            }
    }
}
