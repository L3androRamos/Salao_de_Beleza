package conexao;

import modelo.Cliente;

import java.sql.Connection;
import java.sql.SQLException;

public class PersistenciaCliente  extends ConexaoBancodeDados{
    Connection connection;
    public PersistenciaCliente() throws SQLException{
        this.connection = ConexaoBancodeDados.getInstance().getConnection();

    }
    public void Salvar(Cliente cliente){
        String query ="Insert INTO cliente (nome) VALUES ('" +cliente.getNome() + "');";
        try{
            this.connection.createStatement().executeUpdate(query);
            System.out.println("Cliente salvo com sucesso!");
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}