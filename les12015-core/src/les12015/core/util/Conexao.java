
package les12015.core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/bdles";
		String user = "postgres"; // muda para o seu banco de dados
		String password = "1234"; // sua senha do banco
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, password);

		return conn;

	}

}
