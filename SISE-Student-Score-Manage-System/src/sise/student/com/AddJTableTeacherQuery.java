package sise.student.com;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AddJTableTeacherQuery {
	static JScrollPane p;
	public static void addJTable() {   //添加表头
		SumOfInformation.data.addColumn("编号");
		SumOfInformation.data.addColumn("老师姓名");
		SumOfInformation.data.addColumn("性别");
		SumOfInformation.data.addColumn("课程");
		SumOfInformation.data.addColumn("手机号码");
	}
	//创建数组用来存放从数据库取出的数据
	public static Object[] datarow(int tid,String tname,String gender,String course,String phone){
		Object row[]=new Object[7];
		row[0]=tid;
		row[1]=tname;
		row[2]=gender;
		row[3]=course;
		row[4]=phone;
		return row;
	}
	public static void tableMove() {//清除表格
		SumOfInformation.data=(DefaultTableModel) SumOfInformation.table.getModel();
		SumOfInformation.data.setRowCount(0);// 清除原有行
		SumOfInformation.data.setColumnCount(0);//消除原有列
	}
}
