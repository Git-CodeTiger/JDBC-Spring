package studio.codeocean.utils;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
public class ConnectionUtil {
	public static Connection getConnection() {
		String dirver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
		String username = "root";
		String password = "123456";
		Connection conn = null;
		try {
			Class.forName(dirver);//classLoader,加载对应的驱动
			conn = (Connection) DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
