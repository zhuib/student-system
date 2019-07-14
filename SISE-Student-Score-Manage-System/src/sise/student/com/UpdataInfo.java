package sise.student.com;

import java.sql.SQLException;

import javax.swing.JFrame;
//刷新学生信息
public class UpdataInfo extends JFrame{
	static String sql=null;
	public static void Alluser(){
		AddStudentJTable.addJTable();  //添加表头
		sql="select * from tb_studentinfo";
		DBHelper.select(sql);
		try {
			while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
				StudentBaseSystem.data.addRow(AddStudentJTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
						DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
