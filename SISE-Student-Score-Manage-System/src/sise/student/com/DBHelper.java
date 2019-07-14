package sise.student.com;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class DBHelper implements DBConfig {
	static Connection conn = null;
	static Statement stat = null;
	static ResultSet rs = null;

	//连接加载驱动
	public static Connection getConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				conn =DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
		}
		
	
	//执行数据库操作
	public static Statement openStatement() {
		try {
			stat=getConnect().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stat;
		}
	
	//更新数据
	public static int update(String str) {
		int count =0;
		try {
			count = openStatement().executeUpdate(str);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	//查询数据
	public static ResultSet select(String str) {
		
			try {
				rs =openStatement().executeQuery(str);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
		
		return rs;
	}
	//关闭连接
	public static void closer() {
		try {
			if(rs!=null) 
			rs.close();
			if(stat!=null)
			stat.close();
			if(conn!=null)
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
	}
}
