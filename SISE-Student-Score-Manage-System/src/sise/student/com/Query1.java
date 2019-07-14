package sise.student.com;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Query1 extends JFrame {

	String str1,str2,sql;
	private JComboBox<String> seculateChoice;
	private JComboBox<String> selectKindChoice;
	private JComboBox<String> charatarChoice;
	static JTable table;
	static DefaultTableModel data;
	static int i=0;
	static JPanel jPa;
	static JTextField jt;
	Query1(){
		Container con =getContentPane();
		//设置边界布局管理器
	    setLayout(new BorderLayout());
	    
	    //面板p1   查询类型、字段、运算符、数值等等
	    JPanel panel1=new JPanel();
		JLabel QueryType=new JLabel("查询类型");
		
		String []selectKind = {"    ","学生信息","教师信息","考试成绩"};
		selectKindChoice=new JComboBox<String>(selectKind);
		panel1.add(QueryType);
		panel1.add(selectKindChoice);		
		
		JLabel Field1=new JLabel("字段");
		String []charatar = {"    ","学生编号","教师编号"};
		charatarChoice=new JComboBox<String>(charatar);
		panel1.add(Field1);
		panel1.add(charatarChoice);	
		
		JLabel Operate1=new JLabel("运算符");
		String []seculate = {"like"};
		seculateChoice=new JComboBox<String>(seculate);
		panel1.add(Operate1);
		panel1.add(seculateChoice);	
		
		JLabel Num=new JLabel("数值");
		JTextField textNum=new JTextField(10);
		panel1.add(Num);
		panel1.add(textNum);	
		//按钮
		JButton bt1=new JButton("确定");
		JButton bt2=new JButton("退出");        
		panel1.add(bt1);
		panel1.add(bt2);
		
		
		
		//======================================================================
		//p2数据库列表
		

		data=new DefaultTableModel();//添加JTable
		table=new JTable(data);
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);
        table.setRowHeight(30);
        JScrollPane scrollPane1 = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(900, 700));
        
        con.add(scrollPane1,"Center");

		
		selectKindChoice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String gradeString=(String) e.getItem();
				if(gradeString.equals("学生信息")) {
					QueryBaseInfo.tableMove(); 
					QueryBaseInfo.addStudentJTable(); 
					sql="select * from tb_studentinfo";
					i=GetTotol.totol(sql);
					GetTotol.setSum(i);
					DBHelper.select(sql);
					try {
						while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
							Query1.data.addRow(QueryBaseInfo.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
									DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
						}
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				
				}
				else if(gradeString.equals("教师信息")) {
					QueryBaseInfo.tableMove();
					QueryBaseInfo.addJTable();//清楚table
					sql="select * from tb_teacher";
					i=GetTotol.totol(sql);
					GetTotol.setSum(i);
					DBHelper.select(sql);
					try {
						while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
							Query1.data.addRow(QueryBaseInfo.datarow(DBHelper.rs.getString("tid"),DBHelper.rs.getString("tgrade"),DBHelper.rs.getString("tclass"),DBHelper.rs.getString("tname"),DBHelper.rs.getString("gender"),
									DBHelper.rs.getString("course"),DBHelper.rs.getString("phone")));
						}
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
					}
				else if(gradeString.equals("考试成绩")) {
					QueryBaseInfo.tableMove();
					QueryBaseInfo.addScoreJTable();
					sql="select * from tb_gradeinfo_sub";
					i=GetTotol.totol(sql);
					GetTotol.setSum(i);
					DBHelper.select(sql);
					try {
						while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
							Query1.data.addRow(QueryBaseInfo.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("math"),DBHelper.rs.getString("chinese"),
									DBHelper.rs.getString("english"),DBHelper.rs.getString("politics"),DBHelper.rs.getString("chemistry"),DBHelper.rs.getString("physics")));
						}
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
					}
//			
		}
	});
	
		
		//确定按钮的事件处理======================================
		bt1.addActionListener(new ActionListener() {//按编号查询所有用户监听事件
			public void actionPerformed(ActionEvent e) {
				String s =e.getActionCommand();
				System.out.println("ok");
				QueryBaseInfo.tableMove();
				if(s.equals("确定")) {
					String aS=(String)charatarChoice.getSelectedItem();
					System.out.println(aS);
					String sum= textNum.getText();
					if(aS.equals("教师编号")) {
						QueryBaseInfo.tableMove();
						QueryBaseInfo.addJTable();//清楚table
						sql="select * from tb_teacher where tid ="+"'"+sum+"'";
						i=GetTotol.totol(sql);
						GetTotol.setSum(i);
						DBHelper.select(sql);
						try {
							while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
								Query1.data.addRow(QueryBaseInfo.datarow(DBHelper.rs.getString("tid"),DBHelper.rs.getString("tgrade"),DBHelper.rs.getString("tclass"),DBHelper.rs.getString("tname"),DBHelper.rs.getString("gender"),
										DBHelper.rs.getString("course"),DBHelper.rs.getString("phone")));
							}
						}
						catch(SQLException e1) {
							e1.printStackTrace();
						}
					}
					else if(aS.equals("学生编号")) {
						QueryBaseInfo.tableMove(); 
						QueryBaseInfo.addStudentJTable(); 
						sql="select * from tb_studentinfo where sid ="+"'"+sum+"'";
						i=GetTotol.totol(sql);
						GetTotol.setSum(i);
						DBHelper.select(sql);
						try {
							while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
								Query1.data.addRow(QueryBaseInfo.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
										DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
							}
						}
						catch(SQLException e1) {
							e1.printStackTrace();
						}
					
					}
				}
				
			}
		});

		//退出按钮的事件处理
		bt2.addActionListener(new ActionListener(){
	    	
			public void actionPerformed(ActionEvent e) {
				//退出时候询问（弹出对话框）
				int i = JOptionPane.showConfirmDialog(null,"确定要退出吗","提示",JOptionPane.YES_NO_OPTION);
				 if(i==0){//是==0，否执行else
				    dispose();
				 }
				 else;
			}
			});
		
		
				i =GetTotol.setSum(i);
				System.out.println(i);
		//p3     共有数据？条
				jPa=new JPanel() ;
				jt=new JTextField();                     
				jt.setText("共有数据【"+i+"】条");
				jt.setEditable(false);
				jPa.add(jt);
				jPa.setLayout(new FlowLayout(FlowLayout.LEFT));
				
				//面板布局
				add("North",panel1);
				add("South",jPa);
				setTitle("基本信息数据查询");
				pack();
				
				setSize(800, 600);
//				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setVisible(true);
				Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
				setLocation((screen.width-getWidth())/2,(screen.height-getHeight())/2);
	
			
	}
	
	
	public void actionPerformed(ActionEvent e) {}
	
	
//	public static void main(String[] args) {
//	    Query1 query=new Query1();	
////	    SelectSingleOne Single=new SelectSingleOne();
//	}

}
