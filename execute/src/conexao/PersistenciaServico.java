package conexao;

import modelo.Servico;

import java.sql.*;

public class PersistenciaServico extends ConexaoBancodeDados {
    Connection connection;

    public PersistenciaServico() throws SQLException {
        this.connection = ConexaoBancodeDados.getInstance().getConnection();
    }

    public void Salvar(Servico servico) {
        String query = "INSERT INTO servico (tipodeservico) VALUES ( '" + servico.getTipodeServico() + "');";

        try {
          this.connection.createStatement().executeUpdate(query);
            System.out.println("Tipo de serviço salvo com sucesso");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}