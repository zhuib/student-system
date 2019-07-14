package sise.student.com;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AddJTable1 {
	static JScrollPane p;
	public static void addJTable() {   //添加表头
		SumOfInformation.data.addColumn("编号");
		SumOfInformation.data.addColumn("班级名称");
		SumOfInformation.data.addColumn("学生姓名");
		SumOfInformation.data.addColumn("性别");
		SumOfInformation.data.addColumn("年龄");
		SumOfInformation.data.addColumn("地址");
		SumOfInformation.data.addColumn("手机号码");
	}
	//创建数组用来存放从数据库取出的数据
	public static Object[] datarow(int sid,String grade,String sname,String gender,int age,String address,String tel){
		Object row[]=new Object[7];
		row[0]=sid;
		row[1]=grade;
		row[2]=sname;
		row[3]=gender;
		row[4]=age;
		row[5]=address;
		row[6]=tel;
		return row;
	}
	public static void tableMove() {//清除表格
		SumOfInformation.data=(DefaultTableModel) SumOfInformation.table.getModel();
		SumOfInformation.data.setRowCount(0);// 清除原有行
		SumOfInformation.data.setColumnCount(0);//消除原有列
	}
}
