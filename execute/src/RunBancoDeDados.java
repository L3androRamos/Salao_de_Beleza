import modelo.SalaodeBeleza;

import java.sql.SQLException;

public class RunBancoDeDados {
     public static void main(String[] args) {
         SalaodeBeleza salaodeBeleza = new SalaodeBeleza();
         try{
          salaodeBeleza.exibirmenuInicial();
         } catch  ( SQLException e) {
             throw new RuntimeException(e);
         }
     }



}