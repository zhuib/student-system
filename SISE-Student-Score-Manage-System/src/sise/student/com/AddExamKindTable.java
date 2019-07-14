package sise.student.com;


import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class AddExamKindTable {
	static JScrollPane p;
	public static void addGradeTable() {   //添加表头
		ExamKindSet.data.addColumn("科目");
		ExamKindSet.data.addColumn("考试类型");
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"科目","考试类型"});
	}
	//创建数组用来存放从数据库取出的数据
	public static Object[] datarow(String exam,String check){
		Object row[]=new Object[2];
		row[0]=exam;
		row[1]=check;
		
		return row;
	}
	public static void tableMove() {//清除表格
		ExamKindSet.data=(DefaultTableModel) ExamKindSet.table.getModel();
		ExamKindSet.data.setRowCount(0);// 清除原有行
		ExamKindSet.data.setColumnCount(0);//消除原有列
	}
}

