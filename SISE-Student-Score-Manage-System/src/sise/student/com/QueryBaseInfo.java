package sise.student.com;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class QueryBaseInfo {
	static JScrollPane p;
	public static void addJTable() {   //添加表头
		Query1.data.addColumn("教师编号");
		Query1.data.addColumn("所教年级");
		Query1.data.addColumn("所教班级");
		Query1.data.addColumn("教师姓名");
		Query1.data.addColumn("性别");
		Query1.data.addColumn("所教课程");
		Query1.data.addColumn("联系电话");
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"教师编号","所教年级","所教班级","教师姓名","性别","所教课程","联系电话"});

	}
	//创建数组用来存放从数据库取出的数据
	public static Object[] datarow(String tid,String tgrade,String tclass,String tname,String gender,String course,String phone){
		Object row[]=new Object[7];//"id","grade1","sname","gender","age","address","phone"
		row[0]=tid;
		row[1]=tgrade;
		row[2]=tclass;
		row[3]=tname;
		row[4]=gender;
		row[5]=course;
		row[6]=phone;
		return row;
	}

	
	
//	static JScrollPane p;
	public static void addStudentJTable() {   //添加表头
		Query1.data.addColumn("学生编号");
		Query1.data.addColumn("年级");
		Query1.data.addColumn("班级名称");
		Query1.data.addColumn("学生姓名");
		Query1.data.addColumn("性别");
		Query1.data.addColumn("年龄");
		Query1.data.addColumn("家庭地址");
		Query1.data.addColumn("联系电话");
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

	
	public static void addScoreJTable() {   //添加表头
		Query1.data.addColumn("学生编号");
		Query1.data.addColumn("年级");
		Query1.data.addColumn("班级");
		Query1.data.addColumn("学生姓名");
		Query1.data.addColumn("数学成绩");
		Query1.data.addColumn("语文成绩");
		Query1.data.addColumn("英语成绩");
		Query1.data.addColumn("政治成绩");
		Query1.data.addColumn("化学成绩");
		Query1.data.addColumn("物理成绩");
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
		Query1.data=(DefaultTableModel) Query1.table.getModel();
		Query1.data.setRowCount(0);// 清除原有行
		Query1.data.setColumnCount(0);//消除原有列
	}
}


