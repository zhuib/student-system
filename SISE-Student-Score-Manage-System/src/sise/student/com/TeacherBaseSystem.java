package sise.student.com;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherBaseSystem extends JFrame {

JPanel manegetar1,manegeblock1,manegeLeft1,manegeRight1;
JLabel grandeLabel1,classLabel1,sidJLabel1,sNameJLabel1,sexJLabel1,
		sAddressJLabel1,tgradeJLabel1,tclassJLabel1,sAgeLabel1,sPhoneLabel1,tcourseLabel1;
JComboBox gradeChoice1,classChoice1,sexChoice1;
JButton updateButton1,addButton1,deleteButton1,saveButton1,existButton1;
JTextField sidField1,sNameField1,sAddressField1,tcourseField1,tgradeField1,tclassField1,sAgeField1,sPhoneField1;
static DefaultTableModel data;
static JTable table;
private String tid,tName,tSex,tgrade,tclass,tcourse,ttel;
public TeacherBaseSystem(){
	super("教师基本信息管理");
	Container con =getContentPane();
	manegetar1 =new JPanel(new FlowLayout());
	grandeLabel1 = new JLabel("所教年级:");
	String []grade= {"  ","初一","初二","初三"};
	gradeChoice1 =new JComboBox<String>(grade);
	classLabel1 = new JLabel("所教班级:");
	String []classl = {"  ","一班","二班","三班"};
	classChoice1 =new JComboBox<String>(classl);
	updateButton1 =new JButton("刷新");
	addButton1 =new JButton("添加");
	deleteButton1 =new JButton("删除");
	saveButton1 =new JButton("存盘");
	existButton1 =new JButton("退出");
	manegeblock1 =new JPanel(new BorderLayout());
	manegeLeft1 =new JPanel(new GridLayout(4, 2));
	sidJLabel1 =new JLabel("教师编号");
	sidField1=new JTextField(16);
	sNameJLabel1 =new JLabel("教师姓名");
	sNameField1 =new JTextField(16);
	sexJLabel1 =new JLabel("性别");
	String []sex = {"男","女"};
	sexChoice1=new JComboBox<String>(sex);
	tgradeJLabel1 =new JLabel("所教年级");
	tgradeField1 =new JTextField(16);
	
	manegeRight1 =new JPanel(new GridLayout(4, 2));
	tclassJLabel1 =new JLabel("所教班级");
	tclassField1 =new JTextField(16);
	tcourseLabel1 =new JLabel("所教课程");
	tcourseField1 =new JTextField();
	sPhoneLabel1 =new JLabel("联系电话");
	sPhoneField1 =new JTextField(16);
	
	data=new DefaultTableModel();//添加JTable
	table=new JTable(data);
//	table.setEnabled(false);
	table.setFillsViewportHeight(true);
	table.setAutoCreateRowSorter(true);
	table.setRowHeight(30);
	JScrollPane p=new JScrollPane(table);
	p.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	p.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	con=getContentPane();
	con.add(p,"Center");

	//================================================================================
	manegetar1.add(grandeLabel1);
	manegetar1.add(gradeChoice1);
	manegetar1.add(classLabel1);
	manegetar1.add(classChoice1);
	manegetar1.add(updateButton1);
	manegetar1.add(addButton1);
	manegetar1.add(deleteButton1);
	manegetar1.add(saveButton1);
	manegetar1.add(existButton1);
	con.add(manegetar1,"North");
	
	//=================================================================================
	manegeLeft1.add(sidJLabel1);
	manegeLeft1.add(sidField1);
	manegeLeft1.add(sNameJLabel1);
	manegeLeft1.add(sNameField1);
	manegeLeft1.add(sexJLabel1);
	manegeLeft1.add(sexChoice1);
	manegeLeft1.add(tgradeJLabel1);
	manegeLeft1.add(tgradeField1);
	
	manegeRight1.add(tclassJLabel1);
	manegeRight1.add(tclassField1);
	manegeRight1.add(tcourseLabel1);
	manegeRight1.add(tcourseField1);
	manegeRight1.add(sPhoneLabel1);
	manegeRight1.add(sPhoneField1);
	
	//===============================================================================
	manegeblock1.add(manegeLeft1,"West");
	manegeblock1.add(manegeRight1,"East");
	
	con.add(manegeblock1,"South");
	
//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(800,600);
	setVisible(true);
	setFont(new Font("宋体",Font.PLAIN,28));
	Dimension screen =Toolkit.getDefaultToolkit().getScreenSize();
	setLocation((screen.width-getWidth())/2,(screen.height-getHeight())/2 );
	
	gradeChoice1.addItemListener(new ItemListener() {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			String gradeString=(String) e.getItem();
			
			if(gradeString.equals("初一")) {
				AddTeacherJTable.tableMove(); 
				AddTeacherJTable.addJTable(); //清楚table
				String sql="select * from tb_teacher where tgrade = "+"'"+gradeString+"'";
				DBHelper.select(sql);
				System.out.println(sql);
				try {
					while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
						TeacherBaseSystem.data.addRow(AddTeacherJTable.datarow(DBHelper.rs.getString("tid"),DBHelper.rs.getString("tgrade"),DBHelper.rs.getString("tclass"),DBHelper.rs.getString("tname"),DBHelper.rs.getString("gender"),
								DBHelper.rs.getString("course"),DBHelper.rs.getString("phone")));
					}
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
			else if (gradeString.equals("初二")) {
				AddTeacherJTable.tableMove(); 
				AddTeacherJTable.addJTable(); //清楚table
				String sql="select * from tb_teacher where tgrade = "+"'"+gradeString+"'";
				DBHelper.select(sql);
				System.out.println(sql);
				try {
					while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
						TeacherBaseSystem.data.addRow(AddTeacherJTable.datarow(DBHelper.rs.getString("tid"),DBHelper.rs.getString("tgrade"),DBHelper.rs.getString("tclass"),DBHelper.rs.getString("tname"),DBHelper.rs.getString("gender"),
								DBHelper.rs.getString("course"),DBHelper.rs.getString("phone")));
					}
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			
			else if (gradeString.equals("初三")) {
				AddTeacherJTable.tableMove(); 
				AddTeacherJTable.addJTable(); 
				String sql="select * from tb_teacher where tgrade = "+"'"+gradeString+"'";
				DBHelper.select(sql);
				System.out.println(sql);
				try {
					while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
						TeacherBaseSystem.data.addRow(AddTeacherJTable.datarow(DBHelper.rs.getString("tid"),DBHelper.rs.getString("tgrade"),DBHelper.rs.getString("tclass"),DBHelper.rs.getString("tname"),DBHelper.rs.getString("gender"),
								DBHelper.rs.getString("course"),DBHelper.rs.getString("phone")));
					}
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
			
		}
	});
		
	
	classChoice1.addItemListener(new ItemListener() {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			String gradeString=(String) e.getItem();
			String sa =(String)gradeChoice1.getSelectedItem();
			if(sa.equals("初一")) {
			if(gradeString.equals("一班")) {
				AddTeacherJTable.tableMove(); 
				AddTeacherJTable.addJTable(); //清楚table
				String sql="select * from tb_teacher where tclass = "+"'"+gradeString+"'"+"and tgrade ='初一'";
				DBHelper.select(sql);
				System.out.println(sql);
				try {
					while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
						TeacherBaseSystem.data.addRow(AddTeacherJTable.datarow(DBHelper.rs.getString("tid"),DBHelper.rs.getString("tgrade"),DBHelper.rs.getString("tclass"),DBHelper.rs.getString("tname"),DBHelper.rs.getString("gender"),
								DBHelper.rs.getString("course"),DBHelper.rs.getString("phone")));
					}
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
			else if (gradeString.equals("二班")) {
				AddTeacherJTable.tableMove(); 
				AddTeacherJTable.addJTable(); //清楚table
				String sql="select * from tb_teacher where tclass = "+"'"+gradeString+"'"+"and tgrade ='初一'";
				DBHelper.select(sql);
				System.out.println(sql);
				try {
					while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
						TeacherBaseSystem.data.addRow(AddTeacherJTable.datarow(DBHelper.rs.getString("tid"),DBHelper.rs.getString("tgrade"),DBHelper.rs.getString("tclass"),DBHelper.rs.getString("tname"),DBHelper.rs.getString("gender"),
								DBHelper.rs.getString("course"),DBHelper.rs.getString("phone")));
					}
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
			else if (gradeString.equals("三班")) {
				AddTeacherJTable.tableMove(); 
				AddTeacherJTable.addJTable(); //清楚table
				String sql="select * from tb_teacher where tclass = "+"'"+gradeString+"'"+"and tgrade ='初一'";
				DBHelper.select(sql);
				System.out.println(sql);
				try {
					while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
						TeacherBaseSystem.data.addRow(AddTeacherJTable.datarow(DBHelper.rs.getString("tid"),DBHelper.rs.getString("tgrade"),DBHelper.rs.getString("tclass"),DBHelper.rs.getString("tname"),DBHelper.rs.getString("gender"),
								DBHelper.rs.getString("course"),DBHelper.rs.getString("phone")));
					}
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		
		if(sa.equals("初二")) {
			if(gradeString.equals("一班")) {
				AddTeacherJTable.tableMove(); 
				AddTeacherJTable.addJTable(); //清楚table
				String sql="select * from tb_teacher where tclass = "+"'"+gradeString+"'"+"and tgrade ='初二'";
				DBHelper.select(sql);
				System.out.println(sql);
				try {
					while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
						TeacherBaseSystem.data.addRow(AddTeacherJTable.datarow(DBHelper.rs.getString("tid"),DBHelper.rs.getString("tgrade"),DBHelper.rs.getString("tclass"),DBHelper.rs.getString("tname"),DBHelper.rs.getString("gender"),
								DBHelper.rs.getString("course"),DBHelper.rs.getString("phone")));
					}
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
			else if (gradeString.equals("二班")) {
				AddTeacherJTable.tableMove(); 
				AddTeacherJTable.addJTable(); //清楚table
				String sql="select * from tb_teacher where tclass = "+"'"+gradeString+"'"+"and tgrade ='初二'";
				DBHelper.select(sql);
				System.out.println(sql);
				try {
					while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
						TeacherBaseSystem.data.addRow(AddTeacherJTable.datarow(DBHelper.rs.getString("tid"),DBHelper.rs.getString("tgrade"),DBHelper.rs.getString("tclass"),DBHelper.rs.getString("tname"),DBHelper.rs.getString("gender"),
								DBHelper.rs.getString("course"),DBHelper.rs.getString("phone")));
					}
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
			else if (gradeString.equals("三班")) {
				AddTeacherJTable.tableMove(); 
				AddTeacherJTable.addJTable(); //清楚table
				String sql="select * from tb_teacher where tclass = "+"'"+gradeString+"'"+"and tgrade ='初二'";
				DBHelper.select(sql);
				System.out.println(sql);
				try {
					while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
						TeacherBaseSystem.data.addRow(AddTeacherJTable.datarow(DBHelper.rs.getString("tid"),DBHelper.rs.getString("tgrade"),DBHelper.rs.getString("tclass"),DBHelper.rs.getString("tname"),DBHelper.rs.getString("gender"),
								DBHelper.rs.getString("course"),DBHelper.rs.getString("phone")));
					}
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		
	
	
	if(sa.equals("初三")) {
		if(gradeString.equals("一班")) {
			AddTeacherJTable.tableMove(); 
			AddTeacherJTable.addJTable(); //清楚table
			String sql="select * from tb_teacher where tclass = "+"'"+gradeString+"'"+"and tgrade ='初三'";
			DBHelper.select(sql);
			System.out.println(sql);
			try {
				while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
					TeacherBaseSystem.data.addRow(AddTeacherJTable.datarow(DBHelper.rs.getString("tid"),DBHelper.rs.getString("tgrade"),DBHelper.rs.getString("tclass"),DBHelper.rs.getString("tname"),DBHelper.rs.getString("gender"),
							DBHelper.rs.getString("course"),DBHelper.rs.getString("phone")));
				}
			}
			catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if (gradeString.equals("二班")) {
			AddTeacherJTable.tableMove(); 
			AddTeacherJTable.addJTable(); //清楚table
			String sql="select * from tb_teacher where tclass = "+"'"+gradeString+"'"+"and tgrade ='初三'";
			DBHelper.select(sql);
			System.out.println(sql);
			try {
				while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
					TeacherBaseSystem.data.addRow(AddTeacherJTable.datarow(DBHelper.rs.getString("tid"),DBHelper.rs.getString("tgrade"),DBHelper.rs.getString("tclass"),DBHelper.rs.getString("tname"),DBHelper.rs.getString("gender"),
							DBHelper.rs.getString("course"),DBHelper.rs.getString("phone")));
				}
			}
			catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if (gradeString.equals("三班")) {
			AddTeacherJTable.tableMove(); 
			AddTeacherJTable.addJTable(); //清楚table
			String sql="select * from tb_teacher where tclass = "+"'"+gradeString+"'"+"and tgrade ='初三'";
			DBHelper.select(sql);
			System.out.println(sql);
			try {
				while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
					TeacherBaseSystem.data.addRow(AddTeacherJTable.datarow(DBHelper.rs.getString("tid"),DBHelper.rs.getString("tgrade"),DBHelper.rs.getString("tclass"),DBHelper.rs.getString("tname"),DBHelper.rs.getString("gender"),
							DBHelper.rs.getString("course"),DBHelper.rs.getString("phone")));
				}
			}
			catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	}
	});
	
	updateButton1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			AddTeacherJTable.tableMove();            //清楚table
			UpdataTeacher.Alluser();
		}
	});
	
	addButton1.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			
			String getAdd =e.getActionCommand();
			if(getAdd.equals("添加")) {
				System.out.println("ok");
				tid=sidField1.getText();
				tName=sNameField1.getText();
				tSex=(String)sexChoice1.getSelectedItem();
				tgrade=tgradeField1.getText();
				tclass=tclassField1.getText();
				tcourse=tcourseField1.getText();
				ttel=sPhoneField1.getText();
				String sql1 ="select * from tb_teacher where tid = "+"'"+tid+"'";
				ResultSet rs = DBHelper.select(sql1);
//				System.out.println("获取值："+sid+sName+sSex+sAddr+sGrade+sAge+stel);
				if(tid.equals("")||tName.equals("")||tgrade.equals("")||tclass.equals("")||tcourse.equals("")|ttel.equals("")) {
					JOptionPane.showMessageDialog(null,"请您完善填写信息！");
				} else
			    try {
				if(rs.next()==true) {
				    JOptionPane.showMessageDialog(null,"该信息已存在！");}
				
					else if(rs.next()==false){
						String sql=	"insert into tb_teacher (tid,tgrade,tclass,tname,gender,course,phone)" +"values" 
								+"("+"'"+tid+"'"+","+"'"+tgrade+"'"+","+"'"+tclass+"'"+","+"'"+tName+"'"+","+"'"+tSex+"'"+","+"'"+tcourse+"'"+","+"'"+ttel+"'"+")";

						System.out.println(sql);
						int i =DBHelper.update(sql);
						if(i==0) {
							JOptionPane.showMessageDialog(null,"添加失败，请您检查编号格式是否为数字！");
						}
						else{JOptionPane.showMessageDialog(null,"添加成功！");}
						}
					} catch (HeadlessException | SQLException e1) {
						e1.printStackTrace();
					}
			}

		}
	});
	
	deleteButton1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String getdelete =e.getActionCommand();
			if(getdelete.equals("删除")) {
				
				int row=table.getSelectedRow();
				//判断是否选中
				if(row==-1) {
					JOptionPane.showMessageDialog(null,"请选择需要删除的数据！");
					System.out.println(row);
				}
				//重新选取
				else {int row1=table.getSelectedRow();
				String msg="Delect '"+data.getValueAt(row, 0)+"'?";
				if (JOptionPane.showConfirmDialog(null, msg,"提示",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE)
						==JOptionPane.YES_OPTION) {
					String sql="delete from tb_teacher where tid='"+data.getValueAt(row,0)+"';";
					System.out.println(data.getValueAt(row,0));
					System.out.println(sql);
					if (DBHelper.update(sql)==1) {
						JOptionPane.showMessageDialog(null,"删除成功","提示",JOptionPane.INFORMATION_MESSAGE);
						data.removeRow(row);
					}else {
						JOptionPane.showMessageDialog(null,"删除失败","提示",JOptionPane.ERROR_MESSAGE);
					}
				}
				

				}}
		}
	});
	
	saveButton1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String getSave =e.getActionCommand();
			if(getSave.equals("存盘")) {
				SaveFile.setTeacher();
//				JOptionPane.showMessageDialog(null,"保存成功！");
			}
		}
	});
	
	
	existButton1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String getexist =e.getActionCommand();
			if(getexist.equals("退出")) {
				dispose();
			}
		}
	});
	
}
//	public static void main(String[] args) {
//		TeacherBaseSystem tbs=new TeacherBaseSystem();
//
//	}

}
