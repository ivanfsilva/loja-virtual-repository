import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection recuperarConexao() throws SQLException {
		return DriverManager.
				getConnection("jdbc:mysql://localhost/loja_vurtual?autoReconnect=true&useTimezone=true&serverTimezone=UTC&useSSL=false", "root", "estudo");

	}
}
