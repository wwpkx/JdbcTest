package cn.itcast.jdbc.datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

import cn.itcast.jdbc.datasource.MyDataSource;

/**
 * 
 * 2008-12-6
 * 
 * @author <a href="mailto:liyongibm@hotmail.com">????</a>
 * 
 */
public final class JdbcUtils_My {
	private static String url = "jdbc:mysql://localhost:3306/jdbc";
	private static String user = "root";
	private static String password = "";
	private static MyDataSource myDataSource = null;

	private JdbcUtils_My() {
	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			myDataSource = new MyDataSource();
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static DataSource getDataSource() {
		return myDataSource;
	}

	public static Connection getConnection() throws SQLException {
		return myDataSource.getConnection();
	}

	public static void free(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (conn != null)
					try {
						myDataSource.free(conn);
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
		}
	}
}
