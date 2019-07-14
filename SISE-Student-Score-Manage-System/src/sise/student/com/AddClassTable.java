package sise.student.com;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class AddClassTable {
	static JScrollPane p;
	public static void addClassTable() {   //添加表头
		ClassManageSet.data.addColumn("班级编号");
		ClassManageSet.data.addColumn("班级名称");
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"班级编号","班级名称"});
	}
	//创建数组用来存放从数据库取出的数据
	public static Object[] datarow(String cid,String sclass){
		Object row[]=new Object[2];
		row[0]=cid;
		row[1]=sclass;
		
		return row;
	}
	public static void tableMove() {//清除表格
		ClassManageSet.data=(DefaultTableModel) ClassManageSet.table.getModel();
		ClassManageSet.data.setRowCount(0);// 清除原有行
		ClassManageSet.data.setColumnCount(0);//消除原有列
	}
}

