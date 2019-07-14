package sise.student.com;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AddJTabelUserQuery {
	static JScrollPane p;
	public static void addJTable() {   //添加表头
		SumOfInformation.data.addColumn("编号");
		SumOfInformation.data.addColumn("用户姓名");
		SumOfInformation.data.addColumn("年龄");
		SumOfInformation.data.addColumn("手机号码");
	}
	//创建数组用来存放从数据库取出的数据
	public static Object[] datarow(int uid,String username,String pwd,String phone){
		Object row[]=new Object[7];
		row[0]=uid;
		row[1]=username;
		row[2]=pwd;
		row[3]=phone;
		return row;
	}
	public static void tableMove() {//清除表格
		SumOfInformation.data=(DefaultTableModel) SumOfInformation.table.getModel();
		SumOfInformation.data.setRowCount(0);// 清除原有行
		SumOfInformation.data.setColumnCount(0);//消除原有列
	}
}
