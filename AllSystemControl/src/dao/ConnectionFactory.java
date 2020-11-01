package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Obtém conexão com o banco de dados
	public static Connection obtemConexao() throws SQLException {
		return DriverManager
				//.getConnection("jdbc:mysql://thunderstorm.ci5za8pelfli.us-east-2.rds.amazonaws.com:3306/thunderstorm?useTimezone=true&serverTimezone=America/Sao_Paulo&user=admin&password=ThunderCats");
				.getConnection("jdbc:mysql://localhost:3306/allcontrolsystem?useTimezone=true&serverTimezone=America/Sao_Paulo&user=admin&password=Allcontrolsyste3m");
	}

}
