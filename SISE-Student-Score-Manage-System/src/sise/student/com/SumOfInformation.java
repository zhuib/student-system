package sise.student.com;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class SumOfInformation extends JFrame implements ActionListener {
	static String selectInput;
	static String sname=null;
	static String tname=null;
	static String username=null;
	static String sql1,sql2,sql3;
    public static JTextField textName;
    static JTable table;
	static DefaultTableModel data;
	
	SumOfInformation(){
		setTitle("汇总信息");
		Container con =getContentPane();
		data=new DefaultTableModel();//添加JTable		
		table=new JTable(data);
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);//设置排序
		table.setRowHeight(30);
		table.setSize(500,300);
		table.setBounds(0, 0,900, 900);
		
		JScrollPane tableScroll=new JScrollPane(table);
		
	    //新建面板1,存放姓名的搜索
	    JPanel panel1=new JPanel();
		JLabel QueryName=new JLabel("姓名");
		panel1.add(QueryName);
	    textName=new JTextField(10);
		panel1.add(textName);	
		//按钮
		JButton bt1=new JButton("查询");
		JButton bt2=new JButton("退出");        
		panel1.add(bt1);
		panel1.add(bt2);
		
		//面板2 提示
		JPanel panel2=new JPanel();
		JTextField jt1=new JTextField("输入学生、老师、用户的姓名进行查询");
		jt1.setEditable(false);
		jt1.setFont(new Font("宋体", Font.PLAIN, 20) ); 
		panel2.add(jt1);
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//======================================================================
		//面板3  数据库列表
		Panel panel3=new Panel();
	  	table.getTableHeader();
	  	tableScroll.setViewportView(table);
		//面板布局
		con.add("North",panel1);
		con.add("South",panel2);
		con.add("Center",tableScroll);
		pack();
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setSize(800, 600);
		setVisible(true);
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screen.width-getWidth())/2,(screen.height-getHeight())/2);
				
		
		//确定按钮的事件处理======================================
				bt1.addActionListener(new ActionListener() {//按编号查询所有用户监听事件
					public void actionPerformed(ActionEvent arg0) {
						AddJTable1.tableMove();
						AddJTableTeacherQuery.tableMove();
						AddJTabelUserQuery.tableMove();
						
						SumOfInformation.Select();
					}
				});
		
		
		//退出按钮的事件处理
				bt2.addActionListener(new ActionListener(){
			    	
					public void actionPerformed(ActionEvent e) {
						//退出时候询问（弹出对话框）
						int i = JOptionPane.showConfirmDialog(null,"您确定要退出吗","提示",JOptionPane.YES_NO_OPTION);
						 if(i==0){//是==0，否执行else
						    dispose();
						 }
						 else;
					}

             });
	}
	
	//=========================================================
    public static void Select() {
    	//对教师、学生、用户信息进行查询
    	selectInput=textName.getText(); 
    	
    	sql1="select sname from tb_studentinfo where sname='"+selectInput+"'";
		DBHelper.select(sql1);
		try {
			while(DBHelper.rs.next()) {
				sname=DBHelper.rs.getString("sname");
		}} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		sql2="select tname from tb_teacher where tname='"+selectInput+"'";
		DBHelper.select(sql2);
		try {
			while(DBHelper.rs.next()) {
				tname=DBHelper.rs.getString("tname");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		sql3="select username from tb_user where username='"+selectInput+"'";
		DBHelper.select(sql3);
		try {
			while(DBHelper.rs.next()) {
				username=DBHelper.rs.getString("username");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//判断文本框是否为空
    	if(selectInput.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入名字");
		}
    	
    	else if(sname!=null){
    		AddJTable1.addJTable();
			sql1="select * from tb_studentinfo where sname='"+selectInput+"'";
			DBHelper.select(sql1);

			try {
				while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
					SumOfInformation.data.addRow(AddJTable1.datarow(DBHelper.rs.getInt("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getInt("age"),
							DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			sname=null;
		}
		
    	else if(tname!=null) {
    		AddJTableTeacherQuery.addJTable();
			sql2="select * from tb_teacher where tname='"+selectInput+"'";
			DBHelper.select(sql2);
			
			try {
				while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
					SumOfInformation.data.addRow(AddJTableTeacherQuery.datarow(DBHelper.rs.getInt("tid"),DBHelper.rs.getString("tname"),
							DBHelper.rs.getString("gender"),DBHelper.rs.getString("course"),DBHelper.rs.getString("phone")));
			}}
			catch(SQLException e) {
				e.printStackTrace();
			}
			tname=null;}
    	
    	else if(username!=null) {
    		AddJTabelUserQuery.addJTable();
			sql3="select * from tb_user where username='"+selectInput+"'";
			DBHelper.select(sql3);
			
			try {
				while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
					SumOfInformation.data.addRow(AddJTabelUserQuery.datarow(DBHelper.rs.getInt("uid"),DBHelper.rs.getString("username"),
							DBHelper.rs.getString("pwd"),DBHelper.rs.getString("phone")));
                }}
			catch(SQLException e) {
				e.printStackTrace();
			}
			username=null;}
			else if(sname == null && tname==null && username ==null) {
				JOptionPane.showMessageDialog(null, "您要查询的用户不存在！");
			}
    	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		

	}

//	public static void main(String[] args) {
//		SumOfInformation SOI=new SumOfInformation();
////		AddJTable1 AJT=new AddJTable1();
//		
//	}
	
}
