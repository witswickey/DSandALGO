package soliddesign.singleResponsibility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionDB {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			String url = "jdbc:sqlite:path-to-db/chinook/chinook.db";
			conn = DriverManager.getConnection(url);

			System.out.println("Got it!");
			return conn;
		} catch (SQLException e) {
			throw new Error("Problem", e);
		}
	}
}
