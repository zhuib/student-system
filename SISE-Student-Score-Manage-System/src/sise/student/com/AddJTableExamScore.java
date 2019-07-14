package sise.student.com;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AddJTableExamScore {
	static JScrollPane p;
	public static void addJTable() {   //添加表头
		GradeSet.data.addColumn("学生编号");
		GradeSet.data.addColumn("学生姓名");
		GradeSet.data.addColumn("年级");
		GradeSet.data.addColumn("班级");
		GradeSet.data.addColumn("数学");
		GradeSet.data.addColumn("语文");
		GradeSet.data.addColumn("英语");
		GradeSet.data.addColumn("化学");
		GradeSet.data.addColumn("政治");
		GradeSet.data.addColumn("物理");
		
		
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"学生编号","学生姓名","年级","班级","数学","语文","英语","化学","政治","物理"});
	}
	//创建数组用来存放从数据库取出的数据
	public static Object[] datarow(String sid,String sname,String grade,String sclass,String math,String chinese,String english,String chemistry,String politics,String physics){
		Object row[]=new Object[10];
		row[0]=sid;
		row[1]=sname;
		row[2]=grade;
		row[3]=sclass;
		row[4]=math;
		row[5]=chinese;
		row[6]=english;
		row[7]=chemistry;
		row[8]=politics;
		row[9]=physics;
		return row;
	}
	public static void tableMove() {//清除表格
		GradeSet.data=(DefaultTableModel) GradeSet.table.getModel();
		GradeSet.data.setRowCount(0);// 清除原有行
		GradeSet.data.setColumnCount(0);//消除原有列
	}
}
