package sise.student.com;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class QueryStudentTable {
	static JScrollPane p;
	public static void addJTable() {   //添加表头
		StudentBaseSystem.data.addColumn("学生编号");
		StudentBaseSystem.data.addColumn("年级");
		StudentBaseSystem.data.addColumn("班级名称");
		StudentBaseSystem.data.addColumn("学生姓名");
		StudentBaseSystem.data.addColumn("性别");
		StudentBaseSystem.data.addColumn("年龄");
		StudentBaseSystem.data.addColumn("家庭地址");
		StudentBaseSystem.data.addColumn("联系电话");
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"学生编号","年级","班级名称","学生姓名","性别","年龄","家庭地址","联系电话"});
	}
	//创建数组用来存放从数据库取出的数据
	public static Object[] datarow(String sid,String grade,String sclass,String sname,String gender,String age,String address,String phone){
		Object row[]=new Object[8];
		row[0]=sid;
		row[1]=grade;
		row[2]=sclass;
		row[3]=sname;
		row[4]=gender;
		row[5]=age;
		row[6]=address;
		row[7]=phone;
		return row;
	}
	public static void tableMove() {//清除表格
		StudentBaseSystem.data=(DefaultTableModel) StudentBaseSystem.table.getModel();
		StudentBaseSystem.data.setRowCount(0);// 清除原有行
		StudentBaseSystem.data.setColumnCount(0);//消除原有列
	}
}
