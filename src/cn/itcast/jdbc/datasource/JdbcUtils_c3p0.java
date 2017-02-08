package cn.itcast.jdbc.datasource;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 
 * 2008-12-6
 * 
 * @author <a href="mailto:liyongibm@hotmail.com">????</a>
 * 
 */
public final class JdbcUtils_c3p0 {
	private static String url = "jdbc:mysql://localhost:3306/jdbc";
	private static String user = "root";
	private static String password = "";
	private static DataSource myDataSource = null;

	private static ComboPooledDataSource ds = null;

	static {
		try {
//			ds = new ComboPooledDataSource();
//			ds.setDriverClass("com.mysql.jdbc.Driver");
//			ds.setJdbcUrl(url);
//			ds.setUser(user);
//			ds.setPassword(password);
//			ds.setInitialPoolSize(10);
//			ds.setMinPoolSize(5);
//			ds.setMaxPoolSize(20);
			
//			ds = new ComboPooledDataSource();	//不指定名字，则使用默认配置
			ds = new ComboPooledDataSource("mysql");
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
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;

		}
		if (st != null) {
			try {
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
