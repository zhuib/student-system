package sise.student.com;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AddTeacherJTable {
	static JScrollPane p;
	public static void addJTable() {   //添加表头
		TeacherBaseSystem.data.addColumn("教师编号");
		TeacherBaseSystem.data.addColumn("所教年级");
		TeacherBaseSystem.data.addColumn("所教班级");
		TeacherBaseSystem.data.addColumn("教师姓名");
		TeacherBaseSystem.data.addColumn("性别");
		TeacherBaseSystem.data.addColumn("所教课程");
		TeacherBaseSystem.data.addColumn("联系电话");
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"教师编号","所教年级","所教班级","教师姓名","性别","所教课程","联系电话"});

	}
	//创建数组用来存放从数据库取出的数据
	public static Object[] datarow(String tid,String tgrade,String tclass,String tname,String gender,String course,String phone){
		Object row[]=new Object[7];
		row[0]=tid;
		row[1]=tgrade;
		row[2]=tclass;
		row[3]=tname;
		row[4]=gender;
		row[5]=course;
		row[6]=phone;
		return row;
	}
	public static void tableMove() {//清除表格
		TeacherBaseSystem.data=(DefaultTableModel) TeacherBaseSystem.table.getModel();
		TeacherBaseSystem.data.setRowCount(0);// 清除原有行
		TeacherBaseSystem.data.setColumnCount(0);//消除原有列
	}
}
