package sise.student.com;

import java.sql.SQLException;

import javax.swing.JFrame;
//刷新教师信息
public class UpdataTeacher extends JFrame{
	static String sql=null;
	public static void Alluser(){
		AddTeacherJTable.addJTable();  //添加表头
		sql="select * from tb_teacher";
		DBHelper.select(sql);
		try {
			while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
				TeacherBaseSystem.data.addRow(AddTeacherJTable.datarow(DBHelper.rs.getString("tid"),DBHelper.rs.getString("tgrade"),DBHelper.rs.getString("tclass"),DBHelper.rs.getString("tname"),DBHelper.rs.getString("gender"),
						DBHelper.rs.getString("course"),DBHelper.rs.getString("phone")));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
