package sise.student.com;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class AddGradeTable {
	static JScrollPane p;
	public static void addGradeTable() {   //添加表头
		GradeManageSet.data.addColumn("年级编号");
		GradeManageSet.data.addColumn("年级名称");
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"年级编号","年级名称"});
	}
	//创建数组用来存放从数据库取出的数据
	public static Object[] datarow(String gid,String grade){
		Object row[]=new Object[2];
		row[0]=gid;
		row[1]=grade;
		
		return row;
	}
	public static void tableMove() {//清除表格
		GradeManageSet.data=(DefaultTableModel) GradeManageSet.table.getModel();
		GradeManageSet.data.setRowCount(0);// 清除原有行
		GradeManageSet.data.setColumnCount(0);//消除原有列
	}
	
	
	public static Object[] dataClassrow(String gid,String grade){
		Object row[]=new Object[2];
		row[0]=gid;
		row[1]=grade;
		
		return row;
	}
	public static void tableClassMove() {//清除表格
		GradeManageSet.data=(DefaultTableModel) GradeManageSet.table.getModel();
		GradeManageSet.data.setRowCount(0);// 清除原有行
		GradeManageSet.data.setColumnCount(0);//消除原有列
	}
}

