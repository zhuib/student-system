package sise.student.com;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class AddCourseTable {
	static JScrollPane p;
	public static void addCourseTable() {   //添加表头
		ExamCourseSet.data.addColumn("科目编号");
		ExamCourseSet.data.addColumn("科目名称");
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"科目编号","科目名称"});
	}
	//创建数组用来存放从数据库取出的数据
	public static Object[] datarow(String cid,String course){
		Object row[]=new Object[2];
		row[0]=cid;
		row[1]=course;
		
		return row;
	}
	public static void tableMove() {//清除表格
		ExamCourseSet.data=(DefaultTableModel) ExamCourseSet.table.getModel();
		ExamCourseSet.data.setRowCount(0);// 清除原有行
		ExamCourseSet.data.setColumnCount(0);//消除原有列
	}
	
	
	public static Object[] dataCourserow(String cid,String course){
		Object row[]=new Object[2];
		row[0]=cid;
		row[1]=course;
		
		return row;
	}
	public static void tableCourseMove() {//清除表格
		ExamCourseSet.data=(DefaultTableModel) ExamCourseSet.table.getModel();
		ExamCourseSet.data.setRowCount(0);// 清除原有行
		ExamCourseSet.data.setColumnCount(0);//消除原有列
	}
}

