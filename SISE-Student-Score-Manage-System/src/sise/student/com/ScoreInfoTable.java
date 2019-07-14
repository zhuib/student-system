package sise.student.com;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ScoreInfoTable {
	static JScrollPane p;
	public static void addScoreJTable() {   //添加表头
		ScoreInfomation.data.addColumn("学生编号");
		ScoreInfomation.data.addColumn("年级");
		ScoreInfomation.data.addColumn("班级");
		ScoreInfomation.data.addColumn("学生姓名");
		ScoreInfomation.data.addColumn("数学成绩");
		ScoreInfomation.data.addColumn("语文成绩");
		ScoreInfomation.data.addColumn("英语成绩");
		ScoreInfomation.data.addColumn("政治成绩");
		ScoreInfomation.data.addColumn("化学成绩");
		ScoreInfomation.data.addColumn("物理成绩");
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"学生编号","年级","班级","学生姓名","数学成绩","语文成绩","英语成绩","政治成绩","化学成绩","物理成绩"});
	}
	//创建数组用来存放从数据库取出的数据
	public static Object[] datarow(String sid,String grade,String sclass,String sname,String math,String chinese,String english,String politics,String chemistry,String physics){
		Object row[]=new Object[10];
		row[0]=sid;
		row[1]=grade;
		row[2]=sclass;
		row[3]=sname;
		row[4]=math;
		row[5]=chinese;
		row[6]=english;
		row[7]=politics;
		row[8]=chemistry;
		row[9]=physics;
		return row;
	}
	
	public static void tableMove() {//清除表格
		ScoreInfomation.data=(DefaultTableModel) ScoreInfomation.table.getModel();
		ScoreInfomation.data.setRowCount(0);// 清除原有行
		ScoreInfomation.data.setColumnCount(0);//消除原有列
	}
	

}
