package pw.venda.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class VendaModel {

  public static String gravar(String codigo, String produto, int quantidade) {

    try {
      // Obter conexão com o banco de dados.
      Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/vendadb;create=true", "app", "app");
      // Criando uma sentença.
      Statement stmt = conexao.createStatement();
      //Executar o SQL de inclusão no banco de dados.
      stmt.executeUpdate(
          "insert into venda (codigo, produto, quantidade) values ('"
          + codigo + "', '"
          + produto + "', "
          + quantidade + ")");

    } catch (Exception e) {
      return e.getMessage();
    }

    return "Operação realizada com sucesso";
  }

}